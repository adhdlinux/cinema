package kotlinx.coroutines.android;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

public final class HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ CancellableContinuation f40703b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ HandlerContext f40704c;

    public HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
        this.f40703b = cancellableContinuation;
        this.f40704c = handlerContext;
    }

    public final void run() {
        this.f40703b.g(this.f40704c, Unit.f40298a);
    }
}
