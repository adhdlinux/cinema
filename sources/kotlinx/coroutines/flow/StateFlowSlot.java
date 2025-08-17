package kotlinx.coroutines.flow;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f40714a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    private volatile Object _state;

    public final void a() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f40714a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != null && obj != StateFlowKt.f40713b) {
                if (obj == StateFlowKt.f40712a) {
                    if (a.a(f40714a, this, obj, StateFlowKt.f40713b)) {
                        return;
                    }
                } else if (a.a(f40714a, this, obj, StateFlowKt.f40712a)) {
                    Result.Companion companion = Result.f40263c;
                    ((CancellableContinuationImpl) obj).resumeWith(Result.b(Unit.f40298a));
                    return;
                }
            } else {
                return;
            }
        }
    }
}
