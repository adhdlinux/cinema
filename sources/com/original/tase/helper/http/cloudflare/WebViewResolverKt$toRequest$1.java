package com.original.tase.helper.http.cloudflare;

import android.webkit.WebResourceRequest;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Request;

final class WebViewResolverKt$toRequest$1 extends Lambda implements Function0<Request> {

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ WebResourceRequest f34000f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ String f34001g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolverKt$toRequest$1(WebResourceRequest webResourceRequest, String str) {
        super(0);
        this.f34000f = webResourceRequest;
        this.f34001g = str;
    }

    /* renamed from: b */
    public final Request invoke() {
        String method = this.f34000f.getMethod();
        Intrinsics.e(method, "getMethod(...)");
        String str = this.f34001g;
        Map<String, String> requestHeaders = this.f34000f.getRequestHeaders();
        Intrinsics.e(requestHeaders, "getRequestHeaders(...)");
        return WebViewResolverKt.h(method, str, requestHeaders, (String) null, 8, (Object) null);
    }
}
