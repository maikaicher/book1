def genBmpData(height, width, color):
    colB = color & 0xff
    colG = (color >> 8) & 0xff
    colR = (color >> 16) & 0xff
    noOfZero = (4 - ((3*width) % 4)) % 4
    body = [[] for r in range(height)]
    for r in range(height):
        for c in range(width):
            body[r].append(colB)
            body[r].append(colG)
            body[r].append(colR)
            
        for c in range(noOfZero):
            body[r].append(0x00)
    return body

def prepareBmp(body, height, width):
    head = [
        0x42, 0x4d,             # ASCII für BM 
        0x00, 0x00, 0x00, 0x00, # Dateigröße
        0x00, 0x00, 0x00, 0x00, # immer 00
        0x36, 0x00, 0x00, 0x00, # Offset Bilddaten
        0x28, 0x00, 0x00, 0x00, # Größe Infoheader
        0x00, 0x00, 0x00, 0x00, # Breite
        0x00, 0x00, 0x00, 0x00, # Höhe
        0x01, 0x00,             # immer 01 00 
        0x18, 0x00,             # Farbtiefe
        0x00, 0x00, 0x00, 0x00, # keine Komprimierung
        0x00, 0x00, 0x00, 0x00, # Größe Bilddaten
        0x00, 0x00, 0x00, 0x00, # Auflösung horizontal - Standard 00
        0x00, 0x00, 0x00, 0x00, # Auflösung vertikal - Standard 00
        0x00, 0x00, 0x00, 0x00, # Farbtabelleninfo – Standard 00
        0x00, 0x00, 0x00, 0x00  # Farbtabelleninfo – Standard 00
    ]
    if len(body) == 0:
        return None

    if len(body[0]) == 0:
        return None

    noOfImgBytes = len(body) * len(body[0])
    fileSize = len(head) + noOfImgBytes;
    if not setBytesLittleEnd(2, fileSize, head):
        return None
    if not setBytesLittleEnd(18, width, head):
        return None
    if not setBytesLittleEnd(22, height, head):
        return None
    if not setBytesLittleEnd(34, noOfImgBytes, head):
        return None
    
    data = []

    for hdElm in head:
        data.append(hdElm)

    for row in body:
        for field in row:
            data.append(field)
    return data;

def prepareBmpxx(body, height, width):
    head = [
        0x42, 0x4d,             # ASCII für BM 
        0x00, 0x00, 0x00, 0x00, # Dateigröße
        0x00, 0x00, 0x00, 0x00, # immer 00
        0x36, 0x00, 0x00, 0x00, # Offset Bilddaten
        0x28, 0x00, 0x00, 0x00, # Größe Infoheader
        0x00, 0x00, 0x00, 0x00, # Breite
        0x00, 0x00, 0x00, 0x00, # Höhe
        0x01, 0x00,             # immer 01 00 
        0x18, 0x00,             # Farbtiefe
        0x00, 0x00, 0x00, 0x00, # keine Komprimierung
        0x00, 0x00, 0x00, 0x00, # Größe Bilddaten
        0x00, 0x00, 0x00, 0x00, # Auflösung horizontal - Standard 00
        0x00, 0x00, 0x00, 0x00, # Auflösung vertikal - Standard 00
        0x00, 0x00, 0x00, 0x00, # Farbtabelleninfo – Standard 00
        0x00, 0x00, 0x00, 0x00  # Farbtabelleninfo – Standard 00
    ]
    if len(body) == 0:
        return None

    if len(body[0]) == 0:
        return None

    noOfImgBytes = len(body) * len(body[0])
    fileSize = len(head) + noOfImgBytes;
    if not setBytesLittleEnd(2, fileSize, head):
        return None
    if not setBytesLittleEnd(18, width, head):
        return None
    if not setBytesLittleEnd(22, height, head):
        return None
    if not setBytesLittleEnd(34, noOfImgBytes, head):
        return None
    
    data = [0 for x in range(fileSize)]
    pos = 0
    for hdElm in head:
        data[pos] = hdElm
        pos = pos + 1
    for row in body:
        for field in row:
            data[pos] = field 
            pos = pos + 1
    return data;
def setBytesLittleEnd (offset, value, allBytes): 
    writeValue = 0
    while value > 0:
        writeValue = value & 0xff
        allBytes[offset] = writeValue
        offset = offset + 1
        value >>= 8
        if offset >= len(allBytes):
            return False
    return True


height = 512
width = 1024
body = genBmpData(height, width, 0xe9967a)
data = prepareBmp(body, height, width)
myBytes = bytes(data);
myFile = open("C:\\temp\\MyBitmap.bmp", "wb")
myFile.write(myBytes)
myFile.close()
