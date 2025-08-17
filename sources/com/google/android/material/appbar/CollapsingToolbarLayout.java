package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.facebook.imageutils.JfifUtil;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;

public class CollapsingToolbarLayout extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    private boolean f29446b;

    /* renamed from: c  reason: collision with root package name */
    private int f29447c;

    /* renamed from: d  reason: collision with root package name */
    private Toolbar f29448d;

    /* renamed from: e  reason: collision with root package name */
    private View f29449e;

    /* renamed from: f  reason: collision with root package name */
    private View f29450f;

    /* renamed from: g  reason: collision with root package name */
    private int f29451g;

    /* renamed from: h  reason: collision with root package name */
    private int f29452h;

    /* renamed from: i  reason: collision with root package name */
    private int f29453i;

    /* renamed from: j  reason: collision with root package name */
    private int f29454j;

    /* renamed from: k  reason: collision with root package name */
    private final Rect f29455k;

    /* renamed from: l  reason: collision with root package name */
    final CollapsingTextHelper f29456l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f29457m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f29458n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f29459o;

    /* renamed from: p  reason: collision with root package name */
    Drawable f29460p;

    /* renamed from: q  reason: collision with root package name */
    private int f29461q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29462r;

    /* renamed from: s  reason: collision with root package name */
    private ValueAnimator f29463s;

    /* renamed from: t  reason: collision with root package name */
    private long f29464t;

    /* renamed from: u  reason: collision with root package name */
    private int f29465u;

    /* renamed from: v  reason: collision with root package name */
    private AppBarLayout.OnOffsetChangedListener f29466v;

    /* renamed from: w  reason: collision with root package name */
    int f29467w;

    /* renamed from: x  reason: collision with root package name */
    WindowInsetsCompat f29468x;

    private class OffsetUpdateListener implements AppBarLayout.OnOffsetChangedListener {
        OffsetUpdateListener() {
        }

        public void a(AppBarLayout appBarLayout, int i2) {
            int i3;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.f29467w = i2;
            WindowInsetsCompat windowInsetsCompat = collapsingToolbarLayout.f29468x;
            if (windowInsetsCompat != null) {
                i3 = windowInsetsCompat.k();
            } else {
                i3 = 0;
            }
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                ViewOffsetHelper h2 = CollapsingToolbarLayout.h(childAt);
                int i5 = layoutParams.f29471a;
                if (i5 == 1) {
                    h2.e(MathUtils.b(-i2, 0, CollapsingToolbarLayout.this.g(childAt)));
                } else if (i5 == 2) {
                    h2.e(Math.round(((float) (-i2)) * layoutParams.f29472b));
                }
            }
            CollapsingToolbarLayout.this.n();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.f29460p != null && i3 > 0) {
                ViewCompat.i0(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.f29456l.P(((float) Math.abs(i2)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - ViewCompat.E(CollapsingToolbarLayout.this)) - i3)));
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i2) {
        TimeInterpolator timeInterpolator;
        b();
        ValueAnimator valueAnimator = this.f29463s;
        if (valueAnimator == null) {
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.f29463s = valueAnimator2;
            valueAnimator2.setDuration(this.f29464t);
            ValueAnimator valueAnimator3 = this.f29463s;
            if (i2 > this.f29461q) {
                timeInterpolator = AnimationUtils.f29397c;
            } else {
                timeInterpolator = AnimationUtils.f29398d;
            }
            valueAnimator3.setInterpolator(timeInterpolator);
            this.f29463s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CollapsingToolbarLayout.this.setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
        } else if (valueAnimator.isRunning()) {
            this.f29463s.cancel();
        }
        this.f29463s.setIntValues(new int[]{this.f29461q, i2});
        this.f29463s.start();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b() {
        /*
            r6 = this;
            boolean r0 = r6.f29446b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            r0 = 0
            r6.f29448d = r0
            r6.f29449e = r0
            int r1 = r6.f29447c
            r2 = -1
            if (r1 == r2) goto L_0x001f
            android.view.View r1 = r6.findViewById(r1)
            androidx.appcompat.widget.Toolbar r1 = (androidx.appcompat.widget.Toolbar) r1
            r6.f29448d = r1
            if (r1 == 0) goto L_0x001f
            android.view.View r1 = r6.c(r1)
            r6.f29449e = r1
        L_0x001f:
            androidx.appcompat.widget.Toolbar r1 = r6.f29448d
            r2 = 0
            if (r1 != 0) goto L_0x003c
            int r1 = r6.getChildCount()
            r3 = 0
        L_0x0029:
            if (r3 >= r1) goto L_0x003a
            android.view.View r4 = r6.getChildAt(r3)
            boolean r5 = r4 instanceof androidx.appcompat.widget.Toolbar
            if (r5 == 0) goto L_0x0037
            r0 = r4
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            goto L_0x003a
        L_0x0037:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x003a:
            r6.f29448d = r0
        L_0x003c:
            r6.m()
            r6.f29446b = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.b():void");
    }

    private View c(View view) {
        ViewParent parent = view.getParent();
        while (parent != this && parent != null) {
            if (parent instanceof View) {
                view = (View) parent;
            }
            parent = parent.getParent();
        }
        return view;
    }

    private static int f(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    static ViewOffsetHelper h(View view) {
        int i2 = R$id.view_offset_helper;
        ViewOffsetHelper viewOffsetHelper = (ViewOffsetHelper) view.getTag(i2);
        if (viewOffsetHelper != null) {
            return viewOffsetHelper;
        }
        ViewOffsetHelper viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(i2, viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean i(View view) {
        View view2 = this.f29449e;
        if (view2 == null || view2 == this) {
            if (view == this.f29448d) {
                return true;
            }
        } else if (view == view2) {
            return true;
        }
        return false;
    }

    private void l() {
        setContentDescription(getTitle());
    }

    private void m() {
        View view;
        if (!this.f29457m && (view = this.f29450f) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f29450f);
            }
        }
        if (this.f29457m && this.f29448d != null) {
            if (this.f29450f == null) {
                this.f29450f = new View(getContext());
            }
            if (this.f29450f.getParent() == null) {
                this.f29448d.addView(this.f29450f, -1, -1);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public void draw(Canvas canvas) {
        int i2;
        Drawable drawable;
        super.draw(canvas);
        b();
        if (this.f29448d == null && (drawable = this.f29459o) != null && this.f29461q > 0) {
            drawable.mutate().setAlpha(this.f29461q);
            this.f29459o.draw(canvas);
        }
        if (this.f29457m && this.f29458n) {
            this.f29456l.i(canvas);
        }
        if (this.f29460p != null && this.f29461q > 0) {
            WindowInsetsCompat windowInsetsCompat = this.f29468x;
            if (windowInsetsCompat != null) {
                i2 = windowInsetsCompat.k();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                this.f29460p.setBounds(0, -this.f29467w, getWidth(), i2 - this.f29467w);
                this.f29460p.mutate().setAlpha(this.f29461q);
                this.f29460p.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z2;
        if (this.f29459o == null || this.f29461q <= 0 || !i(view)) {
            z2 = false;
        } else {
            this.f29459o.mutate().setAlpha(this.f29461q);
            this.f29459o.draw(canvas);
            z2 = true;
        }
        if (super.drawChild(canvas, view, j2) || z2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f29460p;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f29459o;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        CollapsingTextHelper collapsingTextHelper = this.f29456l;
        if (collapsingTextHelper != null) {
            z2 |= collapsingTextHelper.S(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public final int g(View view) {
        return ((getHeight() - h(view).a()) - view.getHeight()) - ((LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public int getCollapsedTitleGravity() {
        return this.f29456l.m();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.f29456l.o();
    }

    public Drawable getContentScrim() {
        return this.f29459o;
    }

    public int getExpandedTitleGravity() {
        return this.f29456l.r();
    }

    public int getExpandedTitleMarginBottom() {
        return this.f29454j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f29453i;
    }

    public int getExpandedTitleMarginStart() {
        return this.f29451g;
    }

    public int getExpandedTitleMarginTop() {
        return this.f29452h;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.f29456l.s();
    }

    /* access modifiers changed from: package-private */
    public int getScrimAlpha() {
        return this.f29461q;
    }

    public long getScrimAnimationDuration() {
        return this.f29464t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2;
        int i3 = this.f29465u;
        if (i3 >= 0) {
            return i3;
        }
        WindowInsetsCompat windowInsetsCompat = this.f29468x;
        if (windowInsetsCompat != null) {
            i2 = windowInsetsCompat.k();
        } else {
            i2 = 0;
        }
        int E = ViewCompat.E(this);
        if (E > 0) {
            return Math.min((E * 2) + i2, getHeight());
        }
        return getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f29460p;
    }

    public CharSequence getTitle() {
        if (this.f29457m) {
            return this.f29456l.u();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat j(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.A(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.a(this.f29468x, windowInsetsCompat2)) {
            this.f29468x = windowInsetsCompat2;
            requestLayout();
        }
        return windowInsetsCompat.c();
    }

    public void k(boolean z2, boolean z3) {
        if (this.f29462r != z2) {
            int i2 = JfifUtil.MARKER_FIRST_BYTE;
            if (z3) {
                if (!z2) {
                    i2 = 0;
                }
                a(i2);
            } else {
                if (!z2) {
                    i2 = 0;
                }
                setScrimAlpha(i2);
            }
            this.f29462r = z2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void n() {
        boolean z2;
        if (this.f29459o != null || this.f29460p != null) {
            if (getHeight() + this.f29467w < getScrimVisibleHeightTrigger()) {
                z2 = true;
            } else {
                z2 = false;
            }
            setScrimsShown(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            ViewCompat.A0(this, ViewCompat.A((View) parent));
            if (this.f29466v == null) {
                this.f29466v = new OffsetUpdateListener();
            }
            ((AppBarLayout) parent).b(this.f29466v);
            ViewCompat.o0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        ViewParent parent = getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.f29466v;
        if (onOffsetChangedListener != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).n(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        View view;
        boolean z3;
        int i6;
        int i7;
        int i8;
        int i9;
        super.onLayout(z2, i2, i3, i4, i5);
        WindowInsetsCompat windowInsetsCompat = this.f29468x;
        if (windowInsetsCompat != null) {
            int k2 = windowInsetsCompat.k();
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (!ViewCompat.A(childAt) && childAt.getTop() < k2) {
                    ViewCompat.c0(childAt, k2);
                }
            }
        }
        if (this.f29457m && (view = this.f29450f) != null) {
            boolean z4 = true;
            if (!ViewCompat.U(view) || this.f29450f.getVisibility() != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            this.f29458n = z3;
            if (z3) {
                if (ViewCompat.D(this) != 1) {
                    z4 = false;
                }
                View view2 = this.f29449e;
                if (view2 == null) {
                    view2 = this.f29448d;
                }
                int g2 = g(view2);
                DescendantOffsetUtils.a(this, this.f29450f, this.f29455k);
                CollapsingTextHelper collapsingTextHelper = this.f29456l;
                int i11 = this.f29455k.left;
                if (z4) {
                    i6 = this.f29448d.getTitleMarginEnd();
                } else {
                    i6 = this.f29448d.getTitleMarginStart();
                }
                int i12 = i11 + i6;
                int titleMarginTop = this.f29455k.top + g2 + this.f29448d.getTitleMarginTop();
                int i13 = this.f29455k.right;
                if (z4) {
                    i7 = this.f29448d.getTitleMarginStart();
                } else {
                    i7 = this.f29448d.getTitleMarginEnd();
                }
                collapsingTextHelper.E(i12, titleMarginTop, i13 + i7, (this.f29455k.bottom + g2) - this.f29448d.getTitleMarginBottom());
                CollapsingTextHelper collapsingTextHelper2 = this.f29456l;
                if (z4) {
                    i8 = this.f29453i;
                } else {
                    i8 = this.f29451g;
                }
                int i14 = this.f29455k.top + this.f29452h;
                int i15 = i4 - i2;
                if (z4) {
                    i9 = this.f29451g;
                } else {
                    i9 = this.f29453i;
                }
                collapsingTextHelper2.J(i8, i14, i15 - i9, (i5 - i3) - this.f29454j);
                this.f29456l.C();
            }
        }
        int childCount2 = getChildCount();
        for (int i16 = 0; i16 < childCount2; i16++) {
            h(getChildAt(i16)).c();
        }
        if (this.f29448d != null) {
            if (this.f29457m && TextUtils.isEmpty(this.f29456l.u())) {
                setTitle(this.f29448d.getTitle());
            }
            View view3 = this.f29449e;
            if (view3 == null || view3 == this) {
                setMinimumHeight(f(this.f29448d));
            } else {
                setMinimumHeight(f(view3));
            }
        }
        n();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        b();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        WindowInsetsCompat windowInsetsCompat = this.f29468x;
        if (windowInsetsCompat != null) {
            i4 = windowInsetsCompat.k();
        } else {
            i4 = 0;
        }
        if (mode == 0 && i4 > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + i4, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.f29459o;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        this.f29456l.H(i2);
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.f29456l.F(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.f29456l.I(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f29459o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f29459o = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.f29459o.setCallback(this);
                this.f29459o.setAlpha(this.f29461q);
            }
            ViewCompat.i0(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        this.f29456l.M(i2);
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.f29454j = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.f29453i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.f29451g = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.f29452h = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.f29456l.K(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.f29456l.L(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.f29456l.O(typeface);
    }

    /* access modifiers changed from: package-private */
    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.f29461q) {
            if (!(this.f29459o == null || (toolbar = this.f29448d) == null)) {
                ViewCompat.i0(toolbar);
            }
            this.f29461q = i2;
            ViewCompat.i0(this);
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.f29464t = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.f29465u != i2) {
            this.f29465u = i2;
            n();
        }
    }

    public void setScrimsShown(boolean z2) {
        k(z2, ViewCompat.V(this) && !isInEditMode());
    }

    public void setStatusBarScrim(Drawable drawable) {
        boolean z2;
        Drawable drawable2 = this.f29460p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback((Drawable.Callback) null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f29460p = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f29460p.setState(getDrawableState());
                }
                DrawableCompat.m(this.f29460p, ViewCompat.D(this));
                Drawable drawable4 = this.f29460p;
                if (getVisibility() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                drawable4.setVisible(z2, false);
                this.f29460p.setCallback(this);
                this.f29460p.setAlpha(this.f29461q);
            }
            ViewCompat.i0(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(ContextCompat.getDrawable(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.f29456l.T(charSequence);
        l();
    }

    public void setTitleEnabled(boolean z2) {
        if (z2 != this.f29457m) {
            this.f29457m = z2;
            l();
            m();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        boolean z2;
        super.setVisibility(i2);
        if (i2 == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Drawable drawable = this.f29460p;
        if (!(drawable == null || drawable.isVisible() == z2)) {
            this.f29460p.setVisible(z2, false);
        }
        Drawable drawable2 = this.f29459o;
        if (drawable2 != null && drawable2.isVisible() != z2) {
            this.f29459o.setVisible(z2, false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f29459o || drawable == this.f29460p;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29446b = true;
        this.f29455k = new Rect();
        this.f29465u = -1;
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.f29456l = collapsingTextHelper;
        collapsingTextHelper.U(AnimationUtils.f29399e);
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.L0, i2, R$style.Widget_Design_CollapsingToolbar, new int[0]);
        collapsingTextHelper.M(h2.getInt(R$styleable.P0, 8388691));
        collapsingTextHelper.H(h2.getInt(R$styleable.M0, 8388627));
        int dimensionPixelSize = h2.getDimensionPixelSize(R$styleable.Q0, 0);
        this.f29454j = dimensionPixelSize;
        this.f29453i = dimensionPixelSize;
        this.f29452h = dimensionPixelSize;
        this.f29451g = dimensionPixelSize;
        int i3 = R$styleable.T0;
        if (h2.hasValue(i3)) {
            this.f29451g = h2.getDimensionPixelSize(i3, 0);
        }
        int i4 = R$styleable.S0;
        if (h2.hasValue(i4)) {
            this.f29453i = h2.getDimensionPixelSize(i4, 0);
        }
        int i5 = R$styleable.U0;
        if (h2.hasValue(i5)) {
            this.f29452h = h2.getDimensionPixelSize(i5, 0);
        }
        int i6 = R$styleable.R0;
        if (h2.hasValue(i6)) {
            this.f29454j = h2.getDimensionPixelSize(i6, 0);
        }
        this.f29457m = h2.getBoolean(R$styleable.f29326a1, true);
        setTitle(h2.getText(R$styleable.Z0));
        collapsingTextHelper.K(R$style.TextAppearance_Design_CollapsingToolbar_Expanded);
        collapsingTextHelper.F(androidx.appcompat.R$style.f231c);
        int i7 = R$styleable.V0;
        if (h2.hasValue(i7)) {
            collapsingTextHelper.K(h2.getResourceId(i7, 0));
        }
        int i8 = R$styleable.N0;
        if (h2.hasValue(i8)) {
            collapsingTextHelper.F(h2.getResourceId(i8, 0));
        }
        this.f29465u = h2.getDimensionPixelSize(R$styleable.X0, -1);
        this.f29464t = (long) h2.getInt(R$styleable.W0, 600);
        setContentScrim(h2.getDrawable(R$styleable.O0));
        setStatusBarScrim(h2.getDrawable(R$styleable.Y0));
        this.f29447c = h2.getResourceId(R$styleable.f29329b1, -1);
        h2.recycle();
        setWillNotDraw(false);
        ViewCompat.G0(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return CollapsingToolbarLayout.this.j(windowInsetsCompat);
            }
        });
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f29456l.G(colorStateList);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f29471a = 0;

        /* renamed from: b  reason: collision with root package name */
        float f29472b = 0.5f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f29332c1);
            this.f29471a = obtainStyledAttributes.getInt(R$styleable.f29335d1, 0);
            a(obtainStyledAttributes.getFloat(R$styleable.f29338e1, 0.5f));
            obtainStyledAttributes.recycle();
        }

        public void a(float f2) {
            this.f29472b = f2;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
