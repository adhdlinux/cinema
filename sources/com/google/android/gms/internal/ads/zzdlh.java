package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzdlh extends zzbgn {
    private final String zza;
    private final zzdgv zzb;
    private final zzdha zzc;
    private final zzdqa zzd;

    public zzdlh(String str, zzdgv zzdgv, zzdha zzdha, zzdqa zzdqa) {
        this.zza = str;
        this.zzb = zzdgv;
        this.zzc = zzdha;
        this.zzd = zzdqa;
    }

    public final void zzA() {
        this.zzb.zzG();
    }

    public final void zzB(Bundle bundle) throws RemoteException {
        this.zzb.zzK(bundle);
    }

    public final void zzC() {
        this.zzb.zzM();
    }

    public final void zzD(zzcs zzcs) throws RemoteException {
        this.zzb.zzN(zzcs);
    }

    public final void zzE(zzdg zzdg) throws RemoteException {
        try {
            if (!zzdg.zzf()) {
                this.zzd.zze();
            }
        } catch (RemoteException e2) {
            zzbzr.zzf("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.zzb.zzO(zzdg);
    }

    public final void zzF(zzbgl zzbgl) throws RemoteException {
        this.zzb.zzP(zzbgl);
    }

    public final boolean zzG() {
        return this.zzb.zzU();
    }

    public final boolean zzH() throws RemoteException {
        if (this.zzc.zzG().isEmpty() || this.zzc.zzk() == null) {
            return false;
        }
        return true;
    }

    public final boolean zzI(Bundle bundle) throws RemoteException {
        return this.zzb.zzX(bundle);
    }

    public final double zze() throws RemoteException {
        return this.zzc.zza();
    }

    public final Bundle zzf() throws RemoteException {
        return this.zzc.zzd();
    }

    public final zzdn zzg() throws RemoteException {
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzgA)).booleanValue()) {
            return null;
        }
        return this.zzb.zzl();
    }

    public final zzdq zzh() throws RemoteException {
        return this.zzc.zzj();
    }

    public final zzbej zzi() throws RemoteException {
        return this.zzc.zzl();
    }

    public final zzbeo zzj() throws RemoteException {
        return this.zzb.zzc().zza();
    }

    public final zzber zzk() throws RemoteException {
        return this.zzc.zzn();
    }

    public final IObjectWrapper zzl() throws RemoteException {
        return this.zzc.zzu();
    }

    public final IObjectWrapper zzm() throws RemoteException {
        return ObjectWrapper.wrap(this.zzb);
    }

    public final String zzn() throws RemoteException {
        return this.zzc.zzw();
    }

    public final String zzo() throws RemoteException {
        return this.zzc.zzx();
    }

    public final String zzp() throws RemoteException {
        return this.zzc.zzy();
    }

    public final String zzq() throws RemoteException {
        return this.zzc.zzA();
    }

    public final String zzr() throws RemoteException {
        return this.zza;
    }

    public final String zzs() throws RemoteException {
        return this.zzc.zzC();
    }

    public final String zzt() throws RemoteException {
        return this.zzc.zzD();
    }

    public final List zzu() throws RemoteException {
        return this.zzc.zzF();
    }

    public final List zzv() throws RemoteException {
        if (zzH()) {
            return this.zzc.zzG();
        }
        return Collections.emptyList();
    }

    public final void zzw() throws RemoteException {
        this.zzb.zzs();
    }

    public final void zzx() throws RemoteException {
        this.zzb.zzb();
    }

    public final void zzy(zzcw zzcw) throws RemoteException {
        this.zzb.zzB(zzcw);
    }

    public final void zzz(Bundle bundle) throws RemoteException {
        this.zzb.zzF(bundle);
    }
}
