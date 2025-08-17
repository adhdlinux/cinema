package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

final class MutexImpl$CancellableContinuationWithOwner$tryResume$token$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MutexImpl f40848f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ MutexImpl.CancellableContinuationWithOwner f40849g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$CancellableContinuationWithOwner$tryResume$token$1(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        super(1);
        this.f40848f = mutexImpl;
        this.f40849g = cancellableContinuationWithOwner;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        MutexImpl.f40841i.set(this.f40848f, this.f40849g.f40844c);
        this.f40848f.b(this.f40849g.f40844c);
    }
}
