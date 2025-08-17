package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcq extends zzdp {
    final /* synthetic */ MediaQueueItem[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ JSONObject zze;
    final /* synthetic */ RemoteMediaPlayer zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcq(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaQueueItem[] mediaQueueItemArr, int i2, int i3, long j2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzf = remoteMediaPlayer;
        this.zza = mediaQueueItemArr;
        this.zzb = i2;
        this.zzc = i3;
        this.zzd = j2;
        this.zze = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) {
        this.zzf.zzb.zzx(zzb(), this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
