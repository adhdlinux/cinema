package retrofit2;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

final class KotlinExtensions$suspendAndThrow$2$1 implements Runnable {
    final /* synthetic */ Continuation<?> $continuation;
    final /* synthetic */ Throwable $this_suspendAndThrow;

    KotlinExtensions$suspendAndThrow$2$1(Continuation<?> continuation, Throwable th) {
        this.$continuation = continuation;
        this.$this_suspendAndThrow = th;
    }

    public final void run() {
        Continuation c2 = IntrinsicsKt__IntrinsicsJvmKt.c(this.$continuation);
        Result.Companion companion = Result.f40263c;
        c2.resumeWith(Result.b(ResultKt.a(this.$this_suspendAndThrow)));
    }
}
