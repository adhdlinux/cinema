package com.google.android.gms.internal.ads;

import android.net.Uri;

public final class zzcv {
    private static final String zzA = Integer.toString(9, 36);
    private static final String zzB = Integer.toString(10, 36);
    private static final String zzC = Integer.toString(11, 36);
    private static final String zzD = Integer.toString(12, 36);
    private static final String zzE = Integer.toString(13, 36);
    public static final Object zza = new Object();
    public static final zzn zzb = zzcu.zza;
    private static final Object zzq = new Object();
    private static final zzbp zzr;
    private static final String zzs = Integer.toString(1, 36);
    private static final String zzt = Integer.toString(2, 36);
    private static final String zzu = Integer.toString(3, 36);
    private static final String zzv = Integer.toString(4, 36);
    private static final String zzw = Integer.toString(5, 36);
    private static final String zzx = Integer.toString(6, 36);
    private static final String zzy = Integer.toString(7, 36);
    private static final String zzz = Integer.toString(8, 36);
    public Object zzc = zza;
    public zzbp zzd = zzr;
    public long zze;
    public long zzf;
    public long zzg;
    public boolean zzh;
    public boolean zzi;
    @Deprecated
    public boolean zzj;
    public zzbf zzk;
    public boolean zzl;
    public long zzm;
    public long zzn;
    public int zzo;
    public int zzp;

    static {
        zzar zzar = new zzar();
        zzar.zza("androidx.media3.common.Timeline");
        zzar.zzb(Uri.EMPTY);
        zzr = zzar.zzc();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcv.class.equals(obj.getClass())) {
            zzcv zzcv = (zzcv) obj;
            if (zzfj.zzC(this.zzc, zzcv.zzc) && zzfj.zzC(this.zzd, zzcv.zzd) && zzfj.zzC((Object) null, (Object) null) && zzfj.zzC(this.zzk, zzcv.zzk) && this.zze == zzcv.zze && this.zzf == zzcv.zzf && this.zzg == zzcv.zzg && this.zzh == zzcv.zzh && this.zzi == zzcv.zzi && this.zzl == zzcv.zzl && this.zzn == zzcv.zzn && this.zzo == zzcv.zzo && this.zzp == zzcv.zzp) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int hashCode = ((this.zzc.hashCode() + 217) * 31) + this.zzd.hashCode();
        zzbf zzbf = this.zzk;
        if (zzbf == null) {
            i2 = 0;
        } else {
            i2 = zzbf.hashCode();
        }
        long j2 = this.zze;
        long j3 = this.zzf;
        long j4 = this.zzg;
        int i3 = (((((((((((((hashCode * 961) + i2) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzl ? 1 : 0);
        long j5 = this.zzn;
        return ((((((i3 * 961) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.zzo) * 31) + this.zzp) * 31;
    }

    public final zzcv zza(Object obj, zzbp zzbp, Object obj2, long j2, long j3, long j4, boolean z2, boolean z3, zzbf zzbf, long j5, long j6, int i2, int i3, long j7) {
        zzbf zzbf2 = zzbf;
        this.zzc = obj;
        this.zzd = zzbp == null ? zzr : zzbp;
        this.zze = -9223372036854775807L;
        this.zzf = -9223372036854775807L;
        this.zzg = -9223372036854775807L;
        this.zzh = z2;
        this.zzi = z3;
        this.zzj = zzbf2 != null;
        this.zzk = zzbf2;
        this.zzm = 0;
        this.zzn = j6;
        this.zzo = 0;
        this.zzp = 0;
        this.zzl = false;
        return this;
    }

    public final boolean zzb() {
        zzdy.zzf(this.zzj == (this.zzk != null));
        return this.zzk != null;
    }
}
