package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;

public abstract class zzdxr implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzcaj zza = new zzcaj();
    protected boolean zzb = false;
    protected boolean zzc = false;
    protected zzbth zzd;
    protected Context zze;
    protected Looper zzf;
    protected ScheduledExecutorService zzg;

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        String format = String.format(Locale.US, "Remote ad service connection failed, cause: %d.", new Object[]{Integer.valueOf(connectionResult.getErrorCode())});
        zzbzr.zze(format);
        this.zza.zze(new zzdwa(1, format));
    }

    public void onConnectionSuspended(int i2) {
        String format = String.format(Locale.US, "Remote ad service connection suspended, cause: %d.", new Object[]{Integer.valueOf(i2)});
        zzbzr.zze(format);
        this.zza.zze(new zzdwa(1, format));
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzb() {
        if (this.zzd == null) {
            this.zzd = new zzbth(this.zze, this.zzf, this, this);
        }
        this.zzd.checkAvailabilityAndConnect();
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzc() {
        this.zzc = true;
        zzbth zzbth = this.zzd;
        if (zzbth != null) {
            if (zzbth.isConnected() || this.zzd.isConnecting()) {
                this.zzd.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}
