package com.google.android.gms.internal.cast;

import android.content.Context;
import androidx.mediarouter.media.MediaRouter;

public final class zzax {
    public MediaRouter zza;
    private final Context zzb;

    zzax(Context context) {
        this.zzb = context;
    }

    public final MediaRouter zza() {
        if (this.zza == null) {
            this.zza = MediaRouter.j(this.zzb);
        }
        return this.zza;
    }

    public final void zzb(MediaRouter.Callback callback) {
        MediaRouter zza2 = zza();
        if (zza2 != null) {
            zza2.s(callback);
        }
    }
}
