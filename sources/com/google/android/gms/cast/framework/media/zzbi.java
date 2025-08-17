package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.internal.zzap;
import com.google.android.gms.cast.internal.zzat;
import com.google.android.gms.common.api.Status;
import org.json.JSONObject;

final class zzbi implements zzat {
    final /* synthetic */ zzbk zza;

    zzbi(zzbk zzbk) {
        this.zza = zzbk;
    }

    public final void zza(long j2, int i2, Object obj) {
        JSONObject jSONObject;
        MediaError mediaError = null;
        if (true != (obj instanceof zzap)) {
            obj = null;
        }
        try {
            zzbk zzbk = this.zza;
            Status status = new Status(i2);
            if (obj != null) {
                jSONObject = ((zzap) obj).zza;
            } else {
                jSONObject = null;
            }
            if (obj != null) {
                mediaError = ((zzap) obj).zzb;
            }
            zzbk.setResult(new zzbl(status, jSONObject, mediaError));
        } catch (IllegalStateException e2) {
            RemoteMediaClient.zzb.e(e2, "Result already set when calling onRequestCompleted", new Object[0]);
        }
    }

    public final void zzb(long j2) {
        try {
            zzbk zzbk = this.zza;
            zzbk.setResult(new zzbj(zzbk, new Status(2103)));
        } catch (IllegalStateException e2) {
            RemoteMediaClient.zzb.e(e2, "Result already set when calling onRequestReplaced", new Object[0]);
        }
    }
}
