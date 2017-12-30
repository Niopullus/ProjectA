package client;

import client.request.LogObserverRequest;
import lib.niodatatransmission.data.DataPacket;
import lib.niodatatransmission.tether.TransmissionTether;
import server.ProgramRequestProcessor;

public class ClientDataInputProcessor {

    private ClientContext context;
    private TransmissionTether tether;
    private int connectionID;

    public ClientDataInputProcessor(final ClientContext context) {
        this.context = context;
        this.tether = tether;
    }

    public void setConnectionID(final int connectionID) {
        this.connectionID = connectionID;
    }

    void processInput(final DataPacket dataPacket) {
        final int id;
        id = dataPacket.getID();
        switch (id) {
            case 1:
                observeLogRequest(dataPacket);
                break;
            case 2:
                serverListRequest();
                break;
        }
    }

    private void observeLogRequest(final DataPacket dataPacket) {
        final LogObserverRequest logObserverRequest;
        final ProgramRequestProcessor programRequestProcessor;
        logObserverRequest = new LogObserverRequest(dataPacket);
        programRequestProcessor = context.getProgramRequestProcessor();
        programRequestProcessor.addLogObserver(connectionID, logObserverRequest);
    }

    private void serverListRequest() {
        final ProgramRequestProcessor programRequestProcessor;
        programRequestProcessor = context.getProgramRequestProcessor();
        programRequestProcessor.requestServerList(connectionID);
    }

}
