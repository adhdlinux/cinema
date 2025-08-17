package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;

final class zzak extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzq zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ zzbnw zzd;
    final /* synthetic */ zzaw zze;

    zzak(zzaw zzaw, Context context, zzq zzq, String str, zzbnw zzbnw) {
        this.zze = zzaw;
        this.zza = context;
        this.zzb = zzq;
        this.zzc = str;
        this.zzd = zzbnw;
    }

    public final /* bridge */ /* synthetic */ Object zza() {
        zzaw.zzt(this.zza, "app_open");
        return new zzew();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzc(ObjectWrapper.wrap(this.zza), this.zzb, this.zzc, this.zzd, ModuleDescriptor.MODULE_VERSION);
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        return this.zze.zza.zza(this.zza, this.zzb, this.zzc, this.zzd, 4);
    }
}
