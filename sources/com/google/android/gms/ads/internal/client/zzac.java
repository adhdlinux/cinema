package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

final class zzac extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbnw zzb;

    zzac(zzaw zzaw, Context context, zzbnw zzbnw) {
        this.zza = context;
        this.zzb = zzbnw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "out_of_context_tester");
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zza);
        zzbbm.zza(this.zza);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zziR)).booleanValue()) {
            return zzce.zzh(wrap, this.zzb, ModuleDescriptor.MODULE_VERSION);
        }
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zza);
        zzbbm.zza(this.zza);
        if (!((Boolean) zzba.zzc().zzb(zzbbm.zziR)).booleanValue()) {
            return null;
        }
        try {
            return ((zzdk) zzbzv.zzb(this.zza, "com.google.android.gms.ads.DynamiteOutOfContextTesterCreatorImpl", zzab.zza)).zze(wrap, this.zzb, ModuleDescriptor.MODULE_VERSION);
        } catch (RemoteException | zzbzu | NullPointerException e2) {
            zzbsw.zza(this.zza).zzf(e2, "ClientApiBroker.getOutOfContextTester");
            return null;
        }
    }
}
