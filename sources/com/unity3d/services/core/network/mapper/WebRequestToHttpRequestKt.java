package com.unity3d.services.core.network.mapper;

import com.unity3d.services.core.network.model.BodyType;
import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.RequestType;
import com.unity3d.services.core.request.WebRequest;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class WebRequestToHttpRequestKt {
    public static final HttpRequest toHttpRequest(WebRequest webRequest) {
        Intrinsics.f(webRequest, "<this>");
        String url = webRequest.getUrl().toString();
        String requestType = webRequest.getRequestType();
        Intrinsics.e(requestType, "requestType");
        RequestType valueOf = RequestType.valueOf(requestType);
        Map<String, List<String>> headers = webRequest.getHeaders();
        byte[] body = webRequest.getBody();
        Intrinsics.e(url, "toString()");
        Intrinsics.e(headers, "headers");
        return new HttpRequest(url, (String) null, valueOf, body, headers, (Map) null, (BodyType) null, (String) null, (Integer) null, 0, 0, 0, 0, 8162, (DefaultConstructorMarker) null);
    }
}
