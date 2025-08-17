package com.database.daos;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.UserListEntity;
import d0.c;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class UserListDao_Impl implements UserListDao {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final RoomDatabase f19258a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter f19259b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f19260c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f19261d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedSQLiteStatement f19262e;

    /* renamed from: f  reason: collision with root package name */
    private final SharedSQLiteStatement f19263f;

    public UserListDao_Impl(RoomDatabase roomDatabase) {
        this.f19258a = roomDatabase;
        this.f19259b = new EntityInsertionAdapter<UserListEntity>(roomDatabase) {
            public String d() {
                return "INSERT OR REPLACE INTO `UserListEntity`(`name`,`id`,`owner`,`pivacy`,`enable`) VALUES (?,?,?,?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, UserListEntity userListEntity) {
                String str = userListEntity.f19320b;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                String str2 = userListEntity.f19321c;
                if (str2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, str2);
                }
                String str3 = userListEntity.f19322d;
                if (str3 == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, str3);
                }
                String str4 = userListEntity.f19323e;
                if (str4 == null) {
                    supportSQLiteStatement.d0(4);
                } else {
                    supportSQLiteStatement.R(4, str4);
                }
                supportSQLiteStatement.X(5, userListEntity.f19324f ? 1 : 0);
            }
        };
        this.f19260c = new EntityDeletionOrUpdateAdapter<UserListEntity>(roomDatabase) {
            public String d() {
                return "UPDATE OR REPLACE `UserListEntity` SET `name` = ?,`id` = ?,`owner` = ?,`pivacy` = ?,`enable` = ? WHERE `id` = ?";
            }

            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, UserListEntity userListEntity) {
                String str = userListEntity.f19320b;
                if (str == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, str);
                }
                String str2 = userListEntity.f19321c;
                if (str2 == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, str2);
                }
                String str3 = userListEntity.f19322d;
                if (str3 == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, str3);
                }
                String str4 = userListEntity.f19323e;
                if (str4 == null) {
                    supportSQLiteStatement.d0(4);
                } else {
                    supportSQLiteStatement.R(4, str4);
                }
                supportSQLiteStatement.X(5, userListEntity.f19324f ? 1 : 0);
                String str5 = userListEntity.f19321c;
                if (str5 == null) {
                    supportSQLiteStatement.d0(6);
                } else {
                    supportSQLiteStatement.R(6, str5);
                }
            }
        };
        this.f19261d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM UserListEntity WHERE id = ?";
            }
        };
        this.f19262e = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM UserListEntity";
            }
        };
        this.f19263f = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM UserListEntity WHERE owner = ?";
            }
        };
    }

    /* access modifiers changed from: private */
    public UserListEntity i(Cursor cursor) {
        String str;
        String str2;
        String str3;
        boolean z2;
        int columnIndex = cursor.getColumnIndex("name");
        int columnIndex2 = cursor.getColumnIndex("id");
        int columnIndex3 = cursor.getColumnIndex("owner");
        int columnIndex4 = cursor.getColumnIndex("pivacy");
        int columnIndex5 = cursor.getColumnIndex("enable");
        String str4 = null;
        if (columnIndex == -1) {
            str = null;
        } else {
            str = cursor.getString(columnIndex);
        }
        if (columnIndex2 == -1) {
            str2 = null;
        } else {
            str2 = cursor.getString(columnIndex2);
        }
        if (columnIndex3 == -1) {
            str3 = null;
        } else {
            str3 = cursor.getString(columnIndex3);
        }
        if (columnIndex4 != -1) {
            str4 = cursor.getString(columnIndex4);
        }
        UserListEntity userListEntity = new UserListEntity(str, str2, str3, str4);
        if (columnIndex5 != -1) {
            if (cursor.getInt(columnIndex5) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            userListEntity.f19324f = z2;
        }
        return userListEntity;
    }

    public void a() {
        this.f19258a.b();
        SupportSQLiteStatement a2 = this.f19262e.a();
        this.f19258a.c();
        try {
            a2.j();
            this.f19258a.t();
        } finally {
            this.f19258a.g();
            this.f19262e.f(a2);
        }
    }

    public void b(String str) {
        this.f19258a.b();
        SupportSQLiteStatement a2 = this.f19261d.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f19258a.c();
        try {
            a2.j();
            this.f19258a.t();
        } finally {
            this.f19258a.g();
            this.f19261d.f(a2);
        }
    }

    public void c(String str) {
        this.f19258a.b();
        SupportSQLiteStatement a2 = this.f19263f.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        this.f19258a.c();
        try {
            a2.j();
            this.f19258a.t();
        } finally {
            this.f19258a.g();
            this.f19263f.f(a2);
        }
    }

    public void d(UserListEntity... userListEntityArr) {
        this.f19258a.b();
        this.f19258a.c();
        try {
            this.f19260c.h(userListEntityArr);
            this.f19258a.t();
        } finally {
            this.f19258a.g();
        }
    }

    public void e(UserListEntity... userListEntityArr) {
        this.f19258a.b();
        this.f19258a.c();
        try {
            this.f19259b.i(userListEntityArr);
            this.f19258a.t();
        } finally {
            this.f19258a.g();
        }
    }

    public /* synthetic */ void f(UserListEntity... userListEntityArr) {
        c.a(this, userListEntityArr);
    }

    public Flowable<List<UserListEntity>> g() {
        final RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM UserListEntity WHERE enable=1", 0);
        return RxRoom.a(this.f19258a, false, new String[]{"UserListEntity"}, new Callable<List<UserListEntity>>() {
            /* renamed from: b */
            public List<UserListEntity> call() throws Exception {
                Cursor b2 = DBUtil.b(UserListDao_Impl.this.f19258a, i2, false);
                try {
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        arrayList.add(UserListDao_Impl.this.i(b2));
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }

            /* access modifiers changed from: protected */
            public void finalize() {
                i2.release();
            }
        });
    }

    public UserListEntity get(String str) {
        UserListEntity userListEntity;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM USERLISTENTITY WHERE id=?", 1);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        this.f19258a.b();
        Cursor b2 = DBUtil.b(this.f19258a, i2, false);
        try {
            if (b2.moveToFirst()) {
                userListEntity = i(b2);
            } else {
                userListEntity = null;
            }
            return userListEntity;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public List<UserListEntity> h() {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM UserListEntity", 0);
        this.f19258a.b();
        Cursor b2 = DBUtil.b(this.f19258a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(i(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }
}
