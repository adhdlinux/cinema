package com.startapp;

public class i1 implements Cloneable {
    public long DurationDNS = -1;
    public String HostFile = "";
    public String ServerIp = "";
    public int Try;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
