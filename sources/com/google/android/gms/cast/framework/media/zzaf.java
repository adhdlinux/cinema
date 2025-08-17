package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

final class zzaf extends zzbk {
    final /* synthetic */ MediaQueueItem[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ JSONObject zze;
    final /* synthetic */ RemoteMediaClient zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaf(RemoteMediaClient remoteMediaClient, MediaQueueItem[] mediaQueueItemArr, int i2, int i3, long j2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzf = remoteMediaClient;
        this.zza = mediaQueueItemArr;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = j2;
        this.zze = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() {
        this.zzf.zze.zzx(zzb(), this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
