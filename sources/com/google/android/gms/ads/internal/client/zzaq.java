package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

final class zzaq extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzaw zzb;

    zzaq(zzaw zzaw, Context context) {
        this.zzb = zzaw;
        this.zza = context;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "mobile_ads_settings");
        return new zzey();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzg(ObjectWrapper.wrap(this.zza), ModuleDescriptor.MODULE_VERSION);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Object zzcm;
        zzbbm.zza(this.zza);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            return this.zzb.zzc.zza(this.zza);
        }
        try {
            IBinder zze = ((zzcp) zzbzv.zzb(this.zza, "com.google.android.gms.ads.ChimeraMobileAdsSettingManagerCreatorImpl", zzap.zza)).zze(ObjectWrapper.wrap(this.zza), ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            if (queryLocalInterface instanceof zzco) {
                zzcm = (zzco) queryLocalInterface;
            } else {
                zzcm = new zzcm(zze);
            }
            return zzcm;
        } catch (RemoteException | zzbzu | NullPointerException e2) {
            this.zzb.zzh = zzbsw.zza(this.zza);
            this.zzb.zzh.zzf(e2, "ClientApiBroker.getMobileAdsSettingsManager");
            return null;
        }
    }
}
