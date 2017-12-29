package connection;

import lib.niodatatransmission.data.DataPacket;
import lib.niodatatransmission.tether.TransmissionTether;
import main.ControlPanelContext;

public class ConnectionIOManager implements Runnable {

    private TransmissionTether tether;
    private ConnectionInputManager connectionInputManager;

    public ConnectionIOManager(final ControlPanelContext context, final TransmissionTether tether) {
        this.tether = tether;
        connectionInputManager = new ConnectionInputManager(context, tether);
    }

    public void start() {
        final Thread thread;
        thread = new Thread(this);
        thread.start();
    }

    public void close() {
        tether.close();
    }

    public void run() {
        while (!tether.isClosed()) {
            final DataPacket dataPacket;
            dataPacket = tether.receive();
            connectionInputManager.handleRequest(dataPacket);
        }
    }

}
