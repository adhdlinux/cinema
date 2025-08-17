package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzde extends zzdp {
    final /* synthetic */ JSONObject zza;
    final /* synthetic */ RemoteMediaPlayer zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzde(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzb = remoteMediaPlayer;
        this.zza = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzw zzw) throws zzao {
        this.zzb.zzb.zzq(zzb(), this.zza);
    }
}
