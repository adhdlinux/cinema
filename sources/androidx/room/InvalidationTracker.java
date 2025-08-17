package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

public class InvalidationTracker {

    /* renamed from: m  reason: collision with root package name */
    private static final String[] f11401m = {"UPDATE", "DELETE", "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    final HashMap<String, Integer> f11402a;

    /* renamed from: b  reason: collision with root package name */
    final String[] f11403b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Set<String>> f11404c;

    /* renamed from: d  reason: collision with root package name */
    final RoomDatabase f11405d;

    /* renamed from: e  reason: collision with root package name */
    AtomicBoolean f11406e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f11407f = false;

    /* renamed from: g  reason: collision with root package name */
    volatile SupportSQLiteStatement f11408g;

    /* renamed from: h  reason: collision with root package name */
    private ObservedTableTracker f11409h;

    /* renamed from: i  reason: collision with root package name */
    private final InvalidationLiveDataContainer f11410i;
    @SuppressLint({"RestrictedApi"})

    /* renamed from: j  reason: collision with root package name */
    final SafeIterableMap<Observer, ObserverWrapper> f11411j = new SafeIterableMap<>();

    /* renamed from: k  reason: collision with root package name */
    private MultiInstanceInvalidationClient f11412k;

    /* renamed from: l  reason: collision with root package name */
    Runnable f11413l = new Runnable() {
        /* JADX INFO: finally extract failed */
        private Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor r2 = InvalidationTracker.this.f11405d.r(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (r2.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(r2.getInt(0)));
                } catch (Throwable th) {
                    r2.close();
                    throw th;
                }
            }
            r2.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.f11408g.j();
            }
            return hashSet;
        }

        public void run() {
            SupportSQLiteDatabase writableDatabase;
            Lock h2 = InvalidationTracker.this.f11405d.h();
            Set<Integer> set = null;
            try {
                h2.lock();
                if (!InvalidationTracker.this.c()) {
                    h2.unlock();
                } else if (!InvalidationTracker.this.f11406e.compareAndSet(true, false)) {
                    h2.unlock();
                } else if (InvalidationTracker.this.f11405d.m()) {
                    h2.unlock();
                } else {
                    RoomDatabase roomDatabase = InvalidationTracker.this.f11405d;
                    if (roomDatabase.f11458g) {
                        writableDatabase = roomDatabase.j().getWritableDatabase();
                        writableDatabase.beginTransaction();
                        set = a();
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } else {
                        set = a();
                    }
                    h2.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (InvalidationTracker.this.f11411j) {
                            Iterator<Map.Entry<Observer, ObserverWrapper>> it2 = InvalidationTracker.this.f11411j.iterator();
                            while (it2.hasNext()) {
                                ((ObserverWrapper) it2.next().getValue()).a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e2) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                } catch (Throwable th) {
                    h2.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                writableDatabase.endTransaction();
                throw th2;
            }
        }
    };

    static class ObservedTableTracker {

        /* renamed from: a  reason: collision with root package name */
        final long[] f11415a;

        /* renamed from: b  reason: collision with root package name */
        final boolean[] f11416b;

        /* renamed from: c  reason: collision with root package name */
        final int[] f11417c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11418d;

        /* renamed from: e  reason: collision with root package name */
        boolean f11419e;

        ObservedTableTracker(int i2) {
            long[] jArr = new long[i2];
            this.f11415a = jArr;
            boolean[] zArr = new boolean[i2];
            this.f11416b = zArr;
            this.f11417c = new int[i2];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int[] a() {
            /*
                r9 = this;
                monitor-enter(r9)
                boolean r0 = r9.f11418d     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x003f
                boolean r0 = r9.f11419e     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x000a
                goto L_0x003f
            L_0x000a:
                long[] r0 = r9.f11415a     // Catch:{ all -> 0x0042 }
                int r0 = r0.length     // Catch:{ all -> 0x0042 }
                r1 = 0
                r2 = 0
            L_0x000f:
                r3 = 1
                if (r2 >= r0) goto L_0x0037
                long[] r4 = r9.f11415a     // Catch:{ all -> 0x0042 }
                r5 = r4[r2]     // Catch:{ all -> 0x0042 }
                r7 = 0
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                r4 = 1
                goto L_0x001f
            L_0x001e:
                r4 = 0
            L_0x001f:
                boolean[] r5 = r9.f11416b     // Catch:{ all -> 0x0042 }
                boolean r6 = r5[r2]     // Catch:{ all -> 0x0042 }
                if (r4 == r6) goto L_0x002e
                int[] r6 = r9.f11417c     // Catch:{ all -> 0x0042 }
                if (r4 == 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r3 = 2
            L_0x002b:
                r6[r2] = r3     // Catch:{ all -> 0x0042 }
                goto L_0x0032
            L_0x002e:
                int[] r3 = r9.f11417c     // Catch:{ all -> 0x0042 }
                r3[r2] = r1     // Catch:{ all -> 0x0042 }
            L_0x0032:
                r5[r2] = r4     // Catch:{ all -> 0x0042 }
                int r2 = r2 + 1
                goto L_0x000f
            L_0x0037:
                r9.f11419e = r3     // Catch:{ all -> 0x0042 }
                r9.f11418d = r1     // Catch:{ all -> 0x0042 }
                int[] r0 = r9.f11417c     // Catch:{ all -> 0x0042 }
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                return r0
            L_0x003f:
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                r0 = 0
                return r0
            L_0x0042:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.InvalidationTracker.ObservedTableTracker.a():int[]");
        }

        /* access modifiers changed from: package-private */
        public boolean b(int... iArr) {
            boolean z2;
            synchronized (this) {
                z2 = false;
                for (int i2 : iArr) {
                    long[] jArr = this.f11415a;
                    long j2 = jArr[i2];
                    jArr[i2] = 1 + j2;
                    if (j2 == 0) {
                        z2 = true;
                        this.f11418d = true;
                    }
                }
            }
            return z2;
        }

        /* access modifiers changed from: package-private */
        public boolean c(int... iArr) {
            boolean z2;
            synchronized (this) {
                z2 = false;
                for (int i2 : iArr) {
                    long[] jArr = this.f11415a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        z2 = true;
                        this.f11418d = true;
                    }
                }
            }
            return z2;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            synchronized (this) {
                this.f11419e = false;
            }
        }
    }

    public static abstract class Observer {

        /* renamed from: a  reason: collision with root package name */
        final String[] f11420a;

        public Observer(String[] strArr) {
            this.f11420a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        public abstract void b(Set<String> set);
    }

    static class ObserverWrapper {

        /* renamed from: a  reason: collision with root package name */
        final int[] f11421a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f11422b;

        /* renamed from: c  reason: collision with root package name */
        final Observer f11423c;

        /* renamed from: d  reason: collision with root package name */
        private final Set<String> f11424d;

        ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            this.f11423c = observer;
            this.f11421a = iArr;
            this.f11422b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.f11424d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f11424d = null;
        }

        /* access modifiers changed from: package-private */
        public void a(Set<Integer> set) {
            int length = this.f11421a.length;
            Set set2 = null;
            for (int i2 = 0; i2 < length; i2++) {
                if (set.contains(Integer.valueOf(this.f11421a[i2]))) {
                    if (length == 1) {
                        set2 = this.f11424d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.f11422b[i2]);
                    }
                }
            }
            if (set2 != null) {
                this.f11423c.b(set2);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(String[] strArr) {
            Set<String> set = null;
            if (this.f11422b.length == 1) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (strArr[i2].equalsIgnoreCase(this.f11422b[0])) {
                        set = this.f11424d;
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f11422b;
                    int length2 = strArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i3];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i3++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f11423c.b(set);
            }
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f11405d = roomDatabase;
        this.f11409h = new ObservedTableTracker(strArr.length);
        this.f11402a = new HashMap<>();
        this.f11404c = map2;
        this.f11410i = new InvalidationLiveDataContainer(roomDatabase);
        int length = strArr.length;
        this.f11403b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f11402a.put(lowerCase, Integer.valueOf(i2));
            String str2 = map.get(strArr[i2]);
            if (str2 != null) {
                this.f11403b[i2] = str2.toLowerCase(locale);
            } else {
                this.f11403b[i2] = lowerCase;
            }
        }
        for (Map.Entry next : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            if (this.f11402a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f11402a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    private static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    private String[] h(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f11404c.containsKey(lowerCase)) {
                hashSet.addAll(this.f11404c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void j(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        supportSQLiteDatabase.g("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.f11403b[i2];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f11401m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            supportSQLiteDatabase.g(sb.toString());
        }
    }

    private void k(SupportSQLiteDatabase supportSQLiteDatabase, int i2) {
        String str = this.f11403b[i2];
        StringBuilder sb = new StringBuilder();
        for (String b2 : f11401m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, b2);
            supportSQLiteDatabase.g(sb.toString());
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(Observer observer) {
        ObserverWrapper g2;
        String[] h2 = h(observer.f11420a);
        int[] iArr = new int[h2.length];
        int length = h2.length;
        int i2 = 0;
        while (i2 < length) {
            Integer num = this.f11402a.get(h2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
                i2++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + h2[i2]);
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, h2);
        synchronized (this.f11411j) {
            g2 = this.f11411j.g(observer, observerWrapper);
        }
        if (g2 == null && this.f11409h.b(iArr)) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        if (!this.f11405d.q()) {
            return false;
        }
        if (!this.f11407f) {
            this.f11405d.j().getWritableDatabase();
        }
        if (this.f11407f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.f11407f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.g("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.g("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.g("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            m(supportSQLiteDatabase);
            this.f11408g = supportSQLiteDatabase.S("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f11407f = true;
        }
    }

    public void e(String... strArr) {
        synchronized (this.f11411j) {
            Iterator<Map.Entry<Observer, ObserverWrapper>> it2 = this.f11411j.iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (!((Observer) next.getKey()).a()) {
                    ((ObserverWrapper) next.getValue()).b(strArr);
                }
            }
        }
    }

    public void f() {
        if (this.f11406e.compareAndSet(false, true)) {
            this.f11405d.k().execute(this.f11413l);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void g(Observer observer) {
        ObserverWrapper h2;
        synchronized (this.f11411j) {
            h2 = this.f11411j.h(observer);
        }
        if (h2 != null && this.f11409h.c(h2.f11421a)) {
            l();
        }
    }

    /* access modifiers changed from: package-private */
    public void i(Context context, String str) {
        this.f11412k = new MultiInstanceInvalidationClient(context, str, this, this.f11405d.k());
    }

    /* access modifiers changed from: package-private */
    public void l() {
        if (this.f11405d.q()) {
            m(this.f11405d.j().getWritableDatabase());
        }
    }

    /* access modifiers changed from: package-private */
    public void m(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!supportSQLiteDatabase.e0()) {
            while (true) {
                try {
                    Lock h2 = this.f11405d.h();
                    h2.lock();
                    try {
                        int[] a2 = this.f11409h.a();
                        if (a2 == null) {
                            h2.unlock();
                            return;
                        }
                        int length = a2.length;
                        supportSQLiteDatabase.beginTransaction();
                        for (int i2 = 0; i2 < length; i2++) {
                            int i3 = a2[i2];
                            if (i3 == 1) {
                                j(supportSQLiteDatabase, i2);
                            } else if (i3 == 2) {
                                k(supportSQLiteDatabase, i2);
                            }
                        }
                        supportSQLiteDatabase.setTransactionSuccessful();
                        supportSQLiteDatabase.endTransaction();
                        this.f11409h.d();
                        h2.unlock();
                    } catch (Throwable th) {
                        h2.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e2) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e2);
                    return;
                }
            }
        }
    }
}
