package com.unity3d.services.core.network.model;

import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class HttpResponse {
    private final Object body;
    private final Map<String, Object> headers;
    private final int statusCode;
    private final String urlString;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj) {
        this(obj, 0, (Map) null, (String) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.f(obj, "body");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj, int i2) {
        this(obj, i2, (Map) null, (String) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.f(obj, "body");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HttpResponse(Object obj, int i2, Map<String, ? extends Object> map) {
        this(obj, i2, map, (String) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.f(obj, "body");
        Intrinsics.f(map, "headers");
    }

    public HttpResponse(Object obj, int i2, Map<String, ? extends Object> map, String str) {
        Intrinsics.f(obj, "body");
        Intrinsics.f(map, "headers");
        Intrinsics.f(str, "urlString");
        this.body = obj;
        this.statusCode = i2;
        this.headers = map;
        this.urlString = str;
    }

    public static /* synthetic */ HttpResponse copy$default(HttpResponse httpResponse, Object obj, int i2, Map<String, Object> map, String str, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = httpResponse.body;
        }
        if ((i3 & 2) != 0) {
            i2 = httpResponse.statusCode;
        }
        if ((i3 & 4) != 0) {
            map = httpResponse.headers;
        }
        if ((i3 & 8) != 0) {
            str = httpResponse.urlString;
        }
        return httpResponse.copy(obj, i2, map, str);
    }

    public final Object component1() {
        return this.body;
    }

    public final int component2() {
        return this.statusCode;
    }

    public final Map<String, Object> component3() {
        return this.headers;
    }

    public final String component4() {
        return this.urlString;
    }

    public final HttpResponse copy(Object obj, int i2, Map<String, ? extends Object> map, String str) {
        Intrinsics.f(obj, "body");
        Intrinsics.f(map, "headers");
        Intrinsics.f(str, "urlString");
        return new HttpResponse(obj, i2, map, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpResponse)) {
            return false;
        }
        HttpResponse httpResponse = (HttpResponse) obj;
        return Intrinsics.a(this.body, httpResponse.body) && this.statusCode == httpResponse.statusCode && Intrinsics.a(this.headers, httpResponse.headers) && Intrinsics.a(this.urlString, httpResponse.urlString);
    }

    public final Object getBody() {
        return this.body;
    }

    public final Map<String, Object> getHeaders() {
        return this.headers;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getUrlString() {
        return this.urlString;
    }

    public int hashCode() {
        return (((((this.body.hashCode() * 31) + this.statusCode) * 31) + this.headers.hashCode()) * 31) + this.urlString.hashCode();
    }

    public String toString() {
        return "HttpResponse(body=" + this.body + ", statusCode=" + this.statusCode + ", headers=" + this.headers + ", urlString=" + this.urlString + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HttpResponse(Object obj, int i2, Map map, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i3 & 2) != 0 ? 200 : i2, (i3 & 4) != 0 ? MapsKt__MapsKt.g() : map, (i3 & 8) != 0 ? "" : str);
    }
}
