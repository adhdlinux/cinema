package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdi extends zzdp {
    final /* synthetic */ double zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdi(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, double d2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = d2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzc.zzb.zzG(zzb(), this.zza, this.zzb);
    }
}
