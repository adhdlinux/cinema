package kotlinx.coroutines;

import kotlin.Unit;

public final class ChildHandleNode extends JobCancellingNode implements ChildHandle {

    /* renamed from: f  reason: collision with root package name */
    public final ChildJob f40598f;

    public ChildHandleNode(ChildJob childJob) {
        this.f40598f = childJob;
    }

    public boolean b(Throwable th) {
        return s().x(th);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        r((Throwable) obj);
        return Unit.f40298a;
    }

    public void r(Throwable th) {
        this.f40598f.v(s());
    }
}
