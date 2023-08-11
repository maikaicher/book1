try:
    fp=open("C:\\temp\\NewBitmapPhp.bmp","rb")
except OSError:
    print("failed open file")
else:
    myBuffer=fp.read(10)
    for myByte in myBuffer:
        print(hex(myByte))
    fp.close()
