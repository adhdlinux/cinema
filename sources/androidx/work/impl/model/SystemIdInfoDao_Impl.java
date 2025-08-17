package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class SystemIdInfoDao_Impl implements SystemIdInfoDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12495a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<SystemIdInfo> f12496b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f12497c;

    public SystemIdInfoDao_Impl(RoomDatabase roomDatabase) {
        this.f12495a = roomDatabase;
        this.f12496b = new EntityInsertionAdapter<SystemIdInfo>(roomDatabase) {
            public String d() {
                return "INSERT OR REPLACE INTO `SystemIdInfo` (`work_spec_id`,`system_id`) VALUES (?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, SystemIdInfo systemIdInfo) {
                String str = systemIdInfo.f12493a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                supportSQLiteStatement.X(2, (long) systemIdInfo.f12494b);
            }
        };
        this.f12497c = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM SystemIdInfo where work_spec_id=?";
            }
        };
    }

    public SystemIdInfo a(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT `SystemIdInfo`.`work_spec_id` AS `work_spec_id`, `SystemIdInfo`.`system_id` AS `system_id` FROM SystemIdInfo WHERE work_spec_id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12495a.b();
        SystemIdInfo systemIdInfo = null;
        Cursor c2 = DBUtil.c(this.f12495a, i2, false, (CancellationSignal) null);
        try {
            int b2 = CursorUtil.b(c2, "work_spec_id");
            int b3 = CursorUtil.b(c2, "system_id");
            if (c2.moveToFirst()) {
                systemIdInfo = new SystemIdInfo(c2.getString(b2), c2.getInt(b3));
            }
            return systemIdInfo;
        } finally {
            c2.close();
            i2.release();
        }
    }

    public List<String> b() {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT DISTINCT work_spec_id FROM SystemIdInfo", 0);
        this.f12495a.b();
        Cursor c2 = DBUtil.c(this.f12495a, i2, false, (CancellationSignal) null);
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

    public void c(SystemIdInfo systemIdInfo) {
        this.f12495a.b();
        this.f12495a.c();
        try {
            this.f12496b.h(systemIdInfo);
            this.f12495a.t();
        } finally {
            this.f12495a.g();
        }
    }

    public void d(String str) {
        this.f12495a.b();
        SupportSQLiteStatement a2 = this.f12497c.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f12495a.c();
        try {
            a2.j();
            this.f12495a.t();
        } finally {
            this.f12495a.g();
            this.f12497c.f(a2);
        }
    }
}
