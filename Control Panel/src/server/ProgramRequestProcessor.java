package server;

import client.request.LogObserverRequest;

public class ProgramRequestProcessor {

    private IDProgramConnectionMap programs;

    public ProgramRequestProcessor(final IDProgramConnectionMap programs) {
        super();
        this.programs = programs;
    }

    public void addLogObserver(final int connectionID, final LogObserverRequest request) {
        final int serverID;
        serverID = request.getServerID();
        addLogObserver(connectionID, serverID);
    }

    private void addLogObserver(final int connectionID, final int programID) {
        final ProgramDataReceiver programDataReceiver;
        programDataReceiver = programs.getProgram(programID);
        programDataReceiver.addLogObserver(connectionID);
    }

    public void requestServerList(final int connectionID) {

    }

}
