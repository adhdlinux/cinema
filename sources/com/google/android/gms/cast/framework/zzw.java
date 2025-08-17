package com.google.android.gms.cast.framework;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;

public interface zzw extends IInterface {
    void zzb(int i2) throws RemoteException;

    void zzc(String str, String str2) throws RemoteException;

    void zzd(String str, LaunchOptions launchOptions) throws RemoteException;

    void zze(String str) throws RemoteException;
}
