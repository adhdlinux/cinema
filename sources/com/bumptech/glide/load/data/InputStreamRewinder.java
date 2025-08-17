package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamRewinder implements DataRewinder<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f16337a;

    public static final class Factory implements DataRewinder.Factory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayPool f16338a;

        public Factory(ArrayPool arrayPool) {
            this.f16338a = arrayPool;
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }

        /* renamed from: c */
        public DataRewinder<InputStream> b(InputStream inputStream) {
            return new InputStreamRewinder(inputStream, this.f16338a);
        }
    }

    public InputStreamRewinder(InputStream inputStream, ArrayPool arrayPool) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, arrayPool);
        this.f16337a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    public void b() {
        this.f16337a.release();
    }

    public void c() {
        this.f16337a.f();
    }

    /* renamed from: d */
    public InputStream a() throws IOException {
        this.f16337a.reset();
        return this.f16337a;
    }
}
