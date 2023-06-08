package Kap13.Java.Listing39_48.mylogger;

public class MyJsonLogger implements MyLogger {

    @Override
    public void doLog(String data) {
        System.out.println("{\"message\":\"" + data + "\"}");
    }
    
}
