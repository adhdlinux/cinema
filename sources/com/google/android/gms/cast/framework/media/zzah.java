package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzah extends zzbk {
    final /* synthetic */ MediaQueueItem zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ JSONObject zzd;
    final /* synthetic */ RemoteMediaClient zze;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzah(RemoteMediaClient remoteMediaClient, MediaQueueItem mediaQueueItem, int i2, long j2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zze = remoteMediaClient;
        this.zza = mediaQueueItem;
        this.zzb = i2;
        this.zzc = j2;
        this.zzd = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zze.zze.zzw(zzb(), new MediaQueueItem[]{this.zza}, this.zzb, 0, 0, this.zzc, this.zzd);
    }
}
