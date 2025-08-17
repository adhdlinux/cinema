package com.startapp;

public class l1 implements Cloneable {
    public long MobileRxBytes;
    public long MobileTxBytes;
    public long TotalRxBytes;
    public long TotalTxBytes;
    public long WifiRxBytes;
    public long WifiTxBytes;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
