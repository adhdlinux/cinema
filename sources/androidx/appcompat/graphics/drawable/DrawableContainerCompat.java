package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.imageutils.JfifUtil;

public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    private DrawableContainerState f587b;

    /* renamed from: c  reason: collision with root package name */
    private Rect f588c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f589d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f590e;

    /* renamed from: f  reason: collision with root package name */
    private int f591f = JfifUtil.MARKER_FIRST_BYTE;

    /* renamed from: g  reason: collision with root package name */
    private boolean f592g;

    /* renamed from: h  reason: collision with root package name */
    private int f593h = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f594i;

    /* renamed from: j  reason: collision with root package name */
    private Runnable f595j;

    /* renamed from: k  reason: collision with root package name */
    private long f596k;

    /* renamed from: l  reason: collision with root package name */
    private long f597l;

    /* renamed from: m  reason: collision with root package name */
    private BlockInvalidateCallback f598m;

    private static class Api21Impl {
        private Api21Impl() {
        }

        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    static class BlockInvalidateCallback implements Drawable.Callback {

        /* renamed from: b  reason: collision with root package name */
        private Drawable.Callback f600b;

        BlockInvalidateCallback() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f600b;
            this.f600b = null;
            return callback;
        }

        public BlockInvalidateCallback b(Drawable.Callback callback) {
            this.f600b = callback;
            return this;
        }

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f600b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f600b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static abstract class DrawableContainerState extends Drawable.ConstantState {
        int A = 0;
        int B = 0;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a  reason: collision with root package name */
        final DrawableContainerCompat f601a;

        /* renamed from: b  reason: collision with root package name */
        Resources f602b;

        /* renamed from: c  reason: collision with root package name */
        int f603c;

        /* renamed from: d  reason: collision with root package name */
        int f604d;

        /* renamed from: e  reason: collision with root package name */
        int f605e;

        /* renamed from: f  reason: collision with root package name */
        SparseArray<Drawable.ConstantState> f606f;

        /* renamed from: g  reason: collision with root package name */
        Drawable[] f607g;

        /* renamed from: h  reason: collision with root package name */
        int f608h;

        /* renamed from: i  reason: collision with root package name */
        boolean f609i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f610j;

        /* renamed from: k  reason: collision with root package name */
        Rect f611k;

        /* renamed from: l  reason: collision with root package name */
        boolean f612l = false;

        /* renamed from: m  reason: collision with root package name */
        boolean f613m;

        /* renamed from: n  reason: collision with root package name */
        int f614n;

        /* renamed from: o  reason: collision with root package name */
        int f615o;

        /* renamed from: p  reason: collision with root package name */
        int f616p;

        /* renamed from: q  reason: collision with root package name */
        int f617q;

        /* renamed from: r  reason: collision with root package name */
        boolean f618r;

        /* renamed from: s  reason: collision with root package name */
        int f619s;

        /* renamed from: t  reason: collision with root package name */
        boolean f620t;

        /* renamed from: u  reason: collision with root package name */
        boolean f621u;

        /* renamed from: v  reason: collision with root package name */
        boolean f622v;

        /* renamed from: w  reason: collision with root package name */
        boolean f623w;

        /* renamed from: x  reason: collision with root package name */
        boolean f624x = true;

        /* renamed from: y  reason: collision with root package name */
        boolean f625y;

        /* renamed from: z  reason: collision with root package name */
        int f626z;

        DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            Resources resources2;
            int i2;
            this.f601a = drawableContainerCompat;
            Rect rect = null;
            if (resources != null) {
                resources2 = resources;
            } else if (drawableContainerState != null) {
                resources2 = drawableContainerState.f602b;
            } else {
                resources2 = null;
            }
            this.f602b = resources2;
            if (drawableContainerState != null) {
                i2 = drawableContainerState.f603c;
            } else {
                i2 = 0;
            }
            int f2 = DrawableContainerCompat.f(resources, i2);
            this.f603c = f2;
            if (drawableContainerState != null) {
                this.f604d = drawableContainerState.f604d;
                this.f605e = drawableContainerState.f605e;
                this.f622v = true;
                this.f623w = true;
                this.f609i = drawableContainerState.f609i;
                this.f612l = drawableContainerState.f612l;
                this.f624x = drawableContainerState.f624x;
                this.f625y = drawableContainerState.f625y;
                this.f626z = drawableContainerState.f626z;
                this.A = drawableContainerState.A;
                this.B = drawableContainerState.B;
                this.C = drawableContainerState.C;
                this.D = drawableContainerState.D;
                this.E = drawableContainerState.E;
                this.F = drawableContainerState.F;
                this.G = drawableContainerState.G;
                this.H = drawableContainerState.H;
                this.I = drawableContainerState.I;
                if (drawableContainerState.f603c == f2) {
                    if (drawableContainerState.f610j) {
                        this.f611k = drawableContainerState.f611k != null ? new Rect(drawableContainerState.f611k) : rect;
                        this.f610j = true;
                    }
                    if (drawableContainerState.f613m) {
                        this.f614n = drawableContainerState.f614n;
                        this.f615o = drawableContainerState.f615o;
                        this.f616p = drawableContainerState.f616p;
                        this.f617q = drawableContainerState.f617q;
                        this.f613m = true;
                    }
                }
                if (drawableContainerState.f618r) {
                    this.f619s = drawableContainerState.f619s;
                    this.f618r = true;
                }
                if (drawableContainerState.f620t) {
                    this.f621u = drawableContainerState.f621u;
                    this.f620t = true;
                }
                Drawable[] drawableArr = drawableContainerState.f607g;
                this.f607g = new Drawable[drawableArr.length];
                this.f608h = drawableContainerState.f608h;
                SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.f606f;
                if (sparseArray != null) {
                    this.f606f = sparseArray.clone();
                } else {
                    this.f606f = new SparseArray<>(this.f608h);
                }
                int i3 = this.f608h;
                for (int i4 = 0; i4 < i3; i4++) {
                    Drawable drawable = drawableArr[i4];
                    if (drawable != null) {
                        Drawable.ConstantState constantState = drawable.getConstantState();
                        if (constantState != null) {
                            this.f606f.put(i4, constantState);
                        } else {
                            this.f607g[i4] = drawableArr[i4];
                        }
                    }
                }
                return;
            }
            this.f607g = new Drawable[10];
            this.f608h = 0;
        }

        private void e() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f606f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f607g[this.f606f.keyAt(i2)] = t(this.f606f.valueAt(i2).newDrawable(this.f602b));
                }
                this.f606f = null;
            }
        }

        private Drawable t(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.m(drawable, this.f626z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f601a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f608h;
            if (i2 >= this.f607g.length) {
                o(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f601a);
            this.f607g[i2] = drawable;
            this.f608h++;
            this.f605e = drawable.getChangingConfigurations() | this.f605e;
            p();
            this.f611k = null;
            this.f610j = false;
            this.f613m = false;
            this.f622v = false;
            return i2;
        }

        /* access modifiers changed from: package-private */
        public final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i2 = this.f608h;
                Drawable[] drawableArr = this.f607g;
                for (int i3 = 0; i3 < i2; i3++) {
                    Drawable drawable = drawableArr[i3];
                    if (drawable != null && DrawableCompat.b(drawable)) {
                        DrawableCompat.a(drawableArr[i3], theme);
                        this.f605e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                z(Api21Impl.c(theme));
            }
        }

        public boolean c() {
            if (this.f622v) {
                return this.f623w;
            }
            e();
            this.f622v = true;
            int i2 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.f623w = false;
                    return false;
                }
            }
            this.f623w = true;
            return true;
        }

        public boolean canApplyTheme() {
            int i2 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f606f.get(i3);
                    if (constantState != null && Api21Impl.a(constantState)) {
                        return true;
                    }
                } else if (DrawableCompat.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public void d() {
            this.f613m = true;
            e();
            int i2 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            this.f615o = -1;
            this.f614n = -1;
            this.f617q = 0;
            this.f616p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f614n) {
                    this.f614n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f615o) {
                    this.f615o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f616p) {
                    this.f616p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f617q) {
                    this.f617q = minimumHeight;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final int f() {
            return this.f607g.length;
        }

        public final Drawable g(int i2) {
            int indexOfKey;
            Drawable drawable = this.f607g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f606f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable t2 = t(this.f606f.valueAt(indexOfKey).newDrawable(this.f602b));
            this.f607g[i2] = t2;
            this.f606f.removeAt(indexOfKey);
            if (this.f606f.size() == 0) {
                this.f606f = null;
            }
            return t2;
        }

        public int getChangingConfigurations() {
            return this.f604d | this.f605e;
        }

        public final int h() {
            return this.f608h;
        }

        public final int i() {
            if (!this.f613m) {
                d();
            }
            return this.f615o;
        }

        public final int j() {
            if (!this.f613m) {
                d();
            }
            return this.f617q;
        }

        public final int k() {
            if (!this.f613m) {
                d();
            }
            return this.f616p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f609i) {
                return null;
            }
            Rect rect2 = this.f611k;
            if (rect2 != null || this.f610j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i2 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f610j = true;
            this.f611k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f613m) {
                d();
            }
            return this.f614n;
        }

        public final int n() {
            int i2;
            if (this.f618r) {
                return this.f619s;
            }
            e();
            int i3 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            if (i3 > 0) {
                i2 = drawableArr[0].getOpacity();
            } else {
                i2 = -2;
            }
            for (int i4 = 1; i4 < i3; i4++) {
                i2 = Drawable.resolveOpacity(i2, drawableArr[i4].getOpacity());
            }
            this.f619s = i2;
            this.f618r = true;
            return i2;
        }

        public void o(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            Drawable[] drawableArr2 = this.f607g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i2);
            }
            this.f607g = drawableArr;
        }

        /* access modifiers changed from: package-private */
        public void p() {
            this.f618r = false;
            this.f620t = false;
        }

        public final boolean q() {
            return this.f612l;
        }

        public final boolean r() {
            if (this.f620t) {
                return this.f621u;
            }
            e();
            int i2 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                } else if (drawableArr[i3].isStateful()) {
                    z2 = true;
                    break;
                } else {
                    i3++;
                }
            }
            this.f621u = z2;
            this.f620t = true;
            return z2;
        }

        /* access modifiers changed from: package-private */
        public abstract void s();

        public final void u(boolean z2) {
            this.f612l = z2;
        }

        public final void v(int i2) {
            this.A = i2;
        }

        public final void w(int i2) {
            this.B = i2;
        }

        /* access modifiers changed from: package-private */
        public final boolean x(int i2, int i3) {
            boolean z2;
            int i4 = this.f608h;
            Drawable[] drawableArr = this.f607g;
            boolean z3 = false;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        z2 = DrawableCompat.m(drawable, i2);
                    } else {
                        z2 = false;
                    }
                    if (i5 == i3) {
                        z3 = z2;
                    }
                }
            }
            this.f626z = i2;
            return z3;
        }

        public final void y(boolean z2) {
            this.f609i = z2;
        }

        /* access modifiers changed from: package-private */
        public final void z(Resources resources) {
            if (resources != null) {
                this.f602b = resources;
                int f2 = DrawableContainerCompat.f(resources, this.f603c);
                int i2 = this.f603c;
                this.f603c = f2;
                if (i2 != f2) {
                    this.f613m = false;
                    this.f610j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f598m == null) {
            this.f598m = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.f598m.b(drawable.getCallback()));
        try {
            if (this.f587b.A <= 0 && this.f592g) {
                drawable.setAlpha(this.f591f);
            }
            DrawableContainerState drawableContainerState = this.f587b;
            if (drawableContainerState.E) {
                drawable.setColorFilter(drawableContainerState.D);
            } else {
                if (drawableContainerState.H) {
                    DrawableCompat.o(drawable, drawableContainerState.F);
                }
                DrawableContainerState drawableContainerState2 = this.f587b;
                if (drawableContainerState2.I) {
                    DrawableCompat.p(drawable, drawableContainerState2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f587b.f624x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                DrawableCompat.m(drawable, DrawableCompat.f(this));
            }
            DrawableCompat.j(drawable, this.f587b.C);
            Rect rect = this.f588c;
            if (rect != null) {
                DrawableCompat.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f598m.a());
        }
    }

    private boolean e() {
        if (!isAutoMirrored() || DrawableCompat.f(this) != 1) {
            return false;
        }
        return true;
    }

    static int f(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f592g = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f589d
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L_0x0038
            long r9 = r13.f596k
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L_0x003a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L_0x0022
            int r9 = r13.f591f
            r3.setAlpha(r9)
            r13.f596k = r6
            goto L_0x003a
        L_0x0022:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r9 = r13.f587b
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f591f
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L_0x003b
        L_0x0038:
            r13.f596k = r6
        L_0x003a:
            r3 = 0
        L_0x003b:
            android.graphics.drawable.Drawable r9 = r13.f590e
            if (r9 == 0) goto L_0x0065
            long r10 = r13.f597l
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0067
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L_0x0052
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f590e = r0
            r13.f597l = r6
            goto L_0x0067
        L_0x0052:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.f587b
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f591f
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L_0x0068
        L_0x0065:
            r13.f597l = r6
        L_0x0067:
            r0 = r3
        L_0x0068:
            if (r14 == 0) goto L_0x0074
            if (r0 == 0) goto L_0x0074
            java.lang.Runnable r14 = r13.f595j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L_0x0074:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    public void applyTheme(Resources.Theme theme) {
        this.f587b.b(theme);
    }

    /* access modifiers changed from: package-private */
    public DrawableContainerState b() {
        return this.f587b;
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f593h;
    }

    public boolean canApplyTheme() {
        return this.f587b.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f589d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f590e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f593h
            r1 = 0
            if (r10 != r0) goto L_0x0006
            return r1
        L_0x0006:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f587b
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L_0x002e
            android.graphics.drawable.Drawable r0 = r9.f590e
            if (r0 == 0) goto L_0x001a
            r0.setVisible(r1, r1)
        L_0x001a:
            android.graphics.drawable.Drawable r0 = r9.f589d
            if (r0 == 0) goto L_0x0029
            r9.f590e = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f587b
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f597l = r0
            goto L_0x0035
        L_0x0029:
            r9.f590e = r4
            r9.f597l = r5
            goto L_0x0035
        L_0x002e:
            android.graphics.drawable.Drawable r0 = r9.f589d
            if (r0 == 0) goto L_0x0035
            r0.setVisible(r1, r1)
        L_0x0035:
            if (r10 < 0) goto L_0x0055
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f587b
            int r1 = r0.f608h
            if (r10 >= r1) goto L_0x0055
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f589d = r0
            r9.f593h = r10
            if (r0 == 0) goto L_0x005a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.f587b
            int r10 = r10.A
            if (r10 <= 0) goto L_0x0051
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f596k = r2
        L_0x0051:
            r9.d(r0)
            goto L_0x005a
        L_0x0055:
            r9.f589d = r4
            r10 = -1
            r9.f593h = r10
        L_0x005a:
            long r0 = r9.f596k
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0067
            long r0 = r9.f597l
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x0079
        L_0x0067:
            java.lang.Runnable r0 = r9.f595j
            if (r0 != 0) goto L_0x0073
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r0 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r0.<init>()
            r9.f595j = r0
            goto L_0x0076
        L_0x0073:
            r9.unscheduleSelf(r0)
        L_0x0076:
            r9.a(r10)
        L_0x0079:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.g(int):boolean");
    }

    public int getAlpha() {
        return this.f591f;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f587b.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        if (!this.f587b.c()) {
            return null;
        }
        this.f587b.f604d = getChangingConfigurations();
        return this.f587b;
    }

    public Drawable getCurrent() {
        return this.f589d;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f588c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        if (this.f587b.q()) {
            return this.f587b.i();
        }
        Drawable drawable = this.f589d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        if (this.f587b.q()) {
            return this.f587b.m();
        }
        Drawable drawable = this.f589d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        if (this.f587b.q()) {
            return this.f587b.j();
        }
        Drawable drawable = this.f589d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        if (this.f587b.q()) {
            return this.f587b.k();
        }
        Drawable drawable = this.f589d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f589d;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f587b.n();
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f589d;
        if (drawable != null) {
            Api21Impl.b(drawable, outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z2;
        Rect l2 = this.f587b.l();
        if (l2 != null) {
            rect.set(l2);
            if ((l2.right | l2.left | l2.top | l2.bottom) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            Drawable drawable = this.f589d;
            if (drawable != null) {
                z2 = drawable.getPadding(rect);
            } else {
                z2 = super.getPadding(rect);
            }
        }
        if (e()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public void h(DrawableContainerState drawableContainerState) {
        this.f587b = drawableContainerState;
        int i2 = this.f593h;
        if (i2 >= 0) {
            Drawable g2 = drawableContainerState.g(i2);
            this.f589d = g2;
            if (g2 != null) {
                d(g2);
            }
        }
        this.f590e = null;
    }

    /* access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f587b.z(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        DrawableContainerState drawableContainerState = this.f587b;
        if (drawableContainerState != null) {
            drawableContainerState.p();
        }
        if (drawable == this.f589d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f587b.C;
    }

    public boolean isStateful() {
        return this.f587b.r();
    }

    public void jumpToCurrentState() {
        boolean z2;
        Drawable drawable = this.f590e;
        boolean z3 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f590e = null;
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable2 = this.f589d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f592g) {
                this.f589d.setAlpha(this.f591f);
            }
        }
        if (this.f597l != 0) {
            this.f597l = 0;
            z2 = true;
        }
        if (this.f596k != 0) {
            this.f596k = 0;
        } else {
            z3 = z2;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f594i && super.mutate() == this) {
            DrawableContainerState b2 = b();
            b2.s();
            h(b2);
            this.f594i = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f590e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f589d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        return this.f587b.x(i2, c());
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f590e;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f589d;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f590e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f589d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f589d && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f592g || this.f591f != i2) {
            this.f592g = true;
            this.f591f = i2;
            Drawable drawable = this.f589d;
            if (drawable == null) {
                return;
            }
            if (this.f596k == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z2) {
        DrawableContainerState drawableContainerState = this.f587b;
        if (drawableContainerState.C != z2) {
            drawableContainerState.C = z2;
            Drawable drawable = this.f589d;
            if (drawable != null) {
                DrawableCompat.j(drawable, z2);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.f587b;
        drawableContainerState.E = true;
        if (drawableContainerState.D != colorFilter) {
            drawableContainerState.D = colorFilter;
            Drawable drawable = this.f589d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z2) {
        DrawableContainerState drawableContainerState = this.f587b;
        if (drawableContainerState.f624x != z2) {
            drawableContainerState.f624x = z2;
            Drawable drawable = this.f589d;
            if (drawable != null) {
                drawable.setDither(z2);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f589d;
        if (drawable != null) {
            DrawableCompat.k(drawable, f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f588c;
        if (rect == null) {
            this.f588c = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f589d;
        if (drawable != null) {
            DrawableCompat.l(drawable, i2, i3, i4, i5);
        }
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.f587b;
        drawableContainerState.H = true;
        if (drawableContainerState.F != colorStateList) {
            drawableContainerState.F = colorStateList;
            DrawableCompat.o(this.f589d, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.f587b;
        drawableContainerState.I = true;
        if (drawableContainerState.G != mode) {
            drawableContainerState.G = mode;
            DrawableCompat.p(this.f589d, mode);
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        Drawable drawable = this.f590e;
        if (drawable != null) {
            drawable.setVisible(z2, z3);
        }
        Drawable drawable2 = this.f589d;
        if (drawable2 != null) {
            drawable2.setVisible(z2, z3);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f589d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
