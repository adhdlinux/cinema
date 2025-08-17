package com.google.android.gms.internal.ads;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public abstract class zzfuq<V> extends zzfxf implements zzfwm<V> {
    private static final Logger zzaZ;
    /* access modifiers changed from: private */
    public static final zza zzba;
    private static final Object zzbd = new Object();
    static final boolean zzd;
    /* access modifiers changed from: private */
    public volatile zzd listeners;
    /* access modifiers changed from: private */
    public volatile Object value;
    /* access modifiers changed from: private */
    public volatile zzk waiters;

    abstract class zza {
        /* synthetic */ zza(zzfup zzfup) {
        }

        /* access modifiers changed from: package-private */
        public abstract zzd zza(zzfuq zzfuq, zzd zzd);

        /* access modifiers changed from: package-private */
        public abstract zzk zzb(zzfuq zzfuq, zzk zzk);

        /* access modifiers changed from: package-private */
        public abstract void zzc(zzk zzk, zzk zzk2);

        /* access modifiers changed from: package-private */
        public abstract void zzd(zzk zzk, Thread thread);

        /* access modifiers changed from: package-private */
        public abstract boolean zze(zzfuq zzfuq, zzd zzd, zzd zzd2);

        /* access modifiers changed from: package-private */
        public abstract boolean zzf(zzfuq zzfuq, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean zzg(zzfuq zzfuq, zzk zzk, zzk zzk2);
    }

    final class zzb {
        static final zzb zza;
        static final zzb zzb;
        final boolean zzc;
        final Throwable zzd;

        static {
            if (zzfuq.zzd) {
                zzb = null;
                zza = null;
                return;
            }
            zzb = new zzb(false, (Throwable) null);
            zza = new zzb(true, (Throwable) null);
        }

        zzb(boolean z2, Throwable th) {
            this.zzc = z2;
            this.zzd = th;
        }
    }

    final class zzc {
        static final zzc zza = new zzc(new Throwable("Failure occurred while trying to finish a future.") {
            public final synchronized Throwable fillInStackTrace() {
                return this;
            }
        });
        final Throwable zzb;

        zzc(Throwable th) {
            th.getClass();
            this.zzb = th;
        }
    }

    final class zzd {
        static final zzd zza = new zzd();
        zzd next;
        final Runnable zzb;
        final Executor zzc;

        zzd() {
            this.zzb = null;
            this.zzc = null;
        }

        zzd(Runnable runnable, Executor executor) {
            this.zzb = runnable;
            this.zzc = executor;
        }
    }

    final class zze extends zza {
        final AtomicReferenceFieldUpdater<zzk, Thread> zza;
        final AtomicReferenceFieldUpdater<zzk, zzk> zzb;
        final AtomicReferenceFieldUpdater<zzfuq, zzk> zzc;
        final AtomicReferenceFieldUpdater<zzfuq, zzd> zzd;
        final AtomicReferenceFieldUpdater<zzfuq, Object> zze;

        zze(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super((zzfup) null);
            this.zza = atomicReferenceFieldUpdater;
            this.zzb = atomicReferenceFieldUpdater2;
            this.zzc = atomicReferenceFieldUpdater3;
            this.zzd = atomicReferenceFieldUpdater4;
            this.zze = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public final zzd zza(zzfuq zzfuq, zzd zzd2) {
            return this.zzd.getAndSet(zzfuq, zzd2);
        }

        /* access modifiers changed from: package-private */
        public final zzk zzb(zzfuq zzfuq, zzk zzk) {
            return this.zzc.getAndSet(zzfuq, zzk);
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzk zzk, zzk zzk2) {
            this.zzb.lazySet(zzk, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zzd(zzk zzk, Thread thread) {
            this.zza.lazySet(zzk, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzfuq zzfuq, zzd zzd2, zzd zzd3) {
            return zzfur.zza(this.zzd, zzfuq, zzd2, zzd3);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzf(zzfuq zzfuq, Object obj, Object obj2) {
            return zzfur.zza(this.zze, zzfuq, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzg(zzfuq zzfuq, zzk zzk, zzk zzk2) {
            return zzfur.zza(this.zzc, zzfuq, zzk, zzk2);
        }
    }

    final class zzf<V> implements Runnable {
        final zzfuq<V> zza;
        final zzfwm<? extends V> zzb;

        zzf(zzfuq zzfuq, zzfwm zzfwm) {
            this.zza = zzfuq;
            this.zzb = zzfwm;
        }

        public final void run() {
            if (this.zza.value == this) {
                if (zzfuq.zzba.zzf(this.zza, this, zzfuq.zzf(this.zzb))) {
                    zzfuq.zzy(this.zza, false);
                }
            }
        }
    }

    final class zzg extends zza {
        private zzg() {
            super((zzfup) null);
        }

        /* synthetic */ zzg(zzfus zzfus) {
            super((zzfup) null);
        }

        /* access modifiers changed from: package-private */
        public final zzd zza(zzfuq zzfuq, zzd zzd) {
            zzd zzi;
            synchronized (zzfuq) {
                zzi = zzfuq.listeners;
                if (zzi != zzd) {
                    zzfuq.listeners = zzd;
                }
            }
            return zzi;
        }

        /* access modifiers changed from: package-private */
        public final zzk zzb(zzfuq zzfuq, zzk zzk) {
            zzk zzj;
            synchronized (zzfuq) {
                zzj = zzfuq.waiters;
                if (zzj != zzk) {
                    zzfuq.waiters = zzk;
                }
            }
            return zzj;
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzk zzk, zzk zzk2) {
            zzk.next = zzk2;
        }

        /* access modifiers changed from: package-private */
        public final void zzd(zzk zzk, Thread thread) {
            zzk.thread = thread;
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzfuq zzfuq, zzd zzd, zzd zzd2) {
            synchronized (zzfuq) {
                if (zzfuq.listeners != zzd) {
                    return false;
                }
                zzfuq.listeners = zzd2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zzf(zzfuq zzfuq, Object obj, Object obj2) {
            synchronized (zzfuq) {
                if (zzfuq.value != obj) {
                    return false;
                }
                zzfuq.value = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean zzg(zzfuq zzfuq, zzk zzk, zzk zzk2) {
            synchronized (zzfuq) {
                if (zzfuq.waiters != zzk) {
                    return false;
                }
                zzfuq.waiters = zzk2;
                return true;
            }
        }
    }

    interface zzh<V> extends zzfwm<V> {
    }

    abstract class zzi<V> extends zzfuq<V> implements zzh<V> {
        zzi() {
        }
    }

    final class zzj extends zza {
        static final Unsafe zza;
        static final long zzb;
        static final long zzc;
        static final long zzd;
        static final long zze;
        static final long zzf;

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0068, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.android.gms.internal.ads.zzfuq.zzj.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.android.gms.internal.ads.zzfuq$zzk> r0 = com.google.android.gms.internal.ads.zzfuq.zzk.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.android.gms.internal.ads.zzfuq$zzj$1 r1 = new com.google.android.gms.internal.ads.zzfuq$zzj$1     // Catch:{ PrivilegedActionException -> 0x005c }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005c }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005c }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005c }
            L_0x0012:
                java.lang.Class<com.google.android.gms.internal.ads.zzfuq> r2 = com.google.android.gms.internal.ads.zzfuq.class
                java.lang.String r3 = "waiters"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                zzc = r3     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r3 = "listeners"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                zzb = r3     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r3 = "value"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                zzd = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r2 = "thread"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                zze = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                java.lang.String r2 = "next"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                zzf = r2     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                zza = r1     // Catch:{ NoSuchFieldException -> 0x0055, RuntimeException -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                throw r0
            L_0x0055:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005c:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfuq.zzj.<clinit>():void");
        }

        private zzj() {
            super((zzfup) null);
        }

        /* synthetic */ zzj(zzfuu zzfuu) {
            super((zzfup) null);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        final com.google.android.gms.internal.ads.zzfuq.zzd zza(com.google.android.gms.internal.ads.zzfuq r3, com.google.android.gms.internal.ads.zzfuq.zzd r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.android.gms.internal.ads.zzfuq$zzd r0 = r3.listeners
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.zze(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfuq.zzj.zza(com.google.android.gms.internal.ads.zzfuq, com.google.android.gms.internal.ads.zzfuq$zzd):com.google.android.gms.internal.ads.zzfuq$zzd");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        final com.google.android.gms.internal.ads.zzfuq.zzk zzb(com.google.android.gms.internal.ads.zzfuq r3, com.google.android.gms.internal.ads.zzfuq.zzk r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.android.gms.internal.ads.zzfuq$zzk r0 = r3.waiters
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.zzg(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfuq.zzj.zzb(com.google.android.gms.internal.ads.zzfuq, com.google.android.gms.internal.ads.zzfuq$zzk):com.google.android.gms.internal.ads.zzfuq$zzk");
        }

        /* access modifiers changed from: package-private */
        public final void zzc(zzk zzk, zzk zzk2) {
            zza.putObject(zzk, zzf, zzk2);
        }

        /* access modifiers changed from: package-private */
        public final void zzd(zzk zzk, Thread thread) {
            zza.putObject(zzk, zze, thread);
        }

        /* access modifiers changed from: package-private */
        public final boolean zze(zzfuq zzfuq, zzd zzd2, zzd zzd3) {
            return zzfut.zza(zza, zzfuq, zzb, zzd2, zzd3);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzf(zzfuq zzfuq, Object obj, Object obj2) {
            return zzfut.zza(zza, zzfuq, zzd, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public final boolean zzg(zzfuq zzfuq, zzk zzk, zzk zzk2) {
            return zzfut.zza(zza, zzfuq, zzc, zzk, zzk2);
        }
    }

    final class zzk {
        static final zzk zza = new zzk(false);
        volatile zzk next;
        volatile Thread thread;

        zzk() {
            zzfuq.zzba.zzd(this, Thread.currentThread());
        }

        zzk(boolean z2) {
        }
    }

    static {
        boolean z2;
        Throwable th;
        Throwable th2;
        zza zza2;
        Class<zzk> cls = zzk.class;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", Constants.CASEFIRST_FALSE));
        } catch (SecurityException unused) {
            z2 = false;
        }
        zzd = z2;
        Class<zzfuq> cls2 = zzfuq.class;
        zzaZ = Logger.getLogger(cls2.getName());
        try {
            zza2 = new zzj((zzfuu) null);
            th2 = null;
            th = null;
        } catch (Error | RuntimeException e2) {
            try {
                th = null;
                th2 = e2;
                zza2 = new zze(AtomicReferenceFieldUpdater.newUpdater(cls, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(cls, cls, "next"), AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "waiters"), AtomicReferenceFieldUpdater.newUpdater(cls2, zzd.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(cls2, Object.class, AppMeasurementSdk.ConditionalUserProperty.VALUE));
            } catch (Error | RuntimeException e3) {
                th = e3;
                th2 = e2;
                zza2 = new zzg((zzfus) null);
            }
        }
        zzba = zza2;
        if (th != null) {
            Logger logger = zzaZ;
            Level level = Level.SEVERE;
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "UnsafeAtomicHelper is broken!", th2);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    protected zzfuq() {
    }

    private final void zzA(zzk zzk2) {
        zzk2.thread = null;
        while (true) {
            zzk zzk3 = this.waiters;
            if (zzk3 != zzk.zza) {
                zzk zzk4 = null;
                while (zzk3 != null) {
                    zzk zzk5 = zzk3.next;
                    if (zzk3.thread != null) {
                        zzk4 = zzk3;
                    } else if (zzk4 != null) {
                        zzk4.next = zzk5;
                        if (zzk4.thread == null) {
                        }
                    } else if (!zzba.zzg(this, zzk3, zzk5)) {
                    }
                    zzk3 = zzk5;
                }
                return;
            }
            return;
        }
    }

    private static final Object zzB(Object obj) throws ExecutionException {
        if (obj instanceof zzb) {
            Throwable th = ((zzb) obj).zzd;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        } else if (obj instanceof zzc) {
            throw new ExecutionException(((zzc) obj).zzb);
        } else if (obj == zzbd) {
            return null;
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object zzf(zzfwm zzfwm) {
        Throwable zzm;
        if (zzfwm instanceof zzh) {
            Object obj = ((zzfuq) zzfwm).value;
            if (obj instanceof zzb) {
                zzb zzb2 = (zzb) obj;
                if (zzb2.zzc) {
                    Throwable th = zzb2.zzd;
                    obj = th != null ? new zzb(false, th) : zzb.zzb;
                }
            }
            obj.getClass();
            return obj;
        } else if ((zzfwm instanceof zzfxf) && (zzm = ((zzfxf) zzfwm).zzm()) != null) {
            return new zzc(zzm);
        } else {
            boolean isCancelled = zzfwm.isCancelled();
            if ((!zzd) && isCancelled) {
                zzb zzb3 = zzb.zzb;
                zzb3.getClass();
                return zzb3;
            }
            try {
                Object zzg2 = zzg(zzfwm);
                if (isCancelled) {
                    String valueOf = String.valueOf(zzfwm);
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + valueOf));
                } else if (zzg2 == null) {
                    return zzbd;
                } else {
                    return zzg2;
                }
            } catch (ExecutionException e2) {
                if (isCancelled) {
                    return new zzb(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(zzfwm)), e2));
                }
                return new zzc(e2.getCause());
            } catch (CancellationException e3) {
                if (!isCancelled) {
                    return new zzc(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(zzfwm)), e3));
                }
                return new zzb(false, e3);
            } catch (Error | RuntimeException e4) {
                return new zzc(e4);
            }
        }
    }

    private static Object zzg(Future future) throws ExecutionException {
        Object obj;
        boolean z2 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z2 = true;
            } catch (Throwable th) {
                if (z2) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private final void zzv(StringBuilder sb) {
        try {
            Object zzg2 = zzg(this);
            sb.append("SUCCESS, result=[");
            if (zzg2 == null) {
                sb.append("null");
            } else if (zzg2 == this) {
                sb.append("this future");
            } else {
                sb.append(zzg2.getClass().getName());
                sb.append("@");
                sb.append(Integer.toHexString(System.identityHashCode(zzg2)));
            }
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private final void zzw(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.value;
        if (obj instanceof zzf) {
            sb.append(", setFuture=[");
            zzx(sb, ((zzf) obj).zzb);
            sb.append("]");
        } else {
            try {
                str = zzfpw.zza(zza());
            } catch (RuntimeException | StackOverflowError e2) {
                str = "Exception thrown from implementation: ".concat(String.valueOf(e2.getClass()));
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            zzv(sb);
        }
    }

    private final void zzx(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (RuntimeException | StackOverflowError e2) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e2.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    /* access modifiers changed from: private */
    public static void zzy(zzfuq<V> zzfuq, boolean z2) {
        zzd zzd2 = null;
        while (true) {
            for (zzk zzb2 = zzba.zzb(zzfuq, zzk.zza); zzb2 != null; zzb2 = zzb2.next) {
                Thread thread = zzb2.thread;
                if (thread != null) {
                    zzb2.thread = null;
                    LockSupport.unpark(thread);
                }
            }
            if (z2) {
                zzfuq.zzr();
            }
            zzfuq.zzb();
            zzd zzd3 = zzd2;
            zzd zza2 = zzba.zza(zzfuq, zzd.zza);
            zzd zzd4 = zzd3;
            while (zza2 != null) {
                zzd zzd5 = zza2.next;
                zza2.next = zzd4;
                zzd4 = zza2;
                zza2 = zzd5;
            }
            while (zzd4 != null) {
                zzd2 = zzd4.next;
                Runnable runnable = zzd4.zzb;
                runnable.getClass();
                if (runnable instanceof zzf) {
                    zzf zzf2 = (zzf) runnable;
                    zzfuq = zzf2.zza;
                    if (zzfuq.value == zzf2) {
                        if (zzba.zzf(zzfuq, zzf2, zzf(zzf2.zzb))) {
                            z2 = false;
                        }
                    } else {
                        continue;
                    }
                } else {
                    Executor executor = zzd4.zzc;
                    executor.getClass();
                    zzz(runnable, executor);
                }
                zzd4 = zzd2;
            }
            return;
        }
    }

    private static void zzz(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = zzaZ;
            Level level = Level.SEVERE;
            String valueOf = String.valueOf(runnable);
            String valueOf2 = String.valueOf(executor);
            logger.logp(level, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + valueOf + " with executor " + valueOf2, e2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.internal.ads.zzfwm<? extends V>, java.util.concurrent.Future] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.value
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzfuq.zzf
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x000a
            r4 = 1
            goto L_0x000b
        L_0x000a:
            r4 = 0
        L_0x000b:
            r1 = r1 | r4
            if (r1 == 0) goto L_0x005f
            boolean r1 = zzd
            if (r1 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzfuq$zzb r1 = new com.google.android.gms.internal.ads.zzfuq$zzb
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r1.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzfuq$zzb r1 = com.google.android.gms.internal.ads.zzfuq.zzb.zza
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzfuq$zzb r1 = com.google.android.gms.internal.ads.zzfuq.zzb.zzb
        L_0x0026:
            r1.getClass()
        L_0x0029:
            r5 = 0
            r4 = r7
        L_0x002b:
            com.google.android.gms.internal.ads.zzfuq$zza r6 = zzba
            boolean r6 = r6.zzf(r4, r0, r1)
            if (r6 == 0) goto L_0x0058
            zzy(r4, r8)
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfuq.zzf
            if (r4 == 0) goto L_0x0056
            com.google.android.gms.internal.ads.zzfuq$zzf r0 = (com.google.android.gms.internal.ads.zzfuq.zzf) r0
            com.google.android.gms.internal.ads.zzfwm<? extends V> r0 = r0.zzb
            boolean r4 = r0 instanceof com.google.android.gms.internal.ads.zzfuq.zzh
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.android.gms.internal.ads.zzfuq r4 = (com.google.android.gms.internal.ads.zzfuq) r4
            java.lang.Object r0 = r4.value
            if (r0 != 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzfuq.zzf
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0056
            r5 = 1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
        L_0x0056:
            r2 = 1
            goto L_0x005f
        L_0x0058:
            java.lang.Object r0 = r4.value
            boolean r6 = r0 instanceof com.google.android.gms.internal.ads.zzfuq.zzf
            if (r6 != 0) goto L_0x002b
            r2 = r5
        L_0x005f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfuq.cancel(boolean):boolean");
    }

    public Object get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                return zzB(obj2);
            }
            zzk zzk2 = this.waiters;
            if (zzk2 != zzk.zza) {
                zzk zzk3 = new zzk();
                do {
                    zza zza2 = zzba;
                    zza2.zzc(zzk3, zzk2);
                    if (zza2.zzg(this, zzk2, zzk3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                zzA(zzk3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof zzf))));
                        return zzB(obj);
                    }
                    zzk2 = this.waiters;
                } while (zzk2 != zzk.zza);
            }
            Object obj3 = this.value;
            obj3.getClass();
            return zzB(obj3);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.value instanceof zzb;
    }

    public boolean isDone() {
        Object obj = this.value;
        return (obj != null) & (!(obj instanceof zzf));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb.append(getClass().getSimpleName());
        } else {
            sb.append(getClass().getName());
        }
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            zzv(sb);
        } else {
            zzw(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public String zza() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        long delay = ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS);
        return "remaining delay=[" + delay + " ms]";
    }

    /* access modifiers changed from: protected */
    public void zzb() {
    }

    public void zzc(Runnable runnable, Executor executor) {
        zzd zzd2;
        zzfph.zzc(executor, "Executor was null.");
        if (isDone() || (zzd2 = this.listeners) == zzd.zza) {
            zzz(runnable, executor);
        }
        zzd zzd3 = new zzd(runnable, executor);
        do {
            zzd3.next = zzd2;
            if (!zzba.zze(this, zzd2, zzd3)) {
                zzd2 = this.listeners;
            } else {
                return;
            }
        } while (zzd2 != zzd.zza);
        zzz(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public boolean zzd(Object obj) {
        if (obj == null) {
            obj = zzbd;
        }
        if (!zzba.zzf(this, (Object) null, obj)) {
            return false;
        }
        zzy(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zze(Throwable th) {
        th.getClass();
        if (!zzba.zzf(this, (Object) null, new zzc(th))) {
            return false;
        }
        zzy(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public final Throwable zzm() {
        if (!(this instanceof zzh)) {
            return null;
        }
        Object obj = this.value;
        if (obj instanceof zzc) {
            return ((zzc) obj).zzb;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void zzr() {
    }

    /* access modifiers changed from: package-private */
    public final void zzs(Future future) {
        boolean z2;
        if (future != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2 && isCancelled()) {
            future.cancel(zzu());
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzt(zzfwm zzfwm) {
        zzc zzc2;
        zzfwm.getClass();
        Object obj = this.value;
        if (obj == null) {
            if (zzfwm.isDone()) {
                if (!zzba.zzf(this, (Object) null, zzf(zzfwm))) {
                    return false;
                }
                zzy(this, false);
                return true;
            }
            zzf zzf2 = new zzf(this, zzfwm);
            if (zzba.zzf(this, (Object) null, zzf2)) {
                try {
                    zzfwm.zzc(zzf2, zzfvq.INSTANCE);
                } catch (Error | RuntimeException e2) {
                    try {
                        zzc2 = new zzc(e2);
                    } catch (Error | RuntimeException unused) {
                        zzc2 = zzc.zza;
                    }
                    zzba.zzf(this, zzf2, zzc2);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof zzb) {
            zzfwm.cancel(((zzb) obj).zzc);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean zzu() {
        Object obj = this.value;
        return (obj instanceof zzb) && ((zzb) obj).zzc;
    }

    public Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j3 = j2;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.value;
            boolean z2 = true;
            if ((obj != null) && (!(obj instanceof zzf))) {
                return zzB(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                zzk zzk2 = this.waiters;
                if (zzk2 != zzk.zza) {
                    zzk zzk3 = new zzk();
                    do {
                        zza zza2 = zzba;
                        zza2.zzc(zzk3, zzk2);
                        if (zza2.zzg(this, zzk2, zzk3)) {
                            do {
                                LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.value;
                                    if ((obj2 != null) && (!(obj2 instanceof zzf))) {
                                        return zzB(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    zzA(zzk3);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            zzA(zzk3);
                        } else {
                            zzk2 = this.waiters;
                        }
                    } while (zzk2 != zzk.zza);
                }
                Object obj3 = this.value;
                obj3.getClass();
                return zzB(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.value;
                if ((obj4 != null) && (!(obj4 instanceof zzf))) {
                    return zzB(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String zzfuq = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String concat = str.concat(" (plus ");
                long j4 = -nanos;
                long convert = timeUnit2.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit2.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                if (i2 != 0 && nanos2 <= 1000) {
                    z2 = false;
                }
                if (i2 > 0) {
                    String str2 = concat + convert + " " + lowerCase;
                    if (z2) {
                        str2 = str2.concat(",");
                    }
                    concat = str2.concat(" ");
                }
                if (z2) {
                    concat = concat + nanos2 + " nanoseconds ";
                }
                str = concat.concat("delay)");
            }
            if (isDone()) {
                throw new TimeoutException(str.concat(" but future completed as timeout expired"));
            }
            throw new TimeoutException(str + " for " + zzfuq);
        }
        throw new InterruptedException();
    }
}
