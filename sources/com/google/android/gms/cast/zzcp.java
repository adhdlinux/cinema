package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzcp extends zzdp {
    final /* synthetic */ TextTrackStyle zza;
    final /* synthetic */ RemoteMediaPlayer zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzcp(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, TextTrackStyle textTrackStyle) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzb = remoteMediaPlayer;
        this.zza = textTrackStyle;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        this.zzb.zzb.zzH(zzb(), this.zza);
    }
}
