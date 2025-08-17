package kotlin;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

final class DeepRecursiveScopeImpl<T, R> extends DeepRecursiveScope<T, R> implements Continuation<R> {

    /* renamed from: b  reason: collision with root package name */
    private Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> f40250b;

    /* renamed from: c  reason: collision with root package name */
    private Object f40251c;

    /* renamed from: d  reason: collision with root package name */
    private Continuation<Object> f40252d = this;

    /* renamed from: e  reason: collision with root package name */
    private Object f40253e = DeepRecursiveKt.f40249a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeepRecursiveScopeImpl(Function3<? super DeepRecursiveScope<T, R>, ? super T, ? super Continuation<? super R>, ? extends Object> function3, T t2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.f(function3, "block");
        this.f40250b = function3;
        this.f40251c = t2;
        Intrinsics.d(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
    }

    public Object a(T t2, Continuation<? super R> continuation) {
        Intrinsics.d(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f40252d = continuation;
        this.f40251c = t2;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        if (e2 == IntrinsicsKt__IntrinsicsKt.e()) {
            DebugProbesKt.c(continuation);
        }
        return e2;
    }

    public final R c() {
        Object obj;
        while (true) {
            R r2 = this.f40253e;
            Continuation<Object> continuation = this.f40252d;
            if (continuation == null) {
                ResultKt.b(r2);
                return r2;
            } else if (Result.d(DeepRecursiveKt.f40249a, r2)) {
                try {
                    Function3<? super DeepRecursiveScope<?, ?>, Object, ? super Continuation<Object>, ? extends Object> function3 = this.f40250b;
                    Object obj2 = this.f40251c;
                    if (!(function3 instanceof BaseContinuationImpl)) {
                        obj = IntrinsicsKt__IntrinsicsJvmKt.d(function3, this, obj2, continuation);
                    } else {
                        obj = ((Function3) TypeIntrinsics.b(function3, 3)).invoke(this, obj2, continuation);
                    }
                    if (obj != IntrinsicsKt__IntrinsicsKt.e()) {
                        continuation.resumeWith(Result.b(obj));
                    }
                } catch (Throwable th) {
                    Result.Companion companion = Result.f40263c;
                    continuation.resumeWith(Result.b(ResultKt.a(th)));
                }
            } else {
                this.f40253e = DeepRecursiveKt.f40249a;
                continuation.resumeWith(r2);
            }
        }
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.f40358b;
    }

    public void resumeWith(Object obj) {
        this.f40252d = null;
        this.f40253e = obj;
    }
}
