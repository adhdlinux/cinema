package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzatr;
import com.google.android.gms.internal.ads.zzats;

public abstract class zzds extends zzatr implements zzdt {
    public zzds() {
        super("com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbE(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zzi();
        } else if (i2 == 2) {
            zzh();
        } else if (i2 == 3) {
            zzg();
        } else if (i2 == 4) {
            zze();
        } else if (i2 != 5) {
            return false;
        } else {
            boolean zzg = zzats.zzg(parcel);
            zzats.zzc(parcel);
            zzf(zzg);
        }
        parcel2.writeNoException();
        return true;
    }
}
