package com.facebook.ads.internal.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.internal.adapters.a.k;
import com.facebook.ads.internal.q.a.u;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.view.a;
import com.facebook.ads.internal.view.e.b;
import com.facebook.ads.internal.view.f;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.e;
import com.facebook.ads.internal.view.f.b.m;
import com.facebook.ads.internal.view.f.b.n;
import com.facebook.ads.internal.view.f.b.z;
import com.facebook.ads.internal.view.f.c.d;
import com.facebook.ads.internal.view.f.c.f;
import com.facebook.ads.internal.view.f.c.j;
import com.facebook.ads.internal.view.f.c.l;
import com.facebook.react.uimanager.events.PointerEventHelper;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class o extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f21671a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21672b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f21673c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f21674d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f21675e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21676f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21677g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21678h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f21679i;

    /* renamed from: j  reason: collision with root package name */
    private static final RelativeLayout.LayoutParams f21680j = new RelativeLayout.LayoutParams(-1, -1);
    private Context A;
    /* access modifiers changed from: private */
    public a B;
    /* access modifiers changed from: private */
    public a.C0037a C;
    private com.facebook.ads.internal.view.e.a D;
    /* access modifiers changed from: private */
    public d E;
    private l F;
    /* access modifiers changed from: private */
    public j G;
    private f H;
    /* access modifiers changed from: private */
    public b I;
    /* access modifiers changed from: private */
    public boolean J;

    /* renamed from: k  reason: collision with root package name */
    private final AudienceNetworkActivity.BackButtonInterceptor f21681k = new AudienceNetworkActivity.BackButtonInterceptor() {
        public boolean interceptBackButton() {
            return !o.this.J;
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private final c f21682l;

    /* renamed from: m  reason: collision with root package name */
    private final e f21683m;

    /* renamed from: n  reason: collision with root package name */
    private final m f21684n;

    /* renamed from: o  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.b.o f21685o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public final k f21686p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public final com.facebook.ads.internal.m.c f21687q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public final com.facebook.ads.internal.r.a f21688r;

    /* renamed from: s  reason: collision with root package name */
    private final a.C0035a f21689s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public final u f21690t;

    /* renamed from: u  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.c.o f21691u;

    /* renamed from: v  reason: collision with root package name */
    private final com.facebook.ads.internal.view.f.b f21692v;

    /* renamed from: w  reason: collision with root package name */
    private final RelativeLayout f21693w;

    /* renamed from: x  reason: collision with root package name */
    private final f f21694x;

    /* renamed from: y  reason: collision with root package name */
    private final com.facebook.ads.internal.adapters.a.d f21695y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public final AtomicBoolean f21696z;

    /* renamed from: com.facebook.ads.internal.view.o$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21705a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.facebook.ads.internal.view.e.b$a[] r0 = com.facebook.ads.internal.view.e.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21705a = r0
                com.facebook.ads.internal.view.e.b$a r1 = com.facebook.ads.internal.view.e.b.a.MARKUP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21705a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.ads.internal.view.e.b$a r1 = com.facebook.ads.internal.view.e.b.a.SCREENSHOTS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21705a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.ads.internal.view.e.b$a r1 = com.facebook.ads.internal.view.e.b.a.INFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.view.o.AnonymousClass9.<clinit>():void");
        }
    }

    static {
        float f2 = x.f20694b;
        f21672b = (int) (12.0f * f2);
        f21673c = (int) (18.0f * f2);
        f21674d = (int) (16.0f * f2);
        f21675e = (int) (72.0f * f2);
        f21676f = (int) (f2 * 56.0f);
        f21677g = (int) (56.0f * f2);
        f21678h = (int) (28.0f * f2);
        f21679i = (int) (f2 * 20.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o(Context context, com.facebook.ads.internal.m.c cVar, com.facebook.ads.internal.view.f.a aVar, a.C0037a aVar2, k kVar) {
        super(context);
        Context context2 = context;
        com.facebook.ads.internal.m.c cVar2 = cVar;
        AnonymousClass2 r8 = new c() {
            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                if (o.this.C != null) {
                    o.this.I.d();
                    o.this.c();
                    o.this.C.a(z.REWARDED_VIDEO_COMPLETE.a(), bVar);
                }
            }
        };
        this.f21682l = r8;
        AnonymousClass3 r9 = new e() {
            public void a(com.facebook.ads.internal.view.f.b.d dVar) {
                if (o.this.C != null) {
                    o.this.C.a(z.REWARDED_VIDEO_ERROR.a());
                }
                o.this.a();
            }
        };
        this.f21683m = r9;
        AnonymousClass4 r10 = new m() {
            public void a(com.facebook.ads.internal.view.f.b.l lVar) {
                if (o.this.B != null) {
                    o.this.B.a(com.facebook.ads.internal.view.f.a.a.USER_STARTED);
                    o.this.f21688r.a();
                    o.this.f21696z.set(o.this.B.j());
                    o.this.f();
                }
            }
        };
        this.f21684n = r10;
        AnonymousClass5 r11 = new com.facebook.ads.internal.view.f.b.o() {
            public void a(n nVar) {
                if (o.this.B != null && o.this.E != null && o.this.B.getDuration() - o.this.B.getCurrentPositionInMillis() <= 3000 && o.this.E.a()) {
                    o.this.E.b();
                }
            }
        };
        this.f21685o = r11;
        u uVar = new u();
        this.f21690t = uVar;
        this.f21696z = new AtomicBoolean(false);
        this.J = false;
        this.A = context2;
        this.C = aVar2;
        this.B = aVar;
        this.f21687q = cVar2;
        this.f21686p = kVar;
        this.f21695y = kVar.d().a();
        RelativeLayout relativeLayout = new RelativeLayout(context2);
        this.f21693w = relativeLayout;
        this.f21691u = new com.facebook.ads.internal.view.f.c.o(this.A);
        this.f21694x = new f(this.A);
        new com.facebook.ads.internal.view.b.d(relativeLayout, f21679i).a().a(com.facebook.ads.internal.l.a.e(this.A)).a(kVar.e().g());
        AnonymousClass6 r12 = new a.C0035a() {
            public void a() {
                if (!o.this.f21690t.b()) {
                    o.this.f21690t.a();
                    HashMap hashMap = new HashMap();
                    if (!TextUtils.isEmpty(o.this.f21686p.g())) {
                        o.this.f21688r.a((Map<String, String>) hashMap);
                        hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(o.this.f21690t.e()));
                        o.this.f21687q.a(o.this.f21686p.g(), hashMap);
                    }
                    if (o.this.C != null) {
                        o.this.C.a(z.REWARDED_VIDEO_IMPRESSION.a());
                    }
                }
            }
        };
        this.f21689s = r12;
        com.facebook.ads.internal.r.a aVar3 = new com.facebook.ads.internal.r.a(this, 1, r12);
        this.f21688r = aVar3;
        aVar3.a(250);
        this.f21692v = new com.facebook.ads.internal.view.f.b(this.A, cVar2, this.B, kVar.g());
        this.I = new b(this.A, cVar2, kVar, this.C, aVar3, uVar);
        if (f21671a || this.B != null) {
            this.B.setVideoProgressReportIntervalMs(kVar.h());
            x.a((View) this.B, -16777216);
            this.B.getEventBus().a((T[]) new com.facebook.ads.internal.j.f[]{r8, r9, r10, r11});
            return;
        }
        throw new AssertionError();
    }

    private void b() {
        com.facebook.ads.internal.view.f.a aVar;
        com.facebook.ads.internal.view.f.a.b bVar;
        com.facebook.ads.internal.view.f.a aVar2 = this.B;
        if (aVar2 != null) {
            aVar2.d();
            this.B.a((com.facebook.ads.internal.view.f.a.b) new com.facebook.ads.internal.view.f.c.k(this.A));
            this.B.a((com.facebook.ads.internal.view.f.a.b) this.f21694x);
            this.B.a((com.facebook.ads.internal.view.f.a.b) this.f21691u);
            l lVar = new l(this.A, true);
            this.F = lVar;
            d.a aVar3 = d.a.FADE_OUT_ON_PLAY;
            d dVar = new d(lVar, aVar3, true);
            this.B.a((com.facebook.ads.internal.view.f.a.b) this.F);
            this.B.a((com.facebook.ads.internal.view.f.a.b) dVar);
            Context context = this.A;
            int i2 = f21675e;
            com.facebook.ads.internal.adapters.a.d dVar2 = this.f21695y;
            com.facebook.ads.internal.m.c cVar = this.f21687q;
            a.C0037a aVar4 = this.C;
            b.a b2 = this.I.b();
            b.a aVar5 = b.a.INFO;
            com.facebook.ads.internal.view.e.a aVar6 = new com.facebook.ads.internal.view.e.a(context, i2, dVar2, cVar, aVar4, b2 == aVar5, this.I.b() == aVar5, this.f21688r, this.f21690t);
            this.D = aVar6;
            aVar6.setInfo(this.f21686p);
            d dVar3 = new d(this.D, aVar3, true);
            this.E = dVar3;
            this.B.a((com.facebook.ads.internal.view.f.a.b) dVar3);
            if (this.I.a() && this.f21686p.e().c() > 0) {
                j jVar = new j(this.A, this.f21686p.e().c(), -12286980);
                this.G = jVar;
                jVar.setButtonMode(j.a.SKIP_BUTTON_MODE);
                this.G.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (o.this.G != null && o.this.G.a() && o.this.G.getSkipSeconds() != 0 && o.this.B != null) {
                            o.this.B.e();
                        }
                    }
                });
                aVar = this.B;
                bVar = this.G;
            } else if (!this.I.a()) {
                f fVar = new f(this.A);
                this.H = fVar;
                fVar.a(this.f21686p.a(), this.f21686p.g(), this.f21686p.e().c());
                if (this.f21686p.e().c() <= 0) {
                    this.H.b();
                }
                if (this.I.b() != aVar5) {
                    this.H.c();
                }
                this.H.setToolbarListener(new f.a() {
                    public void a() {
                        if (!o.this.J && o.this.B != null) {
                            boolean unused = o.this.J = true;
                            o.this.B.e();
                        } else if (o.this.J && o.this.C != null) {
                            o.this.C.a(z.REWARDED_VIDEO_END_ACTIVITY.a());
                        }
                    }
                });
                aVar = this.B;
                bVar = this.H;
            } else {
                return;
            }
            aVar.a(bVar);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        RelativeLayout.LayoutParams layoutParams;
        this.J = true;
        e();
        d();
        com.facebook.ads.internal.view.f.a aVar = this.B;
        if (aVar != null) {
            aVar.d();
            this.B.setVisibility(4);
        }
        f fVar = this.H;
        if (fVar != null) {
            fVar.a(true);
            this.H.c();
        }
        x.a(this.B, this.G, this.f21694x, this.f21691u);
        Pair<b.a, View> c2 = this.I.c();
        int i2 = AnonymousClass9.f21705a[((b.a) c2.first).ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                com.facebook.ads.internal.view.e.a aVar2 = this.D;
                if (aVar2 != null) {
                    aVar2.setVisibility(0);
                    this.D.a();
                }
                layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                layoutParams.setMargins(0, f21677g, 0, 0);
                layoutParams.addRule(2, this.D.getId());
            } else if (i2 == 3) {
                x.a(this.D);
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(15);
                int i3 = f21674d;
                layoutParams.setMargins(i3, i3, i3, i3);
            } else {
                return;
            }
            this.f21693w.addView((View) c2.second, layoutParams);
            this.f21690t.a();
            return;
        }
        x.a(this.D);
        this.f21693w.addView((View) c2.second, f21680j);
    }

    private void d() {
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(200);
        autoTransition.setInterpolator(new AccelerateDecelerateInterpolator());
        TransitionManager.beginDelayedTransition(this.f21693w, autoTransition);
    }

    private void e() {
        if (this.A != null) {
            FrameLayout frameLayout = new FrameLayout(this.A);
            frameLayout.setLayoutParams(f21680j);
            x.a((View) frameLayout, -1509949440);
            this.f21693w.addView(frameLayout, 0);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        this.f21694x.setVisibility(this.f21696z.get() ? 0 : 8);
    }

    private void setUpContentLayoutForVideo(int i2) {
        this.f21693w.removeAllViews();
        this.f21693w.addView(this.B, f21680j);
        com.facebook.ads.internal.view.e.a aVar = this.D;
        if (aVar != null) {
            x.a((View) aVar);
            this.D.a(i2);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            com.facebook.ads.internal.view.e.a aVar2 = this.D;
            int i3 = f21674d;
            aVar2.setPadding(i3, i3, i3, i3);
            this.f21693w.addView(this.D, layoutParams);
        }
        if (this.G != null) {
            int i4 = f21676f;
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i4, i4);
            layoutParams2.addRule(10);
            layoutParams2.addRule(11);
            j jVar = this.G;
            int i5 = f21674d;
            jVar.setPadding(i5, i5, i5, i5);
            this.f21693w.addView(this.G, layoutParams2);
        }
        int i6 = f21678h;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i6, i6);
        layoutParams3.addRule(10);
        layoutParams3.addRule(11);
        int i7 = f21672b;
        layoutParams3.setMargins(i7, f21677g + i7, i7, f21673c);
        this.f21693w.addView(this.f21694x, layoutParams3);
        f();
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(12);
        this.f21693w.addView(this.f21691u, layoutParams4);
    }

    public void a() {
        com.facebook.ads.internal.view.f.a aVar = this.B;
        if (aVar != null) {
            aVar.f();
            this.B.k();
        }
        com.facebook.ads.internal.r.a aVar2 = this.f21688r;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void a(Intent intent, Bundle bundle, AudienceNetworkActivity audienceNetworkActivity) {
        if (this.B != null && this.C != null) {
            b();
            audienceNetworkActivity.addBackButtonInterceptor(this.f21681k);
            this.B.setVideoURI(!TextUtils.isEmpty(this.f21686p.e().b()) ? this.f21686p.e().b() : this.f21686p.e().a());
            setUpContentLayoutForVideo(audienceNetworkActivity.getResources().getConfiguration().orientation);
            RelativeLayout relativeLayout = this.f21693w;
            RelativeLayout.LayoutParams layoutParams = f21680j;
            addView(relativeLayout, layoutParams);
            f fVar = this.H;
            if (fVar != null) {
                x.a((View) fVar);
                this.H.a(this.f21695y, true);
                addView(this.H, new RelativeLayout.LayoutParams(-1, f21677g));
            }
            setLayoutParams(layoutParams);
            this.C.a((View) this);
        }
    }

    public void a(Bundle bundle) {
    }

    public int getCurrentPosition() {
        com.facebook.ads.internal.view.f.a aVar = this.B;
        if (aVar != null) {
            return aVar.getCurrentPositionInMillis();
        }
        return 0;
    }

    public void i() {
        com.facebook.ads.internal.view.f.a aVar = this.B;
        if (aVar != null) {
            aVar.a(false);
        }
    }

    public void j() {
        com.facebook.ads.internal.view.f.a aVar = this.B;
        if (aVar != null && this.C != null && aVar.l() && !this.B.m()) {
            this.B.a(com.facebook.ads.internal.view.f.a.a.USER_STARTED);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        com.facebook.ads.internal.view.e.a aVar = this.D;
        if (aVar != null) {
            aVar.a(configuration.orientation);
        }
    }

    public void onDestroy() {
        a();
        com.facebook.ads.internal.view.f.a aVar = this.B;
        if (aVar != null) {
            aVar.getEventBus().b((T[]) new com.facebook.ads.internal.j.f[]{this.f21682l, this.f21683m, this.f21684n, this.f21685o});
        }
        if (!TextUtils.isEmpty(this.f21686p.g())) {
            HashMap hashMap = new HashMap();
            this.f21688r.a((Map<String, String>) hashMap);
            hashMap.put(PointerEventHelper.POINTER_TYPE_TOUCH, com.facebook.ads.internal.q.a.k.a(this.f21690t.e()));
            this.f21687q.i(this.f21686p.g(), hashMap);
        }
        f fVar = this.H;
        if (fVar != null) {
            fVar.setToolbarListener((f.a) null);
        }
        this.f21692v.a();
        this.B = null;
        this.I.e();
        this.G = null;
        this.D = null;
        this.E = null;
        this.C = null;
        this.A = null;
        this.f21691u.a();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f21690t.a(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setEndCardController(b bVar) {
        this.I = bVar;
    }

    public void setListener(a.C0037a aVar) {
    }
}
