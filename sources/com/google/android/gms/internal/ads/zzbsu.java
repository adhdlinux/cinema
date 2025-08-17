package com.google.android.gms.internal.ads;

import java.lang.Thread;

final class zzbsu implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ Thread.UncaughtExceptionHandler zza;
    final /* synthetic */ zzbsw zzb;

    zzbsu(zzbsw zzbsw, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzb = zzbsw;
        this.zza = uncaughtExceptionHandler;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            this.zzb.zze(thread, th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.zza;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.zza;
            if (uncaughtExceptionHandler2 != null) {
                uncaughtExceptionHandler2.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
