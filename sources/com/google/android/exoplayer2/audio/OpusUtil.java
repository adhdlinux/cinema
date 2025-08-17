package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTimeConstants;

public class OpusUtil {
    private OpusUtil() {
    }

    public static List<byte[]> a(byte[] bArr) {
        long h2 = h((long) f(bArr));
        long h3 = h(3840);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(b(h2));
        arrayList.add(b(h3));
        return arrayList;
    }

    private static byte[] b(long j2) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j2).array();
    }

    public static int c(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static long d(byte b2, byte b3) {
        byte b4;
        byte b5 = b2 & 255;
        byte b6 = b5 & 3;
        if (b6 != 0) {
            b4 = 2;
            if (!(b6 == 1 || b6 == 2)) {
                b4 = b3 & 63;
            }
        } else {
            b4 = 1;
        }
        int i2 = b5 >> 3;
        int i3 = i2 & 3;
        return ((long) b4) * ((long) (i2 >= 16 ? 2500 << i3 : i2 >= 12 ? 10000 << (i3 & 1) : i3 == 3 ? DateTimeConstants.MILLIS_PER_MINUTE : 10000 << i3));
    }

    public static long e(byte[] bArr) {
        byte b2 = 0;
        byte b3 = bArr[0];
        if (bArr.length > 1) {
            b2 = bArr[1];
        }
        return d(b3, b2);
    }

    private static int f(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    public static int g(ByteBuffer byteBuffer) {
        byte b2 = 0;
        byte b3 = byteBuffer.get(0);
        if (byteBuffer.limit() > 1) {
            b2 = byteBuffer.get(1);
        }
        return (int) ((d(b3, b2) * 48000) / 1000000);
    }

    private static long h(long j2) {
        return (j2 * 1000000000) / 48000;
    }
}
