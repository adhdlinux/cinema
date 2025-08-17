package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

public final class zzet {
    public static void zza(MediaFormat mediaFormat, String str, int i2) {
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
    }

    public static void zzb(MediaFormat mediaFormat, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            mediaFormat.setByteBuffer("csd-" + i2, ByteBuffer.wrap((byte[]) list.get(i2)));
        }
    }
}
