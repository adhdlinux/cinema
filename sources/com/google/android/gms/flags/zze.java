package com.google.android.gms.flags;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zze extends IInterface {
    boolean getBooleanFlagValue(String str, boolean z2, int i2) throws RemoteException;

    int getIntFlagValue(String str, int i2, int i3) throws RemoteException;

    long getLongFlagValue(String str, long j2, int i2) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i2) throws RemoteException;

    void init(IObjectWrapper iObjectWrapper) throws RemoteException;
}
