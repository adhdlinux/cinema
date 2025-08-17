package kotlinx.coroutines;

import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CoroutineName extends AbstractCoroutineContextElement {

    /* renamed from: c  reason: collision with root package name */
    public static final Key f40615c = new Key((DefaultConstructorMarker) null);

    /* renamed from: b  reason: collision with root package name */
    private final String f40616b;

    public static final class Key implements CoroutineContext.Key<CoroutineName> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineName(String str) {
        super(f40615c);
        this.f40616b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineName) && Intrinsics.a(this.f40616b, ((CoroutineName) obj).f40616b);
    }

    public int hashCode() {
        return this.f40616b.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.f40616b + ')';
    }
}
