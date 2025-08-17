package com.chartboost.sdk.impl;

import android.text.TextUtils;

public abstract class df {
    public static void a() {
        if (!l8.b()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    public static void b(qd qdVar) {
        if (qdVar.i()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    public static void c(qd qdVar) {
        if (qdVar.n()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    public static void d(qd qdVar) {
        if (!qdVar.n()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }

    public static void e(qd qdVar) {
        if (!qdVar.l()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    public static void f(qd qdVar) {
        if (!qdVar.m()) {
            throw new IllegalStateException("Cannot create MediaEvents for JavaScript AdSession");
        }
    }

    public static void g(qd qdVar) {
        if (qdVar.k().c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    public static void h(qd qdVar) {
        if (qdVar.k().d() != null) {
            throw new IllegalStateException("MediaEvents already exists for AdSession");
        }
    }

    public static void a(d9 d9Var, c4 c4Var, h7 h7Var) {
        if (d9Var == d9.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        } else if (c4Var == c4.DEFINED_BY_JAVASCRIPT && d9Var == d9.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        } else if (h7Var == h7.DEFINED_BY_JAVASCRIPT && d9Var == d9.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
    }

    public static void a(qd qdVar) {
        d(qdVar);
        b(qdVar);
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void a(String str, int i2, String str2) {
        if (str.length() > i2) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }
}
