package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public final class zzfwc extends zzfwe {
    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfwb zza(java.lang.Iterable r3) {
        /*
            com.google.android.gms.internal.ads.zzfwb r0 = new com.google.android.gms.internal.ads.zzfwb
            com.google.android.gms.internal.ads.zzfsc r3 = com.google.android.gms.internal.ads.zzfsc.zzj(r3)
            r1 = 0
            r2 = 0
            r0.<init>(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwc.zza(java.lang.Iterable):com.google.android.gms.internal.ads.zzfwb");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Object, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfwb zzb(java.lang.Iterable r3) {
        /*
            com.google.android.gms.internal.ads.zzfwb r0 = new com.google.android.gms.internal.ads.zzfwb
            int r1 = com.google.android.gms.internal.ads.zzfsc.zzd
            r3.getClass()
            com.google.android.gms.internal.ads.zzfsc r3 = com.google.android.gms.internal.ads.zzfsc.zzj(r3)
            r1 = 0
            r2 = 1
            r0.<init>(r2, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwc.zzb(java.lang.Iterable):com.google.android.gms.internal.ads.zzfwb");
    }

    @SafeVarargs
    public static zzfwb zzc(zzfwm... zzfwmArr) {
        return new zzfwb(true, zzfsc.zzk(zzfwmArr), (zzfwa) null);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.util.Collection, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzfwm zzd(java.lang.Iterable r2) {
        /*
            com.google.android.gms.internal.ads.zzfvk r0 = new com.google.android.gms.internal.ads.zzfvk
            com.google.android.gms.internal.ads.zzfsc r2 = com.google.android.gms.internal.ads.zzfsc.zzj(r2)
            r1 = 1
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwc.zzd(java.lang.Iterable):com.google.android.gms.internal.ads.zzfwm");
    }

    public static zzfwm zze(zzfwm zzfwm, Class cls, zzfov zzfov, Executor executor) {
        zzfun zzfun = new zzfun(zzfwm, cls, zzfov);
        zzfwm.zzc(zzfun, zzfwt.zzc(executor, zzfun));
        return zzfun;
    }

    public static zzfwm zzf(zzfwm zzfwm, Class cls, zzfvj zzfvj, Executor executor) {
        zzfum zzfum = new zzfum(zzfwm, cls, zzfvj);
        zzfwm.zzc(zzfum, zzfwt.zzc(executor, zzfum));
        return zzfum;
    }

    public static zzfwm zzg(Throwable th) {
        th.getClass();
        return new zzfwf(th);
    }

    public static zzfwm zzh(Object obj) {
        if (obj == null) {
            return zzfwg.zza;
        }
        return new zzfwg(obj);
    }

    public static zzfwm zzi() {
        return zzfwg.zza;
    }

    public static zzfwm zzj(Callable callable, Executor executor) {
        zzfxc zzfxc = new zzfxc(callable);
        executor.execute(zzfxc);
        return zzfxc;
    }

    public static zzfwm zzk(zzfvi zzfvi, Executor executor) {
        zzfxc zzfxc = new zzfxc(zzfvi);
        executor.execute(zzfxc);
        return zzfxc;
    }

    public static zzfwm zzl(zzfwm zzfwm, zzfov zzfov, Executor executor) {
        zzfux zzfux = new zzfux(zzfwm, zzfov);
        zzfwm.zzc(zzfux, zzfwt.zzc(executor, zzfux));
        return zzfux;
    }

    public static zzfwm zzm(zzfwm zzfwm, zzfvj zzfvj, Executor executor) {
        int i2 = zzfuy.zzc;
        executor.getClass();
        zzfuw zzfuw = new zzfuw(zzfwm, zzfvj);
        zzfwm.zzc(zzfuw, zzfwt.zzc(executor, zzfuw));
        return zzfuw;
    }

    public static zzfwm zzn(zzfwm zzfwm, long j2, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzfwm.isDone()) {
            return zzfwm;
        }
        return zzfwz.zzg(zzfwm, j2, timeUnit, scheduledExecutorService);
    }

    public static Object zzo(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzfxe.zza(future);
        }
        throw new IllegalStateException(zzfpw.zzb("Future was expected to be done: %s", future));
    }

    public static Object zzp(Future future) {
        try {
            return zzfxe.zza(future);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof Error) {
                throw new zzfvr((Error) cause);
            }
            throw new zzfxd(cause);
        }
    }

    public static void zzq(zzfwm zzfwm, zzfvy zzfvy, Executor executor) {
        zzfvy.getClass();
        zzfwm.zzc(new zzfvz(zzfwm, zzfvy), executor);
    }
}
