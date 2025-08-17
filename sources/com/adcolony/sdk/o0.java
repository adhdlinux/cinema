package com.adcolony.sdk;

import android.content.ContentValues;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import com.adcolony.sdk.o;
import java.util.concurrent.ExecutorService;

class o0 {

    /* renamed from: e  reason: collision with root package name */
    private static o0 f13296e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public n0 f13297a;

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f13298b = z0.P();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public o.b f13299c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f13300d = false;

    class b implements x<o.b> {
        b(o0 o0Var) {
        }

        public void a(o.b bVar) {
        }
    }

    class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f13301b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f13302c;

        c(x xVar, long j2) {
            this.f13301b = xVar;
            this.f13302c = j2;
        }

        public void run() {
            o.b bVar;
            x xVar = this.f13301b;
            if (o0.this.f13300d) {
                bVar = o0.this.f13299c;
            } else {
                bVar = v.b().a(o0.this.f13297a, this.f13302c);
            }
            xVar.a(bVar);
        }
    }

    o0() {
    }

    static ContentValues a(f1 f1Var, n0.a aVar) throws NumberFormatException, NullPointerException {
        ContentValues contentValues = new ContentValues();
        for (n0.b next : aVar.a()) {
            Object G = f1Var.G(next.b());
            if (G != null) {
                if (G instanceof Boolean) {
                    contentValues.put(next.b(), (Boolean) G);
                } else if (G instanceof Long) {
                    contentValues.put(next.b(), (Long) G);
                } else if (G instanceof Double) {
                    contentValues.put(next.b(), (Double) G);
                } else if (G instanceof Number) {
                    Number number = (Number) G;
                    if (number.doubleValue() != ((double) number.longValue()) || !"INTEGER".equalsIgnoreCase(next.c())) {
                        contentValues.put(next.b(), Double.valueOf(number.doubleValue()));
                    } else {
                        contentValues.put(next.b(), Long.valueOf(number.longValue()));
                    }
                } else if (G instanceof String) {
                    contentValues.put(next.b(), (String) G);
                }
            }
        }
        return contentValues;
    }

    private void h(String str, f1 f1Var, n0.a aVar) {
        try {
            ContentValues a2 = a(f1Var, aVar);
            v.b().i(aVar.h(), a2);
            v.b().d(aVar, a2);
            n();
        } catch (NullPointerException | NumberFormatException e2) {
            e2.printStackTrace();
            e0.a aVar2 = new e0.a();
            e0.a c2 = aVar2.c("Error parsing event:" + str + " ").c(f1Var.toString());
            c2.c("Schema version: " + this.f13297a.d() + " ").c(" e: ").c(e2.toString()).d(e0.f13112g);
        }
    }

    static o0 m() {
        if (f13296e == null) {
            synchronized (o0.class) {
                if (f13296e == null) {
                    f13296e = new o0();
                }
            }
        }
        return f13296e;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        f(new b(this));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        r0 = r3.H("request_type");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.adcolony.sdk.h0 r3) {
        /*
            r2 = this;
            com.adcolony.sdk.n0 r0 = r2.f13297a
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.adcolony.sdk.f1 r3 = r3.a()
            if (r3 != 0) goto L_0x000c
            return
        L_0x000c:
            java.lang.String r0 = "payload"
            com.adcolony.sdk.f1 r3 = r3.F(r0)
            if (r3 != 0) goto L_0x0015
            return
        L_0x0015:
            java.lang.String r0 = "request_type"
            java.lang.String r0 = r3.H(r0)
            com.adcolony.sdk.n0 r1 = r2.f13297a
            com.adcolony.sdk.n0$a r1 = r1.a(r0)
            if (r1 == 0) goto L_0x0026
            r2.h(r0, r3, r1)
        L_0x0026:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adcolony.sdk.o0.c(com.adcolony.sdk.h0):void");
    }

    /* access modifiers changed from: package-private */
    public void d(n0 n0Var) {
        this.f13297a = n0Var;
    }

    /* access modifiers changed from: package-private */
    public void e(o.b bVar) {
        this.f13299c = bVar;
        this.f13300d = true;
    }

    /* access modifiers changed from: package-private */
    public void f(x<o.b> xVar) {
        g(xVar, -1);
    }

    /* access modifiers changed from: package-private */
    public void g(x<o.b> xVar, long j2) {
        if (this.f13297a == null) {
            xVar.a(null);
        } else if (this.f13300d) {
            xVar.a(this.f13299c);
        } else if (!z0.q(this.f13298b, new c(xVar, j2))) {
            new e0.a().c("Execute ADCOdtEventsListener.calculateFeatureVectors failed").d(e0.f13114i);
        }
    }

    /* access modifiers changed from: package-private */
    public o.b j() {
        return this.f13299c;
    }

    /* access modifiers changed from: package-private */
    public void n() {
        this.f13300d = false;
    }
}
