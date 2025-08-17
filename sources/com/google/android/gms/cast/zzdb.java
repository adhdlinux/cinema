package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzdb extends zzdp {
    final /* synthetic */ int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdb(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i2, long j2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i2;
        this.zzb = j2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        if (RemoteMediaPlayer.zza(this.zzd, this.zza) == -1) {
            setResult(new zzdo(this, new Status(0)));
        } else {
            this.zzd.zzb.zzA(zzb(), this.zza, this.zzb, (MediaQueueItem[]) null, 0, (Boolean) null, (Integer) null, this.zzc);
        }
    }
}
