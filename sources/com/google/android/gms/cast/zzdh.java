package com.google.android.gms.cast;

import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzdh extends zzdp {
    final /* synthetic */ long zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdh(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long j2, int i2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = j2;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        zzaq zzc2 = this.zzd.zzb;
        zzat zzb2 = zzb();
        MediaSeekOptions.Builder builder = new MediaSeekOptions.Builder();
        builder.setPosition(this.zza);
        builder.setResumeState(this.zzb);
        builder.setCustomData(this.zzc);
        zzc2.zzC(zzb2, builder.build());
    }
}
