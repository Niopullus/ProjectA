package server;

import main.ControlPanelContext;
import util.IDCounter;

public class ProgramStatusTracker {

    private IDProgramConnectionMap programs;
    private IDCounter idTracker;
    private ControlPanelContext context;

    public ProgramStatusTracker(final ControlPanelContext context) {
        super();
        this.context = context;
        programs = new IDProgramConnectionMap();
        idTracker = new IDCounter();
    }

    public IDProgramConnectionMap getPrograms() {
        return programs;
    }

    private void addProgram(final ProgramDataReceiver programDataReceiver) {
        final int id;
        id = idTracker.getID();
        programs.put(id, programDataReceiver);
    }

    public void closeProgram(final int serverID) {

    }

}
