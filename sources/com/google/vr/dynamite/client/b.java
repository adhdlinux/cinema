package com.google.vr.dynamite.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.ar.core.dependencies.c;

public final class b extends c implements INativeLibraryLoader {
    b(IBinder iBinder) {
        super(iBinder, "com.google.vr.dynamite.client.INativeLibraryLoader");
    }

    public final int checkVersion(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel b2 = b(2, a2);
        int readInt = b2.readInt();
        b2.recycle();
        return readInt;
    }

    public final long initializeAndLoadNativeLibrary(String str) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        Parcel b2 = b(1, a2);
        long readLong = b2.readLong();
        b2.recycle();
        return readLong;
    }
}
