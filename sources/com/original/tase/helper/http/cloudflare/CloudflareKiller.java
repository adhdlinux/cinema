package com.original.tase.helper.http.cloudflare;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public final class CloudflareKiller implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33901a = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final List<Integer> f33902b = CollectionsKt__CollectionsKt.i(403, 503);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final List<String> f33903c = CollectionsKt__CollectionsKt.i("cloudflare-nginx", "cloudflare");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final Map<String, Map<String, String>> f33904d = new LinkedHashMap();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Map<String, String>> a() {
            return CloudflareKiller.f33904d;
        }

        public final Map<String, String> b(String str) {
            boolean z2;
            String str2;
            String obj;
            Intrinsics.f(str, "cookie");
            Iterable<String> v02 = StringsKt__StringsKt.v0(str, new String[]{";"}, false, 0, 6, (Object) null);
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.b(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.p(v02, 10)), 16));
            for (String v03 : v02) {
                List v04 = StringsKt__StringsKt.v0(v03, new String[]{"="}, false, 0, 6, (Object) null);
                String str3 = (String) CollectionsKt___CollectionsKt.E(v04, 0);
                String str4 = "";
                if (str3 == null || (str2 = StringsKt__StringsKt.N0(str3).toString()) == null) {
                    str2 = str4;
                }
                String str5 = (String) CollectionsKt___CollectionsKt.E(v04, 1);
                if (!(str5 == null || (obj = StringsKt__StringsKt.N0(str5).toString()) == null)) {
                    str4 = obj;
                }
                Pair a2 = TuplesKt.a(str2, str4);
                linkedHashMap.put(a2.c(), a2.d());
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                if (!(!StringsKt__StringsJVMKt.v((CharSequence) entry.getKey())) || !(!StringsKt__StringsJVMKt.v((CharSequence) entry.getValue()))) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap2;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(okhttp3.Request r13, kotlin.coroutines.Continuation<? super okhttp3.Request> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$1
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$1 r0 = (com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$1) r0
            int r1 = r0.f33909m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33909m = r1
            goto L_0x0018
        L_0x0013:
            com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$1 r0 = new com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$1
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f33907k
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r1 = r0.f33909m
            r10 = 2
            r2 = 1
            r11 = 0
            if (r1 == 0) goto L_0x0042
            if (r1 == r2) goto L_0x0036
            if (r1 != r10) goto L_0x002e
            kotlin.ResultKt.b(r14)
            goto L_0x00c1
        L_0x002e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0036:
            java.lang.Object r13 = r0.f33906j
            okhttp3.Request r13 = (okhttp3.Request) r13
            java.lang.Object r1 = r0.f33905i
            com.original.tase.helper.http.cloudflare.CloudflareKiller r1 = (com.original.tase.helper.http.cloudflare.CloudflareKiller) r1
            kotlin.ResultKt.b(r14)
            goto L_0x00a1
        L_0x0042:
            kotlin.ResultKt.b(r14)
            okhttp3.HttpUrl r14 = r13.url()
            java.lang.String r14 = r14.toString()
            boolean r1 = r12.k(r13)
            if (r1 != 0) goto L_0x00a0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Loading webview to solve cloudflare for "
            r1.append(r3)
            okhttp3.HttpUrl r3 = r13.url()
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.String r3 = "CloudflareKiller"
            android.util.Log.d(r3, r1)
            kotlin.text.Regex r1 = new kotlin.text.Regex
            java.lang.String r3 = ".^"
            r1.<init>((java.lang.String) r3)
            kotlin.text.Regex r3 = new kotlin.text.Regex
            java.lang.String r4 = "."
            r3.<init>((java.lang.String) r4)
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsJVMKt.b(r3)
            com.original.tase.helper.http.cloudflare.WebViewResolver r4 = new com.original.tase.helper.http.cloudflare.WebViewResolver
            r5 = 0
            r4.<init>(r1, r3, r11, r5)
            r3 = 0
            r5 = 0
            com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$2 r6 = new com.original.tase.helper.http.cloudflare.CloudflareKiller$bypassCloudflare$2
            r6.<init>(r12, r13)
            r7 = 6
            r8 = 0
            r0.f33905i = r12
            r0.f33906j = r13
            r0.f33909m = r2
            r1 = r4
            r2 = r14
            r4 = r5
            r5 = r6
            r6 = r0
            java.lang.Object r14 = com.original.tase.helper.http.cloudflare.WebViewResolver.l(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r14 != r9) goto L_0x00a0
            return r9
        L_0x00a0:
            r1 = r12
        L_0x00a1:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r14 = f33904d
            okhttp3.HttpUrl r2 = r13.url()
            java.lang.String r2 = r2.host()
            java.lang.Object r14 = r14.get(r2)
            java.util.Map r14 = (java.util.Map) r14
            if (r14 != 0) goto L_0x00b4
            return r11
        L_0x00b4:
            r0.f33905i = r11
            r0.f33906j = r11
            r0.f33909m = r10
            java.lang.Object r14 = r1.j(r13, r14, r0)
            if (r14 != r9) goto L_0x00c1
            return r9
        L_0x00c1:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.cloudflare.CloudflareKiller.g(okhttp3.Request, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String i(String str) {
        return (String) WebViewResolverKt.f(new CloudflareKiller$getWebViewCookie$1(str));
    }

    /* access modifiers changed from: private */
    public final Object j(Request request, Map<String, String> map, Continuation<? super Request> continuation) {
        Map map2;
        String b2 = WebViewResolver.f33920h.b();
        if (b2 == null || (map2 = MapsKt__MapsJVMKt.e(TuplesKt.a("user-agent", b2))) == null) {
            map2 = MapsKt__MapsKt.g();
        }
        return request.newBuilder().headers(CloudflareKillerKt.c(MapsKt__MapsKt.o(MapsKt__MapsKt.s(request.headers()), map2), MapsKt__MapsKt.o(map, CloudflareKillerKt.b(request)))).build();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r1 = kotlin.text.StringsKt__StringsKt.L(r0, "cf_clearance", false, 2, (java.lang.Object) null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean k(okhttp3.Request r6) {
        /*
            r5 = this;
            okhttp3.HttpUrl r0 = r6.url()
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = r5.i(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0057
            r2 = 2
            r3 = 0
            java.lang.String r4 = "cf_clearance"
            boolean r1 = kotlin.text.StringsKt__StringsKt.L(r0, r4, r1, r2, r3)
            if (r1 == 0) goto L_0x0057
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, java.lang.String>> r2 = f33904d
            okhttp3.HttpUrl r3 = r6.url()
            java.lang.String r3 = r3.host()
            com.original.tase.helper.http.cloudflare.CloudflareKiller$Companion r4 = f33901a
            java.util.Map r4 = r4.b(r0)
            r2.put(r3, r4)
            com.original.tase.helper.http.HttpHelper r2 = com.original.tase.helper.http.HttpHelper.i()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            okhttp3.HttpUrl r4 = r6.url()
            java.lang.String r4 = r4.scheme()
            r3.append(r4)
            java.lang.String r4 = "://"
            r3.append(r4)
            okhttp3.HttpUrl r6 = r6.url()
            java.lang.String r6 = r6.host()
            r3.append(r6)
            java.lang.String r6 = r3.toString()
            r2.D(r6, r0)
        L_0x0057:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.original.tase.helper.http.cloudflare.CloudflareKiller.k(okhttp3.Request):boolean");
    }

    public final void h() {
        WebViewResolverKt.f(CloudflareKiller$cleancookie$1.f33912f);
    }

    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.f(chain, "chain");
        return (Response) BuildersKt__BuildersKt.b((CoroutineContext) null, new CloudflareKiller$intercept$1(chain, this, (Continuation<? super CloudflareKiller$intercept$1>) null), 1, (Object) null);
    }
}
