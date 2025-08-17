package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.vungle.ads.internal.presenter.MRAIDPresenter;

final class zzdsb extends zzbki {
    final /* synthetic */ Object zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzffn zzd;
    final /* synthetic */ zzcaj zze;
    final /* synthetic */ zzdsc zzf;

    zzdsb(zzdsc zzdsc, Object obj, String str, long j2, zzffn zzffn, zzcaj zzcaj) {
        this.zzf = zzdsc;
        this.zza = obj;
        this.zzb = str;
        this.zzc = j2;
        this.zzd = zzffn;
        this.zze = zzcaj;
    }

    public final void zze(String str) {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, false, str, (int) (zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzb(this.zzb, MRAIDPresenter.ERROR);
            this.zzf.zzo.zzb(this.zzb, MRAIDPresenter.ERROR);
            zzfgb zze2 = this.zzf.zzp;
            zzffn zzffn = this.zzd;
            zzffn.zzc(str);
            zzffn.zzf(false);
            zze2.zzb(zzffn.zzl());
            this.zze.zzd(Boolean.FALSE);
        }
    }

    public final void zzf() {
        synchronized (this.zza) {
            this.zzf.zzv(this.zzb, true, "", (int) (zzt.zzB().elapsedRealtime() - this.zzc));
            this.zzf.zzl.zzd(this.zzb);
            this.zzf.zzo.zzd(this.zzb);
            zzfgb zze2 = this.zzf.zzp;
            zzffn zzffn = this.zzd;
            zzffn.zzf(true);
            zze2.zzb(zzffn.zzl());
            this.zze.zzd(Boolean.TRUE);
        }
    }
}
