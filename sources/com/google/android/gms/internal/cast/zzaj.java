package com.google.android.gms.internal.cast;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.media.internal.zzi;
import com.google.android.gms.cast.framework.media.internal.zzk;
import com.google.android.gms.cast.framework.zzac;
import com.google.android.gms.cast.framework.zzam;
import com.google.android.gms.cast.framework.zzau;
import com.google.android.gms.cast.framework.zzw;
import com.google.android.gms.cast.framework.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;

public interface zzaj extends IInterface {
    zzz zze(IObjectWrapper iObjectWrapper, CastOptions castOptions, zzal zzal, Map map) throws RemoteException;

    zzac zzf(CastOptions castOptions, IObjectWrapper iObjectWrapper, zzw zzw) throws RemoteException;

    com.google.android.gms.cast.framework.zzaj zzg(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException;

    zzam zzh(String str, String str2, zzau zzau) throws RemoteException;

    zzi zzi(IObjectWrapper iObjectWrapper, zzk zzk, int i2, int i3, boolean z2, long j2, int i4, int i5, int i6) throws RemoteException;
}
