package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;

public class AppCompatImageHelper {

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f1139a;

    /* renamed from: b  reason: collision with root package name */
    private TintInfo f1140b;

    /* renamed from: c  reason: collision with root package name */
    private TintInfo f1141c;

    /* renamed from: d  reason: collision with root package name */
    private TintInfo f1142d;

    /* renamed from: e  reason: collision with root package name */
    private int f1143e = 0;

    public AppCompatImageHelper(ImageView imageView) {
        this.f1139a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f1142d == null) {
            this.f1142d = new TintInfo();
        }
        TintInfo tintInfo = this.f1142d;
        tintInfo.a();
        ColorStateList a2 = ImageViewCompat.a(this.f1139a);
        if (a2 != null) {
            tintInfo.f1464d = true;
            tintInfo.f1461a = a2;
        }
        PorterDuff.Mode b2 = ImageViewCompat.b(this.f1139a);
        if (b2 != null) {
            tintInfo.f1463c = true;
            tintInfo.f1462b = b2;
        }
        if (!tintInfo.f1464d && !tintInfo.f1463c) {
            return false;
        }
        AppCompatDrawableManager.i(drawable, tintInfo, this.f1139a.getDrawableState());
        return true;
    }

    private boolean l() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 21) {
            if (this.f1140b != null) {
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
        if (this.f1139a.getDrawable() != null) {
            this.f1139a.getDrawable().setLevel(this.f1143e);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable drawable = this.f1139a.getDrawable();
        if (drawable != null) {
            DrawableUtils.b(drawable);
        }
        if (drawable == null) {
            return;
        }
        if (!l() || !a(drawable)) {
            TintInfo tintInfo = this.f1141c;
            if (tintInfo != null) {
                AppCompatDrawableManager.i(drawable, tintInfo, this.f1139a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f1140b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.i(drawable, tintInfo2, this.f1139a.getDrawableState());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ColorStateList d() {
        TintInfo tintInfo = this.f1141c;
        if (tintInfo != null) {
            return tintInfo.f1461a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode e() {
        TintInfo tintInfo = this.f1141c;
        if (tintInfo != null) {
            return tintInfo.f1462b;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (this.f1139a.getBackground() instanceof RippleDrawable) {
            return false;
        }
        return true;
    }

    public void g(AttributeSet attributeSet, int i2) {
        int n2;
        Context context = this.f1139a.getContext();
        int[] iArr = R$styleable.R;
        TintTypedArray v2 = TintTypedArray.v(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.f1139a;
        ViewCompat.p0(imageView, imageView.getContext(), iArr, attributeSet, v2.r(), i2, 0);
        try {
            Drawable drawable = this.f1139a.getDrawable();
            if (!(drawable != null || (n2 = v2.n(R$styleable.S, -1)) == -1 || (drawable = AppCompatResources.b(this.f1139a.getContext(), n2)) == null)) {
                this.f1139a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                DrawableUtils.b(drawable);
            }
            int i3 = R$styleable.T;
            if (v2.s(i3)) {
                ImageViewCompat.c(this.f1139a, v2.c(i3));
            }
            int i4 = R$styleable.U;
            if (v2.s(i4)) {
                ImageViewCompat.d(this.f1139a, DrawableUtils.e(v2.k(i4, -1), (PorterDuff.Mode) null));
            }
        } finally {
            v2.w();
        }
    }

    /* access modifiers changed from: package-private */
    public void h(Drawable drawable) {
        this.f1143e = drawable.getLevel();
    }

    public void i(int i2) {
        if (i2 != 0) {
            Drawable b2 = AppCompatResources.b(this.f1139a.getContext(), i2);
            if (b2 != null) {
                DrawableUtils.b(b2);
            }
            this.f1139a.setImageDrawable(b2);
        } else {
            this.f1139a.setImageDrawable((Drawable) null);
        }
        c();
    }

    /* access modifiers changed from: package-private */
    public void j(ColorStateList colorStateList) {
        if (this.f1141c == null) {
            this.f1141c = new TintInfo();
        }
        TintInfo tintInfo = this.f1141c;
        tintInfo.f1461a = colorStateList;
        tintInfo.f1464d = true;
        c();
    }

    /* access modifiers changed from: package-private */
    public void k(PorterDuff.Mode mode) {
        if (this.f1141c == null) {
            this.f1141c = new TintInfo();
        }
        TintInfo tintInfo = this.f1141c;
        tintInfo.f1462b = mode;
        tintInfo.f1463c = true;
        c();
    }
}
