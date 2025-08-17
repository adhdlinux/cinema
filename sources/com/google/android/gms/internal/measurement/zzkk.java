package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzkk {
    static final Charset zza = Charset.forName("US-ASCII");
    static final Charset zzb = Charset.forName("UTF-8");
    static final Charset zzc = Charset.forName("ISO-8859-1");
    public static final byte[] zzd;
    public static final ByteBuffer zze;
    public static final zzjf zzf;

    static {
        byte[] bArr = new byte[0];
        zzd = bArr;
        zze = ByteBuffer.wrap(bArr);
        int i2 = zzjf.zza;
        zzjd zzjd = new zzjd(bArr, 0, 0, false, (zzjc) null);
        try {
            zzjd.zza(0);
            zzf = zzjd;
        } catch (zzkm e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static int zza(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static int zzb(byte[] bArr) {
        int length = bArr.length;
        int zzd2 = zzd(length, bArr, 0, length);
        if (zzd2 == 0) {
            return 1;
        }
        return zzd2;
    }

    public static int zzc(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    static int zzd(int i2, byte[] bArr, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            i2 = (i2 * 31) + bArr[i5];
        }
        return i2;
    }

    static Object zze(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object zzf(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    static Object zzg(Object obj, Object obj2) {
        return ((zzlj) obj).zzbJ().zzay((zzlj) obj2).zzaG();
    }

    public static String zzh(byte[] bArr) {
        return new String(bArr, zzb);
    }

    public static boolean zzi(byte[] bArr) {
        return zzna.zze(bArr);
    }
}
