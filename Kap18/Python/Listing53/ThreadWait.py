import time
from threading import Thread

def doWait(waitTime):
    print("before wait")
    time.sleep(waitTime)
    print("after wait")

def startWaitCheck():
    waitTime = 10
    myThread = Thread(target=doWait, args=(waitTime, ))
    print("start")
    myThread.start()
    print("end")
    myThread.join()

startWaitCheck()
