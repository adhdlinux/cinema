package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzal extends zzbk {
    final /* synthetic */ JSONObject zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzal(RemoteMediaClient remoteMediaClient, boolean z2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzA(zzb(), 0, -1, (MediaQueueItem[]) null, 0, Boolean.TRUE, (Integer) null, this.zza);
    }
}
