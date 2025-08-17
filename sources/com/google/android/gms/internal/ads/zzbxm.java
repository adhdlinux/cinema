package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

public final /* synthetic */ class zzbxm implements zzbxv {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbxm(Context context, String str) {
        this.zza = context;
        this.zzb = str;
    }

    public final void zza(zzcgq zzcgq) {
        Context context = this.zza;
        zzcgq.zzs(ObjectWrapper.wrap(context), this.zzb, context.getPackageName());
    }
}
