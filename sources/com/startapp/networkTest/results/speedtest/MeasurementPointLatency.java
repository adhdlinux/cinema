package com.startapp.networkTest.results.speedtest;

public class MeasurementPointLatency extends MeasurementPointBase {
    public int Rtt = -1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
