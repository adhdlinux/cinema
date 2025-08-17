package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdf extends zzdp {
    final /* synthetic */ JSONObject zza;
    final /* synthetic */ RemoteMediaPlayer zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdf(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzb = remoteMediaPlayer;
        this.zza = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzb.zzb.zzJ(zzb(), this.zza);
    }
}
