package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.zza;

public final class zzdni {
    private final zzcfl zza;
    private final Context zzb;
    private final zzaqs zzc;
    private final zzbco zzd;
    private final zzbzx zze;
    private final zza zzf;
    private final zzawz zzg;
    /* access modifiers changed from: private */
    public final zzcxv zzh;
    private final zzebl zzi;

    public zzdni(zzcfl zzcfl, Context context, zzaqs zzaqs, zzbco zzbco, zzbzx zzbzx, zza zza2, zzawz zzawz, zzcxv zzcxv, zzebl zzebl) {
        this.zza = zzcfl;
        this.zzb = context;
        this.zzc = zzaqs;
        this.zzd = zzbco;
        this.zze = zzbzx;
        this.zzf = zza2;
        this.zzg = zzawz;
        this.zzh = zzcxv;
        this.zzi = zzebl;
    }

    public final zzcez zza(zzq zzq, zzezn zzezn, zzezq zzezq) throws zzcfk {
        return zzcfl.zza(this.zzb, zzcgo.zzc(zzq), zzq.zza, false, false, this.zzc, this.zzd, this.zze, (zzbce) null, new zzdmx(this), this.zzf, this.zzg, zzezn, zzezq, this.zzi);
    }
}
