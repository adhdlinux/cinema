package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;

final class zzau extends zzbk {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzau(RemoteMediaClient remoteMediaClient, boolean z2, int i2, int i3, int i4) {
        super(remoteMediaClient, true);
        this.zzd = remoteMediaClient;
        this.zza = i2;
        this.zzb = i3;
        this.zzc = i4;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzd.zze.zzt(zzb(), this.zza, this.zzb, this.zzc);
    }
}
