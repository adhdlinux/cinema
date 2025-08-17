package o1;

import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

public final /* synthetic */ class a implements DisposableHandle {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HandlerContext f41310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f41311c;

    public /* synthetic */ a(HandlerContext handlerContext, Runnable runnable) {
        this.f41310b = handlerContext;
        this.f41311c = runnable;
    }

    public final void dispose() {
        HandlerContext.x0(this.f41310b, this.f41311c);
    }
}
