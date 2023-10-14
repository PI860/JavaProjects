package EMS.telemetryServer;

import EMS.telemetryServer.Information;

public class CANSignal implements Information {
    private String name;
    private String unit = "nan";

    private int startBit = 0;

    private int length = 1;

    private boolean isSigned = false;

    private double factor = 1;

    private double offset = 0;

    private boolean bigEndian = false;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStartBit() {
        return startBit;
    }

    public void setStartBit(int startBit) {
        this.startBit = startBit;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean getIsSigned() {
        return isSigned;
    }

    public void setIsSigned(boolean isSigned) {
        this.isSigned = isSigned;
    }

    public double getFactor() {
        return factor;
    }

    public void setFactor(double factor) {
        this.factor = factor;
    }

    public double getOffset() {
        return offset;
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public boolean getBigEndian() {
        return bigEndian;
    }

    public void setBigEndian(boolean bigEndian) {
        this.bigEndian = bigEndian;
    }
}
