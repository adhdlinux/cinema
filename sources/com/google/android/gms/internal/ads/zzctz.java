package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzas;

public final /* synthetic */ class zzctz implements zzfov {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzbzx zzb;
    public final /* synthetic */ zzfai zzc;

    public /* synthetic */ zzctz(Context context, zzbzx zzbzx, zzfai zzfai) {
        this.zza = context;
        this.zzb = zzbzx;
        this.zzc = zzfai;
    }

    public final Object apply(Object obj) {
        Context context = this.zza;
        zzbzx zzbzx = this.zzb;
        zzfai zzfai = this.zzc;
        zzezn zzezn = (zzezn) obj;
        zzas zzas = new zzas(context);
        zzas.zzp(zzezn.zzC);
        zzas.zzq(zzezn.zzD.toString());
        zzas.zzo(zzbzx.zza);
        zzas.zzn(zzfai.zzf);
        return zzas;
    }
}
