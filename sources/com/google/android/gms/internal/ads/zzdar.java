package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdar {
    /* access modifiers changed from: private */
    public final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzm = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzn = new HashSet();
    /* access modifiers changed from: private */
    public zzexb zzo;

    public final zzdar zza(zza zza2, Executor executor) {
        this.zzc.add(new zzdcm(zza2, executor));
        return this;
    }

    public final zzdar zzb(zzcvj zzcvj, Executor executor) {
        this.zzi.add(new zzdcm(zzcvj, executor));
        return this;
    }

    public final zzdar zzc(zzcvw zzcvw, Executor executor) {
        this.zzl.add(new zzdcm(zzcvw, executor));
        return this;
    }

    public final zzdar zzd(zzcwa zzcwa, Executor executor) {
        this.zzf.add(new zzdcm(zzcwa, executor));
        return this;
    }

    public final zzdar zze(zzcvg zzcvg, Executor executor) {
        this.zze.add(new zzdcm(zzcvg, executor));
        return this;
    }

    public final zzdar zzf(zzcwu zzcwu, Executor executor) {
        this.zzh.add(new zzdcm(zzcwu, executor));
        return this;
    }

    public final zzdar zzg(zzcxf zzcxf, Executor executor) {
        this.zzg.add(new zzdcm(zzcxf, executor));
        return this;
    }

    public final zzdar zzh(zzo zzo2, Executor executor) {
        this.zzn.add(new zzdcm(zzo2, executor));
        return this;
    }

    public final zzdar zzi(zzcxr zzcxr, Executor executor) {
        this.zzm.add(new zzdcm(zzcxr, executor));
        return this;
    }

    public final zzdar zzj(zzcyb zzcyb, Executor executor) {
        this.zzb.add(new zzdcm(zzcyb, executor));
        return this;
    }

    public final zzdar zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdcm(appEventListener, executor));
        return this;
    }

    public final zzdar zzl(zzdcu zzdcu, Executor executor) {
        this.zzd.add(new zzdcm(zzdcu, executor));
        return this;
    }

    public final zzdar zzm(zzexb zzexb) {
        this.zzo = zzexb;
        return this;
    }

    public final zzdat zzn() {
        return new zzdat(this, (zzdas) null);
    }
}
