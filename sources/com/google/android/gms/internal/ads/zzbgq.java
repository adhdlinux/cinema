package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzbgq extends RemoteCreator {
    public zzbgq() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegateCreator");
        if (queryLocalInterface instanceof zzbey) {
            return (zzbey) queryLocalInterface;
        }
        return new zzbew(iBinder);
    }

    public final zzbev zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        zzbev zzbet;
        try {
            IBinder zze = ((zzbey) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(frameLayout), ObjectWrapper.wrap(frameLayout2), ModuleDescriptor.MODULE_VERSION);
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
            if (queryLocalInterface instanceof zzbev) {
                zzbet = (zzbev) queryLocalInterface;
            } else {
                zzbet = new zzbet(zze);
            }
            return zzbet;
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e2) {
            zzbzr.zzk("Could not create remote NativeAdViewDelegate.", e2);
            return null;
        }
    }
}
