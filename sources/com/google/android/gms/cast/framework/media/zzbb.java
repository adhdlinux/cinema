package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzbb extends zzbk {
    final /* synthetic */ double zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbb(RemoteMediaClient remoteMediaClient, double d2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = d2;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzc.zze.zzG(zzb(), this.zza, this.zzb);
    }
}
