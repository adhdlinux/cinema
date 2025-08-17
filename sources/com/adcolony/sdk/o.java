package com.adcolony.sdk;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

class o {

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n0 f13283b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SQLiteDatabase f13284c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f13285d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f13286e;

        a(n0 n0Var, SQLiteDatabase sQLiteDatabase, b bVar, CountDownLatch countDownLatch) {
            this.f13283b = n0Var;
            this.f13284c = sQLiteDatabase;
            this.f13285d = bVar;
            this.f13286e = countDownLatch;
        }

        public void run() {
            for (n0.a next : this.f13283b.c()) {
                for (Map.Entry next2 : next.g().entrySet()) {
                    c b2 = o.b((String) next2.getValue(), this.f13284c);
                    if (b2 != null) {
                        this.f13285d.c(next.f(), (String) next2.getKey(), b2);
                    }
                }
            }
            o0.m().e(this.f13285d);
            this.f13286e.countDown();
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        private final int f13287a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, ArrayList<a>> f13288b;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            private final String f13289a;

            /* renamed from: b  reason: collision with root package name */
            private final c f13290b;

            /* synthetic */ a(String str, c cVar, a aVar) {
                this(str, cVar);
            }

            /* access modifiers changed from: package-private */
            public String a() {
                return this.f13289a;
            }

            /* access modifiers changed from: package-private */
            public c b() {
                return this.f13290b;
            }

            private a(String str, c cVar) {
                this.f13289a = str;
                this.f13290b = cVar;
            }
        }

        /* synthetic */ b(int i2, a aVar) {
            this(i2);
        }

        /* access modifiers changed from: private */
        public void c(String str, String str2, c cVar) {
            ArrayList arrayList;
            a aVar = new a(str2, cVar, (a) null);
            if (!this.f13288b.containsKey(str) || (arrayList = this.f13288b.get(str)) == null) {
                this.f13288b.put(str, new ArrayList(Collections.singletonList(aVar)));
            } else {
                arrayList.add(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public int a() {
            return this.f13287a;
        }

        /* access modifiers changed from: package-private */
        public f1 d() {
            f1 q2 = c0.q();
            c0.u(q2, MediationMetaData.KEY_VERSION, a());
            for (Map.Entry next : this.f13288b.entrySet()) {
                f1 q3 = c0.q();
                Iterator it2 = ((ArrayList) next.getValue()).iterator();
                while (it2.hasNext()) {
                    a aVar = (a) it2.next();
                    e1 c2 = c0.c();
                    for (String g2 : aVar.b().c(',')) {
                        c2.g(g2);
                    }
                    c0.l(q3, aVar.a(), c2);
                }
                c0.m(q2, (String) next.getKey(), q3);
            }
            return q2;
        }

        private b(int i2) {
            this.f13288b = new ConcurrentHashMap();
            this.f13287a = i2;
        }
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        private final List<a> f13291a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<ContentValues> f13292b = new ArrayList();

        static class a {

            /* renamed from: a  reason: collision with root package name */
            private final int f13293a;
            /* access modifiers changed from: private */

            /* renamed from: b  reason: collision with root package name */
            public final String f13294b;
            /* access modifiers changed from: private */

            /* renamed from: c  reason: collision with root package name */
            public final int f13295c;

            /* synthetic */ a(int i2, String str, int i3, a aVar) {
                this(i2, str, i3);
            }

            /* access modifiers changed from: package-private */
            public int a() {
                return this.f13293a;
            }

            /* access modifiers changed from: package-private */
            public String c() {
                return this.f13294b;
            }

            /* access modifiers changed from: package-private */
            public int e() {
                return this.f13295c;
            }

            private a(int i2, String str, int i3) {
                this.f13293a = i2;
                this.f13294b = str;
                this.f13295c = i3;
            }
        }

        c() {
        }

        /* access modifiers changed from: private */
        public void d(int i2, String str, int i3) {
            this.f13291a.add(new a(i2, str, i3, (a) null));
        }

        /* access modifiers changed from: private */
        public void e(Cursor cursor) {
            ContentValues contentValues = new ContentValues();
            for (a next : this.f13291a) {
                int b2 = next.f13295c;
                if (b2 == 1) {
                    contentValues.put(next.c(), Long.valueOf(cursor.getLong(next.a())));
                } else if (b2 == 2) {
                    contentValues.put(next.c(), Double.valueOf(cursor.getDouble(next.a())));
                } else if (b2 != 4) {
                    contentValues.put(next.c(), cursor.getString(next.a()));
                } else {
                    contentValues.put(next.c(), cursor.getBlob(next.a()));
                }
            }
            this.f13292b.add(contentValues);
        }

        /* access modifiers changed from: package-private */
        public String a(int i2) {
            if (i2 < 0 || i2 >= this.f13291a.size()) {
                return null;
            }
            return this.f13291a.get(i2).c();
        }

        /* access modifiers changed from: package-private */
        public String b(int i2, Character ch) {
            Object obj;
            if (i2 < 0 || i2 >= this.f13292b.size()) {
                return null;
            }
            ContentValues contentValues = this.f13292b.get(i2);
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < this.f13291a.size(); i3++) {
                if (h(i3) == 3) {
                    sb.append("\"");
                    sb.append(contentValues.get(a(i3)));
                    sb.append("\"");
                } else {
                    sb.append(contentValues.getAsString(a(i3)));
                }
                if (i3 == this.f13291a.size() - 1) {
                    obj = "";
                } else {
                    obj = ch;
                }
                sb.append(obj);
            }
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public List<String> c(Character ch) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.f13292b.size(); i2++) {
                arrayList.add(b(i2, ch));
            }
            return arrayList;
        }

        /* access modifiers changed from: package-private */
        public int h(int i2) {
            if (i2 < 0 || i2 >= this.f13291a.size()) {
                return -1;
            }
            return this.f13291a.get(i2).e();
        }

        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            while (true) {
                int size = this.f13291a.size();
                str = ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE;
                if (i2 >= size) {
                    break;
                }
                sb.append(this.f13291a.get(i2).f13294b);
                if (i2 != this.f13291a.size() - 1) {
                    str = " | ";
                }
                sb.append(str);
                i2++;
            }
            for (ContentValues next : this.f13292b) {
                for (int i3 = 0; i3 < this.f13291a.size(); i3++) {
                    sb.append(next.getAsString(a(i3)));
                    if (i3 == this.f13291a.size() - 1) {
                        str2 = str;
                    } else {
                        str2 = " | ";
                    }
                    sb.append(str2);
                }
            }
            return sb.toString();
        }
    }

    static b a(n0 n0Var, SQLiteDatabase sQLiteDatabase, Executor executor, long j2) {
        b bVar = new b(n0Var.d(), (a) null);
        try {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            executor.execute(new a(n0Var, sQLiteDatabase, bVar, countDownLatch));
            if (j2 > 0) {
                countDownLatch.await(j2, TimeUnit.MILLISECONDS);
            } else {
                countDownLatch.await();
            }
        } catch (InterruptedException | RejectedExecutionException e2) {
            e0.a aVar = new e0.a();
            aVar.c("ADCDbReader.calculateFeatureVectors failed with: " + e2.toString()).d(e0.f13114i);
        }
        return bVar;
    }

    static c b(String str, SQLiteDatabase sQLiteDatabase) {
        c cVar;
        Throwable th;
        c cVar2 = null;
        try {
            Cursor rawQuery = sQLiteDatabase.rawQuery(str, (String[]) null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.moveToFirst()) {
                        cVar = new c();
                        int i2 = 0;
                        while (i2 < rawQuery.getColumnCount()) {
                            try {
                                cVar.d(i2, rawQuery.getColumnName(i2), rawQuery.getType(i2));
                                i2++;
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    rawQuery.close();
                                } catch (Throwable th3) {
                                    try {
                                        th.addSuppressed(th3);
                                    } catch (SQLException e2) {
                                        e = e2;
                                        new e0.a().c("SQLException on execute query: ").c(e.toString()).d(e0.f13114i);
                                        return cVar;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        new e0.a().c("Error on execute query: ").c(th.toString()).d(e0.f13114i);
                                        return cVar;
                                    }
                                }
                                throw th;
                            }
                        }
                        do {
                            cVar.e(rawQuery);
                        } while (rawQuery.moveToNext());
                        cVar2 = cVar;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    cVar = null;
                    rawQuery.close();
                    throw th;
                }
            }
            if (rawQuery == null) {
                return cVar2;
            }
            rawQuery.close();
            return cVar2;
        } catch (SQLException e3) {
            e = e3;
            cVar = cVar2;
        } catch (Throwable th6) {
            th = th6;
            cVar = cVar2;
            new e0.a().c("Error on execute query: ").c(th.toString()).d(e0.f13114i);
            return cVar;
        }
    }
}
