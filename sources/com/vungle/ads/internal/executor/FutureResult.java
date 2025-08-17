package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class FutureResult<T> implements Future<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String TAG = FutureResult.class.getSimpleName();
    private final Future<T> future;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getTAG() {
            return FutureResult.TAG;
        }
    }

    public FutureResult(Future<T> future2) {
        this.future = future2;
    }

    public boolean cancel(boolean z2) {
        Future<T> future2 = this.future;
        if (future2 != null) {
            return future2.cancel(z2);
        }
        return false;
    }

    public T get() {
        try {
            Future<T> future2 = this.future;
            if (future2 != null) {
                return future2.get();
            }
            return null;
        } catch (InterruptedException unused) {
            Logger.Companion companion = Logger.Companion;
            String str = TAG;
            Intrinsics.e(str, "TAG");
            companion.w(str, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            Logger.Companion companion2 = Logger.Companion;
            String str2 = TAG;
            Intrinsics.e(str2, "TAG");
            companion2.e(str2, "error on execution", e2);
            return null;
        }
    }

    public final Future<T> getFuture() {
        return this.future;
    }

    public boolean isCancelled() {
        Future<T> future2 = this.future;
        if (future2 != null) {
            return future2.isCancelled();
        }
        return false;
    }

    public boolean isDone() {
        Future<T> future2 = this.future;
        if (future2 != null) {
            return future2.isDone();
        }
        return false;
    }

    public T get(long j2, TimeUnit timeUnit) {
        Intrinsics.f(timeUnit, "unit");
        try {
            Future<T> future2 = this.future;
            if (future2 != null) {
                return future2.get(j2, timeUnit);
            }
            return null;
        } catch (InterruptedException unused) {
            Logger.Companion companion = Logger.Companion;
            String str = TAG;
            Intrinsics.e(str, "TAG");
            companion.w(str, "future.get() Interrupted on Thread " + Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            return null;
        } catch (ExecutionException e2) {
            Logger.Companion companion2 = Logger.Companion;
            String str2 = TAG;
            Intrinsics.e(str2, "TAG");
            companion2.e(str2, "error on execution", e2);
            return null;
        } catch (TimeoutException e3) {
            Logger.Companion companion3 = Logger.Companion;
            String str3 = TAG;
            Intrinsics.e(str3, "TAG");
            companion3.e(str3, "error on timeout", e3);
            Intrinsics.e(str3, "TAG");
            companion3.w(str3, "future.get() Timeout on Thread " + Thread.currentThread().getName());
            return null;
        }
    }
}
