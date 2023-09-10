import time

def doWait(waitTime):
    print("before wait")
    time.sleep(waitTime)
    print("after wait")

def startWaitCheck():
    waitTime = 10
    print("start")
    doWait(waitTime)
    print("end")

startWaitCheck()
