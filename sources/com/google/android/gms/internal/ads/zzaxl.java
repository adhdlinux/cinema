package com.google.android.gms.internal.ads;

public final class zzaxl extends zzgpm implements zzgqx {
    /* access modifiers changed from: private */
    public static final zzaxl zzb;
    private int zzd;
    private int zze;
    private int zzf = 1000;
    private zzayb zzg;
    private zzayd zzh;
    private zzgpv zzi = zzgpm.zzaN();
    private zzayf zzj;
    private zzazp zzk;
    private zzazf zzl;
    private zzayt zzm;
    private zzayv zzn;
    private zzgpv zzo = zzgpm.zzaN();

    static {
        zzaxl zzaxl = new zzaxl();
        zzb = zzaxl;
        zzgpm.zzaU(zzaxl.class, zzaxl);
    }

    private zzaxl() {
    }

    public static zzaxl zzc() {
        return zzb;
    }

    static /* synthetic */ void zze(zzaxl zzaxl, zzaxj zzaxj) {
        zzaxl.zze = zzaxj.zza();
        zzaxl.zzd |= 1;
    }

    static /* synthetic */ void zzf(zzaxl zzaxl, zzayd zzayd) {
        zzayd.getClass();
        zzaxl.zzh = zzayd;
        zzaxl.zzd |= 8;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzgpm.zzaR(zzb, "\u0001\u000b\u0000\u0001\u0007\u0011\u000b\u0000\u0002\u0000\u0007᠌\u0000\b᠌\u0001\tဉ\u0002\nဉ\u0003\u000b\u001b\fဉ\u0004\rဉ\u0005\u000eဉ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011\u001b", new Object[]{"zzd", "zze", zzaxi.zza, "zzf", zzaym.zza, "zzg", "zzh", "zzi", zzaxz.class, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzbab.class});
        } else if (i3 == 3) {
            return new zzaxl();
        } else {
            if (i3 == 4) {
                return new zzaxk((zzaxg) null);
            }
            if (i3 != 5) {
                return null;
            }
            return zzb;
        }
    }

    public final zzayd zzd() {
        zzayd zzayd = this.zzh;
        return zzayd == null ? zzayd.zzc() : zzayd;
    }
}
