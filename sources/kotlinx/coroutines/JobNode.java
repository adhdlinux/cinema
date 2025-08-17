package kotlinx.coroutines;

import kotlin.jvm.internal.Intrinsics;

public abstract class JobNode extends CompletionHandlerBase implements DisposableHandle, Incomplete {

    /* renamed from: e  reason: collision with root package name */
    public JobSupport f40663e;

    public NodeList a() {
        return null;
    }

    public void dispose() {
        s().g0(this);
    }

    public boolean isActive() {
        return true;
    }

    public final JobSupport s() {
        JobSupport jobSupport = this.f40663e;
        if (jobSupport != null) {
            return jobSupport;
        }
        Intrinsics.x("job");
        return null;
    }

    public final void t(JobSupport jobSupport) {
        this.f40663e = jobSupport;
    }

    public String toString() {
        return DebugStringsKt.a(this) + '@' + DebugStringsKt.b(this) + "[job@" + DebugStringsKt.b(s()) + ']';
    }
}
