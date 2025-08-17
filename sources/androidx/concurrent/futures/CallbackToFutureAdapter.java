package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class CallbackToFutureAdapter {

    public static final class Completer<T> {

        /* renamed from: a  reason: collision with root package name */
        Object f1745a;

        /* renamed from: b  reason: collision with root package name */
        SafeFuture<T> f1746b;

        /* renamed from: c  reason: collision with root package name */
        private ResolvableFuture<Void> f1747c = ResolvableFuture.r();

        /* renamed from: d  reason: collision with root package name */
        private boolean f1748d;

        Completer() {
        }

        private void d() {
            this.f1745a = null;
            this.f1746b = null;
            this.f1747c = null;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f1745a = null;
            this.f1746b = null;
            this.f1747c.o(null);
        }

        public boolean b(T t2) {
            boolean z2 = true;
            this.f1748d = true;
            SafeFuture<T> safeFuture = this.f1746b;
            if (safeFuture == null || !safeFuture.b(t2)) {
                z2 = false;
            }
            if (z2) {
                d();
            }
            return z2;
        }

        public boolean c() {
            boolean z2 = true;
            this.f1748d = true;
            SafeFuture<T> safeFuture = this.f1746b;
            if (safeFuture == null || !safeFuture.a(true)) {
                z2 = false;
            }
            if (z2) {
                d();
            }
            return z2;
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            ResolvableFuture<Void> resolvableFuture;
            SafeFuture<T> safeFuture = this.f1746b;
            if (safeFuture != null && !safeFuture.isDone()) {
                safeFuture.c(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1745a));
            }
            if (!this.f1748d && (resolvableFuture = this.f1747c) != null) {
                resolvableFuture.o(null);
            }
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface Resolver<T> {
        Object attachCompleter(Completer<T> completer) throws Exception;
    }

    private static final class SafeFuture<T> implements ListenableFuture<T> {

        /* renamed from: b  reason: collision with root package name */
        final WeakReference<Completer<T>> f1749b;

        /* renamed from: c  reason: collision with root package name */
        private final AbstractResolvableFuture<T> f1750c = new AbstractResolvableFuture<T>() {
            /* access modifiers changed from: protected */
            public String l() {
                Completer completer = SafeFuture.this.f1749b.get();
                if (completer == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + completer.f1745a + "]";
            }
        };

        SafeFuture(Completer<T> completer) {
            this.f1749b = new WeakReference<>(completer);
        }

        /* access modifiers changed from: package-private */
        public boolean a(boolean z2) {
            return this.f1750c.cancel(z2);
        }

        public void addListener(Runnable runnable, Executor executor) {
            this.f1750c.addListener(runnable, executor);
        }

        /* access modifiers changed from: package-private */
        public boolean b(T t2) {
            return this.f1750c.o(t2);
        }

        /* access modifiers changed from: package-private */
        public boolean c(Throwable th) {
            return this.f1750c.p(th);
        }

        public boolean cancel(boolean z2) {
            Completer completer = this.f1749b.get();
            boolean cancel = this.f1750c.cancel(z2);
            if (cancel && completer != null) {
                completer.a();
            }
            return cancel;
        }

        public T get() throws InterruptedException, ExecutionException {
            return this.f1750c.get();
        }

        public boolean isCancelled() {
            return this.f1750c.isCancelled();
        }

        public boolean isDone() {
            return this.f1750c.isDone();
        }

        public String toString() {
            return this.f1750c.toString();
        }

        public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.f1750c.get(j2, timeUnit);
        }
    }

    private CallbackToFutureAdapter() {
    }

    public static <T> ListenableFuture<T> a(Resolver<T> resolver) {
        Completer completer = new Completer();
        SafeFuture<T> safeFuture = new SafeFuture<>(completer);
        completer.f1746b = safeFuture;
        completer.f1745a = resolver.getClass();
        try {
            Object attachCompleter = resolver.attachCompleter(completer);
            if (attachCompleter != null) {
                completer.f1745a = attachCompleter;
            }
        } catch (Exception e2) {
            safeFuture.c(e2);
        }
        return safeFuture;
    }
}
