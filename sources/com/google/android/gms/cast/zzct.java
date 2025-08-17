package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzct extends zzdp {
    final /* synthetic */ MediaQueueItem[] zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzct(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = mediaQueueItemArr;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzc.zzb.zzA(zzb(), 0, -1, this.zza, 0, (Boolean) null, (Integer) null, this.zzb);
    }
}
