package main;

import connection.ConnectionManager;
import panelConfig.PanelConfig;
import server.ServerManager;

import java.io.File;

public class ControlPanel {

    private ControlPanelContext context;
    private ConnectionManager connectionManager;
    private ServerManager serverManager;
    private PanelConfig panelConfig;

    private static final String CONFIG_PATH = "/config/config.properties";

    ControlPanel() {
        super();
        context = new ControlPanelContext();
        createConnectionManager();
        createServerManager();
        updateContext();
    }

    void start() {
        connectionManager.start();
        serverManager.start();
    }

    void stop() {

    }

    private void loadConfig() {
        final File file;
        file = new File(CONFIG_PATH);
        panelConfig = new PanelConfig(file);
    }

    private void createConnectionManager() {
        connectionManager = new ConnectionManager(context);
    }

    private void createServerManager() {
        serverManager = new ServerManager();
    }

    private void updateContext() {
        context.setConfig(panelConfig);
        context.setConnectionManager(connectionManager);
        context.setServerManager(serverManager);
    }

}
