class MyException(Exception):
    def __init__(self, severity):
        super()
        self.severity = severity

def doSomething():
    raise MyException(1)

try :
    doSomething()
except MyException as mye:
    print("Severity:")
    print(mye.severity)
except Exception as e:
    print("Any other Error!")
finally:
    print("done!")
