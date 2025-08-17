package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzq;

public final class zzcgo {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcgo(int i2, int i3, int i4) {
        this.zzc = i2;
        this.zzb = i3;
        this.zza = i4;
    }

    public static zzcgo zza() {
        return new zzcgo(0, 0, 0);
    }

    public static zzcgo zzb(int i2, int i3) {
        return new zzcgo(1, i2, i3);
    }

    public static zzcgo zzc(zzq zzq) {
        if (zzq.zzd) {
            return new zzcgo(3, 0, 0);
        }
        if (zzq.zzi) {
            return new zzcgo(2, 0, 0);
        }
        if (zzq.zzh) {
            return zza();
        }
        return zzb(zzq.zzf, zzq.zzc);
    }

    public static zzcgo zzd() {
        return new zzcgo(5, 0, 0);
    }

    public static zzcgo zze() {
        return new zzcgo(4, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 0;
    }

    public final boolean zzg() {
        return this.zzc == 2;
    }

    public final boolean zzh() {
        return this.zzc == 5;
    }

    public final boolean zzi() {
        return this.zzc == 3;
    }

    public final boolean zzj() {
        return this.zzc == 4;
    }
}
