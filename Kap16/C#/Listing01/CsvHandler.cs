class CsvHandler {
    static public void readCsv(String fileName) {
        List<String[]> fileContent = new List<string[]>();
        String[] allLines = File.ReadAllLines(fileName);
        if (allLines.Length == 0) {
            return;
        } 
        char[] separators = {';'};
        foreach(String line in allLines) {
            fileContent.Add(line.Split(separators));
        }
        String[] header = fileContent[0];
        for (int i = 1; i < fileContent.Count; i++) {
            for (int c = 0; c < (header.Length < fileContent[i].Length ? header.Length : fileContent[i].Length); c++) {
                Console.WriteLine(header[c] + ":" + fileContent[i][c]);
            }
        }
    }
}