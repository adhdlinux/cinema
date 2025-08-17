package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.NonDisposableHandle;
import o1.a;

public final class HandlerContext extends HandlerDispatcher {
    private volatile HandlerContext _immediate;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Handler f40699c;

    /* renamed from: d  reason: collision with root package name */
    private final String f40700d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f40701e;

    /* renamed from: f  reason: collision with root package name */
    private final HandlerContext f40702f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private HandlerContext(Handler handler, String str, boolean z2) {
        super((DefaultConstructorMarker) null);
        HandlerContext handlerContext = null;
        this.f40699c = handler;
        this.f40700d = str;
        this.f40701e = z2;
        this._immediate = z2 ? this : handlerContext;
        HandlerContext handlerContext2 = this._immediate;
        if (handlerContext2 == null) {
            handlerContext2 = new HandlerContext(handler, str, true);
            this._immediate = handlerContext2;
        }
        this.f40702f = handlerContext2;
    }

    private final void v0(CoroutineContext coroutineContext, Runnable runnable) {
        JobKt.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.b().o0(coroutineContext, runnable);
    }

    /* access modifiers changed from: private */
    public static final void x0(HandlerContext handlerContext, Runnable runnable) {
        handlerContext.f40699c.removeCallbacks(runnable);
    }

    public DisposableHandle A(long j2, Runnable runnable, CoroutineContext coroutineContext) {
        if (this.f40699c.postDelayed(runnable, RangesKt___RangesKt.e(j2, 4611686018427387903L))) {
            return new a(this, runnable);
        }
        v0(coroutineContext, runnable);
        return NonDisposableHandle.f40684b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).f40699c == this.f40699c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f40699c);
    }

    public void k(long j2, CancellableContinuation<? super Unit> cancellableContinuation) {
        HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 = new HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(cancellableContinuation, this);
        if (this.f40699c.postDelayed(handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1, RangesKt___RangesKt.e(j2, 4611686018427387903L))) {
            cancellableContinuation.b(new HandlerContext$scheduleResumeAfterDelay$1(this, handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1));
        } else {
            v0(cancellableContinuation.getContext(), handlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1);
        }
    }

    public void o0(CoroutineContext coroutineContext, Runnable runnable) {
        if (!this.f40699c.post(runnable)) {
            v0(coroutineContext, runnable);
        }
    }

    public boolean p0(CoroutineContext coroutineContext) {
        return !this.f40701e || !Intrinsics.a(Looper.myLooper(), this.f40699c.getLooper());
    }

    public String toString() {
        String s02 = s0();
        if (s02 != null) {
            return s02;
        }
        String str = this.f40700d;
        if (str == null) {
            str = this.f40699c.toString();
        }
        if (!this.f40701e) {
            return str;
        }
        return str + ".immediate";
    }

    /* renamed from: w0 */
    public HandlerContext r0() {
        return this.f40702f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
