package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

public final class zzbgr extends RemoteCreator {
    public zzbgr() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        if (queryLocalInterface instanceof zzbfe) {
            return (zzbfe) queryLocalInterface;
        }
        return new zzbfc(iBinder);
    }

    public final zzbfb zza(View view, HashMap hashMap, HashMap hashMap2) {
        zzbfb zzbez;
        try {
            IBinder zze = ((zzbfe) getRemoteCreatorInstance(view.getContext())).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(hashMap), ObjectWrapper.wrap(hashMap2));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            if (queryLocalInterface instanceof zzbfb) {
                zzbez = (zzbfb) queryLocalInterface;
            } else {
                zzbez = new zzbez(zze);
            }
            return zzbez;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbzr.zzk("Could not create remote NativeAdViewHolderDelegate.", e2);
            return null;
        }
    }
}
