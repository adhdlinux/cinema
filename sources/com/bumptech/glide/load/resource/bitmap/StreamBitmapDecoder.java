package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.ExceptionCatchingInputStream;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f16881a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f16882b;

    static class UntrustedCallbacks implements Downsampler.DecodeCallbacks {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclableBufferedInputStream f16883a;

        /* renamed from: b  reason: collision with root package name */
        private final ExceptionCatchingInputStream f16884b;

        UntrustedCallbacks(RecyclableBufferedInputStream recyclableBufferedInputStream, ExceptionCatchingInputStream exceptionCatchingInputStream) {
            this.f16883a = recyclableBufferedInputStream;
            this.f16884b = exceptionCatchingInputStream;
        }

        public void a(BitmapPool bitmapPool, Bitmap bitmap) throws IOException {
            IOException a2 = this.f16884b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    bitmapPool.c(bitmap);
                }
                throw a2;
            }
        }

        public void b() {
            this.f16883a.f();
        }
    }

    public StreamBitmapDecoder(Downsampler downsampler, ArrayPool arrayPool) {
        this.f16881a = downsampler;
        this.f16882b = arrayPool;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z2;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z2 = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f16882b);
            z2 = true;
        }
        ExceptionCatchingInputStream f2 = ExceptionCatchingInputStream.f(recyclableBufferedInputStream);
        try {
            return this.f16881a.g(new MarkEnforcingInputStream(f2), i2, i3, options, new UntrustedCallbacks(recyclableBufferedInputStream, f2));
        } finally {
            f2.release();
            if (z2) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) {
        return this.f16881a.p(inputStream);
    }
}
