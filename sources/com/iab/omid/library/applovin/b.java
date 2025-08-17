package com.iab.omid.library.applovin;

import android.content.Context;
import com.iab.omid.library.applovin.b.d;
import com.iab.omid.library.applovin.b.f;
import com.iab.omid.library.applovin.d.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31485a;

    private void b(Context context) {
        e.a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return "1.3.30-Applovin";
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        b(context);
        if (!b()) {
            a(true);
            f.a().a(context);
            com.iab.omid.library.applovin.b.b.a().a(context);
            com.iab.omid.library.applovin.d.b.a(context);
            d.a().a(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f31485a = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f31485a;
    }
}
