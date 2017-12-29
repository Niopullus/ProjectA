package server;

import connection.ConnectionIOManager;
import lib.niodatatransmission.data.DataPacket;
import main.ControlPanelContext;
import java.util.ArrayList;
import java.util.List;

public class ServerInputManager {

    private ControlPanelContext context;
    private List<Integer> logObservers;

    public ServerInputManager(final ControlPanelContext context) {
        this.context = context;
        logObservers = new ArrayList<>();
    }

    public void addLogObserver(final int connectionID) {
        logObservers.add(connectionID);
    }

    public void inputData(final DataPacket data) {
        final int id;
        id = data.getID();
        switch (id) {
            case 1:

        }
    }

    private void inputLogData(final DataPacket dataPacket) {

    }

}
