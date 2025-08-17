package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public final class ParcelFileDescriptorBitmapDecoder implements ResourceDecoder<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f16872a;

    public ParcelFileDescriptorBitmapDecoder(Downsampler downsampler) {
        this.f16872a = downsampler;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, Options options) throws IOException {
        return this.f16872a.d(parcelFileDescriptor, i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(ParcelFileDescriptor parcelFileDescriptor, Options options) {
        return this.f16872a.o(parcelFileDescriptor);
    }
}
