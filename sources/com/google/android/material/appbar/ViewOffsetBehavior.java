package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a  reason: collision with root package name */
    private ViewOffsetHelper f29488a;

    /* renamed from: b  reason: collision with root package name */
    private int f29489b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f29490c = 0;

    public ViewOffsetBehavior() {
    }

    public int D() {
        ViewOffsetHelper viewOffsetHelper = this.f29488a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.b();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void E(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        coordinatorLayout.I(v2, i2);
    }

    public boolean F(int i2) {
        ViewOffsetHelper viewOffsetHelper = this.f29488a;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.e(i2);
        }
        this.f29489b = i2;
        return false;
    }

    public boolean l(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        E(coordinatorLayout, v2, i2);
        if (this.f29488a == null) {
            this.f29488a = new ViewOffsetHelper(v2);
        }
        this.f29488a.c();
        int i3 = this.f29489b;
        if (i3 != 0) {
            this.f29488a.e(i3);
            this.f29489b = 0;
        }
        int i4 = this.f29490c;
        if (i4 == 0) {
            return true;
        }
        this.f29488a.d(i4);
        this.f29490c = 0;
        return true;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
