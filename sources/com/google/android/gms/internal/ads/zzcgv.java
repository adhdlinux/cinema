package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class zzcgv {
    /* access modifiers changed from: private */
    public zzbzx zza;
    /* access modifiers changed from: private */
    public Context zzb;
    /* access modifiers changed from: private */
    public WeakReference zzc;

    public final zzcgv zzc(Context context) {
        this.zzc = new WeakReference(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }

    public final zzcgv zzd(zzbzx zzbzx) {
        this.zza = zzbzx;
        return this;
    }
}
