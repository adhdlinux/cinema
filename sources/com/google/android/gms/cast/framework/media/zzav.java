package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.internal.zzao;

final class zzav extends zzbk {
    final /* synthetic */ MediaLoadRequestData zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzav(RemoteMediaClient remoteMediaClient, MediaLoadRequestData mediaLoadRequestData) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = mediaLoadRequestData;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzp(zzb(), this.zza);
    }
}
