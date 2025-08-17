package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public final class zzbsb extends zzatr implements zzbsc {
    public static zzbsc zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (queryLocalInterface instanceof zzbsc) {
            return (zzbsc) queryLocalInterface;
        }
        return new zzbsa(iBinder);
    }
}
