package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.zzt;
import java.util.Collections;
import java.util.List;

public final class zzdqx implements AppEventListener, zzcyb, zza, zzcvg, zzcwa, zzcwb, zzcwu, zzcvj, zzfem {
    private final List zza;
    private final zzdql zzb;
    private long zzc;

    public zzdqx(zzdql zzdql, zzcgu zzcgu) {
        this.zzb = zzdql;
        this.zza = Collections.singletonList(zzcgu);
    }

    private final void zze(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    public final void onAdClicked() {
        zze(zza.class, "onAdClicked", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        zze(AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void zza(zze zze) {
        zze(zzcvj.class, "onAdFailedToLoad", Integer.valueOf(zze.zza), zze.zzb, zze.zzc);
    }

    public final void zzb(zzezz zzezz) {
    }

    public final void zzbA(zzbue zzbue) {
        this.zzc = zzt.zzB().elapsedRealtime();
        zze(zzcyb.class, "onAdRequest", new Object[0]);
    }

    public final void zzbB(zzfef zzfef, String str) {
        zze(zzfee.class, "onTaskCreated", str);
    }

    public final void zzbC(zzfef zzfef, String str, Throwable th) {
        zze(zzfee.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    public final void zzbn(Context context) {
        zze(zzcwb.class, "onDestroy", context);
    }

    public final void zzbp(Context context) {
        zze(zzcwb.class, "onPause", context);
    }

    public final void zzbq(Context context) {
        zze(zzcwb.class, "onResume", context);
    }

    public final void zzbr() {
        zze(zzcvg.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zzc(zzfef zzfef, String str) {
        zze(zzfee.class, "onTaskStarted", str);
    }

    public final void zzd(zzfef zzfef, String str) {
        zze(zzfee.class, "onTaskSucceeded", str);
    }

    public final void zzj() {
        zze(zzcvg.class, "onAdClosed", new Object[0]);
    }

    public final void zzl() {
        zze(zzcwa.class, "onAdImpression", new Object[0]);
    }

    public final void zzm() {
        zze(zzcvg.class, "onAdLeftApplication", new Object[0]);
    }

    public final void zzn() {
        long elapsedRealtime = zzt.zzB().elapsedRealtime() - this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + elapsedRealtime);
        zze(zzcwu.class, "onAdLoaded", new Object[0]);
    }

    public final void zzo() {
        zze(zzcvg.class, "onAdOpened", new Object[0]);
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
        zze(zzcvg.class, "onRewarded", zzbuu, str, str2);
    }

    public final void zzq() {
        zze(zzcvg.class, "onRewardedVideoCompleted", new Object[0]);
    }
}
