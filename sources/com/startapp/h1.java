package com.startapp;

import com.startapp.networkTest.enums.MemoryStates;

public class h1 implements Cloneable {
    public long MemoryFree;
    public MemoryStates MemoryState = MemoryStates.Unknown;
    public long MemoryTotal;
    public long MemoryUsed;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
