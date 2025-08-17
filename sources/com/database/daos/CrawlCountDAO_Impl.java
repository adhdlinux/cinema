package com.database.daos;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.CrawlCount;
import java.util.ArrayList;
import java.util.List;

public final class CrawlCountDAO_Impl implements CrawlCountDAO {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f19219a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter f19220b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f19221c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedSQLiteStatement f19222d;

    public CrawlCountDAO_Impl(RoomDatabase roomDatabase) {
        this.f19219a = roomDatabase;
        this.f19220b = new EntityInsertionAdapter<CrawlCount>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `CrawlCount`(`id`,`provider`,`host`,`count`) VALUES (nullif(?, 0),?,?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CrawlCount crawlCount) {
                supportSQLiteStatement.X(1, (long) crawlCount.c());
                if (crawlCount.d() == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, crawlCount.d());
                }
                if (crawlCount.b() == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, crawlCount.b());
                }
                supportSQLiteStatement.X(4, (long) crawlCount.a());
            }
        };
        this.f19221c = new EntityDeletionOrUpdateAdapter<CrawlCount>(roomDatabase) {
            public String d() {
                return "UPDATE OR IGNORE `CrawlCount` SET `id` = ?,`provider` = ?,`host` = ?,`count` = ? WHERE `id` = ?";
            }

            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CrawlCount crawlCount) {
                supportSQLiteStatement.X(1, (long) crawlCount.c());
                if (crawlCount.d() == null) {
                    supportSQLiteStatement.d0(2);
                } else {
                    supportSQLiteStatement.R(2, crawlCount.d());
                }
                if (crawlCount.b() == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.R(3, crawlCount.b());
                }
                supportSQLiteStatement.X(4, (long) crawlCount.a());
                supportSQLiteStatement.X(5, (long) crawlCount.c());
            }
        };
        this.f19222d = new SharedSQLiteStatement(roomDatabase) {
            public String d() {
                return "DELETE FROM CrawlCount";
            }
        };
    }

    private CrawlCount a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("provider");
        int columnIndex3 = cursor.getColumnIndex("host");
        int columnIndex4 = cursor.getColumnIndex("count");
        CrawlCount crawlCount = new CrawlCount();
        if (columnIndex != -1) {
            crawlCount.g(cursor.getInt(columnIndex));
        }
        if (columnIndex2 != -1) {
            crawlCount.h(cursor.getString(columnIndex2));
        }
        if (columnIndex3 != -1) {
            crawlCount.f(cursor.getString(columnIndex3));
        }
        if (columnIndex4 != -1) {
            crawlCount.e(cursor.getInt(columnIndex4));
        }
        return crawlCount;
    }

    public List<CrawlCount> getAll() {
        RoomSQLiteQuery i2 = RoomSQLiteQuery.i("SELECT * FROM CrawlCount", 0);
        this.f19219a.b();
        Cursor b2 = DBUtil.b(this.f19219a, i2, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(a(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i2.release();
        }
    }
}
