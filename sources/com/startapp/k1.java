package com.startapp;

public class k1 implements Cloneable {
    public long StorageExternalAudio = -1;
    public long StorageExternalAvailable;
    public long StorageExternalImages = -1;
    public long StorageExternalSize;
    public long StorageExternalVideo = -1;
    public long StorageInternalAudio = -1;
    public long StorageInternalAvailable;
    public long StorageInternalImages = -1;
    public long StorageInternalSize;
    public long StorageInternalVideo = -1;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
