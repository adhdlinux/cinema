package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;

public class TextInputLayout extends LinearLayout {
    private int A;
    private int B;
    private Drawable C;
    private final Rect D;
    private final RectF E;
    private Typeface F;
    private boolean G;
    private Drawable H;
    private CharSequence I;
    private CheckableImageButton J;
    private boolean K;
    private Drawable L;
    private Drawable M;
    private ColorStateList N;
    private boolean O;
    private PorterDuff.Mode P;
    private boolean Q;
    private ColorStateList R;
    private ColorStateList S;
    private final int T;
    private final int U;
    private int V;
    private final int W;

    /* renamed from: a0  reason: collision with root package name */
    private boolean f30154a0;

    /* renamed from: b  reason: collision with root package name */
    private final FrameLayout f30155b;

    /* renamed from: b0  reason: collision with root package name */
    final CollapsingTextHelper f30156b0;

    /* renamed from: c  reason: collision with root package name */
    EditText f30157c;

    /* renamed from: c0  reason: collision with root package name */
    private boolean f30158c0;

    /* renamed from: d  reason: collision with root package name */
    private CharSequence f30159d;

    /* renamed from: d0  reason: collision with root package name */
    private ValueAnimator f30160d0;

    /* renamed from: e  reason: collision with root package name */
    private final IndicatorViewController f30161e;

    /* renamed from: e0  reason: collision with root package name */
    private boolean f30162e0;

    /* renamed from: f  reason: collision with root package name */
    boolean f30163f;

    /* renamed from: f0  reason: collision with root package name */
    private boolean f30164f0;

    /* renamed from: g  reason: collision with root package name */
    private int f30165g;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public boolean f30166g0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f30167h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f30168i;

    /* renamed from: j  reason: collision with root package name */
    private final int f30169j;

    /* renamed from: k  reason: collision with root package name */
    private final int f30170k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f30171l;

    /* renamed from: m  reason: collision with root package name */
    private CharSequence f30172m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f30173n;

    /* renamed from: o  reason: collision with root package name */
    private GradientDrawable f30174o;

    /* renamed from: p  reason: collision with root package name */
    private final int f30175p;

    /* renamed from: q  reason: collision with root package name */
    private final int f30176q;

    /* renamed from: r  reason: collision with root package name */
    private int f30177r;

    /* renamed from: s  reason: collision with root package name */
    private final int f30178s;

    /* renamed from: t  reason: collision with root package name */
    private float f30179t;

    /* renamed from: u  reason: collision with root package name */
    private float f30180u;

    /* renamed from: v  reason: collision with root package name */
    private float f30181v;

    /* renamed from: w  reason: collision with root package name */
    private float f30182w;

    /* renamed from: x  reason: collision with root package name */
    private int f30183x;

    /* renamed from: y  reason: collision with root package name */
    private final int f30184y;

    /* renamed from: z  reason: collision with root package name */
    private final int f30185z;

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* renamed from: a  reason: collision with root package name */
        private final TextInputLayout f30189a;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.f30189a = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Editable editable;
            boolean z2;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f30189a.getEditText();
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            CharSequence hint = this.f30189a.getHint();
            CharSequence error = this.f30189a.getError();
            CharSequence counterOverflowDescription = this.f30189a.getCounterOverflowDescription();
            boolean z3 = !TextUtils.isEmpty(editable);
            boolean z4 = !TextUtils.isEmpty(hint);
            boolean z5 = !TextUtils.isEmpty(error);
            boolean z6 = false;
            if (z5 || !TextUtils.isEmpty(counterOverflowDescription)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z3) {
                accessibilityNodeInfoCompat.F0(editable);
            } else if (z4) {
                accessibilityNodeInfoCompat.F0(hint);
            }
            if (z4) {
                accessibilityNodeInfoCompat.o0(hint);
                if (!z3 && z4) {
                    z6 = true;
                }
                accessibilityNodeInfoCompat.B0(z6);
            }
            if (z2) {
                if (!z5) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.k0(error);
                accessibilityNodeInfoCompat.h0(true);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            CharSequence charSequence;
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            EditText editText = this.f30189a.getEditText();
            if (editText != null) {
                charSequence = editText.getText();
            } else {
                charSequence = null;
            }
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = this.f30189a.getHint();
            }
            if (!TextUtils.isEmpty(charSequence)) {
                accessibilityEvent.getText().add(charSequence);
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: d  reason: collision with root package name */
        CharSequence f30190d;

        /* renamed from: e  reason: collision with root package name */
        boolean f30191e;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f30190d + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f30190d, parcel, i2);
            parcel.writeInt(this.f30191e ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f30190d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f30191e = parcel.readInt() != 1 ? false : true;
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.textInputStyle);
    }

    private void A() {
        Drawable background;
        EditText editText = this.f30157c;
        if (editText != null && (background = editText.getBackground()) != null) {
            if (DrawableUtils.a(background)) {
                background = background.mutate();
            }
            DescendantOffsetUtils.a(this, this.f30157c, new Rect());
            Rect bounds = background.getBounds();
            if (bounds.left != bounds.right) {
                Rect rect = new Rect();
                background.getPadding(rect);
                background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f30157c.getBottom());
            }
        }
    }

    private void B() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f30155b.getLayoutParams();
        int i2 = i();
        if (i2 != layoutParams.topMargin) {
            layoutParams.topMargin = i2;
            this.f30155b.requestLayout();
        }
    }

    private void D(boolean z2, boolean z3) {
        boolean z4;
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f30157c;
        boolean z5 = true;
        if (editText == null || TextUtils.isEmpty(editText.getText())) {
            z4 = false;
        } else {
            z4 = true;
        }
        EditText editText2 = this.f30157c;
        if (editText2 == null || !editText2.hasFocus()) {
            z5 = false;
        }
        boolean k2 = this.f30161e.k();
        ColorStateList colorStateList2 = this.R;
        if (colorStateList2 != null) {
            this.f30156b0.G(colorStateList2);
            this.f30156b0.L(this.R);
        }
        if (!isEnabled) {
            this.f30156b0.G(ColorStateList.valueOf(this.W));
            this.f30156b0.L(ColorStateList.valueOf(this.W));
        } else if (k2) {
            this.f30156b0.G(this.f30161e.o());
        } else if (this.f30167h && (textView = this.f30168i) != null) {
            this.f30156b0.G(textView.getTextColors());
        } else if (z5 && (colorStateList = this.S) != null) {
            this.f30156b0.G(colorStateList);
        }
        if (z4 || (isEnabled() && (z5 || k2))) {
            if (z3 || this.f30154a0) {
                k(z2);
            }
        } else if (z3 || !this.f30154a0) {
            n(z2);
        }
    }

    private void E() {
        if (this.f30157c != null) {
            if (x()) {
                if (this.J == null) {
                    CheckableImageButton checkableImageButton = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R$layout.design_text_input_password_icon, this.f30155b, false);
                    this.J = checkableImageButton;
                    checkableImageButton.setImageDrawable(this.H);
                    this.J.setContentDescription(this.I);
                    this.f30155b.addView(this.J);
                    this.J.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.t(false);
                        }
                    });
                }
                EditText editText = this.f30157c;
                if (editText != null && ViewCompat.E(editText) <= 0) {
                    this.f30157c.setMinimumHeight(ViewCompat.E(this.J));
                }
                this.J.setVisibility(0);
                this.J.setChecked(this.K);
                if (this.L == null) {
                    this.L = new ColorDrawable();
                }
                this.L.setBounds(0, 0, this.J.getMeasuredWidth(), 1);
                Drawable[] a2 = TextViewCompat.a(this.f30157c);
                Drawable drawable = a2[2];
                Drawable drawable2 = this.L;
                if (drawable != drawable2) {
                    this.M = drawable;
                }
                TextViewCompat.j(this.f30157c, a2[0], a2[1], drawable2, a2[3]);
                this.J.setPadding(this.f30157c.getPaddingLeft(), this.f30157c.getPaddingTop(), this.f30157c.getPaddingRight(), this.f30157c.getPaddingBottom());
                return;
            }
            CheckableImageButton checkableImageButton2 = this.J;
            if (checkableImageButton2 != null && checkableImageButton2.getVisibility() == 0) {
                this.J.setVisibility(8);
            }
            if (this.L != null) {
                Drawable[] a3 = TextViewCompat.a(this.f30157c);
                if (a3[2] == this.L) {
                    TextViewCompat.j(this.f30157c, a3[0], a3[1], this.M, a3[3]);
                    this.L = null;
                }
            }
        }
    }

    private void F() {
        if (this.f30177r != 0 && this.f30174o != null && this.f30157c != null && getRight() != 0) {
            int left = this.f30157c.getLeft();
            int g2 = g();
            int right = this.f30157c.getRight();
            int bottom = this.f30157c.getBottom() + this.f30175p;
            if (this.f30177r == 2) {
                int i2 = this.f30185z;
                left += i2 / 2;
                g2 -= i2 / 2;
                right -= i2 / 2;
                bottom += i2 / 2;
            }
            this.f30174o.setBounds(left, g2, right, bottom);
            c();
            A();
        }
    }

    private void c() {
        int i2;
        Drawable drawable;
        if (this.f30174o != null) {
            v();
            EditText editText = this.f30157c;
            if (editText != null && this.f30177r == 2) {
                if (editText.getBackground() != null) {
                    this.C = this.f30157c.getBackground();
                }
                ViewCompat.v0(this.f30157c, (Drawable) null);
            }
            EditText editText2 = this.f30157c;
            if (!(editText2 == null || this.f30177r != 1 || (drawable = this.C) == null)) {
                ViewCompat.v0(editText2, drawable);
            }
            int i3 = this.f30183x;
            if (i3 > -1 && (i2 = this.A) != 0) {
                this.f30174o.setStroke(i3, i2);
            }
            this.f30174o.setCornerRadii(getCornerRadiiAsArray());
            this.f30174o.setColor(this.B);
            invalidate();
        }
    }

    private void d(RectF rectF) {
        float f2 = rectF.left;
        int i2 = this.f30176q;
        rectF.left = f2 - ((float) i2);
        rectF.top -= (float) i2;
        rectF.right += (float) i2;
        rectF.bottom += (float) i2;
    }

    private void e() {
        Drawable drawable;
        Drawable drawable2 = this.H;
        if (drawable2 == null) {
            return;
        }
        if (this.O || this.Q) {
            Drawable mutate = DrawableCompat.r(drawable2).mutate();
            this.H = mutate;
            if (this.O) {
                DrawableCompat.o(mutate, this.N);
            }
            if (this.Q) {
                DrawableCompat.p(this.H, this.P);
            }
            CheckableImageButton checkableImageButton = this.J;
            if (checkableImageButton != null && checkableImageButton.getDrawable() != (drawable = this.H)) {
                this.J.setImageDrawable(drawable);
            }
        }
    }

    private void f() {
        int i2 = this.f30177r;
        if (i2 == 0) {
            this.f30174o = null;
        } else if (i2 == 2 && this.f30171l && !(this.f30174o instanceof CutoutDrawable)) {
            this.f30174o = new CutoutDrawable();
        } else if (!(this.f30174o instanceof GradientDrawable)) {
            this.f30174o = new GradientDrawable();
        }
    }

    private int g() {
        EditText editText = this.f30157c;
        if (editText == null) {
            return 0;
        }
        int i2 = this.f30177r;
        if (i2 == 1) {
            return editText.getTop();
        }
        if (i2 != 2) {
            return 0;
        }
        return editText.getTop() + i();
    }

    private Drawable getBoxBackground() {
        int i2 = this.f30177r;
        if (i2 == 1 || i2 == 2) {
            return this.f30174o;
        }
        throw new IllegalStateException();
    }

    private float[] getCornerRadiiAsArray() {
        if (!ViewUtils.a(this)) {
            float f2 = this.f30179t;
            float f3 = this.f30180u;
            float f4 = this.f30181v;
            float f5 = this.f30182w;
            return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
        }
        float f6 = this.f30180u;
        float f7 = this.f30179t;
        float f8 = this.f30182w;
        float f9 = this.f30181v;
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    private int h() {
        int i2 = this.f30177r;
        if (i2 == 1) {
            return getBoxBackground().getBounds().top + this.f30178s;
        }
        if (i2 != 2) {
            return getPaddingTop();
        }
        return getBoxBackground().getBounds().top - i();
    }

    private int i() {
        float n2;
        if (!this.f30171l) {
            return 0;
        }
        int i2 = this.f30177r;
        if (i2 == 0 || i2 == 1) {
            n2 = this.f30156b0.n();
        } else if (i2 != 2) {
            return 0;
        } else {
            n2 = this.f30156b0.n() / 2.0f;
        }
        return (int) n2;
    }

    private void j() {
        if (l()) {
            ((CutoutDrawable) this.f30174o).d();
        }
    }

    private void k(boolean z2) {
        ValueAnimator valueAnimator = this.f30160d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f30160d0.cancel();
        }
        if (!z2 || !this.f30158c0) {
            this.f30156b0.P(1.0f);
        } else {
            b(1.0f);
        }
        this.f30154a0 = false;
        if (l()) {
            s();
        }
    }

    private boolean l() {
        return this.f30171l && !TextUtils.isEmpty(this.f30172m) && (this.f30174o instanceof CutoutDrawable);
    }

    private void m() {
        Drawable background;
        int i2 = Build.VERSION.SDK_INT;
        if ((i2 == 21 || i2 == 22) && (background = this.f30157c.getBackground()) != null && !this.f30162e0) {
            Drawable newDrawable = background.getConstantState().newDrawable();
            if (background instanceof DrawableContainer) {
                this.f30162e0 = com.google.android.material.internal.DrawableUtils.a((DrawableContainer) background, newDrawable.getConstantState());
            }
            if (!this.f30162e0) {
                ViewCompat.v0(this.f30157c, newDrawable);
                this.f30162e0 = true;
                r();
            }
        }
    }

    private void n(boolean z2) {
        ValueAnimator valueAnimator = this.f30160d0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f30160d0.cancel();
        }
        if (!z2 || !this.f30158c0) {
            this.f30156b0.P(0.0f);
        } else {
            b(0.0f);
        }
        if (l() && ((CutoutDrawable) this.f30174o).a()) {
            j();
        }
        this.f30154a0 = true;
    }

    private boolean o() {
        EditText editText = this.f30157c;
        if (editText == null || !(editText.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            return false;
        }
        return true;
    }

    private void r() {
        f();
        if (this.f30177r != 0) {
            B();
        }
        F();
    }

    private void s() {
        if (l()) {
            RectF rectF = this.E;
            this.f30156b0.k(rectF);
            d(rectF);
            ((CutoutDrawable) this.f30174o).g(rectF);
        }
    }

    private void setEditText(EditText editText) {
        if (this.f30157c == null) {
            if (!(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f30157c = editText;
            r();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            if (!o()) {
                this.f30156b0.V(this.f30157c.getTypeface());
            }
            this.f30156b0.N(this.f30157c.getTextSize());
            int gravity = this.f30157c.getGravity();
            this.f30156b0.H((gravity & -113) | 48);
            this.f30156b0.M(gravity);
            this.f30157c.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.C(!textInputLayout.f30166g0);
                    TextInputLayout textInputLayout2 = TextInputLayout.this;
                    if (textInputLayout2.f30163f) {
                        textInputLayout2.y(editable.length());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
            if (this.R == null) {
                this.R = this.f30157c.getHintTextColors();
            }
            if (this.f30171l) {
                if (TextUtils.isEmpty(this.f30172m)) {
                    CharSequence hint = this.f30157c.getHint();
                    this.f30159d = hint;
                    setHint(hint);
                    this.f30157c.setHint((CharSequence) null);
                }
                this.f30173n = true;
            }
            if (this.f30168i != null) {
                y(this.f30157c.getText().length());
            }
            this.f30161e.e();
            E();
            D(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.f30172m)) {
            this.f30172m = charSequence;
            this.f30156b0.T(charSequence);
            if (!this.f30154a0) {
                s();
            }
        }
    }

    private static void u(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                u((ViewGroup) childAt, z2);
            }
        }
    }

    private void v() {
        int i2 = this.f30177r;
        if (i2 == 1) {
            this.f30183x = 0;
        } else if (i2 == 2 && this.V == 0) {
            this.V = this.S.getColorForState(getDrawableState(), this.S.getDefaultColor());
        }
    }

    private boolean x() {
        return this.G && (o() || this.K);
    }

    /* access modifiers changed from: package-private */
    public void C(boolean z2) {
        D(z2, false);
    }

    /* access modifiers changed from: package-private */
    public void G() {
        boolean z2;
        TextView textView;
        if (this.f30174o != null && this.f30177r != 0) {
            EditText editText = this.f30157c;
            boolean z3 = true;
            if (editText == null || !editText.hasFocus()) {
                z2 = false;
            } else {
                z2 = true;
            }
            EditText editText2 = this.f30157c;
            if (editText2 == null || !editText2.isHovered()) {
                z3 = false;
            }
            if (this.f30177r == 2) {
                if (!isEnabled()) {
                    this.A = this.W;
                } else if (this.f30161e.k()) {
                    this.A = this.f30161e.n();
                } else if (this.f30167h && (textView = this.f30168i) != null) {
                    this.A = textView.getCurrentTextColor();
                } else if (z2) {
                    this.A = this.V;
                } else if (z3) {
                    this.A = this.U;
                } else {
                    this.A = this.T;
                }
                if ((z3 || z2) && isEnabled()) {
                    this.f30183x = this.f30185z;
                } else {
                    this.f30183x = this.f30184y;
                }
                c();
            }
        }
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f30155b.addView(view, layoutParams2);
            this.f30155b.setLayoutParams(layoutParams);
            B();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        if (this.f30156b0.t() != f2) {
            if (this.f30160d0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f30160d0 = valueAnimator;
                valueAnimator.setInterpolator(AnimationUtils.f29396b);
                this.f30160d0.setDuration(167);
                this.f30160d0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.f30156b0.P(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.f30160d0.setFloatValues(new float[]{this.f30156b0.t(), f2});
            this.f30160d0.start();
        }
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText;
        if (this.f30159d == null || (editText = this.f30157c) == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        boolean z2 = this.f30173n;
        this.f30173n = false;
        CharSequence hint = editText.getHint();
        this.f30157c.setHint(this.f30159d);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
        } finally {
            this.f30157c.setHint(hint);
            this.f30173n = z2;
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f30166g0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f30166g0 = false;
    }

    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.f30174o;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.f30171l) {
            this.f30156b0.i(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        boolean z2;
        if (!this.f30164f0) {
            boolean z3 = true;
            this.f30164f0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!ViewCompat.V(this) || !isEnabled()) {
                z3 = false;
            }
            C(z3);
            z();
            F();
            G();
            CollapsingTextHelper collapsingTextHelper = this.f30156b0;
            if (collapsingTextHelper != null) {
                z2 = collapsingTextHelper.S(drawableState) | false;
            } else {
                z2 = false;
            }
            if (z2) {
                invalidate();
            }
            this.f30164f0 = false;
        }
    }

    public int getBoxBackgroundColor() {
        return this.B;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.f30181v;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.f30182w;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.f30180u;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.f30179t;
    }

    public int getBoxStrokeColor() {
        return this.V;
    }

    public int getCounterMaxLength() {
        return this.f30165g;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f30163f || !this.f30167h || (textView = this.f30168i) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.R;
    }

    public EditText getEditText() {
        return this.f30157c;
    }

    public CharSequence getError() {
        if (this.f30161e.v()) {
            return this.f30161e.m();
        }
        return null;
    }

    public int getErrorCurrentTextColors() {
        return this.f30161e.n();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.f30161e.n();
    }

    public CharSequence getHelperText() {
        if (this.f30161e.w()) {
            return this.f30161e.p();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f30161e.q();
    }

    public CharSequence getHint() {
        if (this.f30171l) {
            return this.f30172m;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.f30156b0.n();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.f30156b0.p();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.I;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.H;
    }

    public Typeface getTypeface() {
        return this.F;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        EditText editText;
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.f30174o != null) {
            F();
        }
        if (this.f30171l && (editText = this.f30157c) != null) {
            Rect rect = this.D;
            DescendantOffsetUtils.a(this, editText, rect);
            int compoundPaddingLeft = rect.left + this.f30157c.getCompoundPaddingLeft();
            int compoundPaddingRight = rect.right - this.f30157c.getCompoundPaddingRight();
            int h2 = h();
            this.f30156b0.J(compoundPaddingLeft, rect.top + this.f30157c.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f30157c.getCompoundPaddingBottom());
            this.f30156b0.E(compoundPaddingLeft, h2, compoundPaddingRight, (i5 - i3) - getPaddingBottom());
            this.f30156b0.C();
            if (l() && !this.f30154a0) {
                s();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        E();
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.b());
        setError(savedState.f30190d);
        if (savedState.f30191e) {
            t(true);
        }
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f30161e.k()) {
            savedState.f30190d = getError();
        }
        savedState.f30191e = this.K;
        return savedState;
    }

    public boolean p() {
        return this.f30161e.w();
    }

    /* access modifiers changed from: package-private */
    public boolean q() {
        return this.f30173n;
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.B != i2) {
            this.B = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i2));
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.f30177r) {
            this.f30177r = i2;
            r();
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.V != i2) {
            this.V = i2;
            G();
        }
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f30163f != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f30168i = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_counter);
                Typeface typeface = this.F;
                if (typeface != null) {
                    this.f30168i.setTypeface(typeface);
                }
                this.f30168i.setMaxLines(1);
                w(this.f30168i, this.f30170k);
                this.f30161e.d(this.f30168i, 2);
                EditText editText = this.f30157c;
                if (editText == null) {
                    y(0);
                } else {
                    y(editText.getText().length());
                }
            } else {
                this.f30161e.x(this.f30168i, 2);
                this.f30168i = null;
            }
            this.f30163f = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        int i3;
        if (this.f30165g != i2) {
            if (i2 > 0) {
                this.f30165g = i2;
            } else {
                this.f30165g = -1;
            }
            if (this.f30163f) {
                EditText editText = this.f30157c;
                if (editText == null) {
                    i3 = 0;
                } else {
                    i3 = editText.getText().length();
                }
                y(i3);
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.R = colorStateList;
        this.S = colorStateList;
        if (this.f30157c != null) {
            C(false);
        }
    }

    public void setEnabled(boolean z2) {
        u(this, z2);
        super.setEnabled(z2);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f30161e.v()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f30161e.J(charSequence);
        } else {
            this.f30161e.r();
        }
    }

    public void setErrorEnabled(boolean z2) {
        this.f30161e.z(z2);
    }

    public void setErrorTextAppearance(int i2) {
        this.f30161e.A(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f30161e.B(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!p()) {
                setHelperTextEnabled(true);
            }
            this.f30161e.K(charSequence);
        } else if (p()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f30161e.E(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.f30161e.D(z2);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.f30161e.C(i2);
    }

    public void setHint(CharSequence charSequence) {
        if (this.f30171l) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.f30158c0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.f30171l) {
            this.f30171l = z2;
            if (!z2) {
                this.f30173n = false;
                if (!TextUtils.isEmpty(this.f30172m) && TextUtils.isEmpty(this.f30157c.getHint())) {
                    this.f30157c.setHint(this.f30172m);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f30157c.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f30172m)) {
                        setHint(hint);
                    }
                    this.f30157c.setHint((CharSequence) null);
                }
                this.f30173n = true;
            }
            if (this.f30157c != null) {
                B();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.f30156b0.F(i2);
        this.S = this.f30156b0.l();
        if (this.f30157c != null) {
            C(false);
            B();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? AppCompatResources.b(getContext(), i2) : null);
    }

    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        EditText editText;
        if (this.G != z2) {
            this.G = z2;
            if (!z2 && this.K && (editText = this.f30157c) != null) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.K = false;
            E();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.N = colorStateList;
        this.O = true;
        e();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.P = mode;
        this.Q = true;
        e();
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f30157c;
        if (editText != null) {
            ViewCompat.r0(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.F) {
            this.F = typeface;
            this.f30156b0.V(typeface);
            this.f30161e.G(typeface);
            TextView textView = this.f30168i;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    public void t(boolean z2) {
        if (this.G) {
            int selectionEnd = this.f30157c.getSelectionEnd();
            if (o()) {
                this.f30157c.setTransformationMethod((TransformationMethod) null);
                this.K = true;
            } else {
                this.f30157c.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.K = false;
            }
            this.J.setChecked(this.K);
            if (z2) {
                this.J.jumpDrawablesToCurrentState();
            }
            this.f30157c.setSelection(selectionEnd);
        }
    }

    /* access modifiers changed from: package-private */
    public void w(TextView textView, int i2) {
        boolean z2 = true;
        try {
            TextViewCompat.o(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            TextViewCompat.o(textView, R$style.f29323a);
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.design_error));
        }
    }

    /* access modifiers changed from: package-private */
    public void y(int i2) {
        boolean z2;
        int i3;
        boolean z3 = this.f30167h;
        if (this.f30165g == -1) {
            this.f30168i.setText(String.valueOf(i2));
            this.f30168i.setContentDescription((CharSequence) null);
            this.f30167h = false;
        } else {
            if (ViewCompat.q(this.f30168i) == 1) {
                ViewCompat.t0(this.f30168i, 0);
            }
            if (i2 > this.f30165g) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.f30167h = z2;
            if (z3 != z2) {
                TextView textView = this.f30168i;
                if (z2) {
                    i3 = this.f30169j;
                } else {
                    i3 = this.f30170k;
                }
                w(textView, i3);
                if (this.f30167h) {
                    ViewCompat.t0(this.f30168i, 1);
                }
            }
            this.f30168i.setText(getContext().getString(R$string.character_counter_pattern, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f30165g)}));
            this.f30168i.setContentDescription(getContext().getString(R$string.character_counter_content_description, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f30165g)}));
        }
        if (this.f30157c != null && z3 != this.f30167h) {
            C(false);
            G();
            z();
        }
    }

    /* access modifiers changed from: package-private */
    public void z() {
        Drawable background;
        TextView textView;
        EditText editText = this.f30157c;
        if (editText != null && (background = editText.getBackground()) != null) {
            m();
            if (DrawableUtils.a(background)) {
                background = background.mutate();
            }
            if (this.f30161e.k()) {
                background.setColorFilter(AppCompatDrawableManager.e(this.f30161e.n(), PorterDuff.Mode.SRC_IN));
            } else if (!this.f30167h || (textView = this.f30168i) == null) {
                DrawableCompat.c(background);
                this.f30157c.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30161e = new IndicatorViewController(this);
        this.D = new Rect();
        this.E = new RectF();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.f30156b0 = collapsingTextHelper;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context);
        this.f30155b = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        addView(frameLayout);
        TimeInterpolator timeInterpolator = AnimationUtils.f29395a;
        collapsingTextHelper.U(timeInterpolator);
        collapsingTextHelper.R(timeInterpolator);
        collapsingTextHelper.H(8388659);
        TintTypedArray i3 = ThemeEnforcement.i(context, attributeSet, R$styleable.D3, i2, R$style.Widget_Design_TextInputLayout, new int[0]);
        this.f30171l = i3.a(R$styleable.Y3, true);
        setHint(i3.p(R$styleable.F3));
        this.f30158c0 = i3.a(R$styleable.X3, true);
        this.f30175p = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_bottom_offset);
        this.f30176q = context.getResources().getDimensionPixelOffset(R$dimen.mtrl_textinput_box_label_cutout_padding);
        this.f30178s = i3.e(R$styleable.I3, 0);
        this.f30179t = i3.d(R$styleable.M3, 0.0f);
        this.f30180u = i3.d(R$styleable.L3, 0.0f);
        this.f30181v = i3.d(R$styleable.J3, 0.0f);
        this.f30182w = i3.d(R$styleable.K3, 0.0f);
        this.B = i3.b(R$styleable.G3, 0);
        this.V = i3.b(R$styleable.N3, 0);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_default);
        this.f30184y = dimensionPixelSize;
        this.f30185z = context.getResources().getDimensionPixelSize(R$dimen.mtrl_textinput_box_stroke_width_focused);
        this.f30183x = dimensionPixelSize;
        setBoxBackgroundMode(i3.k(R$styleable.H3, 0));
        int i4 = R$styleable.E3;
        if (i3.s(i4)) {
            ColorStateList c2 = i3.c(i4);
            this.S = c2;
            this.R = c2;
        }
        this.T = ContextCompat.getColor(context, R$color.mtrl_textinput_default_box_stroke_color);
        this.W = ContextCompat.getColor(context, R$color.mtrl_textinput_disabled_color);
        this.U = ContextCompat.getColor(context, R$color.mtrl_textinput_hovered_box_stroke_color);
        int i5 = R$styleable.Z3;
        if (i3.n(i5, -1) != -1) {
            setHintTextAppearance(i3.n(i5, 0));
        }
        int n2 = i3.n(R$styleable.T3, 0);
        boolean a2 = i3.a(R$styleable.S3, false);
        int n3 = i3.n(R$styleable.W3, 0);
        boolean a3 = i3.a(R$styleable.V3, false);
        CharSequence p2 = i3.p(R$styleable.U3);
        boolean a4 = i3.a(R$styleable.O3, false);
        setCounterMaxLength(i3.k(R$styleable.P3, -1));
        this.f30170k = i3.n(R$styleable.R3, 0);
        this.f30169j = i3.n(R$styleable.Q3, 0);
        this.G = i3.a(R$styleable.c4, false);
        this.H = i3.g(R$styleable.b4);
        this.I = i3.p(R$styleable.a4);
        int i6 = R$styleable.d4;
        if (i3.s(i6)) {
            this.O = true;
            this.N = i3.c(i6);
        }
        int i7 = R$styleable.e4;
        if (i3.s(i7)) {
            this.Q = true;
            this.P = ViewUtils.b(i3.k(i7, -1), (PorterDuff.Mode) null);
        }
        i3.w();
        setHelperTextEnabled(a3);
        setHelperText(p2);
        setHelperTextTextAppearance(n3);
        setErrorEnabled(a2);
        setErrorTextAppearance(n2);
        setCounterEnabled(a4);
        e();
        ViewCompat.C0(this, 2);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.I = charSequence;
        CheckableImageButton checkableImageButton = this.J;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.H = drawable;
        CheckableImageButton checkableImageButton = this.J;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }
}
