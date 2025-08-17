package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public final class Futures extends GwtFuturesCatchingSpecialization {

    private static final class CallbackListener<V> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final Future<V> f30769b;

        /* renamed from: c  reason: collision with root package name */
        final FutureCallback<? super V> f30770c;

        CallbackListener(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.f30769b = future;
            this.f30770c = futureCallback;
        }

        public void run() {
            Throwable a2;
            Future<V> future = this.f30769b;
            if (!(future instanceof InternalFutureFailureAccess) || (a2 = InternalFutures.a((InternalFutureFailureAccess) future)) == null) {
                try {
                    this.f30770c.onSuccess(Futures.b(this.f30769b));
                } catch (ExecutionException e2) {
                    this.f30770c.onFailure(e2.getCause());
                } catch (Throwable th) {
                    this.f30770c.onFailure(th);
                }
            } else {
                this.f30770c.onFailure(a2);
            }
        }

        public String toString() {
            return MoreObjects.b(this).h(this.f30770c).toString();
        }
    }

    private Futures() {
    }

    public static <V> void a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        Preconditions.l(futureCallback);
        listenableFuture.addListener(new CallbackListener(listenableFuture, futureCallback), executor);
    }

    public static <V> V b(Future<V> future) throws ExecutionException {
        Preconditions.s(future.isDone(), "Future was expected to be done: %s", future);
        return Uninterruptibles.a(future);
    }
}
