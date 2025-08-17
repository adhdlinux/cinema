package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapImageDecoderResourceDecoder f16818a = new BitmapImageDecoderResourceDecoder();

    /* renamed from: c */
    public Resource<Bitmap> b(ByteBuffer byteBuffer, int i2, int i3, Options options) throws IOException {
        return this.f16818a.b(ImageDecoder.createSource(byteBuffer), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(ByteBuffer byteBuffer, Options options) throws IOException {
        return true;
    }
}
