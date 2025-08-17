package com.chartboost.sdk.impl;

import com.chartboost.sdk.Mediation;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.internal.Model.CBError;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import com.vungle.ads.internal.ui.AdActivity;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class y implements a0, i1, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final u f19000a;

    /* renamed from: b  reason: collision with root package name */
    public final v5 f19001b;

    /* renamed from: c  reason: collision with root package name */
    public final r2 f19002c;

    /* renamed from: d  reason: collision with root package name */
    public final dd f19003d;

    /* renamed from: e  reason: collision with root package name */
    public final m1 f19004e;

    /* renamed from: f  reason: collision with root package name */
    public final l f19005f;

    /* renamed from: g  reason: collision with root package name */
    public final b9 f19006g;

    /* renamed from: h  reason: collision with root package name */
    public final Mediation f19007h;

    /* renamed from: i  reason: collision with root package name */
    public final a5 f19008i;

    /* renamed from: j  reason: collision with root package name */
    public b1 f19009j;

    /* renamed from: k  reason: collision with root package name */
    public z f19010k;

    /* renamed from: l  reason: collision with root package name */
    public w f19011l;

    /* renamed from: m  reason: collision with root package name */
    public final AtomicBoolean f19012m = new AtomicBoolean(false);

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19013a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f19014b;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        static {
            /*
                com.chartboost.sdk.impl.j1[] r0 = com.chartboost.sdk.impl.j1.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.chartboost.sdk.impl.j1 r2 = com.chartboost.sdk.impl.j1.FAILURE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.chartboost.sdk.impl.j1 r3 = com.chartboost.sdk.impl.j1.READY_TO_SHOW     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.chartboost.sdk.impl.j1 r4 = com.chartboost.sdk.impl.j1.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f19013a = r0
                com.chartboost.sdk.internal.Model.CBError$a[] r0 = com.chartboost.sdk.internal.Model.CBError.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.internal.Model.CBError$a r4 = com.chartboost.sdk.internal.Model.CBError.a.HTTP_NOT_FOUND     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.HTTP_NOT_OK     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.chartboost.sdk.internal.Model.CBError$a r1 = com.chartboost.sdk.internal.Model.CBError.a.UNSUPPORTED_OS_VERSION     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                f19014b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.y.a.<clinit>():void");
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ y f19015b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b1 f19016c;

        public static final class a extends Lambda implements Function1 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ y f19017b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b1 f19018c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(y yVar, b1 b1Var) {
                super(1);
                this.f19017b = yVar;
                this.f19018c = b1Var;
            }

            public final void a(v7 v7Var) {
                Intrinsics.f(v7Var, "$this$fold");
                this.f19017b.b(v7Var, this.f19018c);
                this.f19017b.b(this.f19018c);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((v7) obj);
                return Unit.f40298a;
            }
        }

        /* renamed from: com.chartboost.sdk.impl.y$b$b  reason: collision with other inner class name */
        public static final class C0027b extends Lambda implements Function2 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ y f19019b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b1 f19020c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0027b(y yVar, b1 b1Var) {
                super(2);
                this.f19019b = yVar;
                this.f19020c = b1Var;
            }

            public final void a(v7 v7Var, CBError cBError) {
                Intrinsics.f(v7Var, "$this$fold");
                Intrinsics.f(cBError, MRAIDPresenter.ERROR);
                this.f19019b.a(cBError, this.f19020c.d());
                this.f19019b.a(v7Var, this.f19020c);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((v7) obj, (CBError) obj2);
                return Unit.f40298a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(y yVar, b1 b1Var) {
            super(1);
            this.f19015b = yVar;
            this.f19016c = b1Var;
        }

        public final void a(v7 v7Var) {
            Intrinsics.f(v7Var, "$this$loadAd");
            n.a(v7Var, new a(this.f19015b, this.f19016c), new C0027b(this.f19015b, this.f19016c));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((v7) obj);
            return Unit.f40298a;
        }
    }

    public static final class c extends Lambda implements Function1 {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b1 f19021b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ y f19022c;

        public static final class a extends Lambda implements Function1 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b1 f19023b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ y f19024c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b1 b1Var, y yVar) {
                super(1);
                this.f19023b = b1Var;
                this.f19024c = yVar;
            }

            public final void a(v7 v7Var) {
                Intrinsics.f(v7Var, "$this$fold");
                this.f19023b.a(v7Var.a());
                this.f19024c.e(this.f19023b);
                this.f19024c.b(v7Var, this.f19023b);
                this.f19024c.a(this.f19023b, (tb) tb.a.FINISH_SUCCESS);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((v7) obj);
                return Unit.f40298a;
            }
        }

        public static final class b extends Lambda implements Function2 {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ y f19025b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b1 f19026c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(y yVar, b1 b1Var) {
                super(2);
                this.f19025b = yVar;
                this.f19026c = b1Var;
            }

            public final void a(v7 v7Var, CBError cBError) {
                Intrinsics.f(v7Var, "$this$fold");
                Intrinsics.f(cBError, "it");
                this.f19025b.a(v7Var, this.f19026c);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((v7) obj, (CBError) obj2);
                return Unit.f40298a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b1 b1Var, y yVar) {
            super(1);
            this.f19021b = b1Var;
            this.f19022c = yVar;
        }

        public final void a(v7 v7Var) {
            Intrinsics.f(v7Var, "$this$loadAd");
            n.a(v7Var, new a(this.f19021b, this.f19022c), new b(this.f19022c, this.f19021b));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((v7) obj);
            return Unit.f40298a;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function2 {
        public d(Object obj) {
            super(2, obj, y.class, "loadOpenRTBAd", "loadOpenRTBAd(Lcom/chartboost/sdk/internal/AdUnitManager/data/AppRequest;Lcom/chartboost/sdk/internal/AdUnitManager/loaders/LoadParams;)V", 0);
        }

        public final void a(b1 b1Var, u7 u7Var) {
            Intrinsics.f(b1Var, "p0");
            Intrinsics.f(u7Var, "p1");
            ((y) this.receiver).b(b1Var, u7Var);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((b1) obj, (u7) obj2);
            return Unit.f40298a;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function2 {
        public e(Object obj) {
            super(2, obj, y.class, "loadAdGet", "loadAdGet(Lcom/chartboost/sdk/internal/AdUnitManager/data/AppRequest;Lcom/chartboost/sdk/internal/AdUnitManager/loaders/LoadParams;)V", 0);
        }

        public final void a(b1 b1Var, u7 u7Var) {
            Intrinsics.f(b1Var, "p0");
            Intrinsics.f(u7Var, "p1");
            ((y) this.receiver).a(b1Var, u7Var);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((b1) obj, (u7) obj2);
            return Unit.f40298a;
        }
    }

    public y(u uVar, v5 v5Var, r2 r2Var, dd ddVar, m1 m1Var, l lVar, b9 b9Var, Mediation mediation, a5 a5Var) {
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(v5Var, "fileCache");
        Intrinsics.f(r2Var, "reachability");
        Intrinsics.f(ddVar, "videoRepository");
        Intrinsics.f(m1Var, "assetsDownloader");
        Intrinsics.f(lVar, "adLoader");
        Intrinsics.f(b9Var, "ortbLoader");
        Intrinsics.f(a5Var, "eventTracker");
        this.f19000a = uVar;
        this.f19001b = v5Var;
        this.f19002c = r2Var;
        this.f19003d = ddVar;
        this.f19004e = m1Var;
        this.f19005f = lVar;
        this.f19006g = b9Var;
        this.f19007h = mediation;
        this.f19008i = a5Var;
    }

    public final String c(b1 b1Var) {
        v a2 = b1Var.a();
        if (a2 != null) {
            return a2.m();
        }
        return null;
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f19008i.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19008i.clearFromStorage(qbVar);
    }

    public final void d(b1 b1Var) {
        b(b1Var, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        f(b1Var);
    }

    public final void e(b1 b1Var) {
        String str;
        String B;
        v a2 = b1Var.a();
        if (a2 != null && a2.D()) {
            dd ddVar = this.f19003d;
            v a3 = b1Var.a();
            String str2 = "";
            if (a3 == null || (str = a3.C()) == null) {
                str = str2;
            }
            v a4 = b1Var.a();
            if (!(a4 == null || (B = a4.B()) == null)) {
                str2 = B;
            }
            ddVar.a(str, str2, false, (n0) null);
        }
    }

    public final void f(b1 b1Var) {
        a(b1Var);
        b1Var.a((v) null);
        this.f19012m.set(false);
    }

    public final void g(b1 b1Var) {
        Integer num;
        w wVar = this.f19011l;
        Integer num2 = null;
        if (wVar != null) {
            num = Integer.valueOf(wVar.a());
        } else {
            num = null;
        }
        w wVar2 = this.f19011l;
        if (wVar2 != null) {
            num2 = Integer.valueOf(wVar2.c());
        }
        Pair a2 = d0.f17397a.a(b1Var, new u7(b1Var, true, num, num2), new d(this), new e(this));
        ((Function2) a2.a()).invoke(b1Var, (u7) a2.b());
    }

    public final void h(b1 b1Var) {
        try {
            g(b1Var);
        } catch (Exception e2) {
            String a2 = c0.f17318a;
            Intrinsics.e(a2, "TAG");
            w7.b(a2, "sendAdGetRequest: " + e2);
            a(b1Var, new CBError(CBError.a.MISCELLANEOUS, "error sending ad-get request"));
        }
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19008i.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f19008i.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f19008i.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f19008i.track(qbVar);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m76clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19008i.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m77persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19008i.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m78refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f19008i.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m79store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f19008i.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m80track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f19008i.track(qbVar);
    }

    public final void b() {
        if (!this.f19012m.get()) {
            b1 b1Var = this.f19009j;
            if (b1Var != null) {
                a(b1Var);
                b1Var.a((v) null);
            }
            this.f19009j = null;
        }
    }

    public final b1 a() {
        return this.f19009j;
    }

    public static /* synthetic */ void a(y yVar, String str, z zVar, String str2, w wVar, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            wVar = null;
        }
        yVar.a(str, zVar, str2, wVar);
    }

    public final void a(String str, z zVar, String str2, w wVar) {
        v a2;
        String str3 = str;
        z zVar2 = zVar;
        w wVar2 = wVar;
        Intrinsics.f(str3, "location");
        Intrinsics.f(zVar2, "callback");
        if (this.f19012m.getAndSet(true)) {
            a((tb) tb.a.IGNORED, str3);
            return;
        }
        b1 b1Var = this.f19009j;
        if (!(b1Var == null || (a2 = b1Var.a()) == null || this.f19001b.a(a2).booleanValue())) {
            a(b1Var);
            this.f19009j = null;
        }
        b1 b1Var2 = this.f19009j;
        String str4 = str2;
        if (b1Var2 != null) {
            b1Var2.a(str4);
        }
        b1 b1Var3 = this.f19009j;
        if (b1Var3 == null) {
            b1Var3 = new b1((int) System.currentTimeMillis(), str, str2, (w) null, (v) null, false, false, 120, (DefaultConstructorMarker) null);
            this.f19010k = zVar2;
            this.f19011l = wVar2;
            b1Var3.a(wVar2);
            this.f19009j = b1Var3;
        }
        if (!this.f19002c.e()) {
            b(b1Var3, CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_CACHE);
            return;
        }
        b1Var3.a(true);
        if (b1Var3.a() == null) {
            a((tb) tb.a.START, b1Var3.d());
            h(b1Var3);
            return;
        }
        a(b1Var3, (tb) tb.a.IGNORED);
    }

    public final void b(b1 b1Var, u7 u7Var) {
        this.f19006g.a(u7Var, (Function1) new c(b1Var, this));
    }

    public final void b(v7 v7Var, b1 b1Var) {
        a(b1Var.d(), v7Var.a());
        b1Var.a(v7Var.a());
    }

    public final void b(b1 b1Var) {
        this.f19004e.a(b1Var, this.f19000a.b(), this, this);
    }

    public final void b(b1 b1Var, CBError.CBImpressionError cBImpressionError) {
        this.f19012m.set(false);
        a(b1Var, cBImpressionError);
        if (cBImpressionError != CBError.CBImpressionError.NO_AD_FOUND) {
            String a2 = c0.f17318a;
            Intrinsics.e(a2, "TAG");
            StringBuilder sb = new StringBuilder();
            sb.append("reportError: adTypeTraits: ");
            sb.append(this.f19000a.b());
            sb.append(" reason: cache  format: web error: ");
            sb.append(cBImpressionError);
            sb.append(" adId: ");
            v a3 = b1Var.a();
            sb.append(a3 != null ? a3.a() : null);
            sb.append(" appRequest.location: ");
            sb.append(b1Var.d());
            w7.b(a2, sb.toString());
        }
    }

    public void a(b1 b1Var, j1 j1Var) {
        Intrinsics.f(b1Var, AdActivity.REQUEST_KEY_EXTRA);
        Intrinsics.f(j1Var, "resultAsset");
        int i2 = a.f19013a[j1Var.ordinal()];
        if (i2 == 1) {
            d(b1Var);
        } else if (i2 == 2) {
            String a2 = c0.f17318a;
            Intrinsics.e(a2, "TAG");
            w7.a(a2, "onAssetDownloaded: Ready to show");
        } else if (i2 == 3) {
            String a3 = c0.f17318a;
            Intrinsics.e(a3, "TAG");
            w7.a(a3, "onAssetDownloaded: Success");
        }
    }

    public void a(b1 b1Var, tb tbVar) {
        Intrinsics.f(b1Var, "appRequest");
        Intrinsics.f(tbVar, "trackingEventName");
        z zVar = this.f19010k;
        if (zVar != null) {
            zVar.a(c(b1Var), tbVar);
        }
        this.f19012m.set(false);
    }

    public final void a(b1 b1Var, u7 u7Var) {
        this.f19005f.a(u7Var, new b(this, b1Var));
    }

    public final void a(v7 v7Var, b1 b1Var) {
        a(b1Var.d(), (v) null);
        a(b1Var, v7Var.b());
    }

    public final void a(b1 b1Var, CBError cBError) {
        b(b1Var, a(cBError));
        f(b1Var);
    }

    public final CBError.CBImpressionError a(CBError cBError) {
        return (cBError != null ? cBError.getImpressionError() : null) != null ? cBError.getImpressionError() : CBError.CBImpressionError.INTERNAL;
    }

    public final void a(b1 b1Var) {
        String str;
        a5 a5Var = this.f19008i;
        v a2 = b1Var.a();
        if (a2 == null || (str = a2.r()) == null) {
            str = "";
        }
        a5Var.clear(str, b1Var.d());
    }

    public final void a(b1 b1Var, CBError.CBImpressionError cBImpressionError) {
        z zVar = this.f19010k;
        if (zVar != null) {
            zVar.b(c(b1Var), cBImpressionError);
        }
    }

    public final void a(String str, v vVar) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String y2;
        String b2;
        String p2;
        String i2;
        String m2;
        if (str == null) {
            str = "no location";
        }
        String str7 = str;
        String b3 = this.f19000a.b();
        if (vVar == null || (m2 = vVar.m()) == null) {
            str2 = "";
        } else {
            str2 = m2;
        }
        if (vVar == null || (i2 = vVar.i()) == null) {
            str3 = "";
        } else {
            str3 = i2;
        }
        if (vVar == null || (p2 = vVar.p()) == null) {
            str4 = "";
        } else {
            str4 = p2;
        }
        if (vVar == null || (b2 = vVar.b()) == null) {
            str5 = "";
        } else {
            str5 = b2;
        }
        if (vVar == null || (y2 = vVar.y()) == null) {
            str6 = "";
        } else {
            str6 = y2;
        }
        store(new ib(str7, b3, str2, str3, str4, str5, str6, x.a(this.f19011l)));
    }

    public final void a(tb tbVar, String str) {
        track((qb) new m7(tbVar, "", this.f19000a.b(), str, this.f19007h, (ib) null, 32, (DefaultConstructorMarker) null));
    }

    public final void a(CBError cBError, String str) {
        int i2 = a.f19014b[cBError.getError().ordinal()];
        if (i2 == 1 || i2 == 2) {
            a(cBError, (tb) tb.a.SERVER_ERROR, str);
        } else if (i2 != 3) {
            a(cBError, (tb) tb.a.REQUEST_ERROR, str);
        } else {
            a(cBError, (tb) tb.e.UNSUPPORTED_OS_VERSION, str);
        }
    }

    public final void a(CBError cBError, tb tbVar, String str) {
        track((qb) new x4(tbVar, cBError.getErrorDesc(), this.f19000a.b(), str, this.f19007h));
    }
}
