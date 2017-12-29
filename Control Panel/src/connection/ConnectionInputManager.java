package connection;

import connection.request.LogObserverRequest;
import lib.niodatatransmission.data.DataPacket;
import lib.niodatatransmission.tether.TransmissionTether;
import main.ControlPanelContext;
import server.ServerManager;
import server.ServerRequestManager;

public class ConnectionInputManager {

    private ControlPanelContext context;
    private TransmissionTether tether;
    private int connectionID;

    public ConnectionInputManager(final ControlPanelContext context, final TransmissionTether tether) {
        this.context = context;
        this.tether = tether;
    }

    public void setConnectionID(final int connectionID) {
        this.connectionID = connectionID;
    }

    void handleRequest(final DataPacket dataPacket) {
        final int id;
        id = dataPacket.getID();
        switch (id) {
            case 1:
                observeLogRequest(dataPacket);
                break;
        }
    }

    private void observeLogRequest(final DataPacket dataPacket) {
        final LogObserverRequest logObserverRequest;
        final ServerRequestManager serverRequestManager;
        logObserverRequest = new LogObserverRequest(dataPacket);
        serverRequestManager = getServerRequestManager();
        serverRequestManager.addLogObserver(connectionID, logObserverRequest);
    }

    private ServerRequestManager getServerRequestManager() {
        final ServerManager serverManager;
        serverManager = context.getServerManager();
        return serverManager.getRequestManager();
    }

    private void serverListRequest(final DataPacket dataPacket) {
        final ServerRequestManager serverRequestManager;
        serverRequestManager = getServerRequestManager();
        serverRequestManager.requestServerList(connectionID);
    }

}
