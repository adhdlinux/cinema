package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

final class SynchronizedLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private Function0<? extends T> f40271b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f40272c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f40273d;

    public SynchronizedLazyImpl(Function0<? extends T> function0, Object obj) {
        Intrinsics.f(function0, "initializer");
        this.f40271b = function0;
        this.f40272c = UNINITIALIZED_VALUE.f40292a;
        this.f40273d = obj == null ? this : obj;
    }

    public boolean a() {
        return this.f40272c != UNINITIALIZED_VALUE.f40292a;
    }

    public T getValue() {
        T t2;
        T t3 = this.f40272c;
        T t4 = UNINITIALIZED_VALUE.f40292a;
        if (t3 != t4) {
            return t3;
        }
        synchronized (this.f40273d) {
            t2 = this.f40272c;
            if (t2 == t4) {
                Function0 function0 = this.f40271b;
                Intrinsics.c(function0);
                t2 = function0.invoke();
                this.f40272c = t2;
                this.f40271b = null;
            }
        }
        return t2;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SynchronizedLazyImpl(Function0 function0, Object obj, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i2 & 2) != 0 ? null : obj);
    }
}
