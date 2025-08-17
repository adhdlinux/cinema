package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcvc implements zzgwe {
    private final zzcvb zza;
    private final zzgwr zzb;
    private final zzgwr zzc;
    private final zzgwr zzd;
    private final zzgwr zze;

    public zzcvc(zzcvb zzcvb, zzgwr zzgwr, zzgwr zzgwr2, zzgwr zzgwr3, zzgwr zzgwr4) {
        this.zza = zzcvb;
        this.zzb = zzgwr;
        this.zzc = zzgwr2;
        this.zzd = zzgwr3;
        this.zze = zzgwr4;
    }

    public final /* synthetic */ Object zzb() {
        String str;
        Context context = (Context) this.zzb.zzb();
        zzbzx zza2 = ((zzchm) this.zzc).zza();
        zzezn zza3 = ((zzcrt) this.zzd).zza();
        zzbwo zzbwo = new zzbwo();
        if (zza3.zzB == null) {
            return null;
        }
        zzezs zzezs = zza3.zzt;
        if (zzezs == null) {
            str = null;
        } else {
            str = zzezs.zzb;
        }
        return new zzbwn(context, zza2, zza3.zzB, str, zzbwo);
    }
}
