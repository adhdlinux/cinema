package kotlinx.coroutines.flow;

import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.internal.Symbol;

public final class StateFlowKt {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Symbol f40712a = new Symbol("NONE");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Symbol f40713b = new Symbol("PENDING");

    public static final <T> MutableStateFlow<T> a(T t2) {
        if (t2 == null) {
            t2 = NullSurrogateKt.f40716a;
        }
        return new StateFlowImpl(t2);
    }
}
