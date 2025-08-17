package com.xuhao.didi.core.pojo;

import java.io.Serializable;

public final class OriginalData implements Serializable {
    private byte[] mBodyBytes;
    private byte[] mHeadBytes;

    public byte[] getBodyBytes() {
        return this.mBodyBytes;
    }

    public byte[] getHeadBytes() {
        return this.mHeadBytes;
    }

    public void setBodyBytes(byte[] bArr) {
        this.mBodyBytes = bArr;
    }

    public void setHeadBytes(byte[] bArr) {
        this.mHeadBytes = bArr;
    }
}
