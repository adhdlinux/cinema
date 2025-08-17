package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzdrl implements zzdqz {
    /* access modifiers changed from: private */
    public final long zza;
    private final zzeju zzb;

    zzdrl(long j2, Context context, zzdre zzdre, zzcgu zzcgu, String str) {
        this.zza = j2;
        zzexs zzt = zzcgu.zzt();
        zzt.zzc(context);
        zzt.zza(new zzq());
        zzt.zzb(str);
        zzeju zza2 = zzt.zzd().zza();
        this.zzb = zza2;
        zza2.zzD(new zzdrk(this, zzdre));
    }

    public final void zza() {
        this.zzb.zzx();
    }

    public final void zzb(zzl zzl) {
        this.zzb.zzaa(zzl);
    }

    public final void zzc() {
        this.zzb.zzW(ObjectWrapper.wrap(null));
    }
}
