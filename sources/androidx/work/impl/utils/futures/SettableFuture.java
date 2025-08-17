package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

public final class SettableFuture<V> extends AbstractFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> s() {
        return new SettableFuture<>();
    }

    public boolean o(V v2) {
        return super.o(v2);
    }

    public boolean p(Throwable th) {
        return super.p(th);
    }

    public boolean q(ListenableFuture<? extends V> listenableFuture) {
        return super.q(listenableFuture);
    }
}
