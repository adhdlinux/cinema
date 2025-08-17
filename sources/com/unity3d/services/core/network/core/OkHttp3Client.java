package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class OkHttp3Client implements HttpClient {
    /* access modifiers changed from: private */
    public final OkHttpClient client;
    private final ISDKDispatchers dispatchers;

    public OkHttp3Client(ISDKDispatchers iSDKDispatchers, OkHttpClient okHttpClient) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        Intrinsics.f(okHttpClient, "client");
        this.dispatchers = iSDKDispatchers;
        this.client = okHttpClient;
    }

    /* access modifiers changed from: private */
    public final Object makeRequest(Request request, long j2, long j3, Continuation<? super Response> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.A();
        OkHttpClient.Builder newBuilder = this.client.newBuilder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        newBuilder.connectTimeout(j2, timeUnit).readTimeout(j3, timeUnit).build().newCall(request).enqueue(new OkHttp3Client$makeRequest$2$1(cancellableContinuationImpl));
        Object x2 = cancellableContinuationImpl.x();
        if (x2 == IntrinsicsKt__IntrinsicsKt.e()) {
            DebugProbesKt.c(continuation);
        }
        return x2;
    }

    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.e(this.dispatchers.getIo(), new OkHttp3Client$execute$2(httpRequest, this, (Continuation<? super OkHttp3Client$execute$2>) null), continuation);
    }

    public HttpResponse executeBlocking(HttpRequest httpRequest) {
        Intrinsics.f(httpRequest, AdActivity.REQUEST_KEY_EXTRA);
        return (HttpResponse) BuildersKt.c(this.dispatchers.getIo(), new OkHttp3Client$executeBlocking$1(this, httpRequest, (Continuation<? super OkHttp3Client$executeBlocking$1>) null));
    }
}
