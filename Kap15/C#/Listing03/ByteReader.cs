class ByteReader {
    public static void printBytes(String fName, int noOfBytes) {
        using (FileStream myStream = File.Open(fName, FileMode.Open)) {
            int myByte = 0;
            while(noOfBytes-- > 0 && (myByte = myStream.ReadByte()) != -1) {
            Console.WriteLine(myByte.ToString("X"));
            }
        }
    }
}