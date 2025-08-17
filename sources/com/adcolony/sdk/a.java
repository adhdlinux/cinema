package com.adcolony.sdk;

import android.annotation.SuppressLint;
import android.content.Context;

class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Context f12892a = null;

    /* renamed from: b  reason: collision with root package name */
    private static k f12893b = null;

    /* renamed from: c  reason: collision with root package name */
    static boolean f12894c = false;

    /* renamed from: d  reason: collision with root package name */
    static boolean f12895d = false;

    /* renamed from: e  reason: collision with root package name */
    static boolean f12896e = false;

    static Context a() {
        return f12892a;
    }

    static j0 b(String str, j0 j0Var, boolean z2) {
        f().F0().i(str, j0Var);
        return j0Var;
    }

    static void c(Context context) {
        f12892a = context;
    }

    static void d(String str, f1 f1Var) {
        if (f1Var == null) {
            f1Var = c0.q();
        }
        c0.n(f1Var, "m_type", str);
        f().F0().r(f1Var);
    }

    static void e(String str, j0 j0Var) {
        f().F0().i(str, j0Var);
    }

    static k f() {
        if (!i()) {
            Context a2 = a();
            if (a2 == null) {
                return new k();
            }
            f12893b = new k();
            f12893b.w(new AdColonyAppOptions().a(c0.E(c0.z(a2.getFilesDir().getAbsolutePath() + "/adc3/AppInfo"), "appId")), false);
        }
        return f12893b;
    }

    static void g(String str, j0 j0Var) {
        f().F0().n(str, j0Var);
    }

    static boolean h() {
        return f12892a != null;
    }

    static boolean i() {
        return f12893b != null;
    }

    static boolean j() {
        return f12894c;
    }

    static void k() {
        f().F0().y();
    }
}
