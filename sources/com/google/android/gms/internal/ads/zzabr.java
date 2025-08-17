package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTimeConstants;

public final class zzabr {
    public static int zza(ByteBuffer byteBuffer) {
        byte b2;
        int i2 = byteBuffer.get(26) + 27;
        byte b3 = byteBuffer.get(i2);
        if (byteBuffer.limit() > 1) {
            b2 = byteBuffer.get(i2 + 1);
        } else {
            b2 = 0;
        }
        return (int) ((zze(b3, b2) * 48000) / 1000000);
    }

    public static int zzb(ByteBuffer byteBuffer) {
        byte b2 = 0;
        byte b3 = byteBuffer.get(0);
        if (byteBuffer.limit() > 1) {
            b2 = byteBuffer.get(1);
        }
        return (int) ((zze(b3, b2) * 48000) / 1000000);
    }

    public static long zzc(byte[] bArr) {
        byte b2 = 0;
        byte b3 = bArr[0];
        if (bArr.length > 1) {
            b2 = bArr[1];
        }
        return zze(b3, b2);
    }

    public static List zzd(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzg(zzf((long) (((bArr[11] & 255) << 8) | (bArr[10] & 255)))));
        arrayList.add(zzg(zzf(3840)));
        return arrayList;
    }

    private static long zze(byte b2, byte b3) {
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

    private static long zzf(long j2) {
        return (j2 * 1000000000) / 48000;
    }

    private static byte[] zzg(long j2) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j2).array();
    }
}
