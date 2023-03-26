
public class DummyDbClass {
    private int version;

    public DummyDbClass(int version) {
        setVersion(version);
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public void doDdlStatement(String myStatement) {
        System.out.println("Executed " + myStatement);
    }
}
