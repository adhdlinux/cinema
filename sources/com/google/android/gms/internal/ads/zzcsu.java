package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.util.Clock;

public final class zzcsu implements zzcwu, zza, zzcyb, zzcwa, zzcvg, zzdan {
    private final Clock zza;
    private final zzbyt zzb;

    public zzcsu(Clock clock, zzbyt zzbyt) {
        this.zza = clock;
        this.zzb = zzbyt;
    }

    public final void onAdClicked() {
        this.zzb.zzd();
    }

    public final void zzb(zzezz zzezz) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final void zzbA(zzbue zzbue) {
    }

    public final void zzbr() {
    }

    public final String zzc() {
        return this.zzb.zzc();
    }

    public final void zzd() {
    }

    public final void zze(zzaxu zzaxu) {
        this.zzb.zzi();
    }

    public final void zzf(zzaxu zzaxu) {
    }

    public final void zzg(zzl zzl) {
        this.zzb.zzj(zzl);
    }

    public final void zzh(boolean z2) {
    }

    public final void zzi(zzaxu zzaxu) {
        this.zzb.zzg();
    }

    public final void zzj() {
        this.zzb.zze();
    }

    public final void zzk(boolean z2) {
    }

    public final void zzl() {
        this.zzb.zzf();
    }

    public final void zzm() {
    }

    public final void zzn() {
        this.zzb.zzh(true);
    }

    public final void zzo() {
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
    }

    public final void zzq() {
    }
}
