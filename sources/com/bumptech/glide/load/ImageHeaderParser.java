package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface ImageHeaderParser {

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        

        /* renamed from: b  reason: collision with root package name */
        private final boolean f16296b;

        private ImageType(boolean z2) {
            this.f16296b = z2;
        }

        public boolean hasAlpha() {
            return this.f16296b;
        }
    }

    ImageType a(ByteBuffer byteBuffer) throws IOException;

    ImageType b(InputStream inputStream) throws IOException;

    int c(InputStream inputStream, ArrayPool arrayPool) throws IOException;
}
