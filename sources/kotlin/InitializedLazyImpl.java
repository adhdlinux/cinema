package kotlin;

import java.io.Serializable;

public final class InitializedLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final T f40254b;

    public InitializedLazyImpl(T t2) {
        this.f40254b = t2;
    }

    public T getValue() {
        return this.f40254b;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
