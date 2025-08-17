package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzedz extends zzbve implements zzcwq {
    private zzbvf zza;
    private zzcwp zzb;
    private zzddf zzc;

    public final synchronized void zza(zzcwp zzcwp) {
        this.zzb = zzcwp;
    }

    public final synchronized void zzc(zzbvf zzbvf) {
        this.zza = zzbvf;
    }

    public final synchronized void zzd(zzddf zzddf) {
        this.zzc = zzddf;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            ((zzegx) zzbvf).zzb.onAdClicked();
        }
    }

    public final synchronized void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            zzbvf.zzf(iObjectWrapper);
        }
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        zzcwp zzcwp = this.zzb;
        if (zzcwp != null) {
            zzcwp.zza(i2);
        }
    }

    public final synchronized void zzh(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            ((zzegx) zzbvf).zzc.zzb();
        }
    }

    public final synchronized void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzcwp zzcwp = this.zzb;
        if (zzcwp != null) {
            zzcwp.zzd();
        }
    }

    public final synchronized void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            ((zzegx) zzbvf).zza.zzb();
        }
    }

    public final synchronized void zzk(IObjectWrapper iObjectWrapper, int i2) throws RemoteException {
        zzddf zzddf = this.zzc;
        if (zzddf != null) {
            zzbzr.zzj("Fail to initialize adapter ".concat(String.valueOf(((zzegw) zzddf).zzc.zza)));
        }
    }

    public final synchronized void zzl(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzddf zzddf = this.zzc;
        if (zzddf != null) {
            ((zzegw) zzddf).zzd.zzb.execute(new zzegv((zzegw) zzddf, ((zzegw) zzddf).zza, ((zzegw) zzddf).zzb, ((zzegw) zzddf).zzc));
        }
    }

    public final synchronized void zzm(IObjectWrapper iObjectWrapper, zzbvg zzbvg) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            ((zzegx) zzbvf).zzd.zza(zzbvg);
        }
    }

    public final synchronized void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            ((zzegx) zzbvf).zzc.zze();
        }
    }

    public final synchronized void zzo(IObjectWrapper iObjectWrapper) throws RemoteException {
        zzbvf zzbvf = this.zza;
        if (zzbvf != null) {
            ((zzegx) zzbvf).zzd.zzc();
        }
    }
}
