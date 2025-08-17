package kotlinx.coroutines;

import kotlin.Unit;

public final class ChildContinuation extends JobCancellingNode {

    /* renamed from: f  reason: collision with root package name */
    public final CancellableContinuationImpl<?> f40597f;

    public ChildContinuation(CancellableContinuationImpl<?> cancellableContinuationImpl) {
        this.f40597f = cancellableContinuationImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return Unit.f40298a;
    }

    public void r(Throwable th) {
        CancellableContinuationImpl<?> cancellableContinuationImpl = this.f40597f;
        cancellableContinuationImpl.I(cancellableContinuationImpl.v(s()));
    }
}
