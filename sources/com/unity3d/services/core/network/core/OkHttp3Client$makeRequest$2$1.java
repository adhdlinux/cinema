package com.unity3d.services.core.network.core;

import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public final class OkHttp3Client$makeRequest$2$1 implements Callback {
    final /* synthetic */ CancellableContinuation<Response> $continuation;

    OkHttp3Client$makeRequest$2$1(CancellableContinuation<? super Response> cancellableContinuation) {
        this.$continuation = cancellableContinuation;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.f(call, "call");
        Intrinsics.f(iOException, "e");
        CancellableContinuation<Response> cancellableContinuation = this.$continuation;
        Result.Companion companion = Result.f40263c;
        cancellableContinuation.resumeWith(Result.b(ResultKt.a(iOException)));
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        this.$continuation.resumeWith(Result.b(response));
    }
}
