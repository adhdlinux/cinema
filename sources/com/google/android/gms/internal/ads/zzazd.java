package com.google.android.gms.internal.ads;

public final class zzazd extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzazd zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzazd zzazd = new zzazd();
        zzb = zzazd;
        zzgpm.zzaU(zzazd.class, zzazd);
    }

    private zzazd() {
    }

    public static zzayw zza() {
        return (zzayw) zzb.zzaA();
    }

    public static zzazd zzd() {
        return zzb;
    }

    static /* synthetic */ void zzi(zzazd zzazd, int i2) {
        zzazd.zze = i2 - 1;
        zzazd.zzd |= 1;
    }

    static /* synthetic */ void zzj(zzazd zzazd, int i2) {
        zzazd.zzf = i2 - 1;
        zzazd.zzd |= 2;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", zzazb.zza, "zzf", zzayy.zza});
        } else if (i3 == 3) {
            return new zzazd();
        } else {
            if (i3 == 4) {
                return new zzayw((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final boolean zze() {
        return (this.zzd & 2) != 0;
    }

    public final boolean zzf() {
        return (this.zzd & 1) != 0;
    }

    public final int zzg() {
        int zza = zzayz.zza(this.zzf);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    public final int zzh() {
        int zza = zzazc.zza(this.zze);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }
}
