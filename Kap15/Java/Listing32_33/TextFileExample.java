import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TextFileExample {
    public static void main(String[] args) {
        String[] content =  {"Hallo, Welt!", "Die 1. Zeile hat zwölf Zeichen."};
        try {
          writeText("C:\\temp\\Hello5.txt", content);
          System.out.println("success");
        } catch(IOException ex) {
          System.out.println("error");
        }        
    }

    public static void writeText(String fName, String[] content) throws IOException {
        try (
            FileOutputStream  fos = new FileOutputStream(fName);
            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
            BufferedWriter bwr = new BufferedWriter(osw);
        ) {              
            for (String line : content) {
                bwr.append(line);
                bwr.newLine();
            }
            bwr.flush();
        }
    }

}
