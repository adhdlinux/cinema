package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.vungle.ads.internal.protos.Sdk$SDKError;

public final class CollapsingTextHelper {
    private static final boolean T = false;
    private static final Paint U = null;
    private Paint A;
    private float B;
    private float C;
    private float D;
    private float E;
    private int[] F;
    private boolean G;
    private final TextPaint H;
    private final TextPaint I;
    private TimeInterpolator J;
    private TimeInterpolator K;
    private float L;
    private float M;
    private float N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;

    /* renamed from: a  reason: collision with root package name */
    private final View f29829a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f29830b;

    /* renamed from: c  reason: collision with root package name */
    private float f29831c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f29832d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f29833e;

    /* renamed from: f  reason: collision with root package name */
    private final RectF f29834f;

    /* renamed from: g  reason: collision with root package name */
    private int f29835g = 16;

    /* renamed from: h  reason: collision with root package name */
    private int f29836h = 16;

    /* renamed from: i  reason: collision with root package name */
    private float f29837i = 15.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f29838j = 15.0f;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f29839k;

    /* renamed from: l  reason: collision with root package name */
    private ColorStateList f29840l;

    /* renamed from: m  reason: collision with root package name */
    private float f29841m;

    /* renamed from: n  reason: collision with root package name */
    private float f29842n;

    /* renamed from: o  reason: collision with root package name */
    private float f29843o;

    /* renamed from: p  reason: collision with root package name */
    private float f29844p;

    /* renamed from: q  reason: collision with root package name */
    private float f29845q;

    /* renamed from: r  reason: collision with root package name */
    private float f29846r;

    /* renamed from: s  reason: collision with root package name */
    private Typeface f29847s;

    /* renamed from: t  reason: collision with root package name */
    private Typeface f29848t;

    /* renamed from: u  reason: collision with root package name */
    private Typeface f29849u;

    /* renamed from: v  reason: collision with root package name */
    private CharSequence f29850v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f29851w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f29852x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f29853y;

    /* renamed from: z  reason: collision with root package name */
    private Bitmap f29854z;

    public CollapsingTextHelper(View view) {
        this.f29829a = view;
        TextPaint textPaint = new TextPaint(Sdk$SDKError.Reason.EMPTY_TPAT_ERROR_VALUE);
        this.H = textPaint;
        this.I = new TextPaint(textPaint);
        this.f29833e = new Rect();
        this.f29832d = new Rect();
        this.f29834f = new RectF();
    }

    private Typeface B(int i2) {
        TypedArray obtainStyledAttributes = this.f29829a.getContext().obtainStyledAttributes(i2, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private static boolean D(Rect rect, int i2, int i3, int i4, int i5) {
        return rect.left == i2 && rect.top == i3 && rect.right == i4 && rect.bottom == i5;
    }

    private void Q(float f2) {
        boolean z2;
        g(f2);
        if (!T || this.D == 1.0f) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f29853y = z2;
        if (z2) {
            j();
        }
        ViewCompat.i0(this.f29829a);
    }

    private static int a(int i2, int i3, float f2) {
        float f3 = 1.0f - f2;
        return Color.argb((int) ((((float) Color.alpha(i2)) * f3) + (((float) Color.alpha(i3)) * f2)), (int) ((((float) Color.red(i2)) * f3) + (((float) Color.red(i3)) * f2)), (int) ((((float) Color.green(i2)) * f3) + (((float) Color.green(i3)) * f2)), (int) ((((float) Color.blue(i2)) * f3) + (((float) Color.blue(i3)) * f2)));
    }

    private void b() {
        float f2;
        float f3 = this.E;
        g(this.f29838j);
        CharSequence charSequence = this.f29851w;
        float f4 = 0.0f;
        if (charSequence != null) {
            f2 = this.H.measureText(charSequence, 0, charSequence.length());
        } else {
            f2 = 0.0f;
        }
        int b2 = GravityCompat.b(this.f29836h, this.f29852x ? 1 : 0);
        int i2 = b2 & 112;
        if (i2 == 48) {
            this.f29842n = ((float) this.f29833e.top) - this.H.ascent();
        } else if (i2 != 80) {
            this.f29842n = ((float) this.f29833e.centerY()) + (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent());
        } else {
            this.f29842n = (float) this.f29833e.bottom;
        }
        int i3 = b2 & 8388615;
        if (i3 == 1) {
            this.f29844p = ((float) this.f29833e.centerX()) - (f2 / 2.0f);
        } else if (i3 != 5) {
            this.f29844p = (float) this.f29833e.left;
        } else {
            this.f29844p = ((float) this.f29833e.right) - f2;
        }
        g(this.f29837i);
        CharSequence charSequence2 = this.f29851w;
        if (charSequence2 != null) {
            f4 = this.H.measureText(charSequence2, 0, charSequence2.length());
        }
        int b3 = GravityCompat.b(this.f29835g, this.f29852x ? 1 : 0);
        int i4 = b3 & 112;
        if (i4 == 48) {
            this.f29841m = ((float) this.f29832d.top) - this.H.ascent();
        } else if (i4 != 80) {
            this.f29841m = ((float) this.f29832d.centerY()) + (((this.H.descent() - this.H.ascent()) / 2.0f) - this.H.descent());
        } else {
            this.f29841m = (float) this.f29832d.bottom;
        }
        int i5 = b3 & 8388615;
        if (i5 == 1) {
            this.f29843o = ((float) this.f29832d.centerX()) - (f4 / 2.0f);
        } else if (i5 != 5) {
            this.f29843o = (float) this.f29832d.left;
        } else {
            this.f29843o = ((float) this.f29832d.right) - f4;
        }
        h();
        Q(f3);
    }

    private void d() {
        f(this.f29831c);
    }

    private boolean e(CharSequence charSequence) {
        TextDirectionHeuristicCompat textDirectionHeuristicCompat;
        boolean z2 = true;
        if (ViewCompat.D(this.f29829a) != 1) {
            z2 = false;
        }
        if (z2) {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f2711d;
        } else {
            textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.f2710c;
        }
        return textDirectionHeuristicCompat.isRtl(charSequence, 0, charSequence.length());
    }

    private void f(float f2) {
        w(f2);
        this.f29845q = z(this.f29843o, this.f29844p, f2, this.J);
        this.f29846r = z(this.f29841m, this.f29842n, f2, this.J);
        Q(z(this.f29837i, this.f29838j, f2, this.K));
        if (this.f29840l != this.f29839k) {
            this.H.setColor(a(q(), p(), f2));
        } else {
            this.H.setColor(p());
        }
        this.H.setShadowLayer(z(this.P, this.L, f2, (TimeInterpolator) null), z(this.Q, this.M, f2, (TimeInterpolator) null), z(this.R, this.N, f2, (TimeInterpolator) null), a(this.S, this.O, f2));
        ViewCompat.i0(this.f29829a);
    }

    private void g(float f2) {
        float f3;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this.f29850v != null) {
            float width = (float) this.f29833e.width();
            float width2 = (float) this.f29832d.width();
            boolean z5 = true;
            if (x(f2, this.f29838j)) {
                f3 = this.f29838j;
                this.D = 1.0f;
                Typeface typeface = this.f29849u;
                Typeface typeface2 = this.f29847s;
                if (typeface != typeface2) {
                    this.f29849u = typeface2;
                    z2 = true;
                } else {
                    z2 = false;
                }
            } else {
                float f4 = this.f29837i;
                Typeface typeface3 = this.f29849u;
                Typeface typeface4 = this.f29848t;
                if (typeface3 != typeface4) {
                    this.f29849u = typeface4;
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (x(f2, f4)) {
                    this.D = 1.0f;
                } else {
                    this.D = f2 / this.f29837i;
                }
                float f5 = this.f29838j / this.f29837i;
                if (width2 * f5 > width) {
                    width = Math.min(width / f5, width2);
                } else {
                    width = width2;
                }
                f3 = f4;
                z2 = z4;
            }
            if (width > 0.0f) {
                if (this.E != f3 || this.G || z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.E = f3;
                this.G = false;
            }
            if (this.f29851w == null || z2) {
                this.H.setTextSize(this.E);
                this.H.setTypeface(this.f29849u);
                TextPaint textPaint = this.H;
                if (this.D == 1.0f) {
                    z5 = false;
                }
                textPaint.setLinearText(z5);
                CharSequence ellipsize = TextUtils.ellipsize(this.f29850v, this.H, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f29851w)) {
                    this.f29851w = ellipsize;
                    this.f29852x = e(ellipsize);
                }
            }
        }
    }

    private void h() {
        Bitmap bitmap = this.f29854z;
        if (bitmap != null) {
            bitmap.recycle();
            this.f29854z = null;
        }
    }

    private void j() {
        if (this.f29854z == null && !this.f29832d.isEmpty() && !TextUtils.isEmpty(this.f29851w)) {
            f(0.0f);
            this.B = this.H.ascent();
            this.C = this.H.descent();
            TextPaint textPaint = this.H;
            CharSequence charSequence = this.f29851w;
            int round = Math.round(textPaint.measureText(charSequence, 0, charSequence.length()));
            int round2 = Math.round(this.C - this.B);
            if (round > 0 && round2 > 0) {
                this.f29854z = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f29854z);
                CharSequence charSequence2 = this.f29851w;
                canvas.drawText(charSequence2, 0, charSequence2.length(), 0.0f, ((float) round2) - this.H.descent(), this.H);
                if (this.A == null) {
                    this.A = new Paint(3);
                }
            }
        }
    }

    private int q() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.f29839k.getColorForState(iArr, 0);
        }
        return this.f29839k.getDefaultColor();
    }

    private void v(TextPaint textPaint) {
        textPaint.setTextSize(this.f29838j);
        textPaint.setTypeface(this.f29847s);
    }

    private void w(float f2) {
        this.f29834f.left = z((float) this.f29832d.left, (float) this.f29833e.left, f2, this.J);
        this.f29834f.top = z(this.f29841m, this.f29842n, f2, this.J);
        this.f29834f.right = z((float) this.f29832d.right, (float) this.f29833e.right, f2, this.J);
        this.f29834f.bottom = z((float) this.f29832d.bottom, (float) this.f29833e.bottom, f2, this.J);
    }

    private static boolean x(float f2, float f3) {
        return Math.abs(f2 - f3) < 0.001f;
    }

    private static float z(float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f4 = timeInterpolator.getInterpolation(f4);
        }
        return AnimationUtils.a(f2, f3, f4);
    }

    /* access modifiers changed from: package-private */
    public void A() {
        boolean z2;
        if (this.f29833e.width() <= 0 || this.f29833e.height() <= 0 || this.f29832d.width() <= 0 || this.f29832d.height() <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f29830b = z2;
    }

    public void C() {
        if (this.f29829a.getHeight() > 0 && this.f29829a.getWidth() > 0) {
            b();
            d();
        }
    }

    public void E(int i2, int i3, int i4, int i5) {
        if (!D(this.f29833e, i2, i3, i4, i5)) {
            this.f29833e.set(i2, i3, i4, i5);
            this.G = true;
            A();
        }
    }

    public void F(int i2) {
        TintTypedArray t2 = TintTypedArray.t(this.f29829a.getContext(), i2, R$styleable.c3);
        int i3 = R$styleable.g3;
        if (t2.s(i3)) {
            this.f29840l = t2.c(i3);
        }
        int i4 = R$styleable.d3;
        if (t2.s(i4)) {
            this.f29838j = (float) t2.f(i4, (int) this.f29838j);
        }
        this.O = t2.k(R$styleable.j3, 0);
        this.M = t2.i(R$styleable.k3, 0.0f);
        this.N = t2.i(R$styleable.l3, 0.0f);
        this.L = t2.i(R$styleable.m3, 0.0f);
        t2.w();
        this.f29847s = B(i2);
        C();
    }

    public void G(ColorStateList colorStateList) {
        if (this.f29840l != colorStateList) {
            this.f29840l = colorStateList;
            C();
        }
    }

    public void H(int i2) {
        if (this.f29836h != i2) {
            this.f29836h = i2;
            C();
        }
    }

    public void I(Typeface typeface) {
        if (this.f29847s != typeface) {
            this.f29847s = typeface;
            C();
        }
    }

    public void J(int i2, int i3, int i4, int i5) {
        if (!D(this.f29832d, i2, i3, i4, i5)) {
            this.f29832d.set(i2, i3, i4, i5);
            this.G = true;
            A();
        }
    }

    public void K(int i2) {
        TintTypedArray t2 = TintTypedArray.t(this.f29829a.getContext(), i2, R$styleable.c3);
        int i3 = R$styleable.g3;
        if (t2.s(i3)) {
            this.f29839k = t2.c(i3);
        }
        int i4 = R$styleable.d3;
        if (t2.s(i4)) {
            this.f29837i = (float) t2.f(i4, (int) this.f29837i);
        }
        this.S = t2.k(R$styleable.j3, 0);
        this.Q = t2.i(R$styleable.k3, 0.0f);
        this.R = t2.i(R$styleable.l3, 0.0f);
        this.P = t2.i(R$styleable.m3, 0.0f);
        t2.w();
        this.f29848t = B(i2);
        C();
    }

    public void L(ColorStateList colorStateList) {
        if (this.f29839k != colorStateList) {
            this.f29839k = colorStateList;
            C();
        }
    }

    public void M(int i2) {
        if (this.f29835g != i2) {
            this.f29835g = i2;
            C();
        }
    }

    public void N(float f2) {
        if (this.f29837i != f2) {
            this.f29837i = f2;
            C();
        }
    }

    public void O(Typeface typeface) {
        if (this.f29848t != typeface) {
            this.f29848t = typeface;
            C();
        }
    }

    public void P(float f2) {
        float a2 = MathUtils.a(f2, 0.0f, 1.0f);
        if (a2 != this.f29831c) {
            this.f29831c = a2;
            d();
        }
    }

    public void R(TimeInterpolator timeInterpolator) {
        this.J = timeInterpolator;
        C();
    }

    public final boolean S(int[] iArr) {
        this.F = iArr;
        if (!y()) {
            return false;
        }
        C();
        return true;
    }

    public void T(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f29850v)) {
            this.f29850v = charSequence;
            this.f29851w = null;
            h();
            C();
        }
    }

    public void U(TimeInterpolator timeInterpolator) {
        this.K = timeInterpolator;
        C();
    }

    public void V(Typeface typeface) {
        this.f29848t = typeface;
        this.f29847s = typeface;
        C();
    }

    public float c() {
        if (this.f29850v == null) {
            return 0.0f;
        }
        v(this.I);
        TextPaint textPaint = this.I;
        CharSequence charSequence = this.f29850v;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public void i(Canvas canvas) {
        boolean z2;
        float f2;
        int save = canvas.save();
        if (this.f29851w != null && this.f29830b) {
            float f3 = this.f29845q;
            float f4 = this.f29846r;
            if (!this.f29853y || this.f29854z == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                f2 = this.B * this.D;
            } else {
                f2 = this.H.ascent() * this.D;
                this.H.descent();
            }
            if (z2) {
                f4 += f2;
            }
            float f5 = f4;
            float f6 = this.D;
            if (f6 != 1.0f) {
                canvas.scale(f6, f6, f3, f5);
            }
            if (z2) {
                canvas.drawBitmap(this.f29854z, f3, f5, this.A);
            } else {
                CharSequence charSequence = this.f29851w;
                canvas.drawText(charSequence, 0, charSequence.length(), f3, f5, this.H);
            }
        }
        canvas.restoreToCount(save);
    }

    public void k(RectF rectF) {
        float f2;
        float f3;
        boolean e2 = e(this.f29850v);
        Rect rect = this.f29833e;
        if (!e2) {
            f2 = (float) rect.left;
        } else {
            f2 = ((float) rect.right) - c();
        }
        rectF.left = f2;
        Rect rect2 = this.f29833e;
        rectF.top = (float) rect2.top;
        if (!e2) {
            f3 = f2 + c();
        } else {
            f3 = (float) rect2.right;
        }
        rectF.right = f3;
        rectF.bottom = ((float) this.f29833e.top) + n();
    }

    public ColorStateList l() {
        return this.f29840l;
    }

    public int m() {
        return this.f29836h;
    }

    public float n() {
        v(this.I);
        return -this.I.ascent();
    }

    public Typeface o() {
        Typeface typeface = this.f29847s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int p() {
        int[] iArr = this.F;
        if (iArr != null) {
            return this.f29840l.getColorForState(iArr, 0);
        }
        return this.f29840l.getDefaultColor();
    }

    public int r() {
        return this.f29835g;
    }

    public Typeface s() {
        Typeface typeface = this.f29848t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public float t() {
        return this.f29831c;
    }

    public CharSequence u() {
        return this.f29850v;
    }

    public final boolean y() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f29840l;
        if ((colorStateList2 == null || !colorStateList2.isStateful()) && ((colorStateList = this.f29839k) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }
}
