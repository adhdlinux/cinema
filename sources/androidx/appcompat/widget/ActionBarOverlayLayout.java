package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements DecorContentParent, NestedScrollingParent2, NestedScrollingParent3 {
    static final int[] G = {R$attr.f91b, 16842841};
    private OverScroller A;
    ViewPropertyAnimator B;
    final AnimatorListenerAdapter C;
    private final Runnable D;
    private final Runnable E;
    private final NestedScrollingParentHelper F;

    /* renamed from: b  reason: collision with root package name */
    private int f989b;

    /* renamed from: c  reason: collision with root package name */
    private int f990c = 0;

    /* renamed from: d  reason: collision with root package name */
    private ContentFrameLayout f991d;

    /* renamed from: e  reason: collision with root package name */
    ActionBarContainer f992e;

    /* renamed from: f  reason: collision with root package name */
    private DecorToolbar f993f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f994g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f995h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f996i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f997j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f998k;

    /* renamed from: l  reason: collision with root package name */
    boolean f999l;

    /* renamed from: m  reason: collision with root package name */
    private int f1000m;

    /* renamed from: n  reason: collision with root package name */
    private int f1001n;

    /* renamed from: o  reason: collision with root package name */
    private final Rect f1002o = new Rect();

    /* renamed from: p  reason: collision with root package name */
    private final Rect f1003p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    private final Rect f1004q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private final Rect f1005r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private final Rect f1006s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private final Rect f1007t = new Rect();

    /* renamed from: u  reason: collision with root package name */
    private final Rect f1008u = new Rect();

    /* renamed from: v  reason: collision with root package name */
    private WindowInsetsCompat f1009v;

    /* renamed from: w  reason: collision with root package name */
    private WindowInsetsCompat f1010w;

    /* renamed from: x  reason: collision with root package name */
    private WindowInsetsCompat f1011x;

    /* renamed from: y  reason: collision with root package name */
    private WindowInsetsCompat f1012y;

    /* renamed from: z  reason: collision with root package name */
    private ActionBarVisibilityCallback f1013z;

    public interface ActionBarVisibilityCallback {
        void a();

        void b();

        void c(boolean z2);

        void d();

        void e();

        void onWindowVisibilityChanged(int i2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.f2809b;
        this.f1009v = windowInsetsCompat;
        this.f1010w = windowInsetsCompat;
        this.f1011x = windowInsetsCompat;
        this.f1012y = windowInsetsCompat;
        this.C = new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = null;
                actionBarOverlayLayout.f999l = false;
            }

            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = null;
                actionBarOverlayLayout.f999l = false;
            }
        };
        this.D = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.u();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = actionBarOverlayLayout.f992e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
            }
        };
        this.E = new Runnable() {
            public void run() {
                ActionBarOverlayLayout.this.u();
                ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
                actionBarOverlayLayout.B = actionBarOverlayLayout.f992e.animate().translationY((float) (-ActionBarOverlayLayout.this.f992e.getHeight())).setListener(ActionBarOverlayLayout.this.C);
            }
        };
        v(context);
        this.F = new NestedScrollingParentHelper(this);
    }

    private void A() {
        u();
        this.D.run();
    }

    private boolean B(float f2) {
        this.A.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.A.getFinalY() > this.f992e.getHeight()) {
            return true;
        }
        return false;
    }

    private void p() {
        u();
        this.E.run();
    }

    private boolean q(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!z2 || layoutParams.leftMargin == (i5 = rect.left)) {
            z6 = false;
        } else {
            layoutParams.leftMargin = i5;
            z6 = true;
        }
        if (z3 && layoutParams.topMargin != (i4 = rect.top)) {
            layoutParams.topMargin = i4;
            z6 = true;
        }
        if (z5 && layoutParams.rightMargin != (i3 = rect.right)) {
            layoutParams.rightMargin = i3;
            z6 = true;
        }
        if (!z4 || layoutParams.bottomMargin == (i2 = rect.bottom)) {
            return z6;
        }
        layoutParams.bottomMargin = i2;
        return true;
    }

    private DecorToolbar t(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        boolean z2;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z3 = false;
        this.f989b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f994g = drawable;
        if (drawable == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        setWillNotDraw(z2);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z3 = true;
        }
        this.f995h = z3;
        this.A = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.E, 600);
    }

    private void y() {
        u();
        postDelayed(this.D, 600);
    }

    public boolean a() {
        z();
        return this.f993f.a();
    }

    public boolean b() {
        z();
        return this.f993f.b();
    }

    public boolean c() {
        z();
        return this.f993f.c();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void d(Menu menu, MenuPresenter.Callback callback) {
        z();
        this.f993f.d(menu, callback);
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f994g != null && !this.f995h) {
            if (this.f992e.getVisibility() == 0) {
                i2 = (int) (((float) this.f992e.getBottom()) + this.f992e.getTranslationY() + 0.5f);
            } else {
                i2 = 0;
            }
            this.f994g.setBounds(0, i2, getWidth(), this.f994g.getIntrinsicHeight() + i2);
            this.f994g.draw(canvas);
        }
    }

    public boolean e() {
        z();
        return this.f993f.e();
    }

    public void f() {
        z();
        this.f993f.f();
    }

    /* access modifiers changed from: protected */
    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    public boolean g() {
        z();
        return this.f993f.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f992e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f993f.getTitle();
    }

    public void h(int i2) {
        z();
        if (i2 == 2) {
            this.f993f.q();
        } else if (i2 == 5) {
            this.f993f.z();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    public void i(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    public void j(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    public void k(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public void l() {
        z();
        this.f993f.s();
    }

    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        n(view, i2, i3, i4, i5, i6);
    }

    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        WindowInsetsCompat w2 = WindowInsetsCompat.w(windowInsets, this);
        boolean q2 = q(this.f992e, new Rect(w2.i(), w2.k(), w2.j(), w2.h()), true, true, false, true);
        ViewCompat.h(this, w2, this.f1002o);
        Rect rect = this.f1002o;
        WindowInsetsCompat m2 = w2.m(rect.left, rect.top, rect.right, rect.bottom);
        this.f1009v = m2;
        boolean z2 = true;
        if (!this.f1010w.equals(m2)) {
            this.f1010w = this.f1009v;
            q2 = true;
        }
        if (!this.f1003p.equals(this.f1002o)) {
            this.f1003p.set(this.f1002o);
        } else {
            z2 = q2;
        }
        if (z2) {
            requestLayout();
        }
        return w2.a().c().b().u();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        ViewCompat.o0(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = layoutParams.leftMargin + paddingLeft;
                int i8 = layoutParams.topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z2;
        int i4;
        z();
        measureChildWithMargins(this.f992e, i2, 0, i3, 0);
        LayoutParams layoutParams = (LayoutParams) this.f992e.getLayoutParams();
        int max = Math.max(0, this.f992e.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int max2 = Math.max(0, this.f992e.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f992e.getMeasuredState());
        if ((ViewCompat.N(this) & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i4 = this.f989b;
            if (this.f997j && this.f992e.getTabContainer() != null) {
                i4 += this.f989b;
            }
        } else {
            i4 = this.f992e.getVisibility() != 8 ? this.f992e.getMeasuredHeight() : 0;
        }
        this.f1004q.set(this.f1002o);
        WindowInsetsCompat windowInsetsCompat = this.f1009v;
        this.f1011x = windowInsetsCompat;
        if (this.f996i || z2) {
            this.f1011x = new WindowInsetsCompat.Builder(this.f1011x).c(Insets.b(windowInsetsCompat.i(), this.f1011x.k() + i4, this.f1011x.j(), this.f1011x.h() + 0)).a();
        } else {
            Rect rect = this.f1004q;
            rect.top += i4;
            rect.bottom += 0;
            this.f1011x = windowInsetsCompat.m(0, i4, 0, 0);
        }
        q(this.f991d, this.f1004q, true, true, true, true);
        if (!this.f1012y.equals(this.f1011x)) {
            WindowInsetsCompat windowInsetsCompat2 = this.f1011x;
            this.f1012y = windowInsetsCompat2;
            ViewCompat.i(this.f991d, windowInsetsCompat2);
        }
        measureChildWithMargins(this.f991d, i2, 0, i3, 0);
        LayoutParams layoutParams2 = (LayoutParams) this.f991d.getLayoutParams();
        int max3 = Math.max(max, this.f991d.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin);
        int max4 = Math.max(max2, this.f991d.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f991d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        if (!this.f998k || !z2) {
            return false;
        }
        if (B(f3)) {
            p();
        } else {
            A();
        }
        this.f999l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.f1000m + i3;
        this.f1000m = i6;
        setActionBarHideOffset(i6);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        this.F.b(view, view2, i2);
        this.f1000m = getActionBarHideOffset();
        u();
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1013z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.e();
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f992e.getVisibility() != 0) {
            return false;
        }
        return this.f998k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f998k && !this.f999l) {
            if (this.f1000m <= this.f992e.getHeight()) {
                y();
            } else {
                x();
            }
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1013z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.b();
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        boolean z2;
        super.onWindowSystemUiVisibilityChanged(i2);
        z();
        int i3 = this.f1001n ^ i2;
        this.f1001n = i2;
        boolean z3 = false;
        if ((i2 & 4) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((i2 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0) {
            z3 = true;
        }
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1013z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.c(!z3);
            if (z2 || !z3) {
                this.f1013z.a();
            } else {
                this.f1013z.d();
            }
        }
        if ((i3 & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0 && this.f1013z != null) {
            ViewCompat.o0(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f990c = i2;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.f1013z;
        if (actionBarVisibilityCallback != null) {
            actionBarVisibilityCallback.onWindowVisibilityChanged(i2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    /* renamed from: s */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i2) {
        u();
        this.f992e.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f992e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.f1013z = actionBarVisibilityCallback;
        if (getWindowToken() != null) {
            this.f1013z.onWindowVisibilityChanged(this.f990c);
            int i2 = this.f1001n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                ViewCompat.o0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f997j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f998k) {
            this.f998k = z2;
            if (!z2) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        z();
        this.f993f.setIcon(i2);
    }

    public void setLogo(int i2) {
        z();
        this.f993f.u(i2);
    }

    public void setOverlayMode(boolean z2) {
        boolean z3;
        this.f996i = z2;
        if (!z2 || getContext().getApplicationInfo().targetSdkVersion >= 19) {
            z3 = false;
        } else {
            z3 = true;
        }
        this.f995h = z3;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f993f.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f993f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public void u() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f996i;
    }

    /* access modifiers changed from: package-private */
    public void z() {
        if (this.f991d == null) {
            this.f991d = (ContentFrameLayout) findViewById(R$id.f167b);
            this.f992e = (ActionBarContainer) findViewById(R$id.f168c);
            this.f993f = t(findViewById(R$id.f166a));
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f993f.setIcon(drawable);
    }
}
