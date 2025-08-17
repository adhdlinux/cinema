package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.internal.ads.zzbef;
import com.google.android.gms.internal.ads.zzbfp;
import com.google.android.gms.internal.ads.zzbfs;
import com.google.android.gms.internal.ads.zzbfv;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzbgf;
import com.google.android.gms.internal.ads.zzbkr;
import com.google.android.gms.internal.ads.zzbla;

public interface zzbq extends IInterface {
    zzbn zze() throws RemoteException;

    void zzf(zzbfp zzbfp) throws RemoteException;

    void zzg(zzbfs zzbfs) throws RemoteException;

    void zzh(String str, zzbfy zzbfy, zzbfv zzbfv) throws RemoteException;

    void zzi(zzbla zzbla) throws RemoteException;

    void zzj(zzbgc zzbgc, zzq zzq) throws RemoteException;

    void zzk(zzbgf zzbgf) throws RemoteException;

    void zzl(zzbh zzbh) throws RemoteException;

    void zzm(AdManagerAdViewOptions adManagerAdViewOptions) throws RemoteException;

    void zzn(zzbkr zzbkr) throws RemoteException;

    void zzo(zzbef zzbef) throws RemoteException;

    void zzp(PublisherAdViewOptions publisherAdViewOptions) throws RemoteException;

    void zzq(zzcf zzcf) throws RemoteException;
}
