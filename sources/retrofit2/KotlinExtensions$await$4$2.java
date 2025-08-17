package retrofit2;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

public final class KotlinExtensions$await$4$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    KotlinExtensions$await$4$2(CancellableContinuation<? super T> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.f(call, "call");
        Intrinsics.f(th, "t");
        CancellableContinuation<T> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.f40263c;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(th)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        if (response.isSuccessful()) {
            CancellableContinuation<T> cancellableContinuation = this.$continuation;
            Result.Companion companion = Result.f40263c;
            cancellableContinuation.resumeWith(Result.b(response.body()));
            return;
        }
        CancellableContinuation<T> cancellableContinuation2 = this.$continuation;
        Result.Companion companion2 = Result.f40263c;
        cancellableContinuation2.resumeWith(Result.b(ResultKt.a(new HttpException(response))));
    }
}
