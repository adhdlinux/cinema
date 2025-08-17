package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.work.Data;

public final class WorkProgressDao_Impl implements WorkProgressDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f12507a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter<WorkProgress> f12508b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedSQLiteStatement f12509c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f12510d;

    public WorkProgressDao_Impl(RoomDatabase roomDatabase) {
        this.f12507a = roomDatabase;
        this.f12508b = new EntityInsertionAdapter<WorkProgress>(roomDatabase) {
            public String d() {
                return "INSERT OR REPLACE INTO `WorkProgress` (`work_spec_id`,`progress`) VALUES (?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, WorkProgress workProgress) {
                String str = workProgress.f12505a;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                byte[] m2 = Data.m(workProgress.f12506b);
                if (m2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.Y(2, m2);
                }
            }
        };
        this.f12509c = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE from WorkProgress where work_spec_id=?";
            }
        };
        this.f12510d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM WorkProgress";
            }
        };
    }

    public void a() {
        this.f12507a.b();
        SupportSQLiteStatement a2 = this.f12510d.a();
        this.f12507a.c();
        try {
            a2.j();
            this.f12507a.t();
        } finally {
            this.f12507a.g();
            this.f12510d.f(a2);
        }
    }

    public void b(WorkProgress workProgress) {
        this.f12507a.b();
        this.f12507a.c();
        try {
            this.f12508b.h(workProgress);
            this.f12507a.t();
        } finally {
            this.f12507a.g();
        }
    }

    public void delete(String str) {
        this.f12507a.b();
        SupportSQLiteStatement a2 = this.f12509c.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f12507a.c();
        try {
            a2.j();
            this.f12507a.t();
        } finally {
            this.f12507a.g();
            this.f12509c.f(a2);
        }
    }
}
