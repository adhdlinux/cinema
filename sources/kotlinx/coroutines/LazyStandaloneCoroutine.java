package kotlinx.coroutines;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.CancellableKt;

final class LazyStandaloneCoroutine extends StandaloneCoroutine {

    /* renamed from: e  reason: collision with root package name */
    private final Continuation<Unit> f40683e;

    public LazyStandaloneCoroutine(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        super(coroutineContext, false);
        this.f40683e = IntrinsicsKt__IntrinsicsJvmKt.a(function2, this, this);
    }

    /* access modifiers changed from: protected */
    public void d0() {
        CancellableKt.b(this.f40683e, this);
    }
}
