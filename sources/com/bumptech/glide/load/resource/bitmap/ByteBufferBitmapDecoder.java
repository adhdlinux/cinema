package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f16817a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f16817a = downsampler;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(ByteBuffer byteBuffer, int i2, int i3, Options options) throws IOException {
        return this.f16817a.f(ByteBufferUtil.f(byteBuffer), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(ByteBuffer byteBuffer, Options options) {
        return this.f16817a.q(byteBuffer);
    }
}
