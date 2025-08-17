package com.google.common.util.concurrent;

import androidx.concurrent.futures.a;
import com.facebook.hermes.intl.Constants;
import com.google.android.gms.internal.ads.m;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Locale;
import java.util.Objects;
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

@ReflectionSupport(ReflectionSupport.Level.FULL)
public abstract class AbstractFuture<V> extends InternalFutureFailureAccess implements ListenableFuture<V> {

    /* renamed from: e  reason: collision with root package name */
    static final boolean f30728e;

    /* renamed from: f  reason: collision with root package name */
    static final LazyLogger f30729f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicHelper f30730g;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f30731h = new Object();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile Object f30732b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public volatile Listener f30733c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public volatile Waiter f30734d;

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract Listener d(AbstractFuture<?> abstractFuture, Listener listener);

        /* access modifiers changed from: package-private */
        public abstract Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter);

        /* access modifiers changed from: package-private */
        public abstract void f(Waiter waiter, Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract void g(Waiter waiter, Thread thread);
    }

    private static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f30735c;

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f30736d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f30737a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f30738b;

        static {
            if (AbstractFuture.f30728e) {
                f30736d = null;
                f30735c = null;
                return;
            }
            f30736d = new Cancellation(false, (Throwable) null);
            f30735c = new Cancellation(true, (Throwable) null);
        }

        Cancellation(boolean z2, Throwable th) {
            this.f30737a = z2;
            this.f30738b = th;
        }
    }

    private static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f30739b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f30740a;

        Failure(Throwable th) {
            this.f30740a = (Throwable) Preconditions.l(th);
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f30745a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f30746b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Waiter> f30747c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Listener> f30748d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f30749e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f30745a = atomicReferenceFieldUpdater;
            this.f30746b = atomicReferenceFieldUpdater2;
            this.f30747c = atomicReferenceFieldUpdater3;
            this.f30748d = atomicReferenceFieldUpdater4;
            this.f30749e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return a.a(this.f30748d, abstractFuture, listener, listener2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return a.a(this.f30749e, abstractFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f30747c, abstractFuture, waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            return this.f30748d.getAndSet(abstractFuture, listener);
        }

        /* access modifiers changed from: package-private */
        public Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            return this.f30747c.getAndSet(abstractFuture, waiter);
        }

        /* access modifiers changed from: package-private */
        public void f(Waiter waiter, Waiter waiter2) {
            this.f30746b.lazySet(waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void g(Waiter waiter, Thread thread) {
            this.f30745a.lazySet(waiter, thread);
        }
    }

    private static final class SetFuture<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final AbstractFuture<V> f30750b;

        /* renamed from: c  reason: collision with root package name */
        final ListenableFuture<? extends V> f30751c;

        public void run() {
            if (this.f30750b.f30732b == this) {
                if (AbstractFuture.f30730g.b(this.f30750b, this, AbstractFuture.u(this.f30751c))) {
                    AbstractFuture.r(this.f30750b, false);
                }
            }
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        private SynchronizedHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f30733c != listener) {
                    return false;
                }
                Listener unused = abstractFuture.f30733c = listener2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f30732b != obj) {
                    return false;
                }
                Object unused = abstractFuture.f30732b = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractFuture) {
                if (abstractFuture.f30734d != waiter) {
                    return false;
                }
                Waiter unused = abstractFuture.f30734d = waiter2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public Listener d(AbstractFuture<?> abstractFuture, Listener listener) {
            Listener g2;
            synchronized (abstractFuture) {
                g2 = abstractFuture.f30733c;
                if (g2 != listener) {
                    Listener unused = abstractFuture.f30733c = listener;
                }
            }
            return g2;
        }

        /* access modifiers changed from: package-private */
        public Waiter e(AbstractFuture<?> abstractFuture, Waiter waiter) {
            Waiter i2;
            synchronized (abstractFuture) {
                i2 = abstractFuture.f30734d;
                if (i2 != waiter) {
                    Waiter unused = abstractFuture.f30734d = waiter;
                }
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void f(Waiter waiter, Waiter waiter2) {
            waiter.f30760b = waiter2;
        }

        /* access modifiers changed from: package-private */
        public void g(Waiter waiter, Thread thread) {
            waiter.f30759a = thread;
        }
    }

    interface Trusted<V> extends ListenableFuture<V> {
    }

    static abstract class TrustedFuture<V> extends AbstractFuture<V> implements Trusted<V> {
        TrustedFuture() {
        }

        public final void addListener(Runnable runnable, Executor executor) {
            AbstractFuture.super.addListener(runnable, executor);
        }

        public final boolean cancel(boolean z2) {
            return AbstractFuture.super.cancel(z2);
        }

        public V get() throws InterruptedException, ExecutionException {
            return AbstractFuture.super.get();
        }

        public final boolean isCancelled() {
            return AbstractFuture.super.isCancelled();
        }

        public final boolean isDone() {
            return AbstractFuture.super.isDone();
        }

        public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return AbstractFuture.super.get(j2, timeUnit);
        }
    }

    private static final class UnsafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        static final Unsafe f30752a;

        /* renamed from: b  reason: collision with root package name */
        static final long f30753b;

        /* renamed from: c  reason: collision with root package name */
        static final long f30754c;

        /* renamed from: d  reason: collision with root package name */
        static final long f30755d;

        /* renamed from: e  reason: collision with root package name */
        static final long f30756e;

        /* renamed from: f  reason: collision with root package name */
        static final long f30757f;

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0066, code lost:
            throw new java.lang.RuntimeException("Could not initialize intrinsics", r0.getCause());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:?, code lost:
            r1 = (sun.misc.Unsafe) java.security.AccessController.doPrivileged(new com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.AnonymousClass1());
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0007 */
        static {
            /*
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture$Waiter> r0 = com.google.common.util.concurrent.AbstractFuture.Waiter.class
                sun.misc.Unsafe r1 = sun.misc.Unsafe.getUnsafe()     // Catch:{ SecurityException -> 0x0007 }
                goto L_0x0012
            L_0x0007:
                com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1 r1 = new com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$1     // Catch:{ PrivilegedActionException -> 0x005a }
                r1.<init>()     // Catch:{ PrivilegedActionException -> 0x005a }
                java.lang.Object r1 = java.security.AccessController.doPrivileged(r1)     // Catch:{ PrivilegedActionException -> 0x005a }
                sun.misc.Unsafe r1 = (sun.misc.Unsafe) r1     // Catch:{ PrivilegedActionException -> 0x005a }
            L_0x0012:
                java.lang.Class<com.google.common.util.concurrent.AbstractFuture> r2 = com.google.common.util.concurrent.AbstractFuture.class
                java.lang.String r3 = "d"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                f30754c = r3     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r3 = "c"
                java.lang.reflect.Field r3 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r3 = r1.objectFieldOffset(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                f30753b = r3     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r3 = "b"
                java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                f30755d = r2     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r2 = "a"
                java.lang.reflect.Field r2 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                f30756e = r2     // Catch:{ NoSuchFieldException -> 0x0053 }
                java.lang.String r2 = "b"
                java.lang.reflect.Field r0 = r0.getDeclaredField(r2)     // Catch:{ NoSuchFieldException -> 0x0053 }
                long r2 = r1.objectFieldOffset(r0)     // Catch:{ NoSuchFieldException -> 0x0053 }
                f30757f = r2     // Catch:{ NoSuchFieldException -> 0x0053 }
                f30752a = r1     // Catch:{ NoSuchFieldException -> 0x0053 }
                return
            L_0x0053:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                r1.<init>(r0)
                throw r1
            L_0x005a:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException
                java.lang.String r2 = "Could not initialize intrinsics"
                java.lang.Throwable r0 = r0.getCause()
                r1.<init>(r2, r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.<clinit>():void");
        }

        private UnsafeAtomicHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractFuture<?> abstractFuture, Listener listener, Listener listener2) {
            return m.a(f30752a, abstractFuture, f30753b, listener, listener2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return m.a(f30752a, abstractFuture, f30755d, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractFuture<?> abstractFuture, Waiter waiter, Waiter waiter2) {
            return m.a(f30752a, abstractFuture, f30754c, waiter, waiter2);
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        com.google.common.util.concurrent.AbstractFuture.Listener d(com.google.common.util.concurrent.AbstractFuture<?> r3, com.google.common.util.concurrent.AbstractFuture.Listener r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.common.util.concurrent.AbstractFuture$Listener r0 = r3.f30733c
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.a(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.d(com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture$Listener):com.google.common.util.concurrent.AbstractFuture$Listener");
        }

        /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: 
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        com.google.common.util.concurrent.AbstractFuture.Waiter e(com.google.common.util.concurrent.AbstractFuture<?> r3, com.google.common.util.concurrent.AbstractFuture.Waiter r4) {
            /*
                r2 = this;
            L_0x0000:
                com.google.common.util.concurrent.AbstractFuture$Waiter r0 = r3.f30734d
                if (r4 != r0) goto L_0x0007
                return r0
            L_0x0007:
                boolean r1 = r2.c(r3, r0, r4)
                if (r1 == 0) goto L_0x0000
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.UnsafeAtomicHelper.e(com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.AbstractFuture$Waiter):com.google.common.util.concurrent.AbstractFuture$Waiter");
        }

        /* access modifiers changed from: package-private */
        public void f(Waiter waiter, Waiter waiter2) {
            f30752a.putObject(waiter, f30757f, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void g(Waiter waiter, Thread thread) {
            f30752a.putObject(waiter, f30756e, thread);
        }
    }

    private static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f30758c = new Waiter(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f30759a;

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f30760b;

        Waiter(boolean z2) {
        }

        /* access modifiers changed from: package-private */
        public void a(Waiter waiter) {
            AbstractFuture.f30730g.f(this, waiter);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f30759a;
            if (thread != null) {
                this.f30759a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractFuture.f30730g.g(this, Thread.currentThread());
        }
    }

    static {
        boolean z2;
        AtomicHelper atomicHelper;
        Class<Waiter> cls = Waiter.class;
        try {
            z2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", Constants.CASEFIRST_FALSE));
        } catch (SecurityException unused) {
            z2 = false;
        }
        f30728e = z2;
        Class<AbstractFuture> cls2 = AbstractFuture.class;
        f30729f = new LazyLogger(cls2);
        Throwable th = null;
        try {
            atomicHelper = new UnsafeAtomicHelper();
            e = null;
        } catch (Error | Exception e2) {
            e = e2;
            try {
                atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(cls, Thread.class, com.facebook.ads.internal.c.a.f20042a), AtomicReferenceFieldUpdater.newUpdater(cls, cls, "b"), AtomicReferenceFieldUpdater.newUpdater(cls2, cls, "d"), AtomicReferenceFieldUpdater.newUpdater(cls2, Listener.class, "c"), AtomicReferenceFieldUpdater.newUpdater(cls2, Object.class, "b"));
            } catch (Error | Exception e3) {
                atomicHelper = new SynchronizedHelper();
                th = e3;
            }
        }
        f30730g = atomicHelper;
        if (th != null) {
            LazyLogger lazyLogger = f30729f;
            Logger a2 = lazyLogger.a();
            Level level = Level.SEVERE;
            a2.log(level, "UnsafeAtomicHelper is broken!", e);
            lazyLogger.a().log(level, "SafeAtomicHelper is broken!", th);
        }
    }

    protected AbstractFuture() {
    }

    private void k(StringBuilder sb) {
        try {
            Object v2 = v(this);
            sb.append("SUCCESS, result=[");
            n(sb, v2);
            sb.append("]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (Exception e3) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e3.getClass());
            sb.append(" thrown from get()]");
        }
    }

    private void l(StringBuilder sb) {
        String str;
        int length = sb.length();
        sb.append("PENDING");
        Object obj = this.f30732b;
        if (obj instanceof SetFuture) {
            sb.append(", setFuture=[");
            o(sb, ((SetFuture) obj).f30751c);
            sb.append("]");
        } else {
            try {
                str = Strings.a(x());
            } catch (Exception | StackOverflowError e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null) {
                sb.append(", info=[");
                sb.append(str);
                sb.append("]");
            }
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    private void n(StringBuilder sb, Object obj) {
        if (obj == null) {
            sb.append("null");
        } else if (obj == this) {
            sb.append("this future");
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    private void o(StringBuilder sb, Object obj) {
        if (obj == this) {
            try {
                sb.append("this future");
            } catch (Exception | StackOverflowError e2) {
                sb.append("Exception thrown from implementation: ");
                sb.append(e2.getClass());
            }
        } else {
            sb.append(obj);
        }
    }

    private static CancellationException p(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    private Listener q(Listener listener) {
        Listener listener2 = listener;
        Listener d2 = f30730g.d(this, Listener.f30741d);
        while (d2 != null) {
            Listener listener3 = d2.f30744c;
            d2.f30744c = listener2;
            listener2 = d2;
            d2 = listener3;
        }
        return listener2;
    }

    /* access modifiers changed from: private */
    public static void r(AbstractFuture<?> abstractFuture, boolean z2) {
        Listener listener = null;
        AbstractFuture<V> abstractFuture2 = abstractFuture;
        while (true) {
            abstractFuture2.y();
            if (z2) {
                abstractFuture2.w();
                z2 = false;
            }
            abstractFuture2.m();
            Listener q2 = abstractFuture2.q(listener);
            while (true) {
                if (q2 != null) {
                    listener = q2.f30744c;
                    Runnable runnable = q2.f30742a;
                    Objects.requireNonNull(runnable);
                    Runnable runnable2 = runnable;
                    if (runnable2 instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable2;
                        AbstractFuture<V> abstractFuture3 = setFuture.f30750b;
                        if (abstractFuture3.f30732b == setFuture) {
                            if (f30730g.b(abstractFuture3, setFuture, u(setFuture.f30751c))) {
                                abstractFuture2 = abstractFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        Executor executor = q2.f30743b;
                        Objects.requireNonNull(executor);
                        s(runnable2, executor);
                    }
                    q2 = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void s(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e2) {
            Logger a2 = f30729f.a();
            Level level = Level.SEVERE;
            a2.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private V t(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw p("Task was cancelled.", ((Cancellation) obj).f30738b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f30740a);
        } else if (obj == f30731h) {
            return NullnessCasts.a();
        } else {
            return obj;
        }
    }

    /* access modifiers changed from: private */
    public static Object u(ListenableFuture<?> listenableFuture) {
        Throwable a2;
        if (listenableFuture instanceof Trusted) {
            Object obj = ((AbstractFuture) listenableFuture).f30732b;
            if (obj instanceof Cancellation) {
                Cancellation cancellation = (Cancellation) obj;
                if (cancellation.f30737a) {
                    obj = cancellation.f30738b != null ? new Cancellation(false, cancellation.f30738b) : Cancellation.f30736d;
                }
            }
            Objects.requireNonNull(obj);
            return obj;
        } else if ((listenableFuture instanceof InternalFutureFailureAccess) && (a2 = InternalFutures.a((InternalFutureFailureAccess) listenableFuture)) != null) {
            return new Failure(a2);
        } else {
            boolean isCancelled = listenableFuture.isCancelled();
            if ((!f30728e) && isCancelled) {
                Cancellation cancellation2 = Cancellation.f30736d;
                Objects.requireNonNull(cancellation2);
                return cancellation2;
            }
            try {
                Object v2 = v(listenableFuture);
                if (isCancelled) {
                    return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture));
                } else if (v2 == null) {
                    return f30731h;
                } else {
                    return v2;
                }
            } catch (ExecutionException e2) {
                if (!isCancelled) {
                    return new Failure(e2.getCause());
                }
                return new Cancellation(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + listenableFuture, e2));
            } catch (CancellationException e3) {
                if (isCancelled) {
                    return new Cancellation(false, e3);
                }
                return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
            } catch (Error | Exception e4) {
                return new Failure(e4);
            }
        }
    }

    private static <V> V v(Future<V> future) throws ExecutionException {
        V v2;
        boolean z2 = false;
        while (true) {
            try {
                v2 = future.get();
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
        return v2;
    }

    private void y() {
        for (Waiter e2 = f30730g.e(this, Waiter.f30758c); e2 != null; e2 = e2.f30760b) {
            e2.b();
        }
    }

    private void z(Waiter waiter) {
        waiter.f30759a = null;
        while (true) {
            Waiter waiter2 = this.f30734d;
            if (waiter2 != Waiter.f30758c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f30760b;
                    if (waiter2.f30759a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f30760b = waiter4;
                        if (waiter3.f30759a == null) {
                        }
                    } else if (!f30730g.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: protected */
    public boolean A(V v2) {
        if (v2 == null) {
            v2 = f30731h;
        }
        if (!f30730g.b(this, (Object) null, v2)) {
            return false;
        }
        r(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean B(Throwable th) {
        if (!f30730g.b(this, (Object) null, new Failure((Throwable) Preconditions.l(th)))) {
            return false;
        }
        r(this, false);
        return true;
    }

    /* access modifiers changed from: protected */
    public final Throwable a() {
        if (!(this instanceof Trusted)) {
            return null;
        }
        Object obj = this.f30732b;
        if (obj instanceof Failure) {
            return ((Failure) obj).f30740a;
        }
        return null;
    }

    public void addListener(Runnable runnable, Executor executor) {
        Listener listener;
        Preconditions.m(runnable, "Runnable was null.");
        Preconditions.m(executor, "Executor was null.");
        if (isDone() || (listener = this.f30733c) == Listener.f30741d) {
            s(runnable, executor);
        }
        Listener listener2 = new Listener(runnable, executor);
        do {
            listener2.f30744c = listener;
            if (!f30730g.a(this, listener, listener2)) {
                listener = this.f30733c;
            } else {
                return;
            }
        } while (listener != Listener.f30741d);
        s(runnable, executor);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f30732b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x005f
            boolean r3 = f30728e
            if (r3 == 0) goto L_0x001f
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = new com.google.common.util.concurrent.AbstractFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0029
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.f30735c
            goto L_0x0026
        L_0x0024:
            com.google.common.util.concurrent.AbstractFuture$Cancellation r3 = com.google.common.util.concurrent.AbstractFuture.Cancellation.f30736d
        L_0x0026:
            java.util.Objects.requireNonNull(r3)
        L_0x0029:
            r5 = 0
            r4 = r7
        L_0x002b:
            com.google.common.util.concurrent.AbstractFuture$AtomicHelper r6 = f30730g
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0057
            r(r4, r8)
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r4 == 0) goto L_0x0060
            com.google.common.util.concurrent.AbstractFuture$SetFuture r0 = (com.google.common.util.concurrent.AbstractFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f30751c
            boolean r4 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.Trusted
            if (r4 == 0) goto L_0x0053
            r4 = r0
            com.google.common.util.concurrent.AbstractFuture r4 = (com.google.common.util.concurrent.AbstractFuture) r4
            java.lang.Object r0 = r4.f30732b
            if (r0 != 0) goto L_0x004b
            r5 = 1
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0060
            r5 = 1
            goto L_0x002b
        L_0x0053:
            r0.cancel(r8)
            goto L_0x0060
        L_0x0057:
            java.lang.Object r0 = r4.f30732b
            boolean r6 = r0 instanceof com.google.common.util.concurrent.AbstractFuture.SetFuture
            if (r6 != 0) goto L_0x002b
            r1 = r5
            goto L_0x0060
        L_0x005f:
            r1 = 0
        L_0x0060:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractFuture.cancel(boolean):boolean");
    }

    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j3 = j2;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.f30732b;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return t(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.f30734d;
                if (waiter != Waiter.f30758c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f30730g.c(this, waiter, waiter2)) {
                            do {
                                OverflowAvoidingLockSupport.a(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f30732b;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return t(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    z(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            z(waiter2);
                        } else {
                            waiter = this.f30734d;
                        }
                    } while (waiter != Waiter.f30758c);
                }
                Object obj3 = this.f30732b;
                Objects.requireNonNull(obj3);
                return t(obj3);
            }
            while (nanos > 0) {
                Object obj4 = this.f30732b;
                if ((obj4 != null) && (!(obj4 instanceof SetFuture))) {
                    return t(obj4);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractFuture = toString();
            String obj5 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj5.toLowerCase(locale);
            String str = "Waited " + j3 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j4 = -nanos;
                long convert = timeUnit2.convert(j4, TimeUnit.NANOSECONDS);
                long nanos2 = j4 - timeUnit2.toNanos(convert);
                int i2 = (convert > 0 ? 1 : (convert == 0 ? 0 : -1));
                boolean z2 = i2 == 0 || nanos2 > 1000;
                if (i2 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z2) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z2) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + abstractFuture);
        }
        throw new InterruptedException();
    }

    public boolean isCancelled() {
        return this.f30732b instanceof Cancellation;
    }

    public boolean isDone() {
        boolean z2;
        Object obj = this.f30732b;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (!(obj instanceof SetFuture)) & z2;
    }

    /* access modifiers changed from: protected */
    public void m() {
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
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public void w() {
    }

    /* access modifiers changed from: protected */
    public String x() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    private static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f30741d = new Listener();

        /* renamed from: a  reason: collision with root package name */
        final Runnable f30742a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f30743b;

        /* renamed from: c  reason: collision with root package name */
        Listener f30744c;

        Listener(Runnable runnable, Executor executor) {
            this.f30742a = runnable;
            this.f30743b = executor;
        }

        Listener() {
            this.f30742a = null;
            this.f30743b = null;
        }
    }

    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f30732b;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return t(obj2);
            }
            Waiter waiter = this.f30734d;
            if (waiter != Waiter.f30758c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f30730g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f30732b;
                            } else {
                                z(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return t(obj);
                    }
                    waiter = this.f30734d;
                } while (waiter != Waiter.f30758c);
            }
            Object obj3 = this.f30732b;
            Objects.requireNonNull(obj3);
            return t(obj3);
        }
        throw new InterruptedException();
    }
}
