package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {

    /* renamed from: d  reason: collision with root package name */
    final Rect f29484d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    final Rect f29485e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private int f29486f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f29487g;

    public HeaderScrollingViewBehavior() {
    }

    private static int M(int i2) {
        if (i2 == 0) {
            return 8388659;
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public void E(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View G = G(coordinatorLayout.r(view));
        if (G != null) {
            CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
            Rect rect = this.f29484d;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, G.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + G.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (lastWindowInsets != null && ViewCompat.A(coordinatorLayout) && !ViewCompat.A(view)) {
                rect.left += lastWindowInsets.i();
                rect.right -= lastWindowInsets.j();
            }
            Rect rect2 = this.f29485e;
            GravityCompat.a(M(layoutParams.f2241c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i2);
            int H = H(G);
            view.layout(rect2.left, rect2.top - H, rect2.right, rect2.bottom - H);
            this.f29486f = rect2.top - G.getBottom();
            return;
        }
        super.E(coordinatorLayout, view, i2);
        this.f29486f = 0;
    }

    /* access modifiers changed from: package-private */
    public abstract View G(List<View> list);

    /* access modifiers changed from: package-private */
    public final int H(View view) {
        if (this.f29487g == 0) {
            return 0;
        }
        float I = I(view);
        int i2 = this.f29487g;
        return MathUtils.b((int) (I * ((float) i2)), 0, i2);
    }

    /* access modifiers changed from: package-private */
    public float I(View view) {
        return 1.0f;
    }

    public final int J() {
        return this.f29487g;
    }

    /* access modifiers changed from: package-private */
    public int K(View view) {
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: package-private */
    public final int L() {
        return this.f29486f;
    }

    public final void N(int i2) {
        this.f29487g = i2;
    }

    public boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
        View G;
        int i6;
        int i7 = view.getLayoutParams().height;
        if ((i7 != -1 && i7 != -2) || (G = G(coordinatorLayout.r(view))) == null) {
            return false;
        }
        if (!ViewCompat.A(G) || ViewCompat.A(view)) {
            View view2 = view;
        } else {
            View view3 = view;
            ViewCompat.A0(view, true);
            if (ViewCompat.A(view)) {
                view.requestLayout();
                return true;
            }
        }
        int size = View.MeasureSpec.getSize(i4);
        if (size == 0) {
            size = coordinatorLayout.getHeight();
        }
        int measuredHeight = (size - G.getMeasuredHeight()) + K(G);
        if (i7 == -1) {
            i6 = 1073741824;
        } else {
            i6 = Integer.MIN_VALUE;
        }
        coordinatorLayout.J(view, i2, i3, View.MeasureSpec.makeMeasureSpec(measuredHeight, i6), i5);
        return true;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
