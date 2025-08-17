package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

public final class UnsafeLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private Function0<? extends T> f40299b;

    /* renamed from: c  reason: collision with root package name */
    private Object f40300c = UNINITIALIZED_VALUE.f40292a;

    public UnsafeLazyImpl(Function0<? extends T> function0) {
        Intrinsics.f(function0, "initializer");
        this.f40299b = function0;
    }

    public boolean a() {
        return this.f40300c != UNINITIALIZED_VALUE.f40292a;
    }

    public T getValue() {
        if (this.f40300c == UNINITIALIZED_VALUE.f40292a) {
            Function0<? extends T> function0 = this.f40299b;
            Intrinsics.c(function0);
            this.f40300c = function0.invoke();
            this.f40299b = null;
        }
        return this.f40300c;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
