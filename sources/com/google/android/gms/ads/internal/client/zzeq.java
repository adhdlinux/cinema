package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbzr;

public final class zzeq extends RemoteCreator {
    public zzeq() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (queryLocalInterface instanceof zzcp) {
            return (zzcp) queryLocalInterface;
        }
        return new zzcp(iBinder);
    }

    public final zzco zza(Context context) {
        zzco zzcm;
        try {
            IBinder zze = ((zzcp) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ModuleDescriptor.MODULE_VERSION);
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
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbzr.zzk("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }
}
