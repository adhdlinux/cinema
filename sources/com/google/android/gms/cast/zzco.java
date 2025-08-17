package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzco extends zzdp {
    final /* synthetic */ long[] zza;
    final /* synthetic */ RemoteMediaPlayer zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzco(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, long[] jArr) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzb = remoteMediaPlayer;
        this.zza = jArr;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzb.zzb.zzD(zzb(), this.zza);
    }
}
