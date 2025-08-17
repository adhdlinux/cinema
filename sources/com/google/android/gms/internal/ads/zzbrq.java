package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzbrq extends RemoteCreator {
    public zzbrq() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzbrw) {
            return (zzbrw) queryLocalInterface;
        }
        return new zzbru(iBinder);
    }

    public final zzbrt zza(Activity activity) {
        zzbrt zzbrr;
        try {
            IBinder zze = ((zzbrw) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzbrt) {
                zzbrr = (zzbrt) queryLocalInterface;
            } else {
                zzbrr = new zzbrr(zze);
            }
            return zzbrr;
        } catch (RemoteException e2) {
            zzbzr.zzk("Could not create remote AdOverlay.", e2);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e3) {
            zzbzr.zzk("Could not create remote AdOverlay.", e3);
            return null;
        }
    }
}
