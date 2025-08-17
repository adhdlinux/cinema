package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

final class zzeki implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzdfk zzd;
    final /* synthetic */ zzekj zze;

    zzeki(zzekj zzekj, zzekb zzekb, zzffy zzffy, zzffn zzffn, zzdfk zzdfk) {
        this.zze = zzekj;
        this.zza = zzekb;
        this.zzb = zzffy;
        this.zzc = zzffn;
        this.zzd = zzdfk;
    }

    public final void zza(Throwable th) {
        zzffy zzffy;
        zze zza2 = this.zzd.zza().zza(th);
        this.zzd.zzb().zza(zza2);
        this.zze.zzb.zzA().execute(new zzekh(this, zza2));
        zzfbc.zzb(zza2.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
            zzfgb zze2 = this.zze.zze;
            zzffn zzffn = this.zzc;
            zzffn.zza(zza2);
            zzffn.zzg(th);
            zzffn.zzf(false);
            zze2.zzb(zzffn.zzl());
            return;
        }
        zzffy.zzc(zza2);
        zzffn zzffn2 = this.zzc;
        zzffn2.zzg(th);
        zzffn2.zzf(false);
        zzffy.zza(zzffn2);
        zzffy.zzg();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzffy zzffy;
        zzcrd zzcrd = (zzcrd) obj;
        synchronized (this.zze) {
            zzcrd.zzn().zza(this.zze.zzd.zzd());
            this.zza.zzb(zzcrd);
            this.zze.zzb.zzA().execute(new zzekg(this));
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zze2 = this.zze.zze;
                zzffn zzffn = this.zzc;
                zzffn.zzb(zzcrd.zzp().zzb);
                zzffn.zzd(zzcrd.zzl().zzg());
                zzffn.zzf(true);
                zze2.zzb(zzffn.zzl());
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
