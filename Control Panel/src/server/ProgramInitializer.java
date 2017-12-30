package server;

import main.ControlPanelContext;
import panelConfig.PanelConfig;
import server.tether.ServerTether;

import java.io.IOException;

public class ProgramInitializer {

    private ControlPanelContext context;
    private String executionStatement;
    private Runtime runtime;

    public ProgramInitializer(final ControlPanelContext context) {
        super();
        this.context = context;
        runtime = Runtime.getRuntime();
        executionStatement = getExecutionStatement();
    }

    public ServerTether createNewServer() {
        final Process process;
        try {
            process = runtime.exec(executionStatement);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private String getExecutionStatement() {
        final PanelConfig config;
        config = context.getConfig();
        return "java -jar " + config.getServerProgramPath();
    }

}
