package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzd extends IInterface {
    WebImage zze(MediaMetadata mediaMetadata, int i2) throws RemoteException;

    WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) throws RemoteException;

    IObjectWrapper zzg() throws RemoteException;
}
