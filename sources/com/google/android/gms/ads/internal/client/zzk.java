package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbzr;
import com.google.android.gms.internal.ads.zzbzu;
import com.google.android.gms.internal.ads.zzbzv;

public final class zzk extends RemoteCreator {
    private zzbsy zza;

    public zzk() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (queryLocalInterface instanceof zzbv) {
            return (zzbv) queryLocalInterface;
        }
        return new zzbv(iBinder);
    }

    public final zzbu zza(Context context, zzq zzq, String str, zzbnw zzbnw, int i2) {
        zzbu zzbs;
        zzbu zzbs2;
        zzbbm.zza(context);
        if (((Boolean) zzba.zzc().zzb(zzbbm.zzjo)).booleanValue()) {
            try {
                IBinder zze = ((zzbv) zzbzv.zzb(context, "com.google.android.gms.ads.ChimeraAdManagerCreatorImpl", zzj.zza)).zze(ObjectWrapper.wrap(context), zzq, str, zzbnw, ModuleDescriptor.MODULE_VERSION, i2);
                if (zze == null) {
                    return null;
                }
                IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface instanceof zzbu) {
                    zzbs2 = (zzbu) queryLocalInterface;
                } else {
                    zzbs2 = new zzbs(zze);
                }
                return zzbs2;
            } catch (RemoteException | zzbzu | NullPointerException e2) {
                zzbsy zza2 = zzbsw.zza(context);
                this.zza = zza2;
                zza2.zzf(e2, "AdManagerCreator.newAdManagerByDynamiteLoader");
                zzbzr.zzl("#007 Could not call remote method.", e2);
                return null;
            }
        } else {
            try {
                IBinder zze2 = ((zzbv) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), zzq, str, zzbnw, ModuleDescriptor.MODULE_VERSION, i2);
                if (zze2 == null) {
                    return null;
                }
                IInterface queryLocalInterface2 = zze2.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
                if (queryLocalInterface2 instanceof zzbu) {
                    zzbs = (zzbu) queryLocalInterface2;
                } else {
                    zzbs = new zzbs(zze2);
                }
                return zzbs;
            } catch (RemoteException | RemoteCreator.RemoteCreatorException e3) {
                zzbzr.zzf("Could not create remote AdManager.", e3);
                return null;
            }
        }
    }
}
