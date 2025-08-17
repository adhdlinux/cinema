package com.startapp;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsCategoryConfig;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public class e9 {

    /* renamed from: a  reason: collision with root package name */
    public final b9 f34453a;

    /* renamed from: b  reason: collision with root package name */
    public final va f34454b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f34455c;

    /* renamed from: d  reason: collision with root package name */
    public final ua<Integer> f34456d;

    /* renamed from: e  reason: collision with root package name */
    public final r8 f34457e;

    /* renamed from: f  reason: collision with root package name */
    public final ta<y8, a9, d9, Runnable> f34458f;

    /* renamed from: g  reason: collision with root package name */
    public final ua<AnalyticsConfig> f34459g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<String, Pair<a9, Long>> f34460h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    public final AtomicLong f34461i = new AtomicLong();

    /* renamed from: j  reason: collision with root package name */
    public final ua<Void> f34462j = new a();

    /* renamed from: k  reason: collision with root package name */
    public final Runnable f34463k = new b();

    /* renamed from: l  reason: collision with root package name */
    public final ua<Void> f34464l = new c();

    /* renamed from: m  reason: collision with root package name */
    public final d9 f34465m = new d();

    /* renamed from: n  reason: collision with root package name */
    public final sa<y8, Void> f34466n = new g();

    public class a implements ua<Void> {
        public a() {
        }

        public Object call() {
            try {
                e9 e9Var = e9.this;
                e9Var.f34454b.execute(new g9(e9Var));
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            try {
                e9.this.b();
            } catch (Throwable unused) {
            }
        }
    }

    public class c implements ua<Void> {
        public c() {
        }

        public Object call() {
            try {
                e9.this.a(0);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public class d implements d9 {
        public d() {
        }

        public void a(y8 y8Var, int i2) {
            try {
                e9 e9Var = e9.this;
                e9Var.getClass();
                e9Var.f34454b.execute(new f9(e9Var, y8Var, i2, System.currentTimeMillis()));
            } catch (Throwable unused) {
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8 f34471a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a9 f34472b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d9 f34473c;

        public e(y8 y8Var, a9 a9Var, d9 d9Var) {
            this.f34471a = y8Var;
            this.f34472b = a9Var;
            this.f34473c = d9Var;
        }

        public void run() {
            int i2;
            e9 e9Var = e9.this;
            y8 y8Var = this.f34471a;
            a9 a9Var = this.f34472b;
            d9 d9Var = this.f34473c;
            e9Var.getClass();
            try {
                if (e9Var.f34453a.a(y8Var, a9Var)) {
                    i2 = 2;
                } else {
                    i2 = 3;
                }
                if (d9Var == null) {
                    return;
                }
            } catch (Throwable unused) {
                if (d9Var != null) {
                    i2 = 0;
                } else {
                    return;
                }
            }
            d9Var.a(y8Var, i2);
        }
    }

    public class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y8 f34475a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a9 f34476b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d9 f34477c;

        public f(long j2, y8 y8Var, a9 a9Var, d9 d9Var) {
            this.f34475a = y8Var;
            this.f34476b = a9Var;
            this.f34477c = d9Var;
        }

        public void run() {
            e9.this.a(this.f34475a, this.f34476b, this.f34477c);
        }
    }

    public class g implements sa<y8, Void> {
        public g() {
        }

        public Object a(Object obj) {
            y8 y8Var = (y8) obj;
            if (y8Var == null) {
                return null;
            }
            try {
                e9.this.a(y8Var);
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    public e9(b9 b9Var, va vaVar, Executor executor, ua<Integer> uaVar, r8 r8Var, ta<y8, a9, d9, Runnable> taVar, ua<AnalyticsConfig> uaVar2) {
        this.f34453a = b9Var;
        this.f34454b = vaVar;
        this.f34455c = executor;
        this.f34456d = uaVar;
        this.f34457e = r8Var;
        this.f34458f = taVar;
        this.f34459g = uaVar2;
    }

    /* JADX INFO: finally extract failed */
    public void a(y8 y8Var) {
        a9 a2 = a(y8Var.f36951a);
        long uptimeMillis = (this.f34461i.get() + a2.f34199f) - SystemClock.uptimeMillis();
        if (uptimeMillis > 0) {
            a(uptimeMillis);
            return;
        }
        b9 b9Var = this.f34453a;
        long currentTimeMillis = System.currentTimeMillis();
        b9Var.getClass();
        long j2 = y8Var.f36952b;
        b9.a(j2, currentTimeMillis);
        SQLiteDatabase a3 = b9Var.a();
        a3.beginTransaction();
        try {
            int a4 = b9.a(a3, j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("send", Long.valueOf(currentTimeMillis));
            contentValues.put("attempt", Integer.valueOf(a4 + 1));
            a3.update("events", contentValues, "rowid = ?", new String[]{String.valueOf(j2)});
            a3.setTransactionSuccessful();
            a3.endTransaction();
            a(y8Var, a2, this.f34465m);
        } catch (Throwable th) {
            a3.endTransaction();
            throw th;
        }
    }

    public void b() {
        int i2;
        this.f34454b.a(this.f34463k);
        if (!this.f34457e.a()) {
            AnalyticsConfig call = this.f34459g.call();
            long j2 = 300000;
            if (call != null) {
                j2 = Math.max(300000, lb.e(call.e()));
            }
            a(j2);
            return;
        }
        Integer call2 = this.f34456d.call();
        int i3 = 1;
        if (call2 != null) {
            i2 = Math.max(1, call2.intValue());
        } else {
            i2 = 1;
        }
        AnalyticsConfig call3 = this.f34459g.call();
        if (call3 != null) {
            i3 = Math.max(1, call3.f());
        }
        try {
            this.f34453a.a(this.f34466n, i3, i2);
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (this.f34461i.compareAndSet(0, SystemClock.uptimeMillis())) {
            b9 b9Var = this.f34453a;
            ua<Void> uaVar = this.f34464l;
            synchronized (b9Var) {
                b9Var.f34248d.add(uaVar);
            }
            r8 r8Var = this.f34457e;
            ua<Void> uaVar2 = this.f34462j;
            synchronized (r8Var) {
                if (!r8Var.f35767d.contains(uaVar2)) {
                    r8Var.f35767d.add(uaVar2);
                }
            }
            r8 r8Var2 = this.f34457e;
            if (!r8Var2.f35768e.getAndSet(true)) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) r8Var2.f35764a.getSystemService("connectivity");
                    if (connectivityManager != null) {
                        if (Build.VERSION.SDK_INT < 24 || !hc.a(r8Var2.f35764a, "android.permission.ACCESS_NETWORK_STATE")) {
                            ConnectivityManager.OnNetworkActiveListener onNetworkActiveListener = r8Var2.f35766c;
                            if (onNetworkActiveListener != null) {
                                connectivityManager.addDefaultNetworkActiveListener(onNetworkActiveListener);
                            }
                        } else {
                            ConnectivityManager.NetworkCallback networkCallback = r8Var2.f35765b;
                            if (networkCallback != null) {
                                connectivityManager.registerDefaultNetworkCallback(networkCallback);
                            }
                        }
                    }
                } catch (Throwable th) {
                    y8.a(r8Var2.f35764a, th);
                }
            }
            this.f34454b.execute(new g9(this));
        }
    }

    public final a9 a(z8 z8Var) {
        a9 a9Var;
        Map<String, AnalyticsCategoryConfig> c2;
        AnalyticsCategoryConfig analyticsCategoryConfig;
        synchronized (this.f34460h) {
            Pair pair = this.f34460h.get(z8Var.f37008o);
            a9Var = (pair == null || SystemClock.uptimeMillis() >= ((Long) pair.second).longValue()) ? null : (a9) pair.first;
        }
        if (a9Var != null) {
            return a9Var;
        }
        AnalyticsConfig call = this.f34459g.call();
        if (!(call == null || (c2 = call.c()) == null || (analyticsCategoryConfig = c2.get(z8Var.f37008o)) == null)) {
            a9Var = new a9(z8Var.f37009p, analyticsCategoryConfig);
        }
        if (a9Var == null) {
            a9Var = z8Var.f37009p;
        }
        synchronized (this.f34460h) {
            this.f34460h.put(z8Var.f37008o, new Pair(a9Var, Long.valueOf(SystemClock.uptimeMillis() + NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS)));
        }
        return a9Var;
    }

    public void a(y8 y8Var, d9 d9Var) {
        AnalyticsConfig call = this.f34459g.call();
        if (call != null && !call.dns) {
            a9 a2 = a(y8Var.f36951a);
            if (Math.random() >= a2.f34194a) {
                if (d9Var != null) {
                    d9Var.a(y8Var, 3);
                }
            } else if (a2.f34197d) {
                this.f34454b.execute(new e(y8Var, a2, d9Var));
            } else if (this.f34457e.a()) {
                long uptimeMillis = (this.f34461i.get() + a2.f34199f) - SystemClock.uptimeMillis();
                if (uptimeMillis > 0) {
                    this.f34454b.a(new f(uptimeMillis, y8Var, a2, d9Var), uptimeMillis);
                } else {
                    a(y8Var, a2, d9Var);
                }
            } else if (d9Var != null) {
                d9Var.a(y8Var, 3);
            }
        } else if (d9Var != null) {
            d9Var.a(y8Var, 3);
        }
    }

    public void a(long j2) {
        if (j2 < 0) {
            j2 = 0;
        }
        this.f34454b.a(this.f34463k, j2);
    }

    /* JADX INFO: finally extract failed */
    public void a(y8 y8Var, int i2, long j2) {
        if (i2 == 1) {
            b9 b9Var = this.f34453a;
            b9Var.getClass();
            long j3 = y8Var.f36952b;
            b9.a(j3, j2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("sendSuccess", Long.valueOf(j2));
            b9Var.a().update("events", contentValues, "rowid = ?", new String[]{String.valueOf(j3)});
            a(0);
            return;
        }
        AnalyticsConfig call = this.f34459g.call();
        int max = call != null ? Math.max(1, call.f()) : 1;
        b9 b9Var2 = this.f34453a;
        b9Var2.getClass();
        long j4 = y8Var.f36952b;
        b9.a(j4, j2);
        SQLiteDatabase a2 = b9Var2.a();
        a2.beginTransaction();
        try {
            if (b9.a(a2, j4) >= max) {
                a2.delete("events", "rowid = ?", new String[]{String.valueOf(j4)});
            } else {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("sendFailure", Long.valueOf(j2));
                a2.update("events", contentValues2, "rowid = ?", new String[]{String.valueOf(j4)});
            }
            a2.setTransactionSuccessful();
            a2.endTransaction();
            AnalyticsConfig call2 = this.f34459g.call();
            long j5 = 1000;
            if (call2 != null) {
                j5 = Math.max(1000, call2.g());
            }
            a(j5);
        } catch (Throwable th) {
            a2.endTransaction();
            throw th;
        }
    }

    public void a(y8 y8Var, a9 a9Var, d9 d9Var) {
        vc vcVar = (vc) this.f34458f;
        vcVar.getClass();
        i9 i9Var = (y8Var == null || a9Var == null) ? null : new i9(vcVar.f36744a.f36483b, y8Var, a9Var, d9Var);
        if (i9Var != null) {
            this.f34455c.execute(i9Var);
        } else if (d9Var != null) {
            d9Var.a(y8Var, 0);
        }
    }
}
