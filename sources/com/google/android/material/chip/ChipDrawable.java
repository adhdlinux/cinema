package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends Drawable implements TintAwareDrawable, Drawable.Callback {

    /* renamed from: i0  reason: collision with root package name */
    private static final int[] f29690i0 = {16842910};
    private float A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private final Context H;
    private final TextPaint I;
    private final Paint J;
    private final Paint K;
    private final Paint.FontMetrics L;
    private final RectF M;
    private final PointF N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private boolean S;
    private int T;
    private int U;
    private ColorFilter V;
    private PorterDuffColorFilter W;
    private ColorStateList X;
    private PorterDuff.Mode Y;
    private int[] Z;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f29691a0;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f29692b;

    /* renamed from: b0  reason: collision with root package name */
    private ColorStateList f29693b0;

    /* renamed from: c  reason: collision with root package name */
    private float f29694c;

    /* renamed from: c0  reason: collision with root package name */
    private WeakReference<Delegate> f29695c0;

    /* renamed from: d  reason: collision with root package name */
    private float f29696d;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public boolean f29697d0;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f29698e;

    /* renamed from: e0  reason: collision with root package name */
    private float f29699e0;

    /* renamed from: f  reason: collision with root package name */
    private float f29700f;

    /* renamed from: f0  reason: collision with root package name */
    private TextUtils.TruncateAt f29701f0;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f29702g;

    /* renamed from: g0  reason: collision with root package name */
    private boolean f29703g0;

    /* renamed from: h  reason: collision with root package name */
    private CharSequence f29704h;

    /* renamed from: h0  reason: collision with root package name */
    private int f29705h0;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f29706i;

    /* renamed from: j  reason: collision with root package name */
    private TextAppearance f29707j;

    /* renamed from: k  reason: collision with root package name */
    private final ResourcesCompat.FontCallback f29708k = new ResourcesCompat.FontCallback() {
        public void h(int i2) {
        }

        public void i(Typeface typeface) {
            boolean unused = ChipDrawable.this.f29697d0 = true;
            ChipDrawable.this.l0();
            ChipDrawable.this.invalidateSelf();
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private boolean f29709l;

    /* renamed from: m  reason: collision with root package name */
    private Drawable f29710m;

    /* renamed from: n  reason: collision with root package name */
    private ColorStateList f29711n;

    /* renamed from: o  reason: collision with root package name */
    private float f29712o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f29713p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f29714q;

    /* renamed from: r  reason: collision with root package name */
    private ColorStateList f29715r;

    /* renamed from: s  reason: collision with root package name */
    private float f29716s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f29717t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f29718u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f29719v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f29720w;

    /* renamed from: x  reason: collision with root package name */
    private MotionSpec f29721x;

    /* renamed from: y  reason: collision with root package name */
    private MotionSpec f29722y;

    /* renamed from: z  reason: collision with root package name */
    private float f29723z;

    public interface Delegate {
        void a();
    }

    private ChipDrawable(Context context) {
        TextPaint textPaint = new TextPaint(1);
        this.I = textPaint;
        this.J = new Paint(1);
        this.L = new Paint.FontMetrics();
        this.M = new RectF();
        this.N = new PointF();
        this.U = JfifUtil.MARKER_FIRST_BYTE;
        this.Y = PorterDuff.Mode.SRC_IN;
        this.f29695c0 = new WeakReference<>((Object) null);
        this.f29697d0 = true;
        this.H = context;
        this.f29704h = "";
        textPaint.density = context.getResources().getDisplayMetrics().density;
        this.K = null;
        int[] iArr = f29690i0;
        setState(iArr);
        Y0(iArr);
        this.f29703g0 = true;
    }

    private boolean A1() {
        return this.f29719v && this.f29720w != null && this.S;
    }

    private boolean B1() {
        return this.f29709l && this.f29710m != null;
    }

    private boolean C1() {
        return this.f29713p && this.f29714q != null;
    }

    private void D1(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback((Drawable.Callback) null);
        }
    }

    private void E1() {
        ColorStateList colorStateList;
        if (this.f29691a0) {
            colorStateList = RippleUtils.a(this.f29702g);
        } else {
            colorStateList = null;
        }
        this.f29693b0 = colorStateList;
    }

    private float Z() {
        if (!this.f29697d0) {
            return this.f29699e0;
        }
        float l2 = l(this.f29706i);
        this.f29699e0 = l2;
        this.f29697d0 = false;
        return l2;
    }

    private ColorFilter a0() {
        ColorFilter colorFilter = this.V;
        return colorFilter != null ? colorFilter : this.W;
    }

    private void b(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.m(drawable, DrawableCompat.f(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.f29714q) {
                if (drawable.isStateful()) {
                    drawable.setState(M());
                }
                DrawableCompat.o(drawable, this.f29715r);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    private static boolean b0(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    private void c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (B1() || A1()) {
            float f2 = this.f29723z + this.A;
            if (DrawableCompat.f(this) == 0) {
                float f3 = ((float) rect.left) + f2;
                rectF.left = f3;
                rectF.right = f3 + this.f29712o;
            } else {
                float f4 = ((float) rect.right) - f2;
                rectF.right = f4;
                rectF.left = f4 - this.f29712o;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.f29712o;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private void e(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (C1()) {
            float f2 = this.G + this.F + this.f29716s + this.E + this.D;
            if (DrawableCompat.f(this) == 0) {
                rectF.right = ((float) rect.right) - f2;
            } else {
                rectF.left = ((float) rect.left) + f2;
            }
        }
    }

    private void f(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (C1()) {
            float f2 = this.G + this.F;
            if (DrawableCompat.f(this) == 0) {
                float f3 = ((float) rect.right) - f2;
                rectF.right = f3;
                rectF.left = f3 - this.f29716s;
            } else {
                float f4 = ((float) rect.left) + f2;
                rectF.left = f4;
                rectF.right = f4 + this.f29716s;
            }
            float exactCenterY = rect.exactCenterY();
            float f5 = this.f29716s;
            float f6 = exactCenterY - (f5 / 2.0f);
            rectF.top = f6;
            rectF.bottom = f6 + f5;
        }
    }

    private void g(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (C1()) {
            float f2 = this.G + this.F + this.f29716s + this.E + this.D;
            if (DrawableCompat.f(this) == 0) {
                float f3 = (float) rect.right;
                rectF.right = f3;
                rectF.left = f3 - f2;
            } else {
                int i2 = rect.left;
                rectF.left = (float) i2;
                rectF.right = ((float) i2) + f2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private float h() {
        if (C1()) {
            return this.E + this.f29716s + this.F;
        }
        return 0.0f;
    }

    private static boolean h0(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private void i(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f29706i != null) {
            float d2 = this.f29723z + d() + this.C;
            float h2 = this.G + h() + this.D;
            if (DrawableCompat.f(this) == 0) {
                rectF.left = ((float) rect.left) + d2;
                rectF.right = ((float) rect.right) - h2;
            } else {
                rectF.left = ((float) rect.left) + h2;
                rectF.right = ((float) rect.right) - d2;
            }
            rectF.top = (float) rect.top;
            rectF.bottom = (float) rect.bottom;
        }
    }

    private static boolean i0(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private float j() {
        this.I.getFontMetrics(this.L);
        Paint.FontMetrics fontMetrics = this.L;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean j0(TextAppearance textAppearance) {
        ColorStateList colorStateList;
        if (textAppearance == null || (colorStateList = textAppearance.f29925b) == null || !colorStateList.isStateful()) {
            return false;
        }
        return true;
    }

    private void k0(AttributeSet attributeSet, int i2, int i3) {
        TypedArray h2 = ThemeEnforcement.h(this.H, attributeSet, R$styleable.V, i2, i3, new int[0]);
        t0(MaterialResources.a(this.H, h2, R$styleable.f29337e0));
        H0(h2.getDimension(R$styleable.f29361m0, 0.0f));
        v0(h2.getDimension(R$styleable.f29340f0, 0.0f));
        L0(MaterialResources.a(this.H, h2, R$styleable.f29367o0));
        N0(h2.getDimension(R$styleable.f29370p0, 0.0f));
        m1(MaterialResources.a(this.H, h2, R$styleable.A0));
        r1(h2.getText(R$styleable.Z));
        s1(MaterialResources.d(this.H, h2, R$styleable.W));
        int i4 = h2.getInt(R$styleable.X, 0);
        if (i4 == 1) {
            e1(TextUtils.TruncateAt.START);
        } else if (i4 == 2) {
            e1(TextUtils.TruncateAt.MIDDLE);
        } else if (i4 == 3) {
            e1(TextUtils.TruncateAt.END);
        }
        G0(h2.getBoolean(R$styleable.f29358l0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") != null)) {
            G0(h2.getBoolean(R$styleable.f29349i0, false));
        }
        z0(MaterialResources.b(this.H, h2, R$styleable.f29346h0));
        D0(MaterialResources.a(this.H, h2, R$styleable.f29355k0));
        B0(h2.getDimension(R$styleable.f29352j0, 0.0f));
        c1(h2.getBoolean(R$styleable.f29388w0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") != null)) {
            c1(h2.getBoolean(R$styleable.f29376r0, false));
        }
        P0(MaterialResources.b(this.H, h2, R$styleable.f29373q0));
        Z0(MaterialResources.a(this.H, h2, R$styleable.f29386v0));
        U0(h2.getDimension(R$styleable.f29382t0, 0.0f));
        n0(h2.getBoolean(R$styleable.f29325a0, false));
        s0(h2.getBoolean(R$styleable.f29334d0, false));
        if (!(attributeSet == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") == null || attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") != null)) {
            s0(h2.getBoolean(R$styleable.f29331c0, false));
        }
        p0(MaterialResources.b(this.H, h2, R$styleable.f29328b0));
        p1(MotionSpec.b(this.H, h2, R$styleable.B0));
        f1(MotionSpec.b(this.H, h2, R$styleable.f29390x0));
        J0(h2.getDimension(R$styleable.f29364n0, 0.0f));
        j1(h2.getDimension(R$styleable.f29394z0, 0.0f));
        h1(h2.getDimension(R$styleable.f29392y0, 0.0f));
        w1(h2.getDimension(R$styleable.D0, 0.0f));
        u1(h2.getDimension(R$styleable.C0, 0.0f));
        W0(h2.getDimension(R$styleable.f29384u0, 0.0f));
        R0(h2.getDimension(R$styleable.f29379s0, 0.0f));
        x0(h2.getDimension(R$styleable.f29343g0, 0.0f));
        l1(h2.getDimensionPixelSize(R$styleable.Y, Integer.MAX_VALUE));
        h2.recycle();
    }

    private float l(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.I.measureText(charSequence, 0, charSequence.length());
    }

    private boolean m() {
        return this.f29719v && this.f29720w != null && this.f29718u;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m0(int[] r6, int[] r7) {
        /*
            r5 = this;
            boolean r0 = super.onStateChange(r6)
            android.content.res.ColorStateList r1 = r5.f29692b
            r2 = 0
            if (r1 == 0) goto L_0x0010
            int r3 = r5.O
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            int r3 = r5.O
            r4 = 1
            if (r3 == r1) goto L_0x0019
            r5.O = r1
            r0 = 1
        L_0x0019:
            android.content.res.ColorStateList r1 = r5.f29698e
            if (r1 == 0) goto L_0x0024
            int r3 = r5.P
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            int r3 = r5.P
            if (r3 == r1) goto L_0x002c
            r5.P = r1
            r0 = 1
        L_0x002c:
            android.content.res.ColorStateList r1 = r5.f29693b0
            if (r1 == 0) goto L_0x0037
            int r3 = r5.Q
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            int r3 = r5.Q
            if (r3 == r1) goto L_0x0043
            r5.Q = r1
            boolean r1 = r5.f29691a0
            if (r1 == 0) goto L_0x0043
            r0 = 1
        L_0x0043:
            com.google.android.material.resources.TextAppearance r1 = r5.f29707j
            if (r1 == 0) goto L_0x0052
            android.content.res.ColorStateList r1 = r1.f29925b
            if (r1 == 0) goto L_0x0052
            int r3 = r5.R
            int r1 = r1.getColorForState(r6, r3)
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            int r3 = r5.R
            if (r3 == r1) goto L_0x005a
            r5.R = r1
            r0 = 1
        L_0x005a:
            int[] r1 = r5.getState()
            r3 = 16842912(0x10100a0, float:2.3694006E-38)
            boolean r1 = b0(r1, r3)
            if (r1 == 0) goto L_0x006d
            boolean r1 = r5.f29718u
            if (r1 == 0) goto L_0x006d
            r1 = 1
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            boolean r3 = r5.S
            if (r3 == r1) goto L_0x0088
            android.graphics.drawable.Drawable r3 = r5.f29720w
            if (r3 == 0) goto L_0x0088
            float r0 = r5.d()
            r5.S = r1
            float r1 = r5.d()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0087
            r0 = 1
            r1 = 1
            goto L_0x0089
        L_0x0087:
            r0 = 1
        L_0x0088:
            r1 = 0
        L_0x0089:
            android.content.res.ColorStateList r3 = r5.X
            if (r3 == 0) goto L_0x0093
            int r2 = r5.T
            int r2 = r3.getColorForState(r6, r2)
        L_0x0093:
            int r3 = r5.T
            if (r3 == r2) goto L_0x00a4
            r5.T = r2
            android.content.res.ColorStateList r0 = r5.X
            android.graphics.PorterDuff$Mode r2 = r5.Y
            android.graphics.PorterDuffColorFilter r0 = com.google.android.material.drawable.DrawableUtils.a(r5, r0, r2)
            r5.W = r0
            goto L_0x00a5
        L_0x00a4:
            r4 = r0
        L_0x00a5:
            android.graphics.drawable.Drawable r0 = r5.f29710m
            boolean r0 = i0(r0)
            if (r0 == 0) goto L_0x00b4
            android.graphics.drawable.Drawable r0 = r5.f29710m
            boolean r0 = r0.setState(r6)
            r4 = r4 | r0
        L_0x00b4:
            android.graphics.drawable.Drawable r0 = r5.f29720w
            boolean r0 = i0(r0)
            if (r0 == 0) goto L_0x00c3
            android.graphics.drawable.Drawable r0 = r5.f29720w
            boolean r6 = r0.setState(r6)
            r4 = r4 | r6
        L_0x00c3:
            android.graphics.drawable.Drawable r6 = r5.f29714q
            boolean r6 = i0(r6)
            if (r6 == 0) goto L_0x00d2
            android.graphics.drawable.Drawable r6 = r5.f29714q
            boolean r6 = r6.setState(r7)
            r4 = r4 | r6
        L_0x00d2:
            if (r4 == 0) goto L_0x00d7
            r5.invalidateSelf()
        L_0x00d7:
            if (r1 == 0) goto L_0x00dc
            r5.l0()
        L_0x00dc:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipDrawable.m0(int[], int[]):boolean");
    }

    public static ChipDrawable n(Context context, AttributeSet attributeSet, int i2, int i3) {
        ChipDrawable chipDrawable = new ChipDrawable(context);
        chipDrawable.k0(attributeSet, i2, i3);
        return chipDrawable;
    }

    private void o(Canvas canvas, Rect rect) {
        if (A1()) {
            c(rect, this.M);
            RectF rectF = this.M;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.f29720w.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.f29720w.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void p(Canvas canvas, Rect rect) {
        this.J.setColor(this.O);
        this.J.setStyle(Paint.Style.FILL);
        this.J.setColorFilter(a0());
        this.M.set(rect);
        RectF rectF = this.M;
        float f2 = this.f29696d;
        canvas.drawRoundRect(rectF, f2, f2, this.J);
    }

    private void q(Canvas canvas, Rect rect) {
        if (B1()) {
            c(rect, this.M);
            RectF rectF = this.M;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.f29710m.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.f29710m.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void r(Canvas canvas, Rect rect) {
        if (this.f29700f > 0.0f) {
            this.J.setColor(this.P);
            this.J.setStyle(Paint.Style.STROKE);
            this.J.setColorFilter(a0());
            RectF rectF = this.M;
            float f2 = this.f29700f;
            rectF.set(((float) rect.left) + (f2 / 2.0f), ((float) rect.top) + (f2 / 2.0f), ((float) rect.right) - (f2 / 2.0f), ((float) rect.bottom) - (f2 / 2.0f));
            float f3 = this.f29696d - (this.f29700f / 2.0f);
            canvas.drawRoundRect(this.M, f3, f3, this.J);
        }
    }

    private void s(Canvas canvas, Rect rect) {
        if (C1()) {
            f(rect, this.M);
            RectF rectF = this.M;
            float f2 = rectF.left;
            float f3 = rectF.top;
            canvas.translate(f2, f3);
            this.f29714q.setBounds(0, 0, (int) this.M.width(), (int) this.M.height());
            this.f29714q.draw(canvas);
            canvas.translate(-f2, -f3);
        }
    }

    private void t(Canvas canvas, Rect rect) {
        this.J.setColor(this.Q);
        this.J.setStyle(Paint.Style.FILL);
        this.M.set(rect);
        RectF rectF = this.M;
        float f2 = this.f29696d;
        canvas.drawRoundRect(rectF, f2, f2, this.J);
    }

    private void u(Canvas canvas, Rect rect) {
        Paint paint = this.K;
        if (paint != null) {
            paint.setColor(ColorUtils.p(-16777216, 127));
            canvas.drawRect(rect, this.K);
            if (B1() || A1()) {
                c(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            if (this.f29706i != null) {
                canvas.drawLine((float) rect.left, rect.exactCenterY(), (float) rect.right, rect.exactCenterY(), this.K);
            }
            if (C1()) {
                f(rect, this.M);
                canvas.drawRect(this.M, this.K);
            }
            this.K.setColor(ColorUtils.p(-65536, 127));
            e(rect, this.M);
            canvas.drawRect(this.M, this.K);
            this.K.setColor(ColorUtils.p(-16711936, 127));
            g(rect, this.M);
            canvas.drawRect(this.M, this.K);
        }
    }

    private void v(Canvas canvas, Rect rect) {
        boolean z2;
        if (this.f29706i != null) {
            Paint.Align k2 = k(rect, this.N);
            i(rect, this.M);
            if (this.f29707j != null) {
                this.I.drawableState = getState();
                this.f29707j.g(this.H, this.I, this.f29708k);
            }
            this.I.setTextAlign(k2);
            int i2 = 0;
            if (Math.round(Z()) > Math.round(this.M.width())) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                i2 = canvas.save();
                canvas.clipRect(this.M);
            }
            CharSequence charSequence = this.f29706i;
            if (z2 && this.f29701f0 != null) {
                charSequence = TextUtils.ellipsize(charSequence, this.I, this.M.width(), this.f29701f0);
            }
            CharSequence charSequence2 = charSequence;
            int length = charSequence2.length();
            PointF pointF = this.N;
            canvas.drawText(charSequence2, 0, length, pointF.x, pointF.y, this.I);
            if (z2) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public Drawable A() {
        Drawable drawable = this.f29710m;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void A0(int i2) {
        z0(AppCompatResources.b(this.H, i2));
    }

    public float B() {
        return this.f29712o;
    }

    public void B0(float f2) {
        if (this.f29712o != f2) {
            float d2 = d();
            this.f29712o = f2;
            float d3 = d();
            invalidateSelf();
            if (d2 != d3) {
                l0();
            }
        }
    }

    public ColorStateList C() {
        return this.f29711n;
    }

    public void C0(int i2) {
        B0(this.H.getResources().getDimension(i2));
    }

    public float D() {
        return this.f29694c;
    }

    public void D0(ColorStateList colorStateList) {
        if (this.f29711n != colorStateList) {
            this.f29711n = colorStateList;
            if (B1()) {
                DrawableCompat.o(this.f29710m, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public float E() {
        return this.f29723z;
    }

    public void E0(int i2) {
        D0(AppCompatResources.a(this.H, i2));
    }

    public ColorStateList F() {
        return this.f29698e;
    }

    public void F0(int i2) {
        G0(this.H.getResources().getBoolean(i2));
    }

    public float G() {
        return this.f29700f;
    }

    public void G0(boolean z2) {
        boolean z3;
        if (this.f29709l != z2) {
            boolean B1 = B1();
            this.f29709l = z2;
            boolean B12 = B1();
            if (B1 != B12) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (B12) {
                    b(this.f29710m);
                } else {
                    D1(this.f29710m);
                }
                invalidateSelf();
                l0();
            }
        }
    }

    public Drawable H() {
        Drawable drawable = this.f29714q;
        if (drawable != null) {
            return DrawableCompat.q(drawable);
        }
        return null;
    }

    public void H0(float f2) {
        if (this.f29694c != f2) {
            this.f29694c = f2;
            invalidateSelf();
            l0();
        }
    }

    public CharSequence I() {
        return this.f29717t;
    }

    public void I0(int i2) {
        H0(this.H.getResources().getDimension(i2));
    }

    public float J() {
        return this.F;
    }

    public void J0(float f2) {
        if (this.f29723z != f2) {
            this.f29723z = f2;
            invalidateSelf();
            l0();
        }
    }

    public float K() {
        return this.f29716s;
    }

    public void K0(int i2) {
        J0(this.H.getResources().getDimension(i2));
    }

    public float L() {
        return this.E;
    }

    public void L0(ColorStateList colorStateList) {
        if (this.f29698e != colorStateList) {
            this.f29698e = colorStateList;
            onStateChange(getState());
        }
    }

    public int[] M() {
        return this.Z;
    }

    public void M0(int i2) {
        L0(AppCompatResources.a(this.H, i2));
    }

    public ColorStateList N() {
        return this.f29715r;
    }

    public void N0(float f2) {
        if (this.f29700f != f2) {
            this.f29700f = f2;
            this.J.setStrokeWidth(f2);
            invalidateSelf();
        }
    }

    public void O(RectF rectF) {
        g(getBounds(), rectF);
    }

    public void O0(int i2) {
        N0(this.H.getResources().getDimension(i2));
    }

    public TextUtils.TruncateAt P() {
        return this.f29701f0;
    }

    public void P0(Drawable drawable) {
        Drawable drawable2;
        Drawable H2 = H();
        if (H2 != drawable) {
            float h2 = h();
            if (drawable != null) {
                drawable2 = DrawableCompat.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f29714q = drawable2;
            float h3 = h();
            D1(H2);
            if (C1()) {
                b(this.f29714q);
            }
            invalidateSelf();
            if (h2 != h3) {
                l0();
            }
        }
    }

    public MotionSpec Q() {
        return this.f29722y;
    }

    public void Q0(CharSequence charSequence) {
        if (this.f29717t != charSequence) {
            this.f29717t = BidiFormatter.c().h(charSequence);
            invalidateSelf();
        }
    }

    public float R() {
        return this.B;
    }

    public void R0(float f2) {
        if (this.F != f2) {
            this.F = f2;
            invalidateSelf();
            if (C1()) {
                l0();
            }
        }
    }

    public float S() {
        return this.A;
    }

    public void S0(int i2) {
        R0(this.H.getResources().getDimension(i2));
    }

    public ColorStateList T() {
        return this.f29702g;
    }

    public void T0(int i2) {
        P0(AppCompatResources.b(this.H, i2));
    }

    public MotionSpec U() {
        return this.f29721x;
    }

    public void U0(float f2) {
        if (this.f29716s != f2) {
            this.f29716s = f2;
            invalidateSelf();
            if (C1()) {
                l0();
            }
        }
    }

    public CharSequence V() {
        return this.f29704h;
    }

    public void V0(int i2) {
        U0(this.H.getResources().getDimension(i2));
    }

    public TextAppearance W() {
        return this.f29707j;
    }

    public void W0(float f2) {
        if (this.E != f2) {
            this.E = f2;
            invalidateSelf();
            if (C1()) {
                l0();
            }
        }
    }

    public float X() {
        return this.D;
    }

    public void X0(int i2) {
        W0(this.H.getResources().getDimension(i2));
    }

    public float Y() {
        return this.C;
    }

    public boolean Y0(int[] iArr) {
        if (Arrays.equals(this.Z, iArr)) {
            return false;
        }
        this.Z = iArr;
        if (C1()) {
            return m0(getState(), iArr);
        }
        return false;
    }

    public void Z0(ColorStateList colorStateList) {
        if (this.f29715r != colorStateList) {
            this.f29715r = colorStateList;
            if (C1()) {
                DrawableCompat.o(this.f29714q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void a1(int i2) {
        Z0(AppCompatResources.a(this.H, i2));
    }

    public void b1(int i2) {
        c1(this.H.getResources().getBoolean(i2));
    }

    public boolean c0() {
        return this.f29718u;
    }

    public void c1(boolean z2) {
        boolean z3;
        if (this.f29713p != z2) {
            boolean C1 = C1();
            this.f29713p = z2;
            boolean C12 = C1();
            if (C1 != C12) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (C12) {
                    b(this.f29714q);
                } else {
                    D1(this.f29714q);
                }
                invalidateSelf();
                l0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float d() {
        if (B1() || A1()) {
            return this.A + this.f29712o + this.B;
        }
        return 0.0f;
    }

    public boolean d0() {
        return this.f29719v;
    }

    public void d1(Delegate delegate) {
        this.f29695c0 = new WeakReference<>(delegate);
    }

    public void draw(Canvas canvas) {
        int i2;
        Rect bounds = getBounds();
        if (!bounds.isEmpty() && getAlpha() != 0) {
            int i3 = this.U;
            if (i3 < 255) {
                i2 = CanvasCompat.a(canvas, (float) bounds.left, (float) bounds.top, (float) bounds.right, (float) bounds.bottom, i3);
            } else {
                i2 = 0;
            }
            p(canvas, bounds);
            r(canvas, bounds);
            t(canvas, bounds);
            q(canvas, bounds);
            o(canvas, bounds);
            if (this.f29703g0) {
                v(canvas, bounds);
            }
            s(canvas, bounds);
            u(canvas, bounds);
            if (this.U < 255) {
                canvas.restoreToCount(i2);
            }
        }
    }

    public boolean e0() {
        return this.f29709l;
    }

    public void e1(TextUtils.TruncateAt truncateAt) {
        this.f29701f0 = truncateAt;
    }

    public boolean f0() {
        return i0(this.f29714q);
    }

    public void f1(MotionSpec motionSpec) {
        this.f29722y = motionSpec;
    }

    public boolean g0() {
        return this.f29713p;
    }

    public void g1(int i2) {
        f1(MotionSpec.c(this.H, i2));
    }

    public int getAlpha() {
        return this.U;
    }

    public ColorFilter getColorFilter() {
        return this.V;
    }

    public int getIntrinsicHeight() {
        return (int) this.f29694c;
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f29723z + d() + this.C + Z() + this.D + h() + this.G), this.f29705h0);
    }

    public int getOpacity() {
        return -3;
    }

    @TargetApi(21)
    public void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.f29696d);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f29696d);
        }
        outline.setAlpha(((float) getAlpha()) / 255.0f);
    }

    public void h1(float f2) {
        if (this.B != f2) {
            float d2 = d();
            this.B = f2;
            float d3 = d();
            invalidateSelf();
            if (d2 != d3) {
                l0();
            }
        }
    }

    public void i1(int i2) {
        h1(this.H.getResources().getDimension(i2));
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    public boolean isStateful() {
        if (h0(this.f29692b) || h0(this.f29698e) || ((this.f29691a0 && h0(this.f29693b0)) || j0(this.f29707j) || m() || i0(this.f29710m) || i0(this.f29720w) || h0(this.X))) {
            return true;
        }
        return false;
    }

    public void j1(float f2) {
        if (this.A != f2) {
            float d2 = d();
            this.A = f2;
            float d3 = d();
            invalidateSelf();
            if (d2 != d3) {
                l0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Paint.Align k(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f29706i != null) {
            float d2 = this.f29723z + d() + this.C;
            if (DrawableCompat.f(this) == 0) {
                pointF.x = ((float) rect.left) + d2;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = ((float) rect.right) - d2;
                align = Paint.Align.RIGHT;
            }
            pointF.y = ((float) rect.centerY()) - j();
        }
        return align;
    }

    public void k1(int i2) {
        j1(this.H.getResources().getDimension(i2));
    }

    /* access modifiers changed from: protected */
    public void l0() {
        Delegate delegate = this.f29695c0.get();
        if (delegate != null) {
            delegate.a();
        }
    }

    public void l1(int i2) {
        this.f29705h0 = i2;
    }

    public void m1(ColorStateList colorStateList) {
        if (this.f29702g != colorStateList) {
            this.f29702g = colorStateList;
            E1();
            onStateChange(getState());
        }
    }

    public void n0(boolean z2) {
        if (this.f29718u != z2) {
            this.f29718u = z2;
            float d2 = d();
            if (!z2 && this.S) {
                this.S = false;
            }
            float d3 = d();
            invalidateSelf();
            if (d2 != d3) {
                l0();
            }
        }
    }

    public void n1(int i2) {
        m1(AppCompatResources.a(this.H, i2));
    }

    public void o0(int i2) {
        n0(this.H.getResources().getBoolean(i2));
    }

    /* access modifiers changed from: package-private */
    public void o1(boolean z2) {
        this.f29703g0 = z2;
    }

    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i2) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i2);
        if (B1()) {
            onLayoutDirectionChanged |= this.f29710m.setLayoutDirection(i2);
        }
        if (A1()) {
            onLayoutDirectionChanged |= this.f29720w.setLayoutDirection(i2);
        }
        if (C1()) {
            onLayoutDirectionChanged |= this.f29714q.setLayoutDirection(i2);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        boolean onLevelChange = super.onLevelChange(i2);
        if (B1()) {
            onLevelChange |= this.f29710m.setLevel(i2);
        }
        if (A1()) {
            onLevelChange |= this.f29720w.setLevel(i2);
        }
        if (C1()) {
            onLevelChange |= this.f29714q.setLevel(i2);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return m0(iArr, M());
    }

    public void p0(Drawable drawable) {
        if (this.f29720w != drawable) {
            float d2 = d();
            this.f29720w = drawable;
            float d3 = d();
            D1(this.f29720w);
            b(this.f29720w);
            invalidateSelf();
            if (d2 != d3) {
                l0();
            }
        }
    }

    public void p1(MotionSpec motionSpec) {
        this.f29721x = motionSpec;
    }

    public void q0(int i2) {
        p0(AppCompatResources.b(this.H, i2));
    }

    public void q1(int i2) {
        p1(MotionSpec.c(this.H, i2));
    }

    public void r0(int i2) {
        s0(this.H.getResources().getBoolean(i2));
    }

    public void r1(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.f29704h != charSequence) {
            this.f29704h = charSequence;
            this.f29706i = BidiFormatter.c().h(charSequence);
            this.f29697d0 = true;
            invalidateSelf();
            l0();
        }
    }

    public void s0(boolean z2) {
        boolean z3;
        if (this.f29719v != z2) {
            boolean A1 = A1();
            this.f29719v = z2;
            boolean A12 = A1();
            if (A1 != A12) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                if (A12) {
                    b(this.f29720w);
                } else {
                    D1(this.f29720w);
                }
                invalidateSelf();
                l0();
            }
        }
    }

    public void s1(TextAppearance textAppearance) {
        if (this.f29707j != textAppearance) {
            this.f29707j = textAppearance;
            if (textAppearance != null) {
                textAppearance.h(this.H, this.I, this.f29708k);
                this.f29697d0 = true;
            }
            onStateChange(getState());
            l0();
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (this.U != i2) {
            this.U = i2;
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.V != colorFilter) {
            this.V = colorFilter;
            invalidateSelf();
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            onStateChange(getState());
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.Y != mode) {
            this.Y = mode;
            this.W = DrawableUtils.a(this, this.X, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        if (B1()) {
            visible |= this.f29710m.setVisible(z2, z3);
        }
        if (A1()) {
            visible |= this.f29720w.setVisible(z2, z3);
        }
        if (C1()) {
            visible |= this.f29714q.setVisible(z2, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public void t0(ColorStateList colorStateList) {
        if (this.f29692b != colorStateList) {
            this.f29692b = colorStateList;
            onStateChange(getState());
        }
    }

    public void t1(int i2) {
        s1(new TextAppearance(this.H, i2));
    }

    public void u0(int i2) {
        t0(AppCompatResources.a(this.H, i2));
    }

    public void u1(float f2) {
        if (this.D != f2) {
            this.D = f2;
            invalidateSelf();
            l0();
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public void v0(float f2) {
        if (this.f29696d != f2) {
            this.f29696d = f2;
            invalidateSelf();
        }
    }

    public void v1(int i2) {
        u1(this.H.getResources().getDimension(i2));
    }

    public Drawable w() {
        return this.f29720w;
    }

    public void w0(int i2) {
        v0(this.H.getResources().getDimension(i2));
    }

    public void w1(float f2) {
        if (this.C != f2) {
            this.C = f2;
            invalidateSelf();
            l0();
        }
    }

    public ColorStateList x() {
        return this.f29692b;
    }

    public void x0(float f2) {
        if (this.G != f2) {
            this.G = f2;
            invalidateSelf();
            l0();
        }
    }

    public void x1(int i2) {
        w1(this.H.getResources().getDimension(i2));
    }

    public float y() {
        return this.f29696d;
    }

    public void y0(int i2) {
        x0(this.H.getResources().getDimension(i2));
    }

    public void y1(boolean z2) {
        if (this.f29691a0 != z2) {
            this.f29691a0 = z2;
            E1();
            onStateChange(getState());
        }
    }

    public float z() {
        return this.G;
    }

    public void z0(Drawable drawable) {
        Drawable drawable2;
        Drawable A2 = A();
        if (A2 != drawable) {
            float d2 = d();
            if (drawable != null) {
                drawable2 = DrawableCompat.r(drawable).mutate();
            } else {
                drawable2 = null;
            }
            this.f29710m = drawable2;
            float d3 = d();
            D1(A2);
            if (B1()) {
                b(this.f29710m);
            }
            invalidateSelf();
            if (d2 != d3) {
                l0();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean z1() {
        return this.f29703g0;
    }
}
