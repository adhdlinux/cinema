package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatCheckedTextView extends CheckedTextView implements TintableCompoundDrawablesView {

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatCheckedTextViewHelper f1106b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1107c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCompatTextHelper f1108d;

    /* renamed from: e  reason: collision with root package name */
    private AppCompatEmojiTextHelper f1109e;

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f108s);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1109e == null) {
            this.f1109e = new AppCompatEmojiTextHelper(this);
        }
        return this.f1109e;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatTextHelper appCompatTextHelper = this.f1108d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1106b;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.a();
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCheckMarkTintList() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1106b;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1106b;
        if (appCompatCheckedTextViewHelper != null) {
            return appCompatCheckedTextViewHelper.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1108d.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1108d.k();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return AppCompatHintHelper.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1106b;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.e();
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1108d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1108d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1107c;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1106b;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.f(colorStateList);
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = this.f1106b;
        if (appCompatCheckedTextViewHelper != null) {
            appCompatCheckedTextViewHelper.g(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1108d.w(colorStateList);
        this.f1108d.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1108d.x(mode);
        this.f1108d.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.f1108d;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i2);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1108d = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1107c = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatCheckedTextViewHelper appCompatCheckedTextViewHelper = new AppCompatCheckedTextViewHelper(this);
        this.f1106b = appCompatCheckedTextViewHelper;
        appCompatCheckedTextViewHelper.d(attributeSet, i2);
        getEmojiTextViewHelper().c(attributeSet, i2);
    }

    public void setCheckMarkDrawable(int i2) {
        setCheckMarkDrawable(AppCompatResources.b(getContext(), i2));
    }
}
