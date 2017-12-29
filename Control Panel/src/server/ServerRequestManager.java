package server;

import connection.request.LogObserverRequest;

import java.util.Map;

public class ServerRequestManager {

    private Map<Integer, ServerIOManager> servers;

    public ServerRequestManager(final Map<Integer, ServerIOManager> servers) {
        super();
        this.servers = servers;
    }

    public void addLogObserver(final int connectionID, final LogObserverRequest request) {
        final int serverID;
        serverID = request.getServerID();
        addLogObserver(connectionID, serverID);
    }

    private void addLogObserver(final int connectionID, final int serverID) {
        final ServerIOManager serverIOManager;
        serverIOManager = servers.get(serverID);
        serverIOManager.addLogObserver(connectionID);
    }

    public void requestServerList(final int connectionID) {

    }

}
