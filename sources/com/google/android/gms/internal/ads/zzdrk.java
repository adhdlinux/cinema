package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbg;
import com.google.android.gms.ads.internal.client.zze;

final class zzdrk extends zzbg {
    final /* synthetic */ zzdre zza;
    final /* synthetic */ zzdrl zzb;

    zzdrk(zzdrl zzdrl, zzdre zzdre) {
        this.zzb = zzdrl;
        this.zza = zzdre;
    }

    public final void zzc() throws RemoteException {
        this.zza.zzb(this.zzb.zza);
    }

    public final void zzd() throws RemoteException {
        this.zza.zzc(this.zzb.zza);
    }

    public final void zze(int i2) throws RemoteException {
        this.zza.zzd(this.zzb.zza, i2);
    }

    public final void zzf(zze zze) throws RemoteException {
        this.zza.zzd(this.zzb.zza, zze.zza);
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi() throws RemoteException {
        this.zza.zze(this.zzb.zza);
    }

    public final void zzj() throws RemoteException {
        this.zza.zzg(this.zzb.zza);
    }

    public final void zzk() {
    }
}
