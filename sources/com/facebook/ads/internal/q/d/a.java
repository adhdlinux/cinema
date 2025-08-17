package com.facebook.ads.internal.q.d;

import android.content.Context;
import com.facebook.ads.internal.f.e;
import com.facebook.ads.internal.i.c;
import java.util.Map;
import java.util.Set;

public class a {
    public static void a(Context context, String str, int i2, Exception exc) {
        if (a(context, str, i2, Math.random())) {
            b(context, str, i2, exc);
        }
    }

    static boolean a(Context context, String str, int i2, double d2) {
        double d3;
        double d4;
        Set<String> i3 = com.facebook.ads.internal.l.a.i(context);
        if (i3.contains(str + ":" + i2)) {
            d3 = (double) (com.facebook.ads.internal.l.a.k(context) * com.facebook.ads.internal.l.a.j(context));
            d4 = 10000.0d;
        } else {
            d3 = (double) com.facebook.ads.internal.l.a.k(context);
            d4 = 100.0d;
        }
        return d2 >= 1.0d - (d3 / d4);
    }

    private static void b(Context context, String str, int i2, Exception exc) {
        Map<String, String> b2 = new c(context, false).b();
        b2.put("subtype", str);
        b2.put("subtype_code", String.valueOf(i2));
        e.a(exc, context, b2);
    }
}
