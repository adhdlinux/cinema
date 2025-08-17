package com.original.tase.helper.http.cloudflare;

import android.content.Context;
import android.webkit.WebView;
import com.utils.Utils;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.text.Regex;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class WebViewResolver implements Interceptor {

    /* renamed from: h  reason: collision with root package name */
    public static final Companion f33920h = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static String f33921i;

    /* renamed from: a  reason: collision with root package name */
    private final Regex f33922a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Regex> f33923b;

    /* renamed from: c  reason: collision with root package name */
    private final String f33924c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f33925d;

    /* renamed from: e  reason: collision with root package name */
    private final String f33926e;

    /* renamed from: f  reason: collision with root package name */
    private final Function1<String, Unit> f33927f;

    /* renamed from: g  reason: collision with root package name */
    private final long f33928g;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return WebViewResolver.f33921i;
        }

        public final String b() {
            String a2 = a();
            if (a2 != null) {
                return a2;
            }
            Context v2 = Utils.v();
            if (v2 != null) {
                return (String) BuildersKt__BuildersKt.b((CoroutineContext) null, new WebViewResolver$Companion$getWebViewUserAgent$1$1(v2, (Continuation<? super WebViewResolver$Companion$getWebViewUserAgent$1$1>) null), 1, (Object) null);
            }
            return null;
        }

        public final void c(String str) {
            WebViewResolver.f33921i = str;
        }
    }

    public WebViewResolver(Regex regex, List<Regex> list, String str, boolean z2, String str2, Function1<? super String, Unit> function1, long j2) {
        Intrinsics.f(regex, "interceptUrl");
        Intrinsics.f(list, "additionalUrls");
        this.f33922a = regex;
        this.f33923b = list;
        this.f33924c = str;
        this.f33925d = z2;
        this.f33926e = str2;
        this.f33927f = function1;
        this.f33928g = j2;
    }

    public static /* synthetic */ Object l(WebViewResolver webViewResolver, String str, String str2, String str3, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = "GET";
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            function1 = WebViewResolver$resolveUsingWebView$2.f33941f;
        }
        return webViewResolver.j(str, str4, str5, function1, continuation);
    }

    public static /* synthetic */ Object m(WebViewResolver webViewResolver, Request request, Function1 function1, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            function1 = WebViewResolver$resolveUsingWebView$4.f33953f;
        }
        return webViewResolver.k(request, function1, continuation);
    }

    /* access modifiers changed from: private */
    public static final void n(WebViewResolver webViewResolver, Ref$ObjectRef<WebView> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef) {
        WebViewResolverKt.d(webViewResolver, new WebViewResolver$resolveUsingWebView$destroyWebView$1(ref$ObjectRef, ref$BooleanRef, (Continuation<? super WebViewResolver$resolveUsingWebView$destroyWebView$1>) null));
    }

    public final List<Regex> d() {
        return this.f33923b;
    }

    public final Regex e() {
        return this.f33922a;
    }

    public final String f() {
        return this.f33926e;
    }

    public final Function1<String, Unit> g() {
        return this.f33927f;
    }

    public final boolean h() {
        return this.f33925d;
    }

    public final String i() {
        return this.f33924c;
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        return (Response) BuildersKt__BuildersKt.b((CoroutineContext) null, new WebViewResolver$intercept$1(this, chain.request(), chain, (Continuation<? super WebViewResolver$intercept$1>) null), 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object j(java.lang.String r11, java.lang.String r12, java.lang.String r13, kotlin.jvm.functions.Function1<? super okhttp3.Request, java.lang.Boolean> r14, kotlin.coroutines.Continuation<? super kotlin.Pair<okhttp3.Request, ? extends java.util.List<okhttp3.Request>>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$1 r0 = (com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$1) r0
            int r1 = r0.f33940k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33940k = r1
            goto L_0x0018
        L_0x0013:
            com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$1 r0 = new com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$1
            r0.<init>(r10, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f33938i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f33940k
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.ResultKt.b(r15)     // Catch:{ IllegalArgumentException -> 0x0029 }
            goto L_0x0049
        L_0x0029:
            r11 = move-exception
            goto L_0x004c
        L_0x002b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0033:
            kotlin.ResultKt.b(r15)
            r6 = 0
            r8 = 4
            r9 = 0
            r4 = r13
            r5 = r11
            r7 = r12
            okhttp3.Request r11 = com.original.tase.helper.http.cloudflare.WebViewResolverKt.h(r4, r5, r6, r7, r8, r9)     // Catch:{ IllegalArgumentException -> 0x0029 }
            r0.f33940k = r3     // Catch:{ IllegalArgumentException -> 0x0029 }
            java.lang.Object r15 = r10.k(r11, r14, r0)     // Catch:{ IllegalArgumentException -> 0x0029 }
            if (r15 != r1) goto L_0x0049
            return r1
        L_0x0049:
            kotlin.Pair r15 = (kotlin.Pair) r15     // Catch:{ IllegalArgumentException -> 0x0029 }
            return r15
        L_0x004c:
            r12 = 0
            boolean[] r12 = new boolean[r12]
            com.original.tase.Logger.d(r11, r12)
            r11 = 0
            java.util.List r12 = kotlin.collections.CollectionsKt__CollectionsKt.f()
            kotlin.Pair r11 = kotlin.TuplesKt.a(r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.cloudflare.WebViewResolver.j(java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object k(okhttp3.Request r24, kotlin.jvm.functions.Function1<? super okhttp3.Request, java.lang.Boolean> r25, kotlin.coroutines.Continuation<? super kotlin.Pair<okhttp3.Request, ? extends java.util.List<okhttp3.Request>>> r26) {
        /*
            r23 = this;
            r11 = r23
            r0 = r26
            boolean r1 = r0 instanceof com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$3
            if (r1 == 0) goto L_0x0017
            r1 = r0
            com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$3 r1 = (com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$3) r1
            int r2 = r1.f33952s
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.f33952s = r2
            goto L_0x001c
        L_0x0017:
            com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$3 r1 = new com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$3
            r1.<init>(r11, r0)
        L_0x001c:
            r12 = r1
            java.lang.Object r0 = r12.f33950q
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r1 = r12.f33952s
            r14 = 1
            if (r1 == 0) goto L_0x0052
            if (r1 != r14) goto L_0x004a
            long r1 = r12.f33949p
            long r3 = r12.f33948o
            int r5 = r12.f33947n
            java.lang.Object r6 = r12.f33946m
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r12.f33945l
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r12.f33944k
            kotlin.jvm.internal.Ref$BooleanRef r8 = (kotlin.jvm.internal.Ref$BooleanRef) r8
            java.lang.Object r9 = r12.f33943j
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref$ObjectRef) r9
            java.lang.Object r10 = r12.f33942i
            com.original.tase.helper.http.cloudflare.WebViewResolver r10 = (com.original.tase.helper.http.cloudflare.WebViewResolver) r10
            kotlin.ResultKt.b(r0)
            r0 = 1
            goto L_0x00ea
        L_0x004a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0052:
            kotlin.ResultKt.b(r0)
            okhttp3.HttpUrl r0 = r24.url()
            java.lang.String r2 = r0.toString()
            okhttp3.Headers r3 = r24.headers()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Initial web-view request: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.io.PrintStream r1 = java.lang.System.out
            r1.println(r0)
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            kotlin.jvm.internal.Ref$BooleanRef r16 = new kotlin.jvm.internal.Ref$BooleanRef
            r16.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r17 = new kotlin.jvm.internal.Ref$ObjectRef
            r17.<init>()
            r10 = 0
            okhttp3.Request[] r0 = new okhttp3.Request[r10]
            java.util.List r18 = com.original.tase.helper.http.cloudflare.WebViewResolverKt.i(r0)
            com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$5 r9 = new com.original.tase.helper.http.cloudflare.WebViewResolver$resolveUsingWebView$5
            r19 = 0
            r0 = r9
            r1 = r15
            r4 = r23
            r5 = r25
            r6 = r24
            r7 = r16
            r8 = r17
            r14 = r9
            r9 = r18
            r20 = 0
            r10 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.original.tase.helper.http.cloudflare.WebViewResolverKt.d(r11, r14)
            long r0 = r11.f33928g
            r2 = 40
            r10 = r11
            r9 = r15
            r8 = r16
            r7 = r17
            r6 = r18
            r5 = 0
            r21 = r0
            r1 = r2
            r3 = r21
        L_0x00bc:
            long r14 = (long) r5
            long r16 = r3 / r1
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ec
            boolean r0 = r8.f40425b
            if (r0 != 0) goto L_0x00ec
            T r0 = r7.f40429b
            if (r0 == 0) goto L_0x00d0
            kotlin.Pair r0 = kotlin.TuplesKt.a(r0, r6)
            return r0
        L_0x00d0:
            r12.f33942i = r10
            r12.f33943j = r9
            r12.f33944k = r8
            r12.f33945l = r7
            r12.f33946m = r6
            r12.f33947n = r5
            r12.f33948o = r3
            r12.f33949p = r1
            r0 = 1
            r12.f33952s = r0
            java.lang.Object r14 = kotlinx.coroutines.DelayKt.a(r1, r12)
            if (r14 != r13) goto L_0x00ea
            return r13
        L_0x00ea:
            int r5 = r5 + r0
            goto L_0x00bc
        L_0x00ec:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Web-view timeout after "
            r0.append(r1)
            r1 = 1000(0x3e8, float:1.401E-42)
            long r1 = (long) r1
            long r3 = r3 / r1
            r0.append(r3)
            r1 = 115(0x73, float:1.61E-43)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.io.PrintStream r1 = java.lang.System.out
            r1.println(r0)
            n(r10, r9, r8)
            T r0 = r7.f40429b
            kotlin.Pair r0 = kotlin.TuplesKt.a(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.cloudflare.WebViewResolver.k(okhttp3.Request, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WebViewResolver(Regex regex, List<Regex> list, String str, boolean z2) {
        this(regex, list, str, z2, (String) null, (Function1<? super String, Unit>) null, 40000);
        Intrinsics.f(regex, "interceptUrl");
        Intrinsics.f(list, "additionalUrls");
    }
}
