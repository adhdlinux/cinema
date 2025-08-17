package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfmd;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzl implements Callable {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzl(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        Uri uri = this.zza;
        zzfmd zzfmd = zzs.zza;
        zzt.zzp();
        return zzs.zzL(uri);
    }
}
