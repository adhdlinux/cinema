package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class InvokeOnCompletion extends JobNode {

    /* renamed from: f  reason: collision with root package name */
    private final Function1<Throwable, Unit> f40659f;

    public InvokeOnCompletion(Function1<? super Throwable, Unit> function1) {
        this.f40659f = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return Unit.f40298a;
    }

    public void r(Throwable th) {
        this.f40659f.invoke(th);
    }
}
