package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

final class zzag extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbnw zzb;

    zzag(zzaw zzaw, Context context, zzbnw zzbnw) {
        this.zza = context;
        this.zzb = zzbnw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzl(ObjectWrapper.wrap(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbrp) zzbzv.zzb(this.zza, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzaf.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION);
        } catch (RemoteException | zzbzu | NullPointerException unused) {
            return null;
        }
    }
}
