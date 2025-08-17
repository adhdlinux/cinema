package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzcy {
    public static final zzn zza = zzcx.zza;
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public final int zzb = 1;
    public final String zzc;
    public final int zzd;
    private final zzam[] zzg;
    private int zzh;

    public zzcy(String str, zzam... zzamArr) {
        this.zzc = str;
        this.zzg = zzamArr;
        int zzb2 = zzcc.zzb(zzamArr[0].zzm);
        this.zzd = zzb2 == -1 ? zzcc.zzb(zzamArr[0].zzl) : zzb2;
        zzd(zzamArr[0].zzd);
        int i2 = zzamArr[0].zzf;
    }

    private static String zzd(String str) {
        if (str == null || str.equals("und")) {
            return "";
        }
        return str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcy.class == obj.getClass()) {
            zzcy zzcy = (zzcy) obj;
            if (!this.zzc.equals(zzcy.zzc) || !Arrays.equals(this.zzg, zzcy.zzg)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzh;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = ((this.zzc.hashCode() + 527) * 31) + Arrays.hashCode(this.zzg);
        this.zzh = hashCode;
        return hashCode;
    }

    public final int zza(zzam zzam) {
        for (int i2 = 0; i2 <= 0; i2++) {
            if (zzam == this.zzg[i2]) {
                return i2;
            }
        }
        return -1;
    }

    public final zzam zzb(int i2) {
        return this.zzg[i2];
    }

    public final zzcy zzc(String str) {
        return new zzcy(str, this.zzg);
    }
}
