package com.facebook.ads.internal.view.f.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.t;
import com.facebook.ads.internal.view.f.b.u;

@TargetApi(12)
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    private final i f21367a;

    /* renamed from: b  reason: collision with root package name */
    private final k f21368b;

    /* renamed from: c  reason: collision with root package name */
    private final c f21369c;

    /* renamed from: d  reason: collision with root package name */
    private final u f21370d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final Handler f21371e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final boolean f21372f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final boolean f21373g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public View f21374h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f21375i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public com.facebook.ads.internal.view.f.a f21376j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f21377k;

    public enum a {
        VISIBLE,
        INVSIBLE,
        FADE_OUT_ON_PLAY
    }

    public d(View view, a aVar) {
        this(view, aVar, false);
    }

    public d(View view, a aVar, boolean z2) {
        this(view, aVar, z2, false);
    }

    public d(View view, a aVar, boolean z2, boolean z3) {
        this.f21367a = new i() {
            public void a(h hVar) {
                d.this.a(1, 0);
            }
        };
        this.f21368b = new k() {
            public void a(j jVar) {
                if (d.this.f21377k) {
                    if (d.this.f21375i == a.FADE_OUT_ON_PLAY || d.this.f21372f) {
                        a unused = d.this.f21375i = null;
                        d.this.c();
                        return;
                    }
                    d.this.a(0, 8);
                }
            }
        };
        this.f21369c = new c() {
            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                if (d.this.f21375i != a.INVSIBLE) {
                    d.this.f21374h.setAlpha(1.0f);
                    d.this.f21374h.setVisibility(0);
                }
            }
        };
        this.f21370d = new u() {
            public void a(t tVar) {
                if (d.this.f21376j != null && tVar.a().getAction() == 0) {
                    d.this.f21371e.removeCallbacksAndMessages((Object) null);
                    d.this.a((AnimatorListenerAdapter) new AnimatorListenerAdapter() {
                        public void onAnimationEnd(Animator animator) {
                            d.this.f21371e.postDelayed(new Runnable() {
                                public void run() {
                                    if (!d.this.f21373g && d.this.f21377k) {
                                        d.this.c();
                                    }
                                }
                            }, 2000);
                        }
                    });
                }
            }
        };
        this.f21377k = true;
        this.f21371e = new Handler();
        this.f21372f = z2;
        this.f21373g = z3;
        a(view, aVar);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        this.f21371e.removeCallbacksAndMessages((Object) null);
        this.f21374h.clearAnimation();
        this.f21374h.setAlpha((float) i2);
        this.f21374h.setVisibility(i3);
    }

    /* access modifiers changed from: private */
    public void a(AnimatorListenerAdapter animatorListenerAdapter) {
        this.f21374h.setVisibility(0);
        this.f21374h.animate().alpha(1.0f).setDuration(500).setListener(animatorListenerAdapter);
    }

    /* access modifiers changed from: private */
    public void c() {
        this.f21374h.animate().alpha(0.0f).setDuration(500).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                d.this.f21374h.setVisibility(8);
            }
        });
    }

    public void a(View view, a aVar) {
        int i2;
        View view2;
        this.f21375i = aVar;
        this.f21374h = view;
        view.clearAnimation();
        if (aVar == a.INVSIBLE) {
            this.f21374h.setAlpha(0.0f);
            view2 = this.f21374h;
            i2 = 8;
        } else {
            this.f21374h.setAlpha(1.0f);
            view2 = this.f21374h;
            i2 = 0;
        }
        view2.setVisibility(i2);
    }

    public void a(com.facebook.ads.internal.view.f.a aVar) {
        this.f21376j = aVar;
        aVar.getEventBus().a((T[]) new f[]{this.f21367a, this.f21368b, this.f21370d, this.f21369c});
    }

    public boolean a() {
        return this.f21377k;
    }

    public void b() {
        this.f21377k = false;
        a((AnimatorListenerAdapter) null);
    }

    public void b(com.facebook.ads.internal.view.f.a aVar) {
        a(1, 0);
        aVar.getEventBus().b((T[]) new f[]{this.f21369c, this.f21370d, this.f21368b, this.f21367a});
        this.f21376j = null;
    }
}
