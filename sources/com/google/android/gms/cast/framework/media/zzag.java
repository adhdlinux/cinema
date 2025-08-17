package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzag extends zzbk {
    final /* synthetic */ MediaQueueItem[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzag(RemoteMediaClient remoteMediaClient, MediaQueueItem[] mediaQueueItemArr, int i2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = mediaQueueItemArr;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzd.zze.zzw(zzb(), this.zza, this.zzb, 0, -1, -1, this.zzc);
    }
}
