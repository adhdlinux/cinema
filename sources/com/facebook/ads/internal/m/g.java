package com.facebook.ads.internal.m;

import android.content.Context;
import android.database.Cursor;
import com.facebook.ads.internal.e.c;
import com.facebook.ads.internal.e.d;
import com.facebook.ads.internal.f.e;
import com.facebook.ads.internal.l.a;
import com.facebook.ads.internal.m.b;
import com.facebook.ads.internal.q.a.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20304a = "g";

    /* renamed from: b  reason: collision with root package name */
    private Context f20305b;

    /* renamed from: c  reason: collision with root package name */
    private d f20306c;

    public g(Context context, d dVar) {
        this.f20305b = context;
        this.f20306c = dVar;
    }

    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) {
        int i2 = 0;
        if (jSONArray != null) {
            i2 = 0 + jSONArray.length();
        }
        if (jSONArray2 != null) {
            i2 += jSONArray2.length();
        }
        return a(jSONArray, jSONArray2, i2);
    }

    private static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
        JSONArray jSONArray3 = jSONArray;
        JSONArray jSONArray4 = jSONArray2;
        if (jSONArray3 == null) {
            return jSONArray4;
        }
        if (jSONArray4 == null) {
            return jSONArray3;
        }
        int length = jSONArray.length();
        int length2 = jSONArray2.length();
        JSONArray jSONArray5 = new JSONArray();
        int i3 = i2;
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        int i4 = 0;
        int i5 = 0;
        double d2 = Double.MAX_VALUE;
        double d3 = Double.MAX_VALUE;
        while (true) {
            if ((i4 < length || i5 < length2) && i3 > 0) {
                if (i4 < length && jSONObject == null) {
                    try {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i4);
                        d2 = jSONObject3.getDouble("time");
                        jSONObject = jSONObject3;
                    } catch (JSONException unused) {
                        jSONObject = null;
                        d2 = Double.MAX_VALUE;
                    }
                    i4++;
                }
                if (i5 < length2 && jSONObject2 == null) {
                    try {
                        JSONObject jSONObject4 = jSONArray4.getJSONObject(i5);
                        d3 = jSONObject4.getDouble("time");
                        jSONObject2 = jSONObject4;
                    } catch (JSONException unused2) {
                        jSONObject2 = null;
                        d3 = Double.MAX_VALUE;
                    }
                    i5++;
                }
                if (jSONObject != null || jSONObject2 != null) {
                    if (jSONObject == null || d3 < d2) {
                        jSONArray5.put(jSONObject2);
                        jSONObject2 = null;
                        d3 = Double.MAX_VALUE;
                    } else {
                        jSONArray5.put(jSONObject);
                        jSONObject = null;
                        d2 = Double.MAX_VALUE;
                    }
                    i3--;
                }
            }
        }
        if (i3 > 0) {
            if (jSONObject != null) {
                jSONArray5.put(jSONObject);
            } else if (jSONObject2 != null) {
                jSONArray5.put(jSONObject2);
            }
        }
        return jSONArray5;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: org.json.JSONObject} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(int r8) {
        /*
            r7 = this;
            r0 = 0
            com.facebook.ads.internal.e.d r1 = r7.f20306c     // Catch:{ JSONException -> 0x006d, all -> 0x0060 }
            android.database.Cursor r1 = r1.d()     // Catch:{ JSONException -> 0x006d, all -> 0x0060 }
            com.facebook.ads.internal.e.d r2 = r7.f20306c     // Catch:{ JSONException -> 0x005d, all -> 0x0059 }
            android.database.Cursor r2 = r2.a((int) r8)     // Catch:{ JSONException -> 0x005d, all -> 0x0059 }
            int r3 = r2.getCount()     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            if (r3 <= 0) goto L_0x001c
            org.json.JSONObject r3 = r7.a((android.database.Cursor) r2)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            org.json.JSONArray r4 = r7.c(r2)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            goto L_0x001e
        L_0x001c:
            r3 = r0
            r4 = r3
        L_0x001e:
            android.content.Context r5 = r7.f20305b     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            boolean r5 = com.facebook.ads.internal.l.a.h(r5)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            if (r5 == 0) goto L_0x0038
            android.content.Context r5 = r7.f20305b     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            org.json.JSONArray r5 = com.facebook.ads.internal.f.e.a((android.content.Context) r5, (int) r8)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            if (r5 == 0) goto L_0x0038
            int r6 = r5.length()     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            if (r6 <= 0) goto L_0x0038
            org.json.JSONArray r4 = a(r5, r4, r8)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
        L_0x0038:
            if (r4 == 0) goto L_0x004c
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            r8.<init>()     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            if (r3 == 0) goto L_0x0046
            java.lang.String r5 = "tokens"
            r8.put(r5, r3)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
        L_0x0046:
            java.lang.String r3 = "events"
            r8.put(r3, r4)     // Catch:{ JSONException -> 0x0057, all -> 0x0055 }
            r0 = r8
        L_0x004c:
            if (r1 == 0) goto L_0x0051
            r1.close()
        L_0x0051:
            r2.close()
            return r0
        L_0x0055:
            r8 = move-exception
            goto L_0x005b
        L_0x0057:
            goto L_0x0070
        L_0x0059:
            r8 = move-exception
            r2 = r0
        L_0x005b:
            r0 = r1
            goto L_0x0062
        L_0x005d:
            r2 = r0
            goto L_0x0070
        L_0x0060:
            r8 = move-exception
            r2 = r0
        L_0x0062:
            if (r0 == 0) goto L_0x0067
            r0.close()
        L_0x0067:
            if (r2 == 0) goto L_0x006c
            r2.close()
        L_0x006c:
            throw r8
        L_0x006d:
            r1 = r0
            r2 = r1
        L_0x0070:
            if (r1 == 0) goto L_0x0075
            r1.close()
        L_0x0075:
            if (r2 == 0) goto L_0x007a
            r2.close()
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.a(int):org.json.JSONObject");
    }

    private JSONObject a(Cursor cursor) {
        JSONObject jSONObject = new JSONObject();
        while (cursor.moveToNext()) {
            jSONObject.put(cursor.getString(0), cursor.getString(1));
        }
        return jSONObject;
    }

    private void a(String str) {
        if (e.c(str)) {
            e.a(str);
        } else {
            this.f20306c.a(str);
        }
    }

    private JSONArray b(Cursor cursor) {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", cursor.getString(c.f20091a.f20088a));
            jSONObject2.put("token_id", cursor.getString(c.f20092b.f20088a));
            jSONObject2.put("type", cursor.getString(c.f20094d.f20088a));
            jSONObject2.put("time", t.a(cursor.getDouble(c.f20095e.f20088a)));
            jSONObject2.put("session_time", t.a(cursor.getDouble(c.f20096f.f20088a)));
            jSONObject2.put("session_id", cursor.getString(c.f20097g.f20088a));
            String string = cursor.getString(c.f20098h.f20088a);
            if (string == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put("data", jSONObject);
            jSONObject2.put("attempt", cursor.getString(c.f20099i.f20088a));
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    private JSONArray c(Cursor cursor) {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        cursor.moveToPosition(-1);
        while (cursor.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", cursor.getString(2));
            jSONObject2.put("token_id", cursor.getString(0));
            jSONObject2.put("type", cursor.getString(4));
            jSONObject2.put("time", t.a(cursor.getDouble(5)));
            jSONObject2.put("session_time", t.a(cursor.getDouble(6)));
            jSONObject2.put("session_id", cursor.getString(7));
            String string = cursor.getString(8);
            if (string == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put("data", jSONObject);
            jSONObject2.put("attempt", cursor.getString(9));
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject d() {
        /*
            r8 = this;
            r0 = 0
            com.facebook.ads.internal.e.d r1 = r8.f20306c     // Catch:{ JSONException -> 0x0076, all -> 0x0067 }
            android.database.Cursor r1 = r1.f()     // Catch:{ JSONException -> 0x0076, all -> 0x0067 }
            com.facebook.ads.internal.e.d r2 = r8.f20306c     // Catch:{ JSONException -> 0x0064, all -> 0x005f }
            android.database.Cursor r2 = r2.e()     // Catch:{ JSONException -> 0x0064, all -> 0x005f }
            int r3 = r1.getCount()     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            if (r3 <= 0) goto L_0x0022
            int r3 = r2.getCount()     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            if (r3 <= 0) goto L_0x0022
            org.json.JSONObject r3 = r8.a((android.database.Cursor) r1)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            org.json.JSONArray r4 = r8.b((android.database.Cursor) r2)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            goto L_0x0024
        L_0x0022:
            r3 = r0
            r4 = r3
        L_0x0024:
            android.content.Context r5 = r8.f20305b     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            boolean r5 = com.facebook.ads.internal.l.a.h(r5)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            if (r5 == 0) goto L_0x003e
            android.content.Context r5 = r8.f20305b     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            org.json.JSONArray r5 = com.facebook.ads.internal.f.e.a((android.content.Context) r5)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            if (r5 == 0) goto L_0x003e
            int r6 = r5.length()     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            if (r6 <= 0) goto L_0x003e
            org.json.JSONArray r4 = a(r5, r4)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
        L_0x003e:
            if (r4 == 0) goto L_0x0052
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            r5.<init>()     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            if (r3 == 0) goto L_0x004c
            java.lang.String r6 = "tokens"
            r5.put(r6, r3)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
        L_0x004c:
            java.lang.String r3 = "events"
            r5.put(r3, r4)     // Catch:{ JSONException -> 0x005d, all -> 0x005b }
            r0 = r5
        L_0x0052:
            r1.close()
            if (r2 == 0) goto L_0x005a
            r2.close()
        L_0x005a:
            return r0
        L_0x005b:
            r0 = move-exception
            goto L_0x006b
        L_0x005d:
            goto L_0x0079
        L_0x005f:
            r2 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x006b
        L_0x0064:
            r2 = r0
            goto L_0x0079
        L_0x0067:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x006b:
            if (r1 == 0) goto L_0x0070
            r1.close()
        L_0x0070:
            if (r2 == 0) goto L_0x0075
            r2.close()
        L_0x0075:
            throw r0
        L_0x0076:
            r1 = r0
            r2 = r1
        L_0x0079:
            if (r1 == 0) goto L_0x007e
            r1.close()
        L_0x007e:
            if (r2 == 0) goto L_0x0083
            r2.close()
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.m.g.d():org.json.JSONObject");
    }

    public JSONObject a() {
        int n2 = a.n(this.f20305b);
        return n2 > 0 ? a(n2) : d();
    }

    public boolean a(JSONArray jSONArray) {
        boolean h2 = a.h(this.f20305b);
        boolean z2 = true;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("id");
                int i3 = jSONObject.getInt("code");
                if (i3 == 1) {
                    if (!this.f20306c.b(string)) {
                        if (!h2) {
                        }
                    }
                } else if (i3 < 1000 || i3 >= 2000) {
                    if (i3 >= 2000) {
                        if (i3 < 3000) {
                            if (!this.f20306c.b(string)) {
                                if (!h2) {
                                }
                            }
                        }
                    }
                } else {
                    a(string);
                    z2 = false;
                }
                e.b(string);
            } catch (JSONException unused) {
            }
        }
        return z2;
    }

    public void b() {
        this.f20306c.g();
        this.f20306c.b();
        e.c(this.f20305b);
    }

    public void b(JSONArray jSONArray) {
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            try {
                a(jSONArray.getJSONObject(i2).getString("id"));
            } catch (JSONException unused) {
            }
        }
    }

    public boolean c() {
        int n2 = a.n(this.f20305b);
        boolean z2 = false;
        if (n2 < 1) {
            return false;
        }
        Cursor cursor = null;
        try {
            Cursor d2 = this.f20306c.d();
            if ((d2.moveToFirst() ? d2.getInt(0) : 0) + e.b(this.f20305b) > n2) {
                z2 = true;
            }
            d2.close();
            return z2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }
}
