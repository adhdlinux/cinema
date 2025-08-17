package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzdk extends zzdp {
    final /* synthetic */ RemoteMediaPlayer zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdk(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient) {
        super(remoteMediaPlayer, googleApiClient);
        this.zza = remoteMediaPlayer;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) {
        this.zza.zzb.zzB(zzb());
    }
}
