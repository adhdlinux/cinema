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

public final class WorkNameDao_Impl implements WorkNameDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12502a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkName> f12503b;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.f12502a = roomDatabase;
        this.f12503b = new EntityInsertionAdapter<WorkName>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkName workName) {
                String str = workName.f12500a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                String str2 = workName.f12501b;
                if (str2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, str2);
                }
            }
        };
    }

    public void a(WorkName workName) {
        this.f12502a.b();
        this.f12502a.c();
        try {
            this.f12503b.h(workName);
            this.f12502a.t();
        } finally {
            this.f12502a.g();
        }
    }

    public List<String> b(String str) {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT name FROM workname WHERE work_spec_id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f12502a.b();
        Cursor c2 = DBUtil.c(this.f12502a, i2, false, (CancellationSignal) null);
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
}
