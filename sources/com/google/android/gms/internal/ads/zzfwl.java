package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

abstract class zzfwl extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzfwk((zzfwj) null);
    private static final Runnable zzb = new zzfwk((zzfwj) null);

    zzfwl() {
    }

    private final void zzc(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzfwi zzfwi = null;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!(runnable instanceof zzfwi)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzfwi = (zzfwi) runnable;
            }
            i2++;
            if (i2 > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    if (Thread.interrupted() || z2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    LockSupport.park(zzfwi);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z2) {
            thread.interrupt();
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z2 = !zzg();
            if (z2) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zza)) {
                        zzc(currentThread);
                    }
                    zze((Object) null);
                    throw th;
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzc(currentThread);
            }
            if (z2) {
                zze(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzfwi) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            str = "running=[RUNNING ON " + ((Thread) runnable).getName() + "]";
        } else {
            str = "running=[NOT STARTED YET]";
        }
        return str + ", " + zzb();
    }

    /* access modifiers changed from: package-private */
    public abstract Object zza() throws Exception;

    /* access modifiers changed from: package-private */
    public abstract String zzb();

    /* access modifiers changed from: package-private */
    public abstract void zzd(Throwable th);

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj);

    /* access modifiers changed from: package-private */
    public abstract boolean zzg();

    /* access modifiers changed from: package-private */
    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzfwi zzfwi = new zzfwi(this, (zzfwh) null);
            zzfwl.super.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzfwi)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th;
                }
            }
        }
    }
}
