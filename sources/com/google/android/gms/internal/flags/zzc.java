package com.google.android.gms.internal.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class zzc {
    private static final ClassLoader zza = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean z2) {
        parcel.writeInt(z2 ? 1 : 0);
    }

    public static void zzb(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder((IBinder) null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    public static boolean zzc(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
