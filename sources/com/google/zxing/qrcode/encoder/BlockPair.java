package com.google.zxing.qrcode.encoder;

final class BlockPair {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f31264a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f31265b;

    BlockPair(byte[] bArr, byte[] bArr2) {
        this.f31264a = bArr;
        this.f31265b = bArr2;
    }

    public byte[] a() {
        return this.f31264a;
    }

    public byte[] b() {
        return this.f31265b;
    }
}
