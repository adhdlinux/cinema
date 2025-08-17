package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdd;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzbvn extends IInterface {
    Bundle zzb() throws RemoteException;

    zzdn zzc() throws RemoteException;

    zzbvk zzd() throws RemoteException;

    String zze() throws RemoteException;

    void zzf(zzl zzl, zzbvu zzbvu) throws RemoteException;

    void zzg(zzl zzl, zzbvu zzbvu) throws RemoteException;

    void zzh(boolean z2) throws RemoteException;

    void zzi(zzdd zzdd) throws RemoteException;

    void zzj(zzdg zzdg) throws RemoteException;

    void zzk(zzbvq zzbvq) throws RemoteException;

    void zzl(zzbwb zzbwb) throws RemoteException;

    void zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, boolean z2) throws RemoteException;

    boolean zzo() throws RemoteException;

    void zzp(zzbvv zzbvv) throws RemoteException;
}
