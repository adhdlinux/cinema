package androidx.work.impl;

import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.impl.WorkDatabaseMigrations;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: l  reason: collision with root package name */
    private static final long f12271l = TimeUnit.DAYS.toMillis(1);

    public static WorkDatabase u(final Context context, Executor executor, boolean z2) {
        RoomDatabase.Builder<WorkDatabase> builder;
        Class<WorkDatabase> cls = WorkDatabase.class;
        if (z2) {
            builder = Room.c(context, cls).c();
        } else {
            builder = Room.a(context, cls, WorkDatabasePathHelper.d());
            builder.f(new SupportSQLiteOpenHelper.Factory() {
                public SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
                    SupportSQLiteOpenHelper.Configuration.Builder a2 = SupportSQLiteOpenHelper.Configuration.a(context);
                    a2.c(configuration.f11607b).b(configuration.f11608c).d(true);
                    return new FrameworkSQLiteOpenHelperFactory().a(a2.a());
                }
            });
        }
        return builder.g(executor).a(w()).b(WorkDatabaseMigrations.f12273a).b(new WorkDatabaseMigrations.RescheduleMigration(context, 2, 3)).b(WorkDatabaseMigrations.f12274b).b(WorkDatabaseMigrations.f12275c).b(new WorkDatabaseMigrations.RescheduleMigration(context, 5, 6)).b(WorkDatabaseMigrations.f12276d).b(WorkDatabaseMigrations.f12277e).b(WorkDatabaseMigrations.f12278f).b(new WorkDatabaseMigrations.WorkMigration9To10(context)).b(new WorkDatabaseMigrations.RescheduleMigration(context, 10, 11)).b(WorkDatabaseMigrations.f12279g).e().d();
    }

    static RoomDatabase.Callback w() {
        return new RoomDatabase.Callback() {
            public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                super.c(supportSQLiteDatabase);
                supportSQLiteDatabase.beginTransaction();
                try {
                    supportSQLiteDatabase.g(WorkDatabase.y());
                    supportSQLiteDatabase.setTransactionSuccessful();
                } finally {
                    supportSQLiteDatabase.endTransaction();
                }
            }
        };
    }

    static long x() {
        return System.currentTimeMillis() - f12271l;
    }

    static String y() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + x() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract SystemIdInfoDao A();

    public abstract WorkNameDao B();

    public abstract WorkProgressDao C();

    public abstract WorkSpecDao D();

    public abstract WorkTagDao E();

    public abstract DependencyDao v();

    public abstract PreferenceDao z();
}
