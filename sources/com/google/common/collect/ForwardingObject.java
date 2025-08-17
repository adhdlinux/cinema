package com.google.common.collect;

public abstract class ForwardingObject {
    protected ForwardingObject() {
    }

    /* access modifiers changed from: protected */
    public abstract Object a();

    public String toString() {
        return a().toString();
    }
}
