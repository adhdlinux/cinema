package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.facebook.imageutils.JfifUtil;

public class CircularProgressDrawable extends Drawable implements Animatable {

    /* renamed from: h  reason: collision with root package name */
    private static final Interpolator f11646h = new LinearInterpolator();

    /* renamed from: i  reason: collision with root package name */
    private static final Interpolator f11647i = new FastOutSlowInInterpolator();

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f11648j = {-16777216};

    /* renamed from: b  reason: collision with root package name */
    private final Ring f11649b;

    /* renamed from: c  reason: collision with root package name */
    private float f11650c;

    /* renamed from: d  reason: collision with root package name */
    private Resources f11651d;

    /* renamed from: e  reason: collision with root package name */
    private Animator f11652e;

    /* renamed from: f  reason: collision with root package name */
    float f11653f;

    /* renamed from: g  reason: collision with root package name */
    boolean f11654g;

    private static class Ring {

        /* renamed from: a  reason: collision with root package name */
        final RectF f11659a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        final Paint f11660b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f11661c;

        /* renamed from: d  reason: collision with root package name */
        final Paint f11662d;

        /* renamed from: e  reason: collision with root package name */
        float f11663e;

        /* renamed from: f  reason: collision with root package name */
        float f11664f;

        /* renamed from: g  reason: collision with root package name */
        float f11665g;

        /* renamed from: h  reason: collision with root package name */
        float f11666h;

        /* renamed from: i  reason: collision with root package name */
        int[] f11667i;

        /* renamed from: j  reason: collision with root package name */
        int f11668j;

        /* renamed from: k  reason: collision with root package name */
        float f11669k;

        /* renamed from: l  reason: collision with root package name */
        float f11670l;

        /* renamed from: m  reason: collision with root package name */
        float f11671m;

        /* renamed from: n  reason: collision with root package name */
        boolean f11672n;

        /* renamed from: o  reason: collision with root package name */
        Path f11673o;

        /* renamed from: p  reason: collision with root package name */
        float f11674p;

        /* renamed from: q  reason: collision with root package name */
        float f11675q;

        /* renamed from: r  reason: collision with root package name */
        int f11676r;

        /* renamed from: s  reason: collision with root package name */
        int f11677s;

        /* renamed from: t  reason: collision with root package name */
        int f11678t;

        /* renamed from: u  reason: collision with root package name */
        int f11679u;

        Ring() {
            Paint paint = new Paint();
            this.f11660b = paint;
            Paint paint2 = new Paint();
            this.f11661c = paint2;
            Paint paint3 = new Paint();
            this.f11662d = paint3;
            this.f11663e = 0.0f;
            this.f11664f = 0.0f;
            this.f11665g = 0.0f;
            this.f11666h = 5.0f;
            this.f11674p = 1.0f;
            this.f11678t = JfifUtil.MARKER_FIRST_BYTE;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* access modifiers changed from: package-private */
        public void A() {
            this.f11669k = this.f11663e;
            this.f11670l = this.f11664f;
            this.f11671m = this.f11665g;
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f11659a;
            float f2 = this.f11675q;
            float f3 = (this.f11666h / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (((float) Math.min(rect.width(), rect.height())) / 2.0f) - Math.max((((float) this.f11676r) * this.f11674p) / 2.0f, this.f11666h / 2.0f);
            }
            rectF.set(((float) rect.centerX()) - f3, ((float) rect.centerY()) - f3, ((float) rect.centerX()) + f3, ((float) rect.centerY()) + f3);
            float f4 = this.f11663e;
            float f5 = this.f11665g;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.f11664f + f5) * 360.0f) - f6;
            this.f11660b.setColor(this.f11679u);
            this.f11660b.setAlpha(this.f11678t);
            float f8 = this.f11666h / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f11662d);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.f11660b);
            b(canvas, f6, f7, rectF);
        }

        /* access modifiers changed from: package-private */
        public void b(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.f11672n) {
                Path path = this.f11673o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f11673o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.f11673o.moveTo(0.0f, 0.0f);
                this.f11673o.lineTo(((float) this.f11676r) * this.f11674p, 0.0f);
                Path path3 = this.f11673o;
                float f4 = this.f11674p;
                path3.lineTo((((float) this.f11676r) * f4) / 2.0f, ((float) this.f11677s) * f4);
                this.f11673o.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((((float) this.f11676r) * this.f11674p) / 2.0f), rectF.centerY() + (this.f11666h / 2.0f));
                this.f11673o.close();
                this.f11661c.setColor(this.f11679u);
                this.f11661c.setAlpha(this.f11678t);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f11673o, this.f11661c);
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public int c() {
            return this.f11678t;
        }

        /* access modifiers changed from: package-private */
        public float d() {
            return this.f11664f;
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f11667i[f()];
        }

        /* access modifiers changed from: package-private */
        public int f() {
            return (this.f11668j + 1) % this.f11667i.length;
        }

        /* access modifiers changed from: package-private */
        public float g() {
            return this.f11663e;
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return this.f11667i[this.f11668j];
        }

        /* access modifiers changed from: package-private */
        public float i() {
            return this.f11670l;
        }

        /* access modifiers changed from: package-private */
        public float j() {
            return this.f11671m;
        }

        /* access modifiers changed from: package-private */
        public float k() {
            return this.f11669k;
        }

        /* access modifiers changed from: package-private */
        public void l() {
            t(f());
        }

        /* access modifiers changed from: package-private */
        public void m() {
            this.f11669k = 0.0f;
            this.f11670l = 0.0f;
            this.f11671m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        /* access modifiers changed from: package-private */
        public void n(int i2) {
            this.f11678t = i2;
        }

        /* access modifiers changed from: package-private */
        public void o(float f2, float f3) {
            this.f11676r = (int) f2;
            this.f11677s = (int) f3;
        }

        /* access modifiers changed from: package-private */
        public void p(float f2) {
            if (f2 != this.f11674p) {
                this.f11674p = f2;
            }
        }

        /* access modifiers changed from: package-private */
        public void q(float f2) {
            this.f11675q = f2;
        }

        /* access modifiers changed from: package-private */
        public void r(int i2) {
            this.f11679u = i2;
        }

        /* access modifiers changed from: package-private */
        public void s(ColorFilter colorFilter) {
            this.f11660b.setColorFilter(colorFilter);
        }

        /* access modifiers changed from: package-private */
        public void t(int i2) {
            this.f11668j = i2;
            this.f11679u = this.f11667i[i2];
        }

        /* access modifiers changed from: package-private */
        public void u(int[] iArr) {
            this.f11667i = iArr;
            t(0);
        }

        /* access modifiers changed from: package-private */
        public void v(float f2) {
            this.f11664f = f2;
        }

        /* access modifiers changed from: package-private */
        public void w(float f2) {
            this.f11665g = f2;
        }

        /* access modifiers changed from: package-private */
        public void x(boolean z2) {
            if (this.f11672n != z2) {
                this.f11672n = z2;
            }
        }

        /* access modifiers changed from: package-private */
        public void y(float f2) {
            this.f11663e = f2;
        }

        /* access modifiers changed from: package-private */
        public void z(float f2) {
            this.f11666h = f2;
            this.f11660b.setStrokeWidth(f2);
        }
    }

    public CircularProgressDrawable(Context context) {
        this.f11651d = ((Context) Preconditions.g(context)).getResources();
        Ring ring = new Ring();
        this.f11649b = ring;
        ring.u(f11648j);
        k(2.5f);
        m();
    }

    private void a(float f2, Ring ring) {
        n(f2, ring);
        ring.y(ring.k() + (((ring.i() - 0.01f) - ring.k()) * f2));
        ring.v(ring.i());
        ring.w(ring.j() + ((((float) (Math.floor((double) (ring.j() / 0.8f)) + 1.0d)) - ring.j()) * f2));
    }

    private int c(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & JfifUtil.MARKER_FIRST_BYTE;
        int i5 = (i2 >> 16) & JfifUtil.MARKER_FIRST_BYTE;
        int i6 = (i2 >> 8) & JfifUtil.MARKER_FIRST_BYTE;
        int i7 = i2 & JfifUtil.MARKER_FIRST_BYTE;
        return ((i4 + ((int) (((float) (((i3 >> 24) & JfifUtil.MARKER_FIRST_BYTE) - i4)) * f2))) << 24) | ((i5 + ((int) (((float) (((i3 >> 16) & JfifUtil.MARKER_FIRST_BYTE) - i5)) * f2))) << 16) | ((i6 + ((int) (((float) (((i3 >> 8) & JfifUtil.MARKER_FIRST_BYTE) - i6)) * f2))) << 8) | (i7 + ((int) (f2 * ((float) ((i3 & JfifUtil.MARKER_FIRST_BYTE) - i7)))));
    }

    private void h(float f2) {
        this.f11650c = f2;
    }

    private void i(float f2, float f3, float f4, float f5) {
        Ring ring = this.f11649b;
        float f6 = this.f11651d.getDisplayMetrics().density;
        ring.z(f3 * f6);
        ring.q(f2 * f6);
        ring.t(0);
        ring.o(f4 * f6, f5 * f6);
    }

    private void m() {
        final Ring ring = this.f11649b;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.n(floatValue, ring);
                CircularProgressDrawable.this.b(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f11646h);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.b(1.0f, ring, true);
                ring.A();
                ring.l();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.f11654g) {
                    circularProgressDrawable.f11654g = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    ring.x(false);
                    return;
                }
                circularProgressDrawable.f11653f += 1.0f;
            }

            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.f11653f = 0.0f;
            }
        });
        this.f11652e = ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, Ring ring, boolean z2) {
        float f3;
        float f4;
        if (this.f11654g) {
            a(f2, ring);
        } else if (f2 != 1.0f || z2) {
            float j2 = ring.j();
            if (f2 < 0.5f) {
                f3 = ring.k();
                f4 = (f11647i.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + f3;
            } else {
                float k2 = ring.k() + 0.79f;
                float f5 = k2;
                f3 = k2 - (((1.0f - f11647i.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f4 = f5;
            }
            ring.y(f3);
            ring.v(f4);
            ring.w(j2 + (0.20999998f * f2));
            h((f2 + this.f11653f) * 216.0f);
        }
    }

    public void d(boolean z2) {
        this.f11649b.x(z2);
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f11650c, bounds.exactCenterX(), bounds.exactCenterY());
        this.f11649b.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f2) {
        this.f11649b.p(f2);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f11649b.u(iArr);
        this.f11649b.t(0);
        invalidateSelf();
    }

    public void g(float f2) {
        this.f11649b.w(f2);
        invalidateSelf();
    }

    public int getAlpha() {
        return this.f11649b.c();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        return this.f11652e.isRunning();
    }

    public void j(float f2, float f3) {
        this.f11649b.y(f2);
        this.f11649b.v(f3);
        invalidateSelf();
    }

    public void k(float f2) {
        this.f11649b.z(f2);
        invalidateSelf();
    }

    public void l(int i2) {
        if (i2 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* access modifiers changed from: package-private */
    public void n(float f2, Ring ring) {
        if (f2 > 0.75f) {
            ring.r(c((f2 - 0.75f) / 0.25f, ring.h(), ring.e()));
        } else {
            ring.r(ring.h());
        }
    }

    public void setAlpha(int i2) {
        this.f11649b.n(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11649b.s(colorFilter);
        invalidateSelf();
    }

    public void start() {
        this.f11652e.cancel();
        this.f11649b.A();
        if (this.f11649b.d() != this.f11649b.g()) {
            this.f11654g = true;
            this.f11652e.setDuration(666);
            this.f11652e.start();
            return;
        }
        this.f11649b.t(0);
        this.f11649b.m();
        this.f11652e.setDuration(1332);
        this.f11652e.start();
    }

    public void stop() {
        this.f11652e.cancel();
        h(0.0f);
        this.f11649b.x(false);
        this.f11649b.t(0);
        this.f11649b.m();
        invalidateSelf();
    }
}
