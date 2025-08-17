package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzdud implements Callable {
    public final /* synthetic */ zzaqs zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzdud(zzaqs zzaqs, Context context) {
        this.zza = zzaqs;
        this.zzb = context;
    }

    public final Object call() {
        zzaqs zzaqs = this.zza;
        return zzaqs.zzc().zzg(this.zzb);
    }
}
