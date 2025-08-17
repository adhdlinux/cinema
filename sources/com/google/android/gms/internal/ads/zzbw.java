package com.google.android.gms.internal.ads;

public class zzbw {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    protected zzbw(zzbw zzbw) {
        this.zza = zzbw.zza;
        this.zzb = zzbw.zzb;
        this.zzc = zzbw.zzc;
        this.zzd = zzbw.zzd;
        this.zze = zzbw.zze;
    }

    public zzbw(Object obj, int i2, int i3, long j2) {
        this(obj, i2, i3, j2, -1);
    }

    private zzbw(Object obj, int i2, int i3, long j2, int i4) {
        this.zza = obj;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = j2;
        this.zze = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbw)) {
            return false;
        }
        zzbw zzbw = (zzbw) obj;
        if (this.zza.equals(zzbw.zza) && this.zzb == zzbw.zzb && this.zzc == zzbw.zzc && this.zzd == zzbw.zzd && this.zze == zzbw.zze) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzbw zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzbw(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzbw(Object obj, long j2) {
        this(obj, -1, -1, j2, -1);
    }

    public zzbw(Object obj, long j2, int i2) {
        this(obj, -1, -1, j2, i2);
    }
}
