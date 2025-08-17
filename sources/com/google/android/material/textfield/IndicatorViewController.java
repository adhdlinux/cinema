package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.legacy.widget.Space;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import java.util.ArrayList;
import java.util.List;

final class IndicatorViewController {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30130a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f30131b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f30132c;

    /* renamed from: d  reason: collision with root package name */
    private int f30133d;

    /* renamed from: e  reason: collision with root package name */
    private FrameLayout f30134e;

    /* renamed from: f  reason: collision with root package name */
    private int f30135f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Animator f30136g;

    /* renamed from: h  reason: collision with root package name */
    private final float f30137h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f30138i;

    /* renamed from: j  reason: collision with root package name */
    private int f30139j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f30140k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f30141l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public TextView f30142m;

    /* renamed from: n  reason: collision with root package name */
    private int f30143n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f30144o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f30145p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f30146q;

    /* renamed from: r  reason: collision with root package name */
    private int f30147r;

    /* renamed from: s  reason: collision with root package name */
    private Typeface f30148s;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f30130a = context;
        this.f30131b = textInputLayout;
        this.f30137h = (float) context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    private void F(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void H(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean I(TextView textView, CharSequence charSequence) {
        if (!ViewCompat.V(this.f30131b) || !this.f30131b.isEnabled() || (this.f30139j == this.f30138i && textView != null && TextUtils.equals(textView.getText(), charSequence))) {
            return false;
        }
        return true;
    }

    private void L(int i2, int i3, boolean z2) {
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f30136g = animatorSet;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = arrayList;
            int i4 = i2;
            int i5 = i3;
            h(arrayList2, this.f30145p, this.f30146q, 2, i4, i5);
            h(arrayList2, this.f30141l, this.f30142m, 1, i4, i5);
            AnimatorSetCompat.a(animatorSet, arrayList);
            final TextView l2 = l(i2);
            final TextView l3 = l(i3);
            final int i6 = i3;
            final int i7 = i2;
            animatorSet.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    int unused = IndicatorViewController.this.f30138i = i6;
                    Animator unused2 = IndicatorViewController.this.f30136g = null;
                    TextView textView = l2;
                    if (textView != null) {
                        textView.setVisibility(4);
                        if (i7 == 1 && IndicatorViewController.this.f30142m != null) {
                            IndicatorViewController.this.f30142m.setText((CharSequence) null);
                        }
                    }
                }

                public void onAnimationStart(Animator animator) {
                    TextView textView = l3;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            y(i2, i3);
        }
        this.f30131b.z();
        this.f30131b.C(z2);
        this.f30131b.G();
    }

    private boolean f() {
        return (this.f30132c == null || this.f30131b.getEditText() == null) ? false : true;
    }

    private void h(List<Animator> list, boolean z2, TextView textView, int i2, int i3, int i4) {
        boolean z3;
        if (textView != null && z2) {
            if (i2 == i4 || i2 == i3) {
                if (i4 == i2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                list.add(i(textView, z3));
                if (i4 == i2) {
                    list.add(j(textView));
                }
            }
        }
    }

    private ObjectAnimator i(TextView textView, boolean z2) {
        float f2;
        if (z2) {
            f2 = 1.0f;
        } else {
            f2 = 0.0f;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.ALPHA, new float[]{f2});
        ofFloat.setDuration(167);
        ofFloat.setInterpolator(AnimationUtils.f29395a);
        return ofFloat;
    }

    private ObjectAnimator j(TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, View.TRANSLATION_Y, new float[]{-this.f30137h, 0.0f});
        ofFloat.setDuration(217);
        ofFloat.setInterpolator(AnimationUtils.f29398d);
        return ofFloat;
    }

    private TextView l(int i2) {
        if (i2 == 1) {
            return this.f30142m;
        }
        if (i2 != 2) {
            return null;
        }
        return this.f30146q;
    }

    private boolean t(int i2) {
        if (i2 != 1 || this.f30142m == null || TextUtils.isEmpty(this.f30140k)) {
            return false;
        }
        return true;
    }

    private void y(int i2, int i3) {
        TextView l2;
        TextView l3;
        if (i2 != i3) {
            if (!(i3 == 0 || (l3 = l(i3)) == null)) {
                l3.setVisibility(0);
                l3.setAlpha(1.0f);
            }
            if (!(i2 == 0 || (l2 = l(i2)) == null)) {
                l2.setVisibility(4);
                if (i2 == 1) {
                    l2.setText((CharSequence) null);
                }
            }
            this.f30138i = i3;
        }
    }

    /* access modifiers changed from: package-private */
    public void A(int i2) {
        this.f30143n = i2;
        TextView textView = this.f30142m;
        if (textView != null) {
            this.f30131b.w(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void B(ColorStateList colorStateList) {
        TextView textView = this.f30142m;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void C(int i2) {
        this.f30147r = i2;
        TextView textView = this.f30146q;
        if (textView != null) {
            TextViewCompat.o(textView, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void D(boolean z2) {
        if (this.f30145p != z2) {
            g();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f30130a);
                this.f30146q = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_helper_text);
                Typeface typeface = this.f30148s;
                if (typeface != null) {
                    this.f30146q.setTypeface(typeface);
                }
                this.f30146q.setVisibility(4);
                ViewCompat.t0(this.f30146q, 1);
                C(this.f30147r);
                d(this.f30146q, 1);
            } else {
                s();
                x(this.f30146q, 1);
                this.f30146q = null;
                this.f30131b.z();
                this.f30131b.G();
            }
            this.f30145p = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public void E(ColorStateList colorStateList) {
        TextView textView = this.f30146q;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* access modifiers changed from: package-private */
    public void G(Typeface typeface) {
        if (typeface != this.f30148s) {
            this.f30148s = typeface;
            F(this.f30142m, typeface);
            F(this.f30146q, typeface);
        }
    }

    /* access modifiers changed from: package-private */
    public void J(CharSequence charSequence) {
        g();
        this.f30140k = charSequence;
        this.f30142m.setText(charSequence);
        int i2 = this.f30138i;
        if (i2 != 1) {
            this.f30139j = 1;
        }
        L(i2, this.f30139j, I(this.f30142m, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void K(CharSequence charSequence) {
        g();
        this.f30144o = charSequence;
        this.f30146q.setText(charSequence);
        int i2 = this.f30138i;
        if (i2 != 2) {
            this.f30139j = 2;
        }
        L(i2, this.f30139j, I(this.f30146q, charSequence));
    }

    /* access modifiers changed from: package-private */
    public void d(TextView textView, int i2) {
        if (this.f30132c == null && this.f30134e == null) {
            LinearLayout linearLayout = new LinearLayout(this.f30130a);
            this.f30132c = linearLayout;
            linearLayout.setOrientation(0);
            this.f30131b.addView(this.f30132c, -1, -2);
            FrameLayout frameLayout = new FrameLayout(this.f30130a);
            this.f30134e = frameLayout;
            this.f30132c.addView(frameLayout, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f30132c.addView(new Space(this.f30130a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f30131b.getEditText() != null) {
                e();
            }
        }
        if (u(i2)) {
            this.f30134e.setVisibility(0);
            this.f30134e.addView(textView);
            this.f30135f++;
        } else {
            this.f30132c.addView(textView, i2);
        }
        this.f30132c.setVisibility(0);
        this.f30133d++;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        if (f()) {
            ViewCompat.H0(this.f30132c, ViewCompat.I(this.f30131b.getEditText()), 0, ViewCompat.H(this.f30131b.getEditText()), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void g() {
        Animator animator = this.f30136g;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return t(this.f30139j);
    }

    /* access modifiers changed from: package-private */
    public CharSequence m() {
        return this.f30140k;
    }

    /* access modifiers changed from: package-private */
    public int n() {
        TextView textView = this.f30142m;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public ColorStateList o() {
        TextView textView = this.f30142m;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public CharSequence p() {
        return this.f30144o;
    }

    /* access modifiers changed from: package-private */
    public int q() {
        TextView textView = this.f30146q;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.f30140k = null;
        g();
        if (this.f30138i == 1) {
            if (!this.f30145p || TextUtils.isEmpty(this.f30144o)) {
                this.f30139j = 0;
            } else {
                this.f30139j = 2;
            }
        }
        L(this.f30138i, this.f30139j, I(this.f30142m, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public void s() {
        g();
        int i2 = this.f30138i;
        if (i2 == 2) {
            this.f30139j = 0;
        }
        L(i2, this.f30139j, I(this.f30146q, (CharSequence) null));
    }

    /* access modifiers changed from: package-private */
    public boolean u(int i2) {
        return i2 == 0 || i2 == 1;
    }

    /* access modifiers changed from: package-private */
    public boolean v() {
        return this.f30141l;
    }

    /* access modifiers changed from: package-private */
    public boolean w() {
        return this.f30145p;
    }

    /* access modifiers changed from: package-private */
    public void x(TextView textView, int i2) {
        FrameLayout frameLayout;
        if (this.f30132c != null) {
            if (!u(i2) || (frameLayout = this.f30134e) == null) {
                this.f30132c.removeView(textView);
            } else {
                int i3 = this.f30135f - 1;
                this.f30135f = i3;
                H(frameLayout, i3);
                this.f30134e.removeView(textView);
            }
            int i4 = this.f30133d - 1;
            this.f30133d = i4;
            H(this.f30132c, i4);
        }
    }

    /* access modifiers changed from: package-private */
    public void z(boolean z2) {
        if (this.f30141l != z2) {
            g();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(this.f30130a);
                this.f30142m = appCompatTextView;
                appCompatTextView.setId(R$id.textinput_error);
                Typeface typeface = this.f30148s;
                if (typeface != null) {
                    this.f30142m.setTypeface(typeface);
                }
                A(this.f30143n);
                this.f30142m.setVisibility(4);
                ViewCompat.t0(this.f30142m, 1);
                d(this.f30142m, 0);
            } else {
                r();
                x(this.f30142m, 0);
                this.f30142m = null;
                this.f30131b.z();
                this.f30131b.G();
            }
            this.f30141l = z2;
        }
    }
}
