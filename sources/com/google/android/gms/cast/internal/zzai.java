package com.google.android.gms.cast.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;

public interface zzai extends IInterface {
    void zzb(ApplicationMetadata applicationMetadata, String str, String str2, boolean z2) throws RemoteException;

    void zzc(int i2) throws RemoteException;

    void zzd(int i2) throws RemoteException;

    void zze(int i2) throws RemoteException;

    void zzf(zza zza) throws RemoteException;

    void zzg(int i2) throws RemoteException;

    void zzh(String str, byte[] bArr) throws RemoteException;

    void zzi(int i2) throws RemoteException;

    void zzj(zzab zzab) throws RemoteException;

    void zzk(int i2) throws RemoteException;

    void zzl(String str, long j2) throws RemoteException;

    void zzm(String str, long j2, int i2) throws RemoteException;

    void zzn(String str, double d2, boolean z2) throws RemoteException;

    void zzo(int i2) throws RemoteException;

    void zzp(String str, String str2) throws RemoteException;
}
