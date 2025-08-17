package com.database.daos.premiumDAO.torrents;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.premiumEntitys.torrents.CachedTorrentFileEntity;
import com.database.entitys.premiumEntitys.torrents.TorrentTypeConverter;
import e0.a;
import java.util.ArrayList;
import java.util.List;

public final class CachedTorrentFileDAO_Impl implements CachedTorrentFileDAO {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f19271a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter f19272b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f19273c;

    public CachedTorrentFileDAO_Impl(RoomDatabase roomDatabase) {
        this.f19271a = roomDatabase;
        this.f19272b = new EntityInsertionAdapter<CachedTorrentFileEntity>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `CachedTorrentFileEntity`(`id`,`fullName`,`fileSize`,`movieEntityID`,`season`,`episode`,`type`) VALUES (?,?,?,?,?,?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CachedTorrentFileEntity cachedTorrentFileEntity) {
                if (cachedTorrentFileEntity.e() == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, cachedTorrentFileEntity.e());
                }
                if (cachedTorrentFileEntity.d() == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, cachedTorrentFileEntity.d());
                }
                supportSQLiteStatement.X(3, cachedTorrentFileEntity.c());
                supportSQLiteStatement.X(4, (long) cachedTorrentFileEntity.f());
                supportSQLiteStatement.X(5, (long) cachedTorrentFileEntity.g());
                supportSQLiteStatement.X(6, (long) cachedTorrentFileEntity.b());
                String b2 = TorrentTypeConverter.b(cachedTorrentFileEntity.h());
                if (b2 == null) {
                    supportSQLiteStatement.d0(7);
                } else {
                    supportSQLiteStatement.R(7, b2);
                }
            }
        };
        this.f19273c = new EntityDeletionOrUpdateAdapter<CachedTorrentFileEntity>(roomDatabase) {
            public String d() {
                return "UPDATE OR IGNORE `CachedTorrentFileEntity` SET `id` = ?,`fullName` = ?,`fileSize` = ?,`movieEntityID` = ?,`season` = ?,`episode` = ?,`type` = ? WHERE `id` = ?";
            }

            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CachedTorrentFileEntity cachedTorrentFileEntity) {
                if (cachedTorrentFileEntity.e() == null) {
                    supportSQLiteStatement.d0(1);
                } else {
                    supportSQLiteStatement.R(1, cachedTorrentFileEntity.e());
                }
                if (cachedTorrentFileEntity.d() == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, cachedTorrentFileEntity.d());
                }
                supportSQLiteStatement.X(3, cachedTorrentFileEntity.c());
                supportSQLiteStatement.X(4, (long) cachedTorrentFileEntity.f());
                supportSQLiteStatement.X(5, (long) cachedTorrentFileEntity.g());
                supportSQLiteStatement.X(6, (long) cachedTorrentFileEntity.b());
                String b2 = TorrentTypeConverter.b(cachedTorrentFileEntity.h());
                if (b2 == null) {
                    supportSQLiteStatement.d0(7);
                } else {
                    supportSQLiteStatement.R(7, b2);
                }
                if (cachedTorrentFileEntity.e() == null) {
                    supportSQLiteStatement.d0(8);
                } else {
                    supportSQLiteStatement.R(8, cachedTorrentFileEntity.e());
                }
            }
        };
    }

    private CachedTorrentFileEntity e(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("fullName");
        int columnIndex3 = cursor.getColumnIndex("fileSize");
        int columnIndex4 = cursor.getColumnIndex("movieEntityID");
        int columnIndex5 = cursor.getColumnIndex("season");
        int columnIndex6 = cursor.getColumnIndex("episode");
        int columnIndex7 = cursor.getColumnIndex("type");
        CachedTorrentFileEntity cachedTorrentFileEntity = new CachedTorrentFileEntity();
        if (columnIndex != -1) {
            cachedTorrentFileEntity.l(cursor.getString(columnIndex));
        }
        if (columnIndex2 != -1) {
            cachedTorrentFileEntity.k(cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            cachedTorrentFileEntity.j(cursor.getLong(columnIndex3));
        }
        if (columnIndex4 != -1) {
            cachedTorrentFileEntity.m(cursor.getInt(columnIndex4));
        }
        if (columnIndex5 != -1) {
            cachedTorrentFileEntity.n(cursor.getInt(columnIndex5));
        }
        if (columnIndex6 != -1) {
            cachedTorrentFileEntity.i(cursor.getInt(columnIndex6));
        }
        if (columnIndex7 != -1) {
            cachedTorrentFileEntity.o(TorrentTypeConverter.a(cursor.getString(columnIndex7)));
        }
        return cachedTorrentFileEntity;
    }

    public /* synthetic */ void a(CachedTorrentFileEntity... cachedTorrentFileEntityArr) {
        a.a(this, cachedTorrentFileEntityArr);
    }

    public List<CachedTorrentFileEntity> b(int i2, int i3, int i4) {
        RoomSQLiteQuery i5 = RoomSQLiteQuery.i("SELECT * FROM CachedTorrentFileEntity WHERE movieEntityID= ? AND season = ? AND episode = ?", 3);
        i5.X(1, (long) i2);
        i5.X(2, (long) i3);
        i5.X(3, (long) i4);
        this.f19271a.b();
        Cursor b2 = DBUtil.b(this.f19271a, i5, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(e(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i5.release();
        }
    }

    public void c(CachedTorrentFileEntity... cachedTorrentFileEntityArr) {
        this.f19271a.b();
        this.f19271a.c();
        try {
            this.f19272b.i(cachedTorrentFileEntityArr);
            this.f19271a.t();
        } finally {
            this.f19271a.g();
        }
    }

    public void d(CachedTorrentFileEntity... cachedTorrentFileEntityArr) {
        this.f19271a.b();
        this.f19271a.c();
        try {
            this.f19273c.h(cachedTorrentFileEntityArr);
            this.f19271a.t();
        } finally {
            this.f19271a.g();
        }
    }
}
