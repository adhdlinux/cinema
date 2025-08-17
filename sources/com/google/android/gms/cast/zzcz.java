package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcz extends zzdp {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcz(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzc.zzb.zzA(zzb(), 0, -1, (MediaQueueItem[]) null, 0, (Boolean) null, Integer.valueOf(this.zza), this.zzb);
    }
}
