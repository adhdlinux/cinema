package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.dataflow.qual.Pure;

public final class zzs {
    public static final zzs zza = new zzs(1, 2, 3, (byte[]) null);
    public static final zzs zzb;
    public static final zzn zzc = zzp.zza;
    private static final String zzh = Integer.toString(0, 36);
    private static final String zzi = Integer.toString(1, 36);
    private static final String zzj = Integer.toString(2, 36);
    private static final String zzk = Integer.toString(3, 36);
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final byte[] zzg;
    private int zzl;

    static {
        zzr zzr = new zzr();
        zzr.zzb(1);
        zzr.zza(1);
        zzr.zzc(2);
        zzb = zzr.zzd();
    }

    @Deprecated
    public zzs(int i2, int i3, int i4, byte[] bArr) {
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = bArr;
    }

    @Pure
    public static int zza(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzb(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String zzf(int i2) {
        return i2 != -1 ? i2 != 1 ? i2 != 2 ? "Undefined color range" : "Limited range" : "Full range" : "Unset color range";
    }

    private static String zzg(int i2) {
        return i2 != -1 ? i2 != 6 ? i2 != 1 ? i2 != 2 ? "Undefined color space" : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    private static String zzh(int i2) {
        return i2 != -1 ? i2 != 10 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? i2 != 7 ? "Undefined color transfer" : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzs.class == obj.getClass()) {
            zzs zzs = (zzs) obj;
            if (this.zzd == zzs.zzd && this.zze == zzs.zze && this.zzf == zzs.zzf && Arrays.equals(this.zzg, zzs.zzg)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzl;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = ((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zzf) * 31) + Arrays.hashCode(this.zzg);
        this.zzl = hashCode;
        return hashCode;
    }

    public final String toString() {
        String zzg2 = zzg(this.zzd);
        String zzf2 = zzf(this.zze);
        String zzh2 = zzh(this.zzf);
        byte[] bArr = this.zzg;
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(zzg2);
        sb.append(", ");
        sb.append(zzf2);
        sb.append(", ");
        sb.append(zzh2);
        sb.append(", ");
        sb.append(bArr != null);
        sb.append(")");
        return sb.toString();
    }

    public final zzr zzc() {
        return new zzr(this, (zzq) null);
    }

    public final String zzd() {
        if (!zze()) {
            return "NA";
        }
        return String.format(Locale.US, "%s/%s/%s", new Object[]{zzg(this.zzd), zzf(this.zze), zzh(this.zzf)});
    }

    public final boolean zze() {
        return (this.zzd == -1 || this.zze == -1 || this.zzf == -1) ? false : true;
    }
}
