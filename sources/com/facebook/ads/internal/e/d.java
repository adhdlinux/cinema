package com.facebook.ads.internal.e;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import com.facebook.ads.internal.e.f;
import com.facebook.ads.internal.q.d.b;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20102a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f20103b;

    /* renamed from: c  reason: collision with root package name */
    private static final int f20104c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f20105d;

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadFactory f20106e;

    /* renamed from: f  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f20107f;

    /* renamed from: g  reason: collision with root package name */
    private static final Executor f20108g;

    /* renamed from: h  reason: collision with root package name */
    private static final ReentrantReadWriteLock f20109h;

    /* renamed from: i  reason: collision with root package name */
    private static final Lock f20110i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static final Lock f20111j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final Context f20112k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final h f20113l = new h(this);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final c f20114m = new c(this);

    /* renamed from: n  reason: collision with root package name */
    private SQLiteOpenHelper f20115n;

    private static class a<T> extends AsyncTask<Void, Void, T> {

        /* renamed from: a  reason: collision with root package name */
        private final f<T> f20125a;

        /* renamed from: b  reason: collision with root package name */
        private final a<T> f20126b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f20127c;

        /* renamed from: d  reason: collision with root package name */
        private f.a f20128d;

        a(Context context, f<T> fVar, a<T> aVar) {
            this.f20125a = fVar;
            this.f20126b = aVar;
            this.f20127c = context;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public T doInBackground(Void... voidArr) {
            T t2 = null;
            try {
                t2 = this.f20125a.b();
                this.f20128d = this.f20125a.c();
                return t2;
            } catch (Exception e2) {
                com.facebook.ads.internal.q.d.a.a(this.f20127c, "database", b.f20752l, e2);
                this.f20128d = f.a.UNKNOWN;
                return t2;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(T t2) {
            f.a aVar = this.f20128d;
            if (aVar == null) {
                this.f20126b.a(t2);
            } else {
                this.f20126b.a(aVar.a(), this.f20128d.b());
            }
            this.f20126b.a();
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT tokens.");
        b bVar = h.f20140a;
        sb.append(bVar.f20089b);
        sb.append(", ");
        sb.append("tokens");
        sb.append(".");
        sb.append(h.f20141b.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20091a.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20093c.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20094d.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        b bVar2 = c.f20095e;
        sb.append(bVar2.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20096f.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20097g.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20098h.f20089b);
        sb.append(", ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20099i.f20089b);
        sb.append(" FROM ");
        sb.append("events");
        sb.append(" JOIN ");
        sb.append("tokens");
        sb.append(" ON ");
        sb.append("events");
        sb.append(".");
        sb.append(c.f20092b.f20089b);
        sb.append(" = ");
        sb.append("tokens");
        sb.append(".");
        sb.append(bVar.f20089b);
        sb.append(" ORDER BY ");
        sb.append("events");
        sb.append(".");
        sb.append(bVar2.f20089b);
        sb.append(" ASC");
        f20102a = sb.toString();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f20103b = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 4));
        f20104c = max;
        int i2 = (availableProcessors * 2) + 1;
        f20105d = i2;
        AnonymousClass1 r10 = new ThreadFactory() {

            /* renamed from: a  reason: collision with root package name */
            private final AtomicInteger f20116a = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "DatabaseTask #" + this.f20116a.getAndIncrement());
            }
        };
        f20106e = r10;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f20107f = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(max, i2, 30, TimeUnit.SECONDS, linkedBlockingQueue, r10);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f20108g = threadPoolExecutor;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        f20109h = reentrantReadWriteLock;
        f20110i = reentrantReadWriteLock.readLock();
        f20111j = reentrantReadWriteLock.writeLock();
    }

    public d(Context context) {
        this.f20112k = context;
    }

    private synchronized SQLiteDatabase i() {
        if (this.f20115n == null) {
            this.f20115n = new e(this.f20112k, this);
        }
        return this.f20115n.getWritableDatabase();
    }

    public Cursor a(int i2) {
        Lock lock = f20110i;
        lock.lock();
        try {
            SQLiteDatabase a2 = a();
            Cursor rawQuery = a2.rawQuery(f20102a + " LIMIT " + String.valueOf(i2), (String[]) null);
            lock.unlock();
            return rawQuery;
        } catch (Throwable th) {
            f20110i.unlock();
            throw th;
        }
    }

    public SQLiteDatabase a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return i();
        }
        throw new IllegalStateException("Cannot call getDatabase from the UI thread!");
    }

    public <T> AsyncTask a(f<T> fVar, a<T> aVar) {
        return com.facebook.ads.internal.q.a.d.a(f20108g, new a(this.f20112k.getApplicationContext(), fVar, aVar), new Void[0]);
    }

    public AsyncTask a(String str, int i2, String str2, double d2, double d3, String str3, Map<String, String> map, a<String> aVar) {
        final String str4 = str;
        final int i3 = i2;
        final String str5 = str2;
        final double d4 = d2;
        final double d5 = d3;
        final String str6 = str3;
        final Map<String, String> map2 = map;
        return a(new i<String>() {
            /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A[Catch:{ Exception -> 0x0090 }] */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x00b3 A[Catch:{ Exception -> 0x00b7 }] */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.String b() {
                /*
                    r15 = this;
                    java.lang.String r0 = "database"
                    java.lang.String r1 = r2
                    boolean r1 = android.text.TextUtils.isEmpty(r1)
                    r2 = 0
                    if (r1 == 0) goto L_0x000c
                    return r2
                L_0x000c:
                    java.util.concurrent.locks.Lock r1 = com.facebook.ads.internal.e.d.f20111j
                    r1.lock()
                    com.facebook.ads.internal.e.d r1 = com.facebook.ads.internal.e.d.this     // Catch:{ Exception -> 0x006c, all -> 0x0067 }
                    android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch:{ Exception -> 0x006c, all -> 0x0067 }
                    r1.beginTransaction()     // Catch:{ Exception -> 0x0065 }
                    com.facebook.ads.internal.e.d r3 = com.facebook.ads.internal.e.d.this     // Catch:{ Exception -> 0x0065 }
                    com.facebook.ads.internal.e.c r4 = r3.f20114m     // Catch:{ Exception -> 0x0065 }
                    com.facebook.ads.internal.e.d r3 = com.facebook.ads.internal.e.d.this     // Catch:{ Exception -> 0x0065 }
                    com.facebook.ads.internal.e.h r3 = r3.f20113l     // Catch:{ Exception -> 0x0065 }
                    java.lang.String r5 = r2     // Catch:{ Exception -> 0x0065 }
                    java.lang.String r5 = r3.a(r5)     // Catch:{ Exception -> 0x0065 }
                    int r6 = r3     // Catch:{ Exception -> 0x0065 }
                    java.lang.String r7 = r4     // Catch:{ Exception -> 0x0065 }
                    double r8 = r5     // Catch:{ Exception -> 0x0065 }
                    double r10 = r7     // Catch:{ Exception -> 0x0065 }
                    java.lang.String r12 = r9     // Catch:{ Exception -> 0x0065 }
                    java.util.Map r13 = r10     // Catch:{ Exception -> 0x0065 }
                    java.lang.String r3 = r4.a(r5, r6, r7, r8, r10, r12, r13)     // Catch:{ Exception -> 0x0065 }
                    r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0065 }
                    boolean r2 = r1.isOpen()
                    if (r2 == 0) goto L_0x005d
                    boolean r2 = r1.inTransaction()     // Catch:{ Exception -> 0x0051 }
                    if (r2 == 0) goto L_0x005d
                    r1.endTransaction()     // Catch:{ Exception -> 0x0051 }
                    goto L_0x005d
                L_0x0051:
                    r1 = move-exception
                    com.facebook.ads.internal.e.d r2 = com.facebook.ads.internal.e.d.this
                    android.content.Context r2 = r2.f20112k
                    int r4 = com.facebook.ads.internal.q.d.b.f20751k
                    com.facebook.ads.internal.q.d.a.a((android.content.Context) r2, (java.lang.String) r0, (int) r4, (java.lang.Exception) r1)
                L_0x005d:
                    java.util.concurrent.locks.Lock r0 = com.facebook.ads.internal.e.d.f20111j
                    r0.unlock()
                    return r3
                L_0x0065:
                    r3 = move-exception
                    goto L_0x006e
                L_0x0067:
                    r1 = move-exception
                    r14 = r2
                    r2 = r1
                    r1 = r14
                    goto L_0x00a5
                L_0x006c:
                    r3 = move-exception
                    r1 = r2
                L_0x006e:
                    com.facebook.ads.internal.e.f$a r4 = com.facebook.ads.internal.e.f.a.DATABASE_INSERT     // Catch:{ all -> 0x00a4 }
                    r15.a(r4)     // Catch:{ all -> 0x00a4 }
                    com.facebook.ads.internal.e.d r4 = com.facebook.ads.internal.e.d.this     // Catch:{ all -> 0x00a4 }
                    android.content.Context r4 = r4.f20112k     // Catch:{ all -> 0x00a4 }
                    int r5 = com.facebook.ads.internal.q.d.b.f20749i     // Catch:{ all -> 0x00a4 }
                    com.facebook.ads.internal.q.d.a.a((android.content.Context) r4, (java.lang.String) r0, (int) r5, (java.lang.Exception) r3)     // Catch:{ all -> 0x00a4 }
                    if (r1 == 0) goto L_0x009c
                    boolean r3 = r1.isOpen()
                    if (r3 == 0) goto L_0x009c
                    boolean r3 = r1.inTransaction()     // Catch:{ Exception -> 0x0090 }
                    if (r3 == 0) goto L_0x009c
                    r1.endTransaction()     // Catch:{ Exception -> 0x0090 }
                    goto L_0x009c
                L_0x0090:
                    r1 = move-exception
                    com.facebook.ads.internal.e.d r3 = com.facebook.ads.internal.e.d.this
                    android.content.Context r3 = r3.f20112k
                    int r4 = com.facebook.ads.internal.q.d.b.f20751k
                    com.facebook.ads.internal.q.d.a.a((android.content.Context) r3, (java.lang.String) r0, (int) r4, (java.lang.Exception) r1)
                L_0x009c:
                    java.util.concurrent.locks.Lock r0 = com.facebook.ads.internal.e.d.f20111j
                    r0.unlock()
                    return r2
                L_0x00a4:
                    r2 = move-exception
                L_0x00a5:
                    if (r1 == 0) goto L_0x00c3
                    boolean r3 = r1.isOpen()
                    if (r3 == 0) goto L_0x00c3
                    boolean r3 = r1.inTransaction()     // Catch:{ Exception -> 0x00b7 }
                    if (r3 == 0) goto L_0x00c3
                    r1.endTransaction()     // Catch:{ Exception -> 0x00b7 }
                    goto L_0x00c3
                L_0x00b7:
                    r1 = move-exception
                    com.facebook.ads.internal.e.d r3 = com.facebook.ads.internal.e.d.this
                    android.content.Context r3 = r3.f20112k
                    int r4 = com.facebook.ads.internal.q.d.b.f20751k
                    com.facebook.ads.internal.q.d.a.a((android.content.Context) r3, (java.lang.String) r0, (int) r4, (java.lang.Exception) r1)
                L_0x00c3:
                    java.util.concurrent.locks.Lock r0 = com.facebook.ads.internal.e.d.f20111j
                    r0.unlock()
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.e.d.AnonymousClass2.b():java.lang.String");
            }
        }, aVar);
    }

    public boolean a(String str) {
        f20111j.lock();
        boolean z2 = false;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE ");
            sb.append("events");
            sb.append(" SET ");
            b bVar = c.f20099i;
            sb.append(bVar.f20089b);
            sb.append("=");
            sb.append(bVar.f20089b);
            sb.append("+1");
            sb.append(" WHERE ");
            sb.append(c.f20091a.f20089b);
            sb.append("=?");
            a().execSQL(sb.toString(), new String[]{str});
            z2 = true;
        } catch (SQLiteException unused) {
        }
        f20111j.unlock();
        return z2;
    }

    public synchronized void b() {
        for (g e2 : c()) {
            e2.e();
        }
        SQLiteOpenHelper sQLiteOpenHelper = this.f20115n;
        if (sQLiteOpenHelper != null) {
            sQLiteOpenHelper.close();
            this.f20115n = null;
        }
    }

    public boolean b(String str) {
        Lock lock = f20111j;
        lock.lock();
        try {
            boolean a2 = this.f20114m.a(str);
            lock.unlock();
            return a2;
        } catch (Throwable th) {
            f20111j.unlock();
            throw th;
        }
    }

    public g[] c() {
        return new g[]{this.f20113l, this.f20114m};
    }

    public Cursor d() {
        Lock lock = f20110i;
        lock.lock();
        try {
            Cursor c2 = this.f20114m.c();
            lock.unlock();
            return c2;
        } catch (Throwable th) {
            f20110i.unlock();
            throw th;
        }
    }

    public Cursor e() {
        Lock lock = f20110i;
        lock.lock();
        try {
            Cursor d2 = this.f20114m.d();
            lock.unlock();
            return d2;
        } catch (Throwable th) {
            f20110i.unlock();
            throw th;
        }
    }

    public Cursor f() {
        Lock lock = f20110i;
        lock.lock();
        try {
            Cursor c2 = this.f20113l.c();
            lock.unlock();
            return c2;
        } catch (Throwable th) {
            f20110i.unlock();
            throw th;
        }
    }

    public void g() {
        Lock lock = f20111j;
        lock.lock();
        try {
            this.f20113l.d();
            lock.unlock();
        } catch (Throwable th) {
            f20111j.unlock();
            throw th;
        }
    }
}
