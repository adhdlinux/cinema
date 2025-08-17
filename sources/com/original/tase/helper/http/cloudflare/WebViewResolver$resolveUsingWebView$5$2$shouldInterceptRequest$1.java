package com.original.tase.helper.http.cloudflare;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.original.tase.helper.http.HttpHelper;
import com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$5;
import java.io.InputStream;
import java.net.URI;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Request;
import okhttp3.Response;

@DebugMetadata(c = "com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1", f = "WebViewResolver.kt", l = {}, m = "invokeSuspend")
final class WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WebResourceResponse>, Object> {

    /* renamed from: i  reason: collision with root package name */
    int f33971i;

    /* renamed from: j  reason: collision with root package name */
    final /* synthetic */ WebResourceRequest f33972j;

    /* renamed from: k  reason: collision with root package name */
    final /* synthetic */ Request f33973k;

    /* renamed from: l  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<Request> f33974l;

    /* renamed from: m  reason: collision with root package name */
    final /* synthetic */ WebViewResolver f33975m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ List<Request> f33976n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ WebViewResolver$resolveUsingWebView$5.AnonymousClass2 f33977o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ WebView f33978p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ Function1<Request, Boolean> f33979q;

    /* renamed from: r  reason: collision with root package name */
    final /* synthetic */ Ref$ObjectRef<WebView> f33980r;

    /* renamed from: s  reason: collision with root package name */
    final /* synthetic */ Ref$BooleanRef f33981s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1(WebResourceRequest webResourceRequest, Request request, Ref$ObjectRef<Request> ref$ObjectRef, WebViewResolver webViewResolver, List<Request> list, WebViewResolver$resolveUsingWebView$5.AnonymousClass2 r6, WebView webView, Function1<? super Request, Boolean> function1, Ref$ObjectRef<WebView> ref$ObjectRef2, Ref$BooleanRef ref$BooleanRef, Continuation<? super WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1> continuation) {
        super(2, continuation);
        this.f33972j = webResourceRequest;
        this.f33973k = request;
        this.f33974l = ref$ObjectRef;
        this.f33975m = webViewResolver;
        this.f33976n = list;
        this.f33977o = r6;
        this.f33978p = webView;
        this.f33979q = function1;
        this.f33980r = ref$ObjectRef2;
        this.f33981s = ref$BooleanRef;
    }

    /* access modifiers changed from: private */
    public static final void i(WebView webView, WebViewResolver webViewResolver) {
        webView.evaluateJavascript(String.valueOf(webViewResolver.f()), new b(webViewResolver));
    }

    /* access modifiers changed from: private */
    public static final void j(WebViewResolver webViewResolver, String str) {
        Function1<String, Unit> g2 = webViewResolver.g();
        if (g2 != null) {
            Intrinsics.c(str);
            g2.invoke(str);
        }
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1(this.f33972j, this.f33973k, this.f33974l, this.f33975m, this.f33976n, this.f33977o, this.f33978p, this.f33979q, this.f33980r, this.f33981s, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super WebResourceResponse> continuation) {
        return ((WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
    }

    public final Object invokeSuspend(Object obj) {
        boolean z2;
        boolean z3;
        WebResourceResponse webResourceResponse;
        Request j2;
        Object unused = IntrinsicsKt__IntrinsicsKt.e();
        if (this.f33971i == 0) {
            ResultKt.b(obj);
            String uri = this.f33972j.getUrl().toString();
            Intrinsics.e(uri, "toString(...)");
            System.out.println("Loading WebView URL: " + uri);
            if (WebViewResolverKt.a(this.f33973k)) {
                Ref$ObjectRef<Request> ref$ObjectRef = this.f33974l;
                T j3 = WebViewResolverKt.j(this.f33972j);
                if (j3 != null) {
                    this.f33979q.invoke(j3);
                } else {
                    j3 = null;
                }
                ref$ObjectRef.f40429b = j3;
                WebViewResolver.n(this.f33975m, this.f33980r, this.f33981s);
                return null;
            }
            if (this.f33975m.f() != null) {
                new Handler(Looper.getMainLooper()).post(new a(this.f33978p, this.f33975m));
            }
            if (this.f33975m.e().a(uri)) {
                Ref$ObjectRef<Request> ref$ObjectRef2 = this.f33974l;
                T j4 = WebViewResolverKt.j(this.f33972j);
                if (j4 != null) {
                    this.f33979q.invoke(j4);
                } else {
                    j4 = null;
                }
                ref$ObjectRef2.f40429b = j4;
                System.out.println("Web-view request finished: " + uri);
                WebViewResolver.n(this.f33975m, this.f33980r, this.f33981s);
                return null;
            }
            Iterable d2 = this.f33975m.d();
            if (!(d2 instanceof Collection) || !((Collection) d2).isEmpty()) {
                Iterator it2 = d2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((Regex) it2.next()).a(uri)) {
                            z2 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z2 = false;
            if (z2 && (j2 = WebViewResolverKt.j(this.f33972j)) != null) {
                Function1<Request, Boolean> function1 = this.f33979q;
                WebViewResolver webViewResolver = this.f33975m;
                Ref$ObjectRef<WebView> ref$ObjectRef3 = this.f33980r;
                Ref$BooleanRef ref$BooleanRef = this.f33981s;
                if (function1.invoke(j2).booleanValue()) {
                    WebViewResolver.n(webViewResolver, ref$ObjectRef3, ref$BooleanRef);
                }
                Boxing.a(this.f33976n.add(j2));
            }
            try {
                Iterable i2 = CollectionsKt__CollectionsKt.i(".jpg", ".png", ".webp", ".mpg", ".mpeg", ".jpeg", ".webm", ".mp4", ".mp3", ".gifv", ".flv", ".asf", ".mov", ".mng", ".mkv", ".ogg", ".avi", ".wav", ".woff2", ".woff", ".ttf", ".css", ".vtt", ".srt", ".ts", ".gif", ".m3u8", "wss://");
                if (!(i2 instanceof Collection) || !((Collection) i2).isEmpty()) {
                    Iterator it3 = i2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        String path = new URI(uri).getPath();
                        Intrinsics.e(path, "getPath(...)");
                        if (StringsKt__StringsKt.L(path, (String) it3.next(), false, 2, (Object) null)) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (!z3) {
                    if (!StringsKt__StringsJVMKt.s(uri, "/favicon.ico", false, 2, (Object) null)) {
                        if (!StringsKt__StringsKt.L(uri, "recaptcha", false, 2, (Object) null)) {
                            if (!StringsKt__StringsKt.L(uri, "/cdn-cgi/", false, 2, (Object) null)) {
                                if (!this.f33975m.h() || !Intrinsics.a(this.f33972j.getMethod(), "GET")) {
                                    if (!this.f33975m.h() || !Intrinsics.a(this.f33972j.getMethod(), "POST")) {
                                        webResourceResponse = WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1.super.shouldInterceptRequest(this.f33978p, this.f33972j);
                                    } else {
                                        Response C = HttpHelper.i().C(uri, "", this.f33972j.getRequestHeaders());
                                        Intrinsics.e(C, "postWithJson(...)");
                                        webResourceResponse = WebViewResolverKt.k(C);
                                    }
                                    return webResourceResponse;
                                }
                                Response e2 = HttpHelper.i().e(uri, this.f33972j.getRequestHeaders());
                                Intrinsics.e(e2, "getResponse(...)");
                                webResourceResponse = WebViewResolverKt.k(e2);
                                return webResourceResponse;
                            }
                        }
                        webResourceResponse = WebViewResolver$resolveUsingWebView$5$2$shouldInterceptRequest$1.super.shouldInterceptRequest(this.f33978p, this.f33972j);
                        return webResourceResponse;
                    }
                }
                webResourceResponse = new WebResourceResponse("image/png", (String) null, (InputStream) null);
                return webResourceResponse;
            } catch (Exception unused2) {
                return null;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
