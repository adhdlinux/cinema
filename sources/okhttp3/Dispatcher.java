package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            RealCall.AsyncCall next = it2.next();
            if (Intrinsics.a(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it3 = this.readyAsyncCalls.iterator();
        while (it3.hasNext()) {
            RealCall.AsyncCall next2 = it3.next();
            if (Intrinsics.a(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t2) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t2)) {
                runnable = this.idleCallback;
                Unit unit = Unit.f40298a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    private final boolean promoteAndExecute() {
        int i2;
        boolean z2;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
                Intrinsics.e(it2, "readyAsyncCalls.iterator()");
                while (it2.hasNext()) {
                    RealCall.AsyncCall next = it2.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it2.remove();
                        next.getCallsPerHost().incrementAndGet();
                        Intrinsics.e(next, "asyncCall");
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                if (runningCallsCount() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Unit unit = Unit.f40298a;
            }
            int size = arrayList.size();
            for (i2 = 0; i2 < size; i2++) {
                ((RealCall.AsyncCall) arrayList.get(i2)).executeOn(executorService());
            }
            return z2;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* renamed from: -deprecated_executorService  reason: not valid java name */
    public final ExecutorService m263deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().getCall().cancel();
        }
        Iterator<RealCall.AsyncCall> it3 = this.runningAsyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().getCall().cancel();
        }
        Iterator<RealCall> it4 = this.runningSyncCalls.iterator();
        while (it4.hasNext()) {
            it4.next().cancel();
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall findExistingCallWithHost;
        Intrinsics.f(asyncCall, "call");
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
            if (!asyncCall.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.getHost())) != null) {
                asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
            Unit unit = Unit.f40298a;
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(RealCall realCall) {
        Intrinsics.f(realCall, "call");
        this.runningSyncCalls.add(realCall);
    }

    public final synchronized ExecutorService executorService() {
        ExecutorService executorService;
        if (this.executorServiceOrNull == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, timeUnit, synchronousQueue, Util.threadFactory(Util.okHttpName + " Dispatcher", false));
        }
        executorService = this.executorServiceOrNull;
        Intrinsics.c(executorService);
        return executorService;
    }

    public final void finished$okhttp(RealCall.AsyncCall asyncCall) {
        Intrinsics.f(asyncCall, "call");
        asyncCall.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized List<Call> queuedCalls() {
        List<Call> unmodifiableList;
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(arrayDeque, 10));
        for (RealCall.AsyncCall call : arrayDeque) {
            arrayList.add(call.getCall());
        }
        unmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.e(unmodifiableList, "unmodifiableList(readyAsyncCalls.map { it.call })");
        return unmodifiableList;
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized List<Call> runningCalls() {
        List<Call> unmodifiableList;
        ArrayDeque<RealCall> arrayDeque = this.runningSyncCalls;
        ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(arrayDeque2, 10));
        for (RealCall.AsyncCall call : arrayDeque2) {
            arrayList.add(call.getCall());
        }
        unmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.N(arrayDeque, arrayList));
        Intrinsics.e(unmodifiableList, "unmodifiableList(running…yncCalls.map { it.call })");
        return unmodifiableList;
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i2) {
        boolean z2 = true;
        if (i2 < 1) {
            z2 = false;
        }
        if (z2) {
            synchronized (this) {
                this.maxRequests = i2;
                Unit unit = Unit.f40298a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i2).toString());
    }

    public final void setMaxRequestsPerHost(int i2) {
        boolean z2 = true;
        if (i2 < 1) {
            z2 = false;
        }
        if (z2) {
            synchronized (this) {
                this.maxRequestsPerHost = i2;
                Unit unit = Unit.f40298a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i2).toString());
    }

    public final void finished$okhttp(RealCall realCall) {
        Intrinsics.f(realCall, "call");
        finished(this.runningSyncCalls, realCall);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Dispatcher(ExecutorService executorService) {
        this();
        Intrinsics.f(executorService, "executorService");
        this.executorServiceOrNull = executorService;
    }
}
