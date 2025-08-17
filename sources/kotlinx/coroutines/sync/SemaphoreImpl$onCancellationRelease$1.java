package kotlinx.coroutines.sync;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class SemaphoreImpl$onCancellationRelease$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ SemaphoreImpl f40863f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SemaphoreImpl$onCancellationRelease$1(SemaphoreImpl semaphoreImpl) {
        super(1);
        this.f40863f = semaphoreImpl;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        this.f40863f.h();
    }
}
