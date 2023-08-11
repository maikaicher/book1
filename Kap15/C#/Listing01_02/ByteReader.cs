class ByteReader {
    public static void printBytes(String fName, int noOfBytes) {
        FileStream myStream = null;
        try {
            myStream = File.Open(fName, FileMode.Open);
            int myByte = 0;
            while(noOfBytes-- > 0 && (myByte = myStream.ReadByte()) != -1) {
            Console.WriteLine(myByte.ToString("X"));
            }
        } catch (Exception e) {
            Console.WriteLine(e.Message);
        } finally {
            if (myStream != null) {
            myStream.Dispose();
            }
        }
    }

}