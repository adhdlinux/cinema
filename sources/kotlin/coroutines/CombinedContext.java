package kotlin.coroutines;

import com.facebook.react.uimanager.ViewProps;
import java.io.Serializable;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public final class CombinedContext implements CoroutineContext, Serializable {

    /* renamed from: b  reason: collision with root package name */
    private final CoroutineContext f40353b;

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext.Element f40354c;

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.Element element) {
        Intrinsics.f(coroutineContext, ViewProps.LEFT);
        Intrinsics.f(element, "element");
        this.f40353b = coroutineContext;
        this.f40354c = element;
    }

    private final boolean b(CoroutineContext.Element element) {
        return Intrinsics.a(get(element.getKey()), element);
    }

    private final boolean c(CombinedContext combinedContext) {
        while (b(combinedContext.f40354c)) {
            CoroutineContext coroutineContext = combinedContext.f40353b;
            if (coroutineContext instanceof CombinedContext) {
                combinedContext = (CombinedContext) coroutineContext;
            } else {
                Intrinsics.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((CoroutineContext.Element) coroutineContext);
            }
        }
        return false;
    }

    private final int d() {
        int i2 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.f40353b;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i2;
            }
            i2++;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                if (combinedContext.d() != d() || !combinedContext.c(this)) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        Intrinsics.f(function2, "operation");
        return function2.invoke(this.f40353b.fold(r2, function2), this.f40354c);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.f(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            E e2 = combinedContext.f40354c.get(key);
            if (e2 != null) {
                return e2;
            }
            CoroutineContext coroutineContext = combinedContext.f40353b;
            if (!(coroutineContext instanceof CombinedContext)) {
                return coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.f40353b.hashCode() + this.f40354c.hashCode();
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.f(key, "key");
        if (this.f40354c.get(key) != null) {
            return this.f40353b;
        }
        CoroutineContext minusKey = this.f40353b.minusKey(key);
        if (minusKey == this.f40353b) {
            return this;
        }
        if (minusKey == EmptyCoroutineContext.f40358b) {
            return this.f40354c;
        }
        return new CombinedContext(minusKey, this.f40354c);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold("", CombinedContext$toString$1.f40355f)) + ']';
    }
}
