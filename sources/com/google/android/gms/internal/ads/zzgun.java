package com.google.android.gms.internal.ads;

public final class zzgun extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzgun zzb;
    private int zzd;
    private int zze;
    private String zzf = "";
    private zzgoe zzg;
    private zzgoe zzh;

    static {
        zzgun zzgun = new zzgun();
        zzb = zzgun;
        zzgpm.zzaU(zzgun.class, zzgun);
    }

    private zzgun() {
        zzgoe zzgoe = zzgoe.zzb;
        this.zzg = zzgoe;
        this.zzh = zzgoe;
    }

    public static zzgul zza() {
        return (zzgul) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzgun zzgun, String str) {
        zzgun.zzd |= 2;
        zzgun.zzf = "image/png";
    }

    static /* synthetic */ void zze(zzgun zzgun, zzgoe zzgoe) {
        zzgoe.getClass();
        zzgun.zzd |= 4;
        zzgun.zzg = zzgoe;
    }

    static /* synthetic */ void zzf(zzgun zzgun, int i2) {
        zzgun.zze = 1;
        zzgun.zzd = 1 | zzgun.zzd;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzd", "zze", zzgum.zza, "zzf", "zzg", "zzh"});
        } else if (i3 == 3) {
            return new zzgun();
        } else {
            if (i3 == 4) {
                return new zzgul((zzgtb) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }
}
