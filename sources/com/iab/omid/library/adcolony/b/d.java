package com.iab.omid.library.adcolony.b;

import android.annotation.SuppressLint;
import android.content.Context;

public class d {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: b  reason: collision with root package name */
    private static d f31380b = new d();

    /* renamed from: a  reason: collision with root package name */
    private Context f31381a;

    private d() {
    }

    public static d a() {
        return f31380b;
    }

    public void b(Context context) {
        this.f31381a = context != null ? context.getApplicationContext() : null;
    }

    public Context c() {
        return this.f31381a;
    }
}
