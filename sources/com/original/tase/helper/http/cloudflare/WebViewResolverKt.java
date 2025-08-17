package com.original.tase.helper.http.cloudflare;

import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ImagesContract;
import com.original.tase.Logger;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.http.cloudflare.CloudflareKiller;
import com.uwetrottmann.trakt5.TraktV2;
import com.vungle.ads.internal.ui.AdActivity;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class WebViewResolverKt {
    public static final boolean a(Request request) {
        String str;
        Intrinsics.f(request, AdActivity.REQUEST_KEY_EXTRA);
        CookieManager instance = CookieManager.getInstance();
        if (instance != null) {
            str = instance.getCookie(request.url().toString());
        } else {
            str = null;
        }
        if (str == null || !StringsKt__StringsKt.L(str, "cf_clearance", false, 2, (Object) null)) {
            return false;
        }
        CloudflareKiller.Companion companion = CloudflareKiller.f33901a;
        companion.a().put(request.url().host(), companion.b(str));
        HttpHelper.i().D(request.url().scheme() + "://" + request.url().host(), str);
        return true;
    }

    public static final Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.f(coroutineScope, "<this>");
        Intrinsics.f(coroutineContext, "context");
        Intrinsics.f(coroutineStart, ViewProps.START);
        Intrinsics.f(function2, "block");
        return BuildersKt.a(coroutineScope, coroutineContext, coroutineStart, new WebViewResolverKt$launchSafe$obj$1(function2, (Continuation<? super WebViewResolverKt$launchSafe$obj$1>) null));
    }

    public static /* synthetic */ Job c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f40358b;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return b(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Job d(T t2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.f(function2, "work");
        return c(CoroutineScopeKt.a(Dispatchers.c()), (CoroutineContext) null, (CoroutineStart) null, new WebViewResolverKt$main$1(function2, t2, (Continuation<? super WebViewResolverKt$main$1>) null), 3, (Object) null);
    }

    public static final <T, V> Object e(V v2, Function3<? super CoroutineScope, ? super V, ? super Continuation<? super T>, ? extends Object> function3, Continuation<? super T> continuation) {
        return BuildersKt.e(Dispatchers.c(), new WebViewResolverKt$mainWork$2(function3, v2, (Continuation<? super WebViewResolverKt$mainWork$2>) null), continuation);
    }

    public static final <T> T f(Function0<? extends T> function0) {
        Intrinsics.f(function0, "apiCall");
        try {
            return function0.invoke();
        } catch (Throwable th) {
            Logger.d(th, new boolean[0]);
            return null;
        }
    }

    public static final Request g(String str, String str2, Map<String, String> map, String str3) {
        Intrinsics.f(str, "method");
        Intrinsics.f(str2, ImagesContract.URL);
        Intrinsics.f(map, "headers");
        HttpUrl parse = HttpUrl.Companion.parse(str2);
        if (parse != null) {
            Request.Builder method = new Request.Builder().url(parse).method(str, (RequestBody) null);
            if (map.isEmpty()) {
                method.headers(Headers.Companion.of(map));
            }
            if (str3 != null) {
                method.addHeader("Referer", str3);
            }
            return method.build();
        }
        throw new IllegalArgumentException("Invalid URL: " + str2);
    }

    public static /* synthetic */ Request h(String str, String str2, Map map, String str3, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            map = MapsKt__MapsKt.g();
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return g(str, str2, map, str3);
    }

    public static final <T> List<T> i(T... tArr) {
        Intrinsics.f(tArr, "items");
        List<T> synchronizedList = Collections.synchronizedList(ArraysKt___ArraysKt.R(tArr));
        Intrinsics.e(synchronizedList, "synchronizedList(...)");
        return synchronizedList;
    }

    public static final Request j(WebResourceRequest webResourceRequest) {
        Intrinsics.f(webResourceRequest, "<this>");
        String uri = webResourceRequest.getUrl().toString();
        Intrinsics.e(uri, "toString(...)");
        return (Request) f(new WebViewResolverKt$toRequest$1(webResourceRequest, uri));
    }

    public static final WebResourceResponse k(Response response) {
        WebResourceResponse webResourceResponse;
        InputStream inputStream;
        String str;
        List<String> a2;
        List<String> a3;
        String str2;
        Intrinsics.f(response, "<this>");
        InputStream inputStream2 = null;
        String header$default = Response.header$default(response, TraktV2.HEADER_CONTENT_TYPE, (String) null, 2, (Object) null);
        Regex regex = new Regex("(.*);(?:.*charset=(.*)(?:|;)|)");
        if (header$default != null) {
            MatchResult c2 = Regex.c(regex, header$default, 0, 2, (Object) null);
            if (!(c2 == null || (a3 = c2.a()) == null || (str2 = (String) CollectionsKt___CollectionsKt.E(a3, 1)) == null)) {
                if (StringsKt__StringsJVMKt.v(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    header$default = str2;
                }
            }
            if (c2 == null || (a2 = c2.a()) == null || (str = (String) CollectionsKt___CollectionsKt.E(a2, 2)) == null || StringsKt__StringsJVMKt.v(str)) {
                str = null;
            }
            ResponseBody body = response.body();
            if (body != null) {
                inputStream2 = body.byteStream();
            }
            webResourceResponse = new WebResourceResponse(header$default, str, inputStream2);
        } else {
            ResponseBody body2 = response.body();
            if (body2 != null) {
                inputStream = body2.byteStream();
            } else {
                inputStream = null;
            }
            webResourceResponse = new WebResourceResponse("application/octet-stream", (String) null, inputStream);
        }
        return webResourceResponse;
    }
}
