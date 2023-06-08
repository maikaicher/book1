package Kap13.Java.Listing39_48.mylogger;

public class MyPlainLogger  implements MyLogger {

    @Override
    public void doLog(String data) {
        System.out.println(data);
    }
}

