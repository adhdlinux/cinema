package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

final class zzao extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbnw zzc;
    final /* synthetic */ zzaw zzd;

    zzao(zzaw zzaw, Context context, String str, zzbnw zzbnw) {
        this.zzd = zzaw;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbnw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "native_ad");
        return new zzeu();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzb(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        Object zzbo;
        zzbbm.zza(this.zza);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            return this.zzd.zzb.zza(this.zza, this.zzb, this.zzc);
        }
        try {
            IBinder zze = ((zzbr) zzbzv.zzb(this.zza, "com.google.android.gms.ads.ChimeraAdLoaderBuilderCreatorImpl", zzan.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            if (queryLocalInterface instanceof zzbq) {
                zzbo = (zzbq) queryLocalInterface;
            } else {
                zzbo = new zzbo(zze);
            }
            return zzbo;
        } catch (RemoteException | zzbzu | NullPointerException e2) {
            this.zzd.zzh = zzbsw.zza(this.zza);
            this.zzd.zzh.zzf(e2, "ClientApiBroker.createAdLoaderBuilder");
            return null;
        }
    }
}
