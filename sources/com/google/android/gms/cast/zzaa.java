package com.google.android.gms.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.cast.zzdn;
import com.google.android.gms.internal.cast.zzds;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzaa implements RemoteCall {
    public final /* synthetic */ CastRemoteDisplayClient zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ PendingIntent zzc;
    public final /* synthetic */ CastDevice zzd;
    public final /* synthetic */ String zze;
    public final /* synthetic */ zzal zzf;

    public /* synthetic */ zzaa(CastRemoteDisplayClient castRemoteDisplayClient, int i2, zzal zzal, PendingIntent pendingIntent, CastDevice castDevice, String str) {
        this.zza = castRemoteDisplayClient;
        this.zzb = i2;
        this.zzf = zzal;
        this.zzc = pendingIntent;
        this.zzd = castDevice;
        this.zze = str;
    }

    public final void accept(Object obj, Object obj2) {
        CastRemoteDisplayClient castRemoteDisplayClient = this.zza;
        int i2 = this.zzb;
        zzal zzal = this.zzf;
        PendingIntent pendingIntent = this.zzc;
        CastDevice castDevice = this.zzd;
        String str = this.zze;
        zzdn zzdn = (zzdn) obj;
        Bundle bundle = new Bundle();
        bundle.putInt("configuration", i2);
        ((zzds) zzdn.getService()).zzh(new zzac(castRemoteDisplayClient, (TaskCompletionSource) obj2, zzdn, zzal), pendingIntent, castDevice.getDeviceId(), str, bundle);
    }
}
