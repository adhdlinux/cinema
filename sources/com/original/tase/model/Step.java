package com.original.tase.model;

import java.util.List;

public class Step {
    List<String> keys;
    String method;
    String sequence;

    public List<String> getKeys() {
        return this.keys;
    }

    public String getMethod() {
        return this.method;
    }

    public String getSequence() {
        return this.sequence;
    }

    public void setKeys(List<String> list) {
        this.keys = list;
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setSequence(String str) {
        this.sequence = str;
    }
}
