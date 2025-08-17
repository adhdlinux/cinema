package com.startapp.networkTest.results;

import com.startapp.w0;

public class BaseResult implements Cloneable {
    public String GUID;
    public String ProjectId;
    public String Version = w0.f36759c;

    public BaseResult(String str, String str2) {
        this.ProjectId = str;
        this.GUID = str2;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
