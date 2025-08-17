package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.ConnectionResult;

public final class zzdvj extends zzdvl {
    public zzdvj(Context context) {
        this.zzf = new zzbte(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzg(this.zze, new zzdvk(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzdwa(1));
                } catch (Throwable th) {
                    zzt.zzo().zzu(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zze(new zzdwa(1));
                }
            }
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbzr.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zze(new zzdwa(1));
    }
}
