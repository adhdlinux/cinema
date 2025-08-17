package com.startapp.sdk.adsbase;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1;
    private String errorMessage = null;
    public Map<String, String> parameters = new HashMap();
    private boolean validResponse = true;

    public String a() {
        return this.errorMessage;
    }

    public boolean b() {
        return this.validResponse;
    }

    public String toString() {
        return "BaseResponse [parameters=" + this.parameters + ", validResponse=" + this.validResponse + ", errorMessage=" + this.errorMessage + "]";
    }
}
