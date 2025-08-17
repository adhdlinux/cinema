package androidx.work.impl;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.PreferenceDao_Impl;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.SystemIdInfoDao_Impl;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkProgressDao_Impl;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public final class WorkDatabase_Impl extends WorkDatabase {

    /* renamed from: m  reason: collision with root package name */
    private volatile WorkSpecDao f12284m;

    /* renamed from: n  reason: collision with root package name */
    private volatile DependencyDao f12285n;

    /* renamed from: o  reason: collision with root package name */
    private volatile WorkTagDao f12286o;

    /* renamed from: p  reason: collision with root package name */
    private volatile SystemIdInfoDao f12287p;

    /* renamed from: q  reason: collision with root package name */
    private volatile WorkNameDao f12288q;

    /* renamed from: r  reason: collision with root package name */
    private volatile WorkProgressDao f12289r;

    /* renamed from: s  reason: collision with root package name */
    private volatile PreferenceDao f12290s;

    public SystemIdInfoDao A() {
        SystemIdInfoDao systemIdInfoDao;
        if (this.f12287p != null) {
            return this.f12287p;
        }
        synchronized (this) {
            if (this.f12287p == null) {
                this.f12287p = new SystemIdInfoDao_Impl(this);
            }
            systemIdInfoDao = this.f12287p;
        }
        return systemIdInfoDao;
    }

    public WorkNameDao B() {
        WorkNameDao workNameDao;
        if (this.f12288q != null) {
            return this.f12288q;
        }
        synchronized (this) {
            if (this.f12288q == null) {
                this.f12288q = new WorkNameDao_Impl(this);
            }
            workNameDao = this.f12288q;
        }
        return workNameDao;
    }

    public WorkProgressDao C() {
        WorkProgressDao workProgressDao;
        if (this.f12289r != null) {
            return this.f12289r;
        }
        synchronized (this) {
            if (this.f12289r == null) {
                this.f12289r = new WorkProgressDao_Impl(this);
            }
            workProgressDao = this.f12289r;
        }
        return workProgressDao;
    }

    public WorkSpecDao D() {
        WorkSpecDao workSpecDao;
        if (this.f12284m != null) {
            return this.f12284m;
        }
        synchronized (this) {
            if (this.f12284m == null) {
                this.f12284m = new WorkSpecDao_Impl(this);
            }
            workSpecDao = this.f12284m;
        }
        return workSpecDao;
    }

    public WorkTagDao E() {
        WorkTagDao workTagDao;
        if (this.f12286o != null) {
            return this.f12286o;
        }
        synchronized (this) {
            if (this.f12286o == null) {
                this.f12286o = new WorkTagDao_Impl(this);
            }
            workTagDao = this.f12286o;
        }
        return workTagDao;
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker e() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "Dependency", "WorkSpec", "WorkTag", "SystemIdInfo", "WorkName", "WorkProgress", "Preference");
    }

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper f(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.f11382a.a(SupportSQLiteOpenHelper.Configuration.a(databaseConfiguration.f11383b).c(databaseConfiguration.f11384c).b(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(12) {
            public void a(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `Dependency` (`work_spec_id` TEXT NOT NULL, `prerequisite_id` TEXT NOT NULL, PRIMARY KEY(`work_spec_id`, `prerequisite_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE , FOREIGN KEY(`prerequisite_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_Dependency_work_spec_id` ON `Dependency` (`work_spec_id`)");
                supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_Dependency_prerequisite_id` ON `Dependency` (`prerequisite_id`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `WorkSpec` (`id` TEXT NOT NULL, `state` INTEGER NOT NULL, `worker_class_name` TEXT NOT NULL, `input_merger_class_name` TEXT, `input` BLOB NOT NULL, `output` BLOB NOT NULL, `initial_delay` INTEGER NOT NULL, `interval_duration` INTEGER NOT NULL, `flex_duration` INTEGER NOT NULL, `run_attempt_count` INTEGER NOT NULL, `backoff_policy` INTEGER NOT NULL, `backoff_delay_duration` INTEGER NOT NULL, `period_start_time` INTEGER NOT NULL, `minimum_retention_duration` INTEGER NOT NULL, `schedule_requested_at` INTEGER NOT NULL, `run_in_foreground` INTEGER NOT NULL, `out_of_quota_policy` INTEGER NOT NULL, `required_network_type` INTEGER, `requires_charging` INTEGER NOT NULL, `requires_device_idle` INTEGER NOT NULL, `requires_battery_not_low` INTEGER NOT NULL, `requires_storage_not_low` INTEGER NOT NULL, `trigger_content_update_delay` INTEGER NOT NULL, `trigger_max_content_delay` INTEGER NOT NULL, `content_uri_triggers` BLOB, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_WorkSpec_schedule_requested_at` ON `WorkSpec` (`schedule_requested_at`)");
                supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `WorkSpec` (`period_start_time`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `WorkTag` (`tag` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`tag`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_WorkTag_work_spec_id` ON `WorkTag` (`work_spec_id`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `WorkName` (`name` TEXT NOT NULL, `work_spec_id` TEXT NOT NULL, PRIMARY KEY(`name`, `work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.g("CREATE INDEX IF NOT EXISTS `index_WorkName_work_spec_id` ON `WorkName` (`work_spec_id`)");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
                supportSQLiteDatabase.g("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                supportSQLiteDatabase.g("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
            }

            public void b(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `Dependency`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `WorkSpec`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `WorkTag`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `SystemIdInfo`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `WorkName`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `WorkProgress`");
                supportSQLiteDatabase.g("DROP TABLE IF EXISTS `Preference`");
                if (WorkDatabase_Impl.this.f11459h != null) {
                    int size = WorkDatabase_Impl.this.f11459h.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.f11459h.get(i2)).b(supportSQLiteDatabase);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public void c(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (WorkDatabase_Impl.this.f11459h != null) {
                    int size = WorkDatabase_Impl.this.f11459h.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.f11459h.get(i2)).a(supportSQLiteDatabase);
                    }
                }
            }

            public void d(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = WorkDatabase_Impl.this.f11452a = supportSQLiteDatabase;
                supportSQLiteDatabase.g("PRAGMA foreign_keys = ON");
                WorkDatabase_Impl.this.o(supportSQLiteDatabase);
                if (WorkDatabase_Impl.this.f11459h != null) {
                    int size = WorkDatabase_Impl.this.f11459h.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((RoomDatabase.Callback) WorkDatabase_Impl.this.f11459h.get(i2)).c(supportSQLiteDatabase);
                    }
                }
            }

            public void e(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void f(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.a(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public RoomOpenHelper.ValidationResult g(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(2);
                hashMap.put("work_spec_id", new TableInfo.Column("work_spec_id", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap.put("prerequisite_id", new TableInfo.Column("prerequisite_id", AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                HashSet hashSet = new HashSet(2);
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                hashSet.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"prerequisite_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_Dependency_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                hashSet2.add(new TableInfo.Index("index_Dependency_prerequisite_id", false, Arrays.asList(new String[]{"prerequisite_id"})));
                TableInfo tableInfo = new TableInfo("Dependency", hashMap, hashSet, hashSet2);
                TableInfo a2 = TableInfo.a(supportSQLiteDatabase2, "Dependency");
                if (!tableInfo.equals(a2)) {
                    return new RoomOpenHelper.ValidationResult(false, "Dependency(androidx.work.impl.model.Dependency).\n Expected:\n" + tableInfo + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(25);
                hashMap2.put("id", new TableInfo.Column("id", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap2.put(AdOperationMetric.INIT_STATE, new TableInfo.Column(AdOperationMetric.INIT_STATE, "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("worker_class_name", new TableInfo.Column("worker_class_name", AdPreferences.TYPE_TEXT, true, 0, (String) null, 1));
                hashMap2.put("input_merger_class_name", new TableInfo.Column("input_merger_class_name", AdPreferences.TYPE_TEXT, false, 0, (String) null, 1));
                hashMap2.put("input", new TableInfo.Column("input", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("output", new TableInfo.Column("output", "BLOB", true, 0, (String) null, 1));
                hashMap2.put("initial_delay", new TableInfo.Column("initial_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("interval_duration", new TableInfo.Column("interval_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("flex_duration", new TableInfo.Column("flex_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_attempt_count", new TableInfo.Column("run_attempt_count", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_policy", new TableInfo.Column("backoff_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("backoff_delay_duration", new TableInfo.Column("backoff_delay_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("period_start_time", new TableInfo.Column("period_start_time", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("minimum_retention_duration", new TableInfo.Column("minimum_retention_duration", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("schedule_requested_at", new TableInfo.Column("schedule_requested_at", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("run_in_foreground", new TableInfo.Column("run_in_foreground", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("out_of_quota_policy", new TableInfo.Column("out_of_quota_policy", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("required_network_type", new TableInfo.Column("required_network_type", "INTEGER", false, 0, (String) null, 1));
                hashMap2.put("requires_charging", new TableInfo.Column("requires_charging", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_device_idle", new TableInfo.Column("requires_device_idle", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_battery_not_low", new TableInfo.Column("requires_battery_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("requires_storage_not_low", new TableInfo.Column("requires_storage_not_low", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_content_update_delay", new TableInfo.Column("trigger_content_update_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("trigger_max_content_delay", new TableInfo.Column("trigger_max_content_delay", "INTEGER", true, 0, (String) null, 1));
                hashMap2.put("content_uri_triggers", new TableInfo.Column("content_uri_triggers", "BLOB", false, 0, (String) null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(2);
                hashSet4.add(new TableInfo.Index("index_WorkSpec_schedule_requested_at", false, Arrays.asList(new String[]{"schedule_requested_at"})));
                hashSet4.add(new TableInfo.Index("index_WorkSpec_period_start_time", false, Arrays.asList(new String[]{"period_start_time"})));
                TableInfo tableInfo2 = new TableInfo("WorkSpec", hashMap2, hashSet3, hashSet4);
                TableInfo a3 = TableInfo.a(supportSQLiteDatabase2, "WorkSpec");
                if (!tableInfo2.equals(a3)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkSpec(androidx.work.impl.model.WorkSpec).\n Expected:\n" + tableInfo2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(2);
                hashMap3.put("tag", new TableInfo.Column("tag", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap3.put("work_spec_id", new TableInfo.Column("work_spec_id", AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                HashSet hashSet5 = new HashSet(1);
                hashSet5.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet6 = new HashSet(1);
                hashSet6.add(new TableInfo.Index("index_WorkTag_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                TableInfo tableInfo3 = new TableInfo("WorkTag", hashMap3, hashSet5, hashSet6);
                TableInfo a4 = TableInfo.a(supportSQLiteDatabase2, "WorkTag");
                if (!tableInfo3.equals(a4)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkTag(androidx.work.impl.model.WorkTag).\n Expected:\n" + tableInfo3 + "\n Found:\n" + a4);
                }
                HashMap hashMap4 = new HashMap(2);
                hashMap4.put("work_spec_id", new TableInfo.Column("work_spec_id", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap4.put("system_id", new TableInfo.Column("system_id", "INTEGER", true, 0, (String) null, 1));
                HashSet hashSet7 = new HashSet(1);
                hashSet7.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                TableInfo tableInfo4 = new TableInfo("SystemIdInfo", hashMap4, hashSet7, new HashSet(0));
                TableInfo a5 = TableInfo.a(supportSQLiteDatabase2, "SystemIdInfo");
                if (!tableInfo4.equals(a5)) {
                    return new RoomOpenHelper.ValidationResult(false, "SystemIdInfo(androidx.work.impl.model.SystemIdInfo).\n Expected:\n" + tableInfo4 + "\n Found:\n" + a5);
                }
                HashMap hashMap5 = new HashMap(2);
                hashMap5.put("name", new TableInfo.Column("name", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap5.put("work_spec_id", new TableInfo.Column("work_spec_id", AdPreferences.TYPE_TEXT, true, 2, (String) null, 1));
                HashSet hashSet8 = new HashSet(1);
                hashSet8.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet9 = new HashSet(1);
                hashSet9.add(new TableInfo.Index("index_WorkName_work_spec_id", false, Arrays.asList(new String[]{"work_spec_id"})));
                TableInfo tableInfo5 = new TableInfo("WorkName", hashMap5, hashSet8, hashSet9);
                TableInfo a6 = TableInfo.a(supportSQLiteDatabase2, "WorkName");
                if (!tableInfo5.equals(a6)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkName(androidx.work.impl.model.WorkName).\n Expected:\n" + tableInfo5 + "\n Found:\n" + a6);
                }
                HashMap hashMap6 = new HashMap(2);
                hashMap6.put("work_spec_id", new TableInfo.Column("work_spec_id", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap6.put("progress", new TableInfo.Column("progress", "BLOB", true, 0, (String) null, 1));
                HashSet hashSet10 = new HashSet(1);
                hashSet10.add(new TableInfo.ForeignKey("WorkSpec", "CASCADE", "CASCADE", Arrays.asList(new String[]{"work_spec_id"}), Arrays.asList(new String[]{"id"})));
                TableInfo tableInfo6 = new TableInfo("WorkProgress", hashMap6, hashSet10, new HashSet(0));
                TableInfo a7 = TableInfo.a(supportSQLiteDatabase2, "WorkProgress");
                if (!tableInfo6.equals(a7)) {
                    return new RoomOpenHelper.ValidationResult(false, "WorkProgress(androidx.work.impl.model.WorkProgress).\n Expected:\n" + tableInfo6 + "\n Found:\n" + a7);
                }
                HashMap hashMap7 = new HashMap(2);
                hashMap7.put("key", new TableInfo.Column("key", AdPreferences.TYPE_TEXT, true, 1, (String) null, 1));
                hashMap7.put("long_value", new TableInfo.Column("long_value", "INTEGER", false, 0, (String) null, 1));
                TableInfo tableInfo7 = new TableInfo("Preference", hashMap7, new HashSet(0), new HashSet(0));
                TableInfo a8 = TableInfo.a(supportSQLiteDatabase2, "Preference");
                if (tableInfo7.equals(a8)) {
                    return new RoomOpenHelper.ValidationResult(true, (String) null);
                }
                return new RoomOpenHelper.ValidationResult(false, "Preference(androidx.work.impl.model.Preference).\n Expected:\n" + tableInfo7 + "\n Found:\n" + a8);
            }
        }, "c103703e120ae8cc73c9248622f3cd1e", "49f946663a8deb7054212b8adda248c6")).a());
    }

    public DependencyDao v() {
        DependencyDao dependencyDao;
        if (this.f12285n != null) {
            return this.f12285n;
        }
        synchronized (this) {
            if (this.f12285n == null) {
                this.f12285n = new DependencyDao_Impl(this);
            }
            dependencyDao = this.f12285n;
        }
        return dependencyDao;
    }

    public PreferenceDao z() {
        PreferenceDao preferenceDao;
        if (this.f12290s != null) {
            return this.f12290s;
        }
        synchronized (this) {
            if (this.f12290s == null) {
                this.f12290s = new PreferenceDao_Impl(this);
            }
            preferenceDao = this.f12290s;
        }
        return preferenceDao;
    }
}
