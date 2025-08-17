package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.HashMap;

public final class zzaw {
    /* access modifiers changed from: private */
    public final zzk zza;
    /* access modifiers changed from: private */
    public final zzi zzb;
    /* access modifiers changed from: private */
    public final zzeq zzc;
    /* access modifiers changed from: private */
    public final zzbgq zzd;
    private final zzbvz zze;
    /* access modifiers changed from: private */
    public final zzbrq zzf;
    /* access modifiers changed from: private */
    public final zzbgr zzg;
    /* access modifiers changed from: private */
    public zzbsy zzh;

    public zzaw(zzk zzk, zzi zzi, zzeq zzeq, zzbgq zzbgq, zzbvz zzbvz, zzbrq zzbrq, zzbgr zzbgr) {
        this.zza = zzk;
        this.zzb = zzi;
        this.zzc = zzeq;
        this.zzd = zzbgq;
        this.zze = zzbvz;
        this.zzf = zzbrq;
        this.zzg = zzbgr;
    }

    static /* bridge */ /* synthetic */ void zzt(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzn(context, zzay.zzc().zza, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbnw zzbnw) {
        return (zzbq) new zzao(this, context, str, zzbnw).zzd(context, false);
    }

    public final zzbu zzd(Context context, zzq zzq, String str, zzbnw zzbnw) {
        return (zzbu) new zzak(this, context, zzq, str, zzbnw).zzd(context, false);
    }

    public final zzbu zze(Context context, zzq zzq, String str, zzbnw zzbnw) {
        return (zzbu) new zzam(this, context, zzq, str, zzbnw).zzd(context, false);
    }

    public final zzdj zzf(Context context, zzbnw zzbnw) {
        return (zzdj) new zzac(this, context, zzbnw).zzd(context, false);
    }

    public final zzbev zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbev) new zzas(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzbfb zzi(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbfb) new zzau(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzbjj zzl(Context context, zzbnw zzbnw, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbjj) new zzai(this, context, zzbnw, onH5AdsEventListener).zzd(context, false);
    }

    public final zzbrm zzm(Context context, zzbnw zzbnw) {
        return (zzbrm) new zzag(this, context, zzbnw).zzd(context, false);
    }

    public final zzbrt zzo(Activity activity) {
        zzaa zzaa = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z2 = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbzr.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z2 = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbrt) zzaa.zzd(activity, z2);
    }

    public final zzbvn zzq(Context context, String str, zzbnw zzbnw) {
        return (zzbvn) new zzav(this, context, str, zzbnw).zzd(context, false);
    }

    public final zzbyi zzr(Context context, zzbnw zzbnw) {
        return (zzbyi) new zzae(this, context, zzbnw).zzd(context, false);
    }
}
