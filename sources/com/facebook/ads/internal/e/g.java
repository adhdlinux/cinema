package com.facebook.ads.internal.e;

import android.database.sqlite.SQLiteDatabase;

public abstract class g {

    /* renamed from: k  reason: collision with root package name */
    protected final d f20139k;

    protected g(d dVar) {
        this.f20139k = dVar;
    }

    public static String a(String str, b[] bVarArr) {
        StringBuilder sb = new StringBuilder("SELECT ");
        for (int i2 = 0; i2 < bVarArr.length - 1; i2++) {
            sb.append(bVarArr[i2].f20089b);
            sb.append(", ");
        }
        sb.append(bVarArr[bVarArr.length - 1].f20089b);
        sb.append(" FROM ");
        sb.append(str);
        return sb.toString();
    }

    public static String a(String str, b[] bVarArr, b bVar) {
        return a(str, bVarArr) + " WHERE " + bVar.f20089b + " = ?";
    }

    private String c() {
        b[] b2 = b();
        if (b2.length < 1) {
            return null;
        }
        String str = "";
        for (int i2 = 0; i2 < b2.length - 1; i2++) {
            str = str + b2[i2].a() + ", ";
        }
        return str + b2[b2.length - 1].a();
    }

    public abstract String a();

    public void a(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE " + a() + " (" + c() + ")");
    }

    public void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + a());
    }

    public abstract b[] b();

    public void e() {
    }

    /* access modifiers changed from: protected */
    public SQLiteDatabase f() {
        return this.f20139k.a();
    }
}
