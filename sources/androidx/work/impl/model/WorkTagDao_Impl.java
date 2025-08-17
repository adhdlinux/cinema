package androidx.work.impl.model;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class WorkTagDao_Impl implements WorkTagDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12563a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkTag> f12564b;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.f12563a = roomDatabase;
        this.f12564b = new EntityInsertionAdapter<WorkTag>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkTag workTag) {
                String str = workTag.f12561a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                String str2 = workTag.f12562b;
                if (str2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, str2);
                }
            }
        };
    }

    public List<String> a(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12563a.b();
        Cursor c2 = DBUtil.c(this.f12563a, i2, false, (CancellationSignal) null);
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

    public void b(WorkTag workTag) {
        this.f12563a.b();
        this.f12563a.c();
        try {
            this.f12564b.h(workTag);
            this.f12563a.t();
        } finally {
            this.f12563a.g();
        }
    }
}
