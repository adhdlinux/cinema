package com.iab.omid.library.vungle.internal;

import android.annotation.SuppressLint;
import android.content.Context;

public class g {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static g f31715b = new g();

    /* renamed from: a  reason: collision with root package name */
    private Context f31716a;

    private g() {
    }

    public static g c() {
        return f31715b;
    }

    public Context a() {
        return this.f31716a;
    }

    public void b(Context context) {
        this.f31716a = context != null ? context.getApplicationContext() : null;
    }
}
