package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import com.unity3d.services.core.request.metrics.AdOperationMetric;
import java.util.ArrayList;
import java.util.List;

public final class WorkSpecDao_Impl implements WorkSpecDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12542a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkSpec> f12543b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f12544c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f12545d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f12546e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f12547f;

    /* renamed from: g  reason: collision with root package name */
    private final SharedSQLiteStatement f12548g;

    /* renamed from: h  reason: collision with root package name */
    private final SharedSQLiteStatement f12549h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedSQLiteStatement f12550i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedSQLiteStatement f12551j;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.f12542a = roomDatabase;
        this.f12543b = new EntityInsertionAdapter<WorkSpec>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkSpec workSpec) {
                String str = workSpec.f12516a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                supportSQLiteStatement.X(2, (long) WorkTypeConverters.j(workSpec.f12517b));
                String str2 = workSpec.f12518c;
                if (str2 == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, str2);
                }
                String str3 = workSpec.f12519d;
                if (str3 == null) {
                    supportSQLiteStatement.d0(4);
                } else {
                    supportSQLiteStatement.R(4, str3);
                }
                byte[] m2 = Data.m(workSpec.f12520e);
                if (m2 == null) {
                    supportSQLiteStatement.d0(5);
                } else {
                    supportSQLiteStatement.Y(5, m2);
                }
                byte[] m3 = Data.m(workSpec.f12521f);
                if (m3 == null) {
                    supportSQLiteStatement.d0(6);
                } else {
                    supportSQLiteStatement.Y(6, m3);
                }
                supportSQLiteStatement.X(7, workSpec.f12522g);
                supportSQLiteStatement.X(8, workSpec.f12523h);
                supportSQLiteStatement.X(9, workSpec.f12524i);
                supportSQLiteStatement.X(10, (long) workSpec.f12526k);
                supportSQLiteStatement.X(11, (long) WorkTypeConverters.a(workSpec.f12527l));
                supportSQLiteStatement.X(12, workSpec.f12528m);
                supportSQLiteStatement.X(13, workSpec.f12529n);
                supportSQLiteStatement.X(14, workSpec.f12530o);
                supportSQLiteStatement.X(15, workSpec.f12531p);
                supportSQLiteStatement.X(16, workSpec.f12532q ? 1 : 0);
                supportSQLiteStatement.X(17, (long) WorkTypeConverters.i(workSpec.f12533r));
                Constraints constraints = workSpec.f12525j;
                if (constraints != null) {
                    supportSQLiteStatement.X(18, (long) WorkTypeConverters.h(constraints.b()));
                    supportSQLiteStatement.X(19, constraints.g() ? 1 : 0);
                    supportSQLiteStatement.X(20, constraints.h() ? 1 : 0);
                    supportSQLiteStatement.X(21, constraints.f() ? 1 : 0);
                    supportSQLiteStatement.X(22, constraints.i() ? 1 : 0);
                    supportSQLiteStatement.X(23, constraints.c());
                    supportSQLiteStatement.X(24, constraints.d());
                    byte[] c2 = WorkTypeConverters.c(constraints.a());
                    if (c2 == null) {
                        supportSQLiteStatement.d0(25);
                    } else {
                        supportSQLiteStatement.Y(25, c2);
                    }
                } else {
                    supportSQLiteStatement.d0(18);
                    supportSQLiteStatement.d0(19);
                    supportSQLiteStatement.d0(20);
                    supportSQLiteStatement.d0(21);
                    supportSQLiteStatement.d0(22);
                    supportSQLiteStatement.d0(23);
                    supportSQLiteStatement.d0(24);
                    supportSQLiteStatement.d0(25);
                }
            }
        };
        this.f12544c = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.f12545d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.f12546e = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.f12547f = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.f12548g = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.f12549h = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.f12550i = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        this.f12551j = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
            }
        };
    }

    public int a(WorkInfo.State state, String... strArr) {
        this.f12542a.b();
        StringBuilder b2 = StringUtil.b();
        b2.append("UPDATE workspec SET state=");
        b2.append("?");
        b2.append(" WHERE id IN (");
        StringUtil.a(b2, strArr.length);
        b2.append(")");
        SupportSQLiteStatement d2 = this.f12542a.d(b2.toString());
        d2.X(1, (long) WorkTypeConverters.j(state));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                d2.d0(i2);
            } else {
                d2.R(i2, str);
            }
            i2++;
        }
        this.f12542a.c();
        try {
            int j2 = d2.j();
            this.f12542a.t();
            return j2;
        } finally {
            this.f12542a.g();
        }
    }

    public List<WorkSpec> b(long j2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        i2.X(1, j2);
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "required_network_type");
            int b3 = CursorUtil.b(c2, "requires_charging");
            int b4 = CursorUtil.b(c2, "requires_device_idle");
            int b5 = CursorUtil.b(c2, "requires_battery_not_low");
            int b6 = CursorUtil.b(c2, "requires_storage_not_low");
            int b7 = CursorUtil.b(c2, "trigger_content_update_delay");
            int b8 = CursorUtil.b(c2, "trigger_max_content_delay");
            int b9 = CursorUtil.b(c2, "content_uri_triggers");
            int b10 = CursorUtil.b(c2, "id");
            int b11 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            int b12 = CursorUtil.b(c2, "worker_class_name");
            int b13 = CursorUtil.b(c2, "input_merger_class_name");
            int b14 = CursorUtil.b(c2, "input");
            int b15 = CursorUtil.b(c2, "output");
            roomSQLiteQuery = i2;
            try {
                int b16 = CursorUtil.b(c2, "initial_delay");
                int b17 = CursorUtil.b(c2, "interval_duration");
                int b18 = CursorUtil.b(c2, "flex_duration");
                int b19 = CursorUtil.b(c2, "run_attempt_count");
                int b20 = CursorUtil.b(c2, "backoff_policy");
                int b21 = CursorUtil.b(c2, "backoff_delay_duration");
                int b22 = CursorUtil.b(c2, "period_start_time");
                int b23 = CursorUtil.b(c2, "minimum_retention_duration");
                int b24 = CursorUtil.b(c2, "schedule_requested_at");
                int b25 = CursorUtil.b(c2, "run_in_foreground");
                int b26 = CursorUtil.b(c2, "out_of_quota_policy");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(c2.getCount());
                while (c2.moveToNext()) {
                    String string = c2.getString(b10);
                    int i4 = b10;
                    String string2 = c2.getString(b12);
                    int i5 = b12;
                    Constraints constraints = new Constraints();
                    int i6 = b2;
                    constraints.k(WorkTypeConverters.e(c2.getInt(b2)));
                    if (c2.getInt(b3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.m(z2);
                    if (c2.getInt(b4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.n(z3);
                    if (c2.getInt(b5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.l(z4);
                    if (c2.getInt(b6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    constraints.o(z5);
                    int i7 = b3;
                    int i8 = b4;
                    constraints.p(c2.getLong(b7));
                    constraints.q(c2.getLong(b8));
                    constraints.j(WorkTypeConverters.b(c2.getBlob(b9)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.f12517b = WorkTypeConverters.g(c2.getInt(b11));
                    workSpec.f12519d = c2.getString(b13);
                    workSpec.f12520e = Data.h(c2.getBlob(b14));
                    int i9 = i3;
                    workSpec.f12521f = Data.h(c2.getBlob(i9));
                    int i10 = b16;
                    int i11 = i7;
                    i3 = i9;
                    workSpec.f12522g = c2.getLong(i10);
                    int i12 = b13;
                    int i13 = b17;
                    workSpec.f12523h = c2.getLong(i13);
                    int i14 = i10;
                    int i15 = b5;
                    int i16 = b18;
                    workSpec.f12524i = c2.getLong(i16);
                    int i17 = b19;
                    workSpec.f12526k = c2.getInt(i17);
                    int i18 = b20;
                    int i19 = i13;
                    workSpec.f12527l = WorkTypeConverters.d(c2.getInt(i18));
                    b18 = i16;
                    int i20 = i15;
                    int i21 = b21;
                    workSpec.f12528m = c2.getLong(i21);
                    int i22 = i17;
                    int i23 = i18;
                    int i24 = b22;
                    workSpec.f12529n = c2.getLong(i24);
                    int i25 = i21;
                    b22 = i24;
                    int i26 = b23;
                    workSpec.f12530o = c2.getLong(i26);
                    int i27 = i22;
                    int i28 = b24;
                    workSpec.f12531p = c2.getLong(i28);
                    int i29 = b25;
                    if (c2.getInt(i29) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    workSpec.f12532q = z6;
                    int i30 = b26;
                    int i31 = i28;
                    workSpec.f12533r = WorkTypeConverters.f(c2.getInt(i30));
                    workSpec.f12525j = constraints;
                    arrayList.add(workSpec);
                    b3 = i11;
                    b26 = i30;
                    b13 = i12;
                    b16 = i14;
                    b17 = i19;
                    b19 = i27;
                    b24 = i31;
                    b10 = i4;
                    b12 = i5;
                    b2 = i6;
                    b25 = i29;
                    b23 = i26;
                    b4 = i8;
                    int i32 = i23;
                    b21 = i25;
                    b5 = i20;
                    b20 = i32;
                }
                c2.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = i2;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public void c(WorkSpec workSpec) {
        this.f12542a.b();
        this.f12542a.c();
        try {
            this.f12543b.h(workSpec);
            this.f12542a.t();
        } finally {
            this.f12542a.g();
        }
    }

    public List<WorkSpec> d() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "required_network_type");
            int b3 = CursorUtil.b(c2, "requires_charging");
            int b4 = CursorUtil.b(c2, "requires_device_idle");
            int b5 = CursorUtil.b(c2, "requires_battery_not_low");
            int b6 = CursorUtil.b(c2, "requires_storage_not_low");
            int b7 = CursorUtil.b(c2, "trigger_content_update_delay");
            int b8 = CursorUtil.b(c2, "trigger_max_content_delay");
            int b9 = CursorUtil.b(c2, "content_uri_triggers");
            int b10 = CursorUtil.b(c2, "id");
            int b11 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            int b12 = CursorUtil.b(c2, "worker_class_name");
            int b13 = CursorUtil.b(c2, "input_merger_class_name");
            int b14 = CursorUtil.b(c2, "input");
            int b15 = CursorUtil.b(c2, "output");
            roomSQLiteQuery = i2;
            try {
                int b16 = CursorUtil.b(c2, "initial_delay");
                int b17 = CursorUtil.b(c2, "interval_duration");
                int b18 = CursorUtil.b(c2, "flex_duration");
                int b19 = CursorUtil.b(c2, "run_attempt_count");
                int b20 = CursorUtil.b(c2, "backoff_policy");
                int b21 = CursorUtil.b(c2, "backoff_delay_duration");
                int b22 = CursorUtil.b(c2, "period_start_time");
                int b23 = CursorUtil.b(c2, "minimum_retention_duration");
                int b24 = CursorUtil.b(c2, "schedule_requested_at");
                int b25 = CursorUtil.b(c2, "run_in_foreground");
                int b26 = CursorUtil.b(c2, "out_of_quota_policy");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(c2.getCount());
                while (c2.moveToNext()) {
                    String string = c2.getString(b10);
                    int i4 = b10;
                    String string2 = c2.getString(b12);
                    int i5 = b12;
                    Constraints constraints = new Constraints();
                    int i6 = b2;
                    constraints.k(WorkTypeConverters.e(c2.getInt(b2)));
                    if (c2.getInt(b3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.m(z2);
                    if (c2.getInt(b4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.n(z3);
                    if (c2.getInt(b5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.l(z4);
                    if (c2.getInt(b6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    constraints.o(z5);
                    int i7 = b3;
                    int i8 = b4;
                    constraints.p(c2.getLong(b7));
                    constraints.q(c2.getLong(b8));
                    constraints.j(WorkTypeConverters.b(c2.getBlob(b9)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.f12517b = WorkTypeConverters.g(c2.getInt(b11));
                    workSpec.f12519d = c2.getString(b13);
                    workSpec.f12520e = Data.h(c2.getBlob(b14));
                    int i9 = i3;
                    workSpec.f12521f = Data.h(c2.getBlob(i9));
                    int i10 = i7;
                    i3 = i9;
                    int i11 = b16;
                    workSpec.f12522g = c2.getLong(i11);
                    int i12 = b14;
                    int i13 = b17;
                    workSpec.f12523h = c2.getLong(i13);
                    int i14 = i11;
                    int i15 = b5;
                    int i16 = b18;
                    workSpec.f12524i = c2.getLong(i16);
                    int i17 = b19;
                    workSpec.f12526k = c2.getInt(i17);
                    int i18 = b20;
                    int i19 = i13;
                    workSpec.f12527l = WorkTypeConverters.d(c2.getInt(i18));
                    b18 = i16;
                    int i20 = i15;
                    int i21 = b21;
                    workSpec.f12528m = c2.getLong(i21);
                    int i22 = i17;
                    int i23 = i18;
                    int i24 = b22;
                    workSpec.f12529n = c2.getLong(i24);
                    int i25 = i21;
                    b22 = i24;
                    int i26 = b23;
                    workSpec.f12530o = c2.getLong(i26);
                    int i27 = i22;
                    int i28 = b24;
                    workSpec.f12531p = c2.getLong(i28);
                    int i29 = b25;
                    if (c2.getInt(i29) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    workSpec.f12532q = z6;
                    int i30 = b26;
                    int i31 = i28;
                    workSpec.f12533r = WorkTypeConverters.f(c2.getInt(i30));
                    workSpec.f12525j = constraints;
                    arrayList.add(workSpec);
                    b26 = i30;
                    b3 = i10;
                    b14 = i12;
                    b16 = i14;
                    b17 = i19;
                    b19 = i27;
                    b24 = i31;
                    b10 = i4;
                    b12 = i5;
                    b2 = i6;
                    b25 = i29;
                    b23 = i26;
                    b4 = i8;
                    int i32 = i23;
                    b21 = i25;
                    b5 = i20;
                    b20 = i32;
                }
                c2.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = i2;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public void delete(String str) {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12544c.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f12542a.c();
        try {
            a2.j();
            this.f12542a.t();
        } finally {
            this.f12542a.g();
            this.f12544c.f(a2);
        }
    }

    public List<String> e(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(c2.getString(0));
            }
            return arrayList;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public WorkInfo.State f(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12542a.b();
        WorkInfo.State state = null;
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst()) {
                state = WorkTypeConverters.g(c2.getInt(0));
            }
            return state;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public WorkSpec g(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        WorkSpec workSpec;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        String str2 = str;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            i2.d0(1);
        } else {
            i2.R(1, str2);
        }
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "required_network_type");
            int b3 = CursorUtil.b(c2, "requires_charging");
            int b4 = CursorUtil.b(c2, "requires_device_idle");
            int b5 = CursorUtil.b(c2, "requires_battery_not_low");
            int b6 = CursorUtil.b(c2, "requires_storage_not_low");
            int b7 = CursorUtil.b(c2, "trigger_content_update_delay");
            int b8 = CursorUtil.b(c2, "trigger_max_content_delay");
            int b9 = CursorUtil.b(c2, "content_uri_triggers");
            int b10 = CursorUtil.b(c2, "id");
            int b11 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            int b12 = CursorUtil.b(c2, "worker_class_name");
            int b13 = CursorUtil.b(c2, "input_merger_class_name");
            int b14 = CursorUtil.b(c2, "input");
            int b15 = CursorUtil.b(c2, "output");
            roomSQLiteQuery = i2;
            try {
                int b16 = CursorUtil.b(c2, "initial_delay");
                int b17 = CursorUtil.b(c2, "interval_duration");
                int b18 = CursorUtil.b(c2, "flex_duration");
                int b19 = CursorUtil.b(c2, "run_attempt_count");
                int b20 = CursorUtil.b(c2, "backoff_policy");
                int b21 = CursorUtil.b(c2, "backoff_delay_duration");
                int b22 = CursorUtil.b(c2, "period_start_time");
                int b23 = CursorUtil.b(c2, "minimum_retention_duration");
                int b24 = CursorUtil.b(c2, "schedule_requested_at");
                int b25 = CursorUtil.b(c2, "run_in_foreground");
                int b26 = CursorUtil.b(c2, "out_of_quota_policy");
                if (c2.moveToFirst()) {
                    String string = c2.getString(b10);
                    String string2 = c2.getString(b12);
                    int i3 = b26;
                    Constraints constraints = new Constraints();
                    constraints.k(WorkTypeConverters.e(c2.getInt(b2)));
                    if (c2.getInt(b3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.m(z2);
                    if (c2.getInt(b4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.n(z3);
                    if (c2.getInt(b5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.l(z4);
                    if (c2.getInt(b6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    constraints.o(z5);
                    constraints.p(c2.getLong(b7));
                    constraints.q(c2.getLong(b8));
                    constraints.j(WorkTypeConverters.b(c2.getBlob(b9)));
                    WorkSpec workSpec2 = new WorkSpec(string, string2);
                    workSpec2.f12517b = WorkTypeConverters.g(c2.getInt(b11));
                    workSpec2.f12519d = c2.getString(b13);
                    workSpec2.f12520e = Data.h(c2.getBlob(b14));
                    workSpec2.f12521f = Data.h(c2.getBlob(b15));
                    workSpec2.f12522g = c2.getLong(b16);
                    workSpec2.f12523h = c2.getLong(b17);
                    workSpec2.f12524i = c2.getLong(b18);
                    workSpec2.f12526k = c2.getInt(b19);
                    workSpec2.f12527l = WorkTypeConverters.d(c2.getInt(b20));
                    workSpec2.f12528m = c2.getLong(b21);
                    workSpec2.f12529n = c2.getLong(b22);
                    workSpec2.f12530o = c2.getLong(b23);
                    workSpec2.f12531p = c2.getLong(b24);
                    if (c2.getInt(b25) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    workSpec2.f12532q = z6;
                    workSpec2.f12533r = WorkTypeConverters.f(c2.getInt(i3));
                    workSpec2.f12525j = constraints;
                    workSpec = workSpec2;
                } else {
                    workSpec = null;
                }
                c2.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = i2;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<String> h(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=?)", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(c2.getString(0));
            }
            return arrayList;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public List<Data> i(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                arrayList.add(Data.h(c2.getBlob(0)));
            }
            return arrayList;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public List<WorkSpec> j(int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        i3.X(1, (long) i2);
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i3, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "required_network_type");
            int b3 = CursorUtil.b(c2, "requires_charging");
            int b4 = CursorUtil.b(c2, "requires_device_idle");
            int b5 = CursorUtil.b(c2, "requires_battery_not_low");
            int b6 = CursorUtil.b(c2, "requires_storage_not_low");
            int b7 = CursorUtil.b(c2, "trigger_content_update_delay");
            int b8 = CursorUtil.b(c2, "trigger_max_content_delay");
            int b9 = CursorUtil.b(c2, "content_uri_triggers");
            int b10 = CursorUtil.b(c2, "id");
            int b11 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            int b12 = CursorUtil.b(c2, "worker_class_name");
            int b13 = CursorUtil.b(c2, "input_merger_class_name");
            int b14 = CursorUtil.b(c2, "input");
            int b15 = CursorUtil.b(c2, "output");
            roomSQLiteQuery = i3;
            try {
                int b16 = CursorUtil.b(c2, "initial_delay");
                int b17 = CursorUtil.b(c2, "interval_duration");
                int b18 = CursorUtil.b(c2, "flex_duration");
                int b19 = CursorUtil.b(c2, "run_attempt_count");
                int b20 = CursorUtil.b(c2, "backoff_policy");
                int b21 = CursorUtil.b(c2, "backoff_delay_duration");
                int b22 = CursorUtil.b(c2, "period_start_time");
                int b23 = CursorUtil.b(c2, "minimum_retention_duration");
                int b24 = CursorUtil.b(c2, "schedule_requested_at");
                int b25 = CursorUtil.b(c2, "run_in_foreground");
                int b26 = CursorUtil.b(c2, "out_of_quota_policy");
                int i4 = b15;
                ArrayList arrayList = new ArrayList(c2.getCount());
                while (c2.moveToNext()) {
                    String string = c2.getString(b10);
                    int i5 = b10;
                    String string2 = c2.getString(b12);
                    int i6 = b12;
                    Constraints constraints = new Constraints();
                    int i7 = b2;
                    constraints.k(WorkTypeConverters.e(c2.getInt(b2)));
                    if (c2.getInt(b3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.m(z2);
                    if (c2.getInt(b4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.n(z3);
                    if (c2.getInt(b5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.l(z4);
                    if (c2.getInt(b6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    constraints.o(z5);
                    int i8 = b3;
                    int i9 = b4;
                    constraints.p(c2.getLong(b7));
                    constraints.q(c2.getLong(b8));
                    constraints.j(WorkTypeConverters.b(c2.getBlob(b9)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.f12517b = WorkTypeConverters.g(c2.getInt(b11));
                    workSpec.f12519d = c2.getString(b13);
                    workSpec.f12520e = Data.h(c2.getBlob(b14));
                    int i10 = i4;
                    workSpec.f12521f = Data.h(c2.getBlob(i10));
                    int i11 = i8;
                    i4 = i10;
                    int i12 = b16;
                    workSpec.f12522g = c2.getLong(i12);
                    int i13 = b13;
                    int i14 = b17;
                    workSpec.f12523h = c2.getLong(i14);
                    int i15 = i12;
                    int i16 = b5;
                    int i17 = b18;
                    workSpec.f12524i = c2.getLong(i17);
                    int i18 = b19;
                    workSpec.f12526k = c2.getInt(i18);
                    int i19 = b20;
                    int i20 = i14;
                    workSpec.f12527l = WorkTypeConverters.d(c2.getInt(i19));
                    b18 = i17;
                    int i21 = i16;
                    int i22 = b21;
                    workSpec.f12528m = c2.getLong(i22);
                    int i23 = i18;
                    int i24 = i19;
                    int i25 = b22;
                    workSpec.f12529n = c2.getLong(i25);
                    int i26 = i22;
                    b22 = i25;
                    int i27 = b23;
                    workSpec.f12530o = c2.getLong(i27);
                    int i28 = i23;
                    int i29 = b24;
                    workSpec.f12531p = c2.getLong(i29);
                    int i30 = b25;
                    if (c2.getInt(i30) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    workSpec.f12532q = z6;
                    int i31 = b26;
                    int i32 = i29;
                    workSpec.f12533r = WorkTypeConverters.f(c2.getInt(i31));
                    workSpec.f12525j = constraints;
                    arrayList.add(workSpec);
                    b26 = i31;
                    b3 = i11;
                    b13 = i13;
                    b16 = i15;
                    b17 = i20;
                    b19 = i28;
                    b24 = i32;
                    b10 = i5;
                    b12 = i6;
                    b2 = i7;
                    b25 = i30;
                    b23 = i27;
                    b4 = i9;
                    int i33 = i24;
                    b21 = i26;
                    b5 = i21;
                    b20 = i33;
                }
                c2.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = i3;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public int k() {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12550i.a();
        this.f12542a.c();
        try {
            int j2 = a2.j();
            this.f12542a.t();
            return j2;
        } finally {
            this.f12542a.g();
            this.f12550i.f(a2);
        }
    }

    public int l(String str, long j2) {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12549h.a();
        a2.X(1, j2);
        if (str == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        this.f12542a.c();
        try {
            int j3 = a2.j();
            this.f12542a.t();
            return j3;
        } finally {
            this.f12542a.g();
            this.f12549h.f(a2);
        }
    }

    public List<WorkSpec.IdAndState> m(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "id");
            int b3 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            ArrayList arrayList = new ArrayList(c2.getCount());
            while (c2.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.f12534a = c2.getString(b2);
                idAndState.f12535b = WorkTypeConverters.g(c2.getInt(b3));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public List<WorkSpec> n(int i2) {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        i3.X(1, (long) i2);
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i3, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "required_network_type");
            int b3 = CursorUtil.b(c2, "requires_charging");
            int b4 = CursorUtil.b(c2, "requires_device_idle");
            int b5 = CursorUtil.b(c2, "requires_battery_not_low");
            int b6 = CursorUtil.b(c2, "requires_storage_not_low");
            int b7 = CursorUtil.b(c2, "trigger_content_update_delay");
            int b8 = CursorUtil.b(c2, "trigger_max_content_delay");
            int b9 = CursorUtil.b(c2, "content_uri_triggers");
            int b10 = CursorUtil.b(c2, "id");
            int b11 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            int b12 = CursorUtil.b(c2, "worker_class_name");
            int b13 = CursorUtil.b(c2, "input_merger_class_name");
            int b14 = CursorUtil.b(c2, "input");
            int b15 = CursorUtil.b(c2, "output");
            roomSQLiteQuery = i3;
            try {
                int b16 = CursorUtil.b(c2, "initial_delay");
                int b17 = CursorUtil.b(c2, "interval_duration");
                int b18 = CursorUtil.b(c2, "flex_duration");
                int b19 = CursorUtil.b(c2, "run_attempt_count");
                int b20 = CursorUtil.b(c2, "backoff_policy");
                int b21 = CursorUtil.b(c2, "backoff_delay_duration");
                int b22 = CursorUtil.b(c2, "period_start_time");
                int b23 = CursorUtil.b(c2, "minimum_retention_duration");
                int b24 = CursorUtil.b(c2, "schedule_requested_at");
                int b25 = CursorUtil.b(c2, "run_in_foreground");
                int b26 = CursorUtil.b(c2, "out_of_quota_policy");
                int i4 = b15;
                ArrayList arrayList = new ArrayList(c2.getCount());
                while (c2.moveToNext()) {
                    String string = c2.getString(b10);
                    int i5 = b10;
                    String string2 = c2.getString(b12);
                    int i6 = b12;
                    Constraints constraints = new Constraints();
                    int i7 = b2;
                    constraints.k(WorkTypeConverters.e(c2.getInt(b2)));
                    if (c2.getInt(b3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.m(z2);
                    if (c2.getInt(b4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.n(z3);
                    if (c2.getInt(b5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.l(z4);
                    if (c2.getInt(b6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    constraints.o(z5);
                    int i8 = b3;
                    int i9 = b4;
                    constraints.p(c2.getLong(b7));
                    constraints.q(c2.getLong(b8));
                    constraints.j(WorkTypeConverters.b(c2.getBlob(b9)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.f12517b = WorkTypeConverters.g(c2.getInt(b11));
                    workSpec.f12519d = c2.getString(b13);
                    workSpec.f12520e = Data.h(c2.getBlob(b14));
                    int i10 = i4;
                    workSpec.f12521f = Data.h(c2.getBlob(i10));
                    int i11 = i8;
                    i4 = i10;
                    int i12 = b16;
                    workSpec.f12522g = c2.getLong(i12);
                    int i13 = b13;
                    int i14 = b17;
                    workSpec.f12523h = c2.getLong(i14);
                    int i15 = i12;
                    int i16 = b5;
                    int i17 = b18;
                    workSpec.f12524i = c2.getLong(i17);
                    int i18 = b19;
                    workSpec.f12526k = c2.getInt(i18);
                    int i19 = b20;
                    int i20 = i14;
                    workSpec.f12527l = WorkTypeConverters.d(c2.getInt(i19));
                    b18 = i17;
                    int i21 = i16;
                    int i22 = b21;
                    workSpec.f12528m = c2.getLong(i22);
                    int i23 = i18;
                    int i24 = i19;
                    int i25 = b22;
                    workSpec.f12529n = c2.getLong(i25);
                    int i26 = i22;
                    b22 = i25;
                    int i27 = b23;
                    workSpec.f12530o = c2.getLong(i27);
                    int i28 = i23;
                    int i29 = b24;
                    workSpec.f12531p = c2.getLong(i29);
                    int i30 = b25;
                    if (c2.getInt(i30) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    workSpec.f12532q = z6;
                    int i31 = b26;
                    int i32 = i29;
                    workSpec.f12533r = WorkTypeConverters.f(c2.getInt(i31));
                    workSpec.f12525j = constraints;
                    arrayList.add(workSpec);
                    b26 = i31;
                    b3 = i11;
                    b13 = i13;
                    b16 = i15;
                    b17 = i20;
                    b19 = i28;
                    b24 = i32;
                    b10 = i5;
                    b12 = i6;
                    b2 = i7;
                    b25 = i30;
                    b23 = i27;
                    b4 = i9;
                    int i33 = i24;
                    b21 = i26;
                    b5 = i21;
                    b20 = i33;
                }
                c2.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = i3;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public void o(String str, Data data) {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12545d.a();
        byte[] m2 = Data.m(data);
        if (m2 == null) {
            a2.d0(1);
        } else {
            a2.Y(1, m2);
        }
        if (str == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        this.f12542a.c();
        try {
            a2.j();
            this.f12542a.t();
        } finally {
            this.f12542a.g();
            this.f12545d.f(a2);
        }
    }

    public List<WorkSpec> p() {
        RoomSQLiteQuery roomSQLiteQuery;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "required_network_type");
            int b3 = CursorUtil.b(c2, "requires_charging");
            int b4 = CursorUtil.b(c2, "requires_device_idle");
            int b5 = CursorUtil.b(c2, "requires_battery_not_low");
            int b6 = CursorUtil.b(c2, "requires_storage_not_low");
            int b7 = CursorUtil.b(c2, "trigger_content_update_delay");
            int b8 = CursorUtil.b(c2, "trigger_max_content_delay");
            int b9 = CursorUtil.b(c2, "content_uri_triggers");
            int b10 = CursorUtil.b(c2, "id");
            int b11 = CursorUtil.b(c2, AdOperationMetric.INIT_STATE);
            int b12 = CursorUtil.b(c2, "worker_class_name");
            int b13 = CursorUtil.b(c2, "input_merger_class_name");
            int b14 = CursorUtil.b(c2, "input");
            int b15 = CursorUtil.b(c2, "output");
            roomSQLiteQuery = i2;
            try {
                int b16 = CursorUtil.b(c2, "initial_delay");
                int b17 = CursorUtil.b(c2, "interval_duration");
                int b18 = CursorUtil.b(c2, "flex_duration");
                int b19 = CursorUtil.b(c2, "run_attempt_count");
                int b20 = CursorUtil.b(c2, "backoff_policy");
                int b21 = CursorUtil.b(c2, "backoff_delay_duration");
                int b22 = CursorUtil.b(c2, "period_start_time");
                int b23 = CursorUtil.b(c2, "minimum_retention_duration");
                int b24 = CursorUtil.b(c2, "schedule_requested_at");
                int b25 = CursorUtil.b(c2, "run_in_foreground");
                int b26 = CursorUtil.b(c2, "out_of_quota_policy");
                int i3 = b15;
                ArrayList arrayList = new ArrayList(c2.getCount());
                while (c2.moveToNext()) {
                    String string = c2.getString(b10);
                    int i4 = b10;
                    String string2 = c2.getString(b12);
                    int i5 = b12;
                    Constraints constraints = new Constraints();
                    int i6 = b2;
                    constraints.k(WorkTypeConverters.e(c2.getInt(b2)));
                    if (c2.getInt(b3) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    constraints.m(z2);
                    if (c2.getInt(b4) != 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    constraints.n(z3);
                    if (c2.getInt(b5) != 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    constraints.l(z4);
                    if (c2.getInt(b6) != 0) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    constraints.o(z5);
                    int i7 = b3;
                    int i8 = b4;
                    constraints.p(c2.getLong(b7));
                    constraints.q(c2.getLong(b8));
                    constraints.j(WorkTypeConverters.b(c2.getBlob(b9)));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.f12517b = WorkTypeConverters.g(c2.getInt(b11));
                    workSpec.f12519d = c2.getString(b13);
                    workSpec.f12520e = Data.h(c2.getBlob(b14));
                    int i9 = i3;
                    workSpec.f12521f = Data.h(c2.getBlob(i9));
                    int i10 = i7;
                    i3 = i9;
                    int i11 = b16;
                    workSpec.f12522g = c2.getLong(i11);
                    int i12 = b14;
                    int i13 = b17;
                    workSpec.f12523h = c2.getLong(i13);
                    int i14 = i11;
                    int i15 = b5;
                    int i16 = b18;
                    workSpec.f12524i = c2.getLong(i16);
                    int i17 = b19;
                    workSpec.f12526k = c2.getInt(i17);
                    int i18 = b20;
                    int i19 = i13;
                    workSpec.f12527l = WorkTypeConverters.d(c2.getInt(i18));
                    b18 = i16;
                    int i20 = i15;
                    int i21 = b21;
                    workSpec.f12528m = c2.getLong(i21);
                    int i22 = i17;
                    int i23 = i18;
                    int i24 = b22;
                    workSpec.f12529n = c2.getLong(i24);
                    int i25 = i21;
                    b22 = i24;
                    int i26 = b23;
                    workSpec.f12530o = c2.getLong(i26);
                    int i27 = i22;
                    int i28 = b24;
                    workSpec.f12531p = c2.getLong(i28);
                    int i29 = b25;
                    if (c2.getInt(i29) != 0) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    workSpec.f12532q = z6;
                    int i30 = b26;
                    int i31 = i28;
                    workSpec.f12533r = WorkTypeConverters.f(c2.getInt(i30));
                    workSpec.f12525j = constraints;
                    arrayList.add(workSpec);
                    b26 = i30;
                    b3 = i10;
                    b14 = i12;
                    b16 = i14;
                    b17 = i19;
                    b19 = i27;
                    b24 = i31;
                    b10 = i4;
                    b12 = i5;
                    b2 = i6;
                    b25 = i29;
                    b23 = i26;
                    b4 = i8;
                    int i32 = i23;
                    b21 = i25;
                    b5 = i20;
                    b20 = i32;
                }
                c2.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                c2.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = i2;
            c2.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public boolean q() {
        boolean z2 = false;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f12542a.b();
        Cursor c2 = DBUtil.c(this.f12542a, i2, false, (CancellationSignal) null);
        try {
            if (c2.moveToFirst() && c2.getInt(0) != 0) {
                z2 = true;
            }
            return z2;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public int r(String str) {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12548g.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f12542a.c();
        try {
            int j2 = a2.j();
            this.f12542a.t();
            return j2;
        } finally {
            this.f12542a.g();
            this.f12548g.f(a2);
        }
    }

    public int s(String str) {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12547f.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f12542a.c();
        try {
            int j2 = a2.j();
            this.f12542a.t();
            return j2;
        } finally {
            this.f12542a.g();
            this.f12547f.f(a2);
        }
    }

    public void t(String str, long j2) {
        this.f12542a.b();
        SupportSQLiteStatement a2 = this.f12546e.a();
        a2.X(1, j2);
        if (str == null) {
            a2.d0(2);
        } else {
            a2.R(2, str);
        }
        this.f12542a.c();
        try {
            a2.j();
            this.f12542a.t();
        } finally {
            this.f12542a.g();
            this.f12546e.f(a2);
        }
    }
}
