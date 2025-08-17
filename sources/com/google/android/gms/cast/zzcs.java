package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcs extends zzdp {
    final /* synthetic */ MediaQueueItem zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ JSONObject zzd;
    final /* synthetic */ RemoteMediaPlayer zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcs(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaQueueItem mediaQueueItem, int i2, long j2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zze = remoteMediaPlayer;
        this.zza = mediaQueueItem;
        this.zzb = i2;
        this.zzc = j2;
        this.zzd = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zze.zzb.zzw(zzb(), new MediaQueueItem[]{this.zza}, this.zzb, 0, 0, this.zzc, this.zzd);
    }
}
