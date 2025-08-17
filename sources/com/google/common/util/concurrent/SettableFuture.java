package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;

public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    private SettableFuture() {
    }

    public static <V> SettableFuture<V> C() {
        return new SettableFuture<>();
    }

    public boolean A(V v2) {
        return super.A(v2);
    }

    public boolean B(Throwable th) {
        return super.B(th);
    }

    public /* bridge */ /* synthetic */ Object get() throws InterruptedException, ExecutionException {
        return super.get();
    }
}
