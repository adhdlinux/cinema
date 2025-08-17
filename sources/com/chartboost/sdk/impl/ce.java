package com.chartboost.sdk.impl;

import android.view.View;

public class ce extends qe {

    /* renamed from: d  reason: collision with root package name */
    public static ce f17391d = new ce();

    public static ce g() {
        return f17391d;
    }

    public void b(boolean z2) {
        for (qd k2 : ke.c().b()) {
            k2.k().a(z2);
        }
    }

    public boolean d() {
        for (qd e2 : ke.c().a()) {
            View e3 = e2.e();
            if (e3 != null && e3.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
