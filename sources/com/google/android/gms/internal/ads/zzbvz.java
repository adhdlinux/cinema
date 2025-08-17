package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzbvz {
    public static final zzbvn zza(Context context, String str, zzbnw zzbnw) {
        zzbvn zzbvl;
        try {
            IBinder zze = ((zzbvr) zzbzv.zzb(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzbvy.zza)).zze(ObjectWrapper.wrap(context), str, zzbnw, ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            if (queryLocalInterface instanceof zzbvn) {
                zzbvl = (zzbvn) queryLocalInterface;
            } else {
                zzbvl = new zzbvl(zze);
            }
            return zzbvl;
        } catch (RemoteException | zzbzu e2) {
            zzbzr.zzl("#007 Could not call remote method.", e2);
            return null;
        }
    }
}
