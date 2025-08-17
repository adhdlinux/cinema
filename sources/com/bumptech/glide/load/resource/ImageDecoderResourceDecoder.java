package com.bumptech.glide.load.resource;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.HardwareConfigState;
import java.io.IOException;

public abstract class ImageDecoderResourceDecoder<T> implements ResourceDecoder<ImageDecoder.Source, T> {

    /* renamed from: a  reason: collision with root package name */
    final HardwareConfigState f16796a = HardwareConfigState.a();

    /* access modifiers changed from: protected */
    public abstract Resource<T> c(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    /* renamed from: d */
    public final Resource<T> b(ImageDecoder.Source source, int i2, int i3, Options options) throws IOException {
        final boolean z2;
        final DecodeFormat decodeFormat = (DecodeFormat) options.c(Downsampler.f16838f);
        final DownsampleStrategy downsampleStrategy = (DownsampleStrategy) options.c(DownsampleStrategy.f16833h);
        Option option = Downsampler.f16842j;
        if (options.c(option) == null || !((Boolean) options.c(option)).booleanValue()) {
            z2 = false;
        } else {
            z2 = true;
        }
        final PreferredColorSpace preferredColorSpace = (PreferredColorSpace) options.c(Downsampler.f16839g);
        final int i4 = i2;
        final int i5 = i3;
        return c(source, i2, i3, new ImageDecoder.OnHeaderDecodedListener() {
            @SuppressLint({"Override"})
            public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                ColorSpace.Named named;
                boolean z2 = false;
                if (ImageDecoderResourceDecoder.this.f16796a.c(i4, i5, z2, false)) {
                    imageDecoder.setAllocator(3);
                } else {
                    imageDecoder.setAllocator(1);
                }
                if (decodeFormat == DecodeFormat.PREFER_RGB_565) {
                    imageDecoder.setMemorySizePolicy(0);
                }
                imageDecoder.setOnPartialImageListener(new ImageDecoder.OnPartialImageListener() {
                    public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                        return false;
                    }
                });
                Size a2 = imageInfo.getSize();
                int i2 = i4;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = a2.getWidth();
                }
                int i3 = i5;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = a2.getHeight();
                }
                float b2 = downsampleStrategy.b(a2.getWidth(), a2.getHeight(), i2, i3);
                int round = Math.round(((float) a2.getWidth()) * b2);
                int round2 = Math.round(((float) a2.getHeight()) * b2);
                if (Log.isLoggable("ImageDecoder", 2)) {
                    Log.v("ImageDecoder", "Resizing from [" + a2.getWidth() + "x" + a2.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b2);
                }
                imageDecoder.setTargetSize(round, round2);
                int i4 = Build.VERSION.SDK_INT;
                if (i4 >= 28) {
                    if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                        z2 = true;
                    }
                    if (z2) {
                        named = ColorSpace.Named.DISPLAY_P3;
                    } else {
                        named = ColorSpace.Named.SRGB;
                    }
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                } else if (i4 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            }
        });
    }

    /* renamed from: e */
    public final boolean a(ImageDecoder.Source source, Options options) {
        return true;
    }
}
