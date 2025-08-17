package com.google.android.gms.internal.ads;

public final class zzaow extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaow zzb;
    private int zzd;
    private long zze;
    private String zzf = "";
    private zzgoe zzg = zzgoe.zzb;

    static {
        zzaow zzaow = new zzaow();
        zzb = zzaow;
        zzgpm.zzaU(zzaow.class, zzaow);
    }

    private zzaow() {
    }

    public static zzaow zzd() {
        return zzb;
    }

    public final long zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        } else if (i3 == 3) {
            return new zzaow();
        } else {
            if (i3 == 4) {
                return new zzaov((zzanp) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zze() {
        return (this.zzd & 1) != 0;
    }
}
