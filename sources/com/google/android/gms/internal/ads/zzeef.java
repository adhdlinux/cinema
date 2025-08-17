package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.Executor;

public final class zzeef implements zzecc {
    private final Context zza;
    private final zzdni zzb;
    private final zzdeo zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzbzx zzf;
    private final zzbil zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zzb(zzbbm.zzit)).booleanValue();
    private final zzebl zzi;

    public zzeef(Context context, zzbzx zzbzx, zzfai zzfai, Executor executor, zzdeo zzdeo, zzdni zzdni, zzbil zzbil, zzebl zzebl) {
        this.zza = context;
        this.zzd = zzfai;
        this.zzc = zzdeo;
        this.zze = executor;
        this.zzf = zzbzx;
        this.zzb = zzdni;
        this.zzg = zzbil;
        this.zzi = zzebl;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzdnm zzdnm = new zzdnm();
        zzfwm zzm = zzfwc.zzm(zzfwc.zzh((Object) null), new zzeea(this, zzezn, zzezz, zzdnm), this.zze);
        zzm.zzc(new zzeeb(zzdnm), this.zze);
        return zzm;
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        zzezs zzezs = zzezn.zzt;
        return (zzezs == null || zzezs.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(zzezn zzezn, zzezz zzezz, zzdnm zzdnm, Object obj) throws Exception {
        zzbil zzbil;
        zzezn zzezn2 = zzezn;
        zzezz zzezz2 = zzezz;
        zzcez zza2 = this.zzb.zza(this.zzd.zze, zzezn2, zzezz2.zzb.zzb);
        zza2.zzZ(zzezn2.zzX);
        zzdnm.zza(this.zza, (View) zza2);
        zzcaj zzcaj = new zzcaj();
        zzdeo zzdeo = this.zzc;
        zzcrs zzcrs = new zzcrs(zzezz2, zzezn2, (String) null);
        Context context = this.zza;
        zzbzx zzbzx = this.zzf;
        zzfai zzfai = this.zzd;
        boolean z2 = this.zzh;
        boolean z3 = z2;
        zzeee zzeee = r1;
        zzeee zzeee2 = new zzeee(context, zzbzx, zzcaj, zzezn, zza2, zzfai, z3, this.zzg, this.zzi);
        zzddo zze2 = zzdeo.zze(zzcrs, new zzddr(zzeee, zza2));
        zzcaj.zzd(zze2);
        zze2.zzc().zzm(new zzeec(zza2), zzcae.zzf);
        zzdnh zzk = zze2.zzk();
        if (this.zzh) {
            zzbil = this.zzg;
        } else {
            zzbil = null;
        }
        zzk.zzi(zza2, true, zzbil);
        zze2.zzk();
        zzezn zzezn3 = zzezn;
        zzezs zzezs = zzezn3.zzt;
        return zzfwc.zzl(zzdnh.zzj(zza2, zzezs.zzb, zzezs.zza), new zzeed(this, zza2, zzezn3, zze2), this.zze);
    }
}
