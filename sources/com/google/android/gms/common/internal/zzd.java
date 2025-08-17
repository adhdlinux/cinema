package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzd extends zzac {
    private BaseGmsClient zza;
    private final int zzb;

    public zzd(BaseGmsClient baseGmsClient, int i2) {
        this.zza = baseGmsClient;
        this.zzb = i2;
    }

    public final void onPostInitComplete(int i2, IBinder iBinder, Bundle bundle) {
        Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zza.onPostInitHandler(i2, iBinder, bundle, this.zzb);
        this.zza = null;
    }

    public final void zzb(int i2, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    public final void zzc(int i2, IBinder iBinder, zzk zzk) {
        BaseGmsClient baseGmsClient = this.zza;
        Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        Preconditions.checkNotNull(zzk);
        BaseGmsClient.zzj(baseGmsClient, zzk);
        onPostInitComplete(i2, iBinder, zzk.zza);
    }
}
