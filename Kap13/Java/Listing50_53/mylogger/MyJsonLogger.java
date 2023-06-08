package Kap13.Java.Listing50_53.mylogger;

public class MyJsonLogger implements MyLogger {

    @Override
    public void doLogg(String data) {
        System.out.println("{\"message\":\"" + data + "\"}");
    }
    
}
