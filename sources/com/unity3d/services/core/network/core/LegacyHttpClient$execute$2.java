package com.unity3d.services.core.network.core;

import com.unity3d.services.core.network.mapper.HttpRequestToWebRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.unity3d.services.core.network.core.LegacyHttpClient$execute$2", f = "LegacyHttpClient.kt", l = {}, m = "invokeSuspend")
final class LegacyHttpClient$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyHttpClient$execute$2(HttpRequest httpRequest, Continuation<? super LegacyHttpClient$execute$2> continuation) {
        super(2, continuation);
        this.$request = httpRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyHttpClient$execute$2(this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((LegacyHttpClient$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.label == 0) {
            ResultKt.b(obj);
            WebRequest webRequest = HttpRequestToWebRequestKt.toWebRequest(this.$request);
            String makeRequest = webRequest.makeRequest();
            int responseCode = webRequest.getResponseCode();
            Map<String, List<String>> headers = webRequest.getHeaders();
            String url = webRequest.getUrl().toString();
            if (makeRequest == null) {
                makeRequest = "";
            }
            Intrinsics.e(headers, "headers");
            Intrinsics.e(url, "toString()");
            return new HttpResponse(makeRequest, responseCode, headers, url);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
