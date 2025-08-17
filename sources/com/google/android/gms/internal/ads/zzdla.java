package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzdla extends zzbff {
    private final String zza;
    private final zzdgv zzb;
    private final zzdha zzc;

    public zzdla(String str, zzdgv zzdgv, zzdha zzdha) {
        this.zza = str;
        this.zzb = zzdgv;
        this.zzc = zzdha;
    }

    public final double zzb() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzc() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdq zzd() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbej zze() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzber zzf() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return this.zzc.zzu();
    }

    public final IObjectWrapper zzh() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzi() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzj() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zzk() throws RemoteException {
        return this.zzc.zzA();
    }

    public final String zzl() throws RemoteException {
        return this.zza;
    }

    public final String zzm() throws RemoteException {
        return this.zzc.zzC();
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzD();
    }

    public final List zzo() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzp() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzq(Bundle bundle) throws RemoteException {
        this.zzb.zzF(bundle);
    }

    public final void zzr(Bundle bundle) throws RemoteException {
        this.zzb.zzK(bundle);
    }

    public final boolean zzs(Bundle bundle) throws RemoteException {
        return this.zzb.zzX(bundle);
    }
}
