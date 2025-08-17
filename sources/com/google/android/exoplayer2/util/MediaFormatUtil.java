package com.google.android.exoplayer2.util;

import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

public final class MediaFormatUtil {
    private MediaFormatUtil() {
    }

    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo != null) {
            d(mediaFormat, "color-transfer", colorInfo.f28846d);
            d(mediaFormat, "color-standard", colorInfo.f28844b);
            d(mediaFormat, "color-range", colorInfo.f28845c);
            a(mediaFormat, "hdr-static-info", colorInfo.f28847e);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f2) {
        if (f2 != -1.0f) {
            mediaFormat.setFloat(str, f2);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap(list.get(i2)));
        }
    }
}
