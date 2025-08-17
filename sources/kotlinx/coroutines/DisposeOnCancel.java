package kotlinx.coroutines;

import kotlin.Unit;

final class DisposeOnCancel extends CancelHandler {

    /* renamed from: b  reason: collision with root package name */
    private final DisposableHandle f40634b;

    public DisposeOnCancel(DisposableHandle disposableHandle) {
        this.f40634b = disposableHandle;
    }

    public void a(Throwable th) {
        this.f40634b.dispose();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Throwable) obj);
        return Unit.f40298a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f40634b + ']';
    }
}
