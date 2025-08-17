package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

final class zzbo extends TimerTask {
    final /* synthetic */ RemoteMediaClient zza;
    final /* synthetic */ zzbp zzb;

    zzbo(zzbp zzbp, RemoteMediaClient remoteMediaClient) {
        this.zzb = zzbp;
        this.zza = remoteMediaClient;
    }

    public final void run() {
        zzbp zzbp = this.zzb;
        zzbp.zza.zzw(zzbp.zzb);
        zzbp zzbp2 = this.zzb;
        zzbp2.zza.zzd.postDelayed(this, zzbp2.zzc);
    }
}
