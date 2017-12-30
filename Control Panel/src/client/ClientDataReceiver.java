package client;

import lib.niodatatransmission.data.DataPacket;
import lib.niodatatransmission.tether.TransmissionTether;

public class ClientDataReceiver implements Runnable {

    private ClientContext context;
    private ClientDataInputProcessor connectionInputManager;

    public ClientDataReceiver(final ClientContext context) {
        this.context = context;
        connectionInputManager = new ClientDataInputProcessor(context);
    }

    public void start() {
        final Thread thread;
        thread = new Thread(this);
        thread.start();
    }

    public void close() {
        final TransmissionTether tether;
        tether = context.getTether();
        tether.close();
    }

    public void run() {
        final TransmissionTether tether;
        tether = context.getTether();
        while (!tether.isClosed()) {
            final DataPacket dataPacket;
            dataPacket = tether.receive();
            connectionInputManager.processInput(dataPacket);
        }
    }

}
