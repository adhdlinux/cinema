package com.google.android.gms.internal.ads;

import com.facebook.imageutils.JfifUtil;

class zzage {
    public final int zzd;

    public zzage(int i2) {
        this.zzd = i2;
    }

    public static int zze(int i2) {
        return (i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
    }

    public static String zzf(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) ((i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE));
        sb.append((char) ((i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE));
        sb.append((char) ((i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE));
        sb.append((char) (i2 & JfifUtil.MARKER_FIRST_BYTE));
        return sb.toString();
    }

    public String toString() {
        return zzf(this.zzd);
    }
}
