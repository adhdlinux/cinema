package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public final class GifBitmapProvider implements GifDecoder.BitmapProvider {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f16914a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayPool f16915b;

    public GifBitmapProvider(BitmapPool bitmapPool, ArrayPool arrayPool) {
        this.f16914a = bitmapPool;
        this.f16915b = arrayPool;
    }

    public void a(Bitmap bitmap) {
        this.f16914a.c(bitmap);
    }

    public byte[] b(int i2) {
        ArrayPool arrayPool = this.f16915b;
        if (arrayPool == null) {
            return new byte[i2];
        }
        return (byte[]) arrayPool.c(i2, byte[].class);
    }

    public Bitmap c(int i2, int i3, Bitmap.Config config) {
        return this.f16914a.e(i2, i3, config);
    }

    public int[] d(int i2) {
        ArrayPool arrayPool = this.f16915b;
        if (arrayPool == null) {
            return new int[i2];
        }
        return (int[]) arrayPool.c(i2, int[].class);
    }

    public void e(byte[] bArr) {
        ArrayPool arrayPool = this.f16915b;
        if (arrayPool != null) {
            arrayPool.put(bArr);
        }
    }

    public void f(int[] iArr) {
        ArrayPool arrayPool = this.f16915b;
        if (arrayPool != null) {
            arrayPool.put(iArr);
        }
    }
}
