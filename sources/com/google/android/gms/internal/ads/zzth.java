package com.google.android.gms.internal.ads;

final class zzth extends zztc {
    public static final Object zzd = new Object();
    private final Object zze;
    /* access modifiers changed from: private */
    public final Object zzf;

    private zzth(zzcw zzcw, Object obj, Object obj2) {
        super(zzcw);
        this.zze = obj;
        this.zzf = obj2;
    }

    public static zzth zzq(zzbp zzbp) {
        return new zzth(new zzti(zzbp), zzcv.zza, zzd);
    }

    public static zzth zzr(zzcw zzcw, Object obj, Object obj2) {
        return new zzth(zzcw, obj, obj2);
    }

    public final int zza(Object obj) {
        Object obj2;
        zzcw zzcw = this.zzc;
        if (zzd.equals(obj) && (obj2 = this.zzf) != null) {
            obj = obj2;
        }
        return zzcw.zza(obj);
    }

    public final zzct zzd(int i2, zzct zzct, boolean z2) {
        this.zzc.zzd(i2, zzct, z2);
        if (zzfj.zzC(zzct.zzc, this.zzf) && z2) {
            zzct.zzc = zzd;
        }
        return zzct;
    }

    public final zzcv zze(int i2, zzcv zzcv, long j2) {
        this.zzc.zze(i2, zzcv, j2);
        if (zzfj.zzC(zzcv.zzc, this.zze)) {
            zzcv.zzc = zzcv.zza;
        }
        return zzcv;
    }

    public final Object zzf(int i2) {
        Object zzf2 = this.zzc.zzf(i2);
        if (zzfj.zzC(zzf2, this.zzf)) {
            return zzd;
        }
        return zzf2;
    }

    public final zzth zzp(zzcw zzcw) {
        return new zzth(zzcw, this.zze, this.zzf);
    }
}
