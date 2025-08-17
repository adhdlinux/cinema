package com.iab.omid.library.adcolony;

import android.content.Context;
import com.iab.omid.library.adcolony.b.d;
import com.iab.omid.library.adcolony.b.f;
import com.iab.omid.library.adcolony.d.e;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31368a;

    private void c(Context context) {
        e.d(context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        c(context);
        if (!d()) {
            b(true);
            f.a().b(context);
            com.iab.omid.library.adcolony.b.b.a().b(context);
            com.iab.omid.library.adcolony.d.b.c(context);
            d.a().b(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.f31368a = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f31368a;
    }
}
