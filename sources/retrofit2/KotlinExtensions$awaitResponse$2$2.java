package retrofit2;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation<Response<T>> $continuation;

    KotlinExtensions$awaitResponse$2$2(CancellableContinuation<? super Response<T>> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.f(call, "call");
        Intrinsics.f(th, "t");
        CancellableContinuation<Response<T>> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.f40263c;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(th)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        this.$continuation.resumeWith(Result.b(response));
    }
}
