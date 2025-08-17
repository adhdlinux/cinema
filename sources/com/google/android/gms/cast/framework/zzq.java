package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

final class zzq extends com.google.android.gms.cast.zzq {
    final /* synthetic */ CastSession zza;

    /* synthetic */ zzq(CastSession castSession, zzp zzp) {
        this.zza = castSession;
    }

    public final void zza() {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                if (castSession.zzj != null) {
                    castSession.zzj.zzp();
                }
                this.zza.zze.zzh((Bundle) null);
            } catch (RemoteException e2) {
                CastSession.zzb.d(e2, "Unable to call %s on %s.", "onConnected", zzac.class.getSimpleName());
            }
        }
    }

    public final void zzb(int i2) {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                castSession.zze.zzi(new ConnectionResult(i2));
            } catch (RemoteException e2) {
                CastSession.zzb.d(e2, "Unable to call %s on %s.", "onConnectionFailed", zzac.class.getSimpleName());
            }
        }
    }

    public final void zzc(int i2) {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                castSession.zze.zzj(i2);
            } catch (RemoteException e2) {
                CastSession.zzb.d(e2, "Unable to call %s on %s.", "onConnectionSuspended", zzac.class.getSimpleName());
            }
        }
    }

    public final void zzd(int i2) {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                castSession.zze.zzi(new ConnectionResult(i2));
            } catch (RemoteException e2) {
                CastSession.zzb.d(e2, "Unable to call %s on %s.", "onDisconnected", zzac.class.getSimpleName());
            }
        }
    }
}
