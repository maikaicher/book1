import time
import math
from threading import Thread
#from multiprocessing import Process

#class CalcRoots(Process):
class CalcRoots(Thread):
    duration = 0
    def __init__(self, id, noOfItr):
        Thread.__init__(self)
        #Process.__init__(self)
        self.id = id
        self.noOfItr = noOfItr

    def run(self):
        start = time.time()
        print("start " + self.id)
        for i in range(0, self.noOfItr , 1):
            math.sqrt(i)
        self.duration = time.time() - start
        print("duration of " + self.id + ": " + str(self.duration))   


def startLoadTestOO():
    noOfWorkObj = 8
    myWorkObj = []
    noOfIterations = 10000000
    print("start main")
    for i in range(0, noOfWorkObj, 1):
        myWorkObj.append(CalcRoots("thrd." + str(i), noOfIterations))
    for myWO in myWorkObj:
        myWO.start()
    for myWO in myWorkObj:
        myWO.join()
        print(myWO.duration)
    print("end main")

# only neccessary if used with Process - but will work with Thread as well
if __name__ == '__main__': 
    start = time.time()
    startLoadTestOO()
    print("duration: " + str(time.time() - start))
