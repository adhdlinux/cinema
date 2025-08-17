package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

public abstract class zzdvl implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzcaj zza = new zzcaj();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzbue zze;
    protected zzbte zzf;

    public void onConnectionFailed(ConnectionResult connectionResult) {
        zzbzr.zze("Disconnected from remote ad request service.");
        this.zza.zze(new zzdwa(1));
    }

    public final void onConnectionSuspended(int i2) {
        zzbzr.zze("Cannot connect to remote service, fallback to local instance.");
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        synchronized (this.zzb) {
            this.zzd = true;
            if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                this.zzf.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
