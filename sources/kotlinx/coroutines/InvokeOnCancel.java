package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

final class InvokeOnCancel extends CancelHandler {

    /* renamed from: b  reason: collision with root package name */
    private final Function1<Throwable, Unit> f40656b;

    public InvokeOnCancel(Function1<? super Throwable, Unit> function1) {
        this.f40656b = function1;
    }

    public void a(Throwable th) {
        this.f40656b.invoke(th);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f40298a;
    }

    public String toString() {
        return "InvokeOnCancel[" + DebugStringsKt.a(this.f40656b) + '@' + DebugStringsKt.b(this) + ']';
    }
}
