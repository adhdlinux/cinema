package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzaj extends zzbk {
    final /* synthetic */ int[] zza;
    final /* synthetic */ JSONObject zzb;
    final /* synthetic */ RemoteMediaClient zzc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzaj(RemoteMediaClient remoteMediaClient, int[] iArr, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzc = remoteMediaClient;
        this.zza = iArr;
        this.zzb = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzc.zze.zzy(zzb(), this.zza, this.zzb);
    }
}
