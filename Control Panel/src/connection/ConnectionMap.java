package connection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ConnectionMap {

    private Map<Integer, ConnectionIOManager> connections;

    public ConnectionMap() {
        super();
        connections = new HashMap<>();
    }

    public ConnectionIOManager getConnection(final int connectionID) {
        return connections.get(connectionID);
    }

    public Collection<ConnectionIOManager> getConnections() {
        return connections.values();
    }

    public void put(final int connectionID, final ConnectionIOManager connection) {
        connections.put(connectionID, connection);
    }

    public void remove(final int connectionID) {
        connections.remove(connectionID);
    }

}
