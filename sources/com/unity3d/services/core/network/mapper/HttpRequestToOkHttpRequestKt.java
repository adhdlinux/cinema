package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.HttpRequest;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public final class HttpRequestToOkHttpRequestKt {
    private static final RequestBody generateOkHttpBody(Object obj) {
        if (obj instanceof byte[]) {
            RequestBody create = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (byte[]) obj);
            Intrinsics.e(create, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create;
        } else if (obj instanceof String) {
            RequestBody create2 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), (String) obj);
            Intrinsics.e(create2, "create(MediaType.parse(\"…in;charset=utf-8\"), body)");
            return create2;
        } else {
            RequestBody create3 = RequestBody.create(MediaType.parse("text/plain;charset=utf-8"), "");
            Intrinsics.e(create3, "create(MediaType.parse(\"…lain;charset=utf-8\"), \"\")");
            return create3;
        }
    }

    private static final Headers generateOkHttpHeaders(HttpRequest httpRequest) {
        Headers.Builder builder = new Headers.Builder();
        for (Map.Entry next : httpRequest.getHeaders().entrySet()) {
            builder.add((String) next.getKey(), CollectionsKt___CollectionsKt.J((List) next.getValue(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        Headers build = builder.build();
        Intrinsics.e(build, "Builder()\n    .also { he…ng(\",\")) } }\n    .build()");
        return build;
    }

    public static final Request toOkHttpRequest(HttpRequest httpRequest) {
        RequestBody requestBody;
        Intrinsics.f(httpRequest, "<this>");
        Request.Builder builder = new Request.Builder();
        Request.Builder url = builder.url(StringsKt__StringsKt.n0(StringsKt__StringsKt.O0(httpRequest.getBaseURL(), '/') + '/' + StringsKt__StringsKt.O0(httpRequest.getPath(), '/'), "/"));
        String obj = httpRequest.getMethod().toString();
        Object body = httpRequest.getBody();
        if (body != null) {
            requestBody = generateOkHttpBody(body);
        } else {
            requestBody = null;
        }
        Request build = url.method(obj, requestBody).headers(generateOkHttpHeaders(httpRequest)).build();
        Intrinsics.e(build, "Builder()\n    .url(\"${ba…tpHeaders())\n    .build()");
        return build;
    }
}
