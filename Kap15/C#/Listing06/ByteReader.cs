class ByteReader {
    public static void printBytes(String fName, int noOfBytes) {
        byte[] myBuffer = new byte[noOfBytes];
        int readBytes = 0;
        using (FileStream myStream = File.Open(fName, FileMode.Open)) {
            readBytes = myStream.Read(myBuffer, 0, noOfBytes); 
            for (int i = 0; i < readBytes; i++) {
                Console.WriteLine(myBuffer[i].ToString("X"));
            }
        }
    }
}