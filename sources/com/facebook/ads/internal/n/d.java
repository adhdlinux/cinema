package com.facebook.ads.internal.n;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.r.a;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.b.e;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.c.g;
import com.facebook.ads.internal.view.f.c.h;
import com.facebook.ads.internal.view.f.d;
import com.facebook.ads.internal.view.j;
import java.util.concurrent.atomic.AtomicBoolean;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20318a = "d";

    /* renamed from: b  reason: collision with root package name */
    private final g f20319b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.ads.internal.r.a f20320c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0035a f20321d;

    /* renamed from: e  reason: collision with root package name */
    private final View f20322e;

    /* renamed from: f  reason: collision with root package name */
    private final d.a f20323f = new d.a() {
        public void a() {
            d.this.f20331n.set(true);
            if (d.this.f20325h != null) {
                d.this.f20325h.a(d.this.f20330m.get());
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public j f20324g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public a f20325h;

    /* renamed from: i  reason: collision with root package name */
    private Context f20326i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f20327j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f20328k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f20329l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final AtomicBoolean f20330m = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final AtomicBoolean f20331n = new AtomicBoolean(false);

    /* renamed from: o  reason: collision with root package name */
    private m f20332o = m.DEFAULT;

    public interface a {
        void a(boolean z2);
    }

    public d(Context context, View view) {
        this.f20326i = context;
        this.f20322e = view;
        this.f20319b = new g(context);
        this.f20321d = k();
        this.f20320c = j();
        g();
    }

    /* access modifiers changed from: private */
    public void a(com.facebook.ads.internal.view.f.a.a aVar) {
        j jVar = this.f20324g;
        if (jVar != null) {
            jVar.a(aVar);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(f20318a, "MediaViewVideo is null; unable to find it.");
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        j jVar = this.f20324g;
        if (jVar != null) {
            jVar.a(z2);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(f20318a, "MediaViewVideo is null; unable to find it.");
        }
    }

    private void g() {
        float f2 = x.f20694b;
        int i2 = (int) (2.0f * f2);
        int i3 = (int) (f2 * 25.0f);
        h hVar = new h(this.f20326i);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        hVar.setPadding(i2, i3, i3, i2);
        hVar.setLayoutParams(layoutParams);
        int i4 = 0;
        while (true) {
            if (i4 >= ((ViewGroup) this.f20322e).getChildCount()) {
                break;
            }
            View childAt = ((ViewGroup) this.f20322e).getChildAt(0);
            if (childAt instanceof j) {
                this.f20324g = (j) childAt;
                break;
            }
            i4++;
        }
        j jVar = this.f20324g;
        if (jVar != null) {
            jVar.a((b) this.f20319b);
            this.f20324g.a((b) hVar);
        } else if (AdInternalSettings.isDebugBuild()) {
            Log.e(f20318a, "Unable to find MediaViewVideo child.");
        }
        this.f20320c.a(0);
        this.f20320c.b(250);
    }

    private void h() {
        j jVar = this.f20324g;
        if (jVar != null) {
            ((com.facebook.ads.internal.view.f.d) jVar.getVideoView()).setViewImplInflationListener(this.f20323f);
        }
    }

    private void i() {
        j jVar = this.f20324g;
        if (jVar != null) {
            ((com.facebook.ads.internal.view.f.d) jVar.getVideoView()).setViewImplInflationListener((d.a) null);
        }
    }

    private com.facebook.ads.internal.r.a j() {
        return new com.facebook.ads.internal.r.a(this.f20322e, 50, true, this.f20321d);
    }

    private a.C0035a k() {
        return new a.C0035a() {
            public void a() {
                if (d.this.f20324g != null) {
                    if (!d.this.f20329l && (d.this.f20328k || d.this.m())) {
                        d.this.a(com.facebook.ads.internal.view.f.a.a.AUTO_STARTED);
                    }
                    boolean unused = d.this.f20328k = false;
                    boolean unused2 = d.this.f20329l = false;
                }
            }

            public void b() {
                if (d.this.f20324g != null) {
                    if (d.this.f20324g.getState() == com.facebook.ads.internal.view.f.d.d.PAUSED) {
                        boolean unused = d.this.f20329l = true;
                    } else if (d.this.f20324g.getState() == com.facebook.ads.internal.view.f.d.d.STARTED) {
                        boolean unused2 = d.this.f20328k = true;
                    }
                    d dVar = d.this;
                    dVar.a(dVar.f20329l);
                }
            }
        };
    }

    private void l() {
        if (this.f20322e.getVisibility() != 0 || !this.f20327j || !this.f20322e.hasWindowFocus()) {
            j jVar = this.f20324g;
            if (jVar != null && jVar.getState() == com.facebook.ads.internal.view.f.d.d.PAUSED) {
                this.f20329l = true;
            }
            this.f20320c.c();
            return;
        }
        this.f20320c.a();
    }

    /* access modifiers changed from: private */
    public boolean m() {
        j jVar = this.f20324g;
        return (jVar == null || jVar.getState() == com.facebook.ads.internal.view.f.d.d.PLAYBACK_COMPLETED || this.f20332o != m.ON) ? false : true;
    }

    public void a() {
        this.f20332o = m.DEFAULT;
        i();
    }

    public void a(f fVar, a aVar) {
        this.f20328k = false;
        this.f20329l = false;
        this.f20325h = aVar;
        h();
        this.f20319b.a((fVar == null || fVar.k() == null) ? null : fVar.k().a(), new e() {
            public void a(boolean z2) {
                d.this.f20330m.set(z2);
                if (d.this.f20331n.get() && d.this.f20325h != null) {
                    d.this.f20325h.a(z2);
                }
            }
        });
        this.f20332o = fVar.E();
        this.f20320c.a();
    }

    public void b() {
        j jVar = this.f20324g;
        if (jVar != null) {
            jVar.getVideoView().setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (d.this.f20324g != null && motionEvent.getAction() == 1) {
                        d.this.f20324g.a();
                    }
                    return true;
                }
            });
        }
    }

    public void c() {
        this.f20327j = true;
        l();
    }

    public void d() {
        this.f20327j = false;
        l();
    }

    public void e() {
        l();
    }

    public void f() {
        l();
    }
}
