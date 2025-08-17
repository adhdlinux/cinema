package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@DebugMetadata(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {104}, m = "withTimeoutOrNull")
final class TimeoutKt$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: i  reason: collision with root package name */
    long f40689i;

    /* renamed from: j  reason: collision with root package name */
    Object f40690j;

    /* renamed from: k  reason: collision with root package name */
    Object f40691k;

    /* renamed from: l  reason: collision with root package name */
    /* synthetic */ Object f40692l;

    /* renamed from: m  reason: collision with root package name */
    int f40693m;

    TimeoutKt$withTimeoutOrNull$1(Continuation<? super TimeoutKt$withTimeoutOrNull$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.f40692l = obj;
        this.f40693m |= Integer.MIN_VALUE;
        return TimeoutKt.d(0, (Function2) null, this);
    }
}
