package client.request;

import lib.niodatatransmission.data.DataPacket;
import lib.niopullus.niodatatree.DataTree;

import java.util.List;

public class LogObserverRequest {

    private DataPacket dataPacket;
    private DataTree dataTree;
    private int serverID;

    public LogObserverRequest(final DataPacket dataPacket) {
        super();
        this.dataPacket = dataPacket;
        extractDataTree();
        extractServerID();
    }

    private void extractDataTree() {
        final List<DataTree> dataTrees;
        dataTrees = dataPacket.getDataTrees();
        dataTree = dataTrees.get(0);
    }

    private void extractServerID() {
        serverID = dataTree.getI(0);
    }

    public int getServerID() {
        return serverID;
    }

}
