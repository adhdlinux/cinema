package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TintableCompoundDrawablesView;

public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableCompoundDrawablesView {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f1147e = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final AppCompatBackgroundHelper f1148b;

    /* renamed from: c  reason: collision with root package name */
    private final AppCompatTextHelper f1149c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCompatEmojiEditTextHelper f1150d;

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.f105p);
    }

    /* access modifiers changed from: package-private */
    public void a(AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper) {
        KeyListener keyListener = getKeyListener();
        if (appCompatEmojiEditTextHelper.b(keyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener a2 = appCompatEmojiEditTextHelper.a(keyListener);
            if (a2 != keyListener) {
                super.setKeyListener(a2);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.f1149c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f1149c.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f1149c.k();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return this.f1150d.e(AppCompatHintHelper.a(super.onCreateInputConnection(editorInfo), editorInfo, this), editorInfo);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1149c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.f1149c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setDropDownBackgroundResource(int i2) {
        setDropDownBackgroundDrawable(AppCompatResources.b(getContext(), i2));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        this.f1150d.f(z2);
    }

    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.f1150d.a(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f1148b;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.f1149c.w(colorStateList);
        this.f1149c.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.f1149c.x(mode);
        this.f1149c.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.f1149c;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i2);
        }
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        ThemeUtils.a(this, getContext());
        TintTypedArray v2 = TintTypedArray.v(getContext(), attributeSet, f1147e, i2, 0);
        if (v2.s(0)) {
            setDropDownBackgroundDrawable(v2.g(0));
        }
        v2.w();
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.f1148b = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.f1149c = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        AppCompatEmojiEditTextHelper appCompatEmojiEditTextHelper = new AppCompatEmojiEditTextHelper(this);
        this.f1150d = appCompatEmojiEditTextHelper;
        appCompatEmojiEditTextHelper.d(attributeSet, i2);
        a(appCompatEmojiEditTextHelper);
    }
}
