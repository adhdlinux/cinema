package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

final class zzeus implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzeuu zzd;
    final /* synthetic */ zzeuv zze;

    zzeus(zzeuv zzeuv, zzekb zzekb, zzffy zzffy, zzffn zzffn, zzeuu zzeuu) {
        this.zze = zzeuv;
        this.zza = zzekb;
        this.zzb = zzffy;
        this.zzc = zzffn;
        this.zzd = zzeuu;
    }

    /* JADX WARNING: type inference failed for: r0v17, types: [java.lang.Object, com.google.android.gms.internal.ads.zzcun] */
    public final void zza(Throwable th) {
        zze zze2;
        zzffy zzffy;
        zzcol zzcol = (zzcol) this.zze.zze.zzd();
        if (zzcol == null) {
            zze2 = zzfbi.zzb(th, (zzech) null);
        } else {
            zze2 = zzcol.zzb().zza(th);
        }
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcol != null) {
                zzcol.zzc().zza(zze2);
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzhK)).booleanValue()) {
                    this.zze.zzc.execute(new zzeur(this, zze2));
                }
            } else {
                this.zze.zzd.zza(zze2);
                this.zze.zzm(this.zzd).zzh().zzb().zzc().zzd();
            }
            zzfbc.zzb(zze2.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zzh = this.zze.zzh;
                zzffn zzffn = this.zzc;
                zzffn.zza(zze2);
                zzffn.zzg(th);
                zzffn.zzf(false);
                zzh.zzb(zzffn.zzl());
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
        zzcrd zzcrd = (zzcrd) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhK)).booleanValue()) {
                zzcrd.zzn().zzb(this.zze.zzd);
            }
            this.zza.zzb(zzcrd);
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zzh = this.zze.zzh;
                zzffn zzffn = this.zzc;
                zzffn.zzb(zzcrd.zzp().zzb);
                zzffn.zzd(zzcrd.zzl().zzg());
                zzffn.zzf(true);
                zzh.zzb(zzffn.zzl());
            } else {
                zzffy.zzf(zzcrd.zzp().zzb);
                zzffy.zze(zzcrd.zzl().zzg());
                zzffn zzffn2 = this.zzc;
                zzffn2.zzf(true);
                zzffy.zza(zzffn2);
                zzffy.zzg();
            }
        }
    }
}
