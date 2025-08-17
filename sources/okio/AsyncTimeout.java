package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long IDLE_TIMEOUT_MILLIS;
    /* access modifiers changed from: private */
    public static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    /* access modifiers changed from: private */
    public static final Condition condition;
    /* access modifiers changed from: private */
    public static AsyncTimeout head;
    /* access modifiers changed from: private */
    public static final ReentrantLock lock;
    /* access modifiers changed from: private */
    public boolean inQueue;
    /* access modifiers changed from: private */
    public AsyncTimeout next;
    /* access modifiers changed from: private */
    public long timeoutAt;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean d(AsyncTimeout asyncTimeout) {
            ReentrantLock f2 = AsyncTimeout.Companion.f();
            f2.lock();
            try {
                if (!asyncTimeout.inQueue) {
                    return false;
                }
                asyncTimeout.inQueue = false;
                for (AsyncTimeout access$getHead$cp = AsyncTimeout.head; access$getHead$cp != null; access$getHead$cp = access$getHead$cp.next) {
                    if (access$getHead$cp.next == asyncTimeout) {
                        access$getHead$cp.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        f2.unlock();
                        return false;
                    }
                }
                f2.unlock();
                return true;
            } finally {
                f2.unlock();
            }
        }

        /* access modifiers changed from: private */
        public final void g(AsyncTimeout asyncTimeout, long j2, boolean z2) {
            ReentrantLock f2 = AsyncTimeout.Companion.f();
            f2.lock();
            try {
                if (!asyncTimeout.inQueue) {
                    asyncTimeout.inQueue = true;
                    if (AsyncTimeout.head == null) {
                        AsyncTimeout.head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                    if (i2 != 0 && z2) {
                        asyncTimeout.timeoutAt = Math.min(j2, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (i2 != 0) {
                        asyncTimeout.timeoutAt = j2 + nanoTime;
                    } else if (z2) {
                        asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long access$remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                    AsyncTimeout access$getHead$cp = AsyncTimeout.head;
                    Intrinsics.c(access$getHead$cp);
                    while (true) {
                        if (access$getHead$cp.next == null) {
                            break;
                        }
                        AsyncTimeout access$getNext$p = access$getHead$cp.next;
                        Intrinsics.c(access$getNext$p);
                        if (access$remainingNanos < access$getNext$p.remainingNanos(nanoTime)) {
                            break;
                        }
                        access$getHead$cp = access$getHead$cp.next;
                        Intrinsics.c(access$getHead$cp);
                    }
                    asyncTimeout.next = access$getHead$cp.next;
                    access$getHead$cp.next = asyncTimeout;
                    if (access$getHead$cp == AsyncTimeout.head) {
                        AsyncTimeout.Companion.e().signal();
                    }
                    Unit unit = Unit.f40298a;
                    return;
                }
                throw new IllegalStateException("Unbalanced enter/exit".toString());
            } finally {
                f2.unlock();
            }
        }

        public final AsyncTimeout c() throws InterruptedException {
            AsyncTimeout access$getHead$cp = AsyncTimeout.head;
            Intrinsics.c(access$getHead$cp);
            AsyncTimeout access$getNext$p = access$getHead$cp.next;
            if (access$getNext$p == null) {
                long nanoTime = System.nanoTime();
                e().await(AsyncTimeout.IDLE_TIMEOUT_MILLIS, TimeUnit.MILLISECONDS);
                AsyncTimeout access$getHead$cp2 = AsyncTimeout.head;
                Intrinsics.c(access$getHead$cp2);
                if (access$getHead$cp2.next != null || System.nanoTime() - nanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long access$remainingNanos = access$getNext$p.remainingNanos(System.nanoTime());
            if (access$remainingNanos > 0) {
                e().await(access$remainingNanos, TimeUnit.NANOSECONDS);
                return null;
            }
            AsyncTimeout access$getHead$cp3 = AsyncTimeout.head;
            Intrinsics.c(access$getHead$cp3);
            access$getHead$cp3.next = access$getNext$p.next;
            access$getNext$p.next = null;
            return access$getNext$p;
        }

        public final Condition e() {
            return AsyncTimeout.condition;
        }

        public final ReentrantLock f() {
            return AsyncTimeout.lock;
        }
    }

    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|(5:5|6|7|19|8)(5:9|10|11|12|(2:14|23)(1:22))|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            r1.unlock();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            throw r0;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:18:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r3 = this;
            L_0x0000:
                okio.AsyncTimeout$Companion r0 = okio.AsyncTimeout.Companion     // Catch:{ InterruptedException -> 0x0000 }
                java.util.concurrent.locks.ReentrantLock r1 = r0.f()     // Catch:{ InterruptedException -> 0x0000 }
                r1.lock()     // Catch:{ InterruptedException -> 0x0000 }
                okio.AsyncTimeout r0 = r0.c()     // Catch:{ all -> 0x0026 }
                okio.AsyncTimeout r2 = okio.AsyncTimeout.head     // Catch:{ all -> 0x0026 }
                if (r0 != r2) goto L_0x001b
                r0 = 0
                okio.AsyncTimeout.head = r0     // Catch:{ all -> 0x0026 }
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                return
            L_0x001b:
                kotlin.Unit r2 = kotlin.Unit.f40298a     // Catch:{ all -> 0x0026 }
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                if (r0 == 0) goto L_0x0000
                r0.timedOut()     // Catch:{ InterruptedException -> 0x0000 }
                goto L_0x0000
            L_0x0026:
                r0 = move-exception
                r1.unlock()     // Catch:{ InterruptedException -> 0x0000 }
                throw r0     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.AsyncTimeout.Watchdog.run():void");
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        lock = reentrantLock;
        Condition newCondition = reentrantLock.newCondition();
        Intrinsics.e(newCondition, "newCondition(...)");
        condition = newCondition;
        long millis = TimeUnit.SECONDS.toMillis(60);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* access modifiers changed from: private */
    public final long remainingNanos(long j2) {
        return this.timeoutAt - j2;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Companion.g(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.d(this);
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(Sink sink) {
        Intrinsics.f(sink, "sink");
        return new AsyncTimeout$sink$1(this, sink);
    }

    public final Source source(Source source) {
        Intrinsics.f(source, "source");
        return new AsyncTimeout$source$1(this, source);
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> function0) {
        Intrinsics.f(function0, "block");
        enter();
        try {
            T invoke = function0.invoke();
            InlineMarker.b(1);
            if (!exit()) {
                InlineMarker.a(1);
                return invoke;
            }
            throw access$newTimeoutException((IOException) null);
        } catch (IOException e2) {
            e = e2;
            if (exit()) {
                e = access$newTimeoutException(e);
            }
            throw e;
        } catch (Throwable th) {
            InlineMarker.b(1);
            boolean exit = exit();
            InlineMarker.a(1);
            throw th;
        }
    }
}
