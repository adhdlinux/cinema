package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.zzao;
import org.json.JSONObject;

final class zzak extends zzbk {
    final /* synthetic */ int[] zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzak(RemoteMediaClient remoteMediaClient, int[] iArr, int i2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = iArr;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        this.zzd.zze.zzz(zzb(), this.zza, this.zzb, this.zzc);
    }
}
