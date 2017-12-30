package main;

import client.ClientConnector;
import panelConfig.PanelConfig;
import server.ProgramRequestProcessor;

public class ControlPanelContext {

    private ClientConnector clientConnector;
    private ProgramRequestProcessor programRequestProcessor;
    private PanelConfig config;

    public ControlPanelContext() {
        super();
    }

    public ClientConnector getClientConnector() {
        return clientConnector;
    }

    public PanelConfig getConfig() {
        return config;
    }

    public ProgramRequestProcessor getProgramRequestProcessor() {
        return programRequestProcessor;
    }

    public void setConfig(final PanelConfig config) {
        this.config = config;
    }

    public void setClientConnector(final ClientConnector clientConnector) {
        this.clientConnector = clientConnector;
    }

    public void setProgramRequestProcessor(final ProgramRequestProcessor programRequestProcessor) {
        this.programRequestProcessor = programRequestProcessor;
    }

}

