package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import java.util.concurrent.Executor;

public final class zzexq implements zzekc {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcgu zzc;
    /* access modifiers changed from: private */
    public final zzejm zzd;
    /* access modifiers changed from: private */
    public final zzeyq zze;
    private zzbck zzf;
    /* access modifiers changed from: private */
    public final zzfgb zzg;
    private final zzfag zzh;
    /* access modifiers changed from: private */
    public zzfwm zzi;

    public zzexq(Context context, Executor executor, zzcgu zzcgu, zzejm zzejm, zzeyq zzeyq, zzfag zzfag) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgu;
        this.zzd = zzejm;
        this.zzh = zzfag;
        this.zze = zzeyq;
        this.zzg = zzcgu.zzy();
    }

    public final boolean zza() {
        zzfwm zzfwm = this.zzi;
        return zzfwm != null && !zzfwm.isDone();
    }

    public final boolean zzb(zzl zzl, String str, zzeka zzeka, zzekb zzekb) {
        zzdeo zzf2;
        zzffy zzffy;
        if (str == null) {
            zzbzr.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzexk(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzl.zzf) {
                this.zzc.zzj().zzm(true);
            }
            zzq zzq = ((zzexj) zzeka).zza;
            zzfag zzfag = this.zzh;
            zzfag.zzs(str);
            zzfag.zzr(zzq);
            zzfag.zzE(zzl);
            zzfai zzG = zzfag.zzG();
            zzffn zzb2 = zzffm.zzb(this.zza, zzffx.zzf(zzG), 4, zzl);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhL)).booleanValue()) {
                zzden zzf3 = this.zzc.zzf();
                zzcuo zzcuo = new zzcuo();
                zzcuo.zze(this.zza);
                zzcuo.zzi(zzG);
                zzf3.zze(zzcuo.zzj());
                zzdar zzdar = new zzdar();
                zzdar.zzj(this.zzd, this.zzb);
                zzdar.zzk(this.zzd, this.zzb);
                zzf3.zzd(zzdar.zzn());
                zzf3.zzc(new zzehv(this.zzf));
                zzf2 = zzf3.zzf();
            } else {
                zzdar zzdar2 = new zzdar();
                zzeyq zzeyq = this.zze;
                if (zzeyq != null) {
                    zzdar2.zze(zzeyq, this.zzb);
                    zzdar2.zzf(this.zze, this.zzb);
                    zzdar2.zzb(this.zze, this.zzb);
                }
                zzden zzf4 = this.zzc.zzf();
                zzcuo zzcuo2 = new zzcuo();
                zzcuo2.zze(this.zza);
                zzcuo2.zzi(zzG);
                zzf4.zze(zzcuo2.zzj());
                zzdar2.zzj(this.zzd, this.zzb);
                zzdar2.zze(this.zzd, this.zzb);
                zzdar2.zzf(this.zzd, this.zzb);
                zzdar2.zzb(this.zzd, this.zzb);
                zzdar2.zza(this.zzd, this.zzb);
                zzdar2.zzl(this.zzd, this.zzb);
                zzdar2.zzk(this.zzd, this.zzb);
                zzdar2.zzi(this.zzd, this.zzb);
                zzdar2.zzc(this.zzd, this.zzb);
                zzf4.zzd(zzdar2.zzn());
                zzf4.zzc(new zzehv(this.zzf));
                zzf2 = zzf4.zzf();
            }
            zzdeo zzdeo = zzf2;
            if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
                zzffy zzf5 = zzdeo.zzf();
                zzf5.zzh(4);
                zzf5.zzb(zzl.zzp);
                zzffy = zzf5;
            } else {
                zzffy = null;
            }
            zzcsk zza2 = zzdeo.zza();
            zzfwm zzi2 = zza2.zzi(zza2.zzj());
            this.zzi = zzi2;
            zzfwc.zzq(zzi2, new zzexp(this, zzekb, zzffy, zzb2, zzdeo), this.zzb);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zza(zzfbi.zzd(6, (String) null, (zze) null));
    }

    public final void zzi(zzbck zzbck) {
        this.zzf = zzbck;
    }
}
