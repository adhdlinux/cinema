package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbjq;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

final class zzai extends zzax {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzbnw zzb;
    final /* synthetic */ OnH5AdsEventListener zzc;

    zzai(zzaw zzaw, Context context, zzbnw zzbnw, OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = context;
        this.zzb = zzbnw;
        this.zzc = onH5AdsEventListener;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zza() {
        return new zzbjq();
    }

    public final /* bridge */ /* synthetic */ Object zzb(zzce zzce) throws RemoteException {
        return zzce.zzk(ObjectWrapper.wrap(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION, new zzbjd(this.zzc));
    }

    public final /* bridge */ /* synthetic */ Object zzc() throws RemoteException {
        try {
            return ((zzbjm) zzbzv.zzb(this.zza, "com.google.android.gms.ads.DynamiteH5AdsManagerCreatorImpl", zzah.zza)).zze(ObjectWrapper.wrap(this.zza), this.zzb, ModuleDescriptor.MODULE_VERSION, new zzbjd(this.zzc));
        } catch (RemoteException | zzbzu | NullPointerException unused) {
            return null;
        }
    }
}
