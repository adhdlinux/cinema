package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

public final class zzczn implements AppEventListener, OnAdMetadataChangedListener, zzcvg, zza, zzcxr, zzcwa, zzcxf, zzo, zzcvw, zzdcu {
    private final zzczl zza = new zzczl(this, (zzczk) null);
    /* access modifiers changed from: private */
    public zzejm zzb;
    /* access modifiers changed from: private */
    public zzejq zzc;
    /* access modifiers changed from: private */
    public zzevl zzd;
    /* access modifiers changed from: private */
    public zzeyq zze;

    private static void zzw(Object obj, zzczm zzczm) {
        if (obj != null) {
            zzczm.zza(obj);
        }
    }

    public final void onAdClicked() {
        zzw(this.zzb, zzczb.zza);
        zzw(this.zzc, zzczc.zza);
    }

    public final void onAdMetadataChanged() {
        zzw(this.zze, zzcyu.zza);
    }

    public final void onAppEvent(String str, String str2) {
        zzw(this.zzb, new zzcyd(str, str2));
    }

    public final void zzb() {
        zzw(this.zzd, zzczh.zza);
    }

    public final void zzbF() {
        zzw(this.zzd, zzcyz.zza);
    }

    public final void zzbo() {
        zzw(this.zzd, zzcyg.zza);
    }

    public final void zzbr() {
        zzw(this.zzb, zzcyh.zza);
        zzw(this.zze, zzcyi.zza);
    }

    public final void zzby() {
        zzw(this.zzd, zzcyj.zza);
    }

    public final void zze() {
        zzw(this.zzd, zzcyc.zza);
    }

    public final void zzf(int i2) {
        zzw(this.zzd, new zzcyx(i2));
    }

    public final void zzg() {
        zzw(this.zzd, zzcyp.zza);
    }

    public final void zzh(zzs zzs) {
        zzw(this.zzb, new zzcze(zzs));
        zzw(this.zze, new zzczf(zzs));
        zzw(this.zzd, new zzczg(zzs));
    }

    public final zzczl zzi() {
        return this.zza;
    }

    public final void zzj() {
        zzw(this.zzb, zzcyv.zza);
        zzw(this.zze, zzcyw.zza);
    }

    public final void zzk(zze zze2) {
        zzw(this.zze, new zzcyk(zze2));
        zzw(this.zzb, new zzcyl(zze2));
    }

    public final void zzl() {
        zzw(this.zzb, zzcyn.zza);
    }

    public final void zzm() {
        zzw(this.zzb, zzcyy.zza);
        zzw(this.zze, zzczd.zza);
    }

    public final void zzo() {
        zzw(this.zzb, zzczi.zza);
        zzw(this.zze, zzczj.zza);
    }

    public final void zzp(zzbuu zzbuu, String str, String str2) {
        zzw(this.zzb, new zzcym(zzbuu, str, str2));
        zzw(this.zze, new zzcyo(zzbuu, str, str2));
    }

    public final void zzq() {
        zzw(this.zzb, zzcye.zza);
        zzw(this.zze, zzcyf.zza);
    }

    public final void zzr() {
        zzw(this.zzb, zzcyq.zza);
        zzw(this.zzc, zzcyr.zza);
        zzw(this.zze, zzcys.zza);
        zzw(this.zzd, zzcyt.zza);
    }

    public final void zzs() {
        zzw(this.zzb, zzcza.zza);
    }
}
