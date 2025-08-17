package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzdlc extends zzbfh {
    private final String zza;
    private final zzdgv zzb;
    private final zzdha zzc;

    public zzdlc(String str, zzdgv zzdgv, zzdha zzdha) {
        this.zza = str;
        this.zzb = zzdgv;
        this.zzc = zzdha;
    }

    public final Bundle zzb() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdq zzc() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbej zzd() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzber zze() throws RemoteException {
        return this.zzc.zzo();
    }

    public final IObjectWrapper zzf() throws RemoteException {
        return this.zzc.zzu();
    }

    public final IObjectWrapper zzg() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzh() throws RemoteException {
        return this.zzc.zzw();
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

    public final List zzm() throws RemoteException {
        return this.zzc.zzF();
    }

    public final void zzn() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        this.zzb.zzF(bundle);
    }

    public final void zzp(Bundle bundle) throws RemoteException {
        this.zzb.zzK(bundle);
    }

    public final boolean zzq(Bundle bundle) throws RemoteException {
        return this.zzb.zzX(bundle);
    }
}
