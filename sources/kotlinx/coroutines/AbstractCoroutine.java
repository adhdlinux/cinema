package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

public abstract class AbstractCoroutine<T> extends JobSupport implements Continuation<T>, CoroutineScope {

    /* renamed from: d  reason: collision with root package name */
    private final CoroutineContext f40584d;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z2, boolean z3) {
        super(z3);
        if (z2) {
            R((Job) coroutineContext.get(Job.E0));
        }
        this.f40584d = coroutineContext.plus(this);
    }

    public final void Q(Throwable th) {
        CoroutineExceptionHandlerKt.a(this.f40584d, th);
    }

    public String X() {
        String b2 = CoroutineContextKt.b(this.f40584d);
        if (b2 == null) {
            return super.X();
        }
        return '\"' + b2 + "\":" + super.X();
    }

    public CoroutineContext c() {
        return this.f40584d;
    }

    /* access modifiers changed from: protected */
    public final void c0(Object obj) {
        if (obj instanceof CompletedExceptionally) {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            v0(completedExceptionally.f40605a, completedExceptionally.a());
            return;
        }
        w0(obj);
    }

    public final CoroutineContext getContext() {
        return this.f40584d;
    }

    public boolean isActive() {
        return super.isActive();
    }

    public final void resumeWith(Object obj) {
        Object V = V(CompletionStateKt.d(obj, (Function1) null, 1, (Object) null));
        if (V != JobSupportKt.f40677b) {
            u0(V);
        }
    }

    /* access modifiers changed from: protected */
    public void u0(Object obj) {
        n(obj);
    }

    /* access modifiers changed from: protected */
    public void v0(Throwable th, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public String w() {
        return DebugStringsKt.a(this) + " was cancelled";
    }

    /* access modifiers changed from: protected */
    public void w0(T t2) {
    }

    public final <R> void x0(CoroutineStart coroutineStart, R r2, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.b(function2, r2, this);
    }
}
