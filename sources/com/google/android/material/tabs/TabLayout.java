package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SimplePool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout extends HorizontalScrollView {
    private static final Pools$Pool<Tab> P = new Pools$SynchronizedPool(16);
    int A;
    boolean B;
    boolean C;
    boolean D;
    private BaseOnTabSelectedListener E;
    private final ArrayList<BaseOnTabSelectedListener> F;
    private BaseOnTabSelectedListener G;
    private ValueAnimator H;
    ViewPager I;
    private PagerAdapter J;
    private DataSetObserver K;
    private TabLayoutOnPageChangeListener L;
    private AdapterChangeListener M;
    private boolean N;
    private final Pools$Pool<TabView> O;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Tab> f30060b;

    /* renamed from: c  reason: collision with root package name */
    private Tab f30061c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final RectF f30062d;

    /* renamed from: e  reason: collision with root package name */
    private final SlidingTabIndicator f30063e;

    /* renamed from: f  reason: collision with root package name */
    int f30064f;

    /* renamed from: g  reason: collision with root package name */
    int f30065g;

    /* renamed from: h  reason: collision with root package name */
    int f30066h;

    /* renamed from: i  reason: collision with root package name */
    int f30067i;

    /* renamed from: j  reason: collision with root package name */
    int f30068j;

    /* renamed from: k  reason: collision with root package name */
    ColorStateList f30069k;

    /* renamed from: l  reason: collision with root package name */
    ColorStateList f30070l;

    /* renamed from: m  reason: collision with root package name */
    ColorStateList f30071m;

    /* renamed from: n  reason: collision with root package name */
    Drawable f30072n;

    /* renamed from: o  reason: collision with root package name */
    PorterDuff.Mode f30073o;

    /* renamed from: p  reason: collision with root package name */
    float f30074p;

    /* renamed from: q  reason: collision with root package name */
    float f30075q;

    /* renamed from: r  reason: collision with root package name */
    final int f30076r;

    /* renamed from: s  reason: collision with root package name */
    int f30077s;

    /* renamed from: t  reason: collision with root package name */
    private final int f30078t;

    /* renamed from: u  reason: collision with root package name */
    private final int f30079u;

    /* renamed from: v  reason: collision with root package name */
    private final int f30080v;

    /* renamed from: w  reason: collision with root package name */
    private int f30081w;

    /* renamed from: x  reason: collision with root package name */
    int f30082x;

    /* renamed from: y  reason: collision with root package name */
    int f30083y;

    /* renamed from: z  reason: collision with root package name */
    int f30084z;

    private class AdapterChangeListener implements ViewPager.OnAdapterChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f30086a;

        AdapterChangeListener() {
        }

        public void a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.I == viewPager) {
                tabLayout.E(pagerAdapter2, this.f30086a);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(boolean z2) {
            this.f30086a = z2;
        }
    }

    public interface BaseOnTabSelectedListener<T extends Tab> {
        void a(T t2);

        void b(T t2);

        void c(T t2);
    }

    private class PagerAdapterObserver extends DataSetObserver {
        PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayout.this.x();
        }

        public void onInvalidated() {
            TabLayout.this.x();
        }
    }

    private class SlidingTabIndicator extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private int f30089b;

        /* renamed from: c  reason: collision with root package name */
        private final Paint f30090c;

        /* renamed from: d  reason: collision with root package name */
        private final GradientDrawable f30091d;

        /* renamed from: e  reason: collision with root package name */
        int f30092e = -1;

        /* renamed from: f  reason: collision with root package name */
        float f30093f;

        /* renamed from: g  reason: collision with root package name */
        private int f30094g = -1;

        /* renamed from: h  reason: collision with root package name */
        private int f30095h = -1;

        /* renamed from: i  reason: collision with root package name */
        private int f30096i = -1;

        /* renamed from: j  reason: collision with root package name */
        private ValueAnimator f30097j;

        SlidingTabIndicator(Context context) {
            super(context);
            setWillNotDraw(false);
            this.f30090c = new Paint();
            this.f30091d = new GradientDrawable();
        }

        private void b(TabView tabView, RectF rectF) {
            int c2 = tabView.f();
            if (c2 < TabLayout.this.t(24)) {
                c2 = TabLayout.this.t(24);
            }
            int left = (tabView.getLeft() + tabView.getRight()) / 2;
            int i2 = c2 / 2;
            rectF.set((float) (left - i2), 0.0f, (float) (left + i2), 0.0f);
        }

        private void h() {
            int i2;
            int i3;
            View childAt = getChildAt(this.f30092e);
            if (childAt == null || childAt.getWidth() <= 0) {
                i3 = -1;
                i2 = -1;
            } else {
                i3 = childAt.getLeft();
                i2 = childAt.getRight();
                TabLayout tabLayout = TabLayout.this;
                if (!tabLayout.C && (childAt instanceof TabView)) {
                    b((TabView) childAt, tabLayout.f30062d);
                    i3 = (int) TabLayout.this.f30062d.left;
                    i2 = (int) TabLayout.this.f30062d.right;
                }
                if (this.f30093f > 0.0f && this.f30092e < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.f30092e + 1);
                    int left = childAt2.getLeft();
                    int right = childAt2.getRight();
                    TabLayout tabLayout2 = TabLayout.this;
                    if (!tabLayout2.C && (childAt2 instanceof TabView)) {
                        b((TabView) childAt2, tabLayout2.f30062d);
                        left = (int) TabLayout.this.f30062d.left;
                        right = (int) TabLayout.this.f30062d.right;
                    }
                    float f2 = this.f30093f;
                    i3 = (int) ((((float) left) * f2) + ((1.0f - f2) * ((float) i3)));
                    i2 = (int) ((((float) right) * f2) + ((1.0f - f2) * ((float) i2)));
                }
            }
            d(i3, i2);
        }

        /* access modifiers changed from: package-private */
        public void a(final int i2, int i3) {
            ValueAnimator valueAnimator = this.f30097j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f30097j.cancel();
            }
            View childAt = getChildAt(i2);
            if (childAt == null) {
                h();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            TabLayout tabLayout = TabLayout.this;
            if (!tabLayout.C && (childAt instanceof TabView)) {
                b((TabView) childAt, tabLayout.f30062d);
                left = (int) TabLayout.this.f30062d.left;
                right = (int) TabLayout.this.f30062d.right;
            }
            final int i4 = left;
            final int i5 = right;
            final int i6 = this.f30095h;
            final int i7 = this.f30096i;
            if (i6 != i4 || i7 != i5) {
                ValueAnimator valueAnimator2 = new ValueAnimator();
                this.f30097j = valueAnimator2;
                valueAnimator2.setInterpolator(AnimationUtils.f29396b);
                valueAnimator2.setDuration((long) i3);
                valueAnimator2.setFloatValues(new float[]{0.0f, 1.0f});
                valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = valueAnimator.getAnimatedFraction();
                        SlidingTabIndicator.this.d(AnimationUtils.b(i6, i4, animatedFraction), AnimationUtils.b(i7, i5, animatedFraction));
                    }
                });
                valueAnimator2.addListener(new AnimatorListenerAdapter() {
                    public void onAnimationEnd(Animator animator) {
                        SlidingTabIndicator slidingTabIndicator = SlidingTabIndicator.this;
                        slidingTabIndicator.f30092e = i2;
                        slidingTabIndicator.f30093f = 0.0f;
                    }
                });
                valueAnimator2.start();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (getChildAt(i2).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, int i3) {
            if (i2 != this.f30095h || i3 != this.f30096i) {
                this.f30095h = i2;
                this.f30096i = i3;
                ViewCompat.i0(this);
            }
        }

        public void draw(Canvas canvas) {
            int i2;
            Drawable drawable = TabLayout.this.f30072n;
            int i3 = 0;
            if (drawable != null) {
                i2 = drawable.getIntrinsicHeight();
            } else {
                i2 = 0;
            }
            int i4 = this.f30089b;
            if (i4 >= 0) {
                i2 = i4;
            }
            int i5 = TabLayout.this.f30084z;
            if (i5 == 0) {
                i3 = getHeight() - i2;
                i2 = getHeight();
            } else if (i5 == 1) {
                i3 = (getHeight() - i2) / 2;
                i2 = (getHeight() + i2) / 2;
            } else if (i5 != 2) {
                if (i5 != 3) {
                    i2 = 0;
                } else {
                    i2 = getHeight();
                }
            }
            int i6 = this.f30095h;
            if (i6 >= 0 && this.f30096i > i6) {
                Drawable drawable2 = TabLayout.this.f30072n;
                if (drawable2 == null) {
                    drawable2 = this.f30091d;
                }
                Drawable r2 = DrawableCompat.r(drawable2);
                r2.setBounds(this.f30095h, i3, this.f30096i, i2);
                Paint paint = this.f30090c;
                if (paint != null) {
                    if (Build.VERSION.SDK_INT == 21) {
                        r2.setColorFilter(paint.getColor(), PorterDuff.Mode.SRC_IN);
                    } else {
                        DrawableCompat.n(r2, paint.getColor());
                    }
                }
                r2.draw(canvas);
            }
            super.draw(canvas);
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, float f2) {
            ValueAnimator valueAnimator = this.f30097j;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.f30097j.cancel();
            }
            this.f30092e = i2;
            this.f30093f = f2;
            h();
        }

        /* access modifiers changed from: package-private */
        public void f(int i2) {
            if (this.f30090c.getColor() != i2) {
                this.f30090c.setColor(i2);
                ViewCompat.i0(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void g(int i2) {
            if (this.f30089b != i2) {
                this.f30089b = i2;
                ViewCompat.i0(this);
            }
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
            super.onLayout(z2, i2, i3, i4, i5);
            ValueAnimator valueAnimator = this.f30097j;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                h();
                return;
            }
            this.f30097j.cancel();
            a(this.f30092e, Math.round((1.0f - this.f30097j.getAnimatedFraction()) * ((float) this.f30097j.getDuration())));
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                TabLayout tabLayout = TabLayout.this;
                boolean z2 = true;
                if (tabLayout.A == 1 && tabLayout.f30082x == 1) {
                    int childCount = getChildCount();
                    int i4 = 0;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        View childAt = getChildAt(i5);
                        if (childAt.getVisibility() == 0) {
                            i4 = Math.max(i4, childAt.getMeasuredWidth());
                        }
                    }
                    if (i4 > 0) {
                        if (i4 * childCount <= getMeasuredWidth() - (TabLayout.this.t(16) * 2)) {
                            boolean z3 = false;
                            for (int i6 = 0; i6 < childCount; i6++) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i6).getLayoutParams();
                                if (layoutParams.width != i4 || layoutParams.weight != 0.0f) {
                                    layoutParams.width = i4;
                                    layoutParams.weight = 0.0f;
                                    z3 = true;
                                }
                            }
                            z2 = z3;
                        } else {
                            TabLayout tabLayout2 = TabLayout.this;
                            tabLayout2.f30082x = 0;
                            tabLayout2.L(false);
                        }
                        if (z2) {
                            super.onMeasure(i2, i3);
                        }
                    }
                }
            }
        }

        public void onRtlPropertiesChanged(int i2) {
            super.onRtlPropertiesChanged(i2);
            if (Build.VERSION.SDK_INT < 23 && this.f30094g != i2) {
                requestLayout();
                this.f30094g = i2;
            }
        }
    }

    public static class Tab {

        /* renamed from: a  reason: collision with root package name */
        private Object f30106a;

        /* renamed from: b  reason: collision with root package name */
        private Drawable f30107b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f30108c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f30109d;

        /* renamed from: e  reason: collision with root package name */
        private int f30110e = -1;

        /* renamed from: f  reason: collision with root package name */
        private View f30111f;

        /* renamed from: g  reason: collision with root package name */
        public TabLayout f30112g;

        /* renamed from: h  reason: collision with root package name */
        public TabView f30113h;

        public View c() {
            return this.f30111f;
        }

        public Drawable d() {
            return this.f30107b;
        }

        public int e() {
            return this.f30110e;
        }

        public CharSequence f() {
            return this.f30108c;
        }

        public boolean g() {
            TabLayout tabLayout = this.f30112g;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            } else if (tabLayout.getSelectedTabPosition() == this.f30110e) {
                return true;
            } else {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public void h() {
            this.f30112g = null;
            this.f30113h = null;
            this.f30106a = null;
            this.f30107b = null;
            this.f30108c = null;
            this.f30109d = null;
            this.f30110e = -1;
            this.f30111f = null;
        }

        public void i() {
            TabLayout tabLayout = this.f30112g;
            if (tabLayout != null) {
                tabLayout.C(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public Tab j(CharSequence charSequence) {
            this.f30109d = charSequence;
            p();
            return this;
        }

        public Tab k(int i2) {
            return l(LayoutInflater.from(this.f30113h.getContext()).inflate(i2, this.f30113h, false));
        }

        public Tab l(View view) {
            this.f30111f = view;
            p();
            return this;
        }

        public Tab m(Drawable drawable) {
            this.f30107b = drawable;
            p();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void n(int i2) {
            this.f30110e = i2;
        }

        public Tab o(CharSequence charSequence) {
            if (TextUtils.isEmpty(this.f30109d) && !TextUtils.isEmpty(charSequence)) {
                this.f30113h.setContentDescription(charSequence);
            }
            this.f30108c = charSequence;
            p();
            return this;
        }

        /* access modifiers changed from: package-private */
        public void p() {
            TabView tabView = this.f30113h;
            if (tabView != null) {
                tabView.i();
            }
        }
    }

    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f30114a;

        /* renamed from: b  reason: collision with root package name */
        private int f30115b;

        /* renamed from: c  reason: collision with root package name */
        private int f30116c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.f30114a = new WeakReference<>(tabLayout);
        }

        public void a(int i2, float f2, int i3) {
            boolean z2;
            TabLayout tabLayout = this.f30114a.get();
            if (tabLayout != null) {
                int i4 = this.f30116c;
                boolean z3 = false;
                if (i4 != 2 || this.f30115b == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!(i4 == 2 && this.f30115b == 0)) {
                    z3 = true;
                }
                tabLayout.G(i2, f2, z2, z3);
            }
        }

        public void b(int i2) {
            this.f30115b = this.f30116c;
            this.f30116c = i2;
        }

        public void c(int i2) {
            boolean z2;
            TabLayout tabLayout = this.f30114a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i2 && i2 < tabLayout.getTabCount()) {
                int i3 = this.f30116c;
                if (i3 == 0 || (i3 == 2 && this.f30115b == 0)) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                tabLayout.D(tabLayout.v(i2), z2);
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            this.f30116c = 0;
            this.f30115b = 0;
        }
    }

    class TabView extends LinearLayout {

        /* renamed from: b  reason: collision with root package name */
        private Tab f30117b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f30118c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f30119d;

        /* renamed from: e  reason: collision with root package name */
        private View f30120e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f30121f;

        /* renamed from: g  reason: collision with root package name */
        private ImageView f30122g;

        /* renamed from: h  reason: collision with root package name */
        private Drawable f30123h;

        /* renamed from: i  reason: collision with root package name */
        private int f30124i = 2;

        public TabView(Context context) {
            super(context);
            j(context);
            ViewCompat.H0(this, TabLayout.this.f30064f, TabLayout.this.f30065g, TabLayout.this.f30066h, TabLayout.this.f30067i);
            setGravity(17);
            setOrientation(TabLayout.this.B ^ true ? 1 : 0);
            setClickable(true);
            ViewCompat.I0(this, PointerIconCompat.b(getContext(), 1002));
        }

        private float d(Layout layout, int i2, float f2) {
            return layout.getLineWidth(i2) * (f2 / layout.getPaint().getTextSize());
        }

        /* access modifiers changed from: private */
        public void e(Canvas canvas) {
            Drawable drawable = this.f30123h;
            if (drawable != null) {
                drawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
                this.f30123h.draw(canvas);
            }
        }

        /* access modifiers changed from: private */
        public int f() {
            View[] viewArr = {this.f30118c, this.f30119d, this.f30120e};
            int i2 = 0;
            int i3 = 0;
            boolean z2 = false;
            for (int i4 = 0; i4 < 3; i4++) {
                View view = viewArr[i4];
                if (view != null && view.getVisibility() == 0) {
                    if (z2) {
                        i3 = Math.min(i3, view.getLeft());
                    } else {
                        i3 = view.getLeft();
                    }
                    if (z2) {
                        i2 = Math.max(i2, view.getRight());
                    } else {
                        i2 = view.getRight();
                    }
                    z2 = true;
                }
            }
            return i2 - i3;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [android.graphics.drawable.RippleDrawable] */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void j(android.content.Context r6) {
            /*
                r5 = this;
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                int r0 = r0.f30076r
                r1 = 0
                if (r0 == 0) goto L_0x001f
                android.graphics.drawable.Drawable r6 = androidx.appcompat.content.res.AppCompatResources.b(r6, r0)
                r5.f30123h = r6
                if (r6 == 0) goto L_0x0021
                boolean r6 = r6.isStateful()
                if (r6 == 0) goto L_0x0021
                android.graphics.drawable.Drawable r6 = r5.f30123h
                int[] r0 = r5.getDrawableState()
                r6.setState(r0)
                goto L_0x0021
            L_0x001f:
                r5.f30123h = r1
            L_0x0021:
                android.graphics.drawable.GradientDrawable r6 = new android.graphics.drawable.GradientDrawable
                r6.<init>()
                r0 = 0
                r6.setColor(r0)
                com.google.android.material.tabs.TabLayout r0 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r0 = r0.f30071m
                if (r0 == 0) goto L_0x0058
                android.graphics.drawable.GradientDrawable r0 = new android.graphics.drawable.GradientDrawable
                r0.<init>()
                r2 = 925353388(0x3727c5ac, float:1.0E-5)
                r0.setCornerRadius(r2)
                r2 = -1
                r0.setColor(r2)
                com.google.android.material.tabs.TabLayout r2 = com.google.android.material.tabs.TabLayout.this
                android.content.res.ColorStateList r2 = r2.f30071m
                android.content.res.ColorStateList r2 = com.google.android.material.ripple.RippleUtils.a(r2)
                android.graphics.drawable.RippleDrawable r3 = new android.graphics.drawable.RippleDrawable
                com.google.android.material.tabs.TabLayout r4 = com.google.android.material.tabs.TabLayout.this
                boolean r4 = r4.D
                if (r4 == 0) goto L_0x0050
                r6 = r1
            L_0x0050:
                if (r4 == 0) goto L_0x0053
                goto L_0x0054
            L_0x0053:
                r1 = r0
            L_0x0054:
                r3.<init>(r2, r6, r1)
                r6 = r3
            L_0x0058:
                androidx.core.view.ViewCompat.v0(r5, r6)
                com.google.android.material.tabs.TabLayout r6 = com.google.android.material.tabs.TabLayout.this
                r6.invalidate()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.TabView.j(android.content.Context):void");
        }

        private void l(TextView textView, ImageView imageView) {
            Drawable drawable;
            CharSequence charSequence;
            CharSequence charSequence2;
            int i2;
            Tab tab = this.f30117b;
            CharSequence charSequence3 = null;
            if (tab == null || tab.d() == null) {
                drawable = null;
            } else {
                drawable = DrawableCompat.r(this.f30117b.d()).mutate();
            }
            Tab tab2 = this.f30117b;
            if (tab2 != null) {
                charSequence = tab2.f();
            } else {
                charSequence = null;
            }
            if (imageView != null) {
                if (drawable != null) {
                    imageView.setImageDrawable(drawable);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable((Drawable) null);
                }
            }
            boolean z2 = !TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (z2) {
                    textView.setText(charSequence);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (!z2 || imageView.getVisibility() != 0) {
                    i2 = 0;
                } else {
                    i2 = TabLayout.this.t(8);
                }
                if (TabLayout.this.B) {
                    if (i2 != MarginLayoutParamsCompat.a(marginLayoutParams)) {
                        MarginLayoutParamsCompat.c(marginLayoutParams, i2);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (i2 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i2;
                    MarginLayoutParamsCompat.c(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            Tab tab3 = this.f30117b;
            if (tab3 != null) {
                charSequence2 = tab3.f30109d;
            } else {
                charSequence2 = null;
            }
            if (!z2) {
                charSequence3 = charSequence2;
            }
            TooltipCompat.a(this, charSequence3);
        }

        /* access modifiers changed from: protected */
        public void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f30123h;
            boolean z2 = false;
            if (drawable != null && drawable.isStateful()) {
                z2 = false | this.f30123h.setState(drawableState);
            }
            if (z2) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void g() {
            h((Tab) null);
            setSelected(false);
        }

        /* access modifiers changed from: package-private */
        public void h(Tab tab) {
            if (tab != this.f30117b) {
                this.f30117b = tab;
                i();
            }
        }

        /* access modifiers changed from: package-private */
        public final void i() {
            View view;
            Tab tab = this.f30117b;
            Drawable drawable = null;
            if (tab != null) {
                view = tab.c();
            } else {
                view = null;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f30120e = view;
                TextView textView = this.f30118c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f30119d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f30119d.setImageDrawable((Drawable) null);
                }
                TextView textView2 = (TextView) view.findViewById(16908308);
                this.f30121f = textView2;
                if (textView2 != null) {
                    this.f30124i = TextViewCompat.d(textView2);
                }
                this.f30122g = (ImageView) view.findViewById(16908294);
            } else {
                View view2 = this.f30120e;
                if (view2 != null) {
                    removeView(view2);
                    this.f30120e = null;
                }
                this.f30121f = null;
                this.f30122g = null;
            }
            boolean z2 = false;
            if (this.f30120e == null) {
                if (this.f30119d == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, this, false);
                    addView(imageView2, 0);
                    this.f30119d = imageView2;
                }
                if (!(tab == null || tab.d() == null)) {
                    drawable = DrawableCompat.r(tab.d()).mutate();
                }
                if (drawable != null) {
                    DrawableCompat.o(drawable, TabLayout.this.f30070l);
                    PorterDuff.Mode mode = TabLayout.this.f30073o;
                    if (mode != null) {
                        DrawableCompat.p(drawable, mode);
                    }
                }
                if (this.f30118c == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, this, false);
                    addView(textView3);
                    this.f30118c = textView3;
                    this.f30124i = TextViewCompat.d(textView3);
                }
                TextViewCompat.o(this.f30118c, TabLayout.this.f30068j);
                ColorStateList colorStateList = TabLayout.this.f30069k;
                if (colorStateList != null) {
                    this.f30118c.setTextColor(colorStateList);
                }
                l(this.f30118c, this.f30119d);
            } else {
                TextView textView4 = this.f30121f;
                if (!(textView4 == null && this.f30122g == null)) {
                    l(textView4, this.f30122g);
                }
            }
            if (tab != null && !TextUtils.isEmpty(tab.f30109d)) {
                setContentDescription(tab.f30109d);
            }
            if (tab != null && tab.g()) {
                z2 = true;
            }
            setSelected(z2);
        }

        /* access modifiers changed from: package-private */
        public final void k() {
            setOrientation(TabLayout.this.B ^ true ? 1 : 0);
            TextView textView = this.f30121f;
            if (textView == null && this.f30122g == null) {
                l(this.f30118c, this.f30119d);
            } else {
                l(textView, this.f30122g);
            }
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @TargetApi(14)
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        public void onMeasure(int i2, int i3) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i2 = View.MeasureSpec.makeMeasureSpec(TabLayout.this.f30077s, Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.f30118c != null) {
                float f2 = TabLayout.this.f30074p;
                int i4 = this.f30124i;
                ImageView imageView = this.f30119d;
                boolean z2 = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f30118c;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = TabLayout.this.f30075q;
                    }
                } else {
                    i4 = 1;
                }
                float textSize = this.f30118c.getTextSize();
                int lineCount = this.f30118c.getLineCount();
                int d2 = TextViewCompat.d(this.f30118c);
                int i5 = (f2 > textSize ? 1 : (f2 == textSize ? 0 : -1));
                if (i5 != 0 || (d2 >= 0 && i4 != d2)) {
                    if (TabLayout.this.A == 1 && i5 > 0 && lineCount == 1 && ((layout = this.f30118c.getLayout()) == null || d(layout, 0, f2) > ((float) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())))) {
                        z2 = false;
                    }
                    if (z2) {
                        this.f30118c.setTextSize(0, f2);
                        this.f30118c.setMaxLines(i4);
                        super.onMeasure(i2, i3);
                    }
                }
            }
        }

        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f30117b == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            this.f30117b.i();
            return true;
        }

        public void setSelected(boolean z2) {
            if (isSelected() != z2) {
            }
            super.setSelected(z2);
            TextView textView = this.f30118c;
            if (textView != null) {
                textView.setSelected(z2);
            }
            ImageView imageView = this.f30119d;
            if (imageView != null) {
                imageView.setSelected(z2);
            }
            View view = this.f30120e;
            if (view != null) {
                view.setSelected(z2);
            }
        }
    }

    public static class ViewPagerOnTabSelectedListener implements BaseOnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager f30126a;

        public ViewPagerOnTabSelectedListener(ViewPager viewPager) {
            this.f30126a = viewPager;
        }

        public void a(Tab tab) {
            this.f30126a.setCurrentItem(tab.e());
        }

        public void b(Tab tab) {
        }

        public void c(Tab tab) {
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    private void B(int i2) {
        TabView tabView = (TabView) this.f30063e.getChildAt(i2);
        this.f30063e.removeViewAt(i2);
        if (tabView != null) {
            tabView.g();
            this.O.release(tabView);
        }
        requestLayout();
    }

    private void I(ViewPager viewPager, boolean z2, boolean z3) {
        ViewPager viewPager2 = this.I;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.L;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            AdapterChangeListener adapterChangeListener = this.M;
            if (adapterChangeListener != null) {
                this.I.removeOnAdapterChangeListener(adapterChangeListener);
            }
        }
        BaseOnTabSelectedListener baseOnTabSelectedListener = this.G;
        if (baseOnTabSelectedListener != null) {
            A(baseOnTabSelectedListener);
            this.G = null;
        }
        if (viewPager != null) {
            this.I = viewPager;
            if (this.L == null) {
                this.L = new TabLayoutOnPageChangeListener(this);
            }
            this.L.d();
            viewPager.addOnPageChangeListener(this.L);
            ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(viewPager);
            this.G = viewPagerOnTabSelectedListener;
            b(viewPagerOnTabSelectedListener);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                E(adapter, z2);
            }
            if (this.M == null) {
                this.M = new AdapterChangeListener();
            }
            this.M.b(z2);
            viewPager.addOnAdapterChangeListener(this.M);
            F(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.I = null;
            E((PagerAdapter) null, false);
        }
        this.N = z3;
    }

    private void J() {
        int size = this.f30060b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f30060b.get(i2).p();
        }
    }

    private void K(LinearLayout.LayoutParams layoutParams) {
        if (this.A == 1 && this.f30082x == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    private void f(TabItem tabItem) {
        Tab w2 = w();
        CharSequence charSequence = tabItem.f30057b;
        if (charSequence != null) {
            w2.o(charSequence);
        }
        Drawable drawable = tabItem.f30058c;
        if (drawable != null) {
            w2.m(drawable);
        }
        int i2 = tabItem.f30059d;
        if (i2 != 0) {
            w2.k(i2);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            w2.j(tabItem.getContentDescription());
        }
        c(w2);
    }

    private void g(Tab tab) {
        this.f30063e.addView(tab.f30113h, tab.e(), n());
    }

    private int getDefaultHeight() {
        int size = this.f30060b.size();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Tab tab = this.f30060b.get(i2);
                if (tab != null && tab.d() != null && !TextUtils.isEmpty(tab.f())) {
                    z2 = true;
                    break;
                }
                i2++;
            } else {
                break;
            }
        }
        if (!z2 || this.B) {
            return 48;
        }
        return 72;
    }

    private int getTabMinWidth() {
        int i2 = this.f30078t;
        if (i2 != -1) {
            return i2;
        }
        if (this.A == 0) {
            return this.f30080v;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f30063e.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void h(View view) {
        if (view instanceof TabItem) {
            f((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void i(int i2) {
        if (i2 != -1) {
            if (getWindowToken() == null || !ViewCompat.V(this) || this.f30063e.c()) {
                F(i2, 0.0f, true);
                return;
            }
            int scrollX = getScrollX();
            int k2 = k(i2, 0.0f);
            if (scrollX != k2) {
                u();
                this.H.setIntValues(new int[]{scrollX, k2});
                this.H.start();
            }
            this.f30063e.a(i2, this.f30083y);
        }
    }

    private void j() {
        int i2;
        if (this.A == 0) {
            i2 = Math.max(0, this.f30081w - this.f30064f);
        } else {
            i2 = 0;
        }
        ViewCompat.H0(this.f30063e, i2, 0, 0, 0);
        int i3 = this.A;
        if (i3 == 0) {
            this.f30063e.setGravity(8388611);
        } else if (i3 == 1) {
            this.f30063e.setGravity(1);
        }
        L(true);
    }

    private int k(int i2, float f2) {
        View view;
        int i3;
        int i4 = 0;
        if (this.A != 0) {
            return 0;
        }
        View childAt = this.f30063e.getChildAt(i2);
        int i5 = i2 + 1;
        if (i5 < this.f30063e.getChildCount()) {
            view = this.f30063e.getChildAt(i5);
        } else {
            view = null;
        }
        if (childAt != null) {
            i3 = childAt.getWidth();
        } else {
            i3 = 0;
        }
        if (view != null) {
            i4 = view.getWidth();
        }
        int left = (childAt.getLeft() + (i3 / 2)) - (getWidth() / 2);
        int i6 = (int) (((float) (i3 + i4)) * 0.5f * f2);
        if (ViewCompat.D(this) == 0) {
            return left + i6;
        }
        return left - i6;
    }

    private void l(Tab tab, int i2) {
        tab.n(i2);
        this.f30060b.add(i2, tab);
        int size = this.f30060b.size();
        while (true) {
            i2++;
            if (i2 < size) {
                this.f30060b.get(i2).n(i2);
            } else {
                return;
            }
        }
    }

    private static ColorStateList m(int i2, int i3) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i3, i2});
    }

    private LinearLayout.LayoutParams n() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        K(layoutParams);
        return layoutParams;
    }

    private TabView p(Tab tab) {
        TabView tabView;
        Pools$Pool<TabView> pools$Pool = this.O;
        if (pools$Pool != null) {
            tabView = pools$Pool.acquire();
        } else {
            tabView = null;
        }
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.h(tab);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(tab.f30109d)) {
            tabView.setContentDescription(tab.f30108c);
        } else {
            tabView.setContentDescription(tab.f30109d);
        }
        return tabView;
    }

    private void q(Tab tab) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).c(tab);
        }
    }

    private void r(Tab tab) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).a(tab);
        }
    }

    private void s(Tab tab) {
        for (int size = this.F.size() - 1; size >= 0; size--) {
            this.F.get(size).b(tab);
        }
    }

    private void setSelectedTabView(int i2) {
        boolean z2;
        int childCount = this.f30063e.getChildCount();
        if (i2 < childCount) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f30063e.getChildAt(i3);
                boolean z3 = true;
                if (i3 == i2) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                childAt.setSelected(z2);
                if (i3 != i2) {
                    z3 = false;
                }
                childAt.setActivated(z3);
            }
        }
    }

    private void u() {
        if (this.H == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.H = valueAnimator;
            valueAnimator.setInterpolator(AnimationUtils.f29396b);
            this.H.setDuration((long) this.f30083y);
            this.H.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                }
            });
        }
    }

    public void A(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        this.F.remove(baseOnTabSelectedListener);
    }

    /* access modifiers changed from: package-private */
    public void C(Tab tab) {
        D(tab, true);
    }

    /* access modifiers changed from: package-private */
    public void D(Tab tab, boolean z2) {
        int i2;
        Tab tab2 = this.f30061c;
        if (tab2 != tab) {
            if (tab != null) {
                i2 = tab.e();
            } else {
                i2 = -1;
            }
            if (z2) {
                if ((tab2 == null || tab2.e() == -1) && i2 != -1) {
                    F(i2, 0.0f, true);
                } else {
                    i(i2);
                }
                if (i2 != -1) {
                    setSelectedTabView(i2);
                }
            }
            this.f30061c = tab;
            if (tab2 != null) {
                s(tab2);
            }
            if (tab != null) {
                r(tab);
            }
        } else if (tab2 != null) {
            q(tab);
            i(tab.e());
        }
    }

    /* access modifiers changed from: package-private */
    public void E(PagerAdapter pagerAdapter, boolean z2) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.J;
        if (!(pagerAdapter2 == null || (dataSetObserver = this.K) == null)) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.J = pagerAdapter;
        if (z2 && pagerAdapter != null) {
            if (this.K == null) {
                this.K = new PagerAdapterObserver();
            }
            pagerAdapter.registerDataSetObserver(this.K);
        }
        x();
    }

    public void F(int i2, float f2, boolean z2) {
        G(i2, f2, z2, true);
    }

    /* access modifiers changed from: package-private */
    public void G(int i2, float f2, boolean z2, boolean z3) {
        int round = Math.round(((float) i2) + f2);
        if (round >= 0 && round < this.f30063e.getChildCount()) {
            if (z3) {
                this.f30063e.e(i2, f2);
            }
            ValueAnimator valueAnimator = this.H;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.H.cancel();
            }
            scrollTo(k(i2, f2), 0);
            if (z2) {
                setSelectedTabView(round);
            }
        }
    }

    public void H(ViewPager viewPager, boolean z2) {
        I(viewPager, z2, false);
    }

    /* access modifiers changed from: package-private */
    public void L(boolean z2) {
        for (int i2 = 0; i2 < this.f30063e.getChildCount(); i2++) {
            View childAt = this.f30063e.getChildAt(i2);
            childAt.setMinimumWidth(getTabMinWidth());
            K((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z2) {
                childAt.requestLayout();
            }
        }
    }

    public void addView(View view) {
        h(view);
    }

    public void b(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        if (!this.F.contains(baseOnTabSelectedListener)) {
            this.F.add(baseOnTabSelectedListener);
        }
    }

    public void c(Tab tab) {
        e(tab, this.f30060b.isEmpty());
    }

    public void d(Tab tab, int i2, boolean z2) {
        if (tab.f30112g == this) {
            l(tab, i2);
            g(tab);
            if (z2) {
                tab.i();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    public void e(Tab tab, boolean z2) {
        d(tab, this.f30060b.size(), z2);
    }

    public int getSelectedTabPosition() {
        Tab tab = this.f30061c;
        if (tab != null) {
            return tab.e();
        }
        return -1;
    }

    public int getTabCount() {
        return this.f30060b.size();
    }

    public int getTabGravity() {
        return this.f30082x;
    }

    public ColorStateList getTabIconTint() {
        return this.f30070l;
    }

    public int getTabIndicatorGravity() {
        return this.f30084z;
    }

    /* access modifiers changed from: package-private */
    public int getTabMaxWidth() {
        return this.f30077s;
    }

    public int getTabMode() {
        return this.A;
    }

    public ColorStateList getTabRippleColor() {
        return this.f30071m;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f30072n;
    }

    public ColorStateList getTabTextColors() {
        return this.f30069k;
    }

    /* access modifiers changed from: protected */
    public Tab o() {
        Tab acquire = P.acquire();
        if (acquire == null) {
            return new Tab();
        }
        return acquire;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.I == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                I((ViewPager) parent, true, true);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.N) {
            setupWithViewPager((ViewPager) null);
            this.N = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        for (int i2 = 0; i2 < this.f30063e.getChildCount(); i2++) {
            View childAt = this.f30063e.getChildAt(i2);
            if (childAt instanceof TabView) {
                ((TabView) childAt).e(canvas);
            }
        }
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L_0x0076;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getDefaultHeight()
            int r0 = r5.t(r0)
            int r1 = r5.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L_0x0024
            if (r1 == 0) goto L_0x001f
            goto L_0x0030
        L_0x001f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L_0x0030
        L_0x0024:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L_0x0030:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L_0x0049
            int r1 = r5.f30079u
            if (r1 <= 0) goto L_0x003f
            goto L_0x0047
        L_0x003f:
            r1 = 56
            int r1 = r5.t(r1)
            int r1 = r0 - r1
        L_0x0047:
            r5.f30077s = r1
        L_0x0049:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L_0x0097
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.A
            if (r2 == 0) goto L_0x006a
            if (r2 == r0) goto L_0x005f
            goto L_0x0077
        L_0x005f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L_0x0075
            goto L_0x0076
        L_0x006a:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L_0x0075
            goto L_0x0076
        L_0x0075:
            r0 = 0
        L_0x0076:
            r6 = r0
        L_0x0077:
            if (r6 == 0) goto L_0x0097
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r6 = r6 + r0
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            int r0 = r0.height
            int r6 = android.view.ViewGroup.getChildMeasureSpec(r7, r6, r0)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.onMeasure(int, int):void");
    }

    public void setInlineLabel(boolean z2) {
        if (this.B != z2) {
            this.B = z2;
            for (int i2 = 0; i2 < this.f30063e.getChildCount(); i2++) {
                View childAt = this.f30063e.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).k();
                }
            }
            j();
        }
    }

    public void setInlineLabelResource(int i2) {
        setInlineLabel(getResources().getBoolean(i2));
    }

    @Deprecated
    public void setOnTabSelectedListener(BaseOnTabSelectedListener baseOnTabSelectedListener) {
        BaseOnTabSelectedListener baseOnTabSelectedListener2 = this.E;
        if (baseOnTabSelectedListener2 != null) {
            A(baseOnTabSelectedListener2);
        }
        this.E = baseOnTabSelectedListener;
        if (baseOnTabSelectedListener != null) {
            b(baseOnTabSelectedListener);
        }
    }

    /* access modifiers changed from: package-private */
    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        u();
        this.H.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f30072n != drawable) {
            this.f30072n = drawable;
            ViewCompat.i0(this.f30063e);
        }
    }

    public void setSelectedTabIndicatorColor(int i2) {
        this.f30063e.f(i2);
    }

    public void setSelectedTabIndicatorGravity(int i2) {
        if (this.f30084z != i2) {
            this.f30084z = i2;
            ViewCompat.i0(this.f30063e);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i2) {
        this.f30063e.g(i2);
    }

    public void setTabGravity(int i2) {
        if (this.f30082x != i2) {
            this.f30082x = i2;
            j();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f30070l != colorStateList) {
            this.f30070l = colorStateList;
            J();
        }
    }

    public void setTabIconTintResource(int i2) {
        setTabIconTint(AppCompatResources.a(getContext(), i2));
    }

    public void setTabIndicatorFullWidth(boolean z2) {
        this.C = z2;
        ViewCompat.i0(this.f30063e);
    }

    public void setTabMode(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            j();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f30071m != colorStateList) {
            this.f30071m = colorStateList;
            for (int i2 = 0; i2 < this.f30063e.getChildCount(); i2++) {
                View childAt = this.f30063e.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).j(getContext());
                }
            }
        }
    }

    public void setTabRippleColorResource(int i2) {
        setTabRippleColor(AppCompatResources.a(getContext(), i2));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f30069k != colorStateList) {
            this.f30069k = colorStateList;
            J();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(PagerAdapter pagerAdapter) {
        E(pagerAdapter, false);
    }

    public void setUnboundedRipple(boolean z2) {
        if (this.D != z2) {
            this.D = z2;
            for (int i2 = 0; i2 < this.f30063e.getChildCount(); i2++) {
                View childAt = this.f30063e.getChildAt(i2);
                if (childAt instanceof TabView) {
                    ((TabView) childAt).j(getContext());
                }
            }
        }
    }

    public void setUnboundedRippleResource(int i2) {
        setUnboundedRipple(getResources().getBoolean(i2));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        H(viewPager, true);
    }

    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    /* access modifiers changed from: package-private */
    public int t(int i2) {
        return Math.round(getResources().getDisplayMetrics().density * ((float) i2));
    }

    public Tab v(int i2) {
        if (i2 < 0 || i2 >= getTabCount()) {
            return null;
        }
        return this.f30060b.get(i2);
    }

    public Tab w() {
        Tab o2 = o();
        o2.f30112g = this;
        o2.f30113h = p(o2);
        return o2;
    }

    /* access modifiers changed from: package-private */
    public void x() {
        int currentItem;
        z();
        PagerAdapter pagerAdapter = this.J;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i2 = 0; i2 < count; i2++) {
                e(w().o(this.J.getPageTitle(i2)), false);
            }
            ViewPager viewPager = this.I;
            if (viewPager != null && count > 0 && (currentItem = viewPager.getCurrentItem()) != getSelectedTabPosition() && currentItem < getTabCount()) {
                C(v(currentItem));
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean y(Tab tab) {
        return P.release(tab);
    }

    public void z() {
        for (int childCount = this.f30063e.getChildCount() - 1; childCount >= 0; childCount--) {
            B(childCount);
        }
        Iterator<Tab> it2 = this.f30060b.iterator();
        while (it2.hasNext()) {
            Tab next = it2.next();
            it2.remove();
            next.h();
            y(next);
        }
        this.f30061c = null;
    }

    /* JADX INFO: finally extract failed */
    public TabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30060b = new ArrayList<>();
        this.f30062d = new RectF();
        this.f30077s = Integer.MAX_VALUE;
        this.F = new ArrayList<>();
        this.O = new Pools$SimplePool(12);
        setHorizontalScrollBarEnabled(false);
        SlidingTabIndicator slidingTabIndicator = new SlidingTabIndicator(context);
        this.f30063e = slidingTabIndicator;
        super.addView(slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
        int[] iArr = R$styleable.P2;
        int i3 = R$style.Widget_Design_TabLayout;
        int i4 = R$styleable.m3;
        TypedArray h2 = ThemeEnforcement.h(context, attributeSet, iArr, i2, i3, i4);
        slidingTabIndicator.g(h2.getDimensionPixelSize(R$styleable.a3, -1));
        slidingTabIndicator.f(h2.getColor(R$styleable.X2, 0));
        setSelectedTabIndicator(MaterialResources.b(context, h2, R$styleable.V2));
        setSelectedTabIndicatorGravity(h2.getInt(R$styleable.Z2, 0));
        setTabIndicatorFullWidth(h2.getBoolean(R$styleable.Y2, true));
        int dimensionPixelSize = h2.getDimensionPixelSize(R$styleable.f3, 0);
        this.f30067i = dimensionPixelSize;
        this.f30066h = dimensionPixelSize;
        this.f30065g = dimensionPixelSize;
        this.f30064f = dimensionPixelSize;
        this.f30064f = h2.getDimensionPixelSize(R$styleable.i3, dimensionPixelSize);
        this.f30065g = h2.getDimensionPixelSize(R$styleable.j3, this.f30065g);
        this.f30066h = h2.getDimensionPixelSize(R$styleable.h3, this.f30066h);
        this.f30067i = h2.getDimensionPixelSize(R$styleable.g3, this.f30067i);
        int resourceId = h2.getResourceId(i4, R$style.TextAppearance_Design_Tab);
        this.f30068j = resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(resourceId, androidx.appcompat.R$styleable.c3);
        try {
            this.f30074p = (float) obtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R$styleable.d3, 0);
            this.f30069k = MaterialResources.a(context, obtainStyledAttributes, androidx.appcompat.R$styleable.g3);
            obtainStyledAttributes.recycle();
            int i5 = R$styleable.n3;
            if (h2.hasValue(i5)) {
                this.f30069k = MaterialResources.a(context, h2, i5);
            }
            int i6 = R$styleable.l3;
            if (h2.hasValue(i6)) {
                this.f30069k = m(this.f30069k.getDefaultColor(), h2.getColor(i6, 0));
            }
            this.f30070l = MaterialResources.a(context, h2, R$styleable.T2);
            this.f30073o = ViewUtils.b(h2.getInt(R$styleable.U2, -1), (PorterDuff.Mode) null);
            this.f30071m = MaterialResources.a(context, h2, R$styleable.k3);
            this.f30083y = h2.getInt(R$styleable.W2, 300);
            this.f30078t = h2.getDimensionPixelSize(R$styleable.d3, -1);
            this.f30079u = h2.getDimensionPixelSize(R$styleable.c3, -1);
            this.f30076r = h2.getResourceId(R$styleable.Q2, 0);
            this.f30081w = h2.getDimensionPixelSize(R$styleable.R2, 0);
            this.A = h2.getInt(R$styleable.e3, 1);
            this.f30082x = h2.getInt(R$styleable.S2, 0);
            this.B = h2.getBoolean(R$styleable.b3, false);
            this.D = h2.getBoolean(R$styleable.o3, false);
            h2.recycle();
            Resources resources = getResources();
            this.f30075q = (float) resources.getDimensionPixelSize(R$dimen.design_tab_text_size_2line);
            this.f30080v = resources.getDimensionPixelSize(R$dimen.design_tab_scrollable_min_width);
            j();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public void addView(View view, int i2) {
        h(view);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        h(view);
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        h(view);
    }

    public void setSelectedTabIndicator(int i2) {
        if (i2 != 0) {
            setSelectedTabIndicator(AppCompatResources.b(getContext(), i2));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }
}
