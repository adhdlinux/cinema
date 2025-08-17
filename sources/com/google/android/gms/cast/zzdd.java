package com.google.android.gms.cast;

import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdd extends zzdp {
    final /* synthetic */ MediaInfo zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ long[] zzd;
    final /* synthetic */ JSONObject zze;
    final /* synthetic */ RemoteMediaPlayer zzf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdd(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, MediaInfo mediaInfo, boolean z2, long j2, long[] jArr, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzf = remoteMediaPlayer;
        this.zza = mediaInfo;
        this.zzb = z2;
        this.zzc = j2;
        this.zzd = jArr;
        this.zze = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) {
        synchronized (this.zzf.zza) {
            zzaq zzc2 = this.zzf.zzb;
            zzat zzb2 = zzb();
            MediaLoadRequestData.Builder builder = new MediaLoadRequestData.Builder();
            builder.setMediaInfo(this.zza);
            builder.setAutoplay(Boolean.valueOf(this.zzb));
            builder.setCurrentTime(this.zzc);
            builder.setActiveTrackIds(this.zzd);
            builder.setCustomData(this.zze);
            zzc2.zzp(zzb2, builder.build());
        }
    }
}
