package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdj extends zzdp {
    final /* synthetic */ boolean zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdj(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, boolean z2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = z2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzc.zzb.zzF(zzb(), this.zza, this.zzb);
    }
}
