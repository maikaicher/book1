public class DbUpdateExample {
    // we assume the DB has version:
    public static final int CURRENT_VERSION_ON_DEVICE = 1;

    public static DummyDbClass myDbObject = new DummyDbClass(CURRENT_VERSION_ON_DEVICE);
    public static void main(String[] args) {
        int currentVersion = 0;
        if (myDbObject != null) {
            currentVersion = myDbObject.getVersion();
        }

        updateDatabase(currentVersion);
    }
    public static void updateDatabase(int version) {
        switch(version) {
            case 0:
                createPlayerDB();
                addPlyrTimeToDB();
                addOlPlyrToDB();
                setDbVersion(3);
                break;
            case 1:
                addPlyrTimeToDB();
                addOlPlyrToDB();
                setDbVersion(3);
                break;
            case 2:
                addOlPlyrToDB();
                setDbVersion(3);
                break;
            default:
                errorHandler();
        }
    }

    public static void createPlayerDB() {
        System.out.println("Create new DB");
        myDbObject = new DummyDbClass(1);
    }

    public static void addOlPlyrToDB() {
        myDbObject.doDdlStatement("CREATE TABLE OlPlayer (ID INT, Name VARCHAR(64))");
    }

    public static void addPlyrTimeToDB() {
        myDbObject.doDdlStatement("ALTER TABLE USER ADD PlyrTime INT DEFAULT 0");
    }

    public static void errorHandler() {
        System.out.println("Technical Error!");
    }

    public static void setDbVersion(int version) {
        myDbObject.setVersion(version);
    }

}