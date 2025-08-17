package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

public final class zzbrg {
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomClickListener zzb;
    private NativeCustomFormatAd zzc;

    public zzbrg(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzf(zzbfl zzbfl) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzbrh zzbrh = new zzbrh(zzbfl);
        this.zzc = zzbrh;
        return zzbrh;
    }

    public final zzbfv zza() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbrd(this, (zzbrc) null);
    }

    public final zzbfy zzb() {
        return new zzbrf(this, (zzbre) null);
    }
}
