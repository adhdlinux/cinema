package androidx.concurrent.futures;

public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    private ResolvableFuture() {
    }

    public static <V> ResolvableFuture<V> r() {
        return new ResolvableFuture<>();
    }

    public boolean o(V v2) {
        return super.o(v2);
    }

    public boolean p(Throwable th) {
        return super.p(th);
    }
}
