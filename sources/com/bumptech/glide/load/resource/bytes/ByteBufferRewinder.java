package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.data.DataRewinder;
import java.nio.ByteBuffer;

public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f16901a;

    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        /* renamed from: c */
        public DataRewinder<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new ByteBufferRewinder(byteBuffer);
        }
    }

    public ByteBufferRewinder(ByteBuffer byteBuffer) {
        this.f16901a = byteBuffer;
    }

    public void b() {
    }

    /* renamed from: c */
    public ByteBuffer a() {
        this.f16901a.position(0);
        return this.f16901a;
    }
}
