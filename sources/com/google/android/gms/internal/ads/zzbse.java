package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class zzbse extends zzatr implements zzbsf {
    public static zzbsf zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IPlayStorePurchaseListener");
        if (queryLocalInterface instanceof zzbsf) {
            return (zzbsf) queryLocalInterface;
        }
        return new zzbsd(iBinder);
    }
}
