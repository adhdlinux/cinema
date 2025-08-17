package com.google.android.gms.internal.ads;

public final class zzaas {
    public final String zza;

    private zzaas(int i2, int i3, String str) {
        this.zza = str;
    }

    public static zzaas zza(zzfa zzfa) {
        String str;
        zzfa.zzG(2);
        int zzk = zzfa.zzk();
        int i2 = zzk >> 1;
        int i3 = zzk & 1;
        int zzk2 = zzfa.zzk() >> 3;
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            str = "dvhe";
        } else if (i2 == 8) {
            str = "hev1";
        } else if (i2 != 9) {
            return null;
        } else {
            str = "avc3";
        }
        int i4 = zzk2 | (i3 << 5);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = ".0";
        sb.append(str2);
        sb.append(i2);
        if (i4 >= 10) {
            str2 = ".";
        }
        sb.append(str2);
        sb.append(i4);
        return new zzaas(i2, i4, sb.toString());
    }
}
