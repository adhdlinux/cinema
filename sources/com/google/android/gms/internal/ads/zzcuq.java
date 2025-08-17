package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public final class zzcuq {
    private final Context zza;
    private final zzfai zzb;
    private final Bundle zzc;
    private final zzfaa zzd;
    private final zzcui zze;
    private final zzech zzf;

    /* synthetic */ zzcuq(zzcuo zzcuo, zzcup zzcup) {
        this.zza = zzcuo.zza;
        this.zzb = zzcuo.zzb;
        this.zzc = zzcuo.zzc;
        this.zzd = zzcuo.zzd;
        this.zze = zzcuo.zze;
        this.zzf = zzcuo.zzf;
    }

    /* access modifiers changed from: package-private */
    public final Context zza(Context context) {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzcui zzc() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final zzcuo zzd() {
        zzcuo zzcuo = new zzcuo();
        zzcuo.zze(this.zza);
        zzcuo.zzi(this.zzb);
        zzcuo.zzf(this.zzc);
        zzcuo.zzg(this.zze);
        zzcuo.zzd(this.zzf);
        return zzcuo;
    }

    /* access modifiers changed from: package-private */
    public final zzech zze(String str) {
        zzech zzech = this.zzf;
        return zzech != null ? zzech : new zzech(str);
    }

    /* access modifiers changed from: package-private */
    public final zzfaa zzf() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfai zzg() {
        return this.zzb;
    }
}
