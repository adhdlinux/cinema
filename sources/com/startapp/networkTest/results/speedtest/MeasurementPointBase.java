package com.startapp.networkTest.results.speedtest;

import com.startapp.networkTest.enums.ConnectionTypes;
import com.startapp.networkTest.enums.NetworkTypes;
import com.startapp.networkTest.enums.ThreeStateShort;

public class MeasurementPointBase implements Cloneable {
    public ConnectionTypes ConnectionType = ConnectionTypes.Unknown;
    public long Delta;
    public NetworkTypes NetworkType = NetworkTypes.Unknown;
    public ThreeStateShort NrAvailable = ThreeStateShort.Unknown;
    public String NrState = "Unknown";
    public int RxLev;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
