package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

abstract class zzqo extends AtomicReference implements Runnable {
    private static final Runnable zza = new zzqn((zzqm) null);
    private static final Runnable zzb = new zzqn((zzqm) null);

    zzqo() {
    }

    private final void zzg(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzql zzql = null;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (!(runnable instanceof zzql)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzql = (zzql) runnable;
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
                    LockSupport.park(zzql);
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
            boolean z2 = !zzf();
            if (z2) {
                try {
                    obj = zza();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, zza)) {
                        zzg(currentThread);
                    }
                    zzd((Object) null);
                    throw th;
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzg(currentThread);
            }
            if (z2) {
                zzd(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzql) {
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
    public abstract void zzc(Throwable th);

    /* access modifiers changed from: package-private */
    public abstract void zzd(Object obj);

    /* access modifiers changed from: package-private */
    public final void zze() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzql zzql = new zzql(this, (zzqk) null);
            zzqo.super.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzql)) {
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

    /* access modifiers changed from: package-private */
    public abstract boolean zzf();
}
