package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

public final class zzbgw {
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza;
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomClickListener zzb;
    private NativeCustomTemplateAd zzc;

    public zzbgw(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomTemplateAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzf(zzbfl zzbfl) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzc;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzbfm zzbfm = new zzbfm(zzbfl);
        this.zzc = zzbfm;
        return zzbfm;
    }

    public final zzbfv zzd() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbgt(this, (zzbgs) null);
    }

    public final zzbfy zze() {
        return new zzbgv(this, (zzbgu) null);
    }
}
