package com.chartboost.sdk.internal.clickthrough;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.chartboost.sdk.impl.ec;
import com.chartboost.sdk.impl.l3;
import com.chartboost.sdk.impl.p3;
import com.chartboost.sdk.impl.q7;
import com.facebook.common.util.UriUtil;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

public abstract class a {

    /* renamed from: com.chartboost.sdk.internal.clickthrough.a$a  reason: collision with other inner class name */
    public static final class C0028a extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f19164b;

        /* renamed from: c  reason: collision with root package name */
        public int f19165c;

        public C0028a(Continuation continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.f19164b = obj;
            this.f19165c |= Integer.MIN_VALUE;
            Object a2 = a.a((ec) null, (Context) null, (q7) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this);
            return a2 == IntrinsicsKt__IntrinsicsKt.e() ? a2 : Result.a(a2);
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f19166b = new b();

        public b() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        /* renamed from: a */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    public static final class c extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final c f19167b = new c();

        public c() {
            super(1);
        }

        /* renamed from: a */
        public final Intent invoke(Uri uri) {
            Intrinsics.f(uri, "it");
            return new Intent("android.intent.action.VIEW", uri);
        }
    }

    public static final class d extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f19168b;

        /* renamed from: c  reason: collision with root package name */
        public int f19169c;

        public d(Continuation continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.f19168b = obj;
            this.f19169c |= Integer.MIN_VALUE;
            Object a2 = a.a((ec) null, (Context) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this);
            return a2 == IntrinsicsKt__IntrinsicsKt.e() ? a2 : Result.a(a2);
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final e f19170b = new e();

        public e() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        /* renamed from: a */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    public static final class f extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f19171b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(1);
            this.f19171b = context;
        }

        /* renamed from: a */
        public final Intent invoke(String str) {
            Intrinsics.f(str, ImagesContract.URL);
            return EmbeddedBrowserActivity.Companion.a(this.f19171b, str);
        }
    }

    public static final class g extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f19172b;

        /* renamed from: c  reason: collision with root package name */
        public int f19173c;

        public g(Continuation continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.f19172b = obj;
            this.f19173c |= Integer.MIN_VALUE;
            Object b2 = a.b((ec) null, (Context) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this);
            return b2 == IntrinsicsKt__IntrinsicsKt.e() ? b2 : Result.a(b2);
        }
    }

    public /* synthetic */ class h extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final h f19174b = new h();

        public h() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        /* renamed from: a */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    public static final class i extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final i f19175b = new i();

        public i() {
            super(1);
        }

        /* renamed from: a */
        public final Intent invoke(Uri uri) {
            Intrinsics.f(uri, "it");
            return new Intent("android.intent.action.VIEW", uri);
        }
    }

    public static final class j extends ContinuationImpl {

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f19176b;

        /* renamed from: c  reason: collision with root package name */
        public int f19177c;

        public j(Continuation continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.f19176b = obj;
            this.f19177c |= Integer.MIN_VALUE;
            Object c2 = a.c((ec) null, (Context) null, (Function1) null, (Function1) null, (CoroutineDispatcher) null, this);
            return c2 == IntrinsicsKt__IntrinsicsKt.e() ? c2 : Result.a(c2);
        }
    }

    public /* synthetic */ class k extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final k f19178b = new k();

        public k() {
            super(1, Uri.class, "parse", "parse(Ljava/lang/String;)Landroid/net/Uri;", 0);
        }

        /* renamed from: a */
        public final Uri invoke(String str) {
            return Uri.parse(str);
        }
    }

    public static final class l extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final l f19179b = new l();

        public l() {
            super(1);
        }

        /* renamed from: a */
        public final Intent invoke(Uri uri) {
            Intrinsics.f(uri, "it");
            return new Intent("android.intent.action.VIEW", uri);
        }
    }

    public static final class m extends SuspendLambda implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public int f19180b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f19181c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Intent f19182d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Context context, Intent intent, Continuation continuation) {
            super(2, continuation);
            this.f19181c = context;
            this.f19182d = intent;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((m) create(coroutineScope, continuation)).invokeSuspend(Unit.f40298a);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new m(this.f19181c, this.f19182d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.e();
            if (this.f19180b == 0) {
                ResultKt.b(obj);
                this.f19181c.startActivity(a.b(this.f19182d));
                return Unit.f40298a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(com.chartboost.sdk.impl.ec r4, android.content.Context r5, kotlin.jvm.functions.Function1 r6, kotlin.jvm.functions.Function1 r7, kotlinx.coroutines.CoroutineDispatcher r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof com.chartboost.sdk.internal.clickthrough.a.g
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.chartboost.sdk.internal.clickthrough.a$g r0 = (com.chartboost.sdk.internal.clickthrough.a.g) r0
            int r1 = r0.f19173c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19173c = r1
            goto L_0x0018
        L_0x0013:
            com.chartboost.sdk.internal.clickthrough.a$g r0 = new com.chartboost.sdk.internal.clickthrough.a$g
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f19172b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f19173c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0066 }
            goto L_0x0057
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.f40263c     // Catch:{ all -> 0x0066 }
            boolean r9 = b((com.chartboost.sdk.impl.ec) r4)     // Catch:{ all -> 0x0066 }
            if (r9 == 0) goto L_0x0063
            com.chartboost.sdk.impl.ec r4 = com.chartboost.sdk.impl.hc.b(r4)     // Catch:{ all -> 0x0066 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = r6.invoke(r4)     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = r7.invoke(r4)     // Catch:{ all -> 0x0066 }
            android.content.Intent r4 = (android.content.Intent) r4     // Catch:{ all -> 0x0066 }
            r0.f19173c = r3     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = a(r5, r4, r8, r0)     // Catch:{ all -> 0x0066 }
            if (r4 != r1) goto L_0x0057
            return r1
        L_0x0057:
            com.chartboost.sdk.impl.dc r4 = new com.chartboost.sdk.impl.dc     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = "openInNativeBrowser"
            r4.<init>(r5)     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch:{ all -> 0x0066 }
            goto L_0x0071
        L_0x0063:
            com.chartboost.sdk.impl.pd r4 = com.chartboost.sdk.impl.pd.f18389b     // Catch:{ all -> 0x0066 }
            throw r4     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L_0x0071:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.internal.clickthrough.a.b(com.chartboost.sdk.impl.ec, android.content.Context, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object c(com.chartboost.sdk.impl.ec r4, android.content.Context r5, kotlin.jvm.functions.Function1 r6, kotlin.jvm.functions.Function1 r7, kotlinx.coroutines.CoroutineDispatcher r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof com.chartboost.sdk.internal.clickthrough.a.j
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.chartboost.sdk.internal.clickthrough.a$j r0 = (com.chartboost.sdk.internal.clickthrough.a.j) r0
            int r1 = r0.f19177c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19177c = r1
            goto L_0x0018
        L_0x0013:
            com.chartboost.sdk.internal.clickthrough.a$j r0 = new com.chartboost.sdk.internal.clickthrough.a$j
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f19176b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f19177c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0062 }
            goto L_0x0053
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.f40263c     // Catch:{ all -> 0x0062 }
            boolean r9 = a(r4, r6)     // Catch:{ all -> 0x0062 }
            if (r9 == 0) goto L_0x005f
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0062 }
            java.lang.Object r4 = r6.invoke(r4)     // Catch:{ all -> 0x0062 }
            java.lang.Object r4 = r7.invoke(r4)     // Catch:{ all -> 0x0062 }
            android.content.Intent r4 = (android.content.Intent) r4     // Catch:{ all -> 0x0062 }
            r0.f19177c = r3     // Catch:{ all -> 0x0062 }
            java.lang.Object r4 = a(r5, r4, r8, r0)     // Catch:{ all -> 0x0062 }
            if (r4 != r1) goto L_0x0053
            return r1
        L_0x0053:
            com.chartboost.sdk.impl.dc r4 = new com.chartboost.sdk.impl.dc     // Catch:{ all -> 0x0062 }
            java.lang.String r5 = "openUnsecureLink"
            r4.<init>(r5)     // Catch:{ all -> 0x0062 }
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch:{ all -> 0x0062 }
            goto L_0x006d
        L_0x005f:
            com.chartboost.sdk.impl.i8 r4 = com.chartboost.sdk.impl.i8.f17932b     // Catch:{ all -> 0x0062 }
            throw r4     // Catch:{ all -> 0x0062 }
        L_0x0062:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L_0x006d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.internal.clickthrough.a.c(com.chartboost.sdk.impl.ec, android.content.Context, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(com.chartboost.sdk.impl.ec r4, android.content.Context r5, kotlin.jvm.functions.Function1 r6, kotlin.jvm.functions.Function1 r7, kotlinx.coroutines.CoroutineDispatcher r8, kotlin.coroutines.Continuation r9) {
        /*
            boolean r0 = r9 instanceof com.chartboost.sdk.internal.clickthrough.a.d
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.chartboost.sdk.internal.clickthrough.a$d r0 = (com.chartboost.sdk.internal.clickthrough.a.d) r0
            int r1 = r0.f19169c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19169c = r1
            goto L_0x0018
        L_0x0013:
            com.chartboost.sdk.internal.clickthrough.a$d r0 = new com.chartboost.sdk.internal.clickthrough.a$d
            r0.<init>(r9)
        L_0x0018:
            java.lang.Object r9 = r0.f19168b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f19169c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.b(r9)     // Catch:{ all -> 0x0069 }
            goto L_0x005a
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.b(r9)
            kotlin.Result$Companion r9 = kotlin.Result.f40263c     // Catch:{ all -> 0x0069 }
            boolean r9 = a((com.chartboost.sdk.impl.ec) r4)     // Catch:{ all -> 0x0069 }
            if (r9 == 0) goto L_0x0066
            java.lang.String r9 = r4.b()     // Catch:{ all -> 0x0069 }
            r6.invoke(r9)     // Catch:{ all -> 0x0069 }
            com.chartboost.sdk.impl.ec r4 = com.chartboost.sdk.impl.hc.b(r4)     // Catch:{ all -> 0x0069 }
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0069 }
            java.lang.Object r4 = r7.invoke(r4)     // Catch:{ all -> 0x0069 }
            android.content.Intent r4 = (android.content.Intent) r4     // Catch:{ all -> 0x0069 }
            r0.f19169c = r3     // Catch:{ all -> 0x0069 }
            java.lang.Object r4 = a(r5, r4, r8, r0)     // Catch:{ all -> 0x0069 }
            if (r4 != r1) goto L_0x005a
            return r1
        L_0x005a:
            com.chartboost.sdk.impl.dc r4 = new com.chartboost.sdk.impl.dc     // Catch:{ all -> 0x0069 }
            java.lang.String r5 = "openInEmbeddedBrowser"
            r4.<init>(r5)     // Catch:{ all -> 0x0069 }
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch:{ all -> 0x0069 }
            goto L_0x0074
        L_0x0066:
            com.chartboost.sdk.impl.pd r4 = com.chartboost.sdk.impl.pd.f18389b     // Catch:{ all -> 0x0069 }
            throw r4     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L_0x0074:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.internal.clickthrough.a.a(com.chartboost.sdk.impl.ec, android.content.Context, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object c(ec ecVar, Context context, Function1 function1, Function1 function12, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = p3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            function1 = k.f19178b;
        }
        Function1 function13 = function1;
        if ((i2 & 8) != 0) {
            function12 = l.f19179b;
        }
        Function1 function14 = function12;
        if ((i2 & 16) != 0) {
            coroutineDispatcher = Dispatchers.c();
        }
        return c(ecVar, context2, function13, function14, coroutineDispatcher, continuation);
    }

    public static /* synthetic */ Object b(ec ecVar, Context context, Function1 function1, Function1 function12, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = p3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            function1 = h.f19174b;
        }
        Function1 function13 = function1;
        if ((i2 & 8) != 0) {
            function12 = i.f19175b;
        }
        Function1 function14 = function12;
        if ((i2 & 16) != 0) {
            coroutineDispatcher = Dispatchers.c();
        }
        return b(ecVar, context2, function13, function14, coroutineDispatcher, continuation);
    }

    public static /* synthetic */ Object a(ec ecVar, Context context, Function1 function1, Function1 function12, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = p3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            function1 = e.f19170b;
        }
        Function1 function13 = function1;
        if ((i2 & 8) != 0) {
            function12 = new f(context2);
        }
        Function1 function14 = function12;
        if ((i2 & 16) != 0) {
            coroutineDispatcher = Dispatchers.c();
        }
        return a(ecVar, context2, function13, function14, coroutineDispatcher, continuation);
    }

    public static final boolean b(ec ecVar) {
        return ecVar.a() == l3.CLICK_PREFERENCE_NATIVE;
    }

    public static final Intent b(Intent intent) {
        intent.setFlags(268435456);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(com.chartboost.sdk.impl.ec r4, android.content.Context r5, com.chartboost.sdk.impl.q7 r6, kotlin.jvm.functions.Function1 r7, kotlin.jvm.functions.Function1 r8, kotlinx.coroutines.CoroutineDispatcher r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof com.chartboost.sdk.internal.clickthrough.a.C0028a
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.chartboost.sdk.internal.clickthrough.a$a r0 = (com.chartboost.sdk.internal.clickthrough.a.C0028a) r0
            int r1 = r0.f19165c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f19165c = r1
            goto L_0x0018
        L_0x0013:
            com.chartboost.sdk.internal.clickthrough.a$a r0 = new com.chartboost.sdk.internal.clickthrough.a$a
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f19164b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.e()
            int r2 = r0.f19165c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.b(r10)     // Catch:{ all -> 0x0066 }
            goto L_0x0057
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            kotlin.ResultKt.b(r10)
            kotlin.Result$Companion r10 = kotlin.Result.f40263c     // Catch:{ all -> 0x0066 }
            java.lang.String r10 = r4.b()     // Catch:{ all -> 0x0066 }
            boolean r6 = r6.b(r10)     // Catch:{ all -> 0x0066 }
            if (r6 == 0) goto L_0x0063
            java.lang.String r4 = r4.b()     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = r7.invoke(r4)     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = r8.invoke(r4)     // Catch:{ all -> 0x0066 }
            android.content.Intent r4 = (android.content.Intent) r4     // Catch:{ all -> 0x0066 }
            r0.f19165c = r3     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = a(r5, r4, r9, r0)     // Catch:{ all -> 0x0066 }
            if (r4 != r1) goto L_0x0057
            return r1
        L_0x0057:
            com.chartboost.sdk.impl.dc r4 = new com.chartboost.sdk.impl.dc     // Catch:{ all -> 0x0066 }
            java.lang.String r5 = "openDeepLink"
            r4.<init>(r5)     // Catch:{ all -> 0x0066 }
            java.lang.Object r4 = kotlin.Result.b(r4)     // Catch:{ all -> 0x0066 }
            goto L_0x0071
        L_0x0063:
            com.chartboost.sdk.impl.a8 r4 = com.chartboost.sdk.impl.a8.f17208b     // Catch:{ all -> 0x0066 }
            throw r4     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r4 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.f40263c
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.b(r4)
        L_0x0071:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.internal.clickthrough.a.a(com.chartboost.sdk.impl.ec, android.content.Context, com.chartboost.sdk.impl.q7, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlinx.coroutines.CoroutineDispatcher, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object a(ec ecVar, Context context, q7 q7Var, Function1 function1, Function1 function12, CoroutineDispatcher coroutineDispatcher, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            context = p3.a();
        }
        Context context2 = context;
        if ((i2 & 4) != 0) {
            q7Var = p3.b();
        }
        q7 q7Var2 = q7Var;
        if ((i2 & 8) != 0) {
            function1 = b.f19166b;
        }
        Function1 function13 = function1;
        if ((i2 & 16) != 0) {
            function12 = c.f19167b;
        }
        Function1 function14 = function12;
        if ((i2 & 32) != 0) {
            coroutineDispatcher = Dispatchers.c();
        }
        return a(ecVar, context2, q7Var2, function13, function14, coroutineDispatcher, continuation);
    }

    public static final Object a(Context context, Intent intent, CoroutineDispatcher coroutineDispatcher, Continuation continuation) {
        Object e2 = BuildersKt.e(coroutineDispatcher, new m(context, intent, (Continuation) null), continuation);
        return e2 == IntrinsicsKt__IntrinsicsKt.e() ? e2 : Unit.f40298a;
    }

    public static final boolean a(ec ecVar) {
        return ecVar.a() == l3.CLICK_PREFERENCE_EMBEDDED;
    }

    public static final boolean a(ec ecVar, Function1 function1) {
        if (ecVar != null) {
            return Intrinsics.a(((Uri) function1.invoke(ecVar.b())).getScheme(), UriUtil.HTTP_SCHEME);
        }
        return false;
    }
}
