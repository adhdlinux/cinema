package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.DefaultConstructorMarker;

public class CompletedExceptionally {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f40604b = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f40605a;

    public CompletedExceptionally(Throwable th, boolean z2) {
        this.f40605a = th;
        this._handled = z2 ? 1 : 0;
    }

    public final boolean a() {
        if (f40604b.get(this) != 0) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        return f40604b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return DebugStringsKt.a(this) + '[' + this.f40605a + ']';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CompletedExceptionally(Throwable th, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i2 & 2) != 0 ? false : z2);
    }
}
