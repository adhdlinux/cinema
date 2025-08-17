package com.google.android.gms.internal.ads;

public final class zzbau extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzbau zzb;
    private int zzd;
    private boolean zze;
    private int zzf;

    static {
        zzbau zzbau = new zzbau();
        zzb = zzbau;
        zzgpm.zzaU(zzbau.class, zzbau);
    }

    private zzbau() {
    }

    public static zzbat zza() {
        return (zzbat) zzb.zzaA();
    }

    static /* synthetic */ void zzd(zzbau zzbau, boolean z2) {
        zzbau.zzd |= 1;
        zzbau.zze = z2;
    }

    static /* synthetic */ void zze(zzbau zzbau, int i2) {
        zzbau.zzd |= 2;
        zzbau.zzf = i2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        } else if (i3 == 3) {
            return new zzbau();
        } else {
            if (i3 == 4) {
                return new zzbat((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zzf() {
        return this.zze;
    }
}
