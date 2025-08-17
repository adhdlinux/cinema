package com.google.android.gms.internal.ads;

import android.content.Context;

public final /* synthetic */ class zzegu implements zzdew {
    public final /* synthetic */ zzecf zza;

    public /* synthetic */ zzegu(zzecf zzecf) {
        this.zza = zzecf;
    }

    public final void zza(boolean z2, Context context, zzcvt zzcvt) {
        zzecf zzecf = this.zza;
        try {
            ((zzfbd) zzecf.zzb).zzv(z2);
            ((zzfbd) zzecf.zzb).zzA();
        } catch (zzfan e2) {
            zzbzr.zzk("Cannot show rewarded video.", e2);
            throw new zzdev(e2.getCause());
        }
    }
}
