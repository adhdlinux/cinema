package androidx.concurrent.futures;

import com.facebook.hermes.intl.Constants;
import com.google.common.util.concurrent.ListenableFuture;
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

public abstract class AbstractResolvableFuture<V> implements ListenableFuture<V> {

    /* renamed from: e  reason: collision with root package name */
    static final boolean f1718e = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", Constants.CASEFIRST_FALSE));

    /* renamed from: f  reason: collision with root package name */
    private static final Logger f1719f;

    /* renamed from: g  reason: collision with root package name */
    static final AtomicHelper f1720g;

    /* renamed from: h  reason: collision with root package name */
    private static final Object f1721h = new Object();

    /* renamed from: b  reason: collision with root package name */
    volatile Object f1722b;

    /* renamed from: c  reason: collision with root package name */
    volatile Listener f1723c;

    /* renamed from: d  reason: collision with root package name */
    volatile Waiter f1724d;

    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        /* access modifiers changed from: package-private */
        public abstract boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2);

        /* access modifiers changed from: package-private */
        public abstract boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract void d(Waiter waiter, Waiter waiter2);

        /* access modifiers changed from: package-private */
        public abstract void e(Waiter waiter, Thread thread);
    }

    private static final class Cancellation {

        /* renamed from: c  reason: collision with root package name */
        static final Cancellation f1725c;

        /* renamed from: d  reason: collision with root package name */
        static final Cancellation f1726d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f1727a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f1728b;

        static {
            if (AbstractResolvableFuture.f1718e) {
                f1726d = null;
                f1725c = null;
                return;
            }
            f1726d = new Cancellation(false, (Throwable) null);
            f1725c = new Cancellation(true, (Throwable) null);
        }

        Cancellation(boolean z2, Throwable th) {
            this.f1727a = z2;
            this.f1728b = th;
        }
    }

    private static final class Failure {

        /* renamed from: b  reason: collision with root package name */
        static final Failure f1729b = new Failure(new Throwable("Failure occurred while trying to finish a future.") {
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: a  reason: collision with root package name */
        final Throwable f1730a;

        Failure(Throwable th) {
            this.f1730a = (Throwable) AbstractResolvableFuture.d(th);
        }
    }

    private static final class Listener {

        /* renamed from: d  reason: collision with root package name */
        static final Listener f1731d = new Listener((Runnable) null, (Executor) null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f1732a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f1733b;

        /* renamed from: c  reason: collision with root package name */
        Listener f1734c;

        Listener(Runnable runnable, Executor executor) {
            this.f1732a = runnable;
            this.f1733b = executor;
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Thread> f1735a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<Waiter, Waiter> f1736b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> f1737c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> f1738d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> f1739e;

        SafeAtomicHelper(AtomicReferenceFieldUpdater<Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<Waiter, Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f1735a = atomicReferenceFieldUpdater;
            this.f1736b = atomicReferenceFieldUpdater2;
            this.f1737c = atomicReferenceFieldUpdater3;
            this.f1738d = atomicReferenceFieldUpdater4;
            this.f1739e = atomicReferenceFieldUpdater5;
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            return a.a(this.f1738d, abstractResolvableFuture, listener, listener2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            return a.a(this.f1739e, abstractResolvableFuture, obj, obj2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            return a.a(this.f1737c, abstractResolvableFuture, waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void d(Waiter waiter, Waiter waiter2) {
            this.f1736b.lazySet(waiter, waiter2);
        }

        /* access modifiers changed from: package-private */
        public void e(Waiter waiter, Thread thread) {
            this.f1735a.lazySet(waiter, thread);
        }
    }

    private static final class SetFuture<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final AbstractResolvableFuture<V> f1740b;

        /* renamed from: c  reason: collision with root package name */
        final ListenableFuture<? extends V> f1741c;

        public void run() {
            if (this.f1740b.f1722b == this) {
                if (AbstractResolvableFuture.f1720g.b(this.f1740b, this, AbstractResolvableFuture.i(this.f1741c))) {
                    AbstractResolvableFuture.f(this.f1740b);
                }
            }
        }
    }

    private static final class SynchronizedHelper extends AtomicHelper {
        SynchronizedHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public boolean a(AbstractResolvableFuture<?> abstractResolvableFuture, Listener listener, Listener listener2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1723c != listener) {
                    return false;
                }
                abstractResolvableFuture.f1723c = listener2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean b(AbstractResolvableFuture<?> abstractResolvableFuture, Object obj, Object obj2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1722b != obj) {
                    return false;
                }
                abstractResolvableFuture.f1722b = obj2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c(AbstractResolvableFuture<?> abstractResolvableFuture, Waiter waiter, Waiter waiter2) {
            synchronized (abstractResolvableFuture) {
                if (abstractResolvableFuture.f1724d != waiter) {
                    return false;
                }
                abstractResolvableFuture.f1724d = waiter2;
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(Waiter waiter, Waiter waiter2) {
            waiter.f1744b = waiter2;
        }

        /* access modifiers changed from: package-private */
        public void e(Waiter waiter, Thread thread) {
            waiter.f1743a = thread;
        }
    }

    private static final class Waiter {

        /* renamed from: c  reason: collision with root package name */
        static final Waiter f1742c = new Waiter(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f1743a;

        /* renamed from: b  reason: collision with root package name */
        volatile Waiter f1744b;

        Waiter(boolean z2) {
        }

        /* access modifiers changed from: package-private */
        public void a(Waiter waiter) {
            AbstractResolvableFuture.f1720g.d(this, waiter);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            Thread thread = this.f1743a;
            if (thread != null) {
                this.f1743a = null;
                LockSupport.unpark(thread);
            }
        }

        Waiter() {
            AbstractResolvableFuture.f1720g.e(this, Thread.currentThread());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Waiter> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Waiter.class
            java.lang.String r1 = "guava.concurrent.generate_cancellation_cause"
            java.lang.String r2 = "false"
            java.lang.String r1 = java.lang.System.getProperty(r1, r2)
            boolean r1 = java.lang.Boolean.parseBoolean(r1)
            f1718e = r1
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture> r1 = androidx.concurrent.futures.AbstractResolvableFuture.class
            java.lang.String r2 = r1.getName()
            java.util.logging.Logger r2 = java.util.logging.Logger.getLogger(r2)
            f1719f = r2
            androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper r2 = new androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Thread> r3 = java.lang.Thread.class
            java.lang.String r4 = "a"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r3, r4)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r0, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "d"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<androidx.concurrent.futures.AbstractResolvableFuture$Listener> r0 = androidx.concurrent.futures.AbstractResolvableFuture.Listener.class
            java.lang.String r3 = "c"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            java.lang.String r3 = "b"
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r8 = java.util.concurrent.atomic.AtomicReferenceFieldUpdater.newUpdater(r1, r0, r3)     // Catch:{ all -> 0x0048 }
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0048 }
            r0 = 0
            goto L_0x004e
        L_0x0048:
            r0 = move-exception
            androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper r2 = new androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper
            r2.<init>()
        L_0x004e:
            f1720g = r2
            if (r0 == 0) goto L_0x005b
            java.util.logging.Logger r1 = f1719f
            java.util.logging.Level r2 = java.util.logging.Level.SEVERE
            java.lang.String r3 = "SafeAtomicHelper is broken!"
            r1.log(r2, r3, r0)
        L_0x005b:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            f1721h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.<clinit>():void");
    }

    protected AbstractResolvableFuture() {
    }

    private void a(StringBuilder sb) {
        try {
            Object j2 = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(q(j2));
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

    private static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T d(T t2) {
        t2.getClass();
        return t2;
    }

    private Listener e(Listener listener) {
        Listener listener2;
        do {
            listener2 = this.f1723c;
        } while (!f1720g.a(this, listener2, Listener.f1731d));
        Listener listener3 = listener2;
        Listener listener4 = listener;
        Listener listener5 = listener3;
        while (listener5 != null) {
            Listener listener6 = listener5.f1734c;
            listener5.f1734c = listener4;
            listener4 = listener5;
            listener5 = listener6;
        }
        return listener4;
    }

    static void f(AbstractResolvableFuture<?> abstractResolvableFuture) {
        Listener listener = null;
        AbstractResolvableFuture<V> abstractResolvableFuture2 = abstractResolvableFuture;
        while (true) {
            abstractResolvableFuture2.m();
            abstractResolvableFuture2.b();
            Listener e2 = abstractResolvableFuture2.e(listener);
            while (true) {
                if (e2 != null) {
                    listener = e2.f1734c;
                    Runnable runnable = e2.f1732a;
                    if (runnable instanceof SetFuture) {
                        SetFuture setFuture = (SetFuture) runnable;
                        AbstractResolvableFuture<V> abstractResolvableFuture3 = setFuture.f1740b;
                        if (abstractResolvableFuture3.f1722b == setFuture) {
                            if (f1720g.b(abstractResolvableFuture3, setFuture, i(setFuture.f1741c))) {
                                abstractResolvableFuture2 = abstractResolvableFuture3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        g(runnable, e2.f1733b);
                    }
                    e2 = listener;
                } else {
                    return;
                }
            }
        }
    }

    private static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f1719f;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, e2);
        }
    }

    private V h(Object obj) throws ExecutionException {
        if (obj instanceof Cancellation) {
            throw c("Task was cancelled.", ((Cancellation) obj).f1728b);
        } else if (obj instanceof Failure) {
            throw new ExecutionException(((Failure) obj).f1730a);
        } else if (obj == f1721h) {
            return null;
        } else {
            return obj;
        }
    }

    static Object i(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof AbstractResolvableFuture) {
            Object obj = ((AbstractResolvableFuture) listenableFuture).f1722b;
            if (!(obj instanceof Cancellation)) {
                return obj;
            }
            Cancellation cancellation = (Cancellation) obj;
            if (!cancellation.f1727a) {
                return obj;
            }
            if (cancellation.f1728b != null) {
                return new Cancellation(false, cancellation.f1728b);
            }
            return Cancellation.f1726d;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f1718e) && isCancelled) {
            return Cancellation.f1726d;
        }
        try {
            Object j2 = j(listenableFuture);
            if (j2 == null) {
                return f1721h;
            }
            return j2;
        } catch (ExecutionException e2) {
            return new Failure(e2.getCause());
        } catch (CancellationException e3) {
            if (isCancelled) {
                return new Cancellation(false, e3);
            }
            return new Failure(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e3));
        } catch (Throwable th) {
            return new Failure(th);
        }
    }

    static <V> V j(Future<V> future) throws ExecutionException {
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

    private void m() {
        Waiter waiter;
        do {
            waiter = this.f1724d;
        } while (!f1720g.c(this, waiter, Waiter.f1742c));
        while (waiter != null) {
            waiter.b();
            waiter = waiter.f1744b;
        }
    }

    private void n(Waiter waiter) {
        waiter.f1743a = null;
        while (true) {
            Waiter waiter2 = this.f1724d;
            if (waiter2 != Waiter.f1742c) {
                Waiter waiter3 = null;
                while (waiter2 != null) {
                    Waiter waiter4 = waiter2.f1744b;
                    if (waiter2.f1743a != null) {
                        waiter3 = waiter2;
                    } else if (waiter3 != null) {
                        waiter3.f1744b = waiter4;
                        if (waiter3.f1743a == null) {
                        }
                    } else if (!f1720g.c(this, waiter2, waiter4)) {
                    }
                    waiter2 = waiter4;
                }
                return;
            }
            return;
        }
    }

    private String q(Object obj) {
        if (obj == this) {
            return "this future";
        }
        return String.valueOf(obj);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        d(runnable);
        d(executor);
        Listener listener = this.f1723c;
        if (listener != Listener.f1731d) {
            Listener listener2 = new Listener(runnable, executor);
            do {
                listener2.f1734c = listener;
                if (!f1720g.a(this, listener, listener2)) {
                    listener = this.f1723c;
                } else {
                    return;
                }
            } while (listener != Listener.f1731d);
        }
        g(runnable, executor);
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.util.concurrent.Future, com.google.common.util.concurrent.ListenableFuture<? extends V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f1722b
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            r3 = r3 | r4
            if (r3 == 0) goto L_0x0061
            boolean r3 = f1718e
            if (r3 == 0) goto L_0x001f
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = new androidx.concurrent.futures.AbstractResolvableFuture$Cancellation
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L_0x0026
        L_0x001f:
            if (r8 == 0) goto L_0x0024
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = androidx.concurrent.futures.AbstractResolvableFuture.Cancellation.f1725c
            goto L_0x0026
        L_0x0024:
            androidx.concurrent.futures.AbstractResolvableFuture$Cancellation r3 = androidx.concurrent.futures.AbstractResolvableFuture.Cancellation.f1726d
        L_0x0026:
            r5 = 0
            r4 = r7
        L_0x0028:
            androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper r6 = f1720g
            boolean r6 = r6.b(r4, r0, r3)
            if (r6 == 0) goto L_0x0059
            if (r8 == 0) goto L_0x0035
            r4.k()
        L_0x0035:
            f(r4)
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            if (r4 == 0) goto L_0x0062
            androidx.concurrent.futures.AbstractResolvableFuture$SetFuture r0 = (androidx.concurrent.futures.AbstractResolvableFuture.SetFuture) r0
            com.google.common.util.concurrent.ListenableFuture<? extends V> r0 = r0.f1741c
            boolean r4 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture
            if (r4 == 0) goto L_0x0055
            r4 = r0
            androidx.concurrent.futures.AbstractResolvableFuture r4 = (androidx.concurrent.futures.AbstractResolvableFuture) r4
            java.lang.Object r0 = r4.f1722b
            if (r0 != 0) goto L_0x004d
            r5 = 1
            goto L_0x004e
        L_0x004d:
            r5 = 0
        L_0x004e:
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            r5 = r5 | r6
            if (r5 == 0) goto L_0x0062
            r5 = 1
            goto L_0x0028
        L_0x0055:
            r0.cancel(r8)
            goto L_0x0062
        L_0x0059:
            java.lang.Object r0 = r4.f1722b
            boolean r6 = r0 instanceof androidx.concurrent.futures.AbstractResolvableFuture.SetFuture
            if (r6 != 0) goto L_0x0028
            r1 = r5
            goto L_0x0062
        L_0x0061:
            r1 = 0
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.concurrent.futures.AbstractResolvableFuture.cancel(boolean):boolean");
    }

    public final V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long j3 = j2;
        TimeUnit timeUnit2 = timeUnit;
        long nanos = timeUnit2.toNanos(j3);
        if (!Thread.interrupted()) {
            Object obj = this.f1722b;
            if ((obj != null) && (!(obj instanceof SetFuture))) {
                return h(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0;
            if (nanos >= 1000) {
                Waiter waiter = this.f1724d;
                if (waiter != Waiter.f1742c) {
                    Waiter waiter2 = new Waiter();
                    do {
                        waiter2.a(waiter);
                        if (f1720g.c(this, waiter, waiter2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f1722b;
                                    if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                                        return h(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    n(waiter2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            n(waiter2);
                        } else {
                            waiter = this.f1724d;
                        }
                    } while (waiter != Waiter.f1742c);
                }
                return h(this.f1722b);
            }
            while (nanos > 0) {
                Object obj3 = this.f1722b;
                if ((obj3 != null) && (!(obj3 instanceof SetFuture))) {
                    return h(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String abstractResolvableFuture = toString();
            String obj4 = timeUnit.toString();
            Locale locale = Locale.ROOT;
            String lowerCase = obj4.toLowerCase(locale);
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
            throw new TimeoutException(str + " for " + abstractResolvableFuture);
        }
        throw new InterruptedException();
    }

    public final boolean isCancelled() {
        return this.f1722b instanceof Cancellation;
    }

    public final boolean isDone() {
        boolean z2;
        Object obj = this.f1722b;
        if (obj != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        return (!(obj instanceof SetFuture)) & z2;
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public String l() {
        Object obj = this.f1722b;
        if (obj instanceof SetFuture) {
            return "setFuture=[" + q(((SetFuture) obj).f1741c) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* access modifiers changed from: protected */
    public boolean o(V v2) {
        if (v2 == null) {
            v2 = f1721h;
        }
        if (!f1720g.b(this, (Object) null, v2)) {
            return false;
        }
        f(this);
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean p(Throwable th) {
        if (!f1720g.b(this, (Object) null, new Failure((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = l();
            } catch (RuntimeException e2) {
                str = "Exception thrown from implementation: " + e2.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f1722b;
            if ((obj2 != null) && (!(obj2 instanceof SetFuture))) {
                return h(obj2);
            }
            Waiter waiter = this.f1724d;
            if (waiter != Waiter.f1742c) {
                Waiter waiter2 = new Waiter();
                do {
                    waiter2.a(waiter);
                    if (f1720g.c(this, waiter, waiter2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f1722b;
                            } else {
                                n(waiter2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof SetFuture))));
                        return h(obj);
                    }
                    waiter = this.f1724d;
                } while (waiter != Waiter.f1742c);
            }
            return h(this.f1722b);
        }
        throw new InterruptedException();
    }
}
