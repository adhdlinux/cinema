package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class AppBarLayout extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    private int f29417b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f29418c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f29419d = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29420e;

    /* renamed from: f  reason: collision with root package name */
    private int f29421f = 0;

    /* renamed from: g  reason: collision with root package name */
    private WindowInsetsCompat f29422g;

    /* renamed from: h  reason: collision with root package name */
    private List<BaseOnOffsetChangedListener> f29423h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f29424i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f29425j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f29426k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f29427l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f29428m;

    public interface BaseOnOffsetChangedListener<T extends AppBarLayout> {
        void a(T t2, int i2);
    }

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ int D() {
            return super.D();
        }

        public /* bridge */ /* synthetic */ boolean F(int i2) {
            return super.F(i2);
        }

        public /* bridge */ /* synthetic */ boolean d0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.l(coordinatorLayout, appBarLayout, i2);
        }

        public /* bridge */ /* synthetic */ boolean e0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        public /* bridge */ /* synthetic */ void f0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.q(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        public /* bridge */ /* synthetic */ void g0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6) {
            super.s(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6);
        }

        public /* bridge */ /* synthetic */ void h0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.w(coordinatorLayout, appBarLayout, parcelable);
        }

        public /* bridge */ /* synthetic */ Parcelable i0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.x(coordinatorLayout, appBarLayout);
        }

        public /* bridge */ /* synthetic */ boolean j0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.z(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        public /* bridge */ /* synthetic */ void k0(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.B(coordinatorLayout, appBarLayout, view, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public interface OnOffsetChangedListener extends BaseOnOffsetChangedListener<AppBarLayout> {
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        private static int P(AppBarLayout appBarLayout) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                return ((BaseBehavior) f2).L();
            }
            return 0;
        }

        private void Q(View view, View view2) {
            CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) view2.getLayoutParams()).f();
            if (f2 instanceof BaseBehavior) {
                ViewCompat.c0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f2).f29430k) + L()) - H(view2));
            }
        }

        private void R(View view, View view2) {
            boolean z2;
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.k()) {
                    if (view.getScrollY() > 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    appBarLayout.s(z2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public float I(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int P = P(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + P > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (((float) P) / ((float) i2)) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* access modifiers changed from: package-private */
        public int K(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.K(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: O */
        public AppBarLayout G(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            Q(view, view2);
            R(view, view2);
            return false;
        }

        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.l(coordinatorLayout, view, i2);
        }

        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, view, i2, i3, i4, i5);
        }

        public boolean v(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z2) {
            AppBarLayout O = G(coordinatorLayout.r(view));
            if (O != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f29484d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    O.p(false, !z2);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.E2);
            N(obtainStyledAttributes.getDimensionPixelSize(R$styleable.F2, 0));
            obtainStyledAttributes.recycle();
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        int i2 = Build.VERSION.SDK_INT;
        ViewUtilsLollipop.a(this);
        int i3 = R$style.Widget_Design_AppBarLayout;
        ViewUtilsLollipop.c(this, attributeSet, 0, i3);
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.f29342g, 0, i3, new int[0]);
        ViewCompat.v0(this, h2.getDrawable(R$styleable.f29345h));
        int i4 = R$styleable.f29357l;
        if (h2.hasValue(i4)) {
            q(h2.getBoolean(i4, false), false, false);
        }
        int i5 = R$styleable.f29354k;
        if (h2.hasValue(i5)) {
            ViewUtilsLollipop.b(this, (float) h2.getDimensionPixelSize(i5, 0));
        }
        if (i2 >= 26) {
            int i6 = R$styleable.f29351j;
            if (h2.hasValue(i6)) {
                setKeyboardNavigationCluster(h2.getBoolean(i6, false));
            }
            int i7 = R$styleable.f29348i;
            if (h2.hasValue(i7)) {
                setTouchscreenBlocksFocus(h2.getBoolean(i7, false));
            }
        }
        this.f29427l = h2.getBoolean(R$styleable.f29360m, false);
        h2.recycle();
        ViewCompat.G0(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.l(windowInsetsCompat);
            }
        });
    }

    private boolean h() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((LayoutParams) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void j() {
        this.f29417b = -1;
        this.f29418c = -1;
        this.f29419d = -1;
    }

    private void q(boolean z2, boolean z3, boolean z4) {
        int i2;
        int i3;
        if (z2) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        int i4 = 0;
        if (z3) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        int i5 = i2 | i3;
        if (z4) {
            i4 = 8;
        }
        this.f29421f = i5 | i4;
        requestLayout();
    }

    private boolean r(boolean z2) {
        if (this.f29425j == z2) {
            return false;
        }
        this.f29425j = z2;
        refreshDrawableState();
        return true;
    }

    public void a(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.f29423h == null) {
            this.f29423h = new ArrayList();
        }
        if (baseOnOffsetChangedListener != null && !this.f29423h.contains(baseOnOffsetChangedListener)) {
            this.f29423h.add(baseOnOffsetChangedListener);
        }
    }

    public void b(OnOffsetChangedListener onOffsetChangedListener) {
        a(onOffsetChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        List<BaseOnOffsetChangedListener> list = this.f29423h;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.f29423h.get(i3);
                if (baseOnOffsetChangedListener != null) {
                    baseOnOffsetChangedListener.a(this, i2);
                }
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
        return new LayoutParams(-1, -2);
    }

    /* renamed from: e */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f29420e;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedPreScrollRange() {
        int i2;
        int i3 = this.f29418c;
        if (i3 != -1) {
            return i3;
        }
        int i4 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f29444a;
            if ((i5 & 5) == 5) {
                int i6 = i4 + layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i5 & 8) != 0) {
                    i4 = i6 + ViewCompat.E(childAt);
                } else {
                    if ((i5 & 2) != 0) {
                        i2 = ViewCompat.E(childAt);
                    } else {
                        i2 = getTopInset();
                    }
                    i4 = i6 + (measuredHeight - i2);
                }
            } else if (i4 > 0) {
                break;
            }
        }
        int max = Math.max(0, i4);
        this.f29418c = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getDownNestedScrollRange() {
        int i2 = this.f29419d;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int i5 = layoutParams.f29444a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight;
            if ((i5 & 2) != 0) {
                i4 -= ViewCompat.E(childAt) + getTopInset();
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4);
        this.f29419d = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int E = ViewCompat.E(this);
        if (E == 0) {
            int childCount = getChildCount();
            if (childCount >= 1) {
                E = ViewCompat.E(getChildAt(childCount - 1));
            } else {
                E = 0;
            }
            if (E == 0) {
                return getHeight() / 3;
            }
        }
        return (E * 2) + topInset;
    }

    /* access modifiers changed from: package-private */
    public int getPendingAction() {
        return this.f29421f;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f29422g;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f29417b;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = layoutParams.f29444a;
            if ((i5 & 1) == 0) {
                break;
            }
            i4 += measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((i5 & 2) != 0) {
                i4 -= ViewCompat.E(childAt);
                break;
            }
            i3++;
        }
        int max = Math.max(0, i4 - getTopInset());
        this.f29417b = max;
        return max;
    }

    /* access modifiers changed from: package-private */
    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return getTotalScrollRange() != 0;
    }

    public boolean k() {
        return this.f29427l;
    }

    /* access modifiers changed from: package-private */
    public WindowInsetsCompat l(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2;
        if (ViewCompat.A(this)) {
            windowInsetsCompat2 = windowInsetsCompat;
        } else {
            windowInsetsCompat2 = null;
        }
        if (!ObjectsCompat.a(this.f29422g, windowInsetsCompat2)) {
            this.f29422g = windowInsetsCompat2;
            j();
        }
        return windowInsetsCompat;
    }

    public void m(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.f29423h;
        if (list != null && baseOnOffsetChangedListener != null) {
            list.remove(baseOnOffsetChangedListener);
        }
    }

    public void n(OnOffsetChangedListener onOffsetChangedListener) {
        m(onOffsetChangedListener);
    }

    /* access modifiers changed from: package-private */
    public void o() {
        this.f29421f = 0;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int i3;
        int i4;
        if (this.f29428m == null) {
            this.f29428m = new int[4];
        }
        int[] iArr = this.f29428m;
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z2 = this.f29425j;
        int i5 = R$attr.state_liftable;
        if (!z2) {
            i5 = -i5;
        }
        iArr[0] = i5;
        if (!z2 || !this.f29426k) {
            i3 = -R$attr.state_lifted;
        } else {
            i3 = R$attr.state_lifted;
        }
        iArr[1] = i3;
        int i6 = R$attr.state_collapsible;
        if (!z2) {
            i6 = -i6;
        }
        iArr[2] = i6;
        if (!z2 || !this.f29426k) {
            i4 = -R$attr.state_collapsed;
        } else {
            i4 = R$attr.state_collapsed;
        }
        iArr[3] = i4;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        j();
        boolean z3 = false;
        this.f29420e = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            if (i6 >= childCount) {
                break;
            } else if (((LayoutParams) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f29420e = true;
                break;
            } else {
                i6++;
            }
        }
        if (!this.f29424i) {
            if (this.f29427l || h()) {
                z3 = true;
            }
            r(z3);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        j();
    }

    public void p(boolean z2, boolean z3) {
        q(z2, z3, true);
    }

    /* access modifiers changed from: package-private */
    public boolean s(boolean z2) {
        if (this.f29426k == z2) {
            return false;
        }
        this.f29426k = z2;
        refreshDrawableState();
        return true;
    }

    public void setExpanded(boolean z2) {
        p(z2, ViewCompat.V(this));
    }

    public void setLiftOnScroll(boolean z2) {
        this.f29427l = z2;
    }

    public void setOrientation(int i2) {
        if (i2 == 1) {
            super.setOrientation(i2);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        ViewUtilsLollipop.b(this, f2);
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public int f29430k;

        /* renamed from: l  reason: collision with root package name */
        private int f29431l;

        /* renamed from: m  reason: collision with root package name */
        private ValueAnimator f29432m;

        /* renamed from: n  reason: collision with root package name */
        private int f29433n = -1;

        /* renamed from: o  reason: collision with root package name */
        private boolean f29434o;

        /* renamed from: p  reason: collision with root package name */
        private float f29435p;

        /* renamed from: q  reason: collision with root package name */
        private WeakReference<View> f29436q;

        /* renamed from: r  reason: collision with root package name */
        private BaseDragCallback f29437r;

        public static abstract class BaseDragCallback<T extends AppBarLayout> {
            public abstract boolean a(T t2);
        }

        public BaseBehavior() {
        }

        private void R(CoordinatorLayout coordinatorLayout, T t2, int i2, float f2) {
            int i3;
            int abs = Math.abs(L() - i2);
            float abs2 = Math.abs(f2);
            if (abs2 > 0.0f) {
                i3 = Math.round((((float) abs) / abs2) * 1000.0f) * 3;
            } else {
                i3 = (int) (((((float) abs) / ((float) t2.getHeight())) + 1.0f) * 150.0f);
            }
            S(coordinatorLayout, t2, i2, i3);
        }

        private void S(final CoordinatorLayout coordinatorLayout, final T t2, int i2, int i3) {
            int L = L();
            if (L == i2) {
                ValueAnimator valueAnimator = this.f29432m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f29432m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f29432m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f29432m = valueAnimator3;
                valueAnimator3.setInterpolator(AnimationUtils.f29399e);
                this.f29432m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        BaseBehavior.this.O(coordinatorLayout, t2, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.f29432m.setDuration((long) Math.min(i3, 600));
            this.f29432m.setIntValues(new int[]{L, i2});
            this.f29432m.start();
        }

        private boolean U(CoordinatorLayout coordinatorLayout, T t2, View view) {
            if (!t2.i() || coordinatorLayout.getHeight() - view.getHeight() > t2.getHeight()) {
                return false;
            }
            return true;
        }

        private static boolean V(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private View W(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt instanceof NestedScrollingChild) {
                    return childAt;
                }
            }
            return null;
        }

        private static View X(AppBarLayout appBarLayout, int i2) {
            int abs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int Y(T t2, int i2) {
            int childCount = t2.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t2.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (V(layoutParams.a(), 32)) {
                    top -= layoutParams.topMargin;
                    bottom += layoutParams.bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private int b0(T t2, int i2) {
            int abs = Math.abs(i2);
            int childCount = t2.getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = t2.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator b2 = layoutParams.b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i4++;
                } else if (b2 != null) {
                    int a2 = layoutParams.a();
                    if ((a2 & 1) != 0) {
                        i3 = 0 + childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
                        if ((a2 & 2) != 0) {
                            i3 -= ViewCompat.E(childAt);
                        }
                    }
                    if (ViewCompat.A(childAt)) {
                        i3 -= t2.getTopInset();
                    }
                    if (i3 > 0) {
                        float f2 = (float) i3;
                        return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * b2.getInterpolation(((float) (abs - childAt.getTop())) / f2)));
                    }
                }
            }
            return i2;
        }

        private boolean m0(CoordinatorLayout coordinatorLayout, T t2) {
            List<View> s2 = coordinatorLayout.s(t2);
            int size = s2.size();
            int i2 = 0;
            while (i2 < size) {
                CoordinatorLayout.Behavior f2 = ((CoordinatorLayout.LayoutParams) s2.get(i2).getLayoutParams()).f();
                if (!(f2 instanceof ScrollingViewBehavior)) {
                    i2++;
                } else if (((ScrollingViewBehavior) f2).J() != 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private void n0(CoordinatorLayout coordinatorLayout, T t2) {
            int L = L();
            int Y = Y(t2, L);
            if (Y >= 0) {
                View childAt = t2.getChildAt(Y);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int a2 = layoutParams.a();
                if ((a2 & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int i3 = -childAt.getBottom();
                    if (Y == t2.getChildCount() - 1) {
                        i3 += t2.getTopInset();
                    }
                    if (V(a2, 2)) {
                        i3 += ViewCompat.E(childAt);
                    } else if (V(a2, 5)) {
                        int E = ViewCompat.E(childAt) + i3;
                        if (L < E) {
                            i2 = E;
                        } else {
                            i3 = E;
                        }
                    }
                    if (V(a2, 32)) {
                        i2 += layoutParams.topMargin;
                        i3 -= layoutParams.bottomMargin;
                    }
                    if (L < (i3 + i2) / 2) {
                        i2 = i3;
                    }
                    R(coordinatorLayout, t2, MathUtils.b(i2, -t2.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void o0(int i2, T t2, View view, int i3) {
            if (i3 == 1) {
                int L = L();
                if ((i2 < 0 && L == 0) || (i2 > 0 && L == (-t2.getDownNestedScrollRange()))) {
                    ViewCompat.Q0(view, 1);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void p0(androidx.coordinatorlayout.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = X(r7, r8)
                if (r0 == 0) goto L_0x0068
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                com.google.android.material.appbar.AppBarLayout$LayoutParams r1 = (com.google.android.material.appbar.AppBarLayout.LayoutParams) r1
                int r1 = r1.a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L_0x0041
                int r2 = androidx.core.view.ViewCompat.E(r0)
                if (r9 <= 0) goto L_0x002f
                r9 = r1 & 12
                if (r9 == 0) goto L_0x002f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
            L_0x002d:
                r8 = 1
                goto L_0x0042
            L_0x002f:
                r9 = r1 & 2
                if (r9 == 0) goto L_0x0041
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L_0x0041
                goto L_0x002d
            L_0x0041:
                r8 = 0
            L_0x0042:
                boolean r9 = r7.k()
                if (r9 == 0) goto L_0x0057
                android.view.View r9 = r5.W(r6)
                if (r9 == 0) goto L_0x0057
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L_0x0055
                goto L_0x0056
            L_0x0055:
                r3 = 0
            L_0x0056:
                r8 = r3
            L_0x0057:
                boolean r8 = r7.s(r8)
                if (r10 != 0) goto L_0x0065
                if (r8 == 0) goto L_0x0068
                boolean r6 = r5.m0(r6, r7)
                if (r6 == 0) goto L_0x0068
            L_0x0065:
                r7.jumpDrawablesToCurrentState()
            L_0x0068:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.AppBarLayout.BaseBehavior.p0(androidx.coordinatorlayout.widget.CoordinatorLayout, com.google.android.material.appbar.AppBarLayout, int, int, boolean):void");
        }

        /* access modifiers changed from: package-private */
        public int L() {
            return D() + this.f29430k;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: T */
        public boolean G(T t2) {
            BaseDragCallback baseDragCallback = this.f29437r;
            if (baseDragCallback != null) {
                return baseDragCallback.a(t2);
            }
            WeakReference<View> weakReference = this.f29436q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            if (view == null || !view.isShown() || view.canScrollVertically(-1)) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Z */
        public int J(T t2) {
            return -t2.getDownNestedScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a0 */
        public int K(T t2) {
            return t2.getTotalScrollRange();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c0 */
        public void M(CoordinatorLayout coordinatorLayout, T t2) {
            n0(coordinatorLayout, t2);
        }

        /* renamed from: d0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t2, int i2) {
            boolean z2;
            int i3;
            boolean l2 = super.l(coordinatorLayout, t2, i2);
            int pendingAction = t2.getPendingAction();
            int i4 = this.f29433n;
            if (i4 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t2.getChildAt(i4);
                int i5 = -childAt.getBottom();
                if (this.f29434o) {
                    i3 = ViewCompat.E(childAt) + t2.getTopInset();
                } else {
                    i3 = Math.round(((float) childAt.getHeight()) * this.f29435p);
                }
                O(coordinatorLayout, t2, i5 + i3);
            } else if (pendingAction != 0) {
                if ((pendingAction & 4) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((pendingAction & 2) != 0) {
                    int i6 = -t2.getUpNestedPreScrollRange();
                    if (z2) {
                        R(coordinatorLayout, t2, i6, 0.0f);
                    } else {
                        O(coordinatorLayout, t2, i6);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z2) {
                        R(coordinatorLayout, t2, 0, 0.0f);
                    } else {
                        O(coordinatorLayout, t2, 0);
                    }
                }
            }
            t2.o();
            this.f29433n = -1;
            F(MathUtils.b(D(), -t2.getTotalScrollRange(), 0));
            p0(coordinatorLayout, t2, D(), 0, true);
            t2.c(D());
            return l2;
        }

        /* renamed from: e0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3, int i4, int i5) {
            if (((CoordinatorLayout.LayoutParams) t2.getLayoutParams()).height != -2) {
                return super.m(coordinatorLayout, t2, i2, i3, i4, i5);
            }
            coordinatorLayout.J(t2, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        /* renamed from: f0 */
        public void q(CoordinatorLayout coordinatorLayout, T t2, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int i6;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i7 = -t2.getTotalScrollRange();
                    i6 = i7;
                    i5 = t2.getDownNestedPreScrollRange() + i7;
                } else {
                    i6 = -t2.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i6 != i5) {
                    iArr[1] = N(coordinatorLayout, t2, i3, i6, i5);
                    o0(i3, t2, view, i4);
                }
            }
        }

        /* renamed from: g0 */
        public void s(CoordinatorLayout coordinatorLayout, T t2, View view, int i2, int i3, int i4, int i5, int i6) {
            boolean z2;
            if (i5 < 0) {
                N(coordinatorLayout, t2, i5, -t2.getDownNestedScrollRange(), 0);
                o0(i5, t2, view, i6);
            }
            if (t2.k()) {
                if (view.getScrollY() > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                t2.s(z2);
            }
        }

        /* renamed from: h0 */
        public void w(CoordinatorLayout coordinatorLayout, T t2, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.w(coordinatorLayout, t2, savedState.b());
                this.f29433n = savedState.f29441d;
                this.f29435p = savedState.f29442e;
                this.f29434o = savedState.f29443f;
                return;
            }
            super.w(coordinatorLayout, t2, parcelable);
            this.f29433n = -1;
        }

        /* renamed from: i0 */
        public Parcelable x(CoordinatorLayout coordinatorLayout, T t2) {
            Parcelable x2 = super.x(coordinatorLayout, t2);
            int D = D();
            int childCount = t2.getChildCount();
            boolean z2 = false;
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = t2.getChildAt(i2);
                int bottom = childAt.getBottom() + D;
                if (childAt.getTop() + D > 0 || bottom < 0) {
                    i2++;
                } else {
                    SavedState savedState = new SavedState(x2);
                    savedState.f29441d = i2;
                    if (bottom == ViewCompat.E(childAt) + t2.getTopInset()) {
                        z2 = true;
                    }
                    savedState.f29443f = z2;
                    savedState.f29442e = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return x2;
        }

        /* renamed from: j0 */
        public boolean z(CoordinatorLayout coordinatorLayout, T t2, View view, View view2, int i2, int i3) {
            boolean z2;
            ValueAnimator valueAnimator;
            if ((i2 & 2) == 0 || (!t2.k() && !U(coordinatorLayout, t2, view))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && (valueAnimator = this.f29432m) != null) {
                valueAnimator.cancel();
            }
            this.f29436q = null;
            this.f29431l = i3;
            return z2;
        }

        /* renamed from: k0 */
        public void B(CoordinatorLayout coordinatorLayout, T t2, View view, int i2) {
            if (this.f29431l == 0 || i2 == 1) {
                n0(coordinatorLayout, t2);
            }
            this.f29436q = new WeakReference<>(view);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: l0 */
        public int P(CoordinatorLayout coordinatorLayout, T t2, int i2, int i3, int i4) {
            int i5;
            int i6;
            int L = L();
            int i7 = 0;
            if (i3 == 0 || L < i3 || L > i4) {
                this.f29430k = 0;
            } else {
                int b2 = MathUtils.b(i2, i3, i4);
                if (L != b2) {
                    if (t2.g()) {
                        i5 = b0(t2, b2);
                    } else {
                        i5 = b2;
                    }
                    boolean F = F(i5);
                    i7 = L - b2;
                    this.f29430k = b2 - i5;
                    if (!F && t2.g()) {
                        coordinatorLayout.f(t2);
                    }
                    t2.c(D());
                    if (b2 < L) {
                        i6 = -1;
                    } else {
                        i6 = 1;
                    }
                    p0(coordinatorLayout, t2, b2, i6, false);
                }
            }
            return i7;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected static class SavedState extends AbsSavedState {
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
            int f29441d;

            /* renamed from: e  reason: collision with root package name */
            float f29442e;

            /* renamed from: f  reason: collision with root package name */
            boolean f29443f;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f29441d = parcel.readInt();
                this.f29442e = parcel.readFloat();
                this.f29443f = parcel.readByte() != 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f29441d);
                parcel.writeFloat(this.f29442e);
                parcel.writeByte(this.f29443f ? (byte) 1 : 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f29444a = 1;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f29445b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f29366o);
            this.f29444a = obtainStyledAttributes.getInt(R$styleable.f29369p, 0);
            int i2 = R$styleable.f29372q;
            if (obtainStyledAttributes.hasValue(i2)) {
                this.f29445b = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i2, 0));
            }
            obtainStyledAttributes.recycle();
        }

        public int a() {
            return this.f29444a;
        }

        public Interpolator b() {
            return this.f29445b;
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int i2 = this.f29444a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
