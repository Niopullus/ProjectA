package server;

import main.ControlPanelContext;
import server.tether.ServerTether;

public class ProgramDataReceiver implements Runnable {

    private ServerTether tether;
    private ControlPanelContext context;
    private ProgramDataInputProcessor programDataInputProcessor;

    public ProgramDataReceiver(final ServerTether tether, final ControlPanelContext context) {
        this.tether = tether;
        this.context = context;
    }

    public void start() {
        final Thread thread;
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {

    }

    public void run() {

    }

    public void addLogObserver(final int connectionID) {
        programDataInputProcessor.addLogObserver(connectionID);
    }

}
