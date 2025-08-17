package com.google.android.material.button;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;

class MaterialButtonHelper {

    /* renamed from: w  reason: collision with root package name */
    private static final boolean f29645w = true;

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f29646a;

    /* renamed from: b  reason: collision with root package name */
    private int f29647b;

    /* renamed from: c  reason: collision with root package name */
    private int f29648c;

    /* renamed from: d  reason: collision with root package name */
    private int f29649d;

    /* renamed from: e  reason: collision with root package name */
    private int f29650e;

    /* renamed from: f  reason: collision with root package name */
    private int f29651f;

    /* renamed from: g  reason: collision with root package name */
    private int f29652g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f29653h;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f29654i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f29655j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f29656k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f29657l = new Paint(1);

    /* renamed from: m  reason: collision with root package name */
    private final Rect f29658m = new Rect();

    /* renamed from: n  reason: collision with root package name */
    private final RectF f29659n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    private GradientDrawable f29660o;

    /* renamed from: p  reason: collision with root package name */
    private Drawable f29661p;

    /* renamed from: q  reason: collision with root package name */
    private GradientDrawable f29662q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f29663r;

    /* renamed from: s  reason: collision with root package name */
    private GradientDrawable f29664s;

    /* renamed from: t  reason: collision with root package name */
    private GradientDrawable f29665t;

    /* renamed from: u  reason: collision with root package name */
    private GradientDrawable f29666u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f29667v = false;

    public MaterialButtonHelper(MaterialButton materialButton) {
        this.f29646a = materialButton;
    }

    private Drawable a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f29660o = gradientDrawable;
        gradientDrawable.setCornerRadius(((float) this.f29651f) + 1.0E-5f);
        this.f29660o.setColor(-1);
        Drawable r2 = DrawableCompat.r(this.f29660o);
        this.f29661p = r2;
        DrawableCompat.o(r2, this.f29654i);
        PorterDuff.Mode mode = this.f29653h;
        if (mode != null) {
            DrawableCompat.p(this.f29661p, mode);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f29662q = gradientDrawable2;
        gradientDrawable2.setCornerRadius(((float) this.f29651f) + 1.0E-5f);
        this.f29662q.setColor(-1);
        Drawable r3 = DrawableCompat.r(this.f29662q);
        this.f29663r = r3;
        DrawableCompat.o(r3, this.f29656k);
        return x(new LayerDrawable(new Drawable[]{this.f29661p, this.f29663r}));
    }

    @TargetApi(21)
    private Drawable b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.f29664s = gradientDrawable;
        gradientDrawable.setCornerRadius(((float) this.f29651f) + 1.0E-5f);
        this.f29664s.setColor(-1);
        w();
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        this.f29665t = gradientDrawable2;
        gradientDrawable2.setCornerRadius(((float) this.f29651f) + 1.0E-5f);
        this.f29665t.setColor(0);
        this.f29665t.setStroke(this.f29652g, this.f29655j);
        InsetDrawable x2 = x(new LayerDrawable(new Drawable[]{this.f29664s, this.f29665t}));
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        this.f29666u = gradientDrawable3;
        gradientDrawable3.setCornerRadius(((float) this.f29651f) + 1.0E-5f);
        this.f29666u.setColor(-1);
        return new MaterialButtonBackgroundDrawable(RippleUtils.a(this.f29656k), x2, this.f29666u);
    }

    private GradientDrawable s() {
        if (!f29645w || this.f29646a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f29646a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }

    private GradientDrawable t() {
        if (!f29645w || this.f29646a.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f29646a.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    private void v() {
        boolean z2 = f29645w;
        if (z2 && this.f29665t != null) {
            this.f29646a.setInternalBackground(b());
        } else if (!z2) {
            this.f29646a.invalidate();
        }
    }

    private void w() {
        GradientDrawable gradientDrawable = this.f29664s;
        if (gradientDrawable != null) {
            DrawableCompat.o(gradientDrawable, this.f29654i);
            PorterDuff.Mode mode = this.f29653h;
            if (mode != null) {
                DrawableCompat.p(this.f29664s, mode);
            }
        }
    }

    private InsetDrawable x(Drawable drawable) {
        return new InsetDrawable(drawable, this.f29647b, this.f29649d, this.f29648c, this.f29650e);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.f29651f;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList d() {
        return this.f29656k;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList e() {
        return this.f29655j;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f29652g;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList g() {
        return this.f29654i;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode h() {
        return this.f29653h;
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.f29667v;
    }

    public void j(TypedArray typedArray) {
        Drawable drawable;
        int i2 = 0;
        this.f29647b = typedArray.getDimensionPixelOffset(R$styleable.O1, 0);
        this.f29648c = typedArray.getDimensionPixelOffset(R$styleable.P1, 0);
        this.f29649d = typedArray.getDimensionPixelOffset(R$styleable.Q1, 0);
        this.f29650e = typedArray.getDimensionPixelOffset(R$styleable.R1, 0);
        this.f29651f = typedArray.getDimensionPixelSize(R$styleable.U1, 0);
        this.f29652g = typedArray.getDimensionPixelSize(R$styleable.d2, 0);
        this.f29653h = ViewUtils.b(typedArray.getInt(R$styleable.T1, -1), PorterDuff.Mode.SRC_IN);
        this.f29654i = MaterialResources.a(this.f29646a.getContext(), typedArray, R$styleable.S1);
        this.f29655j = MaterialResources.a(this.f29646a.getContext(), typedArray, R$styleable.c2);
        this.f29656k = MaterialResources.a(this.f29646a.getContext(), typedArray, R$styleable.b2);
        this.f29657l.setStyle(Paint.Style.STROKE);
        this.f29657l.setStrokeWidth((float) this.f29652g);
        Paint paint = this.f29657l;
        ColorStateList colorStateList = this.f29655j;
        if (colorStateList != null) {
            i2 = colorStateList.getColorForState(this.f29646a.getDrawableState(), 0);
        }
        paint.setColor(i2);
        int I = ViewCompat.I(this.f29646a);
        int paddingTop = this.f29646a.getPaddingTop();
        int H = ViewCompat.H(this.f29646a);
        int paddingBottom = this.f29646a.getPaddingBottom();
        MaterialButton materialButton = this.f29646a;
        if (f29645w) {
            drawable = b();
        } else {
            drawable = a();
        }
        materialButton.setInternalBackground(drawable);
        ViewCompat.H0(this.f29646a, I + this.f29647b, paddingTop + this.f29649d, H + this.f29648c, paddingBottom + this.f29650e);
    }

    /* access modifiers changed from: package-private */
    public void k(int i2) {
        GradientDrawable gradientDrawable;
        GradientDrawable gradientDrawable2;
        boolean z2 = f29645w;
        if (z2 && (gradientDrawable2 = this.f29664s) != null) {
            gradientDrawable2.setColor(i2);
        } else if (!z2 && (gradientDrawable = this.f29660o) != null) {
            gradientDrawable.setColor(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f29667v = true;
        this.f29646a.setSupportBackgroundTintList(this.f29654i);
        this.f29646a.setSupportBackgroundTintMode(this.f29653h);
    }

    /* access modifiers changed from: package-private */
    public void m(int i2) {
        GradientDrawable gradientDrawable;
        if (this.f29651f != i2) {
            this.f29651f = i2;
            boolean z2 = f29645w;
            if (z2 && this.f29664s != null && this.f29665t != null && this.f29666u != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f2 = ((float) i2) + 1.0E-5f;
                    s().setCornerRadius(f2);
                    t().setCornerRadius(f2);
                }
                float f3 = ((float) i2) + 1.0E-5f;
                this.f29664s.setCornerRadius(f3);
                this.f29665t.setCornerRadius(f3);
                this.f29666u.setCornerRadius(f3);
            } else if (!z2 && (gradientDrawable = this.f29660o) != null && this.f29662q != null) {
                float f4 = ((float) i2) + 1.0E-5f;
                gradientDrawable.setCornerRadius(f4);
                this.f29662q.setCornerRadius(f4);
                this.f29646a.invalidate();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void n(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f29656k != colorStateList) {
            this.f29656k = colorStateList;
            boolean z2 = f29645w;
            if (z2 && (this.f29646a.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f29646a.getBackground()).setColor(colorStateList);
            } else if (!z2 && (drawable = this.f29663r) != null) {
                DrawableCompat.o(drawable, colorStateList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(ColorStateList colorStateList) {
        if (this.f29655j != colorStateList) {
            this.f29655j = colorStateList;
            Paint paint = this.f29657l;
            int i2 = 0;
            if (colorStateList != null) {
                i2 = colorStateList.getColorForState(this.f29646a.getDrawableState(), 0);
            }
            paint.setColor(i2);
            v();
        }
    }

    /* access modifiers changed from: package-private */
    public void p(int i2) {
        if (this.f29652g != i2) {
            this.f29652g = i2;
            this.f29657l.setStrokeWidth((float) i2);
            v();
        }
    }

    /* access modifiers changed from: package-private */
    public void q(ColorStateList colorStateList) {
        if (this.f29654i != colorStateList) {
            this.f29654i = colorStateList;
            if (f29645w) {
                w();
                return;
            }
            Drawable drawable = this.f29661p;
            if (drawable != null) {
                DrawableCompat.o(drawable, colorStateList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void r(PorterDuff.Mode mode) {
        if (this.f29653h != mode) {
            this.f29653h = mode;
            if (f29645w) {
                w();
                return;
            }
            Drawable drawable = this.f29661p;
            if (drawable != null && mode != null) {
                DrawableCompat.p(drawable, mode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void u(int i2, int i3) {
        GradientDrawable gradientDrawable = this.f29666u;
        if (gradientDrawable != null) {
            gradientDrawable.setBounds(this.f29647b, this.f29649d, i3 - this.f29648c, i2 - this.f29650e);
        }
    }
}
