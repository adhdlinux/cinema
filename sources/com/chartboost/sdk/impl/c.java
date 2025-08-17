package com.chartboost.sdk.impl;

import android.util.Log;
import android.view.ViewGroup;
import b0.d;
import com.chartboost.sdk.ads.Ad;
import com.chartboost.sdk.ads.Banner;
import com.chartboost.sdk.ads.Interstitial;
import com.chartboost.sdk.ads.Rewarded;
import com.chartboost.sdk.callbacks.AdCallback;
import com.chartboost.sdk.events.CacheError;
import com.chartboost.sdk.events.ClickError;
import com.chartboost.sdk.events.ShowError;
import com.chartboost.sdk.impl.ib;
import com.chartboost.sdk.impl.tb;
import com.chartboost.sdk.impl.u;
import com.chartboost.sdk.internal.Model.CBError;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

public abstract class c implements j0, z, a5 {

    /* renamed from: a  reason: collision with root package name */
    public final y f17306a;

    /* renamed from: b  reason: collision with root package name */
    public final h0 f17307b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference f17308c;

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f17309d;

    /* renamed from: e  reason: collision with root package name */
    public final d f17310e;

    /* renamed from: f  reason: collision with root package name */
    public final ta f17311f;

    /* renamed from: g  reason: collision with root package name */
    public final q1 f17312g;

    /* renamed from: h  reason: collision with root package name */
    public final Function0 f17313h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ a5 f17314i;

    /* renamed from: j  reason: collision with root package name */
    public Ad f17315j;

    /* renamed from: k  reason: collision with root package name */
    public AdCallback f17316k;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17317a;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError[] r0 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSET_MISSING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ASSET_PREFETCH_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.WEB_VIEW_CLIENT_RECEIVED_ERROR     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.WEB_VIEW_PAGE_LOAD_TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.chartboost.sdk.internal.Model.CBError$CBImpressionError r1 = com.chartboost.sdk.internal.Model.CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                f17317a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.c.a.<clinit>():void");
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function2 {
        public b(Object obj) {
            super(2, obj, c.class, "onAdFailToLoad", "onAdFailToLoad(Ljava/lang/String;Lcom/chartboost/sdk/internal/Model/CBError$CBImpressionError;)V", 0);
        }

        public final void a(String str, CBError.CBImpressionError cBImpressionError) {
            Intrinsics.f(cBImpressionError, "p1");
            ((c) this.receiver).b(str, cBImpressionError);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (CBError.CBImpressionError) obj2);
            return Unit.f40298a;
        }
    }

    public c(y yVar, h0 h0Var, AtomicReference atomicReference, ScheduledExecutorService scheduledExecutorService, d dVar, ta taVar, q1 q1Var, a5 a5Var, Function0 function0) {
        Intrinsics.f(yVar, "adUnitLoader");
        Intrinsics.f(h0Var, "adUnitRenderer");
        Intrinsics.f(atomicReference, "sdkConfig");
        Intrinsics.f(scheduledExecutorService, "backgroundExecutorService");
        Intrinsics.f(dVar, "adApiCallbackSender");
        Intrinsics.f(taVar, "session");
        Intrinsics.f(q1Var, "base64Wrapper");
        Intrinsics.f(a5Var, "eventTracker");
        Intrinsics.f(function0, "androidVersion");
        this.f17306a = yVar;
        this.f17307b = h0Var;
        this.f17308c = atomicReference;
        this.f17309d = scheduledExecutorService;
        this.f17310e = dVar;
        this.f17311f = taVar;
        this.f17312g = q1Var;
        this.f17313h = function0;
        this.f17314i = a5Var;
    }

    public final void a(String str, Ad ad, AdCallback adCallback, String str2) {
        Intrinsics.f(str, "location");
        Intrinsics.f(ad, "ad");
        Intrinsics.f(adCallback, "callback");
        this.f17315j = ad;
        this.f17316k = adCallback;
        Object a2 = g.f17714a.a(str2, this.f17312g, new b(this));
        if (Result.e(a2) == null) {
            this.f17309d.execute(new b0.c(ad, this, str, (String) a2));
        }
    }

    public final boolean b() {
        b1 a2 = this.f17306a.a();
        return (a2 != null ? a2.a() : null) != null;
    }

    public void c(String str) {
        a((tb) tb.e.IMPRESSION_RECORDED, "", str);
        this.f17310e.b(str, this.f17315j, this.f17316k);
    }

    public void clear(String str, String str2) {
        Intrinsics.f(str, "type");
        Intrinsics.f(str2, "location");
        this.f17314i.clear(str, str2);
    }

    public qb clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17314i.clearFromStorage(qbVar);
    }

    public void d(String str) {
        this.f17310e.c(str, this.f17315j, this.f17316k);
    }

    public void e(String str) {
        a((tb) tb.h.FINISH_SUCCESS, "", str);
        c();
        this.f17310e.a(str, (ShowError) null, this.f17315j, this.f17316k);
    }

    public final ib f(String str) {
        if (str == null) {
            str = "";
        }
        return new ib((String) null, (String) null, str, (String) null, (String) null, (String) null, (String) null, (ib.a) null, 251, (DefaultConstructorMarker) null);
    }

    public final boolean g(String str) {
        Intrinsics.f(str, "location");
        if (((Number) this.f17313h.invoke()).intValue() < 21) {
            return true;
        }
        pa paVar = (pa) this.f17308c.get();
        if (paVar != null && paVar.e()) {
            w7.b("AdApi", "Chartboost Integration Warning: your account has been disabled for this session. This app has no active publishing campaigns, please create a publishing campaign in the Chartboost dashboard and wait at least 30 minutes to re-enable. If you need assistance, please visit http://chartboo.st/publishing .");
            return true;
        } else if (str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public qb persist(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17314i.persist(qbVar);
    }

    public ob refresh(ob obVar) {
        Intrinsics.f(obVar, "<this>");
        return this.f17314i.refresh(obVar);
    }

    public ib store(ib ibVar) {
        Intrinsics.f(ibVar, "<this>");
        return this.f17314i.store(ibVar);
    }

    public qb track(qb qbVar) {
        Intrinsics.f(qbVar, "<this>");
        return this.f17314i.track(qbVar);
    }

    public void b(String str) {
        this.f17310e.a(str, (ClickError) null, this.f17315j, this.f17316k);
    }

    /* renamed from: clearFromStorage  reason: collision with other method in class */
    public void m11clearFromStorage(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17314i.clearFromStorage(qbVar);
    }

    /* renamed from: persist  reason: collision with other method in class */
    public void m12persist(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17314i.persist(qbVar);
    }

    /* renamed from: refresh  reason: collision with other method in class */
    public void m13refresh(ob obVar) {
        Intrinsics.f(obVar, "config");
        this.f17314i.refresh(obVar);
    }

    /* renamed from: store  reason: collision with other method in class */
    public void m14store(ib ibVar) {
        Intrinsics.f(ibVar, "ad");
        this.f17314i.store(ibVar);
    }

    /* renamed from: track  reason: collision with other method in class */
    public void m15track(qb qbVar) {
        Intrinsics.f(qbVar, "event");
        this.f17314i.track(qbVar);
    }

    public static final void a(Ad ad, c cVar, String str, String str2) {
        Intrinsics.f(ad, "$ad");
        Intrinsics.f(cVar, "this$0");
        Intrinsics.f(str, "$location");
        if (ad instanceof Banner) {
            Banner banner = (Banner) ad;
            cVar.f17306a.a(str, cVar, str2, new w((ViewGroup) ad, banner.getBannerWidth(), banner.getBannerHeight()));
            return;
        }
        y.a(cVar.f17306a, str, cVar, str2, (w) null, 8, (Object) null);
    }

    public void b(String str, CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        a((tb) tb.a.FINISH_FAILURE, cBImpressionError.name(), str);
        this.f17310e.a(str, j.a(cBImpressionError), this.f17315j, this.f17316k);
    }

    public final void c() {
        u a2;
        Ad ad = this.f17315j;
        if (ad != null && (a2 = a(ad)) != null) {
            this.f17311f.a(a2);
            w7.c("AdApi", "Current session impression count: " + this.f17311f.b(a2) + " in session: " + this.f17311f.c());
        }
    }

    public final void a(Ad ad, AdCallback adCallback) {
        Intrinsics.f(ad, "ad");
        Intrinsics.f(adCallback, "callback");
        this.f17315j = ad;
        this.f17316k = adCallback;
        this.f17309d.execute(new d(this));
    }

    public static final void a(c cVar) {
        Intrinsics.f(cVar, "this$0");
        b1 a2 = cVar.f17306a.a();
        if (a2 != null) {
            cVar.f17307b.a(a2, (j0) cVar);
        } else {
            Log.e("AdApi", "Missing app request on render");
        }
    }

    public final void a() {
        if (b()) {
            this.f17306a.b();
        }
    }

    public void a(String str, String str2, CBError.CBClickError cBClickError) {
        Intrinsics.f(cBClickError, MRAIDPresenter.ERROR);
        String str3 = "Click error: " + cBClickError.name() + " url: " + str2;
        a((tb) tb.b.INVALID_URL_ERROR, str3, str);
        this.f17310e.a(str, j.a(cBClickError, str3), this.f17315j, this.f17316k);
    }

    public void a(String str, CBError.CBImpressionError cBImpressionError) {
        Intrinsics.f(cBImpressionError, MRAIDPresenter.ERROR);
        a(cBImpressionError, str);
        this.f17310e.a(str, j.b(cBImpressionError), this.f17315j, this.f17316k);
    }

    public final void a(CBError.CBImpressionError cBImpressionError, String str) {
        tb.h hVar;
        switch (a.f17317a[cBImpressionError.ordinal()]) {
            case 1:
            case 2:
            case 3:
                hVar = tb.h.UNAVAILABLE_ASSET_ERROR;
                break;
            case 4:
            case 5:
            case 6:
                hVar = tb.h.WEBVIEW_ERROR;
                break;
            default:
                hVar = tb.h.FINISH_FAILURE;
                break;
        }
        a((tb) hVar, cBImpressionError.name(), str);
    }

    public void a(String str, tb tbVar) {
        Intrinsics.f(tbVar, "trackingEventName");
        a(tbVar, "", str);
        this.f17310e.a(str, (CacheError) null, this.f17315j, this.f17316k);
    }

    public void a(String str, int i2) {
        this.f17310e.a(str, this.f17315j, this.f17316k, i2);
    }

    public void a(String str) {
        this.f17310e.a(str, this.f17315j, this.f17316k);
    }

    public final void a(tb tbVar, String str, u uVar, String str2) {
        Intrinsics.f(tbVar, "eventName");
        Intrinsics.f(str, "message");
        Intrinsics.f(uVar, "adType");
        Intrinsics.f(str2, "location");
        track((qb) new m7(tbVar, str, uVar.b(), str2, this.f17307b.F(), (ib) null, 32, (DefaultConstructorMarker) null));
    }

    public final u a(Ad ad) {
        if (ad instanceof Interstitial) {
            return u.b.f18736g;
        }
        if (ad instanceof Rewarded) {
            return u.c.f18737g;
        }
        if (ad instanceof Banner) {
            return u.a.f18735g;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [com.chartboost.sdk.impl.qb] */
    /* JADX WARNING: type inference failed for: r1v4, types: [com.chartboost.sdk.impl.m7] */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.chartboost.sdk.impl.d4] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.chartboost.sdk.impl.tb r9, java.lang.String r10, java.lang.String r11) {
        /*
            r8 = this;
            com.chartboost.sdk.ads.Ad r0 = r8.f17315j
            if (r0 == 0) goto L_0x0010
            com.chartboost.sdk.impl.u r0 = r8.a((com.chartboost.sdk.ads.Ad) r0)
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.b()
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            java.lang.String r0 = "Unknown"
        L_0x0012:
            r4 = r0
            com.chartboost.sdk.ads.Ad r0 = r8.f17315j
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r0.getLocation()
            if (r0 != 0) goto L_0x001f
        L_0x001d:
            java.lang.String r0 = ""
        L_0x001f:
            r5 = r0
            com.chartboost.sdk.impl.tb$b r0 = com.chartboost.sdk.impl.tb.b.INVALID_URL_ERROR
            if (r9 != r0) goto L_0x0037
            com.chartboost.sdk.impl.d4 r0 = new com.chartboost.sdk.impl.d4
            com.chartboost.sdk.impl.h0 r1 = r8.f17307b
            com.chartboost.sdk.Mediation r6 = r1.F()
            com.chartboost.sdk.impl.ib r7 = r8.f(r11)
            r1 = r0
            r2 = r9
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L_0x0049
        L_0x0037:
            com.chartboost.sdk.impl.m7 r0 = new com.chartboost.sdk.impl.m7
            com.chartboost.sdk.impl.h0 r1 = r8.f17307b
            com.chartboost.sdk.Mediation r6 = r1.F()
            com.chartboost.sdk.impl.ib r7 = r8.f(r11)
            r1 = r0
            r2 = r9
            r3 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)
        L_0x0049:
            r8.track((com.chartboost.sdk.impl.qb) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.impl.c.a(com.chartboost.sdk.impl.tb, java.lang.String, java.lang.String):void");
    }
}
