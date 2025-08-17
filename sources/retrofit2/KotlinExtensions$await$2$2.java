package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ CancellableContinuation<T> $continuation;

    KotlinExtensions$await$2$2(CancellableContinuation<? super T> cancellableContinuation) {
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
            T body = response.body();
            if (body == null) {
                Object tag = call.request().tag(Invocation.class);
                Intrinsics.c(tag);
                Invocation invocation = (Invocation) tag;
                Class<?> service = invocation.service();
                Method method = invocation.method();
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + service.getName() + '.' + method.getName() + " was null but response body type was declared as non-null");
                CancellableContinuation<T> cancellableContinuation = this.$continuation;
                Result.Companion companion = Result.f40263c;
                cancellableContinuation.resumeWith(Result.b(ResultKt.a(kotlinNullPointerException)));
                return;
            }
            this.$continuation.resumeWith(Result.b(body));
            return;
        }
        CancellableContinuation<T> cancellableContinuation2 = this.$continuation;
        Result.Companion companion2 = Result.f40263c;
        cancellableContinuation2.resumeWith(Result.b(ResultKt.a(new HttpException(response))));
    }
}
