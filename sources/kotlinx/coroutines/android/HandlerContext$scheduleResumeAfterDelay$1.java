package kotlinx.coroutines.android;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class HandlerContext$scheduleResumeAfterDelay$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ HandlerContext f40705f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Runnable f40706g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandlerContext$scheduleResumeAfterDelay$1(HandlerContext handlerContext, Runnable runnable) {
        super(1);
        this.f40705f = handlerContext;
        this.f40706g = runnable;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.f40298a;
    }

    public final void invoke(Throwable th) {
        this.f40705f.f40699c.removeCallbacks(this.f40706g);
    }
}
