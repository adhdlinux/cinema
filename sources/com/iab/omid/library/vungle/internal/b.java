package com.iab.omid.library.vungle.internal;

import android.annotation.SuppressLint;
import android.view.View;
import com.iab.omid.library.vungle.adsession.a;

public class b extends d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: e  reason: collision with root package name */
    private static b f31702e = new b();

    private b() {
    }

    public static b k() {
        return f31702e;
    }

    public void f(boolean z2) {
        for (a m2 : c.e().c()) {
            m2.m().i(z2);
        }
    }

    public boolean h() {
        for (a h2 : c.e().a()) {
            View h3 = h2.h();
            if (h3 != null && h3.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
