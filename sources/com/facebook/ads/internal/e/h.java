package com.facebook.ads.internal.e;

import android.database.Cursor;
import android.database.SQLException;
import com.startapp.sdk.adsbase.model.AdPreferences;

public class h extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final b f20140a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f20141b;

    /* renamed from: c  reason: collision with root package name */
    public static final b[] f20142c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f20143d = h.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private static final String f20144e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f20145f;

    /* renamed from: g  reason: collision with root package name */
    private static final String f20146g;

    static {
        b bVar = new b(0, "token_id", "TEXT PRIMARY KEY");
        f20140a = bVar;
        b bVar2 = new b(1, "token", AdPreferences.TYPE_TEXT);
        f20141b = bVar2;
        b[] bVarArr = {bVar, bVar2};
        f20142c = bVarArr;
        f20144e = g.a("tokens", bVarArr);
        f20145f = g.a("tokens", bVarArr, bVar2);
        f20146g = "DELETE FROM tokens WHERE NOT EXISTS (SELECT 1 FROM events WHERE tokens." + bVar.f20089b + " = " + "events" + "." + c.f20092b.f20089b + ")";
    }

    public h(d dVar) {
        super(dVar);
    }

    public String a() {
        return "tokens";
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 != 0) goto L_0x0064
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.f()     // Catch:{ all -> 0x005d }
            java.lang.String r2 = f20145f     // Catch:{ all -> 0x005d }
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ all -> 0x005d }
            r4 = 0
            r3[r4] = r6     // Catch:{ all -> 0x005d }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ all -> 0x005d }
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0026
            com.facebook.ads.internal.e.b r2 = f20140a     // Catch:{ all -> 0x005a }
            int r2 = r2.f20088a     // Catch:{ all -> 0x005a }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ all -> 0x005a }
            goto L_0x0027
        L_0x0026:
            r2 = r0
        L_0x0027:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x005a }
            if (r3 != 0) goto L_0x0031
            r1.close()
            return r2
        L_0x0031:
            java.util.UUID r2 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x005a }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005a }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ all -> 0x005a }
            r4 = 2
            r3.<init>(r4)     // Catch:{ all -> 0x005a }
            com.facebook.ads.internal.e.b r4 = f20140a     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.f20089b     // Catch:{ all -> 0x005a }
            r3.put(r4, r2)     // Catch:{ all -> 0x005a }
            com.facebook.ads.internal.e.b r4 = f20141b     // Catch:{ all -> 0x005a }
            java.lang.String r4 = r4.f20089b     // Catch:{ all -> 0x005a }
            r3.put(r4, r6)     // Catch:{ all -> 0x005a }
            android.database.sqlite.SQLiteDatabase r6 = r5.f()     // Catch:{ all -> 0x005a }
            java.lang.String r4 = "tokens"
            r6.insertOrThrow(r4, r0, r3)     // Catch:{ all -> 0x005a }
            r1.close()
            return r2
        L_0x005a:
            r6 = move-exception
            r0 = r1
            goto L_0x005e
        L_0x005d:
            r6 = move-exception
        L_0x005e:
            if (r0 == 0) goto L_0x0063
            r0.close()
        L_0x0063:
            throw r6
        L_0x0064:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Invalid token."
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.e.h.a(java.lang.String):java.lang.String");
    }

    public b[] b() {
        return f20142c;
    }

    /* access modifiers changed from: package-private */
    public Cursor c() {
        return f().rawQuery(f20144e, (String[]) null);
    }

    public void d() {
        try {
            f().execSQL(f20146g);
        } catch (SQLException unused) {
        }
    }
}
