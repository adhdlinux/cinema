package com.facebook.ads.internal.view.component.a;

import android.util.DisplayMetrics;
import com.facebook.ads.internal.adapters.a.d;
import com.facebook.ads.internal.adapters.a.h;
import com.facebook.ads.internal.q.a.x;
import com.facebook.ads.internal.view.component.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21088a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21089b;

    static {
        DisplayMetrics displayMetrics = x.f20693a;
        f21088a = displayMetrics.heightPixels;
        f21089b = displayMetrics.widthPixels;
    }

    private static float a(h hVar) {
        int h2 = hVar.c().h();
        int i2 = hVar.c().i();
        if (i2 > 0) {
            return ((float) h2) / ((float) i2);
        }
        return -1.0f;
    }

    private static int a(int i2) {
        int a2 = x.a(16) + (a.f21040a * 2);
        return (f21088a - i2) - (a2 + (b.f21083a * 2));
    }

    public static b a(d dVar) {
        b bVar;
        boolean z2 = true;
        d a2 = dVar.k() == 1 ? dVar.g().b().a() : dVar.g().b().b();
        h hVar = dVar.g().d().get(0);
        double a3 = (double) a(hVar);
        if (a(dVar.k(), dVar.j(), a3)) {
            if (dVar.k() != 2) {
                z2 = false;
            }
            bVar = new a(dVar, a2, z2);
        } else {
            bVar = new e(dVar, a(a3), a2);
        }
        bVar.a(hVar, dVar.g().c(), a3);
        return bVar;
    }

    private static boolean a(double d2) {
        return d2 < 0.9d;
    }

    private static boolean a(double d2, int i2) {
        return a(i2) < b(d2);
    }

    private static boolean a(int i2, int i3, double d2) {
        return i2 == 2 || a(d2, i3);
    }

    private static int b(double d2) {
        return (int) (((double) (f21089b - (b.f21083a * 2))) / d2);
    }
}
