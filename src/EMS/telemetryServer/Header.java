package EMS.telemetryServer;

import EMS.telemetryServer.Information;

public class Header implements Information {
    private int dlc;

    public int getDlc() {
        return dlc;
    }

    public void setDlc(int dlc) {
        this.dlc = dlc;
    }
}
