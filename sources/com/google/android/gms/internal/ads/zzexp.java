package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;

final class zzexp implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzdeo zzd;
    final /* synthetic */ zzexq zze;

    zzexp(zzexq zzexq, zzekb zzekb, zzffy zzffy, zzffn zzffn, zzdeo zzdeo) {
        this.zze = zzexq;
        this.zza = zzekb;
        this.zzb = zzffy;
        this.zzc = zzffn;
        this.zzd = zzdeo;
    }

    public final void zza(Throwable th) {
        zzffy zzffy;
        zze zza2 = this.zzd.zza().zza(th);
        synchronized (this.zze) {
            this.zze.zzi = null;
            this.zzd.zzb().zza(zza2);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhL)).booleanValue()) {
                this.zze.zzb.execute(new zzexn(this, zza2));
                this.zze.zzb.execute(new zzexo(this, zza2));
            }
            zzfbc.zzb(zza2.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zze2 = this.zze.zzg;
                zzffn zzffn = this.zzc;
                zzffn.zza(zza2);
                zzffn.zzg(th);
                zzffn.zzf(false);
                zze2.zzb(zzffn.zzl());
            } else {
                zzffy.zzc(zza2);
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
        zzddn zzddn = (zzddn) obj;
        synchronized (this.zze) {
            this.zze.zzi = null;
            zzbbe zzbbe = zzbbm.zzhL;
            if (((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue()) {
                zzczl zzn = zzddn.zzn();
                zzn.zza(this.zze.zzd);
                zzn.zzd(this.zze.zze);
            }
            this.zza.zzb(zzddn);
            if (((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue()) {
                this.zze.zzb.execute(new zzexl(this));
                this.zze.zzb.execute(new zzexm(this));
            }
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zze2 = this.zze.zzg;
                zzffn zzffn = this.zzc;
                zzffn.zzb(zzddn.zzp().zzb);
                zzffn.zzd(zzddn.zzl().zzg());
                zzffn.zzf(true);
                zze2.zzb(zzffn.zzl());
            } else {
                zzffy.zzf(zzddn.zzp().zzb);
                zzffy.zze(zzddn.zzl().zzg());
                zzffn zzffn2 = this.zzc;
                zzffn2.zzf(true);
                zzffy.zza(zzffn2);
                zzffy.zzg();
            }
        }
    }
}
