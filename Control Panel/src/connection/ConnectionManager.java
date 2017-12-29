package connection;

import lib.niodatatransmission.tether.TransmissionServer;
import lib.niodatatransmission.tether.TransmissionTether;
import main.ControlPanelContext;
import panelConfig.PanelConfig;
import util.IDCounter;

import java.util.Collection;

public class ConnectionManager implements Runnable {

    private ControlPanelContext context;
    private ConnectionMap connections;
    private TransmissionServer transmissionServer;
    private IDCounter idTracker;

    public ConnectionManager(final ControlPanelContext context) {
        this.context = context;
        connections = new ConnectionMap();
        idTracker = new IDCounter();
    }

    public void start() {
        final int port;
        port = getPort();
        transmissionServer = new TransmissionServer(port);
    }

    private int getPort() {
        final PanelConfig config;
        config = getConfig();
        return config.getServerPort();
    }

    private PanelConfig getConfig() {
        return context.getConfig();
    }

    public void close() {
        transmissionServer.stop();
    }

    private void closeConnections() {
        final Collection<ConnectionIOManager> connectionIOManagers;
        connectionIOManagers = connections.getConnections();
        for (final ConnectionIOManager connectionIOManager : connectionIOManagers) {
            connectionIOManager.close();
        }
    }

    public void run() {
        while (true) {
            final TransmissionTether tether;
            tether = transmissionServer.acceptTether();
            createNewConnection(tether);
        }
    }

    private void createNewConnection(final TransmissionTether tether) {
        final ConnectionIOManager connectionIOManager;
        final int connectionID;
        connectionIOManager = new ConnectionIOManager(context, tether);
        connectionIOManager.start();
        connectionID = idTracker.getID();
        connections.put(connectionID, connectionIOManager);
    }

}
