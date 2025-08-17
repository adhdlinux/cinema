package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;

public class NestedScrollingParentHelper {

    /* renamed from: a  reason: collision with root package name */
    private int f2761a;

    /* renamed from: b  reason: collision with root package name */
    private int f2762b;

    public NestedScrollingParentHelper(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f2761a | this.f2762b;
    }

    public void b(View view, View view2, int i2) {
        c(view, view2, i2, 0);
    }

    public void c(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f2762b = i2;
        } else {
            this.f2761a = i2;
        }
    }

    public void d(View view) {
        e(view, 0);
    }

    public void e(View view, int i2) {
        if (i2 == 1) {
            this.f2762b = 0;
        } else {
            this.f2761a = 0;
        }
    }
}
