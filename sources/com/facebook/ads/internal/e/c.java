package com.facebook.ads.internal.e;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

public class c extends g {

    /* renamed from: a  reason: collision with root package name */
    public static final b f20091a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f20092b;

    /* renamed from: c  reason: collision with root package name */
    public static final b f20093c;

    /* renamed from: d  reason: collision with root package name */
    public static final b f20094d;

    /* renamed from: e  reason: collision with root package name */
    public static final b f20095e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f20096f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f20097g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f20098h;

    /* renamed from: i  reason: collision with root package name */
    public static final b f20099i;

    /* renamed from: j  reason: collision with root package name */
    public static final b[] f20100j;

    /* renamed from: l  reason: collision with root package name */
    private static final String f20101l;

    static {
        b bVar = new b(0, "event_id", "TEXT PRIMARY KEY");
        f20091a = bVar;
        b bVar2 = new b(1, "token_id", "TEXT REFERENCES tokens ON UPDATE CASCADE ON DELETE RESTRICT");
        f20092b = bVar2;
        b bVar3 = new b(2, "priority", "INTEGER");
        f20093c = bVar3;
        b bVar4 = new b(3, "type", AdPreferences.TYPE_TEXT);
        f20094d = bVar4;
        b bVar5 = new b(4, "time", "REAL");
        f20095e = bVar5;
        b bVar6 = new b(5, "session_time", "REAL");
        f20096f = bVar6;
        b bVar7 = new b(6, "session_id", AdPreferences.TYPE_TEXT);
        f20097g = bVar7;
        b bVar8 = new b(7, "data", AdPreferences.TYPE_TEXT);
        f20098h = bVar8;
        b bVar9 = new b(8, "attempt", "INTEGER");
        f20099i = bVar9;
        b[] bVarArr = {bVar, bVar2, bVar3, bVar4, bVar5, bVar6, bVar7, bVar8, bVar9};
        f20100j = bVarArr;
        f20101l = g.a("events", bVarArr);
    }

    public c(d dVar) {
        super(dVar);
    }

    public String a() {
        return "events";
    }

    /* access modifiers changed from: package-private */
    public String a(String str, int i2, String str2, double d2, double d3, String str3, Map<String, String> map) {
        String uuid = UUID.randomUUID().toString();
        ContentValues contentValues = new ContentValues(9);
        contentValues.put(f20091a.f20089b, uuid);
        contentValues.put(f20092b.f20089b, str);
        contentValues.put(f20093c.f20089b, Integer.valueOf(i2));
        contentValues.put(f20094d.f20089b, str2);
        contentValues.put(f20095e.f20089b, Double.valueOf(d2));
        contentValues.put(f20096f.f20089b, Double.valueOf(d3));
        contentValues.put(f20097g.f20089b, str3);
        contentValues.put(f20098h.f20089b, map != null ? new JSONObject(map).toString() : null);
        contentValues.put(f20099i.f20089b, 0);
        f().insertOrThrow("events", (String) null, contentValues);
        return uuid;
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str) {
        SQLiteDatabase f2 = f();
        StringBuilder sb = new StringBuilder();
        sb.append(f20091a.f20089b);
        sb.append(" = ?");
        return f2.delete("events", sb.toString(), new String[]{str}) > 0;
    }

    public b[] b() {
        return f20100j;
    }

    /* access modifiers changed from: package-private */
    public Cursor c() {
        return f().rawQuery("SELECT count(*) FROM events", (String[]) null);
    }

    /* access modifiers changed from: package-private */
    public Cursor d() {
        return f().rawQuery(f20101l, (String[]) null);
    }
}
