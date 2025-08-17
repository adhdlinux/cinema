package androidx.room;

import android.database.Cursor;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.List;

public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    /* renamed from: b  reason: collision with root package name */
    private DatabaseConfiguration f11485b;

    /* renamed from: c  reason: collision with root package name */
    private final Delegate f11486c;

    /* renamed from: d  reason: collision with root package name */
    private final String f11487d;

    /* renamed from: e  reason: collision with root package name */
    private final String f11488e;

    public static abstract class Delegate {

        /* renamed from: a  reason: collision with root package name */
        public final int f11489a;

        public Delegate(int i2) {
            this.f11489a = i2;
        }

        /* access modifiers changed from: protected */
        public abstract void a(SupportSQLiteDatabase supportSQLiteDatabase);

        /* access modifiers changed from: protected */
        public abstract void b(SupportSQLiteDatabase supportSQLiteDatabase);

        /* access modifiers changed from: protected */
        public abstract void c(SupportSQLiteDatabase supportSQLiteDatabase);

        /* access modifiers changed from: protected */
        public abstract void d(SupportSQLiteDatabase supportSQLiteDatabase);

        /* access modifiers changed from: protected */
        public abstract void e(SupportSQLiteDatabase supportSQLiteDatabase);

        /* access modifiers changed from: protected */
        public abstract void f(SupportSQLiteDatabase supportSQLiteDatabase);

        /* access modifiers changed from: protected */
        public ValidationResult g(SupportSQLiteDatabase supportSQLiteDatabase) {
            h(supportSQLiteDatabase);
            return new ValidationResult(true, (String) null);
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public void h(SupportSQLiteDatabase supportSQLiteDatabase) {
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    public static class ValidationResult {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f11490a;

        /* renamed from: b  reason: collision with root package name */
        public final String f11491b;

        public ValidationResult(boolean z2, String str) {
            this.f11490a = z2;
            this.f11491b = str;
        }
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str, String str2) {
        super(delegate.f11489a);
        this.f11485b = databaseConfiguration;
        this.f11486c = delegate;
        this.f11487d = str;
        this.f11488e = str2;
    }

    /* JADX INFO: finally extract failed */
    private void h(SupportSQLiteDatabase supportSQLiteDatabase) {
        String str;
        if (k(supportSQLiteDatabase)) {
            Cursor C = supportSQLiteDatabase.C(new SimpleSQLiteQuery("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
            try {
                if (C.moveToFirst()) {
                    str = C.getString(0);
                } else {
                    str = null;
                }
                C.close();
                if (!this.f11487d.equals(str) && !this.f11488e.equals(str)) {
                    throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                }
            } catch (Throwable th) {
                C.close();
                throw th;
            }
        } else {
            ValidationResult g2 = this.f11486c.g(supportSQLiteDatabase);
            if (g2.f11490a) {
                this.f11486c.e(supportSQLiteDatabase);
                l(supportSQLiteDatabase);
                return;
            }
            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g2.f11491b);
        }
    }

    private void i(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private static boolean j(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor Z = supportSQLiteDatabase.Z("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z2 = false;
            if (Z.moveToFirst() && Z.getInt(0) == 0) {
                z2 = true;
            }
            return z2;
        } finally {
            Z.close();
        }
    }

    private static boolean k(SupportSQLiteDatabase supportSQLiteDatabase) {
        Cursor Z = supportSQLiteDatabase.Z("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
        try {
            boolean z2 = false;
            if (Z.moveToFirst() && Z.getInt(0) != 0) {
                z2 = true;
            }
            return z2;
        } finally {
            Z.close();
        }
    }

    private void l(SupportSQLiteDatabase supportSQLiteDatabase) {
        i(supportSQLiteDatabase);
        supportSQLiteDatabase.g(RoomMasterTable.a(this.f11487d));
    }

    public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.b(supportSQLiteDatabase);
    }

    public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
        boolean j2 = j(supportSQLiteDatabase);
        this.f11486c.a(supportSQLiteDatabase);
        if (!j2) {
            ValidationResult g2 = this.f11486c.g(supportSQLiteDatabase);
            if (!g2.f11490a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g2.f11491b);
            }
        }
        l(supportSQLiteDatabase);
        this.f11486c.c(supportSQLiteDatabase);
    }

    public void e(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        g(supportSQLiteDatabase, i2, i3);
    }

    public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
        super.f(supportSQLiteDatabase);
        h(supportSQLiteDatabase);
        this.f11486c.d(supportSQLiteDatabase);
        this.f11485b = null;
    }

    public void g(SupportSQLiteDatabase supportSQLiteDatabase, int i2, int i3) {
        boolean z2;
        List<Migration> c2;
        DatabaseConfiguration databaseConfiguration = this.f11485b;
        if (databaseConfiguration == null || (c2 = databaseConfiguration.f11385d.c(i2, i3)) == null) {
            z2 = false;
        } else {
            this.f11486c.f(supportSQLiteDatabase);
            for (Migration a2 : c2) {
                a2.a(supportSQLiteDatabase);
            }
            ValidationResult g2 = this.f11486c.g(supportSQLiteDatabase);
            if (g2.f11490a) {
                this.f11486c.e(supportSQLiteDatabase);
                l(supportSQLiteDatabase);
                z2 = true;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g2.f11491b);
            }
        }
        if (!z2) {
            DatabaseConfiguration databaseConfiguration2 = this.f11485b;
            if (databaseConfiguration2 == null || databaseConfiguration2.a(i2, i3)) {
                throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
            }
            this.f11486c.b(supportSQLiteDatabase);
            this.f11486c.a(supportSQLiteDatabase);
        }
    }
}
