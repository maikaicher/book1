package Kap15.Java.Listing34_36;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextHandler {
    public static void main(String[] args) {
        try {
            readText1("C:\\temp\\Hello.txt");
            readText2("C:\\temp\\Hello.txt");
            writeText("C:\\temp\\Hello6.txt", new String[] {"Hallo, Welt!", "Die 1. Zeile hat zwölf Zeichen."});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readText1(String fName) throws IOException {
        try (
            FileInputStream  fis = new FileInputStream(fName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader brd = new BufferedReader(isr);
        ) {              
            String myLine = "";
            while ((myLine = brd.readLine()) != null) {
                System.out.println(myLine);
            }
        }
    }

    public static void readText2(String fName) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fName),
            StandardCharsets.UTF_8)) {
            String line = "";
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void writeText(String fName, String[] lines) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fName),
            StandardCharsets.UTF_8)) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }            
        }
    }

}
