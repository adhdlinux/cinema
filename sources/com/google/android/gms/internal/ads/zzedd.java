package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzfl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzas;
import java.util.concurrent.Executor;

public final class zzedd implements zzecc {
    private final zzcpy zza;
    private final Context zzb;
    private final zzdni zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final zzfov zzf;

    public zzedd(zzcpy zzcpy, Context context, Executor executor, zzdni zzdni, zzfai zzfai, zzfov zzfov) {
        this.zzb = context;
        this.zza = zzcpy;
        this.zze = executor;
        this.zzc = zzdni;
        this.zzd = zzfai;
        this.zzf = zzfov;
    }

    public final zzfwm zza(zzezz zzezz, zzezn zzezn) {
        return zzfwc.zzm(zzfwc.zzh((Object) null), new zzecx(this, zzezz, zzezn), this.zze);
    }

    public final boolean zzb(zzezz zzezz, zzezn zzezn) {
        zzezs zzezs = zzezn.zzt;
        return (zzezs == null || zzezs.zza == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(zzezz zzezz, zzezn zzezn, Object obj) throws Exception {
        View view;
        zzq zza2 = zzfam.zza(this.zzb, zzezn.zzv);
        zzcez zza3 = this.zzc.zza(zza2, zzezn, zzezz.zzb.zzb);
        zza3.zzZ(zzezn.zzX);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() || !zzezn.zzah) {
            view = new zzdnl(this.zzb, (View) zza3, (zzas) this.zzf.apply(zzezn));
        } else {
            view = zzcqp.zza(this.zzb, (View) zza3, zzezn);
        }
        zzcpc zza4 = this.zza.zza(new zzcrs(zzezz, zzezn, (String) null), new zzcpi(view, zza3, new zzecy(zza3), zzfam.zzb(zza2)));
        zza4.zzh().zzi(zza3, false, (zzbil) null);
        zzcvy zzc2 = zza4.zzc();
        zzecz zzecz = new zzecz(zza3);
        zzfwn zzfwn = zzcae.zzf;
        zzc2.zzm(zzecz, zzfwn);
        zza4.zzh();
        zzezs zzezs = zzezn.zzt;
        zzfwm zzj = zzdnh.zzj(zza3, zzezs.zzb, zzezs.zza);
        if (zzezn.zzN) {
            zzj.zzc(new zzeda(zza3), this.zze);
        }
        zzj.zzc(new zzedb(this, zza3), this.zze);
        return zzfwc.zzl(zzj, new zzedc(zza4), zzfwn);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzcez zzcez) {
        zzcez.zzY();
        zzcfv zzq = zzcez.zzq();
        zzfl zzfl = this.zzd.zza;
        if (zzfl != null && zzq != null) {
            zzq.zzs(zzfl);
        }
    }
}
