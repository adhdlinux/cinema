package com.startapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Pair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONTokener;

public class b9 extends pa {

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f34247c = {"rowid", "timestamp", "sdkVersion", "category", "appActivity", AppMeasurementSdk.ConditionalUserProperty.VALUE, "details", "detailsJson", "dParam", "service", "tag"};

    /* renamed from: d  reason: collision with root package name */
    public final List<ua<Void>> f34248d = new LinkedList();

    public b9(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final boolean a(y8 y8Var, c9 c9Var, SQLiteDatabase sQLiteDatabase, Map<String, String> map, long j2) {
        y8 y8Var2 = y8Var;
        c9 c9Var2 = c9Var;
        Map<String, String> map2 = map;
        if (c9Var2.f34289a.size() > 0 && !c9Var2.f34289a.contains(y8Var2.f36954d)) {
            return false;
        }
        if (c9Var2.f34290b.size() > 0 && c9Var2.f34290b.contains(y8Var2.f36954d)) {
            return false;
        }
        if (c9Var2.f34291c.size() > 0 && !c9Var2.f34291c.contains(y8Var2.f36959i)) {
            return false;
        }
        if (c9Var2.f34292d.size() > 0 && c9Var2.f34292d.contains(y8Var2.f36959i)) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (map2.containsKey("sdkVersion")) {
            linkedHashMap.put("sdkVersion", map2.get("sdkVersion"));
        }
        if (map2.containsKey("category")) {
            linkedHashMap.put("category", map2.get("category"));
        }
        for (String next : c9Var2.f34293e) {
            if (map2.containsKey(next)) {
                linkedHashMap.put(next, map2.get(next));
            }
        }
        int size = linkedHashMap.size();
        if (size >= 1) {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList(size);
            String str = "";
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                sb.append(str);
                sb.append((String) entry.getKey());
                if (entry.getValue() == null) {
                    sb.append(" IS NULL");
                } else {
                    sb.append(" = ?");
                    arrayList.add(entry.getValue());
                }
                str = " AND ";
            }
            Pair pair = new Pair(sb.toString(), arrayList.toArray(new String[0]));
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.query("events", new String[]{"sendSuccess"}, (String) pair.first, (String[]) pair.second, (String) null, (String) null, "sendSuccess DESC");
                if (cursor.moveToFirst()) {
                    long j3 = cursor.getLong(0);
                    if (j3 <= 0) {
                        return true;
                    }
                    long j4 = j2 - j3;
                    long j5 = c9Var2.f34294f;
                    if (j5 > 0 && j4 < j5) {
                        a(cursor);
                        return true;
                    }
                }
                a(cursor);
                return false;
            } finally {
                a(cursor);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final synchronized void b() {
        for (ua<Void> call : this.f34248d) {
            call.call();
        }
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS events ( timestamp INTEGER NOT NULL, validTill INTEGER NOT NULL, sdkVersion TEXT NOT NULL, category TEXT NOT NULL, appActivity TEXT, value TEXT, details TEXT, detailsJson TEXT, dParam TEXT, service INTEGER NOT NULL DEFAULT 0, tag TEXT, priority INTEGER NOT NULL, attempt INTEGER NOT NULL DEFAULT 0, send INTEGER NOT NULL DEFAULT 0, sendFailure INTEGER NOT NULL DEFAULT 0, sendSuccess INTEGER NOT NULL DEFAULT 0, CHECK (attempt >= 0), CHECK (send >= 0), CHECK (sendFailure >= 0), CHECK (sendSuccess >= 0));");
    }

    public static y8 b(Cursor cursor) {
        boolean z2 = false;
        long j2 = cursor.getLong(0);
        long j3 = cursor.getLong(1);
        a(j2, j3);
        String string = cursor.getString(2);
        z8 a2 = z8.a(cursor.getString(3));
        String string2 = cursor.getString(4);
        String string3 = cursor.getString(5);
        String string4 = cursor.getString(6);
        String string5 = cursor.getString(7);
        String string6 = cursor.getString(8);
        if (cursor.getInt(9) == 1) {
            z2 = true;
        }
        String string7 = cursor.getString(10);
        if (string == null || string.trim().length() < 1) {
            throw new IllegalArgumentException();
        } else if (a2 != null) {
            Object obj = null;
            if (string5 != null) {
                try {
                    obj = new JSONTokener(string5).nextValue();
                } catch (JSONException unused) {
                }
            }
            y8 y8Var = new y8(a2, j2);
            y8Var.f36958h = Long.valueOf(j3);
            y8Var.f36953c = string;
            y8Var.f36959i = string2;
            y8Var.f36954d = string3;
            y8Var.f36955e = string4;
            y8Var.f36956f = obj;
            y8Var.f36957g = string6;
            y8Var.f36960j = z2;
            y8Var.f36961k = string7;
            return y8Var;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(sa<y8, Void> saVar, int i2, int i3) {
        String str = "attempt < " + i2 + " AND " + "validTill" + " >= " + System.currentTimeMillis() + " AND " + "sendSuccess" + " = 0  AND " + "send" + " <= " + "sendFailure";
        Cursor cursor = null;
        try {
            cursor = a().query("events", f34247c, str, (String[]) null, (String) null, (String) null, "priority DESC, timestamp ASC", String.valueOf(Math.max(1, i3)));
            while (cursor.moveToNext()) {
                saVar.a(b(cursor));
            }
        } finally {
            a(cursor);
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: type inference failed for: r14v1, types: [java.lang.String[], java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r14v4 */
    public boolean a(y8 y8Var, a9 a9Var) {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        ? r14;
        String str7;
        String str8;
        y8 y8Var2 = y8Var;
        a9 a9Var2 = a9Var;
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = currentTimeMillis + a9Var2.f34198e;
        Long l2 = y8Var2.f36958h;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            y8Var2.f36958h = Long.valueOf(currentTimeMillis);
            j2 = currentTimeMillis;
        }
        Object obj = y8Var2.f36956f;
        String obj2 = obj != null ? obj.toString() : null;
        String str9 = y8Var2.f36953c;
        if (str9 == null) {
            str9 = "4.10.0";
        }
        String str10 = str9;
        List<c9> list = a9Var2.f34200g;
        int size = list.size();
        String str11 = "service";
        String str12 = "dParam";
        String str13 = "detailsJson";
        long j4 = j3;
        String str14 = "details";
        String str15 = AppMeasurementSdk.ConditionalUserProperty.VALUE;
        long j5 = j2;
        String str16 = "events";
        String str17 = "sdkVersion";
        if (size > 0) {
            HashMap hashMap = new HashMap();
            hashMap.put(str17, str10);
            String str18 = str10;
            hashMap.put("category", y8Var2.f36951a.f37008o);
            hashMap.put("appActivity", y8Var2.f36959i);
            hashMap.put(str15, y8Var2.f36954d);
            hashMap.put(str14, y8Var2.f36955e);
            hashMap.put(str13, obj2);
            hashMap.put(str12, y8Var2.f36957g);
            try {
                hashMap.put(str11, y8Var2.f36960j ? "1" : "0");
                for (c9 a3 : list) {
                    HashMap hashMap2 = hashMap;
                    String str19 = str12;
                    String str20 = str11;
                    String str21 = str13;
                    String str22 = str18;
                    String str23 = obj2;
                    String str24 = str14;
                    String str25 = str15;
                    String str26 = str17;
                    if (a(y8Var, a3, a2, hashMap2, currentTimeMillis)) {
                        a2.endTransaction();
                        return false;
                    }
                    str17 = str26;
                    str14 = str24;
                    str15 = str25;
                    hashMap = hashMap2;
                    str12 = str19;
                    str11 = str20;
                    obj2 = str23;
                    str18 = str22;
                    str13 = str21;
                }
                str4 = str12;
                str2 = str11;
                str = obj2;
                str3 = str13;
                str6 = str14;
                str8 = str18;
                str7 = str17;
                str5 = str15;
                r14 = 0;
            } catch (Throwable th) {
                a2.endTransaction();
                throw th;
            }
        } else {
            str4 = str12;
            str2 = str11;
            str = obj2;
            str3 = str13;
            str6 = str14;
            str5 = str15;
            r14 = 0;
            str8 = str10;
            str7 = str17;
        }
        String str27 = str16;
        a2.delete(str27, "validTill < " + currentTimeMillis, r14);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(j5));
        contentValues.put("validTill", Long.valueOf(j4));
        contentValues.put(str7, str8);
        contentValues.put("category", y8Var2.f36951a.f37008o);
        contentValues.put("appActivity", y8Var2.f36959i);
        contentValues.put(str5, y8Var2.f36954d);
        contentValues.put(str6, y8Var2.f36955e);
        contentValues.put(str3, str);
        contentValues.put(str4, y8Var2.f36957g);
        contentValues.put(str2, Integer.valueOf(y8Var2.f36960j ? 1 : 0));
        contentValues.put("tag", y8Var2.f36961k);
        contentValues.put("priority", Integer.valueOf(a9Var.f34196c));
        a2.insertOrThrow(str27, r14, contentValues);
        a2.setTransactionSuccessful();
        a2.endTransaction();
        b();
        return true;
    }

    public static void a(long j2, long j3) {
        if (j2 <= 0) {
            throw new IllegalArgumentException();
        } else if (j3 <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static int a(SQLiteDatabase sQLiteDatabase, long j2) {
        Cursor cursor = null;
        try {
            String[] strArr = {"attempt"};
            cursor = sQLiteDatabase.query("events", strArr, "rowid = ?", new String[]{String.valueOf(j2)}, (String) null, (String) null, (String) null);
            if (cursor.moveToFirst()) {
                return cursor.getInt(0);
            }
            throw new IllegalStateException();
        } finally {
            a(cursor);
        }
    }

    public static void a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }
}
