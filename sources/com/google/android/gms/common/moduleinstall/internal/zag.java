package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.moduleinstall.ModuleInstallStatusUpdate;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;

public abstract class zag extends zab implements zah {
    public zag() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallStatusListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zaa(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 != 1) {
            return false;
        }
        zac.zab(parcel);
        zab((ModuleInstallStatusUpdate) zac.zaa(parcel, ModuleInstallStatusUpdate.CREATOR));
        return true;
    }
}
