package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzavt extends IInterface {
    zzbu zze() throws RemoteException;

    zzdn zzf() throws RemoteException;

    void zzg(boolean z2) throws RemoteException;

    void zzh(zzdg zzdg) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, zzawa zzawa) throws RemoteException;
}
