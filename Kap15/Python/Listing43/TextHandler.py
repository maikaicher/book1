import sys
import codecs

sys.stdout = codecs.getwriter("UTF-8")(sys.stdout.detach())

def readFile(fName):
    fp = open(fName, encoding="UTF-8")
    print(fp.read())
    fp.close()

def writeFile(fName, content):
    fp = open(fName, "w", encoding="UTF-8")
    content.encode("utf-8")
    fp.write(content)
    fp.close()

readFile("C:\\temp\\Hello.txt")
writeFile("C:\\temp\\Hello11.txt", "Hallo, Welt!\nDie 1. Zeile hat zwölf Zeichen.")