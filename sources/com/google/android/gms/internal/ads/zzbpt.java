package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzbpt extends IInterface {
    zzdq zze() throws RemoteException;

    zzbqh zzf() throws RemoteException;

    zzbqh zzg() throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbpw zzbpw) throws RemoteException;

    void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpe zzbpe, zzboc zzboc) throws RemoteException;

    void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbph zzbph, zzboc zzboc, zzq zzq) throws RemoteException;

    void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbph zzbph, zzboc zzboc, zzq zzq) throws RemoteException;

    void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpk zzbpk, zzboc zzboc) throws RemoteException;

    void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpn zzbpn, zzboc zzboc) throws RemoteException;

    void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpn zzbpn, zzboc zzboc, zzbef zzbef) throws RemoteException;

    void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpq zzbpq, zzboc zzboc) throws RemoteException;

    void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbpq zzbpq, zzboc zzboc) throws RemoteException;

    void zzq(String str) throws RemoteException;

    boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
