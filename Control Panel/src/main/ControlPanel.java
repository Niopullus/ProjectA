package main;

import client.ClientConnector;
import panelConfig.PanelConfig;
import server.IDProgramConnectionMap;
import server.ProgramRequestProcessor;
import server.ProgramStatusTracker;

import java.io.File;

public class ControlPanel {

    private ControlPanelContext context;
    private ClientConnector clientConnector;
    private ProgramRequestProcessor programRequestProcessor;
    private ProgramStatusTracker programStatusTracker;
    private PanelConfig panelConfig;

    private static final String CONFIG_PATH = "/config/config.properties";

    ControlPanel() {
        super();
        context = new ControlPanelContext();
        createConnectionManager();
        createProgramStatusTracker();
        updateContext();
    }

    void start() {
        clientConnector.start();
    }

    void stop() {

    }

    private void loadConfig() {
        final File file;
        file = new File(CONFIG_PATH);
        panelConfig = new PanelConfig(file);
    }

    private void createConnectionManager() {
        clientConnector = new ClientConnector(context);
    }

    private void createProgramStatusTracker() {
        final IDProgramConnectionMap programs;
        programStatusTracker = new ProgramStatusTracker(context);
        programs = programStatusTracker.getPrograms();
        programRequestProcessor = new ProgramRequestProcessor(programs);
    }

    private void updateContext() {
        context.setConfig(panelConfig);
        context.setClientConnector(clientConnector);
        context.setProgramRequestProcessor(programRequestProcessor);
    }

}
