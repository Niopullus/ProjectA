package client;

import lib.niodatatransmission.tether.TransmissionTether;
import main.ControlPanelContext;

public class ClientContext extends ControlPanelContext {

    private TransmissionTether tether;
    private int clientID;

    public ClientContext() {
        super();
    }

    public TransmissionTether getTether() {
        return tether;
    }

    public int getClientID() {
        return clientID;
    }

    public void setTether(final TransmissionTether tether) {
        this.tether = tether;
    }

    public void setClientID(final int clientID) {
        this.clientID = clientID;
    }
}
