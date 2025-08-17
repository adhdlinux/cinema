package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.internal.zzao;

final class zzba extends zzbk {
    final /* synthetic */ MediaSeekOptions zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzba(RemoteMediaClient remoteMediaClient, MediaSeekOptions mediaSeekOptions) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = mediaSeekOptions;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzC(zzb(), this.zza);
    }
}
