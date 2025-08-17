package com.google.android.gms.internal.ads;

import android.content.Context;

public final /* synthetic */ class zzegb implements zzdew {
    public final /* synthetic */ zzecf zza;

    public /* synthetic */ zzegb(zzecf zzecf) {
        this.zza = zzecf;
    }

    public final void zza(boolean z2, Context context, zzcvt zzcvt) {
        zzecf zzecf = this.zza;
        try {
            ((zzfbd) zzecf.zzb).zzv(z2);
            ((zzfbd) zzecf.zzb).zzz(context);
        } catch (zzfan e2) {
            throw new zzdev(e2.getCause());
        }
    }
}
