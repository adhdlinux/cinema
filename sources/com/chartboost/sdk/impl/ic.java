package com.chartboost.sdk.impl;

import com.google.android.gms.common.internal.ImagesContract;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

public final class ic {

    /* renamed from: a  reason: collision with root package name */
    public final Function1 f17952a;

    /* renamed from: b  reason: collision with root package name */
    public final SSLSocketFactory f17953b;

    public /* synthetic */ class a extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17954b = new a();

        public a() {
            super(1, URL.class, "<init>", "<init>(Ljava/lang/String;)V", 0);
        }

        /* renamed from: a */
        public final URL invoke(String str) {
            return new URL(str);
        }
    }

    public static abstract class b extends Exception {

        public static final class a extends b {

            /* renamed from: b  reason: collision with root package name */
            public static final a f17955b = new a();

            public a() {
                super("Empty or null URL", (Throwable) null, (String) null, 6, (DefaultConstructorMarker) null);
            }
        }

        /* renamed from: com.chartboost.sdk.impl.ic$b$b  reason: collision with other inner class name */
        public static final class C0025b extends b {

            /* renamed from: b  reason: collision with root package name */
            public final int f17956b;

            public C0025b(int i2) {
                super("Failed with HTTP code " + i2, (Throwable) null, (String) null, 6, (DefaultConstructorMarker) null);
                this.f17956b = i2;
            }
        }

        public static final class c extends b {

            /* renamed from: b  reason: collision with root package name */
            public static final c f17957b = new c();

            public c() {
                super("Returned connection is null", (Throwable) null, (String) null, 6, (DefaultConstructorMarker) null);
            }
        }

        public static final class d extends b {

            /* renamed from: b  reason: collision with root package name */
            public static final d f17958b = new d();

            public d() {
                super("Too many redirects", (Throwable) null, (String) null, 6, (DefaultConstructorMarker) null);
            }
        }

        public static final class e extends b {

            /* renamed from: b  reason: collision with root package name */
            public final String f17959b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(String str, Throwable th) {
                super("Uncontrolled error", th, str, (DefaultConstructorMarker) null);
                Intrinsics.f(str, ImagesContract.URL);
                Intrinsics.f(th, "cause");
                this.f17959b = str;
            }

            public final String a() {
                return this.f17959b;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
                r0 = r0.toString();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.String toString() {
                /*
                    r1 = this;
                    java.lang.Throwable r0 = r1.getCause()
                    if (r0 == 0) goto L_0x000c
                    java.lang.String r0 = r0.toString()
                    if (r0 != 0) goto L_0x000e
                L_0x000c:
                    java.lang.String r0 = "No cause"
                L_0x000e:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ic.b.e.toString():java.lang.String");
            }
        }

        public /* synthetic */ b(String str, Throwable th, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, th, str2);
        }

        public String toString() {
            String message = getMessage();
            return message == null ? "No message" : message;
        }

        public b(String str, Throwable th, String str2) {
            super(str, th);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ b(String str, Throwable th, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? null : th, (i2 & 4) != 0 ? null : str2, (DefaultConstructorMarker) null);
        }
    }

    public ic(Function1 function1, SSLSocketFactory sSLSocketFactory) {
        Intrinsics.f(function1, "urlFactory");
        Intrinsics.f(sSLSocketFactory, "sslSocket");
        this.f17952a = function1;
        this.f17953b = sSLSocketFactory;
    }

    public static /* synthetic */ Object a(ic icVar, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 10;
        }
        return icVar.a(str, i2);
    }

    public final boolean b(int i2) {
        return i2 <= f6.REQUEST_SUCCESS_END.b() && f6.REQUEST_SUCCESS_START.b() <= i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008a, code lost:
        if (r2 != null) goto L_0x00bf;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r8, int r9) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x00c9
            int r0 = r8.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x00c9
        L_0x000a:
            if (r9 >= 0) goto L_0x0013
            com.chartboost.sdk.impl.ic$b$d r8 = com.chartboost.sdk.impl.ic.b.d.f17958b
            java.lang.Object r8 = r7.a((com.chartboost.sdk.impl.ic.b) r8)
            return r8
        L_0x0013:
            r0 = 0
            kotlin.jvm.functions.Function1 r1 = r7.f17952a     // Catch:{ Exception -> 0x0095 }
            java.lang.Object r1 = r1.invoke(r8)     // Catch:{ Exception -> 0x0095 }
            java.net.URL r1 = (java.net.URL) r1     // Catch:{ Exception -> 0x0095 }
            javax.net.ssl.HttpsURLConnection r2 = r7.a((java.net.URL) r1)     // Catch:{ Exception -> 0x0095 }
            if (r2 == 0) goto L_0x0084
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            boolean r3 = r7.b(r3)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            if (r3 == 0) goto L_0x0031
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            goto L_0x008a
        L_0x0031:
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            boolean r3 = r7.a((int) r3)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            if (r3 == 0) goto L_0x0076
            java.lang.String r3 = "Location"
            java.lang.String r3 = r2.getHeaderField(r3)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.String r4 = "location"
            kotlin.jvm.internal.Intrinsics.e(r3, r4)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.String r4 = "/"
            r5 = 0
            r6 = 2
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.G(r3, r4, r5, r6, r0)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            if (r0 == 0) goto L_0x006f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            r0.<init>()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.String r4 = r1.getProtocol()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            r0.append(r4)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.String r4 = "://"
            r0.append(r4)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.String r1 = r1.getHost()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            r0.append(r1)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            r0.append(r3)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
        L_0x006f:
            int r9 = r9 + -1
            java.lang.Object r8 = r7.a(r3, r9)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            goto L_0x008a
        L_0x0076:
            com.chartboost.sdk.impl.ic$b$b r9 = new com.chartboost.sdk.impl.ic$b$b     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            int r0 = r2.getResponseCode()     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            r9.<init>(r0)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.Object r8 = r7.a((com.chartboost.sdk.impl.ic.b) r9)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            goto L_0x008a
        L_0x0084:
            com.chartboost.sdk.impl.ic$b$c r9 = com.chartboost.sdk.impl.ic.b.c.f17957b     // Catch:{ Exception -> 0x0090, all -> 0x008d }
            java.lang.Object r8 = r7.a((com.chartboost.sdk.impl.ic.b) r9)     // Catch:{ Exception -> 0x0090, all -> 0x008d }
        L_0x008a:
            if (r2 == 0) goto L_0x00c2
            goto L_0x00bf
        L_0x008d:
            r8 = move-exception
            r0 = r2
            goto L_0x00c3
        L_0x0090:
            r9 = move-exception
            r0 = r2
            goto L_0x0096
        L_0x0093:
            r8 = move-exception
            goto L_0x00c3
        L_0x0095:
            r9 = move-exception
        L_0x0096:
            java.lang.String r1 = com.chartboost.sdk.impl.jc.f18000a     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r2.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "Cannot redirect "
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            r2.append(r8)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0093 }
            com.chartboost.sdk.impl.w7.a(r1, r2, r9)     // Catch:{ all -> 0x0093 }
            com.chartboost.sdk.impl.ic$b$e r1 = new com.chartboost.sdk.impl.ic$b$e     // Catch:{ all -> 0x0093 }
            r1.<init>(r8, r9)     // Catch:{ all -> 0x0093 }
            java.lang.Object r8 = r7.a((com.chartboost.sdk.impl.ic.b) r1)     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x00c2
            r2 = r0
        L_0x00bf:
            r2.disconnect()
        L_0x00c2:
            return r8
        L_0x00c3:
            if (r0 == 0) goto L_0x00c8
            r0.disconnect()
        L_0x00c8:
            throw r8
        L_0x00c9:
            com.chartboost.sdk.impl.ic$b$a r8 = com.chartboost.sdk.impl.ic.b.a.f17955b
            java.lang.Object r8 = r7.a((com.chartboost.sdk.impl.ic.b) r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.ic.a(java.lang.String, int):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ic(Function1 function1, SSLSocketFactory sSLSocketFactory, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? a.f17954b : function1, (i2 & 2) != 0 ? v2.f18816a.a() : sSLSocketFactory);
    }

    public final Object a(b bVar) {
        Result.Companion companion = Result.f40263c;
        return Result.b(ResultKt.a(bVar));
    }

    public final boolean a(int i2) {
        return i2 <= f6.REDIRECTION_END.b() && f6.REDIRECTION_START.b() <= i2;
    }

    public final HttpsURLConnection a(URL url) {
        URLConnection openConnection = url.openConnection();
        HttpsURLConnection httpsURLConnection = openConnection instanceof HttpsURLConnection ? (HttpsURLConnection) openConnection : null;
        if (httpsURLConnection == null) {
            return null;
        }
        httpsURLConnection.setSSLSocketFactory(this.f17953b);
        httpsURLConnection.setInstanceFollowRedirects(false);
        httpsURLConnection.setConnectTimeout(10000);
        httpsURLConnection.setReadTimeout(10000);
        return httpsURLConnection;
    }
}
