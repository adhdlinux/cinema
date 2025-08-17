package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

class AppCompatBackgroundHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f1093a;

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatDrawableManager f1094b;

    /* renamed from: c  reason: collision with root package name */
    private int f1095c = -1;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f1096d;

    /* renamed from: e  reason: collision with root package name */
    private TintInfo f1097e;

    /* renamed from: f  reason: collision with root package name */
    private TintInfo f1098f;

    AppCompatBackgroundHelper(View view) {
        this.f1093a = view;
        this.f1094b = AppCompatDrawableManager.b();
    }

    private boolean a(Drawable drawable) {
        if (this.f1098f == null) {
            this.f1098f = new TintInfo();
        }
        TintInfo tintInfo = this.f1098f;
        tintInfo.a();
        ColorStateList t2 = ViewCompat.t(this.f1093a);
        if (t2 != null) {
            tintInfo.f1464d = true;
            tintInfo.f1461a = t2;
        }
        PorterDuff.Mode u2 = ViewCompat.u(this.f1093a);
        if (u2 != null) {
            tintInfo.f1463c = true;
            tintInfo.f1462b = u2;
        }
        if (!tintInfo.f1464d && !tintInfo.f1463c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1093a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 21) {
            if (this.f1096d != null) {
                return true;
            }
            return false;
        } else if (i2 == 21) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        Drawable background = this.f1093a.getBackground();
        if (background == null) {
            return;
        }
        if (!k() || !a(background)) {
            TintInfo tintInfo = this.f1097e;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(background, tintInfo, this.f1093a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1096d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(background, tintInfo2, this.f1093a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList c() {
        TintInfo tintInfo = this.f1097e;
        if (tintInfo != null) {
            return tintInfo.f1461a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode d() {
        TintInfo tintInfo = this.f1097e;
        if (tintInfo != null) {
            return tintInfo.f1462b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void e(AttributeSet attributeSet, int i2) {
        Context context = this.f1093a.getContext();
        int[] iArr = R$styleable.a4;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, iArr, i2, 0);
        View view = this.f1093a;
        ViewCompat.p0(view, view.getContext(), iArr, attributeSet, v2.r(), i2, 0);
        try {
            int i3 = R$styleable.b4;
            if (v2.s(i3)) {
                this.f1095c = v2.n(i3, -1);
                ColorStateList f2 = this.f1094b.f(this.f1093a.getContext(), this.f1095c);
                if (f2 != null) {
                    h(f2);
                }
            }
            int i4 = R$styleable.c4;
            if (v2.s(i4)) {
                ViewCompat.w0(this.f1093a, v2.c(i4));
            }
            int i5 = R$styleable.d4;
            if (v2.s(i5)) {
                ViewCompat.x0(this.f1093a, DrawableUtils.e(v2.k(i5, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v2.w();
        }
    }

    /* access modifiers changed from: package-private */
    public void f(Drawable drawable) {
        this.f1095c = -1;
        h((ColorStateList) null);
        b();
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        ColorStateList colorStateList;
        this.f1095c = i2;
        AppCompatDrawableManager appCompatDrawableManager = this.f1094b;
        if (appCompatDrawableManager != null) {
            colorStateList = appCompatDrawableManager.f(this.f1093a.getContext(), i2);
        } else {
            colorStateList = null;
        }
        h(colorStateList);
        b();
    }

    /* access modifiers changed from: package-private */
    public void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1096d == null) {
                this.f1096d = new TintInfo();
            }
            TintInfo tintInfo = this.f1096d;
            tintInfo.f1461a = colorStateList;
            tintInfo.f1464d = true;
        } else {
            this.f1096d = null;
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public void i(ColorStateList colorStateList) {
        if (this.f1097e == null) {
            this.f1097e = new TintInfo();
        }
        TintInfo tintInfo = this.f1097e;
        tintInfo.f1461a = colorStateList;
        tintInfo.f1464d = true;
        b();
    }

    /* access modifiers changed from: package-private */
    public void j(PorterDuff.Mode mode) {
        if (this.f1097e == null) {
            this.f1097e = new TintInfo();
        }
        TintInfo tintInfo = this.f1097e;
        tintInfo.f1462b = mode;
        tintInfo.f1463c = true;
        b();
    }
}
