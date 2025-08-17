package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zza;

public final class zzb extends zza implements zzd {
    zzb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.media.IImagePicker");
    }

    public final WebImage zze(MediaMetadata mediaMetadata, int i2) throws RemoteException {
        throw null;
    }

    public final WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) throws RemoteException {
        throw null;
    }

    public final IObjectWrapper zzg() throws RemoteException {
        Parcel zzb = zzb(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzb.readStrongBinder());
        zzb.recycle();
        return asInterface;
    }
}
