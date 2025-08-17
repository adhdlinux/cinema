package com.google.android.gms.internal.ads;

final class zzcjs implements zzdra {
    private final zzciq zza;
    private final zzcjy zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcjs(zzciq zzciq, zzcjy zzcjy, zzcjr zzcjr) {
        this.zza = zzciq;
        this.zzb = zzcjy;
    }

    public final /* synthetic */ zzdra zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdra zzb(long j2) {
        this.zzc = Long.valueOf(j2);
        return this;
    }

    public final zzdrb zzc() {
        zzgwm.zzc(this.zzc, Long.class);
        zzgwm.zzc(this.zzd, String.class);
        return new zzcju(this.zza, this.zzb, this.zzc, this.zzd, (zzcjt) null);
    }
}
