package com.facebook.ads.internal.view.f.c;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.j.f;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.f.a;
import com.facebook.ads.internal.view.f.a.b;
import com.facebook.ads.internal.view.f.b.c;
import com.facebook.ads.internal.view.f.b.h;
import com.facebook.ads.internal.view.f.b.i;
import com.facebook.ads.internal.view.f.b.j;
import com.facebook.ads.internal.view.f.b.k;
import com.facebook.ads.internal.view.f.b.n;
import java.util.concurrent.atomic.AtomicInteger;

public class o extends RelativeLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21473a = ((int) (x.f20694b * 6.0f));

    /* renamed from: b  reason: collision with root package name */
    private ObjectAnimator f21474b;

    /* renamed from: c  reason: collision with root package name */
    private AtomicInteger f21475c;

    /* renamed from: d  reason: collision with root package name */
    private ProgressBar f21476d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public a f21477e;

    /* renamed from: f  reason: collision with root package name */
    private f f21478f;

    /* renamed from: g  reason: collision with root package name */
    private f f21479g;

    /* renamed from: h  reason: collision with root package name */
    private f f21480h;

    /* renamed from: i  reason: collision with root package name */
    private f f21481i;

    public o(Context context) {
        this(context, f21473a, -12549889);
    }

    public o(Context context, int i2, int i3) {
        super(context);
        this.f21478f = new com.facebook.ads.internal.view.f.b.o() {
            public void a(n nVar) {
                if (o.this.f21477e != null) {
                    o oVar = o.this;
                    oVar.a(oVar.f21477e.getDuration(), o.this.f21477e.getCurrentPositionInMillis());
                }
            }
        };
        this.f21479g = new i() {
            public void a(h hVar) {
                o.this.b();
            }
        };
        this.f21480h = new k() {
            public void a(j jVar) {
                if (o.this.f21477e != null) {
                    o oVar = o.this;
                    oVar.a(oVar.f21477e.getDuration(), o.this.f21477e.getCurrentPositionInMillis());
                }
            }
        };
        this.f21481i = new c() {
            public void a(com.facebook.ads.internal.view.f.b.b bVar) {
                if (o.this.f21477e != null) {
                    o.this.c();
                }
            }
        };
        this.f21475c = new AtomicInteger(-1);
        this.f21476d = new ProgressBar(context, (AttributeSet) null, 16842872);
        this.f21476d.setLayoutParams(new RelativeLayout.LayoutParams(-1, i2));
        setProgressBarColor(i3);
        this.f21476d.setMax(10000);
        addView(this.f21476d);
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3) {
        b();
        if (this.f21475c.get() < i3 && i2 > i3) {
            ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f21476d, "progress", new int[]{(i3 * 10000) / i2, (Math.min(i3 + 250, i2) * 10000) / i2});
            this.f21474b = ofInt;
            ofInt.setDuration((long) Math.min(250, i2 - i3));
            this.f21474b.setInterpolator(new LinearInterpolator());
            this.f21474b.start();
            this.f21475c.set(i3);
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        ObjectAnimator objectAnimator = this.f21474b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f21474b.setTarget((Object) null);
            this.f21474b = null;
            this.f21476d.clearAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        b();
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this.f21476d, "progress", new int[]{0, 0});
        this.f21474b = ofInt;
        ofInt.setDuration(0);
        this.f21474b.setInterpolator(new LinearInterpolator());
        this.f21474b.start();
        this.f21475c.set(0);
    }

    public void a() {
        b();
        this.f21476d = null;
        this.f21477e = null;
    }

    public void a(a aVar) {
        this.f21477e = aVar;
        aVar.getEventBus().a((T[]) new f[]{this.f21479g, this.f21480h, this.f21478f, this.f21481i});
    }

    public void b(a aVar) {
        aVar.getEventBus().b((T[]) new f[]{this.f21478f, this.f21480h, this.f21479g, this.f21481i});
        this.f21477e = null;
    }

    public void setProgressBarColor(int i2) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(0), new ColorDrawable(0), new ScaleDrawable(new ColorDrawable(i2), 8388611, 1.0f, -1.0f)});
        layerDrawable.setId(0, 16908288);
        layerDrawable.setId(1, 16908303);
        layerDrawable.setId(2, 16908301);
        this.f21476d.setProgressDrawable(layerDrawable);
    }
}
