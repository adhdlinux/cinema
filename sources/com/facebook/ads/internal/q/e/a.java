package com.facebook.ads.internal.q.e;

import android.content.Context;
import android.os.PowerManager;
import android.util.Log;
import com.facebook.ads.internal.q.d.b;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20762a = "a";

    public static boolean a(Context context) {
        return b(context) && b.b(context);
    }

    public static boolean b(Context context) {
        if (context == null) {
            Log.v(f20762a, "Invalid context in screen interactive check, assuming interactive.");
            return true;
        }
        try {
            return ((PowerManager) context.getSystemService("power")).isInteractive();
        } catch (Exception e2) {
            Log.e(f20762a, "Exception in screen interactive check, assuming interactive.", e2);
            com.facebook.ads.internal.q.d.a.a(context, "risky", b.f20757q, e2);
            return true;
        }
    }
}
