package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Http2;

public class StreamGifDecoder implements ResourceDecoder<InputStream, GifDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f16955a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceDecoder<ByteBuffer, GifDrawable> f16956b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f16957c;

    public StreamGifDecoder(List<ImageHeaderParser> list, ResourceDecoder<ByteBuffer, GifDrawable> resourceDecoder, ArrayPool arrayPool) {
        this.f16955a = list;
        this.f16956b = resourceDecoder;
        this.f16957c = arrayPool;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    /* renamed from: c */
    public Resource<GifDrawable> b(InputStream inputStream, int i2, int i3, Options options) throws IOException {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.f16956b.b(ByteBuffer.wrap(e2), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(InputStream inputStream, Options options) throws IOException {
        if (((Boolean) options.c(GifOptions.f16954b)).booleanValue() || ImageHeaderParserUtils.e(this.f16955a, inputStream, this.f16957c) != ImageHeaderParser.ImageType.GIF) {
            return false;
        }
        return true;
    }
}
