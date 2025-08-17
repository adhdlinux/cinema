package kotlin;

import androidx.concurrent.futures.a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f40266e = new Companion((DefaultConstructorMarker) null);

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> f40267f = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "c");

    /* renamed from: b  reason: collision with root package name */
    private volatile Function0<? extends T> f40268b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Object f40269c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f40270d;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SafePublicationLazyImpl(Function0<? extends T> function0) {
        Intrinsics.f(function0, "initializer");
        this.f40268b = function0;
        UNINITIALIZED_VALUE uninitialized_value = UNINITIALIZED_VALUE.f40292a;
        this.f40269c = uninitialized_value;
        this.f40270d = uninitialized_value;
    }

    public boolean a() {
        return this.f40269c != UNINITIALIZED_VALUE.f40292a;
    }

    public T getValue() {
        T t2 = this.f40269c;
        T t3 = UNINITIALIZED_VALUE.f40292a;
        if (t2 != t3) {
            return t2;
        }
        Function0<? extends T> function0 = this.f40268b;
        if (function0 != null) {
            T invoke = function0.invoke();
            if (a.a(f40267f, this, t3, invoke)) {
                this.f40268b = null;
                return invoke;
            }
        }
        return this.f40269c;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
