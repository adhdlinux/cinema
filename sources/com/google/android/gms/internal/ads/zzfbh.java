package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public final class zzfbh {
    public static ParcelFileDescriptor zza(InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        zzcae.zza.execute(new zzfbg(inputStream, createPipe[1]));
        return parcelFileDescriptor;
    }
}
