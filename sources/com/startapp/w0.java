package com.startapp;

import android.content.Context;
import java.security.PublicKey;

public class w0 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f36757a = "insight Core SDK";

    /* renamed from: b  reason: collision with root package name */
    public static final String f36758b = "© 2014 - 2020 umlaut insight GmbH";

    /* renamed from: c  reason: collision with root package name */
    public static final String f36759c = "20211123190300";

    /* renamed from: d  reason: collision with root package name */
    private static w0 f36760d;

    /* renamed from: e  reason: collision with root package name */
    private u0 f36761e;

    /* renamed from: f  reason: collision with root package name */
    private r2 f36762f;

    /* renamed from: g  reason: collision with root package name */
    private x0 f36763g;

    /* renamed from: h  reason: collision with root package name */
    private Context f36764h;

    /* renamed from: i  reason: collision with root package name */
    private PublicKey f36765i;

    /* renamed from: j  reason: collision with root package name */
    private a f36766j;

    public interface a {
        void a(String str);
    }

    private w0(Context context) {
        this.f36764h = context;
    }

    public static void a(Context context, int i2) {
        try {
            a(context, e3.a(context.getResources().openRawResource(i2)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Error while opening the raw resource");
        }
    }

    public static u0 b() {
        return f36760d.f36761e;
    }

    public static x0 c() {
        return f36760d.f36763g;
    }

    public static a d() {
        return f36760d.f36766j;
    }

    public static PublicKey e() {
        return f36760d.f36765i;
    }

    public static synchronized r2 f() {
        r2 r2Var;
        synchronized (w0.class) {
            r2Var = f36760d.f36762f;
        }
        return r2Var;
    }

    private void g() {
        this.f36762f = new r2();
        this.f36763g = new x0(this.f36764h);
    }

    public static boolean h() {
        return f36760d != null;
    }

    public static void a(Context context, byte[] bArr) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        } else if (bArr == null) {
            throw new IllegalArgumentException("config is null");
        } else if (f36760d == null) {
            try {
                v0 a2 = v0.a(bArr);
                w0 w0Var = new w0(context);
                f36760d = w0Var;
                w0Var.f36765i = a2.f36689a;
                w0Var.f36761e = a2.f36690b;
                w0Var.g();
            } catch (Exception unused) {
                throw new IllegalArgumentException("configuration is invalid");
            }
        }
    }

    public static void a(a aVar) {
        f36760d.f36766j = aVar;
    }

    public static String a() {
        return f36760d.f36763g.p();
    }
}
