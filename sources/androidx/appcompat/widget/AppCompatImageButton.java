package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;

public class AppCompatImageButton extends ImageButton {

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1136b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatImageHelper f1137c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1138d;

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.G);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            return appCompatImageHelper.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            return appCompatImageHelper.e();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        return this.f1137c.f() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (!(appCompatImageHelper == null || drawable == null || this.f1138d)) {
            appCompatImageHelper.h(drawable);
        }
        super.setImageDrawable(drawable);
        AppCompatImageHelper appCompatImageHelper2 = this.f1137c;
        if (appCompatImageHelper2 != null) {
            appCompatImageHelper2.c();
            if (!this.f1138d) {
                this.f1137c.b();
            }
        }
    }

    public void setImageLevel(int i2) {
        super.setImageLevel(i2);
        this.f1138d = true;
    }

    public void setImageResource(int i2) {
        this.f1137c.i(i2);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1136b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.f1137c;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.k(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        this.f1138d = false;
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1136b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.f1137c = appCompatImageHelper;
        appCompatImageHelper.g(attributeSet, i2);
    }
}
