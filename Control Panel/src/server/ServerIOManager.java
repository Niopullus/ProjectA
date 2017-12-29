package server;

import lib.niodatatransmission.tether.TransmissionTether;
import main.ControlPanelContext;

public class ServerIOManager implements Runnable {

    private ServerTether tether;
    private ControlPanelContext context;
    private ServerInputManager serverInputManager;

    public ServerIOManager(final ServerTether tether, final ControlPanelContext context) {
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
        serverInputManager.addLogObserver(connectionID);
    }

}
