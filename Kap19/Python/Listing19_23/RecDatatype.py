class Elmt:
    nextElmt = None
    value = None

def createList(numbElmt, childElmt = None):
    if numbElmt == 0:
        return childElmt
    newElmt = Elmt()
    newElmt.nextElmt = childElmt
    return createList(numbElmt - 1, newElmt)

def setElementVal(val, pos, elmt):
    if pos == 0:
        elmt.value = val
    elif elmt.nextElmt != None:
        setElementVal(val, pos - 1, elmt.nextElmt)

def printAllValues(elmtIn):
    if elmtIn != None:
        print(elmtIn.value)
        printAllValues(elmtIn.nextElmt)


root = createList(3)
setElementVal(2, 0, root)
setElementVal(4, 1, root)
setElementVal(6, 2, root)

printAllValues(root)

