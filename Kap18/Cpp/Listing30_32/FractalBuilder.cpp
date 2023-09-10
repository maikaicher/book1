#include <iostream>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
#include <thread>
#include <mutex>
#include <vector>

using byte = unsigned char;

long getTimestamp() {
    struct timespec timeSpec;
    clock_gettime(1, &timeSpec);
  return timeSpec.tv_sec * 1000 + timeSpec.tv_nsec / 1e6;
}

int setBytesLittleEnd(int offset, int value, byte* allBytes, int arrLength) {
    byte writeValue;

    while(value > 0) {
        writeValue = (byte)(value & 0xff);
        allBytes[offset++] = writeValue;
        value >>= 8;
        if (offset >= arrLength) {
            return 0;
        }
    }
    return 1;
}

byte* genBmpData(int height, int width, int* pixel, int noOfZero, int rowWidth) {
    byte* body = (byte*)malloc(height * rowWidth);
    int pixVal = 0;
        for (int r = 0; r < height; r++) {
            int pos = 0;
            for (int c = 0; c < width; c++) {
                pixVal = pixel[(r * width + c)];
                body[r * rowWidth + pos++] = (byte) (pixVal        & 0xff);
                body[r * rowWidth + pos++] = (byte)((pixVal >> 8 ) & 0xff);
                body[r * rowWidth + pos++] = (byte)((pixVal >> 16) & 0xff);
            }
            for (int c = 0; c < noOfZero; c++) {
                body[r * rowWidth + pos++] = 0x00;
            }
        }
        return body;
    }

    byte* prepareBmp(int* pixel, int height, int width, int fileSize, int noOfZero, int noOfImgBytes) {
        byte head[0x36] = {
            0x42, 0x4d, // ASCII für BM 
            0x00, 0x00, 0x00, 0x00, // Dateigröße
            0x00, 0x00, 0x00, 0x00, // immer 00
            0x36, 0x00, 0x00, 0x00, // Offset Bilddaten
            0x28, 0x00, 0x00, 0x00, // Größe Infoheader
            0x00, 0x00, 0x00, 0x00, // Breite
            0x00, 0x00, 0x00, 0x00, // Höhe
            0x01, 0x00, // immer 01 00 
            0x18, 0x00, // Farbtiefe
            0x00, 0x00, 0x00, 0x00, // keine Komprimierung
            0x00, 0x00, 0x00, 0x00, // Größe Bilddaten
            0x00, 0x00, 0x00, 0x00, // Aufl. Hor. Standard 00
            0x00, 0x00, 0x00, 0x00, // Aufl. Vert. Standard 00
            0x00, 0x00, 0x00, 0x00, // Farbtabelleninfo 00
            0x00, 0x00, 0x00, 0x00 // Farbtabelleninfo 00
        };
      
        if (!setBytesLittleEnd(2, fileSize, head, 0x36)) { return 0;}
        if (!setBytesLittleEnd(18, width, head, 0x36)) { return 0;}
        if (!setBytesLittleEnd(22, height, head, 0x36)) { return 0;}
        if (!setBytesLittleEnd(34, noOfImgBytes, head, 0x36)) { return 0;}

        byte* data = (byte*) malloc(fileSize);
        int pos = 0;
        for (int i = 0; i < 0x36; i++) {
            data[pos++] = head[i];
        }

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                setBytesLittleEnd(pos, pixel[(r * width + c)], data, fileSize);
                pos += 3;
            }
            for (int c = 0; c < noOfZero; c++) {
                data[pos++] = 0x00;
            }
        }
        return data;
    }

class ComplexNumber {
public:
  double re;
  double im;
  ComplexNumber(double re, double im) {
      this->re = re;
      this->im = im;
  }
  void addC(double re, double im) {
        this->re += re;
        this->im += im;
    }
  void square() {
    double r = re * re - im * im;
    double i = 2 * re * im;
        re = r;
        im = i;
  }
  double getDistSquare() {
        return re * re + im * im;
    }
  void reset(){
        re = 0; 
        im = 0;
    } 
};

class FractalBuilder {
    private: 
        int dimX = 0;
        int dimY = 0;
        int halfDimRe = 0;
        int halfDimIm = 0;
        int maxIteration = 0;
        double startRe = 0;
        double startIm = 0;
        double thresSquare = 0;
        double pixelDist = 0;
        int* pixel;
        int noOfThreads = 0;  
        std::mutex pixel_lock;        
        std::mutex noOfThreads_lock;        
    public:
        FractalBuilder(double, int, double, double, double, int, int) ;
        ~FractalBuilder() {
            free(this->pixel);
        }
        int getNoOfThreads() {
            return noOfThreads;
        }
        void calcPixel(int, int);
        void writeDataToFile(char*);
        void setPixel(int r, int c, int i) {
            pixel_lock.lock();
            pixel[r*dimX + c] = i;
            if (pixel[r*dimX + c] < 0) {
                std::cout << "error";
            }
            pixel_lock.unlock();
        }

        void changeNoOfThreads(bool increase) {
            noOfThreads_lock.lock();
            if (increase) {
                noOfThreads++;
            } else {
                noOfThreads--;
            }
            //std::cout << "\nthreadNo: " << noOfThreads;
            noOfThreads_lock.unlock();
        }
    };

FractalBuilder::FractalBuilder(double threshold, int maxIteration, double pixelDist, double startRe, double startIm, int dimX, int dimY) {
    this->thresSquare = threshold * threshold;
    this->maxIteration = maxIteration;
    this->dimX = dimX;
    this->dimY = dimY;
	this->startRe = startRe;
	this->startIm = startIm; 
	this->pixelDist = pixelDist;
	this->halfDimRe = dimX / 2;
	this->halfDimIm = dimY / 2;
	this->pixel = (int*) malloc(dimY * dimX * sizeof(int));
}
    
void FractalBuilder::writeDataToFile(char* fileName) {
    int noOfZero = (4 - ((3*dimX) % 4)) % 4;
    int rowWidth = 3 * dimX + noOfZero;
    int noOfImgBytes = dimY * rowWidth;
    int fileSize = 0x36 + noOfImgBytes;    

    byte* data = prepareBmp(this->pixel, dimY, dimX, fileSize, noOfZero, noOfImgBytes);

    FILE *fp;
    fp = fopen( fileName , "wb" );
    fwrite(data, sizeof(byte), fileSize, fp);
    fclose(fp);
    free(data);
}

void FractalBuilder::calcPixel(int fromY, int toY) {

    ComplexNumber *z = new ComplexNumber(0,0);
    int delta = 0xffffff / 2500;
	for (int r = fromY; r < toY; r++) {
	    for (int c = 0; c < dimX; c++) {
		    z->reset();
			double re =   startRe - (halfDimRe - c)  * pixelDist;
			double im = -1 * (startIm - (halfDimIm - r) * pixelDist);
            setPixel(r, c, 0);

			for (int i = 0; i < maxIteration; i++) {
			    z->square();
				z->addC(re, im);
				if (z->getDistSquare() > thresSquare) {
				    setPixel(r, c, i * delta);
					break;
				}
			}
		}
	}
    free(z);
}
void threadedMethod(FractalBuilder* myThread, int fromY, int toY) {
    myThread->changeNoOfThreads(true);
    myThread->calcPixel(fromY, toY);
    myThread->changeNoOfThreads(false);
}    

uint64_t timeSinceEpochMillisec() {
  using namespace std::chrono;
  return duration_cast<milliseconds>(system_clock::now().time_since_epoch()).count();
}

static void startMulti(int noOfCores) {

    int dimX = 2048;
    int dimY = 1024;
    double threshold = 10;
    int maxIteration = 50; 
    double pixelDist = 0.001; 
    double startRe = 0.36001014891; 
    double startIm = 0.350001;

    int noLinesPerThread = dimY / noOfCores;
    long start = getTimestamp();

    std::vector<std::thread> threads;
    for (int img = 0; img < 50; img++) {
        FractalBuilder* fb = new FractalBuilder(threshold, maxIteration, pixelDist, startRe, startIm, dimX, dimY);
        
        int rFrom = 0;
        int rTo = 0;
        for (int i = 1; i <= noOfCores; i++) {
    		rTo = (i == noOfCores) ? dimY : i * noLinesPerThread;
            threads.push_back(std::thread(threadedMethod, std::ref(fb), rFrom, rTo));
    		rFrom = rTo;
        }

        for (std::thread & th : threads){
            th.join();
        }
        threads.clear();
        char fName[100];
        sprintf(fName, "C:\\temp\\cppThreaded%d.bmp", img);
        std::cout << "\nwriting: " << fName << std::flush;

        fb->writeDataToFile(fName);
        pixelDist /= 2;
        maxIteration += 50;
        free(fb);

    }
    long timeValue = getTimestamp() - start;
    printf("Time: %d", timeValue);
}




int main() {
    startMulti(8);
    return 0;
}