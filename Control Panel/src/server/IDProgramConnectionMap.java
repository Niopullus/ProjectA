package server;

import java.util.HashMap;
import java.util.Map;

public class IDProgramConnectionMap {

    private Map<Integer, ProgramDataReceiver> servers;

    public IDProgramConnectionMap() {
        super();
        servers = new HashMap<>();
    }

    public ProgramDataReceiver getProgram(final int serverID) {
        return servers.get(serverID);
    }

    public void put(final int serverID, final ProgramDataReceiver serverIOManager) {
        servers.put(serverID, serverIOManager);
    }

    public void remove(final int serverID) {
        servers.remove(serverID);
    }

}
