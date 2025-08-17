package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.ExecutionException;

public final class zzedn implements zzeci {
    private final Context zza;
    private final zzcpy zzb;
    /* access modifiers changed from: private */
    public View zzc;
    /* access modifiers changed from: private */
    public zzbof zzd;

    public zzedn(Context context, zzcpy zzcpy) {
        this.zza = context;
        this.zzb = zzcpy;
    }

    public final /* bridge */ /* synthetic */ Object zza(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan, zzefu {
        View view;
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() || !zzezn.zzah) {
            view = this.zzc;
        } else {
            try {
                view = (View) ObjectWrapper.unwrap(this.zzd.zze());
                boolean zzf = this.zzd.zzf();
                if (view == null) {
                    throw new zzfan(new Exception("BannerRtbAdapterWrapper interscrollerView should not be null"));
                } else if (zzf) {
                    try {
                        view = (View) zzfwc.zzm(zzfwc.zzh((Object) null), new zzedj(this, view, zzezn), zzcae.zze).get();
                    } catch (InterruptedException | ExecutionException e2) {
                        throw new zzfan(e2);
                    }
                }
            } catch (RemoteException e3) {
                throw new zzfan(e3);
            }
        }
        zzcpc zza2 = this.zzb.zza(new zzcrs(zzezz, zzezn, zzecf.zza), new zzcpi(view, (zzcez) null, new zzedk(zzecf), (zzezo) zzezn.zzv.get(0)));
        zza2.zzg().zza(view);
        ((zzedy) zzecf.zzc).zzc(zza2.zzi());
        return zza2.zza();
    }

    public final void zzb(zzezz zzezz, zzezn zzezn, zzecf zzecf) throws zzfan {
        try {
            ((zzbpt) zzecf.zzb).zzq(zzezn.zzaa);
            if (!((Boolean) zzba.zzc().zzb(zzbbm.zzhs)).booleanValue() || !zzezn.zzah) {
                ((zzbpt) zzecf.zzb).zzj(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzedm(this, zzecf, (zzedl) null), (zzboc) zzecf.zzc, zzezz.zza.zza.zze);
            } else {
                ((zzbpt) zzecf.zzb).zzk(zzezn.zzV, zzezn.zzw.toString(), zzezz.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzedm(this, zzecf, (zzedl) null), (zzboc) zzecf.zzc, zzezz.zza.zza.zze);
            }
        } catch (RemoteException e2) {
            throw new zzfan(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(View view, zzezn zzezn, Object obj) throws Exception {
        return zzfwc.zzh(zzcqp.zza(this.zza, view, zzezn));
    }
}
