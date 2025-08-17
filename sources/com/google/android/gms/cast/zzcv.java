package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import org.json.JSONObject;

final class zzcv extends zzdp {
    final /* synthetic */ int[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcv(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int[] iArr, int i2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = iArr;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzd.zzb.zzz(zzb(), this.zza, this.zzb, this.zzc);
    }
}
