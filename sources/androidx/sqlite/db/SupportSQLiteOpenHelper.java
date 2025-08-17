package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;

public interface SupportSQLiteOpenHelper extends Closeable {

    public static abstract class Callback {

        /* renamed from: a  reason: collision with root package name */
        public final int f11605a;

        public Callback(int i2) {
            this.f11605a = i2;
        }

        private void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w("SupportSQLite", "deleting the database file: " + str);
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception e2) {
                    Log.w("SupportSQLite", "delete failed: ", e2);
                }
            }
        }

        public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r0 != null) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            r3 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            if (r3.hasNext() != false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            a((java.lang.String) r3.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
            a(r3.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002e A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v10 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0029, B:8:0x0030, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0029] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(androidx.sqlite.db.SupportSQLiteDatabase r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Corruption reported by sqlite on database: "
                r0.append(r1)
                java.lang.String r1 = r3.getPath()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "SupportSQLite"
                android.util.Log.e(r1, r0)
                boolean r0 = r3.isOpen()
                if (r0 != 0) goto L_0x0028
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
                return
            L_0x0028:
                r0 = 0
                java.util.List r0 = r3.e()     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
                goto L_0x0030
            L_0x002e:
                r1 = move-exception
                goto L_0x0034
            L_0x0030:
                r3.close()     // Catch:{ IOException -> 0x0056, all -> 0x002e }
                goto L_0x0057
            L_0x0034:
                if (r0 == 0) goto L_0x004e
                java.util.Iterator r3 = r0.iterator()
            L_0x003a:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0055
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.a(r0)
                goto L_0x003a
            L_0x004e:
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
            L_0x0055:
                throw r1
            L_0x0056:
            L_0x0057:
                if (r0 == 0) goto L_0x0071
                java.util.Iterator r3 = r0.iterator()
            L_0x005d:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0078
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.a(r0)
                goto L_0x005d
            L_0x0071:
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Callback.c(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        public abstract void d(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void e(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3);

        public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void g(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3);
    }

    public static class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final Context f11606a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11607b;

        /* renamed from: c  reason: collision with root package name */
        public final Callback f11608c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f11609d;

        public static class Builder {

            /* renamed from: a  reason: collision with root package name */
            Context f11610a;

            /* renamed from: b  reason: collision with root package name */
            String f11611b;

            /* renamed from: c  reason: collision with root package name */
            Callback f11612c;

            /* renamed from: d  reason: collision with root package name */
            boolean f11613d;

            Builder(Context context) {
                this.f11610a = context;
            }

            public Configuration a() {
                if (this.f11612c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.f11610a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.f11613d || !TextUtils.isEmpty(this.f11611b)) {
                    return new Configuration(this.f11610a, this.f11611b, this.f11612c, this.f11613d);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            public Builder b(Callback callback) {
                this.f11612c = callback;
                return this;
            }

            public Builder c(String str) {
                this.f11611b = str;
                return this;
            }

            public Builder d(boolean z2) {
                this.f11613d = z2;
                return this;
            }
        }

        Configuration(Context context, String str, Callback callback, boolean z2) {
            this.f11606a = context;
            this.f11607b = str;
            this.f11608c = callback;
            this.f11609d = z2;
        }

        public static Builder a(Context context) {
            return new Builder(context);
        }
    }

    public interface Factory {
        SupportSQLiteOpenHelper a(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z2);
}
