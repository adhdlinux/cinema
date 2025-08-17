package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;

final class MutexImpl$CancellableContinuationWithOwner$resume$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ MutexImpl f40846f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ MutexImpl.CancellableContinuationWithOwner f40847g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutexImpl$CancellableContinuationWithOwner$resume$2(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        super(1);
        this.f40846f = mutexImpl;
        this.f40847g = cancellableContinuationWithOwner;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        this.f40846f.b(this.f40847g.f40844c);
    }
}
