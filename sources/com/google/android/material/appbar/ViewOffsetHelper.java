package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewOffsetHelper {

    /* renamed from: a  reason: collision with root package name */
    private final View f29491a;

    /* renamed from: b  reason: collision with root package name */
    private int f29492b;

    /* renamed from: c  reason: collision with root package name */
    private int f29493c;

    /* renamed from: d  reason: collision with root package name */
    private int f29494d;

    /* renamed from: e  reason: collision with root package name */
    private int f29495e;

    public ViewOffsetHelper(View view) {
        this.f29491a = view;
    }

    private void f() {
        View view = this.f29491a;
        ViewCompat.c0(view, this.f29494d - (view.getTop() - this.f29492b));
        View view2 = this.f29491a;
        ViewCompat.b0(view2, this.f29495e - (view2.getLeft() - this.f29493c));
    }

    public int a() {
        return this.f29492b;
    }

    public int b() {
        return this.f29494d;
    }

    public void c() {
        this.f29492b = this.f29491a.getTop();
        this.f29493c = this.f29491a.getLeft();
        f();
    }

    public boolean d(int i2) {
        if (this.f29495e == i2) {
            return false;
        }
        this.f29495e = i2;
        f();
        return true;
    }

    public boolean e(int i2) {
        if (this.f29494d == i2) {
            return false;
        }
        this.f29494d = i2;
        f();
        return true;
    }
}
