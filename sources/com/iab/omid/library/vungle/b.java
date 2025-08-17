package com.iab.omid.library.vungle;

import android.content.Context;
import com.iab.omid.library.vungle.internal.i;
import com.iab.omid.library.vungle.internal.j;
import com.iab.omid.library.vungle.utils.a;
import com.iab.omid.library.vungle.utils.c;
import com.iab.omid.library.vungle.utils.e;
import com.iab.omid.library.vungle.utils.g;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f31690a;

    private void c(Context context) {
        g.c(context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        c(context);
        if (!d()) {
            b(true);
            i.d().b(context);
            com.iab.omid.library.vungle.internal.b.k().a(context);
            a.b(context);
            c.d(context);
            e.c(context);
            com.iab.omid.library.vungle.internal.g.c().b(context);
            com.iab.omid.library.vungle.internal.a.a().b(context);
            j.f().b(context);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.f31690a = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f31690a;
    }
}
