package com.facebook.ads.internal.view.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.d;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.l;
import com.facebook.ads.internal.view.f.b.n;
import com.facebook.ads.internal.view.f.b.p;
import com.facebook.ads.internal.view.f.b.r;
import com.facebook.ads.internal.view.f.b.s;
import com.facebook.ads.internal.view.f.b.t;
import com.facebook.ads.internal.view.f.b.v;
import com.facebook.ads.internal.view.f.b.x;
import com.facebook.ads.internal.view.f.b.y;
import com.facebook.ads.internal.view.f.c;
import com.facebook.ads.internal.view.f.c.g;
import com.facebook.ads.internal.view.f.d.e;
import java.util.ArrayList;
import java.util.List;

public class a extends RelativeLayout implements c.a, e {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final l f21227b = new l();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final d f21228c = new d();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final r f21229d = new r();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final h f21230e = new h();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final s f21231f = new s();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final j f21232g = new j();

    /* renamed from: h  reason: collision with root package name */
    private static final v f21233h = new v();

    /* renamed from: i  reason: collision with root package name */
    private static final y f21234i = new y();

    /* renamed from: j  reason: collision with root package name */
    private static final x f21235j = new x();

    /* renamed from: a  reason: collision with root package name */
    protected final com.facebook.ads.internal.view.f.d.c f21236a;

    /* renamed from: k  reason: collision with root package name */
    private d f21237k;

    /* renamed from: l  reason: collision with root package name */
    private final List<b> f21238l = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final Handler f21239m = new Handler();

    /* renamed from: n  reason: collision with root package name */
    private final Handler f21240n = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public final com.facebook.ads.internal.j.e<f, com.facebook.ads.internal.j.d> f21241o = new com.facebook.ads.internal.j.e<>();
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f21242p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f21243q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f21244r = false;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f21245s = 200;

    /* renamed from: t  reason: collision with root package name */
    private final View.OnTouchListener f21246t = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            a.this.f21241o.a(new t(view, motionEvent));
            return false;
        }
    };

    public a(Context context) {
        super(context);
        this.f21236a = com.facebook.ads.internal.l.a.a(context) ? new com.facebook.ads.internal.view.f.d.a(context) : new com.facebook.ads.internal.view.f.d.b(context);
        a();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21236a = com.facebook.ads.internal.l.a.a(context) ? new com.facebook.ads.internal.view.f.d.a(context, attributeSet) : new com.facebook.ads.internal.view.f.d.b(context, attributeSet);
        a();
    }

    public a(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21236a = com.facebook.ads.internal.l.a.a(context) ? new com.facebook.ads.internal.view.f.d.a(context, attributeSet, i2) : new com.facebook.ads.internal.view.f.d.b(context, attributeSet, i2);
        a();
    }

    @TargetApi(21)
    public a(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f21236a = com.facebook.ads.internal.l.a.a(context) ? new com.facebook.ads.internal.view.f.d.a(context, attributeSet, i2, i3) : new com.facebook.ads.internal.view.f.d.b(context, attributeSet, i2, i3);
        a();
    }

    private void a() {
        if (g()) {
            com.facebook.ads.internal.view.f.d.c cVar = this.f21236a;
            if (cVar instanceof com.facebook.ads.internal.view.f.d.a) {
                ((com.facebook.ads.internal.view.f.d.a) cVar).setTestMode(AdInternalSettings.isTestMode(getContext()));
            }
        }
        this.f21236a.setRequestedVolume(1.0f);
        this.f21236a.setVideoStateChangeListener(this);
        this.f21237k = new d(getContext(), this.f21236a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        addView(this.f21237k, layoutParams);
        setOnTouchListener(this.f21246t);
    }

    private void a(com.facebook.ads.internal.view.f.a.c cVar) {
        if (cVar.getParent() != null) {
            return;
        }
        if (cVar instanceof g) {
            this.f21237k.a(cVar);
        } else {
            addView(cVar);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        this.f21239m.postDelayed(new Runnable() {
            public void run() {
                if (!a.this.f21242p) {
                    a.this.f21241o.a(new n(a.this.getCurrentPositionInMillis()));
                    a.this.f21239m.postDelayed(this, (long) a.this.f21245s);
                }
            }
        }, (long) this.f21245s);
    }

    private void b(com.facebook.ads.internal.view.f.a.c cVar) {
        if (cVar instanceof g) {
            this.f21237k.b(cVar);
        } else {
            com.facebook.ads.internal.q.a.x.b(cVar);
        }
    }

    public void a(int i2) {
        this.f21239m.removeCallbacksAndMessages((Object) null);
        this.f21236a.a(i2);
    }

    public void a(final int i2, final int i3) {
        this.f21240n.post(new Runnable() {
            public void run() {
                a.this.f21241o.a(new p(i2, i3));
            }
        });
        b();
    }

    public void a(com.facebook.ads.internal.view.f.a.a aVar) {
        if (this.f21242p && this.f21236a.getState() == com.facebook.ads.internal.view.f.d.d.PLAYBACK_COMPLETED) {
            this.f21242p = false;
        }
        this.f21236a.a(aVar);
    }

    public void a(b bVar) {
        this.f21238l.add(bVar);
    }

    public void a(final com.facebook.ads.internal.view.f.d.d dVar) {
        final int currentPositionInMillis = getCurrentPositionInMillis();
        final int duration = getDuration();
        this.f21240n.post(new Runnable() {
            public void run() {
                com.facebook.ads.internal.j.e b2;
                com.facebook.ads.internal.j.d r2;
                com.facebook.ads.internal.j.e b3;
                com.facebook.ads.internal.j.d bVar;
                com.facebook.ads.internal.view.f.d.d dVar = dVar;
                if (dVar == com.facebook.ads.internal.view.f.d.d.PREPARED) {
                    b3 = a.this.f21241o;
                    bVar = a.f21227b;
                } else if (dVar == com.facebook.ads.internal.view.f.d.d.ERROR) {
                    boolean unused = a.this.f21242p = true;
                    b3 = a.this.f21241o;
                    bVar = a.f21228c;
                } else if (dVar == com.facebook.ads.internal.view.f.d.d.PLAYBACK_COMPLETED) {
                    boolean unused2 = a.this.f21242p = true;
                    a.this.f21239m.removeCallbacksAndMessages((Object) null);
                    b3 = a.this.f21241o;
                    bVar = new com.facebook.ads.internal.view.f.b.b(currentPositionInMillis, duration);
                } else if (dVar == com.facebook.ads.internal.view.f.d.d.STARTED) {
                    a.this.f21241o.a(a.f21232g);
                    a.this.f21239m.removeCallbacksAndMessages((Object) null);
                    a.this.b();
                    return;
                } else {
                    if (dVar == com.facebook.ads.internal.view.f.d.d.PAUSED) {
                        b2 = a.this.f21241o;
                        r2 = a.f21230e;
                    } else if (dVar == com.facebook.ads.internal.view.f.d.d.IDLE) {
                        b2 = a.this.f21241o;
                        r2 = a.f21231f;
                    } else {
                        return;
                    }
                    b2.a(r2);
                    a.this.f21239m.removeCallbacksAndMessages((Object) null);
                    return;
                }
                b3.a(bVar);
            }
        });
    }

    public void a(boolean z2) {
        if (!l()) {
            this.f21236a.a(z2);
            this.f21244r = z2;
        }
    }

    public void c() {
        for (b next : this.f21238l) {
            if (next instanceof com.facebook.ads.internal.view.f.a.c) {
                a((com.facebook.ads.internal.view.f.a.c) next);
            }
            next.a(this);
        }
    }

    public void d() {
        for (b next : this.f21238l) {
            if (next instanceof com.facebook.ads.internal.view.f.a.c) {
                b((com.facebook.ads.internal.view.f.a.c) next);
            }
            next.b(this);
        }
    }

    public void e() {
        this.f21240n.post(new Runnable() {
            public void run() {
                a.this.getEventBus().a(a.f21229d);
            }
        });
        this.f21236a.b();
    }

    public void f() {
        this.f21236a.c();
    }

    public boolean g() {
        return com.facebook.ads.internal.l.a.a(getContext());
    }

    public int getCurrentPositionInMillis() {
        return this.f21236a.getCurrentPosition();
    }

    public int getDuration() {
        return this.f21236a.getDuration();
    }

    public com.facebook.ads.internal.j.e<f, com.facebook.ads.internal.j.d> getEventBus() {
        return this.f21241o;
    }

    public long getInitialBufferTime() {
        return this.f21236a.getInitialBufferTime();
    }

    public com.facebook.ads.internal.view.f.d.d getState() {
        return this.f21236a.getState();
    }

    /* access modifiers changed from: protected */
    public Handler getStateHandler() {
        return this.f21240n;
    }

    public TextureView getTextureView() {
        return (TextureView) this.f21236a;
    }

    public int getVideoHeight() {
        return this.f21236a.getVideoHeight();
    }

    public int getVideoProgressReportIntervalMs() {
        return this.f21245s;
    }

    public com.facebook.ads.internal.view.f.a.a getVideoStartReason() {
        return this.f21236a.getStartReason();
    }

    public View getVideoView() {
        return this.f21237k;
    }

    public int getVideoWidth() {
        return this.f21236a.getVideoWidth();
    }

    public float getVolume() {
        return this.f21236a.getVolume();
    }

    public boolean h() {
        return this.f21243q;
    }

    public boolean i() {
        return getState() == com.facebook.ads.internal.view.f.d.d.STARTED;
    }

    public boolean j() {
        return this.f21236a.d();
    }

    public void k() {
        this.f21236a.setVideoStateChangeListener((e) null);
        this.f21236a.e();
    }

    public boolean l() {
        return getState() == com.facebook.ads.internal.view.f.d.d.PAUSED;
    }

    public boolean m() {
        return l() && this.f21244r;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        this.f21241o.a(f21235j);
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f21241o.a(f21234i);
        super.onDetachedFromWindow();
    }

    public void setControlsAnchorView(View view) {
        com.facebook.ads.internal.view.f.d.c cVar = this.f21236a;
        if (cVar != null) {
            cVar.setControlsAnchorView(view);
        }
    }

    public void setIsFullScreen(boolean z2) {
        this.f21243q = z2;
        this.f21236a.setFullScreen(z2);
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
    }

    public void setVideoMPD(String str) {
        this.f21236a.setVideoMPD(str);
    }

    public void setVideoProgressReportIntervalMs(int i2) {
        this.f21245s = i2;
    }

    public void setVideoURI(Uri uri) {
        if (uri == null) {
            d();
        } else {
            c();
            this.f21236a.setup(uri);
        }
        this.f21242p = false;
    }

    public void setVideoURI(String str) {
        setVideoURI(str != null ? Uri.parse(str) : null);
    }

    public void setVolume(float f2) {
        this.f21236a.setRequestedVolume(f2);
        getEventBus().a(f21233h);
    }
}
