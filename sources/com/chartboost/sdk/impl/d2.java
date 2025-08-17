package com.chartboost.sdk.impl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

public final class d2 {

    /* renamed from: a  reason: collision with root package name */
    public final CoroutineDispatcher f17401a;

    /* renamed from: b  reason: collision with root package name */
    public final Function1 f17402b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f17403c;

    /* renamed from: d  reason: collision with root package name */
    public final String f17404d;

    /* renamed from: e  reason: collision with root package name */
    public final long f17405e;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17406b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final URL invoke(String str) {
            Intrinsics.f(str, "it");
            return new URL(str);
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f17407b = new b();

        public b() {
            super(1);
        }

        /* renamed from: a */
        public final Bitmap invoke(InputStream inputStream) {
            Intrinsics.f(inputStream, "it");
            return BitmapFactory.decodeStream(inputStream);
        }
    }

    public static final class c extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public Object f17408b;

        /* renamed from: c  reason: collision with root package name */
        public Object f17409c;

        /* renamed from: d  reason: collision with root package name */
        public Object f17410d;

        /* renamed from: e  reason: collision with root package name */
        public int f17411e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d2 f17412f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f17413g;

        public static final class a extends SuspendLambda implements Function2 {

            /* renamed from: b  reason: collision with root package name */
            public int f17414b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Ref$ObjectRef f17415c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ URL f17416d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ Ref$ObjectRef f17417e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Ref$ObjectRef f17418f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ d2 f17419g;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Ref$ObjectRef ref$ObjectRef, URL url, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3, d2 d2Var, Continuation continuation) {
                super(2, continuation);
                this.f17415c = ref$ObjectRef;
                this.f17416d = url;
                this.f17417e = ref$ObjectRef2;
                this.f17418f = ref$ObjectRef3;
                this.f17419g = d2Var;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new a(this.f17415c, this.f17416d, this.f17417e, this.f17418f, this.f17419g, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                T t2;
                Object unused = IntrinsicsKt__IntrinsicsKt.e();
                if (this.f17414b == 0) {
                    ResultKt.b(obj);
                    Ref$ObjectRef ref$ObjectRef = this.f17415c;
                    T openConnection = this.f17416d.openConnection();
                    Intrinsics.d(openConnection, "null cannot be cast to non-null type javax.net.ssl.HttpsURLConnection");
                    T t3 = (HttpsURLConnection) openConnection;
                    Ref$ObjectRef ref$ObjectRef2 = this.f17418f;
                    t3.setDoInput(true);
                    ref$ObjectRef2.f40429b = t3.getInputStream();
                    ref$ObjectRef.f40429b = t3;
                    Ref$ObjectRef ref$ObjectRef3 = this.f17417e;
                    InputStream inputStream = (InputStream) this.f17418f.f40429b;
                    if (inputStream == null || (t2 = (Bitmap) this.f17419g.f17403c.invoke(inputStream)) == null) {
                        throw new IOException("Bitmap decoded to null");
                    }
                    ref$ObjectRef3.f40429b = t2;
                    return Unit.f40298a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d2 d2Var, String str, Continuation continuation) {
            super(2, continuation);
            this.f17412f = d2Var;
            this.f17413g = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new c(this.f17412f, this.f17413g, continuation);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0079, code lost:
            if (r15 != null) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
            if (r15 == null) goto L_0x009f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009c, code lost:
            r15.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
            return r2.f40429b;
         */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
                int r1 = r14.f17411e
                r2 = 1
                if (r1 == 0) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                java.lang.Object r0 = r14.f17410d
                kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref$ObjectRef) r0
                java.lang.Object r1 = r14.f17409c
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref$ObjectRef) r1
                java.lang.Object r2 = r14.f17408b
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref$ObjectRef) r2
                kotlin.ResultKt.b(r15)     // Catch:{ Exception -> 0x001e }
                goto L_0x006c
            L_0x001b:
                r15 = move-exception
                goto L_0x00a2
            L_0x001e:
                r15 = move-exception
                goto L_0x0082
            L_0x0020:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L_0x0028:
                kotlin.ResultKt.b(r15)
                kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
                r15.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
                r10.<init>()
                com.chartboost.sdk.impl.d2 r3 = r14.f17412f     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                kotlin.jvm.functions.Function1 r3 = r3.f17402b     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                java.lang.String r4 = r14.f17413g     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                java.lang.Object r3 = r3.invoke(r4)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                r5 = r3
                java.net.URL r5 = (java.net.URL) r5     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                com.chartboost.sdk.impl.d2 r3 = r14.f17412f     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                long r11 = r3.f17405e     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                com.chartboost.sdk.impl.d2$c$a r13 = new com.chartboost.sdk.impl.d2$c$a     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                com.chartboost.sdk.impl.d2 r8 = r14.f17412f     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                r9 = 0
                r3 = r13
                r4 = r1
                r6 = r15
                r7 = r10
                r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                r14.f17408b = r15     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                r14.f17409c = r1     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                r14.f17410d = r10     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                r14.f17411e = r2     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                java.lang.Object r2 = kotlinx.coroutines.TimeoutKt.c(r11, r13, r14)     // Catch:{ Exception -> 0x007e, all -> 0x007c }
                if (r2 != r0) goto L_0x006a
                return r0
            L_0x006a:
                r2 = r15
                r0 = r10
            L_0x006c:
                T r15 = r0.f40429b
                java.io.InputStream r15 = (java.io.InputStream) r15
                if (r15 == 0) goto L_0x0075
                r15.close()
            L_0x0075:
                T r15 = r1.f40429b
                javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15
                if (r15 == 0) goto L_0x009f
                goto L_0x009c
            L_0x007c:
                r15 = move-exception
                goto L_0x00a3
            L_0x007e:
                r0 = move-exception
                r2 = r15
                r15 = r0
                r0 = r10
            L_0x0082:
                com.chartboost.sdk.impl.d2 r3 = r14.f17412f     // Catch:{ all -> 0x001b }
                java.lang.String r3 = r3.f17404d     // Catch:{ all -> 0x001b }
                java.lang.String r4 = "Unable to download the info icon image"
                android.util.Log.w(r3, r4, r15)     // Catch:{ all -> 0x001b }
                T r15 = r0.f40429b
                java.io.InputStream r15 = (java.io.InputStream) r15
                if (r15 == 0) goto L_0x0096
                r15.close()
            L_0x0096:
                T r15 = r1.f40429b
                javax.net.ssl.HttpsURLConnection r15 = (javax.net.ssl.HttpsURLConnection) r15
                if (r15 == 0) goto L_0x009f
            L_0x009c:
                r15.disconnect()
            L_0x009f:
                T r15 = r2.f40429b
                return r15
            L_0x00a2:
                r10 = r0
            L_0x00a3:
                T r0 = r10.f40429b
                java.io.InputStream r0 = (java.io.InputStream) r0
                if (r0 == 0) goto L_0x00ac
                r0.close()
            L_0x00ac:
                T r0 = r1.f40429b
                javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0
                if (r0 == 0) goto L_0x00b5
                r0.disconnect()
            L_0x00b5:
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.d2.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public d2(CoroutineDispatcher coroutineDispatcher, Function1 function1, Function1 function12) {
        Intrinsics.f(coroutineDispatcher, "ioDispatcher");
        Intrinsics.f(function1, "urlFactory");
        Intrinsics.f(function12, "bitmapFactory");
        this.f17401a = coroutineDispatcher;
        this.f17402b = function1;
        this.f17403c = function12;
        this.f17404d = d2.class.getSimpleName();
        this.f17405e = 1000;
    }

    public final Object a(String str, Continuation continuation) {
        return BuildersKt.e(this.f17401a, new c(this, str, (Continuation) null), continuation);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d2(CoroutineDispatcher coroutineDispatcher, Function1 function1, Function1 function12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Dispatchers.b() : coroutineDispatcher, (i2 & 2) != 0 ? a.f17406b : function1, (i2 & 4) != 0 ? b.f17407b : function12);
    }
}
