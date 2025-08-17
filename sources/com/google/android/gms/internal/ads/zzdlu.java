package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzdlu implements Callable {
    /* access modifiers changed from: private */
    public final zza zza;
    /* access modifiers changed from: private */
    public final zzcfl zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    /* access modifiers changed from: private */
    public final zzdqa zzd;
    /* access modifiers changed from: private */
    public final zzfev zze;
    /* access modifiers changed from: private */
    public final zzeba zzf;
    /* access modifiers changed from: private */
    public final Executor zzg;
    /* access modifiers changed from: private */
    public final zzaqs zzh;
    /* access modifiers changed from: private */
    public final zzbzx zzi;
    /* access modifiers changed from: private */
    public final zzfgr zzj;
    /* access modifiers changed from: private */
    public final zzebl zzk;

    public zzdlu(Context context, Executor executor, zzaqs zzaqs, zzbzx zzbzx, zza zza2, zzcfl zzcfl, zzeba zzeba, zzfgr zzfgr, zzdqa zzdqa, zzfev zzfev, zzebl zzebl) {
        this.zzc = context;
        this.zzg = executor;
        this.zzh = zzaqs;
        this.zzi = zzbzx;
        this.zza = zza2;
        this.zzb = zzcfl;
        this.zzf = zzeba;
        this.zzj = zzfgr;
        this.zzd = zzdqa;
        this.zze = zzfev;
        this.zzk = zzebl;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzdlx zzdlx = new zzdlx(this);
        zzdlx.zzh();
        return zzdlx;
    }
}
