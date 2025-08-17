package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class RoomDatabase {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    protected volatile SupportSQLiteDatabase f11452a;

    /* renamed from: b  reason: collision with root package name */
    private Executor f11453b;

    /* renamed from: c  reason: collision with root package name */
    private Executor f11454c;

    /* renamed from: d  reason: collision with root package name */
    private SupportSQLiteOpenHelper f11455d;

    /* renamed from: e  reason: collision with root package name */
    private final InvalidationTracker f11456e = e();

    /* renamed from: f  reason: collision with root package name */
    private boolean f11457f;

    /* renamed from: g  reason: collision with root package name */
    boolean f11458g;
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    protected List<Callback> f11459h;

    /* renamed from: i  reason: collision with root package name */
    private final ReentrantReadWriteLock f11460i = new ReentrantReadWriteLock();

    /* renamed from: j  reason: collision with root package name */
    private final ThreadLocal<Integer> f11461j = new ThreadLocal<>();

    /* renamed from: k  reason: collision with root package name */
    private final Map<String, Object> f11462k = new ConcurrentHashMap();

    public static class Builder<T extends RoomDatabase> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f11463a;

        /* renamed from: b  reason: collision with root package name */
        private final String f11464b;

        /* renamed from: c  reason: collision with root package name */
        private final Context f11465c;

        /* renamed from: d  reason: collision with root package name */
        private ArrayList<Callback> f11466d;

        /* renamed from: e  reason: collision with root package name */
        private Executor f11467e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f11468f;

        /* renamed from: g  reason: collision with root package name */
        private SupportSQLiteOpenHelper.Factory f11469g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f11470h;

        /* renamed from: i  reason: collision with root package name */
        private JournalMode f11471i = JournalMode.AUTOMATIC;

        /* renamed from: j  reason: collision with root package name */
        private boolean f11472j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f11473k = true;

        /* renamed from: l  reason: collision with root package name */
        private boolean f11474l;

        /* renamed from: m  reason: collision with root package name */
        private final MigrationContainer f11475m = new MigrationContainer();

        /* renamed from: n  reason: collision with root package name */
        private Set<Integer> f11476n;

        /* renamed from: o  reason: collision with root package name */
        private Set<Integer> f11477o;

        /* renamed from: p  reason: collision with root package name */
        private String f11478p;

        /* renamed from: q  reason: collision with root package name */
        private File f11479q;

        Builder(Context context, Class<T> cls, String str) {
            this.f11465c = context;
            this.f11463a = cls;
            this.f11464b = str;
        }

        public Builder<T> a(Callback callback) {
            if (this.f11466d == null) {
                this.f11466d = new ArrayList<>();
            }
            this.f11466d.add(callback);
            return this;
        }

        public Builder<T> b(Migration... migrationArr) {
            if (this.f11477o == null) {
                this.f11477o = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.f11477o.add(Integer.valueOf(migration.f11527a));
                this.f11477o.add(Integer.valueOf(migration.f11528b));
            }
            this.f11475m.b(migrationArr);
            return this;
        }

        public Builder<T> c() {
            this.f11470h = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T d() {
            Executor executor;
            if (this.f11465c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f11463a != null) {
                Executor executor2 = this.f11467e;
                if (executor2 == null && this.f11468f == null) {
                    Executor d2 = ArchTaskExecutor.d();
                    this.f11468f = d2;
                    this.f11467e = d2;
                } else if (executor2 != null && this.f11468f == null) {
                    this.f11468f = executor2;
                } else if (executor2 == null && (executor = this.f11468f) != null) {
                    this.f11467e = executor;
                }
                Set<Integer> set = this.f11477o;
                if (!(set == null || this.f11476n == null)) {
                    for (Integer next : set) {
                        if (this.f11476n.contains(next)) {
                            throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + next);
                        }
                    }
                }
                if (this.f11469g == null) {
                    this.f11469g = new FrameworkSQLiteOpenHelperFactory();
                }
                String str = this.f11478p;
                if (!(str == null && this.f11479q == null)) {
                    if (this.f11464b == null) {
                        throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                    } else if (str == null || this.f11479q == null) {
                        this.f11469g = new SQLiteCopyOpenHelperFactory(str, this.f11479q, this.f11469g);
                    } else {
                        throw new IllegalArgumentException("Both createFromAsset() and createFromFile() was called on this Builder but the database can only be created using one of the two configurations.");
                    }
                }
                Context context = this.f11465c;
                String str2 = this.f11464b;
                SupportSQLiteOpenHelper.Factory factory = this.f11469g;
                MigrationContainer migrationContainer = this.f11475m;
                ArrayList<Callback> arrayList = this.f11466d;
                boolean z2 = this.f11470h;
                JournalMode b2 = this.f11471i.b(context);
                Executor executor3 = this.f11467e;
                Executor executor4 = this.f11468f;
                boolean z3 = this.f11472j;
                boolean z4 = this.f11473k;
                boolean z5 = this.f11474l;
                boolean z6 = z4;
                boolean z7 = z5;
                DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, str2, factory, migrationContainer, arrayList, z2, b2, executor3, executor4, z3, z6, z7, this.f11476n, this.f11478p, this.f11479q);
                T t2 = (RoomDatabase) Room.b(this.f11463a, "_Impl");
                t2.n(databaseConfiguration);
                return t2;
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        public Builder<T> e() {
            this.f11473k = false;
            this.f11474l = true;
            return this;
        }

        public Builder<T> f(SupportSQLiteOpenHelper.Factory factory) {
            this.f11469g = factory;
            return this;
        }

        public Builder<T> g(Executor executor) {
            this.f11467e = executor;
            return this;
        }
    }

    public static abstract class Callback {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean a(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        /* access modifiers changed from: package-private */
        @SuppressLint({"NewApi"})
        public JournalMode b(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || a(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    public static class MigrationContainer {

        /* renamed from: a  reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, Migration>> f11484a = new HashMap<>();

        private void a(Migration migration) {
            int i2 = migration.f11527a;
            int i3 = migration.f11528b;
            TreeMap treeMap = this.f11484a.get(Integer.valueOf(i2));
            if (treeMap == null) {
                treeMap = new TreeMap();
                this.f11484a.put(Integer.valueOf(i2), treeMap);
            }
            Migration migration2 = (Migration) treeMap.get(Integer.valueOf(i3));
            if (migration2 != null) {
                Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
            }
            treeMap.put(Integer.valueOf(i3), migration);
        }

        private List<Migration> d(List<Migration> list, boolean z2, int i2, int i3) {
            Set set;
            boolean z3;
            do {
                if (z2) {
                    if (i2 >= i3) {
                        return list;
                    }
                } else if (i2 <= i3) {
                    return list;
                }
                TreeMap treeMap = this.f11484a.get(Integer.valueOf(i2));
                if (treeMap != null) {
                    if (z2) {
                        set = treeMap.descendingKeySet();
                    } else {
                        set = treeMap.keySet();
                    }
                    Iterator it2 = set.iterator();
                    while (true) {
                        z3 = false;
                        if (!it2.hasNext()) {
                            break;
                        }
                        int intValue = ((Integer) it2.next()).intValue();
                        if (!z2 ? !(intValue < i3 || intValue >= i2) : !(intValue > i3 || intValue <= i2)) {
                            z3 = true;
                            continue;
                        }
                        if (z3) {
                            list.add(treeMap.get(Integer.valueOf(intValue)));
                            i2 = intValue;
                            z3 = true;
                            continue;
                            break;
                        }
                    }
                } else {
                    return null;
                }
            } while (z3);
            return null;
        }

        public void b(Migration... migrationArr) {
            for (Migration a2 : migrationArr) {
                a(a2);
            }
        }

        public List<Migration> c(int i2, int i3) {
            boolean z2;
            if (i2 == i3) {
                return Collections.emptyList();
            }
            if (i3 > i2) {
                z2 = true;
            } else {
                z2 = false;
            }
            return d(new ArrayList(), z2, i2, i3);
        }
    }

    private static boolean p() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a() {
        if (!this.f11457f && p()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b() {
        if (!m() && this.f11461j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void c() {
        a();
        SupportSQLiteDatabase writableDatabase = this.f11455d.getWritableDatabase();
        this.f11456e.m(writableDatabase);
        writableDatabase.beginTransaction();
    }

    public SupportSQLiteStatement d(String str) {
        a();
        b();
        return this.f11455d.getWritableDatabase().S(str);
    }

    /* access modifiers changed from: protected */
    public abstract InvalidationTracker e();

    /* access modifiers changed from: protected */
    public abstract SupportSQLiteOpenHelper f(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public void g() {
        this.f11455d.getWritableDatabase().endTransaction();
        if (!m()) {
            this.f11456e.f();
        }
    }

    /* access modifiers changed from: package-private */
    public Lock h() {
        return this.f11460i.readLock();
    }

    public InvalidationTracker i() {
        return this.f11456e;
    }

    public SupportSQLiteOpenHelper j() {
        return this.f11455d;
    }

    public Executor k() {
        return this.f11453b;
    }

    public Executor l() {
        return this.f11454c;
    }

    public boolean m() {
        return this.f11455d.getWritableDatabase().e0();
    }

    public void n(DatabaseConfiguration databaseConfiguration) {
        boolean z2;
        SupportSQLiteOpenHelper f2 = f(databaseConfiguration);
        this.f11455d = f2;
        if (f2 instanceof SQLiteCopyOpenHelper) {
            ((SQLiteCopyOpenHelper) f2).f(databaseConfiguration);
        }
        if (databaseConfiguration.f11388g == JournalMode.WRITE_AHEAD_LOGGING) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.f11455d.setWriteAheadLoggingEnabled(z2);
        this.f11459h = databaseConfiguration.f11386e;
        this.f11453b = databaseConfiguration.f11389h;
        this.f11454c = new TransactionExecutor(databaseConfiguration.f11390i);
        this.f11457f = databaseConfiguration.f11387f;
        this.f11458g = z2;
        if (databaseConfiguration.f11391j) {
            this.f11456e.i(databaseConfiguration.f11383b, databaseConfiguration.f11384c);
        }
    }

    /* access modifiers changed from: protected */
    public void o(SupportSQLiteDatabase supportSQLiteDatabase) {
        this.f11456e.d(supportSQLiteDatabase);
    }

    public boolean q() {
        SupportSQLiteDatabase supportSQLiteDatabase = this.f11452a;
        if (supportSQLiteDatabase == null || !supportSQLiteDatabase.isOpen()) {
            return false;
        }
        return true;
    }

    public Cursor r(SupportSQLiteQuery supportSQLiteQuery) {
        return s(supportSQLiteQuery, (CancellationSignal) null);
    }

    public Cursor s(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
        a();
        b();
        if (cancellationSignal != null) {
            return this.f11455d.getWritableDatabase().n(supportSQLiteQuery, cancellationSignal);
        }
        return this.f11455d.getWritableDatabase().C(supportSQLiteQuery);
    }

    @Deprecated
    public void t() {
        this.f11455d.getWritableDatabase().setTransactionSuccessful();
    }
}
