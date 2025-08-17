package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzcfi implements zzfvi {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ zzaqs zzb;
    public final /* synthetic */ zzbzx zzc;
    public final /* synthetic */ zza zzd;
    public final /* synthetic */ zzebl zze;
    public final /* synthetic */ String zzf;

    public /* synthetic */ zzcfi(Context context, zzaqs zzaqs, zzbzx zzbzx, zza zza2, zzebl zzebl, String str) {
        this.zza = context;
        this.zzb = zzaqs;
        this.zzc = zzbzx;
        this.zzd = zza2;
        this.zze = zzebl;
        this.zzf = str;
    }

    public final zzfwm zza() {
        Context context = this.zza;
        zzaqs zzaqs = this.zzb;
        zzbzx zzbzx = this.zzc;
        zza zza2 = this.zzd;
        zzebl zzebl = this.zze;
        String str = this.zzf;
        zzt.zzz();
        zzcez zza3 = zzcfl.zza(context, zzcgo.zza(), "", false, false, zzaqs, (zzbco) null, zzbzx, (zzbce) null, (zzl) null, zza2, zzawz.zza(), (zzezn) null, (zzezq) null, zzebl);
        zzcai zza4 = zzcai.zza(zza3);
        zza3.zzN().zzA(new zzcfj(zza4));
        zza3.loadUrl(str);
        return zza4;
    }
}
