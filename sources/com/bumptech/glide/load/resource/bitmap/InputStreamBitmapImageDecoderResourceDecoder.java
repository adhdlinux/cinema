package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;

public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapImageDecoderResourceDecoder f16869a = new BitmapImageDecoderResourceDecoder();

    /* renamed from: c */
    public Resource<Bitmap> b(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        return this.f16869a.b(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) throws IOException {
        return true;
    }
}
