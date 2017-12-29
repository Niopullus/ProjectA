package main;

import connection.ConnectionManager;
import panelConfig.PanelConfig;
import server.ServerManager;

public class ControlPanelContext {

    private ConnectionManager connectionManager;
    private ServerManager serverManager;
    private PanelConfig config;

    ControlPanelContext() {
        super();
    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    public PanelConfig getConfig() {
        return config;
    }

    public ServerManager getServerManager() {
        return serverManager;
    }

    public void setConfig(final PanelConfig config) {
        this.config = config;
    }

    public void setConnectionManager(final ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public void setServerManager(final ServerManager serverManager) {
        this.serverManager = serverManager;
    }

}

