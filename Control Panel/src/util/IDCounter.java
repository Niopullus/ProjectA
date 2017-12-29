package util;

public class IDCounter {

    private int latestID;

    public IDCounter() {
        super();
        latestID = 1;
    }

    public int getID() {
        final int id;
        id = latestID;
        latestID += 1;
        return id;
    }

}
