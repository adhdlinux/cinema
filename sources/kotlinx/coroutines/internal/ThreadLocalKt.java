package kotlinx.coroutines.internal;

public final class ThreadLocalKt {
    public static final <T> ThreadLocal<T> a(Symbol symbol) {
        return new ThreadLocal<>();
    }
}
