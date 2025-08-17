package com.google.android.gms.internal.ads;

public final class zzglb extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzglb zzb;
    private String zzd = "";
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzglb zzglb = new zzglb();
        zzb = zzglb;
        zzgpm.zzaU(zzglb.class, zzglb);
    }

    private zzglb() {
    }

    public static zzgla zza() {
        return (zzgla) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzglb zzglb, String str) {
        str.getClass();
        zzglb.zzd = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzglb();
        } else {
            if (i3 == 4) {
                return new zzgla((zzgky) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
