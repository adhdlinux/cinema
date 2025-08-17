package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;
import java.util.ArrayList;
import java.util.List;

public final class zze extends zza implements zzg {
    zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    public final IObjectWrapper zze() throws RemoteException {
        throw null;
    }

    public final List zzf() throws RemoteException {
        Parcel zzb = zzb(3, zza());
        ArrayList<NotificationAction> createTypedArrayList = zzb.createTypedArrayList(NotificationAction.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final int[] zzg() throws RemoteException {
        Parcel zzb = zzb(4, zza());
        int[] createIntArray = zzb.createIntArray();
        zzb.recycle();
        return createIntArray;
    }
}
