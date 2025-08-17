package com.adcolony.sdk;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.adcolony.sdk.e0;
import com.adcolony.sdk.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

class n {

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f13260a;

    /* renamed from: b  reason: collision with root package name */
    private final n0 f13261b;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f13262a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13263b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13264c;

        private a(String[] strArr) {
            this.f13262a = strArr[1];
            this.f13263b = strArr[2];
            this.f13264c = strArr[4];
        }

        static a a(String[] strArr) {
            if (strArr.length >= 5) {
                return new a(strArr);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f13262a;
        }

        /* access modifiers changed from: package-private */
        public boolean c(n0.b bVar) {
            if (!Objects.equals(this.f13262a, bVar.b()) || !Objects.equals(this.f13263b, bVar.c()) || !Objects.equals(this.f13264c, bVar.a())) {
                return false;
            }
            return true;
        }
    }

    n(SQLiteDatabase sQLiteDatabase, n0 n0Var) {
        this.f13260a = sQLiteDatabase;
        this.f13261b = n0Var;
    }

    private String a(n0.a aVar) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        sb.append(aVar.h());
        sb.append(" (");
        for (int i2 = 0; i2 < aVar.a().size(); i2++) {
            n0.b bVar = aVar.a().get(i2);
            sb.append(bVar.b());
            sb.append(" ");
            sb.append(bVar.c());
            if (bVar.a() != null) {
                if (bVar.a() instanceof Boolean) {
                    if (((Boolean) bVar.a()).booleanValue()) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                } else if (bVar.a() instanceof String) {
                    str = "'" + bVar.a() + "'";
                } else {
                    str = bVar.a().toString();
                }
                sb.append(" DEFAULT ");
                sb.append(str);
            }
            if (i2 < aVar.a().size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private String b(n0.c cVar, String str) {
        String join = TextUtils.join(", ", cVar.a());
        return "CREATE INDEX " + cVar.b() + " ON " + str + "(" + join + ")";
    }

    private void d(n0.a aVar, List<String> list) {
        f(aVar.h(), "manager_tmp_table");
        m(aVar);
        g("manager_tmp_table", aVar.h(), list);
        j("manager_tmp_table");
    }

    private void e(String str) {
        SQLiteDatabase sQLiteDatabase = this.f13260a;
        sQLiteDatabase.execSQL("DROP INDEX " + str);
    }

    private void f(String str, String str2) {
        SQLiteDatabase sQLiteDatabase = this.f13260a;
        sQLiteDatabase.execSQL("ALTER TABLE " + str + " RENAME TO " + str2);
    }

    private void g(String str, String str2, List<String> list) {
        String join = TextUtils.join(", ", list);
        SQLiteDatabase sQLiteDatabase = this.f13260a;
        sQLiteDatabase.execSQL("INSERT INTO " + str2 + " (" + join + ") SELECT " + join + " FROM " + str);
    }

    private void h(n0.a aVar) {
        for (n0.c i2 : aVar.c()) {
            i(i2, aVar.h());
        }
    }

    private void i(n0.c cVar, String str) {
        this.f13260a.execSQL(b(cVar, str));
    }

    private void j(String str) {
        SQLiteDatabase sQLiteDatabase = this.f13260a;
        sQLiteDatabase.execSQL("DROP TABLE " + str);
    }

    private void m(n0.a aVar) {
        this.f13260a.execSQL(a(aVar));
    }

    private void n(n0.c cVar, String str) {
        ArrayList<String[]> l2 = l(cVar.b());
        boolean z2 = true;
        if (cVar.a().length == l2.size()) {
            boolean z3 = false;
            for (int i2 = 0; i2 < cVar.a().length; i2++) {
                if (!Objects.equals(cVar.a()[i2], l2.get(i2)[2])) {
                    z3 = true;
                }
            }
            z2 = z3;
        }
        if (z2) {
            e(cVar.b());
            i(cVar, str);
        }
    }

    private void p(n0.a aVar) {
        List<n0.c> c2 = aVar.c();
        ArrayList<String> o2 = o(aVar.h());
        for (n0.c next : c2) {
            if (o2.contains(next.b())) {
                n(next, aVar.h());
            } else {
                i(next, aVar.h());
            }
            o2.remove(next.b());
        }
        Iterator<String> it2 = o2.iterator();
        while (it2.hasNext()) {
            e(it2.next());
        }
    }

    private void r(n0.a aVar) {
        boolean z2;
        boolean z3;
        ArrayList<a> t2 = t(aVar.h());
        ArrayList arrayList = new ArrayList();
        boolean z4 = false;
        for (n0.b next : aVar.a()) {
            int size = t2.size() - 1;
            while (true) {
                if (size < 0) {
                    z2 = false;
                    z3 = false;
                    break;
                }
                a aVar2 = t2.get(size);
                if (Objects.equals(aVar2.b(), next.b())) {
                    arrayList.add(next.b());
                    z2 = aVar2.c(next);
                    t2.remove(size);
                    z3 = true;
                    break;
                }
                size--;
            }
            if (!z3 || !z2) {
                z4 = true;
            }
        }
        if (t2.size() > 0) {
            z4 = true;
        }
        if (z4) {
            d(aVar, arrayList);
            h(aVar);
            return;
        }
        p(aVar);
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> c() {
        ArrayList<String> s2 = s("table");
        for (int size = s2.size() - 1; size >= 0; size--) {
            String str = s2.get(size);
            if (str.startsWith("android_") || str.startsWith("sqlite_")) {
                s2.remove(size);
            }
        }
        return s2;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        int version = this.f13260a.getVersion();
        this.f13260a.beginTransaction();
        boolean z2 = false;
        try {
            List<n0.a> c2 = this.f13261b.c();
            ArrayList<String> c3 = c();
            for (n0.a next : c2) {
                if (c3.contains(next.h())) {
                    r(next);
                } else {
                    m(next);
                    h(next);
                }
                c3.remove(next.h());
            }
            Iterator<String> it2 = c3.iterator();
            while (it2.hasNext()) {
                j(it2.next());
            }
            this.f13260a.setVersion(this.f13261b.d());
            this.f13260a.setTransactionSuccessful();
            z2 = true;
            new e0.a().c("Success upgrading database from ").a(version).c(" to ").a(this.f13261b.d()).d(e0.f13110e);
        } catch (SQLException e2) {
            new e0.a().c("Upgrading database from ").a(version).c(" to ").a(this.f13261b.d()).c("caused: ").c(e2.toString()).d(e0.f13112g);
        } catch (Throwable th) {
            this.f13260a.endTransaction();
            throw th;
        }
        this.f13260a.endTransaction();
        return z2;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String[]> l(String str) {
        return q("PRAGMA index_info(" + str + ")");
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> o(String str) {
        ArrayList<String[]> q2 = q("PRAGMA index_list(" + str + ")");
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String[]> it2 = q2.iterator();
        while (it2.hasNext()) {
            String[] next = it2.next();
            if (next.length >= 3) {
                arrayList.add(next[1]);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String[]> q(String str) {
        Cursor rawQuery = this.f13260a.rawQuery(str, (String[]) null);
        ArrayList<String[]> arrayList = new ArrayList<>();
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            rawQuery.close();
            return arrayList;
        }
        do {
            int columnCount = rawQuery.getColumnCount();
            String[] strArr = new String[columnCount];
            for (int i2 = 0; i2 < columnCount; i2++) {
                strArr[i2] = rawQuery.getString(i2);
            }
            arrayList.add(strArr);
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<String> s(String str) {
        SQLiteDatabase sQLiteDatabase = this.f13260a;
        Cursor rawQuery = sQLiteDatabase.rawQuery("SELECT name FROM sqlite_master  WHERE type='" + str + "' ORDER BY name", (String[]) null);
        ArrayList<String> arrayList = new ArrayList<>();
        if (rawQuery == null || !rawQuery.moveToFirst()) {
            rawQuery.close();
            return arrayList;
        }
        do {
            arrayList.add(rawQuery.getString(0));
        } while (rawQuery.moveToNext());
        rawQuery.close();
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<a> t(String str) {
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<String[]> it2 = q("PRAGMA table_info(" + str + ")").iterator();
        while (it2.hasNext()) {
            a a2 = a.a(it2.next());
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        return arrayList;
    }
}
