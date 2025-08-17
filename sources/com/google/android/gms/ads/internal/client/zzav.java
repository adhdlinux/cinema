package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbvz;
import com.vungle.ads.internal.Constants;

final class zzav extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbnw zzc;
    final /* synthetic */ zzaw zzd;

    zzav(zzaw zzaw, Context context, String str, zzbnw zzbnw) {
        this.zzd = zzaw;
        this.zza = context;
        this.zzb = str;
        this.zzc = zzbnw;
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, Constants.PLACEMENT_TYPE_REWARDED);
        return new zzfc();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzo(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, ModuleDescriptor.MODULE_VERSION);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return zzbvz.zza(this.zza, this.zzb, this.zzc);
    }
}
