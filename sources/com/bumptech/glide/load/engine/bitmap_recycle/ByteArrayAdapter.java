package com.bumptech.glide.load.engine.bitmap_recycle;

public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
    public int a() {
        return 1;
    }

    /* renamed from: c */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: d */
    public byte[] newArray(int i2) {
        return new byte[i2];
    }

    public String getTag() {
        return "ByteArrayPool";
    }
}
