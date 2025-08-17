package com.google.android.gms.internal.ads;

public final class zzgtn extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgtn zzb;
    private int zzd;
    private String zze = "";

    static {
        zzgtn zzgtn = new zzgtn();
        zzb = zzgtn;
        zzgpm.zzaU(zzgtn.class, zzgtn);
    }

    private zzgtn() {
    }

    public static zzgtm zza() {
        return (zzgtm) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgtn zzgtn, String str) {
        zzgtn.zzd |= 1;
        zzgtn.zze = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        } else if (i3 == 3) {
            return new zzgtn();
        } else {
            if (i3 == 4) {
                return new zzgtm((zzgtb) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
