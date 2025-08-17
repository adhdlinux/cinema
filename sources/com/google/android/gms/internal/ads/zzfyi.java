package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzfyi {
    private final Object zza;
    private final Object zzb;
    private final byte[] zzc;
    private final zzglq zzd;
    private final int zze;
    private final String zzf;
    private final zzfxn zzg;
    private final int zzh;

    zzfyi(Object obj, Object obj2, byte[] bArr, int i2, zzglq zzglq, int i3, String str, zzfxn zzfxn) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = Arrays.copyOf(bArr, bArr.length);
        this.zzh = i2;
        this.zzd = zzglq;
        this.zze = i3;
        this.zzf = str;
        this.zzg = zzfxn;
    }

    public final int zza() {
        return this.zze;
    }

    public final zzfxn zzb() {
        return this.zzg;
    }

    public final zzglq zzc() {
        return this.zzd;
    }

    public final Object zzd() {
        return this.zza;
    }

    public final Object zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final byte[] zzg() {
        byte[] bArr = this.zzc;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final int zzh() {
        return this.zzh;
    }
}
