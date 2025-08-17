package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;
import java.util.concurrent.Executor;

final class zzeyx implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzeyz zzd;
    final /* synthetic */ zzeza zze;

    zzeyx(zzeza zzeza, zzekb zzekb, zzffy zzffy, zzffn zzffn, zzeyz zzeyz) {
        this.zze = zzeza;
        this.zza = zzekb;
        this.zzb = zzffy;
        this.zzc = zzffn;
        this.zzd = zzeyz;
    }

    public final void zza(Throwable th) {
        zze zze2;
        zzffy zzffy;
        zzdmr zzdmr = (zzdmr) this.zze.zze.zzd();
        if (zzdmr == null) {
            zze2 = zzfbi.zzb(th, (zzech) null);
        } else {
            zze2 = zzdmr.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzdmr != null) {
                zzdmr.zza().zza(zze2);
                this.zze.zzb.execute(new zzeyw(this, zze2));
            } else {
                this.zze.zzd.zza(zze2);
                this.zze.zzk(this.zzd).zze().zzb().zzc().zzd();
            }
            zzfbc.zzb(zze2.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zzg = this.zze.zzg;
                zzffn zzffn = this.zzc;
                zzffn.zza(zze2);
                zzffn.zzg(th);
                zzffn.zzf(false);
                zzg.zzb(zzffn.zzl());
            } else {
                zzffy.zzc(zze2);
                zzffn zzffn2 = this.zzc;
                zzffn2.zzg(th);
                zzffn2.zzf(false);
                zzffy.zza(zzffn2);
                zzffy.zzg();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffy zzffy;
        zzdmm zzdmm = (zzdmm) obj;
        synchronized (this.zze) {
            zzdmm.zzn().zzd(this.zze.zzd);
            this.zza.zzb(zzdmm);
            zzeza zzeza = this.zze;
            Executor zzh = zzeza.zzb;
            zzeyq zzf = zzeza.zzd;
            zzf.getClass();
            zzh.execute(new zzeyv(zzf));
            this.zze.zzd.onAdMetadataChanged();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zzg = this.zze.zzg;
                zzffn zzffn = this.zzc;
                zzffn.zzb(zzdmm.zzp().zzb);
                zzffn.zzd(zzdmm.zzl().zzg());
                zzffn.zzf(true);
                zzg.zzb(zzffn.zzl());
            } else {
                zzffy.zzf(zzdmm.zzp().zzb);
                zzffy.zze(zzdmm.zzl().zzg());
                zzffn zzffn2 = this.zzc;
                zzffn2.zzf(true);
                zzffy.zza(zzffn2);
                zzffy.zzg();
            }
        }
    }
}
