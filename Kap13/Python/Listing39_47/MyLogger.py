import abc

class MyLogger (metaclass=abc.ABCMeta):

    @abc.abstractmethod
    def __init__(self):
        return

    @abc.abstractmethod
    def doLog(self, data):
        return


class MyPlainLogger(MyLogger):
    def __init__(self):
        super().__init__()

    def doLog(self, data):
        print(data)
    

class MyJsonLogger(MyLogger):
    def __init__(self):
        super().__init__()

    def doLog(self, data):
        print("{\"message\":\"" + data + "\"}")