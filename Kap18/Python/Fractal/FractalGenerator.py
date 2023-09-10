import math
from multiprocessing import Process, Queue

def prepareBmp(pixel):
    head = [
        0x42, 0x4d,             # ASCII für BM 
        0x00, 0x00, 0x00, 0x00, # Dateigröße
        0x00, 0x00, 0x00, 0x00, # immer 00
        0x36, 0x00, 0x00, 0x00, # Offset Bilddaten
        0x28, 0x00, 0x00, 0x00, # Größe Infoheader
        0x00, 0x00, 0x00, 0x00, # Breite
        0x00, 0x00, 0x00, 0x00, # Höhe
        0x01, 0x00,             # immer 01 00 
        0x18, 0x00,             # Farbtiefe
        0x00, 0x00, 0x00, 0x00, # keine Komprimierung
        0x00, 0x00, 0x00, 0x00, # Größe Bilddaten
        0x00, 0x00, 0x00, 0x00, # Auflösung horizontal - Standard 00
        0x00, 0x00, 0x00, 0x00, # Auflösung vertikal - Standard 00
        0x00, 0x00, 0x00, 0x00, # Farbtabelleninfo – Standard 00
        0x00, 0x00, 0x00, 0x00  # Farbtabelleninfo – Standard 00
    ]
    if len(pixel) == 0:
        return None

    if len(pixel[0]) == 0:
        return None

    height = len(pixel)
    width = len(pixel[0])
    noOfZero = (4 - ((3*width) % 4)) % 4

    noOfImgBytes = height * (3*width + noOfZero)
    fileSize = len(head) + noOfImgBytes
    if not setBytesLittleEnd(2, fileSize, head):
        return None
    if not setBytesLittleEnd(18, width, head):
        return None
    if not setBytesLittleEnd(22, height, head):
        return None
    if not setBytesLittleEnd(34, noOfImgBytes, head):
        return None
    
    data = [0 for i in range(fileSize)]

    pos = 0
    for hdElm in head:
        data[pos] = hdElm
        pos += 1

    for r in range(0, height):
        for c in range(0, width):
            setBytesLittleEnd(pos, pixel[r][c], data)
            pos +=3
        for c in range(0, noOfZero):
            data[pos] = 0x00  
            pos += 1
    return data

def setBytesLittleEnd (offset, value, allBytes): 
    writeValue = 0
    while value > 0:
        writeValue = value & 0xff
        allBytes[offset] = writeValue
        offset = offset + 1
        value >>= 8
        if offset >= len(allBytes):
            return False
    return True

def startFractalThread(myQueue):
    noOfLinesPerThread = math.floor(dimY / cpuCount)
    rFrom = 0
    rTo = 0
    for i in range(1, cpuCount + 1):
        rTo = dimY if (i == cpuCount) else i * noOfLinesPerThread        
        worker.append(FractalWorker(FractalConfig(rFrom, rTo), myQueue))
        rFrom = rTo 
    for myWO in worker:
        myWO.start()

    # If the queue has a lot of data, it must be emptied before joining.
    # So, as long as the processes are alive, try to get the queue data and therefore emptying it
    while 1:
        running = any(p.is_alive() for p in worker)
        while not myQueue.empty():
            info = myQueue.get()
            pixel = info[0]
            rFrom = info[1].rFrom
            rTo = info[1].rTo
            for r in range(rFrom, rTo):
                for c in range(0, dimX):
                    pixelResult[r][c] = pixel[r][c]
        if not running:
            break

    for myWO in worker:
        myWO.join()

class FractalConfig():
    def __init__(self, rFrom, rTo):
        self.rFrom = rFrom
        self.rTo = rTo


class ComplexNumber():
    def __init__(self, re, im):
        self.re = re
        self.im = im
    
    def multiply(self, c):
        r = c.re * self.re - c.im * self.im
        i = self.im * c.re + self.re * c.im 
        return ComplexNumber(r, i)

    def getDist(self):
        return math.sqrt(self.re * self.re + self.im * self.im)

    def square(self):
        r = self.re * self.re - self.im * self.im 
        self.im = 2 * self.re * self.im
        self.re = r

    def getDistSquare(self):
        return self.re * self.re + self.im * self.im 
    
    def addC(self, re, im):
        self.re += re
        self.im += im 

    def reset(self):
        self.re = 0
        self.im = 0

class FractalWorker(Process):
    def __init__(self, myConfig, myQueue):
        Process.__init__(self)
        self.pixel = [[0 for x in range(dimX)] for y in range(dimY)]
        self.myConfig = myConfig
        self.myQueue = myQueue
        
    def run(self):
        z = ComplexNumber(0, 0)
        for r in range(self.myConfig.rFrom, self.myConfig.rTo):
            for c in range(0, dimX):
                z.reset()
                re = startRe - (halfDimRe - c) * pixelDist
                im = -1 * (startIm - (halfDimIm - r) * pixelDist)

                for i in range(0, maxIteration):
                    z.square()
                    z.addC(re, im)
                    if z.getDistSquare() > thresSquare:
                        self.pixel[r][c] = math.floor(i * delta)
                        break
        self.myQueue.put([self.pixel, self.myConfig])

cpuCount = 8
dimY = 1024
dimX = 2048
halfDimRe = dimX/2
halfDimIm = dimY/2
pixelDist = 0.001
maxIteration = 50
threshold = 10
thresSquare = threshold * threshold
startRe = 0.36001014891
startIm = 0.350001
delta = 0xffffff / 2500
worker = []
pixelResult = [[0 for x in range(dimX)] for y in range(dimY)]


def main():
    myQueue = Queue()
    startFractalThread(myQueue)

    data = prepareBmp(pixelResult)
    myBytes = bytes(data)
    myFile = open("C:\\temp\\Myfractal.bmp", "wb")
    myFile.write(myBytes)
    myFile.close()

# Because the code is handled multiple times in different python instances, it must be guaranteed, 
# that it will start only once 
if __name__=='__main__':
    main()