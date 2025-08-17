package com.facebook.ads.internal;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.BannerAdapter;
import com.facebook.ads.internal.adapters.BannerAdapterListener;
import com.facebook.ads.internal.adapters.InterstitialAdapter;
import com.facebook.ads.internal.adapters.InterstitialAdapterListener;
import com.facebook.ads.internal.adapters.ab;
import com.facebook.ads.internal.adapters.ac;
import com.facebook.ads.internal.adapters.s;
import com.facebook.ads.internal.adapters.u;
import com.facebook.ads.internal.adapters.v;
import com.facebook.ads.internal.adapters.z;
import com.facebook.ads.internal.o.c;
import com.facebook.ads.internal.o.g;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.e;
import com.facebook.ads.internal.protocol.f;
import com.facebook.ads.internal.protocol.h;
import com.facebook.ads.internal.q.a.l;
import com.facebook.ads.internal.q.a.o;
import com.facebook.ads.internal.q.a.y;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DisplayAdController implements c.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f19567b = DisplayAdController.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private static final Handler f19568h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private static boolean f19569i = false;
    private boolean A;
    private final com.facebook.ads.internal.m.c B;
    private final EnumSet<CacheFlag> C;

    /* renamed from: a  reason: collision with root package name */
    protected com.facebook.ads.internal.adapters.a f19570a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Context f19571c;

    /* renamed from: d  reason: collision with root package name */
    private final String f19572d;

    /* renamed from: e  reason: collision with root package name */
    private final AdPlacementType f19573e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.ads.internal.o.c f19574f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Handler f19575g;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f19576j;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f19577k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f19578l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f19579m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public volatile boolean f19580n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public AdAdapter f19581o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public AdAdapter f19582p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public View f19583q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public com.facebook.ads.internal.h.c f19584r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public com.facebook.ads.internal.o.b f19585s;

    /* renamed from: t  reason: collision with root package name */
    private f f19586t;

    /* renamed from: u  reason: collision with root package name */
    private d f19587u;

    /* renamed from: v  reason: collision with root package name */
    private e f19588v;

    /* renamed from: w  reason: collision with root package name */
    private int f19589w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f19590x;

    /* renamed from: y  reason: collision with root package name */
    private int f19591y;

    /* renamed from: z  reason: collision with root package name */
    private final c f19592z;

    /* renamed from: com.facebook.ads.internal.DisplayAdController$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f19612a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.ads.internal.protocol.AdPlacementType[] r0 = com.facebook.ads.internal.protocol.AdPlacementType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f19612a = r0
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f19612a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f19612a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f19612a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.NATIVE_BANNER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f19612a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.INSTREAM     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f19612a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.ads.internal.protocol.AdPlacementType r1 = com.facebook.ads.internal.protocol.AdPlacementType.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.DisplayAdController.AnonymousClass4.<clinit>():void");
        }
    }

    private static final class a extends y<DisplayAdController> {
        public a(DisplayAdController displayAdController) {
            super(displayAdController);
        }

        public void run() {
            DisplayAdController displayAdController = (DisplayAdController) a();
            if (displayAdController != null) {
                boolean unused = displayAdController.f19578l = false;
                displayAdController.b((String) null);
            }
        }
    }

    private static final class b extends y<DisplayAdController> {
        public b(DisplayAdController displayAdController) {
            super(displayAdController);
        }

        public void run() {
            DisplayAdController displayAdController = (DisplayAdController) a();
            if (displayAdController != null) {
                displayAdController.l();
            }
        }
    }

    private class c extends BroadcastReceiver {
        private c() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                DisplayAdController.this.m();
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                DisplayAdController.this.l();
            }
        }
    }

    static {
        com.facebook.ads.internal.q.a.d.a();
    }

    public DisplayAdController(Context context, String str, f fVar, AdPlacementType adPlacementType, e eVar, d dVar, int i2, boolean z2) {
        this(context, str, fVar, adPlacementType, eVar, dVar, i2, z2, EnumSet.of(CacheFlag.NONE));
    }

    public DisplayAdController(Context context, String str, f fVar, AdPlacementType adPlacementType, e eVar, d dVar, int i2, boolean z2, EnumSet<CacheFlag> enumSet) {
        this.f19575g = new Handler();
        this.f19590x = false;
        this.f19591y = -1;
        Context applicationContext = context.getApplicationContext();
        this.f19571c = applicationContext;
        this.f19572d = str;
        this.f19586t = fVar;
        this.f19573e = adPlacementType;
        this.f19588v = eVar;
        this.f19587u = dVar;
        this.f19589w = i2;
        this.f19592z = new c();
        this.C = enumSet;
        com.facebook.ads.internal.o.c cVar = new com.facebook.ads.internal.o.c(applicationContext);
        this.f19574f = cVar;
        cVar.a((c.a) this);
        this.f19576j = new a(this);
        this.f19577k = new b(this);
        this.f19579m = z2;
        g();
        try {
            CookieManager.getInstance();
        } catch (Exception e2) {
            Log.w(f19567b, "Failed to initialize CookieManager.", e2);
        }
        com.facebook.ads.internal.i.a.a(this.f19571c).a();
        this.B = com.facebook.ads.internal.m.d.a(this.f19571c);
    }

    /* access modifiers changed from: private */
    public Map<String, String> a(long j2) {
        HashMap hashMap = new HashMap();
        hashMap.put("delay", String.valueOf(System.currentTimeMillis() - j2));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public void a(AdAdapter adAdapter) {
        if (adAdapter != null) {
            adAdapter.onDestroy();
        }
    }

    private void a(final BannerAdapter bannerAdapter, com.facebook.ads.internal.h.c cVar, Map<String, Object> map) {
        final AnonymousClass8 r02 = new Runnable() {
            public void run() {
                DisplayAdController.this.a((AdAdapter) bannerAdapter);
                DisplayAdController.this.j();
            }
        };
        this.f19575g.postDelayed(r02, (long) cVar.a().j());
        bannerAdapter.loadBannerAd(this.f19571c, this.B, this.f19588v, new BannerAdapterListener() {
            public void onBannerAdClicked(BannerAdapter bannerAdapter) {
                DisplayAdController.this.f19570a.a();
            }

            public void onBannerAdExpanded(BannerAdapter bannerAdapter) {
            }

            public void onBannerAdLoaded(BannerAdapter bannerAdapter, View view) {
                if (bannerAdapter == DisplayAdController.this.f19581o) {
                    DisplayAdController.this.f19575g.removeCallbacks(r02);
                    AdAdapter f2 = DisplayAdController.this.f19582p;
                    AdAdapter unused = DisplayAdController.this.f19582p = bannerAdapter;
                    View unused2 = DisplayAdController.this.f19583q = view;
                    if (!DisplayAdController.this.f19580n) {
                        DisplayAdController.this.f19570a.a((AdAdapter) bannerAdapter);
                        return;
                    }
                    DisplayAdController.this.f19570a.a(view);
                    DisplayAdController.this.a(f2);
                }
            }

            public void onBannerAdMinimized(BannerAdapter bannerAdapter) {
            }

            public void onBannerError(BannerAdapter bannerAdapter, AdError adError) {
                if (bannerAdapter == DisplayAdController.this.f19581o) {
                    DisplayAdController.this.f19575g.removeCallbacks(r02);
                    DisplayAdController.this.a((AdAdapter) bannerAdapter);
                    DisplayAdController.this.j();
                }
            }

            public void onBannerLoggingImpression(BannerAdapter bannerAdapter) {
                DisplayAdController.this.f19570a.b();
            }
        }, map);
    }

    private void a(final InterstitialAdapter interstitialAdapter, com.facebook.ads.internal.h.c cVar, Map<String, Object> map) {
        final AnonymousClass10 r02 = new Runnable() {
            public void run() {
                DisplayAdController.this.a((AdAdapter) interstitialAdapter);
                DisplayAdController.this.j();
            }
        };
        this.f19575g.postDelayed(r02, (long) cVar.a().j());
        interstitialAdapter.loadInterstitialAd(this.f19571c, new InterstitialAdapterListener() {
            public void onInterstitialActivityDestroyed() {
                DisplayAdController.this.f19570a.f();
            }

            public void onInterstitialAdClicked(InterstitialAdapter interstitialAdapter, String str, boolean z2) {
                DisplayAdController.this.f19570a.a();
                boolean z3 = !TextUtils.isEmpty(str);
                if (z2 && z3) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    if (!(DisplayAdController.this.f19585s.f20406b instanceof Activity)) {
                        intent.addFlags(268435456);
                    }
                    intent.setData(Uri.parse(str));
                    DisplayAdController.this.f19585s.f20406b.startActivity(intent);
                }
            }

            public void onInterstitialAdDismissed(InterstitialAdapter interstitialAdapter) {
                DisplayAdController.this.f19570a.e();
            }

            public void onInterstitialAdDisplayed(InterstitialAdapter interstitialAdapter) {
                DisplayAdController.this.f19570a.d();
            }

            public void onInterstitialAdLoaded(InterstitialAdapter interstitialAdapter) {
                if (interstitialAdapter == DisplayAdController.this.f19581o) {
                    DisplayAdController displayAdController = DisplayAdController.this;
                    if (interstitialAdapter == null) {
                        com.facebook.ads.internal.q.d.a.a(displayAdController.f19571c, "api", com.facebook.ads.internal.q.d.b.f20742b, (Exception) new com.facebook.ads.internal.protocol.b(AdErrorType.NO_ADAPTER_ON_LOAD, "Adapter is null on loadInterstitialAd"));
                        onInterstitialError(interstitialAdapter, AdError.INTERNAL_ERROR);
                        return;
                    }
                    displayAdController.f19575g.removeCallbacks(r02);
                    AdAdapter unused = DisplayAdController.this.f19582p = interstitialAdapter;
                    DisplayAdController.this.f19570a.a((AdAdapter) interstitialAdapter);
                    DisplayAdController.this.l();
                }
            }

            public void onInterstitialError(InterstitialAdapter interstitialAdapter, AdError adError) {
                if (interstitialAdapter == DisplayAdController.this.f19581o) {
                    DisplayAdController.this.f19575g.removeCallbacks(r02);
                    DisplayAdController.this.a((AdAdapter) interstitialAdapter);
                    DisplayAdController.this.j();
                    DisplayAdController.this.f19570a.a(new com.facebook.ads.internal.protocol.a(adError.getErrorCode(), adError.getErrorMessage()));
                }
            }

            public void onInterstitialLoggingImpression(InterstitialAdapter interstitialAdapter) {
                DisplayAdController.this.f19570a.b();
            }
        }, map, this.B, this.C);
    }

    private void a(ab abVar, com.facebook.ads.internal.h.c cVar, Map<String, Object> map) {
        abVar.a(this.f19571c, new ac() {
            public void a() {
                DisplayAdController.this.f19570a.h();
            }

            public void a(ab abVar) {
                AdAdapter unused = DisplayAdController.this.f19582p = abVar;
                DisplayAdController.this.f19570a.a((AdAdapter) abVar);
            }

            public void a(ab abVar, AdError adError) {
                DisplayAdController.this.f19570a.a(new com.facebook.ads.internal.protocol.a(AdErrorType.INTERNAL_ERROR, (String) null));
                DisplayAdController.this.a((AdAdapter) abVar);
                DisplayAdController.this.j();
            }

            public void b() {
                DisplayAdController.this.f19570a.k();
            }

            public void b(ab abVar) {
                DisplayAdController.this.f19570a.a();
            }

            public void c(ab abVar) {
                DisplayAdController.this.f19570a.b();
            }

            public void d(ab abVar) {
                DisplayAdController.this.f19570a.g();
            }

            public void e(ab abVar) {
                DisplayAdController.this.f19570a.i();
            }

            public void f(ab abVar) {
                DisplayAdController.this.f19570a.j();
            }
        }, map, this.f19590x);
    }

    private void a(s sVar, com.facebook.ads.internal.h.c cVar, Map<String, Object> map) {
        sVar.a(this.f19571c, new com.facebook.ads.a.a() {
            public void a(s sVar) {
                AdAdapter unused = DisplayAdController.this.f19582p = sVar;
                boolean unused2 = DisplayAdController.this.f19580n = false;
                DisplayAdController.this.f19570a.a((AdAdapter) sVar);
            }

            public void a(s sVar, View view) {
                DisplayAdController.this.f19570a.a(view);
            }

            public void a(s sVar, AdError adError) {
                DisplayAdController.this.f19570a.a(new com.facebook.ads.internal.protocol.a(adError.getErrorCode(), adError.getErrorMessage()));
            }

            public void b(s sVar) {
                DisplayAdController.this.f19570a.a();
            }

            public void c(s sVar) {
                DisplayAdController.this.f19570a.b();
            }

            public void d(s sVar) {
                DisplayAdController.this.f19570a.c();
            }
        }, map, this.B, this.C);
    }

    private void a(com.facebook.ads.internal.adapters.y yVar, com.facebook.ads.internal.h.c cVar, com.facebook.ads.internal.h.a aVar, Map<String, Object> map) {
        final com.facebook.ads.internal.adapters.y yVar2 = yVar;
        final long currentTimeMillis = System.currentTimeMillis();
        final com.facebook.ads.internal.h.a aVar2 = aVar;
        AnonymousClass12 r02 = new Runnable() {
            public void run() {
                DisplayAdController.this.a((AdAdapter) yVar2);
                if (yVar2 instanceof u) {
                    Context h2 = DisplayAdController.this.f19571c;
                    com.facebook.ads.internal.q.a.d.a(h2, v.a(((u) yVar2).J()) + " Failed. Ad request timed out");
                }
                Map a2 = DisplayAdController.this.a(currentTimeMillis);
                a2.put(MRAIDPresenter.ERROR, "-1");
                a2.put("msg", "timeout");
                DisplayAdController.this.a(aVar2.a(com.facebook.ads.internal.h.e.REQUEST), (Map<String, String>) a2);
                DisplayAdController.this.j();
            }
        };
        this.f19575g.postDelayed(r02, (long) cVar.a().j());
        final AnonymousClass12 r2 = r02;
        yVar.a(this.f19571c, new z() {

            /* renamed from: a  reason: collision with root package name */
            boolean f19603a = false;

            /* renamed from: b  reason: collision with root package name */
            boolean f19604b = false;

            /* renamed from: c  reason: collision with root package name */
            boolean f19605c = false;

            public void a(com.facebook.ads.internal.adapters.y yVar) {
                if (yVar == DisplayAdController.this.f19581o) {
                    DisplayAdController.this.f19575g.removeCallbacks(r2);
                    AdAdapter unused = DisplayAdController.this.f19582p = yVar;
                    DisplayAdController.this.f19570a.a((AdAdapter) yVar);
                    if (!this.f19603a) {
                        this.f19603a = true;
                        DisplayAdController.this.a(aVar2.a(com.facebook.ads.internal.h.e.REQUEST), (Map<String, String>) DisplayAdController.this.a(currentTimeMillis));
                    }
                }
            }

            public void a(com.facebook.ads.internal.adapters.y yVar, com.facebook.ads.internal.protocol.a aVar) {
                if (yVar == DisplayAdController.this.f19581o) {
                    DisplayAdController.this.f19575g.removeCallbacks(r2);
                    DisplayAdController.this.a((AdAdapter) yVar);
                    if (!this.f19603a) {
                        this.f19603a = true;
                        Map a2 = DisplayAdController.this.a(currentTimeMillis);
                        a2.put(MRAIDPresenter.ERROR, String.valueOf(aVar.a().getErrorCode()));
                        a2.put("msg", String.valueOf(aVar.b()));
                        DisplayAdController.this.a(aVar2.a(com.facebook.ads.internal.h.e.REQUEST), (Map<String, String>) a2);
                    }
                    DisplayAdController.this.j();
                }
            }

            public void b(com.facebook.ads.internal.adapters.y yVar) {
                if (!this.f19604b) {
                    this.f19604b = true;
                    DisplayAdController.this.a(aVar2.a(com.facebook.ads.internal.h.e.IMPRESSION), (Map<String, String>) null);
                }
            }

            public void c(com.facebook.ads.internal.adapters.y yVar) {
                if (!this.f19605c) {
                    this.f19605c = true;
                    DisplayAdController.this.a(aVar2.a(com.facebook.ads.internal.h.e.CLICK), (Map<String, String>) null);
                }
                com.facebook.ads.internal.adapters.a aVar = DisplayAdController.this.f19570a;
                if (aVar != null) {
                    aVar.a();
                }
            }
        }, this.B, map, NativeAdBase.getViewTraversalPredicate());
    }

    /* access modifiers changed from: private */
    public void a(List<String> list, Map<String, String> map) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                new com.facebook.ads.internal.q.c.e(this.f19571c, map).execute(new String[]{str});
            }
        }
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        try {
            h hVar = new h(this.f19571c, str, this.f19572d, this.f19586t);
            Context context = this.f19571c;
            com.facebook.ads.internal.i.c cVar = new com.facebook.ads.internal.i.c(this.f19571c, false);
            String str2 = this.f19572d;
            e eVar = this.f19588v;
            com.facebook.ads.internal.o.b bVar = new com.facebook.ads.internal.o.b(context, cVar, str2, eVar != null ? new l(eVar.b(), this.f19588v.a()) : null, this.f19586t, this.f19587u, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, com.facebook.ads.internal.adapters.e.a(com.facebook.ads.internal.protocol.c.a(this.f19586t).a()), this.f19589w, AdSettings.isTestMode(this.f19571c), AdSettings.isChildDirected(), hVar, o.a(com.facebook.ads.internal.l.a.q(this.f19571c)));
            this.f19585s = bVar;
            this.f19574f.a(bVar);
        } catch (com.facebook.ads.internal.protocol.b e2) {
            a(com.facebook.ads.internal.protocol.a.a(e2));
        }
    }

    private void g() {
        if (!this.f19579m) {
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            this.f19571c.registerReceiver(this.f19592z, intentFilter);
            this.A = true;
        }
    }

    private void h() {
        if (this.A) {
            try {
                this.f19571c.unregisterReceiver(this.f19592z);
                this.A = false;
            } catch (Exception e2) {
                com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(e2, "Error unregistering screen state receiever"));
            }
        }
    }

    private AdPlacementType i() {
        AdPlacementType adPlacementType = this.f19573e;
        if (adPlacementType != null) {
            return adPlacementType;
        }
        e eVar = this.f19588v;
        return eVar == null ? AdPlacementType.NATIVE : eVar == e.INTERSTITIAL ? AdPlacementType.INTERSTITIAL : AdPlacementType.BANNER;
    }

    /* access modifiers changed from: private */
    public synchronized void j() {
        f19568h.post(new Runnable() {
            public void run() {
                try {
                    DisplayAdController.this.k();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void k() {
        this.f19581o = null;
        com.facebook.ads.internal.h.c cVar = this.f19584r;
        com.facebook.ads.internal.h.a d2 = cVar.d();
        if (d2 == null) {
            this.f19570a.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.NO_FILL, ""));
            l();
            return;
        }
        String a2 = d2.a();
        AdAdapter a3 = com.facebook.ads.internal.adapters.e.a(a2, cVar.a().b());
        if (a3 == null) {
            String str = f19567b;
            Log.e(str, "Adapter does not exist: " + a2);
            j();
        } else if (i() != a3.getPlacementType()) {
            this.f19570a.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.INTERNAL_ERROR, ""));
        } else {
            this.f19581o = a3;
            HashMap hashMap = new HashMap();
            com.facebook.ads.internal.h.d a4 = cVar.a();
            hashMap.put("data", d2.b());
            hashMap.put("definition", a4);
            hashMap.put(AudienceNetworkActivity.PLACEMENT_ID, this.f19572d);
            hashMap.put(AudienceNetworkActivity.REQUEST_TIME, Long.valueOf(a4.a()));
            if (this.f19585s == null) {
                this.f19570a.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.UNKNOWN_ERROR, "environment is empty"));
                return;
            }
            switch (AnonymousClass4.f19612a[a3.getPlacementType().ordinal()]) {
                case 1:
                    a((InterstitialAdapter) a3, cVar, (Map<String, Object>) hashMap);
                    return;
                case 2:
                    a((BannerAdapter) a3, cVar, (Map<String, Object>) hashMap);
                    return;
                case 3:
                case 4:
                    a((com.facebook.ads.internal.adapters.y) a3, cVar, d2, hashMap);
                    return;
                case 5:
                    a((s) a3, cVar, (Map<String, Object>) hashMap);
                    return;
                case 6:
                    a((ab) a3, cVar, (Map<String, Object>) hashMap);
                    return;
                default:
                    Log.e(f19567b, "attempt unexpected adapter type");
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void l() {
        if (!this.f19579m && !this.f19578l && AnonymousClass4.f19612a[i().ordinal()] == 1) {
            if (!com.facebook.ads.internal.q.e.a.a(this.f19571c)) {
                this.f19575g.postDelayed(this.f19577k, 1000);
            }
            com.facebook.ads.internal.h.c cVar = this.f19584r;
            long c2 = cVar == null ? NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS : cVar.a().c();
            if (c2 > 0) {
                this.f19575g.postDelayed(this.f19576j, c2);
                this.f19578l = true;
            }
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (this.f19578l) {
            this.f19575g.removeCallbacks(this.f19576j);
            this.f19578l = false;
        }
    }

    private Handler n() {
        return !o() ? this.f19575g : f19568h;
    }

    private static synchronized boolean o() {
        boolean z2;
        synchronized (DisplayAdController.class) {
            z2 = f19569i;
        }
        return z2;
    }

    protected static synchronized void setMainThreadForced(boolean z2) {
        synchronized (DisplayAdController.class) {
            String str = f19567b;
            Log.d(str, "DisplayAdController changed main thread forced from " + f19569i + " to " + z2);
            f19569i = z2;
        }
    }

    public com.facebook.ads.internal.h.d a() {
        com.facebook.ads.internal.h.c cVar = this.f19584r;
        if (cVar == null) {
            return null;
        }
        return cVar.a();
    }

    public void a(int i2) {
        this.f19591y = i2;
    }

    public void a(RewardData rewardData) {
        AdAdapter adAdapter = this.f19582p;
        if (adAdapter == null) {
            throw new IllegalStateException("no adapter ready to set reward on");
        } else if (adAdapter.getPlacementType() == AdPlacementType.REWARDED_VIDEO) {
            ((ab) this.f19582p).a(rewardData);
        } else {
            throw new IllegalStateException("can only set on rewarded video ads");
        }
    }

    public void a(com.facebook.ads.internal.adapters.a aVar) {
        this.f19570a = aVar;
    }

    public synchronized void a(final g gVar) {
        n().post(new Runnable() {
            public void run() {
                com.facebook.ads.internal.h.c a2 = gVar.a();
                if (a2 == null || a2.a() == null) {
                    throw new IllegalStateException("invalid placement in response");
                }
                com.facebook.ads.internal.h.c unused = DisplayAdController.this.f19584r = a2;
                DisplayAdController.this.j();
            }
        });
    }

    public synchronized void a(final com.facebook.ads.internal.protocol.a aVar) {
        n().post(new Runnable() {
            public void run() {
                DisplayAdController.this.f19570a.a(aVar);
            }
        });
    }

    public void a(String str) {
        b(str);
    }

    public void a(boolean z2) {
        this.f19590x = z2;
    }

    public void b() {
        com.facebook.ads.internal.adapters.a aVar;
        com.facebook.ads.internal.protocol.a a2;
        if (this.f19582p == null) {
            com.facebook.ads.internal.q.d.a.a(this.f19571c, "api", com.facebook.ads.internal.q.d.b.f20745e, (Exception) new com.facebook.ads.internal.protocol.b(AdErrorType.NO_ADAPTER_ON_START, "Adapter is null on startAd"));
            aVar = this.f19570a;
            AdErrorType adErrorType = AdErrorType.INTERNAL_ERROR;
            a2 = com.facebook.ads.internal.protocol.a.a(adErrorType, adErrorType.getDefaultErrorMessage());
        } else if (this.f19580n) {
            Context context = this.f19571c;
            int i2 = com.facebook.ads.internal.q.d.b.f20743c;
            AdErrorType adErrorType2 = AdErrorType.AD_ALREADY_STARTED;
            com.facebook.ads.internal.q.d.a.a(context, "api", i2, (Exception) new com.facebook.ads.internal.protocol.b(adErrorType2, "ad already started"));
            aVar = this.f19570a;
            a2 = com.facebook.ads.internal.protocol.a.a(adErrorType2, adErrorType2.getDefaultErrorMessage());
        } else {
            this.f19580n = true;
            switch (AnonymousClass4.f19612a[this.f19582p.getPlacementType().ordinal()]) {
                case 1:
                    ((InterstitialAdapter) this.f19582p).show();
                    return;
                case 2:
                    View view = this.f19583q;
                    if (view != null) {
                        this.f19570a.a(view);
                        return;
                    }
                    return;
                case 3:
                case 4:
                    com.facebook.ads.internal.adapters.y yVar = (com.facebook.ads.internal.adapters.y) this.f19582p;
                    if (yVar.c_()) {
                        this.f19570a.a(yVar);
                        return;
                    }
                    throw new IllegalStateException("ad is not ready or already displayed");
                case 5:
                    ((s) this.f19582p).e();
                    return;
                case 6:
                    ab abVar = (ab) this.f19582p;
                    abVar.a(this.f19591y);
                    abVar.b();
                    return;
                default:
                    Log.e(f19567b, "start unexpected adapter type");
                    return;
            }
        }
        aVar.a(a2);
    }

    public void b(boolean z2) {
        h();
        if (z2 || this.f19580n) {
            m();
            a(this.f19582p);
            this.f19574f.a();
            this.f19583q = null;
            this.f19580n = false;
        }
    }

    public void c() {
        b(false);
    }

    public boolean d() {
        com.facebook.ads.internal.h.c cVar = this.f19584r;
        return cVar == null || cVar.e();
    }

    public com.facebook.ads.internal.m.c e() {
        return this.B;
    }

    public AdAdapter f() {
        return this.f19582p;
    }
}
