import time
import math
from multiprocessing  import Process

def calcRoots(id, noOfItr):
    print("start " + id)
    for i in range(0, noOfItr, 1):
        math.sqrt(i)

def startLoadTestMP():
    noOfThreads = 8
    myThreads = []
    noOfItr = 10000000
    print("start main")
    for i in range(0, noOfThreads, 1):
        myThreads.append(Process(target=calcRoots, args=("thrd." + str(i), noOfItr)))
    for myThread in myThreads:
        myThread.start()
    for myThreads in myThreads:
        myThreads.join()
    print("end main")

if __name__ == '__main__': 
    start = time.time()
    startLoadTestMP()
    print("duration: " + str(time.time() - start))

