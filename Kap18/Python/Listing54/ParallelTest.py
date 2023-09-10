import time
import math
from threading import Thread

def calcRoots(id, noOfItr):
    print("start " + id)
    for i in range(0, noOfItr, 1):
        math.sqrt(i)

def startLoadTestMT():
    noOfThreads = 1
    myThreads = []
    noOfItr = 10000000
    print("start main")
    for i in range(0, noOfThreads, 1):
        myThreads.append(Thread(target=calcRoots, args=("thrd." + str(i), noOfItr)))
    for myThread in myThreads:
        myThread.start()
    for myThreads in myThreads:
        myThreads.join()
    print("end main")

start = time.time()
startLoadTestMT()
print("duration: " + str(time.time() - start))
