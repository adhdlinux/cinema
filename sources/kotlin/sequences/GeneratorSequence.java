package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

final class GeneratorSequence<T> implements Sequence<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Function0<T> f40496a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Function1<T, T> f40497b;

    public GeneratorSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics.f(function0, "getInitialValue");
        Intrinsics.f(function1, "getNextValue");
        this.f40496a = function0;
        this.f40497b = function1;
    }

    public Iterator<T> iterator() {
        return new GeneratorSequence$iterator$1(this);
    }
}
