package androidx.work;

import androidx.work.ListenableWorker;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
final class CoroutineWorker$startWork$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f12164i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ CoroutineWorker f12165j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoroutineWorker$startWork$1(CoroutineWorker coroutineWorker, Continuation<? super CoroutineWorker$startWork$1> continuation) {
        super(2, continuation);
        this.f12165j = coroutineWorker;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CoroutineWorker$startWork$1(this.f12165j, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CoroutineWorker$startWork$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.f12164i;
        if (i2 == 0) {
            ResultKt.b(obj);
            CoroutineWorker coroutineWorker = this.f12165j;
            this.f12164i = 1;
            obj = coroutineWorker.a(this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            try {
                ResultKt.b(obj);
            } catch (Throwable th) {
                this.f12165j.g().p(th);
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f12165j.g().o((ListenableWorker.Result) obj);
        return Unit.f40298a;
    }
}
