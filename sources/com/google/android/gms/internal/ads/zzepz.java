package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzepz implements zzeqy {
    final String zza;
    private final zzfwn zzb;
    private final ScheduledExecutorService zzc;
    private final zzeii zzd;
    private final Context zze;
    private final zzfai zzf;
    private final zzeie zzg;
    private final zzdnv zzh;
    private final zzdse zzi;

    public zzepz(zzfwn zzfwn, ScheduledExecutorService scheduledExecutorService, String str, zzeii zzeii, Context context, zzfai zzfai, zzeie zzeie, zzdnv zzdnv, zzdse zzdse) {
        this.zzb = zzfwn;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzeii;
        this.zze = context;
        this.zzf = zzfai;
        this.zzg = zzeie;
        this.zzh = zzdnv;
        this.zzi = zzdse;
    }

    public static /* synthetic */ zzfwm zzc(zzepz zzepz) {
        String str;
        Bundle bundle;
        Bundle bundle2;
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjv)).booleanValue()) {
            str = zzepz.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzepz.zzf.zzf;
        }
        Map zza2 = zzepz.zzd.zza(zzepz.zza, str);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzbz)).booleanValue()) {
            bundle = zzepz.zzi.zzg();
        } else {
            bundle = new Bundle();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((zzfsf) zza2).entrySet().iterator();
        while (true) {
            Bundle bundle3 = null;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            Bundle bundle4 = zzepz.zzf.zzd.zzm;
            if (bundle4 != null) {
                bundle3 = bundle4.getBundle(str2);
            }
            arrayList.add(zzepz.zzf(str2, list, bundle3, true, true));
        }
        for (Map.Entry value : ((zzfsf) zzepz.zzd.zzb()).entrySet()) {
            zzeim zzeim = (zzeim) value.getValue();
            String str3 = zzeim.zza;
            Bundle bundle5 = zzepz.zzf.zzd.zzm;
            if (bundle5 != null) {
                bundle2 = bundle5.getBundle(str3);
            } else {
                bundle2 = null;
            }
            arrayList.add(zzepz.zzf(str3, Collections.singletonList(zzeim.zzd), bundle2, zzeim.zzb, zzeim.zzc));
        }
        return zzfwc.zzb(arrayList).zza(new zzepw(arrayList, bundle), zzepz.zzb);
    }

    private final zzfvt zzf(String str, List list, Bundle bundle, boolean z2, boolean z3) {
        zzfvt zzv = zzfvt.zzv(zzfwc.zzk(new zzepx(this, str, list, bundle, z2, z3), this.zzb));
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzbv)).booleanValue()) {
            zzv = (zzfvt) zzfwc.zzn(zzv, ((Long) zzba.zzc().zzb(zzbbm.zzbo)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzfvt) zzfwc.zze(zzv, Throwable.class, new zzepy(str), this.zzb);
    }

    private final void zzg(zzbpt zzbpt, Bundle bundle, List list, zzeil zzeil) throws RemoteException {
        zzbpt.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzeil);
    }

    public final int zza() {
        return 32;
    }

    public final zzfwm zzb() {
        return zzfwc.zzk(new zzept(this), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(String str, List list, Bundle bundle, boolean z2, boolean z3) throws Exception {
        zzbpt zzbpt;
        zzcaj zzcaj = new zzcaj();
        if (z3) {
            this.zzg.zzb(str);
            zzbpt = this.zzg.zza(str);
        } else {
            try {
                zzbpt = this.zzh.zzb(str);
            } catch (RemoteException e2) {
                zzbzr.zzh("Couldn't create RTB adapter : ", e2);
                zzbpt = null;
            }
        }
        if (zzbpt == null) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbq)).booleanValue()) {
                zzeil.zzb(str, zzcaj);
            } else {
                throw null;
            }
        } else {
            zzeil zzeil = new zzeil(str, zzbpt, zzcaj, zzt.zzB().elapsedRealtime());
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzbv)).booleanValue()) {
                this.zzc.schedule(new zzepu(zzeil), ((Long) zzba.zzc().zzb(zzbbm.zzbo)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (z2) {
                if (((Boolean) zzba.zzc().zzb(zzbbm.zzbA)).booleanValue()) {
                    this.zzb.zza(new zzepv(this, zzbpt, bundle, list, zzeil, zzcaj));
                } else {
                    zzg(zzbpt, bundle, list, zzeil);
                }
            } else {
                zzeil.zzd();
            }
        }
        return zzcaj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbpt zzbpt, Bundle bundle, List list, zzeil zzeil, zzcaj zzcaj) {
        try {
            zzg(zzbpt, bundle, list, zzeil);
        } catch (RemoteException e2) {
            zzcaj.zze(e2);
        }
    }
}
