package client;

import lib.niodatatransmission.tether.TransmissionServer;
import lib.niodatatransmission.tether.TransmissionTether;
import main.ControlPanelContext;
import panelConfig.PanelConfig;
import util.IDCounter;

import java.util.Collection;

public class ClientConnector implements Runnable {

    private ControlPanelContext context;
    private ClientIDConnectionMap connections;
    private TransmissionServer transmissionServer;
    private IDCounter idTracker;

    public ClientConnector(final ControlPanelContext context) {
        this.context = context;
        connections = new ClientIDConnectionMap();
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
        closeConnections();
    }

    private void closeConnections() {
        final Collection<ClientDataReceiver> clientDataReceivers;
        clientDataReceivers = connections.getConnections();
        for (final ClientDataReceiver clientDataReceiver : clientDataReceivers) {
            clientDataReceiver.close();
        }
    }

    public void run() {
        while (true) {
            final TransmissionTether tether;
            final ClientContext clientContext;
            tether = transmissionServer.acceptTether();
            clientContext = createClientContext(tether);
            createNewConnection(clientContext);
        }
    }

    private ClientContext createClientContext(final TransmissionTether tether) {
        final ClientContext clientContext;
        final int clientID;
        clientContext = new ClientContext();
        clientID = idTracker.getID();
        clientContext.setClientID(clientID);
        clientContext.setTether(tether);
        return clientContext;
    }

    private void createNewConnection(final ClientContext clientContext) {
        final ClientDataReceiver clientDataReceiver;
        final int connectionID;
        clientDataReceiver = new ClientDataReceiver(clientContext);
        clientDataReceiver.start();
        connectionID = idTracker.getID();
        connections.put(connectionID, clientDataReceiver);
    }

}
