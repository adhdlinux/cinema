package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.expandable.ExpandableWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.stateful.ExtendableSavedState;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements ExpandableWidget {

    /* renamed from: c  reason: collision with root package name */
    private ColorStateList f29747c;

    /* renamed from: d  reason: collision with root package name */
    private PorterDuff.Mode f29748d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f29749e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f29750f;

    /* renamed from: g  reason: collision with root package name */
    private int f29751g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f29752h;

    /* renamed from: i  reason: collision with root package name */
    private int f29753i;

    /* renamed from: j  reason: collision with root package name */
    private int f29754j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f29755k;

    /* renamed from: l  reason: collision with root package name */
    private int f29756l;

    /* renamed from: m  reason: collision with root package name */
    boolean f29757m;

    /* renamed from: n  reason: collision with root package name */
    final Rect f29758n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f29759o;

    /* renamed from: p  reason: collision with root package name */
    private final AppCompatImageHelper f29760p;

    /* renamed from: q  reason: collision with root package name */
    private final ExpandableWidgetHelper f29761q;

    /* renamed from: r  reason: collision with root package name */
    private FloatingActionButtonImpl f29762r;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public /* bridge */ /* synthetic */ boolean D(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        public /* bridge */ /* synthetic */ boolean G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        public /* bridge */ /* synthetic */ boolean H(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.l(coordinatorLayout, floatingActionButton, i2);
        }

        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.LayoutParams layoutParams) {
            super.g(layoutParams);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static abstract class OnVisibilityChangedListener {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class ShadowDelegateImpl implements ShadowViewDelegate {
        ShadowDelegateImpl() {
        }

        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.f29758n.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.f29755k, i3 + FloatingActionButton.this.f29755k, i4 + FloatingActionButton.this.f29755k, i5 + FloatingActionButton.this.f29755k);
        }

        public void b(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        public boolean c() {
            return FloatingActionButton.this.f29757m;
        }

        public float getRadius() {
            return ((float) FloatingActionButton.this.getSizeDimension()) / 2.0f;
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    private FloatingActionButtonImpl g() {
        return new FloatingActionButtonImplLollipop(this, new ShadowDelegateImpl());
    }

    private FloatingActionButtonImpl getImpl() {
        if (this.f29762r == null) {
            this.f29762r = g();
        }
        return this.f29762r;
    }

    private int j(int i2) {
        int i3 = this.f29754j;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            if (i2 != 1) {
                return resources.getDimensionPixelSize(R$dimen.design_fab_size_normal);
            }
            return resources.getDimensionPixelSize(R$dimen.design_fab_size_mini);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return j(1);
        } else {
            return j(0);
        }
    }

    private void m(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.f29758n;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void n() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f29749e;
            if (colorStateList == null) {
                DrawableCompat.c(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f29750f;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(AppCompatDrawableManager.e(colorForState, mode));
        }
    }

    private static int q(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private FloatingActionButtonImpl.InternalVisibilityChangedListener s(final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new FloatingActionButtonImpl.InternalVisibilityChangedListener() {
            public void a() {
                onVisibilityChangedListener.b(FloatingActionButton.this);
            }

            public void b() {
                onVisibilityChangedListener.a(FloatingActionButton.this);
            }
        };
    }

    public boolean a() {
        return this.f29761q.c();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().A(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().a(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().b(animatorListener);
    }

    public ColorStateList getBackgroundTintList() {
        return this.f29747c;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f29748d;
    }

    public float getCompatElevation() {
        return getImpl().l();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().n();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().p();
    }

    public Drawable getContentBackground() {
        return getImpl().i();
    }

    public int getCustomSize() {
        return this.f29754j;
    }

    public int getExpandedComponentIdHint() {
        return this.f29761q.b();
    }

    public MotionSpec getHideMotionSpec() {
        return getImpl().m();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f29752h;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f29752h;
    }

    public MotionSpec getShowMotionSpec() {
        return getImpl().q();
    }

    public int getSize() {
        return this.f29753i;
    }

    /* access modifiers changed from: package-private */
    public int getSizeDimension() {
        return j(this.f29753i);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f29749e;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f29750f;
    }

    public boolean getUseCompatPadding() {
        return this.f29757m;
    }

    @Deprecated
    public boolean h(Rect rect) {
        if (!ViewCompat.V(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        m(rect);
        return true;
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m(rect);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().u();
    }

    /* access modifiers changed from: package-private */
    public void k(OnVisibilityChangedListener onVisibilityChangedListener, boolean z2) {
        getImpl().r(s(onVisibilityChangedListener), z2);
    }

    public boolean l() {
        return getImpl().t();
    }

    public void o(Animator.AnimatorListener animatorListener) {
        getImpl().E(animatorListener);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().x();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().z();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.f29755k = (sizeDimension - this.f29756l) / 2;
        getImpl().W();
        int min = Math.min(q(sizeDimension, i2), q(sizeDimension, i3));
        Rect rect = this.f29758n;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.b());
        this.f29761q.d(extendableSavedState.f30056d.get("expandableWidgetHelper"));
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.f30056d.put("expandableWidgetHelper", this.f29761q.e());
        return extendableSavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !h(this.f29759o) || this.f29759o.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void p(Animator.AnimatorListener animatorListener) {
        getImpl().F(animatorListener);
    }

    /* access modifiers changed from: package-private */
    public void r(OnVisibilityChangedListener onVisibilityChangedListener, boolean z2) {
        getImpl().T(s(onVisibilityChangedListener), z2);
    }

    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f29747c != colorStateList) {
            this.f29747c = colorStateList;
            getImpl().I(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f29748d != mode) {
            this.f29748d = mode;
            getImpl().J(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().K(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().M(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().P(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 >= 0) {
            this.f29754j = i2;
            return;
        }
        throw new IllegalArgumentException("Custom size must be non-negative");
    }

    public void setExpandedComponentIdHint(int i2) {
        this.f29761q.f(i2);
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        getImpl().L(motionSpec);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(MotionSpec.c(getContext(), i2));
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().V();
    }

    public void setImageResource(int i2) {
        this.f29760p.i(i2);
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        getImpl().R(motionSpec);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(MotionSpec.c(getContext(), i2));
    }

    public void setSize(int i2) {
        this.f29754j = 0;
        if (i2 != this.f29753i) {
            this.f29753i = i2;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f29749e != colorStateList) {
            this.f29749e = colorStateList;
            n();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f29750f != mode) {
            this.f29750f = mode;
            n();
        }
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f29757m != z2) {
            this.f29757m = z2;
            getImpl().y();
        }
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f29765a;

        /* renamed from: b  reason: collision with root package name */
        private OnVisibilityChangedListener f29766b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f29767c;

        public BaseBehavior() {
            this.f29767c = true;
        }

        private static boolean E(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void F(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.f29758n;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                int i3 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin) {
                    i2 = rect.right;
                } else if (floatingActionButton.getLeft() <= layoutParams.leftMargin) {
                    i2 = -rect.left;
                } else {
                    i2 = 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                    i3 = rect.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                    i3 = -rect.top;
                }
                if (i3 != 0) {
                    ViewCompat.c0(floatingActionButton, i3);
                }
                if (i2 != 0) {
                    ViewCompat.b0(floatingActionButton, i2);
                }
            }
        }

        private boolean I(View view, FloatingActionButton floatingActionButton) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
            if (this.f29767c && layoutParams.e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0) {
                return true;
            }
            return false;
        }

        private boolean J(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!I(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f29765a == null) {
                this.f29765a = new Rect();
            }
            Rect rect = this.f29765a;
            DescendantOffsetUtils.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.k(this.f29766b, false);
                return true;
            }
            floatingActionButton.r(this.f29766b, false);
            return true;
        }

        private boolean K(View view, FloatingActionButton floatingActionButton) {
            if (!I(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.k(this.f29766b, false);
                return true;
            }
            floatingActionButton.r(this.f29766b, false);
            return true;
        }

        /* renamed from: D */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f29758n;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: G */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                J(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!E(view)) {
                return false;
            } else {
                K(view, floatingActionButton);
                return false;
            }
        }

        /* renamed from: H */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> r2 = coordinatorLayout.r(floatingActionButton);
            int size = r2.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = r2.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (E(view) && K(view, floatingActionButton)) {
                        break;
                    }
                } else if (J(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(floatingActionButton, i2);
            F(coordinatorLayout, floatingActionButton);
            return true;
        }

        public void g(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.f2246h == 0) {
                layoutParams.f2246h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.z1);
            this.f29767c = obtainStyledAttributes.getBoolean(R$styleable.A1, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29758n = new Rect();
        this.f29759o = new Rect();
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, R$styleable.f29359l1, i2, R$style.Widget_Design_FloatingActionButton, new int[0]);
        this.f29747c = MaterialResources.a(context, h2, R$styleable.f29362m1);
        this.f29748d = ViewUtils.b(h2.getInt(R$styleable.f29365n1, -1), (PorterDuff.Mode) null);
        this.f29752h = MaterialResources.a(context, h2, R$styleable.w1);
        this.f29753i = h2.getInt(R$styleable.f29377r1, -1);
        this.f29754j = h2.getDimensionPixelSize(R$styleable.f29374q1, 0);
        this.f29751g = h2.getDimensionPixelSize(R$styleable.f29368o1, 0);
        float dimension = h2.getDimension(R$styleable.f29371p1, 0.0f);
        float dimension2 = h2.getDimension(R$styleable.t1, 0.0f);
        float dimension3 = h2.getDimension(R$styleable.v1, 0.0f);
        this.f29757m = h2.getBoolean(R$styleable.y1, false);
        this.f29756l = h2.getDimensionPixelSize(R$styleable.u1, 0);
        MotionSpec b2 = MotionSpec.b(context, h2, R$styleable.x1);
        MotionSpec b3 = MotionSpec.b(context, h2, R$styleable.f29380s1);
        h2.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.f29760p = appCompatImageHelper;
        appCompatImageHelper.g(attributeSet, i2);
        this.f29761q = new ExpandableWidgetHelper(this);
        getImpl().H(this.f29747c, this.f29748d, this.f29752h, this.f29751g);
        getImpl().K(dimension);
        getImpl().M(dimension2);
        getImpl().P(dimension3);
        getImpl().O(this.f29756l);
        getImpl().R(b2);
        getImpl().L(b3);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f29752h != colorStateList) {
            this.f29752h = colorStateList;
            getImpl().Q(this.f29752h);
        }
    }
}
