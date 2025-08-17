package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.internal.zzao;

final class zzae extends zzbk {
    final /* synthetic */ TextTrackStyle zza;
    final /* synthetic */ RemoteMediaClient zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzae(RemoteMediaClient remoteMediaClient, TextTrackStyle textTrackStyle) {
        super(remoteMediaClient, false);
        this.zzb = remoteMediaClient;
        this.zza = textTrackStyle;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzb.zze.zzH(zzb(), this.zza);
    }
}
