package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzdt;

public final class zzdgz extends zzdp {
    private final Object zza = new Object();
    private final zzdq zzb;
    private final zzbol zzc;

    public zzdgz(zzdq zzdq, zzbol zzbol) {
        this.zzb = zzdq;
        this.zzc = zzbol;
    }

    public final float zze() throws RemoteException {
        throw new RemoteException();
    }

    public final float zzf() throws RemoteException {
        zzbol zzbol = this.zzc;
        if (zzbol != null) {
            return zzbol.zzg();
        }
        return 0.0f;
    }

    public final float zzg() throws RemoteException {
        zzbol zzbol = this.zzc;
        if (zzbol != null) {
            return zzbol.zzh();
        }
        return 0.0f;
    }

    public final int zzh() throws RemoteException {
        throw new RemoteException();
    }

    public final zzdt zzi() throws RemoteException {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq == null) {
                return null;
            }
            zzdt zzi = zzdq.zzi();
            return zzi;
        }
    }

    public final void zzj(boolean z2) throws RemoteException {
        throw new RemoteException();
    }

    public final void zzk() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm(zzdt zzdt) throws RemoteException {
        synchronized (this.zza) {
            zzdq zzdq = this.zzb;
            if (zzdq != null) {
                zzdq.zzm(zzdt);
            }
        }
    }

    public final void zzn() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzo() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzp() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean zzq() throws RemoteException {
        throw new RemoteException();
    }
}
