package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

final class zzao extends zzbk {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzao(RemoteMediaClient remoteMediaClient, int i2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = i2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws com.google.android.gms.cast.internal.zzao {
        this.zzc.zze.zzA(zzb(), 0, -1, (MediaQueueItem[]) null, 0, (Boolean) null, Integer.valueOf(this.zza), this.zzb);
    }
}
