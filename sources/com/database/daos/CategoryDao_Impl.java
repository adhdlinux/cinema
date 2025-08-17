package com.database.daos;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.database.entitys.CategoryEntity;
import java.util.ArrayList;
import java.util.List;

public final class CategoryDao_Impl implements CategoryDao {

    /* renamed from: a  reason: collision with root package name */
    private final RoomDatabase f19212a;

    /* renamed from: b  reason: collision with root package name */
    private final EntityInsertionAdapter f19213b;

    /* renamed from: c  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f19214c;

    /* renamed from: d  reason: collision with root package name */
    private final EntityDeletionOrUpdateAdapter f19215d;

    public CategoryDao_Impl(RoomDatabase roomDatabase) {
        this.f19212a = roomDatabase;
        this.f19213b = new EntityInsertionAdapter<CategoryEntity>(roomDatabase) {
            public String d() {
                return "INSERT OR IGNORE INTO `CategoryEntity`(`category_source`,`category_type`,`category_id`,`category_source_type`,`category_name`,`category_restricted`) VALUES (?,?,?,?,?,?)";
            }

            /* renamed from: j */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CategoryEntity categoryEntity) {
                Integer num;
                supportSQLiteStatement.X(1, (long) CategoryEntity.SourceConverter.a(categoryEntity.getSource()));
                supportSQLiteStatement.X(2, (long) CategoryEntity.TypeEntityConverter.a(categoryEntity.getType()));
                if (categoryEntity.getId() == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.X(3, (long) categoryEntity.getId().intValue());
                }
                supportSQLiteStatement.X(4, (long) CategoryEntity.SourceTypeConverter.a(categoryEntity.getSourceType()));
                if (categoryEntity.getName() == null) {
                    supportSQLiteStatement.d0(5);
                } else {
                    supportSQLiteStatement.R(5, categoryEntity.getName());
                }
                if (categoryEntity.getRestricted() == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(categoryEntity.getRestricted().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    supportSQLiteStatement.d0(6);
                } else {
                    supportSQLiteStatement.X(6, (long) num.intValue());
                }
            }
        };
        this.f19214c = new EntityDeletionOrUpdateAdapter<CategoryEntity>(roomDatabase) {
            public String d() {
                return "DELETE FROM `CategoryEntity` WHERE `category_source` = ? AND `category_type` = ? AND `category_id` = ? AND `category_source_type` = ?";
            }

            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CategoryEntity categoryEntity) {
                supportSQLiteStatement.X(1, (long) CategoryEntity.SourceConverter.a(categoryEntity.getSource()));
                supportSQLiteStatement.X(2, (long) CategoryEntity.TypeEntityConverter.a(categoryEntity.getType()));
                if (categoryEntity.getId() == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.X(3, (long) categoryEntity.getId().intValue());
                }
                supportSQLiteStatement.X(4, (long) CategoryEntity.SourceTypeConverter.a(categoryEntity.getSourceType()));
            }
        };
        this.f19215d = new EntityDeletionOrUpdateAdapter<CategoryEntity>(roomDatabase) {
            public String d() {
                return "UPDATE OR IGNORE `CategoryEntity` SET `category_source` = ?,`category_type` = ?,`category_id` = ?,`category_source_type` = ?,`category_name` = ?,`category_restricted` = ? WHERE `category_source` = ? AND `category_type` = ? AND `category_id` = ? AND `category_source_type` = ?";
            }

            /* renamed from: i */
            public void g(SupportSQLiteStatement supportSQLiteStatement, CategoryEntity categoryEntity) {
                Integer num;
                supportSQLiteStatement.X(1, (long) CategoryEntity.SourceConverter.a(categoryEntity.getSource()));
                supportSQLiteStatement.X(2, (long) CategoryEntity.TypeEntityConverter.a(categoryEntity.getType()));
                if (categoryEntity.getId() == null) {
                    supportSQLiteStatement.d0(3);
                } else {
                    supportSQLiteStatement.X(3, (long) categoryEntity.getId().intValue());
                }
                supportSQLiteStatement.X(4, (long) CategoryEntity.SourceTypeConverter.a(categoryEntity.getSourceType()));
                if (categoryEntity.getName() == null) {
                    supportSQLiteStatement.d0(5);
                } else {
                    supportSQLiteStatement.R(5, categoryEntity.getName());
                }
                if (categoryEntity.getRestricted() == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(categoryEntity.getRestricted().booleanValue() ? 1 : 0);
                }
                if (num == null) {
                    supportSQLiteStatement.d0(6);
                } else {
                    supportSQLiteStatement.X(6, (long) num.intValue());
                }
                supportSQLiteStatement.X(7, (long) CategoryEntity.SourceConverter.a(categoryEntity.getSource()));
                supportSQLiteStatement.X(8, (long) CategoryEntity.TypeEntityConverter.a(categoryEntity.getType()));
                if (categoryEntity.getId() == null) {
                    supportSQLiteStatement.d0(9);
                } else {
                    supportSQLiteStatement.X(9, (long) categoryEntity.getId().intValue());
                }
                supportSQLiteStatement.X(10, (long) CategoryEntity.SourceTypeConverter.a(categoryEntity.getSourceType()));
            }
        };
    }

    private CategoryEntity e(Cursor cursor) {
        CategoryEntity.Source source;
        CategoryEntity.Type type;
        Integer num;
        CategoryEntity.SourceType sourceType;
        String str;
        Integer num2;
        boolean z2;
        int columnIndex = cursor.getColumnIndex("category_source");
        int columnIndex2 = cursor.getColumnIndex("category_type");
        int columnIndex3 = cursor.getColumnIndex("category_id");
        int columnIndex4 = cursor.getColumnIndex("category_source_type");
        int columnIndex5 = cursor.getColumnIndex("category_name");
        int columnIndex6 = cursor.getColumnIndex("category_restricted");
        Boolean bool = null;
        if (columnIndex == -1) {
            source = null;
        } else {
            source = CategoryEntity.SourceConverter.b(cursor.getInt(columnIndex));
        }
        if (columnIndex2 == -1) {
            type = null;
        } else {
            type = CategoryEntity.TypeEntityConverter.b(cursor.getInt(columnIndex2));
        }
        if (columnIndex3 != -1 && !cursor.isNull(columnIndex3)) {
            num = Integer.valueOf(cursor.getInt(columnIndex3));
        } else {
            num = null;
        }
        if (columnIndex4 == -1) {
            sourceType = null;
        } else {
            sourceType = CategoryEntity.SourceTypeConverter.b(cursor.getInt(columnIndex4));
        }
        if (columnIndex5 == -1) {
            str = null;
        } else {
            str = cursor.getString(columnIndex5);
        }
        CategoryEntity categoryEntity = new CategoryEntity(source, type, num, sourceType, str);
        if (columnIndex6 != -1) {
            if (cursor.isNull(columnIndex6)) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(cursor.getInt(columnIndex6));
            }
            if (num2 != null) {
                if (num2.intValue() != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                bool = Boolean.valueOf(z2);
            }
            categoryEntity.setRestricted(bool);
        }
        return categoryEntity;
    }

    public void a(CategoryEntity... categoryEntityArr) {
        this.f19212a.b();
        this.f19212a.c();
        try {
            this.f19213b.i(categoryEntityArr);
            this.f19212a.t();
        } finally {
            this.f19212a.g();
        }
    }

    public void b(CategoryEntity... categoryEntityArr) {
        this.f19212a.b();
        this.f19212a.c();
        try {
            this.f19215d.h(categoryEntityArr);
            this.f19212a.t();
        } finally {
            this.f19212a.g();
        }
    }

    public List<CategoryEntity> c(int i2, int i3) {
        RoomSQLiteQuery i4 = RoomSQLiteQuery.i("SELECT * FROM CategoryEntity WHERE category_source=? AND category_type=?", 2);
        i4.X(1, (long) i2);
        i4.X(2, (long) i3);
        this.f19212a.b();
        Cursor b2 = DBUtil.b(this.f19212a, i4, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(e(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i4.release();
        }
    }

    public List<CategoryEntity> d(int i2) {
        RoomSQLiteQuery i3 = RoomSQLiteQuery.i("SELECT * FROM CategoryEntity WHERE category_type=?", 1);
        i3.X(1, (long) i2);
        this.f19212a.b();
        Cursor b2 = DBUtil.b(this.f19212a, i3, false);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(e(b2));
            }
            return arrayList;
        } finally {
            b2.close();
            i3.release();
        }
    }
}
