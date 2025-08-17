package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzboz extends zzbob {
    private final Adapter zza;
    private final zzbvf zzb;

    zzboz(Adapter adapter, zzbvf zzbvf) {
        this.zza = adapter;
        this.zzb = zzbvf;
    }

    public final void zze() throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzf() throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzg(int i2) throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzg(ObjectWrapper.wrap(this.zza), i2);
        }
    }

    public final void zzh(zze zze) throws RemoteException {
    }

    public final void zzi(int i2, String str) throws RemoteException {
    }

    public final void zzj(int i2) throws RemoteException {
    }

    public final void zzk(zze zze) {
    }

    public final void zzl(String str) {
    }

    public final void zzm() throws RemoteException {
    }

    public final void zzn() throws RemoteException {
    }

    public final void zzo() throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzp() throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzq(String str, String str2) throws RemoteException {
    }

    public final void zzr(zzbfl zzbfl, String str) throws RemoteException {
    }

    public final void zzs(zzbvg zzbvg) throws RemoteException {
    }

    public final void zzt(zzbvk zzbvk) throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzm(ObjectWrapper.wrap(this.zza), new zzbvg(zzbvk.zzf(), zzbvk.zze()));
        }
    }

    public final void zzu() throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    public final void zzv() throws RemoteException {
    }

    public final void zzw() throws RemoteException {
    }

    public final void zzx() throws RemoteException {
    }

    public final void zzy() throws RemoteException {
        zzbvf zzbvf = this.zzb;
        if (zzbvf != null) {
            zzbvf.zzo(ObjectWrapper.wrap(this.zza));
        }
    }
}
