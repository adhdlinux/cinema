package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import java.util.concurrent.Executor;

final class zzevy implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzcpy zzd;
    final /* synthetic */ zzevz zze;

    zzevy(zzevz zzevz, zzekb zzekb, zzffy zzffy, zzffn zzffn, zzcpy zzcpy) {
        this.zze = zzevz;
        this.zza = zzekb;
        this.zzb = zzffy;
        this.zzc = zzffn;
        this.zzd = zzcpy;
    }

    public final void zza(Throwable th) {
        zzffy zzffy;
        zze zza2 = this.zzd.zzd().zza(th);
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zzd.zzf().zza(zza2);
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzhJ)).booleanValue()) {
                this.zze.zzb.execute(new zzevx(this, zza2));
            }
            zzevz zzevz = this.zze;
            zzevz.zzh.zzd(zzevz.zzj.zzc());
            zzfbc.zzb(zza2.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zzj = this.zze.zzi;
                zzffn zzffn = this.zzc;
                zzffn.zza(zza2);
                zzffn.zzg(th);
                zzffn.zzf(false);
                zzj.zzb(zzffn.zzl());
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
        zzcpb zzcpb = (zzcpb) obj;
        synchronized (this.zze) {
            this.zze.zzl = null;
            this.zze.zzf.removeAllViews();
            if (zzcpb.zzc() != null) {
                ViewParent parent = zzcpb.zzc().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzcpb.zzl() != null) {
                        str = zzcpb.zzl().zzg();
                    }
                    zzbzr.zzj("Banner view provided from " + str + " already has a parent view. Removing its old parent.");
                    ((ViewGroup) parent).removeView(zzcpb.zzc());
                }
            }
            zzbbe zzbbe = zzbbm.zzhJ;
            if (((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue()) {
                zzczl zzn = zzcpb.zzn();
                zzn.zza(this.zze.zzd);
                zzn.zzc(this.zze.zze);
            }
            this.zze.zzf.addView(zzcpb.zzc());
            this.zza.zzb(zzcpb);
            if (((Boolean) zzba.zzc().zzb(zzbbe)).booleanValue()) {
                zzevz zzevz = this.zze;
                Executor zzk = zzevz.zzb;
                zzejm zzg = zzevz.zzd;
                zzg.getClass();
                zzk.execute(new zzevw(zzg));
            }
            this.zze.zzh.zzd(zzcpb.zza());
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffy = this.zzb) == null) {
                zzfgb zzj = this.zze.zzi;
                zzffn zzffn = this.zzc;
                zzffn.zzb(zzcpb.zzp().zzb);
                zzffn.zzd(zzcpb.zzl().zzg());
                zzffn.zzf(true);
                zzj.zzb(zzffn.zzl());
            } else {
                zzffy.zzf(zzcpb.zzp().zzb);
                zzffy.zze(zzcpb.zzl().zzg());
                zzffn zzffn2 = this.zzc;
                zzffn2.zzf(true);
                zzffy.zza(zzffn2);
                zzffy.zzg();
            }
        }
    }
}
