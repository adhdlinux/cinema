package com.orm;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import android.util.Log;
import com.orm.dsl.Table;
import com.orm.util.NamingHelper;
import com.orm.util.QueryBuilder;
import com.orm.util.ReflectionUtil;
import com.orm.util.SugarCursor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SugarRecord {
    public static final String SUGAR = "Sugar";
    private Long id = null;

    static class CursorIterator<E> implements Iterator<E> {

        /* renamed from: b  reason: collision with root package name */
        Class<E> f34062b;

        /* renamed from: c  reason: collision with root package name */
        Cursor f34063c;

        public CursorIterator(Class<E> cls, Cursor cursor) {
            this.f34062b = cls;
            this.f34063c = cursor;
        }

        public boolean hasNext() {
            Cursor cursor = this.f34063c;
            return cursor != null && !cursor.isClosed() && !this.f34063c.isAfterLast();
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0043 A[DONT_GENERATE] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public E next() {
            /*
                r5 = this;
                android.database.Cursor r0 = r5.f34063c
                if (r0 == 0) goto L_0x005c
                boolean r0 = r0.isAfterLast()
                if (r0 != 0) goto L_0x005c
                android.database.Cursor r0 = r5.f34063c
                boolean r0 = r0.isBeforeFirst()
                if (r0 == 0) goto L_0x0017
                android.database.Cursor r0 = r5.f34063c
                r0.moveToFirst()
            L_0x0017:
                r0 = 0
                java.lang.Class<E> r1 = r5.f34062b     // Catch:{ Exception -> 0x002f }
                r2 = 0
                java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x002f }
                java.lang.reflect.Constructor r1 = r1.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x002f }
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x002f }
                java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ Exception -> 0x002f }
                com.orm.SugarContext.a()     // Catch:{ Exception -> 0x002b }
                throw r0     // Catch:{ Exception -> 0x002b }
            L_0x002b:
                r0 = move-exception
                goto L_0x0033
            L_0x002d:
                r0 = move-exception
                goto L_0x0049
            L_0x002f:
                r1 = move-exception
                r4 = r1
                r1 = r0
                r0 = r4
            L_0x0033:
                r0.printStackTrace()     // Catch:{ all -> 0x002d }
                android.database.Cursor r0 = r5.f34063c
                r0.moveToNext()
                android.database.Cursor r0 = r5.f34063c
                boolean r0 = r0.isAfterLast()
                if (r0 == 0) goto L_0x0048
                android.database.Cursor r0 = r5.f34063c
                r0.close()
            L_0x0048:
                return r1
            L_0x0049:
                android.database.Cursor r1 = r5.f34063c
                r1.moveToNext()
                android.database.Cursor r1 = r5.f34063c
                boolean r1 = r1.isAfterLast()
                if (r1 == 0) goto L_0x005b
                android.database.Cursor r1 = r5.f34063c
                r1.close()
            L_0x005b:
                throw r0
            L_0x005c:
                java.util.NoSuchElementException r0 = new java.util.NoSuchElementException
                r0.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.orm.SugarRecord.CursorIterator.next():java.lang.Object");
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static <T> long count(Class<?> cls) {
        return count(cls, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public static <T> int deleteAll(Class<T> cls) {
        return deleteAll(cls, (String) null, new String[0]);
    }

    public static <T> int deleteInTx(T... tArr) {
        return deleteInTx(Arrays.asList(tArr));
    }

    public static void executeQuery(String str, String... strArr) {
        getSugarDataBase().execSQL(str, strArr);
    }

    public static <T> List<T> find(Class<T> cls, String str, String... strArr) {
        return find(cls, str, strArr, (String) null, (String) null, (String) null);
    }

    public static <T> Iterator<T> findAll(Class<T> cls) {
        return findAsIterator(cls, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public static <T> Iterator<T> findAsIterator(Class<T> cls, String str, String... strArr) {
        return findAsIterator(cls, str, strArr, (String) null, (String) null, (String) null);
    }

    public static <T> T findById(Class<T> cls, Long l2) {
        List<T> find = find(cls, "id=?", new String[]{String.valueOf(l2)}, (String) null, (String) null, "1");
        if (find.isEmpty()) {
            return null;
        }
        return find.get(0);
    }

    public static <T> List<T> findWithQuery(Class<T> cls, String str, String... strArr) {
        return getEntitiesFromCursor(getSugarDataBase().rawQuery(str, strArr), cls);
    }

    public static <T> Iterator<T> findWithQueryAsIterator(Class<T> cls, String str, String... strArr) {
        return new CursorIterator(cls, getSugarDataBase().rawQuery(str, strArr));
    }

    public static <T> T first(Class<T> cls) {
        List<T> findWithQuery = findWithQuery(cls, "SELECT * FROM " + NamingHelper.a(cls) + " ORDER BY ID ASC LIMIT 1", new String[0]);
        if (findWithQuery.isEmpty()) {
            return null;
        }
        return findWithQuery.get(0);
    }

    public static <T> Cursor getCursor(Class<T> cls, String str, String[] strArr, String str2, String str3, String str4) {
        return new SugarCursor(getSugarDataBase().query(NamingHelper.a(cls), (String[]) null, str, strArr, str2, (String) null, str3, str4));
    }

    public static <T> List<T> getEntitiesFromCursor(Cursor cursor, Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        try {
            if (cursor.moveToNext()) {
                cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                SugarContext.a();
                throw null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            cursor.close();
            throw th;
        }
        cursor.close();
        return arrayList;
    }

    private static SQLiteDatabase getSugarDataBase() {
        SugarContext.a();
        throw null;
    }

    /* access modifiers changed from: private */
    public static void inflate(Cursor cursor, Object obj, Map<Object, Long> map) {
        List<Field> b2 = ReflectionUtil.b(obj.getClass());
        if (!map.containsKey(obj)) {
            map.put(obj, Long.valueOf(cursor.getLong(cursor.getColumnIndex("ID"))));
        }
        for (Field next : b2) {
            next.setAccessible(true);
            Class<?> type = next.getType();
            if (isSugarEntity(type)) {
                try {
                    long j2 = cursor.getLong(cursor.getColumnIndex(NamingHelper.b(next)));
                    next.set(obj, j2 > 0 ? findById(type, Long.valueOf(j2)) : null);
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            } else {
                ReflectionUtil.c(cursor, next, obj);
            }
        }
    }

    public static boolean isSugarEntity(Class<?> cls) {
        return cls.isAnnotationPresent(Table.class) || SugarRecord.class.isAssignableFrom(cls);
    }

    public static <T> T last(Class<T> cls) {
        List<T> findWithQuery = findWithQuery(cls, "SELECT * FROM " + NamingHelper.a(cls) + " ORDER BY ID DESC LIMIT 1", new String[0]);
        if (findWithQuery.isEmpty()) {
            return null;
        }
        return findWithQuery.get(0);
    }

    public static <T> List<T> listAll(Class<T> cls) {
        return find(cls, (String) null, (String[]) null, (String) null, (String) null, (String) null);
    }

    public static long save(Object obj) {
        return save(getSugarDataBase(), obj);
    }

    public static <T> void saveInTx(T... tArr) {
        saveInTx(Arrays.asList(tArr));
    }

    public static long update(Object obj) {
        return update(getSugarDataBase(), obj);
    }

    public static <T> void updateInTx(T... tArr) {
        updateInTx(Arrays.asList(tArr));
    }

    public boolean delete() {
        Long id2 = getId();
        Class<?> cls = getClass();
        if (id2 == null || id2.longValue() <= 0) {
            Log.i(SUGAR, "Cannot delete object: " + cls.getSimpleName() + " - object has not been saved");
            return false;
        }
        Log.i(SUGAR, cls.getSimpleName() + " deleted : " + id2);
        if (getSugarDataBase().delete(NamingHelper.a(cls), "Id=?", new String[]{id2.toString()}) == 1) {
            return true;
        }
        return false;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long l2) {
        this.id = l2;
    }

    public static <T> long count(Class<?> cls, String str, String[] strArr) {
        return count(cls, str, strArr, (String) null, (String) null, (String) null);
    }

    public static <T> int deleteAll(Class<T> cls, String str, String... strArr) {
        return getSugarDataBase().delete(NamingHelper.a(cls), str, strArr);
    }

    public static <T> int deleteInTx(Collection<T> collection) {
        SQLiteDatabase sugarDataBase = getSugarDataBase();
        try {
            sugarDataBase.beginTransaction();
            sugarDataBase.setLockingEnabled(false);
            int i2 = 0;
            for (T delete : collection) {
                if (delete(delete)) {
                    i2++;
                }
            }
            sugarDataBase.setTransactionSuccessful();
            sugarDataBase.endTransaction();
            sugarDataBase.setLockingEnabled(true);
            return i2;
        } catch (Exception e2) {
            Log.i(SUGAR, "Error in deleting in transaction " + e2.getMessage());
            sugarDataBase.endTransaction();
            sugarDataBase.setLockingEnabled(true);
            return 0;
        } catch (Throwable th) {
            sugarDataBase.endTransaction();
            sugarDataBase.setLockingEnabled(true);
            throw th;
        }
    }

    public static <T> List<T> find(Class<T> cls, String str, String[] strArr, String str2, String str3, String str4) {
        return getEntitiesFromCursor(getSugarDataBase().query(NamingHelper.a(cls), (String[]) null, str, strArr, str2, (String) null, str3, str4), cls);
    }

    public static <T> Iterator<T> findAsIterator(Class<T> cls, String str, String[] strArr, String str2, String str3, String str4) {
        return new CursorIterator(cls, getSugarDataBase().query(NamingHelper.a(cls), (String[]) null, str, strArr, str2, (String) null, str3, str4));
    }

    public static <T> List<T> listAll(Class<T> cls, String str) {
        return find(cls, (String) null, (String[]) null, (String) null, str, (String) null);
    }

    static long save(SQLiteDatabase sQLiteDatabase, Object obj) {
        SugarContext.a();
        throw null;
    }

    public static <T> void saveInTx(Collection<T> collection) {
        SQLiteDatabase sugarDataBase = getSugarDataBase();
        try {
            sugarDataBase.beginTransaction();
            sugarDataBase.setLockingEnabled(false);
            for (T save : collection) {
                save(save);
            }
            sugarDataBase.setTransactionSuccessful();
        } catch (Exception e2) {
            Log.i(SUGAR, "Error in saving in transaction " + e2.getMessage());
        } catch (Throwable th) {
            sugarDataBase.endTransaction();
            sugarDataBase.setLockingEnabled(true);
            throw th;
        }
        sugarDataBase.endTransaction();
        sugarDataBase.setLockingEnabled(true);
    }

    static long update(SQLiteDatabase sQLiteDatabase, Object obj) {
        SugarContext.a();
        throw null;
    }

    public static <T> void updateInTx(Collection<T> collection) {
        SQLiteDatabase sugarDataBase = getSugarDataBase();
        try {
            sugarDataBase.beginTransaction();
            sugarDataBase.setLockingEnabled(false);
            for (T update : collection) {
                update(update);
            }
            sugarDataBase.setTransactionSuccessful();
        } catch (Exception e2) {
            Log.i(SUGAR, "Error in saving in transaction " + e2.getMessage());
        } catch (Throwable th) {
            sugarDataBase.endTransaction();
            sugarDataBase.setLockingEnabled(true);
            throw th;
        }
        sugarDataBase.endTransaction();
        sugarDataBase.setLockingEnabled(true);
    }

    public static <T> long count(Class<?> cls, String str, String[] strArr, String str2, String str3, String str4) {
        String str5;
        if (!TextUtils.isEmpty(str)) {
            str5 = " where " + str;
        } else {
            str5 = "";
        }
        try {
            SQLiteStatement compileStatement = getSugarDataBase().compileStatement("SELECT count(*) FROM " + NamingHelper.a(cls) + str5);
            if (strArr != null) {
                for (int length = strArr.length; length != 0; length--) {
                    compileStatement.bindString(length, strArr[length - 1]);
                }
            }
            try {
                return compileStatement.simpleQueryForLong();
            } finally {
                compileStatement.close();
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public long save() {
        return save(getSugarDataBase(), this);
    }

    public long update() {
        return update(getSugarDataBase(), this);
    }

    public static <T> T findById(Class<T> cls, Integer num) {
        return findById(cls, Long.valueOf((long) num.intValue()));
    }

    public static <T> List<T> findById(Class<T> cls, String[] strArr) {
        return find(cls, "id IN (" + QueryBuilder.a(strArr.length) + ")", strArr);
    }

    public static boolean delete(Object obj) {
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(Table.class)) {
            try {
                Field declaredField = cls.getDeclaredField("id");
                boolean z2 = true;
                declaredField.setAccessible(true);
                Long l2 = (Long) declaredField.get(obj);
                if (l2 == null || l2.longValue() <= 0) {
                    Log.i(SUGAR, "Cannot delete object: " + obj.getClass().getSimpleName() + " - object has not been saved");
                    return false;
                }
                if (getSugarDataBase().delete(NamingHelper.a(cls), "Id=?", new String[]{l2.toString()}) != 1) {
                    z2 = false;
                }
                Log.i(SUGAR, cls.getSimpleName() + " deleted : " + l2);
                return z2;
            } catch (NoSuchFieldException unused) {
                Log.i(SUGAR, "Cannot delete object: " + obj.getClass().getSimpleName() + " - annotated object has no id");
                return false;
            } catch (IllegalAccessException unused2) {
                Log.i(SUGAR, "Cannot delete object: " + obj.getClass().getSimpleName() + " - can't access id");
                return false;
            }
        } else if (SugarRecord.class.isAssignableFrom(cls)) {
            return ((SugarRecord) obj).delete();
        } else {
            Log.i(SUGAR, "Cannot delete object: " + obj.getClass().getSimpleName() + " - not persisted");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void inflate(Cursor cursor) {
        SugarContext.a();
        throw null;
    }
}
