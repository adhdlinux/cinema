package com.unity3d.services.core.network.core;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.vungle.ads.internal.ui.AdActivity;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

public final class LegacyHttpClient implements HttpClient {
    private final ISDKDispatchers dispatchers;

    public LegacyHttpClient(ISDKDispatchers iSDKDispatchers) {
        Intrinsics.f(iSDKDispatchers, "dispatchers");
        this.dispatchers = iSDKDispatchers;
    }

    public Object execute(HttpRequest httpRequest, Continuation<? super HttpResponse> continuation) {
        return BuildersKt.e(this.dispatchers.getIo(), new LegacyHttpClient$execute$2(httpRequest, (Continuation<? super LegacyHttpClient$execute$2>) null), continuation);
    }

    public HttpResponse executeBlocking(HttpRequest httpRequest) {
        Intrinsics.f(httpRequest, AdActivity.REQUEST_KEY_EXTRA);
        return (HttpResponse) BuildersKt.c(this.dispatchers.getIo(), new LegacyHttpClient$executeBlocking$1(this, httpRequest, (Continuation<? super LegacyHttpClient$executeBlocking$1>) null));
    }
}
