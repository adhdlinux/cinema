package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

public final class CompletedWithCancellation {

    /* renamed from: a  reason: collision with root package name */
    public final Object f40606a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1<Throwable, Unit> f40607b;

    public CompletedWithCancellation(Object obj, Function1<? super Throwable, Unit> function1) {
        this.f40606a = obj;
        this.f40607b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompletedWithCancellation)) {
            return false;
        }
        CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
        return Intrinsics.a(this.f40606a, completedWithCancellation.f40606a) && Intrinsics.a(this.f40607b, completedWithCancellation.f40607b);
    }

    public int hashCode() {
        Object obj = this.f40606a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.f40607b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f40606a + ", onCancellation=" + this.f40607b + ')';
    }
}
