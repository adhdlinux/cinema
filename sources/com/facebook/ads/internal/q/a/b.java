package com.facebook.ads.internal.q.a;

import android.text.TextUtils;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f20593a = false;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f20594b = false;

    public static synchronized String a(String str) {
        synchronized (b.class) {
            if (!a()) {
                return null;
            }
            String property = System.getProperty("fb.e2e." + str);
            return property;
        }
    }

    public static synchronized boolean a() {
        boolean z2;
        synchronized (b.class) {
            if (!f20594b) {
                f20593a = "true".equals(System.getProperty("fb.running_e2e"));
                f20594b = true;
            }
            z2 = f20593a;
        }
        return z2;
    }

    public static synchronized boolean b(String str) {
        boolean z2;
        synchronized (b.class) {
            z2 = !TextUtils.isEmpty(a(str));
        }
        return z2;
    }
}
