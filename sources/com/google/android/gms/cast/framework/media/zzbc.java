package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzbc extends zzbk {
    final /* synthetic */ boolean zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbc(RemoteMediaClient remoteMediaClient, boolean z2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = z2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzc.zze.zzF(zzb(), this.zza, this.zzb);
    }
}
