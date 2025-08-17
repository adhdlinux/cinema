package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzda extends zzdp {
    final /* synthetic */ int zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaPlayer zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzda(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzc = remoteMediaPlayer;
        this.zza = i2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        if (RemoteMediaPlayer.zza(this.zzc, this.zza) == -1) {
            setResult(new zzdo(this, new Status(0)));
            return;
        }
        this.zzc.zzb.zzy(zzb(), new int[]{this.zza}, this.zzb);
    }
}
