package okhttp3.internal.http;

import kotlin.jvm.internal.Intrinsics;

public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    private HttpMethod() {
    }

    public static final boolean permitsRequestBody(String str) {
        Intrinsics.f(str, "method");
        if (Intrinsics.a(str, "GET") || Intrinsics.a(str, "HEAD")) {
            return false;
        }
        return true;
    }

    public static final boolean requiresRequestBody(String str) {
        Intrinsics.f(str, "method");
        if (Intrinsics.a(str, "POST") || Intrinsics.a(str, "PUT") || Intrinsics.a(str, "PATCH") || Intrinsics.a(str, "PROPPATCH") || Intrinsics.a(str, "REPORT")) {
            return true;
        }
        return false;
    }

    public final boolean invalidatesCache(String str) {
        Intrinsics.f(str, "method");
        if (Intrinsics.a(str, "POST") || Intrinsics.a(str, "PATCH") || Intrinsics.a(str, "PUT") || Intrinsics.a(str, "DELETE") || Intrinsics.a(str, "MOVE")) {
            return true;
        }
        return false;
    }

    public final boolean redirectsToGet(String str) {
        Intrinsics.f(str, "method");
        return !Intrinsics.a(str, "PROPFIND");
    }

    public final boolean redirectsWithBody(String str) {
        Intrinsics.f(str, "method");
        return Intrinsics.a(str, "PROPFIND");
    }
}
