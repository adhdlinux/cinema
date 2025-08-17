package com.google.android.gms.internal.ads;

import android.net.Uri;

public final class zzvj extends zzcw {
    private static final Object zzc = new Object();
    private static final zzbp zzd;
    private final long zze;
    private final long zzf;
    private final boolean zzg;
    private final zzbp zzh;
    private final zzbf zzi;

    static {
        zzar zzar = new zzar();
        zzar.zza("SinglePeriodTimeline");
        zzar.zzb(Uri.EMPTY);
        zzd = zzar.zzc();
    }

    public zzvj(long j2, long j3, long j4, long j5, long j6, long j7, long j8, boolean z2, boolean z3, boolean z4, Object obj, zzbp zzbp, zzbf zzbf) {
        this.zze = j5;
        this.zzf = j6;
        this.zzg = z2;
        this.zzh = zzbp;
        this.zzi = zzbf;
    }

    public final int zza(Object obj) {
        return zzc.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzct zzd(int i2, zzct zzct, boolean z2) {
        Object obj;
        zzdy.zza(i2, 0, 1);
        if (z2) {
            obj = zzc;
        } else {
            obj = null;
        }
        zzct.zzl((Object) null, obj, 0, this.zze, 0, zzd.zza, false);
        return zzct;
    }

    public final zzcv zze(int i2, zzcv zzcv, long j2) {
        zzdy.zza(i2, 0, 1);
        zzcv.zza(zzcv.zza, this.zzh, (Object) null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.zzg, false, this.zzi, 0, this.zzf, 0, 0, 0);
        return zzcv;
    }

    public final Object zzf(int i2) {
        zzdy.zza(i2, 0, 1);
        return zzc;
    }
}
