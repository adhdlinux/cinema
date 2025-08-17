package com.chartboost.sdk.impl;

import android.content.Context;
import com.chartboost.sdk.impl.f3;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheEvictor;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class i5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17895a;

    /* renamed from: b  reason: collision with root package name */
    public final vc f17896b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1 f17897c;

    /* renamed from: d  reason: collision with root package name */
    public final Function4 f17898d;

    /* renamed from: e  reason: collision with root package name */
    public final Function2 f17899e;

    /* renamed from: f  reason: collision with root package name */
    public final DefaultHttpDataSource.Factory f17900f;

    /* renamed from: g  reason: collision with root package name */
    public final Function5 f17901g;

    /* renamed from: h  reason: collision with root package name */
    public final Function1 f17902h;

    /* renamed from: i  reason: collision with root package name */
    public final Function0 f17903i;

    /* renamed from: j  reason: collision with root package name */
    public final Function1 f17904j;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final a f17905b = new a();

        public a() {
            super(1);
        }

        /* renamed from: a */
        public final n5 invoke(Context context) {
            Intrinsics.f(context, "c");
            return new n5(context, (File) null, (File) null, (File) null, 14, (DefaultConstructorMarker) null);
        }
    }

    public static final class b extends Lambda implements Function4 {

        /* renamed from: b  reason: collision with root package name */
        public static final b f17906b = new b();

        public b() {
            super(4);
        }

        /* renamed from: a */
        public final Cache invoke(m5 m5Var, vc vcVar, DatabaseProvider databaseProvider, f3.b bVar) {
            Intrinsics.f(m5Var, "fc");
            Intrinsics.f(vcVar, "vcp");
            Intrinsics.f(databaseProvider, "dp");
            Intrinsics.f(bVar, "c");
            return h4.a(m5Var, databaseProvider, vcVar, bVar, (CacheEvictor) null, 16, (Object) null);
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function2 {

        /* renamed from: b  reason: collision with root package name */
        public static final c f17907b = new c();

        public c() {
            super(2, h4.class, "cacheDataSourceFactory", "cacheDataSourceFactory(Lcom/google/android/exoplayer2/upstream/cache/Cache;Lcom/google/android/exoplayer2/upstream/HttpDataSource$Factory;)Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", 1);
        }

        /* renamed from: a */
        public final CacheDataSource.Factory invoke(Cache cache, HttpDataSource$Factory httpDataSource$Factory) {
            Intrinsics.f(cache, "p0");
            Intrinsics.f(httpDataSource$Factory, "p1");
            return h4.a(cache, httpDataSource$Factory);
        }
    }

    public static final class d extends Lambda implements Function5 {

        /* renamed from: b  reason: collision with root package name */
        public static final d f17908b = new d();

        public d() {
            super(5);
        }

        /* renamed from: a */
        public final DownloadManager invoke(Context context, DatabaseProvider databaseProvider, Cache cache, HttpDataSource$Factory httpDataSource$Factory, DownloadManager.Listener listener) {
            Intrinsics.f(context, "c");
            Intrinsics.f(databaseProvider, "dp");
            Intrinsics.f(cache, "ca");
            Intrinsics.f(httpDataSource$Factory, "hf");
            Intrinsics.f(listener, "l");
            return h4.a(context, databaseProvider, cache, httpDataSource$Factory, listener, 0, 0, 96, (Object) null);
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final e f17909b = new e();

        public e() {
            super(1, h4.class, "databaseProvider", "databaseProvider(Landroid/content/Context;)Lcom/google/android/exoplayer2/database/DatabaseProvider;", 1);
        }

        /* renamed from: a */
        public final DatabaseProvider invoke(Context context) {
            Intrinsics.f(context, "p0");
            return h4.a(context);
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function0 {

        /* renamed from: b  reason: collision with root package name */
        public static final f f17910b = new f();

        public f() {
            super(0, h4.class, "setCookieHandler", "setCookieHandler()V", 1);
        }

        public final void a() {
            h4.a();
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f40298a;
        }
    }

    public static final class g extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public static final g f17911b = new g();

        public g() {
            super(1);
        }

        /* renamed from: a */
        public final u5 invoke(m5 m5Var) {
            Intrinsics.f(m5Var, "fc");
            return new u5(m5Var);
        }
    }

    public i5(Context context, vc vcVar, Function1 function1, Function4 function4, Function2 function2, DefaultHttpDataSource.Factory factory, Function5 function5, Function1 function12, Function0 function0, Function1 function13) {
        Intrinsics.f(context, "context");
        Intrinsics.f(vcVar, "videoCachePolicy");
        Intrinsics.f(function1, "fileCachingFactory");
        Intrinsics.f(function4, "cacheFactory");
        Intrinsics.f(function2, "cacheDataSourceFactoryFactory");
        Intrinsics.f(factory, "httpDataSourceFactory");
        Intrinsics.f(function5, "downloadManagerFactory");
        Intrinsics.f(function12, "databaseProviderFactory");
        Intrinsics.f(function0, "setCookieHandler");
        Intrinsics.f(function13, "fakePrecacheFilesManagerFactory");
        this.f17895a = context;
        this.f17896b = vcVar;
        this.f17897c = function1;
        this.f17898d = function4;
        this.f17899e = function2;
        this.f17900f = factory;
        this.f17901g = function5;
        this.f17902h = function12;
        this.f17903i = function0;
        this.f17904j = function13;
    }

    public final Function2 a() {
        return this.f17899e;
    }

    public final Function4 b() {
        return this.f17898d;
    }

    public final Context c() {
        return this.f17895a;
    }

    public final Function1 d() {
        return this.f17902h;
    }

    public final Function5 e() {
        return this.f17901g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i5)) {
            return false;
        }
        i5 i5Var = (i5) obj;
        return Intrinsics.a(this.f17895a, i5Var.f17895a) && Intrinsics.a(this.f17896b, i5Var.f17896b) && Intrinsics.a(this.f17897c, i5Var.f17897c) && Intrinsics.a(this.f17898d, i5Var.f17898d) && Intrinsics.a(this.f17899e, i5Var.f17899e) && Intrinsics.a(this.f17900f, i5Var.f17900f) && Intrinsics.a(this.f17901g, i5Var.f17901g) && Intrinsics.a(this.f17902h, i5Var.f17902h) && Intrinsics.a(this.f17903i, i5Var.f17903i) && Intrinsics.a(this.f17904j, i5Var.f17904j);
    }

    public final Function1 f() {
        return this.f17904j;
    }

    public final Function1 g() {
        return this.f17897c;
    }

    public final DefaultHttpDataSource.Factory h() {
        return this.f17900f;
    }

    public int hashCode() {
        return (((((((((((((((((this.f17895a.hashCode() * 31) + this.f17896b.hashCode()) * 31) + this.f17897c.hashCode()) * 31) + this.f17898d.hashCode()) * 31) + this.f17899e.hashCode()) * 31) + this.f17900f.hashCode()) * 31) + this.f17901g.hashCode()) * 31) + this.f17902h.hashCode()) * 31) + this.f17903i.hashCode()) * 31) + this.f17904j.hashCode();
    }

    public final Function0 i() {
        return this.f17903i;
    }

    public final vc j() {
        return this.f17896b;
    }

    public String toString() {
        return "ExoPlayerDownloadManagerDependencies(context=" + this.f17895a + ", videoCachePolicy=" + this.f17896b + ", fileCachingFactory=" + this.f17897c + ", cacheFactory=" + this.f17898d + ", cacheDataSourceFactoryFactory=" + this.f17899e + ", httpDataSourceFactory=" + this.f17900f + ", downloadManagerFactory=" + this.f17901g + ", databaseProviderFactory=" + this.f17902h + ", setCookieHandler=" + this.f17903i + ", fakePrecacheFilesManagerFactory=" + this.f17904j + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ i5(android.content.Context r11, com.chartboost.sdk.impl.vc r12, kotlin.jvm.functions.Function1 r13, kotlin.jvm.functions.Function4 r14, kotlin.jvm.functions.Function2 r15, com.google.android.exoplayer2.upstream.DefaultHttpDataSource.Factory r16, kotlin.jvm.functions.Function5 r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function0 r19, kotlin.jvm.functions.Function1 r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r10 = this;
            r0 = r21
            r1 = r0 & 1
            if (r1 == 0) goto L_0x001a
            com.chartboost.sdk.impl.i3 r1 = com.chartboost.sdk.impl.i3.f17882b
            com.chartboost.sdk.impl.z0 r1 = r1.a()
            android.content.Context r1 = r1.getContext()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r2 = "ChartboostDependencyCont…ontext.applicationContext"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            goto L_0x001b
        L_0x001a:
            r1 = r11
        L_0x001b:
            r2 = r0 & 2
            if (r2 == 0) goto L_0x002a
            com.chartboost.sdk.impl.i3 r2 = com.chartboost.sdk.impl.i3.f17882b
            com.chartboost.sdk.impl.c1 r2 = r2.d()
            com.chartboost.sdk.impl.vc r2 = r2.k()
            goto L_0x002b
        L_0x002a:
            r2 = r12
        L_0x002b:
            r3 = r0 & 4
            if (r3 == 0) goto L_0x0032
            com.chartboost.sdk.impl.i5$a r3 = com.chartboost.sdk.impl.i5.a.f17905b
            goto L_0x0033
        L_0x0032:
            r3 = r13
        L_0x0033:
            r4 = r0 & 8
            if (r4 == 0) goto L_0x003a
            com.chartboost.sdk.impl.i5$b r4 = com.chartboost.sdk.impl.i5.b.f17906b
            goto L_0x003b
        L_0x003a:
            r4 = r14
        L_0x003b:
            r5 = r0 & 16
            if (r5 == 0) goto L_0x0042
            com.chartboost.sdk.impl.i5$c r5 = com.chartboost.sdk.impl.i5.c.f17907b
            goto L_0x0043
        L_0x0042:
            r5 = r15
        L_0x0043:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x004d
            com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory r6 = new com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory
            r6.<init>()
            goto L_0x004f
        L_0x004d:
            r6 = r16
        L_0x004f:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x0056
            com.chartboost.sdk.impl.i5$d r7 = com.chartboost.sdk.impl.i5.d.f17908b
            goto L_0x0058
        L_0x0056:
            r7 = r17
        L_0x0058:
            r8 = r0 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x005f
            com.chartboost.sdk.impl.i5$e r8 = com.chartboost.sdk.impl.i5.e.f17909b
            goto L_0x0061
        L_0x005f:
            r8 = r18
        L_0x0061:
            r9 = r0 & 256(0x100, float:3.59E-43)
            if (r9 == 0) goto L_0x0068
            com.chartboost.sdk.impl.i5$f r9 = com.chartboost.sdk.impl.i5.f.f17910b
            goto L_0x006a
        L_0x0068:
            r9 = r19
        L_0x006a:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0071
            com.chartboost.sdk.impl.i5$g r0 = com.chartboost.sdk.impl.i5.g.f17911b
            goto L_0x0073
        L_0x0071:
            r0 = r20
        L_0x0073:
            r11 = r10
            r12 = r1
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r9
            r21 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.i5.<init>(android.content.Context, com.chartboost.sdk.impl.vc, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function4, kotlin.jvm.functions.Function2, com.google.android.exoplayer2.upstream.DefaultHttpDataSource$Factory, kotlin.jvm.functions.Function5, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
