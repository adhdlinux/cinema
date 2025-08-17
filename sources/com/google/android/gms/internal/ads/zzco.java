package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzco {
    public static final zzn zza = zzcn.zza;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    private static final String zzq = Integer.toString(6, 36);
    public final Object zzb;
    public final int zzc;
    public final zzbp zzd;
    public final Object zze;
    public final int zzf;
    public final long zzg;
    public final long zzh;
    public final int zzi;
    public final int zzj;

    public zzco(Object obj, int i2, zzbp zzbp, Object obj2, int i3, long j2, long j3, int i4, int i5) {
        this.zzb = obj;
        this.zzc = i2;
        this.zzd = zzbp;
        this.zze = obj2;
        this.zzf = i3;
        this.zzg = j2;
        this.zzh = j3;
        this.zzi = i4;
        this.zzj = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzco.class == obj.getClass()) {
            zzco zzco = (zzco) obj;
            if (this.zzc == zzco.zzc && this.zzf == zzco.zzf && this.zzg == zzco.zzg && this.zzh == zzco.zzh && this.zzi == zzco.zzi && this.zzj == zzco.zzj && zzfpc.zza(this.zzb, zzco.zzb) && zzfpc.zza(this.zze, zzco.zze) && zzfpc.zza(this.zzd, zzco.zzd)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf(this.zzi), Integer.valueOf(this.zzj)});
    }
}
