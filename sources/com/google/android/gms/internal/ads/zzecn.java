package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.concurrent.Executor;

public final class zzecn implements zzecc {
    private final zzcop zza;
    private final Context zzb;
    private final zzdni zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzbzx zzf;
    private final zzbil zzg;
    private final boolean zzh = ((Boolean) zzba.zzc().zzb(zzbbm.zzit)).booleanValue();
    private final zzebl zzi;

    public zzecn(zzcop zzcop, Context context, Executor executor, zzdni zzdni, zzfai zzfai, zzbzx zzbzx, zzbil zzbil, zzebl zzebl) {
        this.zzb = context;
        this.zza = zzcop;
        this.zze = executor;
        this.zzc = zzdni;
        this.zzd = zzfai;
        this.zzf = zzbzx;
        this.zzg = zzbil;
        this.zzi = zzebl;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        zzdnm zzdnm = new zzdnm();
        zzfwm zzm = zzfwc.zzm(zzfwc.zzh((Object) null), new zzecl(this, zzezn, zzezz, zzdnm), this.zze);
        zzm.zzc(new zzecm(zzdnm), this.zze);
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
        zzcez zza2 = this.zzc.zza(this.zzd.zze, zzezn2, zzezz2.zzb.zzb);
        zza2.zzZ(zzezn2.zzX);
        zzdnm.zza(this.zzb, (View) zza2);
        zzcaj zzcaj = new zzcaj();
        zzcop zzcop = this.zza;
        zzcrs zzcrs = new zzcrs(zzezz2, zzezn2, (String) null);
        zzbzx zzbzx = this.zzf;
        zzfai zzfai = this.zzd;
        boolean z2 = this.zzh;
        zzbil zzbil2 = this.zzg;
        zzbil zzbil3 = zzbil2;
        zzecp zzecp = r1;
        zzcaj zzcaj2 = zzcaj;
        zzecp zzecp2 = new zzecp(zzbzx, zzcaj, zzezn, zza2, zzfai, z2, zzbil3, this.zzi);
        zzcom zza3 = zzcop.zza(zzcrs, new zzddr(zzecp, zza2), new zzcon(zzezn2.zzab));
        zzdnh zzh2 = zza3.zzh();
        if (this.zzh) {
            zzbil = this.zzg;
        } else {
            zzbil = null;
        }
        zzh2.zzi(zza2, false, zzbil);
        zzcaj2.zzd(zza3);
        zza3.zzc().zzm(new zzecj(zza2), zzcae.zzf);
        zza3.zzh();
        zzezs zzezs = zzezn2.zzt;
        return zzfwc.zzl(zzdnh.zzj(zza2, zzezs.zzb, zzezs.zza), new zzeck(this, zza2, zzezn2, zza3), this.zze);
    }
}
