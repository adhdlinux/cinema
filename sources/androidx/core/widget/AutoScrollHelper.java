package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* renamed from: s  reason: collision with root package name */
    private static final int f2905s = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    final ClampedScroller f2906b = new ClampedScroller();

    /* renamed from: c  reason: collision with root package name */
    private final Interpolator f2907c = new AccelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    final View f2908d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f2909e;

    /* renamed from: f  reason: collision with root package name */
    private float[] f2910f = {0.0f, 0.0f};

    /* renamed from: g  reason: collision with root package name */
    private float[] f2911g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: h  reason: collision with root package name */
    private int f2912h;

    /* renamed from: i  reason: collision with root package name */
    private int f2913i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f2914j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    private float[] f2915k = {0.0f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    private float[] f2916l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: m  reason: collision with root package name */
    private boolean f2917m;

    /* renamed from: n  reason: collision with root package name */
    boolean f2918n;

    /* renamed from: o  reason: collision with root package name */
    boolean f2919o;

    /* renamed from: p  reason: collision with root package name */
    boolean f2920p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f2921q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2922r;

    private static class ClampedScroller {

        /* renamed from: a  reason: collision with root package name */
        private int f2923a;

        /* renamed from: b  reason: collision with root package name */
        private int f2924b;

        /* renamed from: c  reason: collision with root package name */
        private float f2925c;

        /* renamed from: d  reason: collision with root package name */
        private float f2926d;

        /* renamed from: e  reason: collision with root package name */
        private long f2927e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        private long f2928f = 0;

        /* renamed from: g  reason: collision with root package name */
        private int f2929g = 0;

        /* renamed from: h  reason: collision with root package name */
        private int f2930h = 0;

        /* renamed from: i  reason: collision with root package name */
        private long f2931i = -1;

        /* renamed from: j  reason: collision with root package name */
        private float f2932j;

        /* renamed from: k  reason: collision with root package name */
        private int f2933k;

        ClampedScroller() {
        }

        private float e(long j2) {
            long j3 = this.f2927e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f2931i;
            if (j4 < 0 || j2 < j4) {
                return AutoScrollHelper.e(((float) (j2 - j3)) / ((float) this.f2923a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f2932j;
            return (1.0f - f2) + (f2 * AutoScrollHelper.e(((float) (j2 - j4)) / ((float) this.f2933k), 0.0f, 1.0f));
        }

        private float g(float f2) {
            return (-4.0f * f2 * f2) + (f2 * 4.0f);
        }

        public void a() {
            if (this.f2928f != 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float g2 = g(e(currentAnimationTimeMillis));
                this.f2928f = currentAnimationTimeMillis;
                float f2 = ((float) (currentAnimationTimeMillis - this.f2928f)) * g2;
                this.f2929g = (int) (this.f2925c * f2);
                this.f2930h = (int) (f2 * this.f2926d);
                return;
            }
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f2929g;
        }

        public int c() {
            return this.f2930h;
        }

        public int d() {
            float f2 = this.f2925c;
            return (int) (f2 / Math.abs(f2));
        }

        public int f() {
            float f2 = this.f2926d;
            return (int) (f2 / Math.abs(f2));
        }

        public boolean h() {
            if (this.f2931i <= 0 || AnimationUtils.currentAnimationTimeMillis() <= this.f2931i + ((long) this.f2933k)) {
                return false;
            }
            return true;
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2933k = AutoScrollHelper.f((int) (currentAnimationTimeMillis - this.f2927e), 0, this.f2924b);
            this.f2932j = e(currentAnimationTimeMillis);
            this.f2931i = currentAnimationTimeMillis;
        }

        public void j(int i2) {
            this.f2924b = i2;
        }

        public void k(int i2) {
            this.f2923a = i2;
        }

        public void l(float f2, float f3) {
            this.f2925c = f2;
            this.f2926d = f3;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2927e = currentAnimationTimeMillis;
            this.f2931i = -1;
            this.f2928f = currentAnimationTimeMillis;
            this.f2932j = 0.5f;
            this.f2929g = 0;
            this.f2930h = 0;
        }
    }

    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f2920p) {
                if (autoScrollHelper.f2918n) {
                    autoScrollHelper.f2918n = false;
                    autoScrollHelper.f2906b.m();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.f2906b;
                if (clampedScroller.h() || !AutoScrollHelper.this.u()) {
                    AutoScrollHelper.this.f2920p = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f2919o) {
                    autoScrollHelper2.f2919o = false;
                    autoScrollHelper2.c();
                }
                clampedScroller.a();
                AutoScrollHelper.this.j(clampedScroller.b(), clampedScroller.c());
                ViewCompat.j0(AutoScrollHelper.this.f2908d, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.f2908d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = (float) ((int) ((1575.0f * f2) + 0.5f));
        o(f3, f3);
        float f4 = (float) ((int) ((f2 * 315.0f) + 0.5f));
        p(f4, f4);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2905s);
        r(500);
        q(500);
    }

    private float d(int i2, float f2, float f3, float f4) {
        float h2 = h(this.f2910f[i2], f3, this.f2911g[i2], f2);
        int i3 = (h2 > 0.0f ? 1 : (h2 == 0.0f ? 0 : -1));
        if (i3 == 0) {
            return 0.0f;
        }
        float f5 = this.f2914j[i2];
        float f6 = this.f2915k[i2];
        float f7 = this.f2916l[i2];
        float f8 = f5 * f4;
        if (i3 > 0) {
            return e(h2 * f8, f6, f7);
        }
        return -e((-h2) * f8, f6, f7);
    }

    static float e(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    static int f(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : i2 < i3 ? i3 : i2;
    }

    private float g(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f2912h;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (!this.f2920p || i2 != 1) {
                    return 0.0f;
                }
                return 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    private float h(float f2, float f3, float f4, float f5) {
        float f6;
        float e2 = e(f2 * f3, 0.0f, f4);
        float g2 = g(f3 - f5, e2) - g(f5, e2);
        if (g2 < 0.0f) {
            f6 = -this.f2907c.getInterpolation(-g2);
        } else if (g2 <= 0.0f) {
            return 0.0f;
        } else {
            f6 = this.f2907c.getInterpolation(g2);
        }
        return e(f6, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f2918n) {
            this.f2920p = false;
        } else {
            this.f2906b.i();
        }
    }

    private void v() {
        int i2;
        if (this.f2909e == null) {
            this.f2909e = new ScrollAnimationRunnable();
        }
        this.f2920p = true;
        this.f2918n = true;
        if (this.f2917m || (i2 = this.f2913i) <= 0) {
            this.f2909e.run();
        } else {
            ViewCompat.k0(this.f2908d, this.f2909e, (long) i2);
        }
        this.f2917m = true;
    }

    public abstract boolean a(int i2);

    public abstract boolean b(int i2);

    /* access modifiers changed from: package-private */
    public void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f2908d.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i2, int i3);

    public AutoScrollHelper k(int i2) {
        this.f2913i = i2;
        return this;
    }

    public AutoScrollHelper l(int i2) {
        this.f2912h = i2;
        return this;
    }

    public AutoScrollHelper m(boolean z2) {
        if (this.f2921q && !z2) {
            i();
        }
        this.f2921q = z2;
        return this;
    }

    public AutoScrollHelper n(float f2, float f3) {
        float[] fArr = this.f2911g;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public AutoScrollHelper o(float f2, float f3) {
        float[] fArr = this.f2916l;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f2921q
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L_0x001a
            if (r0 == r2) goto L_0x0016
            r3 = 2
            if (r0 == r3) goto L_0x001e
            r6 = 3
            if (r0 == r6) goto L_0x0016
            goto L_0x0058
        L_0x0016:
            r5.i()
            goto L_0x0058
        L_0x001a:
            r5.f2919o = r2
            r5.f2917m = r1
        L_0x001e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f2908d
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f2908d
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r7 = r5.f2906b
            r7.l(r0, r6)
            boolean r6 = r5.f2920p
            if (r6 != 0) goto L_0x0058
            boolean r6 = r5.u()
            if (r6 == 0) goto L_0x0058
            r5.v()
        L_0x0058:
            boolean r6 = r5.f2922r
            if (r6 == 0) goto L_0x0061
            boolean r6 = r5.f2920p
            if (r6 == 0) goto L_0x0061
            r1 = 1
        L_0x0061:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public AutoScrollHelper p(float f2, float f3) {
        float[] fArr = this.f2915k;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    public AutoScrollHelper q(int i2) {
        this.f2906b.j(i2);
        return this;
    }

    public AutoScrollHelper r(int i2) {
        this.f2906b.k(i2);
        return this;
    }

    public AutoScrollHelper s(float f2, float f3) {
        float[] fArr = this.f2910f;
        fArr[0] = f2;
        fArr[1] = f3;
        return this;
    }

    public AutoScrollHelper t(float f2, float f3) {
        float[] fArr = this.f2914j;
        fArr[0] = f2 / 1000.0f;
        fArr[1] = f3 / 1000.0f;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        ClampedScroller clampedScroller = this.f2906b;
        int f2 = clampedScroller.f();
        int d2 = clampedScroller.d();
        if ((f2 == 0 || !b(f2)) && (d2 == 0 || !a(d2))) {
            return false;
        }
        return true;
    }
}
