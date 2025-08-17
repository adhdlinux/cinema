package com.squareup.sqlbrite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTransactionListener;
import com.squareup.sqlbrite.SqlBrite;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;

public final class BriteDatabase implements Closeable {
    private static final Set<String> INITIAL_TRIGGER = Collections.singleton("<initial>");
    private final Object databaseLock = new Object();
    private final SQLiteOpenHelper helper;
    private final SqlBrite.Logger logger;
    /* access modifiers changed from: private */
    public volatile boolean logging;
    private volatile SQLiteDatabase readableDatabase;
    /* access modifiers changed from: private */
    public final ThreadLocal<Transaction> transactions = new ThreadLocal<>();
    private final PublishSubject<Set<String>> triggers = PublishSubject.k();
    private volatile SQLiteDatabase writeableDatabase;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConflictAlgorithm {
    }

    private final class Transaction implements SQLiteTransactionListener {
        final Transaction parent;
        final Set<String> triggers = new LinkedHashSet();

        Transaction(Transaction transaction) {
            this.parent = transaction;
        }

        public void onBegin() {
        }

        public void onCommit() {
            BriteDatabase.this.sendTableTrigger(this.triggers);
        }

        public void onRollback() {
        }

        public String toString() {
            String format = String.format("%08x", new Object[]{Integer.valueOf(System.identityHashCode(this))});
            if (this.parent == null) {
                return format;
            }
            return format + " [" + this.parent.toString() + ']';
        }
    }

    BriteDatabase(SQLiteOpenHelper sQLiteOpenHelper, SqlBrite.Logger logger2) {
        this.helper = sQLiteOpenHelper;
        this.logger = logger2;
    }

    private static String conflictString(int i2) {
        if (i2 == 0) {
            return "none";
        }
        if (i2 == 1) {
            return "rollback";
        }
        if (i2 == 2) {
            return "abort";
        }
        if (i2 == 3) {
            return "fail";
        }
        if (i2 == 4) {
            return "ignore";
        }
        if (i2 == 5) {
            return "replace";
        }
        return "unknown (" + i2 + ')';
    }

    /* access modifiers changed from: private */
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.readableDatabase;
        if (sQLiteDatabase == null) {
            synchronized (this.databaseLock) {
                sQLiteDatabase = this.readableDatabase;
                if (sQLiteDatabase == null) {
                    if (this.logging) {
                        log("Creating readable database", new Object[0]);
                    }
                    sQLiteDatabase = this.helper.getReadableDatabase();
                    this.readableDatabase = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    private SQLiteDatabase getWriteableDatabase() {
        SQLiteDatabase sQLiteDatabase = this.writeableDatabase;
        if (sQLiteDatabase == null) {
            synchronized (this.databaseLock) {
                sQLiteDatabase = this.writeableDatabase;
                if (sQLiteDatabase == null) {
                    if (this.logging) {
                        log("Creating writeable database", new Object[0]);
                    }
                    sQLiteDatabase = this.helper.getWritableDatabase();
                    this.writeableDatabase = sQLiteDatabase;
                }
            }
        }
        return sQLiteDatabase;
    }

    /* access modifiers changed from: private */
    public void log(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        this.logger.log(str);
    }

    /* access modifiers changed from: private */
    public void sendTableTrigger(Set<String> set) {
        Transaction transaction = this.transactions.get();
        if (transaction != null) {
            transaction.triggers.addAll(set);
            return;
        }
        if (this.logging) {
            log("TRIGGER %s", set);
        }
        this.triggers.onNext(set);
    }

    public void beginTransaction() {
        Transaction transaction = new Transaction(this.transactions.get());
        this.transactions.set(transaction);
        if (this.logging) {
            log("TXN BEGIN %s", transaction);
        }
        getWriteableDatabase().beginTransactionWithListener(transaction);
    }

    public void close() throws IOException {
        synchronized (this.databaseLock) {
            this.readableDatabase = null;
            this.writeableDatabase = null;
            this.helper.close();
        }
    }

    public Observable<SqlBrite.Query> createQuery(final String str, String str2, String... strArr) {
        return createQuery((Func1<Set<String>, Boolean>) new Func1<Set<String>, Boolean>() {
            public String toString() {
                return str;
            }

            public Boolean call(Set<String> set) {
                return Boolean.valueOf(set.contains(str));
            }
        }, str2, strArr);
    }

    public int delete(String str, String str2, String... strArr) {
        String str3;
        SQLiteDatabase writeableDatabase2 = getWriteableDatabase();
        if (this.logging) {
            log("DELETE\n  table: %s\n  whereClause: %s\n  whereArgs: %s", str, str2, Arrays.toString(strArr));
        }
        int delete = writeableDatabase2.delete(str, str2, strArr);
        if (this.logging) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(delete);
            if (delete != 1) {
                str3 = "rows";
            } else {
                str3 = "row";
            }
            objArr[1] = str3;
            log("DELETE affected %s %s", objArr);
        }
        if (delete > 0) {
            sendTableTrigger(Collections.singleton(str));
        }
        return delete;
    }

    public void endTransaction() {
        Transaction transaction = this.transactions.get();
        if (transaction != null) {
            this.transactions.set(transaction.parent);
            if (this.logging) {
                log("TXN END %s", transaction);
            }
            getWriteableDatabase().endTransaction();
            return;
        }
        throw new IllegalStateException("Not in transaction.");
    }

    public long insert(String str, ContentValues contentValues) {
        return insert(str, contentValues, 0);
    }

    public Cursor query(String str, String... strArr) {
        if (this.logging) {
            log("QUERY\n  sql: %s\n  args: %s", str, Arrays.toString(strArr));
        }
        return getReadableDatabase().rawQuery(str, strArr);
    }

    public void setLoggingEnabled(boolean z2) {
        this.logging = z2;
    }

    public void setTransactionSuccessful() {
        if (this.logging) {
            log("TXN SUCCESS %s", this.transactions.get());
        }
        getWriteableDatabase().setTransactionSuccessful();
    }

    public int update(String str, ContentValues contentValues, String str2, String... strArr) {
        return update(str, contentValues, 0, str2, strArr);
    }

    public boolean yieldIfContendedSafely() {
        return getWriteableDatabase().yieldIfContendedSafely();
    }

    public long insert(String str, ContentValues contentValues, int i2) {
        SQLiteDatabase writeableDatabase2 = getWriteableDatabase();
        if (this.logging) {
            log("INSERT\n  table: %s\n  values: %s\n  conflictAlgorithm: %s", str, contentValues, conflictString(i2));
        }
        long insertWithOnConflict = writeableDatabase2.insertWithOnConflict(str, (String) null, contentValues, i2);
        if (this.logging) {
            log("INSERT id: %s", Long.valueOf(insertWithOnConflict));
        }
        if (insertWithOnConflict != -1) {
            sendTableTrigger(Collections.singleton(str));
        }
        return insertWithOnConflict;
    }

    public int update(String str, ContentValues contentValues, int i2, String str2, String... strArr) {
        SQLiteDatabase writeableDatabase2 = getWriteableDatabase();
        if (this.logging) {
            log("UPDATE\n  table: %s\n  values: %s\n  whereClause: %s\n  whereArgs: %s\n  conflictAlgorithm: %s", str, contentValues, str2, Arrays.toString(strArr), conflictString(i2));
        }
        int updateWithOnConflict = writeableDatabase2.updateWithOnConflict(str, contentValues, str2, strArr, i2);
        if (this.logging) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(updateWithOnConflict);
            objArr[1] = updateWithOnConflict != 1 ? "rows" : "row";
            log("UPDATE affected %s %s", objArr);
        }
        if (updateWithOnConflict > 0) {
            sendTableTrigger(Collections.singleton(str));
        }
        return updateWithOnConflict;
    }

    public boolean yieldIfContendedSafely(long j2, TimeUnit timeUnit) {
        return getWriteableDatabase().yieldIfContendedSafely(timeUnit.toMillis(j2));
    }

    public Observable<SqlBrite.Query> createQuery(final Iterable<String> iterable, String str, String... strArr) {
        return createQuery((Func1<Set<String>, Boolean>) new Func1<Set<String>, Boolean>() {
            public String toString() {
                return iterable.toString();
            }

            public Boolean call(Set<String> set) {
                for (String contains : iterable) {
                    if (set.contains(contains)) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        }, str, strArr);
    }

    private Observable<SqlBrite.Query> createQuery(Func1<Set<String>, Boolean> func1, final String str, final String... strArr) {
        if (this.transactions.get() == null) {
            final AnonymousClass3 r6 = new SqlBrite.Query() {
                public Cursor run() {
                    if (BriteDatabase.this.transactions.get() == null) {
                        return BriteDatabase.this.getReadableDatabase().rawQuery(str, strArr);
                    }
                    throw new IllegalStateException("Cannot execute observable query in a transaction.");
                }

                public String toString() {
                    return str;
                }
            };
            final Func1<Set<String>, Boolean> func12 = func1;
            final String str2 = str;
            final String[] strArr2 = strArr;
            return this.triggers.d(func1).j(INITIAL_TRIGGER).i(new Func1<Set<String>, SqlBrite.Query>() {
                public SqlBrite.Query call(Set<String> set) {
                    if (BriteDatabase.this.transactions.get() == null) {
                        if (BriteDatabase.this.logging) {
                            BriteDatabase.this.log("QUERY\n  trigger: %s\n  tables: %s\n  sql: %s\n  args: %s", set, func12, str2, Arrays.toString(strArr2));
                        }
                        return r6;
                    }
                    throw new IllegalStateException("Cannot subscribe to observable query in a transaction.");
                }
            }).h(BackpressureBufferLastOperator.instance());
        }
        throw new IllegalStateException("Cannot create observable query in transaction. Use query() for a query inside a transaction.");
    }
}
