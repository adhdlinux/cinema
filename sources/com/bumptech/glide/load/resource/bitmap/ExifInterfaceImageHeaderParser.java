package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public ImageHeaderParser.ImageType b(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public int c(InputStream inputStream, ArrayPool arrayPool) throws IOException {
        int c2 = new ExifInterface(inputStream).c("Orientation", 1);
        if (c2 == 0) {
            return -1;
        }
        return c2;
    }
}
