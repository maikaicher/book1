import time
import math
from multiprocessing import Process, Queue

class CalcRoots(Process):
    duration = 0
    def __init__(self, myQueue, id, noOfItr):
        Process.__init__(self)
        self.id = id
        self.noOfItr = noOfItr
        self.myQueue = myQueue

    def run(self):
        start = time.time()
        print("start " + self.id)
        for i in range(0, self.noOfItr , 1):
            math.sqrt(i)
        duration = time.time() - start        
        print("duration of " + self.id + ": " + str(duration))   
        self.myQueue.put([self.id, duration])

def startLoadTestOO():
    noOfWorkObj = 8
    myWorkObj = []
    noOfIterations = 10000000
    myQueue = Queue()
    print("start main")
    for i in range(0, noOfWorkObj, 1):
        myWorkObj.append(CalcRoots(myQueue, "thrd." + str(i), noOfIterations))
    for myWO in myWorkObj:
        myWO.start()

    while 1:
        running = any(p.is_alive() for p in myWorkObj)
        while not myQueue.empty():
            info = myQueue.get()
            print("duration: " + info[0] + " " + str(info[1]))
        if not running:
            break

    for myWO in myWorkObj:
        myWO.join()
    print("end main")

# only neccessary if used with Process - but will work with Thread as well
if __name__ == '__main__': 
    start = time.time()
    startLoadTestOO()
    print("duration: " + str(time.time() - start))
