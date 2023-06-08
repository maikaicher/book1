package Kap13.Java.Listing50_53.mylogger;

public class MyPlainLogger  implements MyLogger {

    @Override
    public void doLogg(String data) {
        System.out.println(data);
    }
}

