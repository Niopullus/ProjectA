package server;

import java.util.HashMap;
import java.util.Map;

public class ServerMap {

    private Map<Integer, ServerIOManager> servers;

    public ServerMap() {
        super();
        servers = new HashMap<>();
    }

    public ServerIOManager getServer(final int serverID) {
        return servers.get(serverID);
    }

    public void put(final int serverID, final ServerIOManager serverIOManager) {
        servers.put(serverID, serverIOManager);
    }

    public void remove(final int serverID) {
        servers.remove(serverID);
    }

}
