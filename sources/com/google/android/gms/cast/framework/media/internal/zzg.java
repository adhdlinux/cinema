package com.google.android.gms.cast.framework.media.internal;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

public final class zzg extends zza implements zzi {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
    }

    public final Bitmap zze(Uri uri) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, uri);
        Parcel zzb = zzb(1, zza);
        Bitmap bitmap = (Bitmap) zzc.zza(zzb, Bitmap.CREATOR);
        zzb.recycle();
        return bitmap;
    }
}
