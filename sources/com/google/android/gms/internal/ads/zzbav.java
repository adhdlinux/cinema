package com.google.android.gms.internal.ads;

import android.os.Environment;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzbav implements Callable {
    public static final /* synthetic */ zzbav zza = new zzbav();

    private /* synthetic */ zzbav() {
    }

    public final Object call() {
        return Boolean.valueOf("mounted".equals(Environment.getExternalStorageState()));
    }
}
