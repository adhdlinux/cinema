package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatButton extends Button implements TintableCompoundDrawablesView {

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1099b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatTextHelper f1100c;

    /* renamed from: d  reason: collision with root package name */
    private AppCompatEmojiTextHelper f1101d;

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f106q);
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.f1101d == null) {
            this.f1101d = new AppCompatEmojiTextHelper(this);
        }
        return this.f1101d;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f1552b) {
            return super.getAutoSizeMaxTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f1552b) {
            return super.getAutoSizeMinTextSize();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f1552b) {
            return super.getAutoSizeStepGranularity();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f1552b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.h();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!ViewUtils.f1552b) {
            AppCompatTextHelper appCompatTextHelper = this.f1100c;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.i();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1100c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1100c.k();
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.o(z2, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        boolean z2;
        super.onTextChanged(charSequence, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper == null || ViewUtils.f1552b || !appCompatTextHelper.l()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            this.f1100c.c();
        }
    }

    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (ViewUtils.f1552b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.t(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (ViewUtils.f1552b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.u(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (ViewUtils.f1552b) {
            super.setAutoSizeTextTypeWithDefaults(i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.v(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportAllCaps(boolean z2) {
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.s(z2);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1099b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1100c.w(colorStateList);
        this.f1100c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1100c.x(mode);
        this.f1100c.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i2);
        }
    }

    public void setTextSize(int i2, float f2) {
        if (ViewUtils.f1552b) {
            super.setTextSize(i2, f2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.f1100c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.A(i2, f2);
        }
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1099b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1100c = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        getEmojiTextViewHelper().c(attributeSet, i2);
    }
}
