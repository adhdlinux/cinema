package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzfnu extends zzatr implements zzfnv {
    public zzfnu() {
        super("com.google.android.play.core.lmd.protocol.ILmdOverlayServiceListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zzats.zzc(parcel);
        zzb((Bundle) zzats.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
