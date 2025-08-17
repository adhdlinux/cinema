package androidx.work.impl;

import android.content.Context;
import android.os.Build;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.impl.utils.IdGenerator;
import androidx.work.impl.utils.PreferenceUtils;

public class WorkDatabaseMigrations {

    /* renamed from: a  reason: collision with root package name */
    public static Migration f12273a = new Migration(1, 2) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            supportSQLiteDatabase.g("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            supportSQLiteDatabase.g("DROP TABLE IF EXISTS alarmInfo");
            supportSQLiteDatabase.g("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public static Migration f12274b = new Migration(3, 4) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 23) {
                supportSQLiteDatabase.g("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public static Migration f12275c = new Migration(4, 5) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            supportSQLiteDatabase.g("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static Migration f12276d = new Migration(6, 7) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public static Migration f12277e = new Migration(7, 8) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    public static Migration f12278f = new Migration(8, 9) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    };

    /* renamed from: g  reason: collision with root package name */
    public static Migration f12279g = new Migration(11, 12) {
        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    };

    public static class RescheduleMigration extends Migration {

        /* renamed from: c  reason: collision with root package name */
        final Context f12280c;

        public RescheduleMigration(Context context, int i2, int i3) {
            super(i2, i3);
            this.f12280c = context;
        }

        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            if (this.f11528b >= 10) {
                supportSQLiteDatabase.u("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f12280c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class WorkMigration9To10 extends Migration {

        /* renamed from: c  reason: collision with root package name */
        final Context f12281c;

        public WorkMigration9To10(Context context) {
            super(9, 10);
            this.f12281c = context;
        }

        public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            PreferenceUtils.b(this.f12281c, supportSQLiteDatabase);
            IdGenerator.a(this.f12281c, supportSQLiteDatabase);
        }
    }

    private WorkDatabaseMigrations() {
    }
}
