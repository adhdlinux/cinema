package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;

final class zzat extends zzbk {
    final /* synthetic */ int[] zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzat(RemoteMediaClient remoteMediaClient, boolean z2, int[] iArr) {
        super(remoteMediaClient, true);
        this.zzb = remoteMediaClient;
        this.zza = iArr;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzv(zzb(), this.zza);
    }
}
