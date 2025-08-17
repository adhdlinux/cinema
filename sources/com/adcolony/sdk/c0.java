package com.adcolony.sdk;

import com.adcolony.sdk.e0;
import java.io.IOException;
import org.json.JSONException;

class c0 {
    static int A(f1 f1Var, String str) {
        return f1Var.B(str);
    }

    static e1 B(f1 f1Var, String str) {
        return f1Var.D(str);
    }

    static f1 C(f1 f1Var, String str) {
        return f1Var.E(str);
    }

    static Object D(f1 f1Var, String str) {
        Object G = f1Var.G(str);
        if (G == null) {
            return Boolean.FALSE;
        }
        return G;
    }

    static String E(f1 f1Var, String str) {
        return f1Var.H(str);
    }

    static String F(f1 f1Var, String str) {
        return f1Var.I(str);
    }

    static boolean G(f1 f1Var, String str) {
        try {
            a.f().B0().f(str, f1Var.toString(), false);
            return true;
        } catch (IOException e2) {
            new e0.a().c("IOException in ADCJSON's saveObject: ").c(e2.toString()).d(e0.f13114i);
            return false;
        }
    }

    static int a(f1 f1Var, String str, int i2) {
        return f1Var.b(str, i2);
    }

    static long b(f1 f1Var, String str, long j2) {
        return f1Var.c(str, j2);
    }

    static e1 c() {
        return new e1();
    }

    static e1 d(f1 f1Var, String str) {
        return f1Var.C(str);
    }

    static e1 e(String str) {
        try {
            return new e1(str);
        } catch (JSONException e2) {
            new e0.a().c(e2.toString()).d(e0.f13114i);
            return new e1();
        }
    }

    static f1 f(e1 e1Var, int i2) {
        return e1Var.h(i2);
    }

    static f1 g(String str, String str2) {
        String str3;
        try {
            return new f1(str);
        } catch (JSONException e2) {
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2 + ": " + e2.toString();
            }
            new e0.a().c(str3).d(e0.f13114i);
            return new f1();
        }
    }

    static f1 h(f1... f1VarArr) {
        f1 f1Var = new f1();
        for (f1 i2 : f1VarArr) {
            f1Var.i(i2);
        }
        return f1Var;
    }

    static void i(e1 e1Var, f1 f1Var) {
        e1Var.a(f1Var);
    }

    static void j(e1 e1Var, String str) {
        e1Var.g(str);
    }

    static boolean k(f1 f1Var, String str, double d2) {
        try {
            f1Var.m(str, d2);
            return true;
        } catch (JSONException unused) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putDouble(): ");
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + d2).d(e0.f13114i);
            return false;
        }
    }

    static boolean l(f1 f1Var, String str, e1 e1Var) {
        try {
            f1Var.d(str, e1Var);
            return true;
        } catch (JSONException e2) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putArray(): ").c(e2.toString());
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + e1Var).d(e0.f13114i);
            return false;
        }
    }

    static boolean m(f1 f1Var, String str, f1 f1Var2) {
        try {
            f1Var.e(str, f1Var2);
            return true;
        } catch (JSONException e2) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putObject(): ").c(e2.toString());
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + f1Var2).d(e0.f13114i);
            return false;
        }
    }

    static boolean n(f1 f1Var, String str, String str2) {
        try {
            f1Var.f(str, str2);
            return true;
        } catch (JSONException e2) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putString(): ").c(e2.toString());
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + str2).d(e0.f13114i);
            return false;
        }
    }

    static boolean o(f1 f1Var, String str, boolean z2) {
        return f1Var.k(str, z2);
    }

    static String[] p(e1 e1Var) {
        return e1Var.k();
    }

    static f1 q() {
        return new f1();
    }

    static f1 r(String str) {
        return g(str, (String) null);
    }

    static String s(e1 e1Var, int i2) {
        return e1Var.j(i2);
    }

    static boolean t(f1 f1Var, String str) {
        return f1Var.y(str);
    }

    static boolean u(f1 f1Var, String str, int i2) {
        try {
            f1Var.n(str, i2);
            return true;
        } catch (JSONException e2) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putInteger(): ").c(e2.toString());
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + i2).d(e0.f13114i);
            return false;
        }
    }

    static boolean v(f1 f1Var, String str, long j2) {
        try {
            f1Var.o(str, j2);
            return true;
        } catch (JSONException e2) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putLong(): ").c(e2.toString());
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + j2).d(e0.f13114i);
            return false;
        }
    }

    static boolean w(f1 f1Var, String str, boolean z2) {
        try {
            f1Var.p(str, z2);
            return true;
        } catch (JSONException e2) {
            e0.a c2 = new e0.a().c("JSON error in ADCJSON putBoolean(): ").c(e2.toString());
            e0.a c3 = c2.c(" with key: " + str);
            c3.c(" and value: " + z2).d(e0.f13114i);
            return false;
        }
    }

    static f1[] x(e1 e1Var) {
        return e1Var.i();
    }

    static double y(f1 f1Var, String str) {
        return f1Var.a(str, 0.0d);
    }

    static f1 z(String str) {
        try {
            String sb = a.f().B0().a(str, false).toString();
            return g(sb, "loadObject from filepath " + str);
        } catch (IOException e2) {
            new e0.a().c("IOException in ADCJSON's loadObject: ").c(e2.toString()).d(e0.f13114i);
            return q();
        }
    }
}
