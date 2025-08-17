package com.facebook.ads.internal.n;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.internal.DisplayAdController;
import com.facebook.ads.internal.adapters.AdAdapter;
import com.facebook.ads.internal.adapters.m;
import com.facebook.ads.internal.adapters.x;
import com.facebook.ads.internal.adapters.y;
import com.facebook.ads.internal.adapters.z;
import com.facebook.ads.internal.j.a;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.protocol.d;
import com.facebook.ads.internal.protocol.e;
import com.facebook.ads.internal.q.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.v;
import com.facebook.ads.internal.view.w;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final d f20341b = d.ADS;

    /* renamed from: c  reason: collision with root package name */
    private static final String f20342c = f.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private static WeakHashMap<View, WeakReference<f>> f20343d = new WeakHashMap<>();
    /* access modifiers changed from: private */
    public boolean A;
    /* access modifiers changed from: private */
    public boolean B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    /* access modifiers changed from: private */
    public long E;
    /* access modifiers changed from: private */
    public com.facebook.ads.internal.view.b.c F;
    /* access modifiers changed from: private */
    public e G;
    /* access modifiers changed from: private */
    public x.a H;
    private View I;

    /* renamed from: a  reason: collision with root package name */
    protected y f20344a;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Context f20345e;

    /* renamed from: f  reason: collision with root package name */
    private final String f20346f;

    /* renamed from: g  reason: collision with root package name */
    private final String f20347g;

    /* renamed from: h  reason: collision with root package name */
    private final com.facebook.ads.internal.d.b f20348h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public i f20349i;

    /* renamed from: j  reason: collision with root package name */
    private final c f20350j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public DisplayAdController f20351k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f20352l;

    /* renamed from: m  reason: collision with root package name */
    private com.facebook.ads.internal.h.d f20353m;

    /* renamed from: n  reason: collision with root package name */
    private com.facebook.ads.internal.protocol.f f20354n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public View f20355o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public g f20356p;

    /* renamed from: q  reason: collision with root package name */
    private final List<View> f20357q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public View.OnTouchListener f20358r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public com.facebook.ads.internal.r.a f20359s;

    /* renamed from: t  reason: collision with root package name */
    private a.C0035a f20360t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public WeakReference<a.C0035a> f20361u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public final u f20362v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public x f20363w;

    /* renamed from: x  reason: collision with root package name */
    private a f20364x;

    /* renamed from: y  reason: collision with root package name */
    private w f20365y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public l f20366z;

    private class a implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
        private a() {
        }

        public void onClick(View view) {
            if (!f.this.f20362v.d()) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            int p2 = com.facebook.ads.internal.l.a.p(f.this.f20345e);
            if (p2 < 0 || f.this.f20362v.c() >= ((long) p2)) {
                HashMap hashMap = new HashMap();
                hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, k.a(f.this.f20362v.e()));
                if (f.this.f20366z != null) {
                    hashMap.put("nti", String.valueOf(f.this.f20366z.c()));
                }
                if (f.this.A) {
                    hashMap.put("nhs", String.valueOf(f.this.A));
                }
                f.this.f20359s.a((Map<String, String>) hashMap);
                y yVar = f.this.f20344a;
                if (yVar != null) {
                    yVar.b(hashMap);
                    return;
                }
                return;
            }
            Log.e("FBAudienceNetworkLog", !f.this.f20362v.b() ? "Ad cannot be clicked before it is viewed." : "Clicks happened too fast.");
        }

        public boolean onLongClick(View view) {
            if (f.this.f20355o == null || f.this.F == null) {
                return false;
            }
            f.this.F.setBounds(0, 0, f.this.f20355o.getWidth(), f.this.f20355o.getHeight());
            f.this.F.a(!f.this.F.a());
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            f.this.f20362v.a(motionEvent, f.this.f20355o, view);
            return f.this.f20358r != null && f.this.f20358r.onTouch(view, motionEvent);
        }
    }

    private class b extends com.facebook.ads.internal.adapters.c {
        private b() {
        }

        public void a() {
            if (f.this.f20349i != null) {
                f.this.f20349i.d();
            }
        }

        public void b() {
        }
    }

    public interface c {
        boolean a(View view);
    }

    public f(Context context, y yVar, com.facebook.ads.internal.h.d dVar, c cVar) {
        this(context, (String) null, cVar);
        this.f20344a = yVar;
        this.f20353m = dVar;
        this.f20352l = true;
        this.I = new View(context);
    }

    public f(Context context, String str, c cVar) {
        this.f20347g = UUID.randomUUID().toString();
        this.f20354n = com.facebook.ads.internal.protocol.f.NATIVE_UNKNOWN;
        this.f20357q = new ArrayList();
        this.f20362v = new u();
        this.B = false;
        this.C = false;
        this.G = e.ALL;
        this.H = x.a.ALL;
        this.f20345e = context;
        this.f20346f = str;
        this.f20350j = cVar;
        this.f20348h = new com.facebook.ads.internal.d.b(context);
        this.I = new View(context);
    }

    public f(f fVar) {
        this(fVar.f20345e, (String) null, fVar.f20350j);
        this.f20353m = fVar.f20353m;
        this.f20344a = fVar.f20344a;
        this.f20352l = true;
        this.I = new View(this.f20345e);
    }

    /* access modifiers changed from: private */
    public AdPlacementType K() {
        return this.f20354n == com.facebook.ads.internal.protocol.f.NATIVE_UNKNOWN ? AdPlacementType.NATIVE : AdPlacementType.NATIVE_BANNER;
    }

    /* access modifiers changed from: private */
    public boolean L() {
        y yVar = this.f20344a;
        return yVar != null && ((m) yVar).L();
    }

    private int M() {
        com.facebook.ads.internal.h.d dVar = this.f20353m;
        if (dVar == null) {
            DisplayAdController displayAdController = this.f20351k;
            if (displayAdController == null || displayAdController.a() == null) {
                return 1;
            }
            dVar = this.f20351k.a();
        }
        return dVar.f();
    }

    private int N() {
        com.facebook.ads.internal.h.d dVar = this.f20353m;
        if (dVar == null) {
            DisplayAdController displayAdController = this.f20351k;
            if (displayAdController == null || displayAdController.a() == null) {
                return 0;
            }
            dVar = this.f20351k.a();
        }
        return dVar.g();
    }

    private int O() {
        com.facebook.ads.internal.h.d dVar = this.f20353m;
        if (dVar != null) {
            return dVar.h();
        }
        y yVar = this.f20344a;
        if (yVar != null) {
            return yVar.i();
        }
        DisplayAdController displayAdController = this.f20351k;
        if (displayAdController == null || displayAdController.a() == null) {
            return 0;
        }
        return this.f20351k.a().h();
    }

    private int P() {
        com.facebook.ads.internal.h.d dVar = this.f20353m;
        if (dVar != null) {
            return dVar.i();
        }
        y yVar = this.f20344a;
        if (yVar != null) {
            return yVar.j();
        }
        DisplayAdController displayAdController = this.f20351k;
        if (displayAdController == null || displayAdController.a() == null) {
            return 1000;
        }
        return this.f20351k.a().i();
    }

    /* access modifiers changed from: private */
    public boolean Q() {
        return E() == m.ON;
    }

    private void R() {
        for (View next : this.f20357q) {
            next.setOnClickListener((View.OnClickListener) null);
            next.setOnTouchListener((View.OnTouchListener) null);
            next.setOnLongClickListener((View.OnLongClickListener) null);
        }
        this.f20357q.clear();
    }

    private void a(View view) {
        this.f20357q.add(view);
        view.setOnClickListener(this.f20364x);
        view.setOnTouchListener(this.f20364x);
        if (com.facebook.ads.internal.l.a.b(view.getContext())) {
            view.setOnLongClickListener(this.f20364x);
        }
    }

    /* access modifiers changed from: private */
    public void a(final y yVar, final boolean z2) {
        if (yVar != null) {
            if (this.G.equals(e.ALL)) {
                if (yVar.k() != null) {
                    this.f20348h.a(yVar.k().a(), yVar.k().c(), yVar.k().b());
                }
                if (yVar.l() != null) {
                    this.f20348h.a(yVar.l().a(), yVar.l().c(), yVar.l().b());
                }
                if (yVar.F() != null) {
                    for (f next : yVar.F()) {
                        if (next.k() != null) {
                            this.f20348h.a(next.k().a(), next.k().c(), next.k().b());
                        }
                    }
                }
                if (!TextUtils.isEmpty(yVar.A())) {
                    this.f20348h.a(yVar.A());
                }
            }
            this.f20348h.a((com.facebook.ads.internal.d.a) new com.facebook.ads.internal.d.a() {
                public void a() {
                    f fVar = f.this;
                    fVar.f20344a = yVar;
                    if (fVar.f20349i != null) {
                        if (f.this.G.equals(e.ALL) && !f.this.L()) {
                            f.this.f20349i.a();
                        }
                        if (z2) {
                            f.this.f20349i.b();
                        }
                    }
                }

                public void b() {
                    y yVar = f.this.f20344a;
                    if (yVar != null) {
                        yVar.b_();
                        f.this.f20344a = null;
                    }
                    if (f.this.f20349i != null) {
                        f.this.f20349i.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.CACHE_FAILURE_ERROR, "Failed to download a media."));
                    }
                }
            });
        }
    }

    public static void a(h hVar, ImageView imageView) {
        if (hVar != null && imageView != null) {
            new com.facebook.ads.internal.view.b.d(imageView).a(hVar.c(), hVar.b()).a(hVar.a());
        }
    }

    private void a(List<View> list, View view) {
        c cVar = this.f20350j;
        if (cVar != null && cVar.a(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(list, viewGroup.getChildAt(i2));
            }
            return;
        }
        list.add(view);
    }

    public String A() {
        if (!g()) {
            return null;
        }
        return this.f20344a.z();
    }

    public String B() {
        if (!g() || TextUtils.isEmpty(this.f20344a.A())) {
            return null;
        }
        return this.f20348h.b(this.f20344a.A());
    }

    public String C() {
        if (!g()) {
            return null;
        }
        return this.f20344a.B();
    }

    public String D() {
        if (!g()) {
            return null;
        }
        return this.f20344a.E();
    }

    public m E() {
        return !g() ? m.DEFAULT : this.f20344a.C();
    }

    public List<f> F() {
        if (!g()) {
            return null;
        }
        return this.f20344a.F();
    }

    public String G() {
        if (!g()) {
            return null;
        }
        return this.f20344a.c();
    }

    public void H() {
        this.I.performClick();
    }

    public l I() {
        return this.f20366z;
    }

    public void J() {
        w wVar;
        View view = this.f20355o;
        if (view != null && this.f20356p != null) {
            if (!f20343d.containsKey(view) || f20343d.get(this.f20355o).get() != this) {
                throw new IllegalStateException("View not registered with this NativeAd");
            }
            View view2 = this.f20355o;
            if ((view2 instanceof ViewGroup) && (wVar = this.f20365y) != null) {
                ((ViewGroup) view2).removeView(wVar);
                this.f20365y = null;
            }
            y yVar = this.f20344a;
            if (yVar != null) {
                yVar.b_();
            }
            if (this.F != null && com.facebook.ads.internal.l.a.b(this.f20345e)) {
                this.F.b();
                this.f20355o.getOverlay().remove(this.F);
            }
            f20343d.remove(this.f20355o);
            R();
            this.f20355o = null;
            this.f20356p = null;
            com.facebook.ads.internal.r.a aVar = this.f20359s;
            if (aVar != null) {
                aVar.c();
                this.f20359s = null;
            }
            this.f20363w = null;
        }
    }

    public y a() {
        return this.f20344a;
    }

    public void a(View.OnTouchListener onTouchListener) {
        this.f20358r = onTouchListener;
    }

    public void a(View view, g gVar) {
        ArrayList arrayList = new ArrayList();
        a((List<View>) arrayList, view);
        a(view, gVar, (List<View>) arrayList);
    }

    public void a(View view, g gVar, List<View> list) {
        String str;
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (!g()) {
            Log.e(f20342c, "Ad not loaded");
        } else if (gVar == null) {
            if (this.f20354n == com.facebook.ads.internal.protocol.f.NATIVE_UNKNOWN) {
                i iVar = this.f20349i;
                str = "MediaView is missing.";
                if (iVar != null) {
                    iVar.a(new com.facebook.ads.internal.protocol.a(AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD, str));
                }
                if (!AdInternalSettings.isDebugBuild()) {
                    return;
                }
            } else {
                i iVar2 = this.f20349i;
                str = "AdIconView is missing.";
                if (iVar2 != null) {
                    iVar2.a(new com.facebook.ads.internal.protocol.a(AdErrorType.NO_ICONVIEW_IN_NATIVEBANNERAD, str));
                }
                if (!AdInternalSettings.isDebugBuild()) {
                    return;
                }
            }
            Log.e(f20342c, str);
        } else if (gVar.getAdContentsView() == null) {
            i iVar3 = this.f20349i;
            if (iVar3 != null) {
                iVar3.a(new com.facebook.ads.internal.protocol.a(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, "ad media type is not supported."));
            }
        } else {
            if (this.f20355o != null) {
                Log.w(f20342c, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                J();
            }
            if (f20343d.containsKey(view) && f20343d.get(view).get() != null) {
                Log.w(f20342c, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((f) f20343d.get(view).get()).J();
            }
            this.f20364x = new a();
            this.f20355o = view;
            this.f20356p = gVar;
            if (view instanceof ViewGroup) {
                w wVar = new w(view.getContext(), new v() {
                    public void a(int i2) {
                        y yVar = f.this.f20344a;
                        if (yVar != null) {
                            yVar.a(i2);
                        }
                    }
                });
                this.f20365y = wVar;
                ((ViewGroup) view).addView(wVar);
            }
            ArrayList<View> arrayList = new ArrayList<>(list);
            View view2 = this.I;
            if (view2 != null) {
                arrayList.add(view2);
            }
            for (View a2 : arrayList) {
                a(a2);
            }
            this.f20344a.a(view, arrayList);
            int M = M();
            this.f20360t = new a.C0035a() {
                public void a() {
                    if (!f.this.f20362v.b()) {
                        f.this.f20362v.a();
                        f.this.f20359s.c();
                        if (!(f.this.f20361u == null || f.this.f20361u.get() == null)) {
                            ((a.C0035a) f.this.f20361u.get()).a();
                        }
                        if (f.this.f20363w != null && f.this.f20355o != null && f.this.f20356p != null) {
                            f.this.f20363w.a(f.this.f20355o);
                            f.this.f20363w.a(f.this.f20356p);
                            f.this.f20363w.a(f.this.f20366z);
                            f.this.f20363w.a(f.this.A);
                            f.this.f20363w.b(f.this.B);
                            f.this.f20363w.d(f.this.C);
                            f.this.f20363w.c(f.this.Q());
                            f.this.f20363w.a(f.this.H);
                            f.this.f20363w.e(f.this.D);
                            f.this.f20363w.a();
                        }
                    }
                }
            };
            com.facebook.ads.internal.r.a aVar = new com.facebook.ads.internal.r.a(gVar.getAdContentsView(), M, N(), true, this.f20360t);
            this.f20359s = aVar;
            aVar.a(O());
            this.f20359s.b(P());
            x xVar = new x(this.f20345e, new b(), this.f20359s, this.f20344a);
            this.f20363w = xVar;
            xVar.a((List<View>) arrayList);
            f20343d.put(view, new WeakReference(this));
            if (com.facebook.ads.internal.l.a.b(this.f20345e)) {
                com.facebook.ads.internal.view.b.c cVar = new com.facebook.ads.internal.view.b.c();
                this.F = cVar;
                cVar.a(this.f20346f);
                this.F.b(this.f20345e.getPackageName());
                this.F.a(this.f20359s);
                if (this.f20344a.H() > 0) {
                    this.F.a(this.f20344a.H(), this.f20344a.G());
                }
                com.facebook.ads.internal.h.d dVar = this.f20353m;
                if (dVar != null) {
                    this.F.a(dVar.a());
                } else {
                    DisplayAdController displayAdController = this.f20351k;
                    if (!(displayAdController == null || displayAdController.a() == null)) {
                        this.F.a(this.f20351k.a().a());
                    }
                }
                this.f20355o.getOverlay().add(this.F);
            }
        }
    }

    public void a(z zVar) {
        y yVar = this.f20344a;
        if (yVar != null) {
            yVar.a(zVar);
        }
    }

    public void a(e eVar, String str) {
        if (!this.f20352l) {
            this.E = System.currentTimeMillis();
            this.f20352l = true;
            this.G = eVar;
            if (eVar.equals(e.NONE)) {
                this.H = x.a.NONE;
            }
            DisplayAdController displayAdController = new DisplayAdController(this.f20345e, this.f20346f, this.f20354n, K(), (e) null, f20341b, 1, true);
            this.f20351k = displayAdController;
            displayAdController.a((com.facebook.ads.internal.adapters.a) new com.facebook.ads.internal.adapters.a() {
                public void a() {
                    if (f.this.f20349i != null) {
                        f.this.f20349i.c();
                    }
                }

                public void a(AdAdapter adAdapter) {
                    if (f.this.f20351k != null) {
                        f.this.f20351k.b();
                    }
                }

                public void a(y yVar) {
                    com.facebook.ads.internal.j.b.a(com.facebook.ads.internal.j.a.a(a.b.LOADING_AD, f.this.K().toString(), System.currentTimeMillis() - f.this.E, (String) null));
                    f.this.a(yVar, true);
                    if (f.this.f20349i != null && yVar.F() != null) {
                        AnonymousClass1 r02 = new z() {
                            public void a(y yVar) {
                            }

                            public void a(y yVar, com.facebook.ads.internal.protocol.a aVar) {
                            }

                            public void b(y yVar) {
                            }

                            public void c(y yVar) {
                                if (f.this.f20349i != null) {
                                    f.this.f20349i.c();
                                }
                            }
                        };
                        for (f a2 : yVar.F()) {
                            a2.a((z) r02);
                        }
                    }
                }

                public void a(com.facebook.ads.internal.protocol.a aVar) {
                    if (f.this.f20349i != null) {
                        f.this.f20349i.a(aVar);
                    }
                }

                public void b() {
                    throw new IllegalStateException("Native ads manager their own impressions.");
                }
            });
            this.f20351k.a(str);
            return;
        }
        throw new IllegalStateException("loadAd cannot be called more than once");
    }

    public void a(i iVar) {
        this.f20349i = iVar;
    }

    public void a(l lVar) {
        this.f20366z = lVar;
    }

    public void a(com.facebook.ads.internal.protocol.f fVar) {
        this.f20354n = fVar;
    }

    public void a(a.C0035a aVar) {
        this.f20361u = new WeakReference<>(aVar);
    }

    public void a(boolean z2) {
        this.A = z2;
    }

    public void a(boolean z2, boolean z3) {
        i iVar;
        if (z2) {
            if (this.G.equals(e.NONE) && !L() && (iVar = this.f20349i) != null) {
                iVar.a();
            }
            com.facebook.ads.internal.r.a aVar = this.f20359s;
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        com.facebook.ads.internal.r.a aVar2 = this.f20359s;
        if (aVar2 != null) {
            aVar2.c();
        }
        i iVar2 = this.f20349i;
        if (iVar2 != null && z3) {
            iVar2.a(com.facebook.ads.internal.protocol.a.a(AdErrorType.BROKEN_MEDIA_ERROR, "Failed to load Media."));
        }
    }

    public c b() {
        y yVar;
        if (!g() || (yVar = this.f20344a) == null) {
            return null;
        }
        return yVar.I();
    }

    public void b(boolean z2) {
        this.D = z2;
    }

    public void c(boolean z2) {
        this.B = z2;
    }

    public boolean c() {
        DisplayAdController displayAdController = this.f20351k;
        return displayAdController == null || displayAdController.d();
    }

    public void d() {
        if (this.G.equals(e.NONE)) {
            this.H = x.a.MANUAL;
        }
        this.G = e.ALL;
        a(this.f20344a, false);
    }

    public void d(boolean z2) {
        this.C = z2;
    }

    public void e() {
        DisplayAdController displayAdController = this.f20351k;
        if (displayAdController != null) {
            displayAdController.b(true);
            this.f20351k = null;
        }
    }

    public String f() {
        return this.f20346f;
    }

    public boolean g() {
        y yVar = this.f20344a;
        return yVar != null && yVar.c_();
    }

    public boolean h() {
        return g() && this.f20344a.f();
    }

    public boolean i() {
        y yVar = this.f20344a;
        return yVar != null && yVar.a_();
    }

    public h j() {
        if (!g()) {
            return null;
        }
        return this.f20344a.k();
    }

    public h k() {
        if (!g()) {
            return null;
        }
        return this.f20344a.l();
    }

    public k l() {
        if (!g()) {
            return null;
        }
        return this.f20344a.m();
    }

    public String m() {
        if (!g()) {
            return null;
        }
        return this.f20344a.n();
    }

    public String n() {
        if (!g()) {
            return null;
        }
        return this.f20344a.o();
    }

    public String o() {
        if (!g()) {
            return null;
        }
        return this.f20344a.p();
    }

    public String p() {
        if (!g()) {
            return null;
        }
        return this.f20344a.K();
    }

    public String q() {
        if (!g()) {
            return null;
        }
        return this.f20344a.q();
    }

    public String r() {
        if (!g()) {
            return null;
        }
        return this.f20344a.r();
    }

    public String s() {
        if (!g()) {
            return null;
        }
        return this.f20344a.s();
    }

    public String t() {
        if (!g()) {
            return null;
        }
        return this.f20344a.t();
    }

    public String u() {
        if (!g()) {
            return null;
        }
        return this.f20344a.u();
    }

    public String v() {
        if (!g()) {
            return null;
        }
        return this.f20344a.v();
    }

    public j w() {
        if (!g()) {
            return null;
        }
        return this.f20344a.w();
    }

    public String x() {
        if (!g()) {
            return null;
        }
        return this.f20347g;
    }

    public h y() {
        if (!g()) {
            return null;
        }
        return this.f20344a.x();
    }

    public String z() {
        if (!g()) {
            return null;
        }
        return this.f20344a.y();
    }
}
