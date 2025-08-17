package com.adcolony.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import com.adcolony.sdk.o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

class v {

    /* renamed from: f  reason: collision with root package name */
    private static v f13440f;

    /* renamed from: a  reason: collision with root package name */
    private final Executor f13441a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private SQLiteDatabase f13442b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13443c = false;

    /* renamed from: d  reason: collision with root package name */
    private c f13444d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f13445e = new HashSet();

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f1 f13446b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x f13447c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f13448d;

        a(f1 f1Var, x xVar, Context context) {
            this.f13446b = f1Var;
            this.f13447c = xVar;
            this.f13448d = context;
        }

        public void run() {
            n0 b2 = n0.b(this.f13446b);
            if (b2 != null) {
                v.this.e(b2, this.f13447c, this.f13448d);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f13450b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ContentValues f13451c;

        b(String str, ContentValues contentValues) {
            this.f13450b = str;
            this.f13451c = contentValues;
        }

        public void run() {
            v.this.l(this.f13450b, this.f13451c);
        }
    }

    interface c {
        void a();
    }

    v() {
    }

    public static v b() {
        if (f13440f == null) {
            synchronized (v.class) {
                if (f13440f == null) {
                    f13440f = new v();
                }
            }
        }
        return f13440f;
    }

    /* access modifiers changed from: private */
    public synchronized void e(n0 n0Var, x<n0> xVar, Context context) {
        try {
            SQLiteDatabase sQLiteDatabase = this.f13442b;
            boolean z2 = false;
            if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                this.f13442b = context.openOrCreateDatabase("adc_events_db", 0, (SQLiteDatabase.CursorFactory) null);
            }
            if (this.f13442b.needUpgrade(n0Var.d())) {
                if (j(n0Var) && this.f13444d != null) {
                    z2 = true;
                }
                this.f13443c = z2;
                if (z2) {
                    this.f13444d.a();
                }
            } else {
                this.f13443c = true;
            }
            if (this.f13443c) {
                xVar.a(n0Var);
            }
        } catch (SQLiteException e2) {
            new e0.a().c("Database cannot be opened").c(e2.toString()).d(e0.f13112g);
        }
        return;
    }

    private boolean j(n0 n0Var) {
        return new n(this.f13442b, n0Var).k();
    }

    /* access modifiers changed from: private */
    public synchronized void l(String str, ContentValues contentValues) {
        p.b(str, contentValues, this.f13442b);
    }

    /* access modifiers changed from: package-private */
    public o.b a(n0 n0Var, long j2) {
        if (this.f13443c) {
            return o.a(n0Var, this.f13442b, this.f13441a, j2);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void c(f1 f1Var, x<n0> xVar) {
        Context context;
        if (a.h()) {
            context = a.a().getApplicationContext();
        } else {
            context = null;
        }
        if (context != null && f1Var != null) {
            try {
                this.f13441a.execute(new a(f1Var, xVar, context));
            } catch (RejectedExecutionException e2) {
                e0.a aVar = new e0.a();
                aVar.c("ADCEventsRepository.open failed with: " + e2.toString()).d(e0.f13114i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(n0.a aVar, ContentValues contentValues) {
        String str;
        long j2;
        if (aVar != null && !this.f13445e.contains(aVar.h())) {
            this.f13445e.add(aVar.h());
            int e2 = aVar.e();
            n0.d i2 = aVar.i();
            if (i2 != null) {
                j2 = contentValues.getAsLong(i2.a()).longValue() - i2.b();
                str = i2.a();
            } else {
                str = null;
                j2 = -1;
            }
            p.a(e2, j2, str, aVar.h(), this.f13442b);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(c cVar) {
        this.f13444d = cVar;
    }

    /* access modifiers changed from: package-private */
    public void i(String str, ContentValues contentValues) {
        if (this.f13443c) {
            try {
                this.f13441a.execute(new b(str, contentValues));
            } catch (RejectedExecutionException e2) {
                e0.a aVar = new e0.a();
                aVar.c("ADCEventsRepository.saveEvent failed with: " + e2.toString()).d(e0.f13114i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f13445e.clear();
    }
}
