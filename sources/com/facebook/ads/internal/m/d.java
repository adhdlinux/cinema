package com.facebook.ads.internal.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.e.a;
import com.facebook.ads.internal.m.a;
import com.facebook.ads.internal.q.a.n;
import com.facebook.ads.internal.q.c.e;
import java.util.Map;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20277a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static double f20278b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    private static String f20279c = null;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f20280d = false;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: h  reason: collision with root package name */
    private static c f20281h;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final b f20282e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.ads.internal.e.d f20283f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f20284g;

    private d(Context context) {
        this.f20284g = context.getApplicationContext();
        com.facebook.ads.internal.e.d dVar = new com.facebook.ads.internal.e.d(context);
        this.f20283f = dVar;
        b bVar = new b(context, new g(context, dVar));
        this.f20282e = bVar;
        bVar.b();
        b(context);
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (d.class) {
            if (f20281h == null) {
                f20281h = new d(context.getApplicationContext());
            }
            cVar = f20281h;
        }
        return cVar;
    }

    private void a(final a aVar) {
        if (!aVar.g()) {
            String str = f20277a;
            Log.e(str, "Attempting to log an invalid " + aVar.i() + " event.");
            return;
        }
        this.f20283f.a(aVar.a(), aVar.h().f20290c, aVar.i().toString(), aVar.b(), aVar.c(), aVar.d(), aVar.e(), new a<String>() {
            public void a(int i2, String str) {
                super.a(i2, str);
            }

            public void a(String str) {
                super.a(str);
                if (aVar.f()) {
                    d.this.f20282e.a();
                } else {
                    d.this.f20282e.b();
                }
            }
        });
    }

    private static synchronized void b(Context context) {
        synchronized (d.class) {
            if (!f20280d) {
                com.facebook.ads.internal.i.a.a(context).a();
                n.a();
                f20278b = n.b();
                f20279c = n.c();
                f20280d = true;
            }
        }
    }

    public void a(String str) {
        new e(this.f20284g).execute(new String[]{str});
    }

    public void a(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.IMMEDIATE).a(f.IMPRESSION).a(true).a());
        }
    }

    public void a(String str, Map<String, String> map, String str2, e eVar) {
        a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(eVar).a(f.a(str2)).a(true).a());
    }

    public void b(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.IMMEDIATE).a(f.INVALIDATION).a(false).a());
        }
    }

    public void c(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.IMMEDIATE).a(f.OPEN_LINK).a(true).a());
        }
    }

    public void d(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.DEFERRED).a(f.OFF_TARGET_CLICK).a(true).a());
        }
    }

    public void e(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.IMMEDIATE).a(f.VIDEO).a(true).a());
        }
    }

    public void f(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.DEFERRED).a(f.NATIVE_VIEW).a(false).a());
        }
    }

    public void g(String str, Map<String, String> map) {
        a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.DEFERRED).a(f.BROWSER_SESSION).a(false).a());
    }

    public void h(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.IMMEDIATE).a(f.STORE).a(true).a());
        }
    }

    public void i(String str, Map<String, String> map) {
        if (!TextUtils.isEmpty(str)) {
            a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.DEFERRED).a(f.CLOSE).a(true).a());
        }
    }

    public void j(String str, Map<String, String> map) {
        a(new a.C0034a().a(str).a(f20278b).b(f20279c).a(map).a(e.IMMEDIATE).a(f.USER_RETURN).a(true).a());
    }
}
