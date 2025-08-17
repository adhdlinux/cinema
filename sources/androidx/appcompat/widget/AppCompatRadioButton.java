package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatRadioButton extends RadioButton implements TintableCompoundDrawablesView {

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatCompoundButtonHelper f1156b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1157c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCompatTextHelper f1158d;

    /* renamed from: e  reason: collision with root package name */
    private AppCompatEmojiTextHelper f1159e;

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.L);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1159e == null) {
            this.f1159e = new AppCompatEmojiTextHelper(this);
        }
        return this.f1159e;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1158d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1156b;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.b(compoundPaddingLeft);
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1156b;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1156b;
        if (appCompatCompoundButtonHelper != null) {
            return appCompatCompoundButtonHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1158d.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1158d.k();
    }

    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1156b;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.f();
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1158d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1158d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1157c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1156b;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.g(colorStateList);
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = this.f1156b;
        if (appCompatCompoundButtonHelper != null) {
            appCompatCompoundButtonHelper.h(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1158d.w(colorStateList);
        this.f1158d.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1158d.x(mode);
        this.f1158d.b();
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatCompoundButtonHelper appCompatCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
        this.f1156b = appCompatCompoundButtonHelper;
        appCompatCompoundButtonHelper.e(attributeSet, i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1157c = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1158d = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        getEmojiTextViewHelper().c(attributeSet, i2);
    }

    public void setButtonDrawable(int i2) {
        setButtonDrawable(AppCompatResources.b(getContext(), i2));
    }
}
