package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.p001authapi.zbb;

public abstract class zbo extends zbb implements zbp {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* access modifiers changed from: protected */
    public final boolean zba(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        if (i2 == 1) {
            zbc();
        } else if (i2 != 2) {
            return false;
        } else {
            zbb();
        }
        return true;
    }
}
