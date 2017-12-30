package client;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClientIDConnectionMap {

    private Map<Integer, ClientDataReceiver> connections;

    public ClientIDConnectionMap() {
        super();
        connections = new HashMap<>();
    }

    public ClientDataReceiver getConnection(final int connectionID) {
        return connections.get(connectionID);
    }

    public Collection<ClientDataReceiver> getConnections() {
        return connections.values();
    }

    public void put(final int connectionID, final ClientDataReceiver connection) {
        connections.put(connectionID, connection);
    }

    public void remove(final int connectionID) {
        connections.remove(connectionID);
    }

}
