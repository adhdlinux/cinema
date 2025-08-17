package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.core.widget.TintableCompoundDrawablesView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements TintableCompoundDrawablesView {
    private final AppCompatBackgroundHelper mBackgroundTintHelper;
    private AppCompatEmojiTextHelper mEmojiTextViewHelper;
    private boolean mIsSetTypefaceProcessing;
    private Future<PrecomputedTextCompat> mPrecomputedTextFuture;
    private SuperCaller mSuperCaller;
    private final AppCompatTextClassifierHelper mTextClassifierHelper;
    private final AppCompatTextHelper mTextHelper;

    private interface SuperCaller {
        void a(int[] iArr, int i2);

        void b(int i2);

        int c();

        int d();

        int[] e();

        TextClassifier f();

        int g();

        void h(TextClassifier textClassifier);

        void i(int i2, int i3, int i4, int i5);

        void j(int i2);

        int k();

        void l(int i2);
    }

    class SuperCallerApi26 implements SuperCaller {
        SuperCallerApi26() {
        }

        public void a(int[] iArr, int i2) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        }

        public void b(int i2) {
        }

        public int c() {
            return AppCompatTextView.super.getAutoSizeTextType();
        }

        public int d() {
            return AppCompatTextView.super.getAutoSizeMinTextSize();
        }

        public int[] e() {
            return AppCompatTextView.super.getAutoSizeTextAvailableSizes();
        }

        public TextClassifier f() {
            return AppCompatTextView.super.getTextClassifier();
        }

        public int g() {
            return AppCompatTextView.super.getAutoSizeMaxTextSize();
        }

        public void h(TextClassifier textClassifier) {
            AppCompatTextView.super.setTextClassifier(textClassifier);
        }

        public void i(int i2, int i3, int i4, int i5) {
            AppCompatTextView.super.setAutoSizeTextTypeUniformWithConfiguration(i2, i3, i4, i5);
        }

        public void j(int i2) {
        }

        public int k() {
            return AppCompatTextView.super.getAutoSizeStepGranularity();
        }

        public void l(int i2) {
            AppCompatTextView.super.setAutoSizeTextTypeWithDefaults(i2);
        }
    }

    class SuperCallerApi28 extends SuperCallerApi26 {
        SuperCallerApi28() {
            super();
        }

        public void b(int i2) {
            AppCompatTextView.super.setLastBaselineToBottomHeight(i2);
        }

        public void j(int i2) {
            AppCompatTextView.super.setFirstBaselineToTopHeight(i2);
        }
    }

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<PrecomputedTextCompat> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                TextViewCompat.n(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.mEmojiTextViewHelper == null) {
            this.mEmojiTextViewHelper = new AppCompatEmojiTextHelper(this);
        }
        return this.mEmojiTextViewHelper;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.b();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.b();
        }
    }

    public int getAutoSizeMaxTextSize() {
        if (ViewUtils.f1552b) {
            return getSuperCaller().g();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.e();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (ViewUtils.f1552b) {
            return getSuperCaller().d();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.f();
        }
        return -1;
    }

    public int getAutoSizeStepGranularity() {
        if (ViewUtils.f1552b) {
            return getSuperCaller().k();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.g();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (ViewUtils.f1552b) {
            return getSuperCaller().e();
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            return appCompatTextHelper.h();
        }
        return new int[0];
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!ViewUtils.f1552b) {
            AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
            if (appCompatTextHelper != null) {
                return appCompatTextHelper.i();
            }
            return 0;
        } else if (getSuperCaller().c() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.b(this);
    }

    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.c(this);
    }

    /* access modifiers changed from: package-private */
    public SuperCaller getSuperCaller() {
        if (this.mSuperCaller == null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                this.mSuperCaller = new SuperCallerApi28();
            } else if (i2 >= 26) {
                this.mSuperCaller = new SuperCallerApi26();
            }
        }
        return this.mSuperCaller;
    }

    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.d();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public TextClassifier getTextClassifier() {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            return getSuperCaller().f();
        }
        return appCompatTextClassifierHelper.a();
    }

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.g(this);
    }

    public boolean isEmojiCompatEnabled() {
        return getEmojiTextViewHelper().b();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.mTextHelper.r(this, onCreateInputConnection, editorInfo);
        return AppCompatHintHelper.a(onCreateInputConnection, editorInfo, this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.o(z2, i2, i3, i4, i5);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        boolean z2;
        super.onTextChanged(charSequence, i2, i3, i4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper == null || ViewUtils.f1552b || !appCompatTextHelper.l()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            this.mTextHelper.c();
        }
    }

    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (ViewUtils.f1552b) {
            getSuperCaller().i(i2, i3, i4, i5);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.t(i2, i3, i4, i5);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws IllegalArgumentException {
        if (ViewUtils.f1552b) {
            getSuperCaller().a(iArr, i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.u(iArr, i2);
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i2) {
        if (ViewUtils.f1552b) {
            getSuperCaller().l(i2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.v(i2);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.f(drawable);
        }
    }

    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.g(i2);
        }
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
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

    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setFirstBaselineToTopHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().j(i2);
        } else {
            TextViewCompat.k(this, i2);
        }
    }

    public void setLastBaselineToBottomHeight(int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i2);
        } else {
            TextViewCompat.l(this, i2);
        }
    }

    public void setLineHeight(int i2) {
        TextViewCompat.m(this, i2);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.n(this, precomputedTextCompat);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.mBackgroundTintHelper;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.j(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.w(colorStateList);
        this.mTextHelper.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.x(mode);
        this.mTextHelper.b();
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.q(context, i2);
        }
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        AppCompatTextClassifierHelper appCompatTextClassifierHelper;
        if (Build.VERSION.SDK_INT >= 28 || (appCompatTextClassifierHelper = this.mTextClassifierHelper) == null) {
            getSuperCaller().h(textClassifier);
        } else {
            appCompatTextClassifierHelper.b(textClassifier);
        }
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        TextViewCompat.p(this, params);
    }

    public void setTextSize(int i2, float f2) {
        if (ViewUtils.f1552b) {
            super.setTextSize(i2, f2);
            return;
        }
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.A(i2, f2);
        }
    }

    public void setTypeface(Typeface typeface, int i2) {
        Typeface typeface2;
        if (!this.mIsSetTypefaceProcessing) {
            if (typeface == null || i2 <= 0) {
                typeface2 = null;
            } else {
                typeface2 = TypefaceCompat.a(getContext(), typeface, i2);
            }
            this.mIsSetTypefaceProcessing = true;
            if (typeface2 != null) {
                typeface = typeface2;
            }
            try {
                super.setTypeface(typeface, i2);
            } finally {
                this.mIsSetTypefaceProcessing = false;
            }
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i2) {
        super(TintContextWrapper.b(context), attributeSet, i2);
        this.mIsSetTypefaceProcessing = false;
        this.mSuperCaller = null;
        ThemeUtils.a(this, getContext());
        AppCompatBackgroundHelper appCompatBackgroundHelper = new AppCompatBackgroundHelper(this);
        this.mBackgroundTintHelper = appCompatBackgroundHelper;
        appCompatBackgroundHelper.e(attributeSet, i2);
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.mTextHelper = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i2);
        appCompatTextHelper.b();
        this.mTextClassifierHelper = new AppCompatTextClassifierHelper(this);
        getEmojiTextViewHelper().c(attributeSet, i2);
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? AppCompatResources.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? AppCompatResources.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? AppCompatResources.b(context, i4) : null;
        if (i5 != 0) {
            drawable = AppCompatResources.b(context, i5);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i2 != 0 ? AppCompatResources.b(context, i2) : null;
        Drawable b3 = i3 != 0 ? AppCompatResources.b(context, i3) : null;
        Drawable b4 = i4 != 0 ? AppCompatResources.b(context, i4) : null;
        if (i5 != 0) {
            drawable = AppCompatResources.b(context, i5);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        AppCompatTextHelper appCompatTextHelper = this.mTextHelper;
        if (appCompatTextHelper != null) {
            appCompatTextHelper.p();
        }
    }
}
