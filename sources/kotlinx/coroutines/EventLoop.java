package kotlinx.coroutines;

import com.facebook.common.time.Clock;
import kotlin.collections.ArrayDeque;

public abstract class EventLoop extends CoroutineDispatcher {

    /* renamed from: c  reason: collision with root package name */
    private long f40637c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f40638d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayDeque<DispatchedTask<?>> f40639e;

    public static /* synthetic */ void s0(EventLoop eventLoop, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            eventLoop.r0(z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
    }

    private final long t0(boolean z2) {
        return z2 ? 4294967296L : 1;
    }

    public static /* synthetic */ void x0(EventLoop eventLoop, boolean z2, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 1) != 0) {
                z2 = false;
            }
            eventLoop.w0(z2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public long A0() {
        if (!B0()) {
            return Clock.MAX_TIME;
        }
        return 0;
    }

    public final boolean B0() {
        DispatchedTask l2;
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.f40639e;
        if (arrayDeque == null || (l2 = arrayDeque.l()) == null) {
            return false;
        }
        l2.run();
        return true;
    }

    public boolean C0() {
        return false;
    }

    public final void r0(boolean z2) {
        long t02 = this.f40637c - t0(z2);
        this.f40637c = t02;
        if (t02 <= 0 && this.f40638d) {
            shutdown();
        }
    }

    public void shutdown() {
    }

    public final void u0(DispatchedTask<?> dispatchedTask) {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.f40639e;
        if (arrayDeque == null) {
            arrayDeque = new ArrayDeque<>();
            this.f40639e = arrayDeque;
        }
        arrayDeque.addLast(dispatchedTask);
    }

    /* access modifiers changed from: protected */
    public long v0() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.f40639e;
        if (arrayDeque != null && !arrayDeque.isEmpty()) {
            return 0;
        }
        return Clock.MAX_TIME;
    }

    public final void w0(boolean z2) {
        this.f40637c += t0(z2);
        if (!z2) {
            this.f40638d = true;
        }
    }

    public final boolean y0() {
        return this.f40637c >= t0(true);
    }

    public final boolean z0() {
        ArrayDeque<DispatchedTask<?>> arrayDeque = this.f40639e;
        if (arrayDeque != null) {
            return arrayDeque.isEmpty();
        }
        return true;
    }
}
