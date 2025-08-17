package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifdecoder.StandardGifDecoder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public class ByteBufferGifDecoder implements ResourceDecoder<ByteBuffer, GifDrawable> {

    /* renamed from: f  reason: collision with root package name */
    private static final GifDecoderFactory f16906f = new GifDecoderFactory();

    /* renamed from: g  reason: collision with root package name */
    private static final GifHeaderParserPool f16907g = new GifHeaderParserPool();

    /* renamed from: a  reason: collision with root package name */
    private final Context f16908a;

    /* renamed from: b  reason: collision with root package name */
    private final List<ImageHeaderParser> f16909b;

    /* renamed from: c  reason: collision with root package name */
    private final GifHeaderParserPool f16910c;

    /* renamed from: d  reason: collision with root package name */
    private final GifDecoderFactory f16911d;

    /* renamed from: e  reason: collision with root package name */
    private final GifBitmapProvider f16912e;

    static class GifDecoderFactory {
        GifDecoderFactory() {
        }

        /* access modifiers changed from: package-private */
        public GifDecoder a(GifDecoder.BitmapProvider bitmapProvider, GifHeader gifHeader, ByteBuffer byteBuffer, int i2) {
            return new StandardGifDecoder(bitmapProvider, gifHeader, byteBuffer, i2);
        }
    }

    static class GifHeaderParserPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<GifHeaderParser> f16913a = Util.e(0);

        GifHeaderParserPool() {
        }

        /* access modifiers changed from: package-private */
        public synchronized GifHeaderParser a(ByteBuffer byteBuffer) {
            GifHeaderParser poll;
            poll = this.f16913a.poll();
            if (poll == null) {
                poll = new GifHeaderParser();
            }
            return poll.p(byteBuffer);
        }

        /* access modifiers changed from: package-private */
        public synchronized void b(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.a();
            this.f16913a.offer(gifHeaderParser);
        }
    }

    public ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool) {
        this(context, list, bitmapPool, arrayPool, f16907g, f16906f);
    }

    private GifDrawableResource c(ByteBuffer byteBuffer, int i2, int i3, GifHeaderParser gifHeaderParser, Options options) {
        Bitmap.Config config;
        long b2 = LogTime.b();
        try {
            GifHeader c2 = gifHeaderParser.c();
            if (c2.b() > 0) {
                if (c2.c() == 0) {
                    if (options.c(GifOptions.f16953a) == DecodeFormat.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    GifDecoder a2 = this.f16911d.a(this.f16912e, c2, byteBuffer, e(c2, i2, i3));
                    a2.d(config);
                    a2.b();
                    Bitmap a3 = a2.a();
                    if (a3 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b2));
                        }
                        return null;
                    }
                    GifDrawableResource gifDrawableResource = new GifDrawableResource(new GifDrawable(this.f16908a, a2, UnitTransformation.c(), i2, i3, a3));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b2));
                    }
                    return gifDrawableResource;
                }
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + LogTime.a(b2));
            }
        }
    }

    private static int e(GifHeader gifHeader, int i2, int i3) {
        int i4;
        int min = Math.min(gifHeader.a() / i3, gifHeader.d() / i2);
        if (min == 0) {
            i4 = 0;
        } else {
            i4 = Integer.highestOneBit(min);
        }
        int max = Math.max(1, i4);
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + gifHeader.d() + "x" + gifHeader.a() + "]");
        }
        return max;
    }

    /* renamed from: d */
    public GifDrawableResource b(ByteBuffer byteBuffer, int i2, int i3, Options options) {
        GifHeaderParser a2 = this.f16910c.a(byteBuffer);
        try {
            return c(byteBuffer, i2, i3, a2, options);
        } finally {
            this.f16910c.b(a2);
        }
    }

    /* renamed from: f */
    public boolean a(ByteBuffer byteBuffer, Options options) throws IOException {
        if (((Boolean) options.c(GifOptions.f16954b)).booleanValue() || ImageHeaderParserUtils.f(this.f16909b, byteBuffer) != ImageHeaderParser.ImageType.GIF) {
            return false;
        }
        return true;
    }

    ByteBufferGifDecoder(Context context, List<ImageHeaderParser> list, BitmapPool bitmapPool, ArrayPool arrayPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderFactory gifDecoderFactory) {
        this.f16908a = context.getApplicationContext();
        this.f16909b = list;
        this.f16911d = gifDecoderFactory;
        this.f16912e = new GifBitmapProvider(bitmapPool, arrayPool);
        this.f16910c = gifHeaderParserPool;
    }
}
