package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

public final /* synthetic */ class zzfi implements ThreadFactory {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzfi(String str) {
        this.zza = str;
    }

    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.zza);
    }
}
