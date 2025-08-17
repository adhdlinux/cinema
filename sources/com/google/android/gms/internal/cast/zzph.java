package com.google.android.gms.internal.cast;

public final class zzph extends zzsh implements zztq {
    /* access modifiers changed from: private */
    public static final zzph zzb;
    private int zzd;
    private String zze = "";

    static {
        zzph zzph = new zzph();
        zzb = zzph;
        zzsh.zzG(zzph.class, zzph);
    }

    private zzph() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzph();
        } else {
            if (i3 == 4) {
                return new zzpg((zzlu) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
