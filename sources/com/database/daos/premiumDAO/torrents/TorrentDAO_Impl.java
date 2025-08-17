package com.database.daos.premiumDAO.torrents;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.premiumEntitys.torrents.FileIDConverter;
import com.database.entitys.premiumEntitys.torrents.TorrentEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter;
import e0.b;
import java.util.ArrayList;
import java.util.List;

public final class TorrentDAO_Impl implements TorrentDAO {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f19276a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter f19277b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f19278c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f19279d;

    public TorrentDAO_Impl(RoomDatabase roomDatabase) {
        this.f19276a = roomDatabase;
        this.f19277b = new EntityInsertionAdapter<TorrentEntity>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `TorrentEntity`(`hash`,`id`,`type`,`fileIDs`,`movieEntityID`) VALUES (?,?,?,?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, TorrentEntity torrentEntity) {
                if (torrentEntity.c() == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, torrentEntity.c());
                }
                if (torrentEntity.d() == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, torrentEntity.d());
                }
                String b2 = TorrentTypeConverter.b(torrentEntity.f());
                if (b2 == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, b2);
                }
                String a2 = FileIDConverter.a(torrentEntity.b());
                if (a2 == null) {
                    supportSQLiteStatement.d0(4);
                } else {
                    supportSQLiteStatement.R(4, a2);
                }
                supportSQLiteStatement.X(5, (long) torrentEntity.e());
            }
        };
        this.f19278c = new EntityDeletionOrUpdateAdapter<TorrentEntity>(roomDatabase) {
            public String d() {
                return "UPDATE OR IGNORE `TorrentEntity` SET `hash` = ?,`id` = ?,`type` = ?,`fileIDs` = ?,`movieEntityID` = ? WHERE `hash` = ? AND `type` = ?";
            }

            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, TorrentEntity torrentEntity) {
                if (torrentEntity.c() == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, torrentEntity.c());
                }
                if (torrentEntity.d() == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, torrentEntity.d());
                }
                String b2 = TorrentTypeConverter.b(torrentEntity.f());
                if (b2 == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, b2);
                }
                String a2 = FileIDConverter.a(torrentEntity.b());
                if (a2 == null) {
                    supportSQLiteStatement.d0(4);
                } else {
                    supportSQLiteStatement.R(4, a2);
                }
                supportSQLiteStatement.X(5, (long) torrentEntity.e());
                if (torrentEntity.c() == null) {
                    supportSQLiteStatement.d0(6);
                } else {
                    supportSQLiteStatement.R(6, torrentEntity.c());
                }
                String b3 = TorrentTypeConverter.b(torrentEntity.f());
                if (b3 == null) {
                    supportSQLiteStatement.d0(7);
                } else {
                    supportSQLiteStatement.R(7, b3);
                }
            }
        };
        this.f19279d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM TorrentEntity WHERE hash = ? AND id = ?";
            }
        };
    }

    private TorrentEntity g(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("hash");
        int columnIndex2 = cursor.getColumnIndex("id");
        int columnIndex3 = cursor.getColumnIndex("type");
        int columnIndex4 = cursor.getColumnIndex("fileIDs");
        int columnIndex5 = cursor.getColumnIndex("movieEntityID");
        TorrentEntity torrentEntity = new TorrentEntity();
        if (columnIndex != -1) {
            torrentEntity.h(cursor.getString(columnIndex));
        }
        if (columnIndex2 != -1) {
            torrentEntity.i(cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            torrentEntity.k(TorrentTypeConverter.a(cursor.getString(columnIndex3)));
        }
        if (columnIndex4 != -1) {
            torrentEntity.g(FileIDConverter.b(cursor.getString(columnIndex4)));
        }
        if (columnIndex5 != -1) {
            torrentEntity.j(cursor.getInt(columnIndex5));
        }
        return torrentEntity;
    }

    public void a(String str, String str2) {
        this.f19276a.b();
        SupportSQLiteStatement a2 = this.f19279d.a();
        if (str == null) {
            a2.d0(1);
        } else {
            a2.R(1, str);
        }
        if (str2 == null) {
            a2.d0(2);
        } else {
            a2.R(2, str2);
        }
        this.f19276a.c();
        try {
            a2.j();
            this.f19276a.t();
        } finally {
            this.f19276a.g();
            this.f19279d.f(a2);
        }
    }

    public List<TorrentEntity> b(int i2) {
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM TorrentEntity WHERE movieEntityID = ?", 1);
        i3.X(1, (long) i2);
        this.f19276a.b();
        Cursor b2 = DBUtil.b(this.f19276a, i3, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(g(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i3.release();
        }
    }

    public void c(TorrentEntity... torrentEntityArr) {
        this.f19276a.b();
        this.f19276a.c();
        try {
            this.f19278c.h(torrentEntityArr);
            this.f19276a.t();
        } finally {
            this.f19276a.g();
        }
    }

    public TorrentEntity d(String str, String str2, String str3) {
        TorrentEntity torrentEntity;
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM TorrentEntity WHERE (hash = ? OR id = ?) AND type = ?", 3);
        if (str == null) {
            i2.d0(1);
        } else {
            i2.R(1, str);
        }
        if (str2 == null) {
            i2.d0(2);
        } else {
            i2.R(2, str2);
        }
        if (str3 == null) {
            i2.d0(3);
        } else {
            i2.R(3, str3);
        }
        this.f19276a.b();
        Cursor b2 = DBUtil.b(this.f19276a, i2, false);
        try {
            if (b2.moveToFirst()) {
                torrentEntity = g(b2);
            } else {
                torrentEntity = null;
            }
            return torrentEntity;
        } finally {
            b2.close();
            i2.release();
        }
    }

    public /* synthetic */ void e(TorrentEntity... torrentEntityArr) {
        b.a(this, torrentEntityArr);
    }

    public void f(TorrentEntity... torrentEntityArr) {
        this.f19276a.b();
        this.f19276a.c();
        try {
            this.f19277b.i(torrentEntityArr);
            this.f19276a.t();
        } finally {
            this.f19276a.g();
        }
    }
}
