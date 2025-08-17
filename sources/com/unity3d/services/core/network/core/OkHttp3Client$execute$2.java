package com.unity3d.services.core.network.core;

import com.unity3d.services.core.network.mapper.HttpRequestToOkHttpRequestKt;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
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
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@DebugMetadata(c = "com.unity3d.services.core.network.core.OkHttp3Client$execute$2", f = "OkHttp3Client.kt", l = {47}, m = "invokeSuspend")
final class OkHttp3Client$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ OkHttp3Client this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OkHttp3Client$execute$2(HttpRequest httpRequest, OkHttp3Client okHttp3Client, Continuation<? super OkHttp3Client$execute$2> continuation) {
        super(2, continuation);
        this.$request = httpRequest;
        this.this$0 = okHttp3Client;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OkHttp3Client$execute$2(this.$request, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((OkHttp3Client$execute$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        Object e2 = IntrinsicsKt__IntrinsicsKt.e();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.b(obj);
            Request okHttpRequest = HttpRequestToOkHttpRequestKt.toOkHttpRequest(this.$request);
            this.label = 1;
            obj = this.this$0.makeRequest(okHttpRequest, (long) this.$request.getConnectTimeout(), (long) this.$request.getReadTimeout(), this);
            if (obj == e2) {
                return e2;
            }
        } else if (i2 == 1) {
            ResultKt.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Response response = (Response) obj;
        int code = response.code();
        Map<String, List<String>> multimap = response.headers().toMultimap();
        String httpUrl = response.request().url().toString();
        ResponseBody body = response.body();
        if (body != null) {
            str = body.string();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        Intrinsics.e(multimap, "toMultimap()");
        Intrinsics.e(httpUrl, "toString()");
        return new HttpResponse(str, code, multimap, httpUrl);
    }
}
