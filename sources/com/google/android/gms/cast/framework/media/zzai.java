package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzai extends zzbk {
    final /* synthetic */ MediaQueueItem[] zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzai(RemoteMediaClient remoteMediaClient, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = mediaQueueItemArr;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzc.zze.zzA(zzb(), 0, -1, this.zza, 0, (Boolean) null, (Integer) null, this.zzb);
    }
}
