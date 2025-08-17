package com.google.android.material.expandable;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public final class ExpandableWidgetHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f29744a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f29745b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f29746c = 0;

    public ExpandableWidgetHelper(ExpandableWidget expandableWidget) {
        this.f29744a = (View) expandableWidget;
    }

    private void a() {
        ViewParent parent = this.f29744a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).f(this.f29744a);
        }
    }

    public int b() {
        return this.f29746c;
    }

    public boolean c() {
        return this.f29745b;
    }

    public void d(Bundle bundle) {
        this.f29745b = bundle.getBoolean("expanded", false);
        this.f29746c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f29745b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f29745b);
        bundle.putInt("expandedComponentIdHint", this.f29746c);
        return bundle;
    }

    public void f(int i2) {
        this.f29746c = i2;
    }
}
