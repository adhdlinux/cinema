package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;

public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap.CompressFormat f16958a;

    /* renamed from: b  reason: collision with root package name */
    private final int f16959b;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public Resource<byte[]> a(Resource<Bitmap> resource, Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resource.get().compress(this.f16958a, this.f16959b, byteArrayOutputStream);
        resource.recycle();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }

    public BitmapBytesTranscoder(Bitmap.CompressFormat compressFormat, int i2) {
        this.f16958a = compressFormat;
        this.f16959b = i2;
    }
}
