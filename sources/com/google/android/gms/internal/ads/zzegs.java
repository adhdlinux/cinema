package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.Executor;

public final class zzegs implements zzecc {
    private final Context zza;
    private final zzdni zzb;
    private final zzdmr zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzbzx zzf;
    private final zzbil zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zzb(zzbbm.zzit)).booleanValue();
    private final zzebl zzi;

    public zzegs(Context context, zzbzx zzbzx, zzfai zzfai, Executor executor, zzdmr zzdmr, zzdni zzdni, zzbil zzbil, zzebl zzebl) {
        this.zza = context;
        this.zzd = zzfai;
        this.zzc = zzdmr;
        this.zze = executor;
        this.zzf = zzbzx;
        this.zzb = zzdni;
        this.zzg = zzbil;
        this.zzi = zzebl;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzdnm zzdnm = new zzdnm();
        zzfwm zzm = zzfwc.zzm(zzfwc.zzh((Object) null), new zzegl(this, zzezn, zzezz, zzdnm), this.zze);
        zzm.zzc(new zzegm(zzdnm), this.zze);
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
        zzdmr zzdmr = this.zzc;
        zzcrs zzcrs = new zzcrs(zzezz2, zzezn2, (String) null);
        zzegr zzegr = r1;
        zzegr zzegr2 = new zzegr(this.zza, this.zzb, this.zzd, this.zzf, zzezn, zzcaj, zza2, this.zzg, this.zzh, this.zzi);
        zzdmn zze2 = zzdmr.zze(zzcrs, new zzdmo(zzegr, zza2));
        zzcaj.zzd(zze2);
        zzbiz.zzb(zza2, zze2.zzg());
        zze2.zzc().zzm(new zzegn(zza2), zzcae.zzf);
        zzdnh zzl = zze2.zzl();
        if (this.zzh) {
            zzbil = this.zzg;
        } else {
            zzbil = null;
        }
        zzl.zzi(zza2, true, zzbil);
        zze2.zzl();
        zzezn zzezn3 = zzezn;
        zzezs zzezs = zzezn3.zzt;
        return zzfwc.zzl(zzdnh.zzj(zza2, zzezs.zzb, zzezs.zza), new zzego(this, zza2, zzezn3, zze2), this.zze);
    }
}
