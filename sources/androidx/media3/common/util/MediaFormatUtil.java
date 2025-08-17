package androidx.media3.common.util;

import android.media.MediaFormat;
import androidx.media3.common.ColorInfo;
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
            d(mediaFormat, "color-transfer", colorInfo.f3945c);
            d(mediaFormat, "color-standard", colorInfo.f3943a);
            d(mediaFormat, "color-range", colorInfo.f3944b);
            a(mediaFormat, "hdr-static-info", colorInfo.f3946d);
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
