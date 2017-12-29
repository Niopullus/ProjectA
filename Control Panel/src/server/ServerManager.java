package server;

import connection.request.LogObserverRequest;

import java.util.HashMap;
import java.util.Map;

public class ServerManager {

    private ServerMap servers;
    private ServerRequestManager requestManager;

    public ServerManager() {
        super();
        servers = new ServerMap();
    }

    public ServerRequestManager getRequestManager() {
        return requestManager;
    }

    public void start() {

    }

    public void createNewServer() {

    }

    public void closeServer() {

    }

}
