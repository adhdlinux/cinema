package kotlinx.coroutines;

import kotlin.Unit;

public final class DisposeOnCompletion extends JobNode {

    /* renamed from: f  reason: collision with root package name */
    private final DisposableHandle f40635f;

    public DisposeOnCompletion(DisposableHandle disposableHandle) {
        this.f40635f = disposableHandle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return Unit.f40298a;
    }

    public void r(Throwable th) {
        this.f40635f.dispose();
    }
}
