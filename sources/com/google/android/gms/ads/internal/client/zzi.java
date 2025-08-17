package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbzr;

public final class zzi extends RemoteCreator {
    public zzi() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        if (queryLocalInterface instanceof zzbr) {
            return (zzbr) queryLocalInterface;
        }
        return new zzbr(iBinder);
    }

    public final zzbq zza(Context context, String str, zzbnw zzbnw) {
        zzbq zzbo;
        try {
            IBinder zze = ((zzbr) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), str, zzbnw, ModuleDescriptor.MODULE_VERSION);
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
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbzr.zzk("Could not create remote builder for AdLoader.", e2);
            return null;
        }
    }
}
