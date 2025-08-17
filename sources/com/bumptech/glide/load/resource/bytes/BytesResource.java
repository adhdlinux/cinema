package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class BytesResource implements Resource<byte[]> {

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f16902b;

    public BytesResource(byte[] bArr) {
        this.f16902b = (byte[]) Preconditions.d(bArr);
    }

    public Class<byte[]> a() {
        return byte[].class;
    }

    /* renamed from: b */
    public byte[] get() {
        return this.f16902b;
    }

    public int getSize() {
        return this.f16902b.length;
    }

    public void recycle() {
    }
}
