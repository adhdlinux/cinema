package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;

final class zzad extends zzbk {
    final /* synthetic */ long[] zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzad(RemoteMediaClient remoteMediaClient, long[] jArr) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = jArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzD(zzb(), this.zza);
    }
}
