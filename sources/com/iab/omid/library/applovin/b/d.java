package com.iab.omid.library.applovin.b;

import android.annotation.SuppressLint;
import android.content.Context;

public class d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static d f31497a = new d();

    /* renamed from: b  reason: collision with root package name */
    private Context f31498b;

    private d() {
    }

    public static d a() {
        return f31497a;
    }

    public void a(Context context) {
        this.f31498b = context != null ? context.getApplicationContext() : null;
    }

    public Context b() {
        return this.f31498b;
    }
}
