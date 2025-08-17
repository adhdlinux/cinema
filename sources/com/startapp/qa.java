package com.startapp;

import java.io.ByteArrayOutputStream;

public class qa extends ByteArrayOutputStream {
    public qa(int i2) {
        super(i2);
    }

    public byte[] a() {
        return this.buf;
    }

    public int b() {
        return this.count;
    }
}
