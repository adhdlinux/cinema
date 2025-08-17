package com.facebook.ads.internal.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.facebook.ads.internal.q.a.n;
import com.facebook.ads.internal.q.a.q;
import com.facebook.ads.internal.q.a.t;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f20157a = "com.facebook.ads.internal.f.e";

    /* renamed from: b  reason: collision with root package name */
    private static final Object f20158b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static final Set<String> f20159c = Collections.synchronizedSet(new HashSet());

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, Integer> f20160d = Collections.synchronizedMap(new HashMap());

    public static d a(Exception exc, Context context, Map<String, String> map) {
        d dVar = null;
        try {
            d dVar2 = new d(n.b(), n.c(), new b(q.a((Throwable) exc), map, true).a());
            try {
                a(dVar2, context);
                return dVar2;
            } catch (Exception unused) {
                dVar = dVar2;
            }
        } catch (Exception unused2) {
            return dVar;
        }
    }

    public static JSONArray a(Context context) {
        return a(context, -1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v23, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v24, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v26, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v30, resolved type: java.lang.Throwable} */
    /* JADX WARNING: type inference failed for: r10v25 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bc A[SYNTHETIC, Splitter:B:57:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c4 A[Catch:{ IOException -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c9 A[Catch:{ IOException -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00d7 A[SYNTHETIC, Splitter:B:71:0x00d7] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e1 A[Catch:{ IOException -> 0x00dd }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00e6 A[Catch:{ IOException -> 0x00dd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray a(android.content.Context r9, int r10) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.Object r1 = f20158b
            monitor-enter(r1)
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x00b0, JSONException -> 0x00ae, all -> 0x00aa }
            java.io.File r4 = r9.getFilesDir()     // Catch:{ IOException -> 0x00b0, JSONException -> 0x00ae, all -> 0x00aa }
            java.lang.String r5 = "debuglogs"
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x00b0, JSONException -> 0x00ae, all -> 0x00aa }
            boolean r3 = r3.exists()     // Catch:{ IOException -> 0x00b0, JSONException -> 0x00ae, all -> 0x00aa }
            if (r3 == 0) goto L_0x008d
            java.lang.String r3 = "debuglogs"
            java.io.FileInputStream r9 = r9.openFileInput(r3)     // Catch:{ IOException -> 0x00b0, JSONException -> 0x00ae, all -> 0x00aa }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x008a, JSONException -> 0x0088, all -> 0x0085 }
            r3.<init>(r9)     // Catch:{ IOException -> 0x008a, JSONException -> 0x0088, all -> 0x0085 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0083, JSONException -> 0x0081 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0083, JSONException -> 0x0081 }
        L_0x002a:
            java.lang.String r2 = r4.readLine()     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            if (r2 == 0) goto L_0x0076
            if (r10 == 0) goto L_0x0076
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            java.lang.String r2 = "attempt"
            boolean r2 = r5.has(r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            if (r2 != 0) goto L_0x0045
            java.lang.String r2 = "attempt"
            r6 = 0
            r5.put(r2, r6)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
        L_0x0045:
            java.lang.String r2 = "id"
            java.lang.String r2 = r5.getString(r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            java.util.Set<java.lang.String> r6 = f20159c     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            boolean r6 = r6.contains(r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            if (r6 != 0) goto L_0x002a
            java.lang.String r6 = "attempt"
            int r6 = r5.getInt(r6)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            java.util.Map<java.lang.String, java.lang.Integer> r7 = f20160d     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            boolean r8 = r7.containsKey(r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            if (r8 == 0) goto L_0x006b
            java.lang.String r6 = "attempt"
            java.lang.Object r2 = r7.get(r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            r5.put(r6, r2)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            goto L_0x006e
        L_0x006b:
            a((java.lang.String) r2, (int) r6)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
        L_0x006e:
            r0.put(r5)     // Catch:{ IOException -> 0x007e, JSONException -> 0x007c, all -> 0x0078 }
            if (r10 <= 0) goto L_0x002a
            int r10 = r10 + -1
            goto L_0x002a
        L_0x0076:
            r2 = r4
            goto L_0x008f
        L_0x0078:
            r10 = move-exception
            r2 = r4
            goto L_0x00d5
        L_0x007c:
            r10 = move-exception
            goto L_0x007f
        L_0x007e:
            r10 = move-exception
        L_0x007f:
            r2 = r4
            goto L_0x00b3
        L_0x0081:
            r10 = move-exception
            goto L_0x00b3
        L_0x0083:
            r10 = move-exception
            goto L_0x00b3
        L_0x0085:
            r10 = move-exception
            r3 = r2
            goto L_0x00d5
        L_0x0088:
            r10 = move-exception
            goto L_0x008b
        L_0x008a:
            r10 = move-exception
        L_0x008b:
            r3 = r2
            goto L_0x00b3
        L_0x008d:
            r9 = r2
            r3 = r9
        L_0x008f:
            if (r2 == 0) goto L_0x0097
            r2.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x0097
        L_0x0095:
            r9 = move-exception
            goto L_0x00a2
        L_0x0097:
            if (r3 == 0) goto L_0x009c
            r3.close()     // Catch:{ IOException -> 0x0095 }
        L_0x009c:
            if (r9 == 0) goto L_0x00d2
            r9.close()     // Catch:{ IOException -> 0x0095 }
            goto L_0x00d2
        L_0x00a2:
            java.lang.String r10 = f20157a     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "Failed to close buffers"
        L_0x00a6:
            android.util.Log.e(r10, r2, r9)     // Catch:{ all -> 0x00db }
            goto L_0x00d2
        L_0x00aa:
            r10 = move-exception
            r9 = r2
            r3 = r9
            goto L_0x00d5
        L_0x00ae:
            r10 = move-exception
            goto L_0x00b1
        L_0x00b0:
            r10 = move-exception
        L_0x00b1:
            r9 = r2
            r3 = r9
        L_0x00b3:
            java.lang.String r4 = f20157a     // Catch:{ all -> 0x00d4 }
            java.lang.String r5 = "Failed to read crashes"
            android.util.Log.e(r4, r5, r10)     // Catch:{ all -> 0x00d4 }
            if (r2 == 0) goto L_0x00c2
            r2.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c2
        L_0x00c0:
            r9 = move-exception
            goto L_0x00cd
        L_0x00c2:
            if (r3 == 0) goto L_0x00c7
            r3.close()     // Catch:{ IOException -> 0x00c0 }
        L_0x00c7:
            if (r9 == 0) goto L_0x00d2
            r9.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00d2
        L_0x00cd:
            java.lang.String r10 = f20157a     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "Failed to close buffers"
            goto L_0x00a6
        L_0x00d2:
            monitor-exit(r1)     // Catch:{ all -> 0x00db }
            return r0
        L_0x00d4:
            r10 = move-exception
        L_0x00d5:
            if (r2 == 0) goto L_0x00df
            r2.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00df
        L_0x00db:
            r9 = move-exception
            goto L_0x00f2
        L_0x00dd:
            r9 = move-exception
            goto L_0x00ea
        L_0x00df:
            if (r3 == 0) goto L_0x00e4
            r3.close()     // Catch:{ IOException -> 0x00dd }
        L_0x00e4:
            if (r9 == 0) goto L_0x00f1
            r9.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00f1
        L_0x00ea:
            java.lang.String r0 = f20157a     // Catch:{ all -> 0x00db }
            java.lang.String r2 = "Failed to close buffers"
            android.util.Log.e(r0, r2, r9)     // Catch:{ all -> 0x00db }
        L_0x00f1:
            throw r10     // Catch:{ all -> 0x00db }
        L_0x00f2:
            monitor-exit(r1)     // Catch:{ all -> 0x00db }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.f.e.a(android.content.Context, int):org.json.JSONArray");
    }

    private static JSONObject a(d dVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", UUID.randomUUID().toString());
        jSONObject.put("type", dVar.a());
        jSONObject.put("time", t.a(dVar.b()));
        jSONObject.put("session_time", t.a(dVar.c()));
        jSONObject.put("session_id", dVar.d());
        jSONObject.put("data", dVar.e() != null ? new JSONObject(dVar.e()) : new JSONObject());
        jSONObject.put("attempt", 0);
        return jSONObject;
    }

    public static void a(d dVar, Context context) {
        if (dVar != null && context != null) {
            synchronized (f20158b) {
                try {
                    JSONObject a2 = a(dVar);
                    FileOutputStream openFileOutput = context.openFileOutput("debuglogs", 32768);
                    openFileOutput.write((a2.toString() + ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE).getBytes());
                    openFileOutput.close();
                    d(context);
                } catch (Exception e2) {
                    Log.e(f20157a, "Failed to store crash", e2);
                }
            }
        }
    }

    public static void a(String str) {
        Map<String, Integer> map = f20160d;
        Integer num = map.get(str);
        if (num == null) {
            num = 0;
        } else {
            map.remove(str);
        }
        map.put(str, Integer.valueOf(num.intValue() + 1));
    }

    private static void a(String str, int i2) {
        if (!f20159c.contains(str)) {
            Map<String, Integer> map = f20160d;
            if (map.containsKey(str)) {
                map.remove(str);
            }
            map.put(str, Integer.valueOf(i2));
            return;
        }
        throw new RuntimeException("finished event should not be updated to OngoingEvent.");
    }

    public static int b(Context context) {
        return context.getApplicationContext().getSharedPreferences("DEBUG_PREF", 0).getInt("EventCount", 0) - f20159c.size();
    }

    private static void b(Context context, int i2) {
        SharedPreferences.Editor edit = context.getApplicationContext().getSharedPreferences("DEBUG_PREF", 0).edit();
        if (i2 < 0) {
            i2 = 0;
        }
        edit.putInt("EventCount", i2).apply();
    }

    public static void b(String str) {
        Map<String, Integer> map = f20160d;
        if (map.containsKey(str)) {
            map.remove(str);
        }
        f20159c.add(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:64:0x00fb A[SYNTHETIC, Splitter:B:64:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0103 A[Catch:{ IOException -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0108 A[Catch:{ IOException -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x010d A[Catch:{ IOException -> 0x00ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0127 A[SYNTHETIC, Splitter:B:81:0x0127] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0131 A[Catch:{ IOException -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0136 A[Catch:{ IOException -> 0x012d }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x013b A[Catch:{ IOException -> 0x012d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(android.content.Context r11) {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            java.lang.Object r1 = f20158b
            monitor-enter(r1)
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x00ee, JSONException -> 0x00ec, all -> 0x00e7 }
            java.io.File r5 = r11.getFilesDir()     // Catch:{ IOException -> 0x00ee, JSONException -> 0x00ec, all -> 0x00e7 }
            java.lang.String r6 = "debuglogs"
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x00ee, JSONException -> 0x00ec, all -> 0x00e7 }
            boolean r4 = r4.exists()     // Catch:{ IOException -> 0x00ee, JSONException -> 0x00ec, all -> 0x00e7 }
            if (r4 == 0) goto L_0x00ad
            java.lang.String r4 = "debuglogs"
            java.io.FileInputStream r4 = r11.openFileInput(r4)     // Catch:{ IOException -> 0x00ee, JSONException -> 0x00ec, all -> 0x00e7 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a9, JSONException -> 0x00a7, all -> 0x00a2 }
            r5.<init>(r4)     // Catch:{ IOException -> 0x00a9, JSONException -> 0x00a7, all -> 0x00a2 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009e, JSONException -> 0x009c, all -> 0x0098 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x009e, JSONException -> 0x009c, all -> 0x0098 }
        L_0x002b:
            java.lang.String r7 = r6.readLine()     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            if (r7 == 0) goto L_0x0059
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r8.<init>(r7)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            java.lang.String r7 = "id"
            java.lang.String r7 = r8.getString(r7)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            java.util.Set<java.lang.String> r9 = f20159c     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            boolean r9 = r9.contains(r7)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            if (r9 != 0) goto L_0x002b
            java.util.Map<java.lang.String, java.lang.Integer> r9 = f20160d     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            boolean r10 = r9.containsKey(r7)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            if (r10 == 0) goto L_0x0055
            java.lang.String r10 = "attempt"
            java.lang.Object r7 = r9.get(r7)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r8.put(r10, r7)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
        L_0x0055:
            r0.put(r8)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            goto L_0x002b
        L_0x0059:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r7.<init>()     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            int r8 = r0.length()     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r9 = 0
        L_0x0063:
            if (r9 >= r8) goto L_0x0078
            org.json.JSONObject r10 = r0.getJSONObject(r9)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r7.append(r10)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r10 = 10
            r7.append(r10)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            int r9 = r9 + 1
            goto L_0x0063
        L_0x0078:
            java.lang.String r0 = "debuglogs"
            java.io.FileOutputStream r3 = r11.openFileOutput(r0, r2)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            java.lang.String r0 = r7.toString()     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r3.write(r0)     // Catch:{ IOException -> 0x0093, JSONException -> 0x0091, all -> 0x008c }
            r0 = r3
            r3 = r6
            goto L_0x00b0
        L_0x008c:
            r11 = move-exception
            r0 = r3
            r3 = r6
            goto L_0x0125
        L_0x0091:
            r11 = move-exception
            goto L_0x0094
        L_0x0093:
            r11 = move-exception
        L_0x0094:
            r0 = r3
            r3 = r6
            goto L_0x00f2
        L_0x0098:
            r11 = move-exception
            r0 = r3
            goto L_0x0125
        L_0x009c:
            r11 = move-exception
            goto L_0x009f
        L_0x009e:
            r11 = move-exception
        L_0x009f:
            r0 = r3
            goto L_0x00f2
        L_0x00a2:
            r11 = move-exception
            r0 = r3
            r5 = r0
            goto L_0x0125
        L_0x00a7:
            r11 = move-exception
            goto L_0x00aa
        L_0x00a9:
            r11 = move-exception
        L_0x00aa:
            r0 = r3
            r5 = r0
            goto L_0x00f2
        L_0x00ad:
            r0 = r3
            r4 = r0
            r5 = r4
        L_0x00b0:
            int r6 = b((android.content.Context) r11)     // Catch:{ IOException -> 0x00e5, JSONException -> 0x00e3 }
            b(r11, r6)     // Catch:{ IOException -> 0x00e5, JSONException -> 0x00e3 }
            if (r3 == 0) goto L_0x00bf
            r3.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00bf
        L_0x00bd:
            r11 = move-exception
            goto L_0x00cf
        L_0x00bf:
            if (r5 == 0) goto L_0x00c4
            r5.close()     // Catch:{ IOException -> 0x00bd }
        L_0x00c4:
            if (r4 == 0) goto L_0x00c9
            r4.close()     // Catch:{ IOException -> 0x00bd }
        L_0x00c9:
            if (r0 == 0) goto L_0x00d6
            r0.close()     // Catch:{ IOException -> 0x00bd }
            goto L_0x00d6
        L_0x00cf:
            java.lang.String r0 = f20157a     // Catch:{ all -> 0x012b }
            java.lang.String r2 = "Failed to close buffers"
            android.util.Log.e(r0, r2, r11)     // Catch:{ all -> 0x012b }
        L_0x00d6:
            java.util.Set<java.lang.String> r11 = f20159c     // Catch:{ all -> 0x012b }
            r11.clear()     // Catch:{ all -> 0x012b }
            java.util.Map<java.lang.String, java.lang.Integer> r11 = f20160d     // Catch:{ all -> 0x012b }
            r11.clear()     // Catch:{ all -> 0x012b }
            monitor-exit(r1)     // Catch:{ all -> 0x012b }
            r11 = 1
            return r11
        L_0x00e3:
            r11 = move-exception
            goto L_0x00f2
        L_0x00e5:
            r11 = move-exception
            goto L_0x00f2
        L_0x00e7:
            r11 = move-exception
            r0 = r3
            r4 = r0
            r5 = r4
            goto L_0x0125
        L_0x00ec:
            r11 = move-exception
            goto L_0x00ef
        L_0x00ee:
            r11 = move-exception
        L_0x00ef:
            r0 = r3
            r4 = r0
            r5 = r4
        L_0x00f2:
            java.lang.String r6 = f20157a     // Catch:{ all -> 0x0124 }
            java.lang.String r7 = "Failed to rewrite File."
            android.util.Log.e(r6, r7, r11)     // Catch:{ all -> 0x0124 }
            if (r3 == 0) goto L_0x0101
            r3.close()     // Catch:{ IOException -> 0x00ff }
            goto L_0x0101
        L_0x00ff:
            r11 = move-exception
            goto L_0x0111
        L_0x0101:
            if (r5 == 0) goto L_0x0106
            r5.close()     // Catch:{ IOException -> 0x00ff }
        L_0x0106:
            if (r4 == 0) goto L_0x010b
            r4.close()     // Catch:{ IOException -> 0x00ff }
        L_0x010b:
            if (r0 == 0) goto L_0x0118
            r0.close()     // Catch:{ IOException -> 0x00ff }
            goto L_0x0118
        L_0x0111:
            java.lang.String r0 = f20157a     // Catch:{ all -> 0x012b }
            java.lang.String r3 = "Failed to close buffers"
            android.util.Log.e(r0, r3, r11)     // Catch:{ all -> 0x012b }
        L_0x0118:
            java.util.Set<java.lang.String> r11 = f20159c     // Catch:{ all -> 0x012b }
            r11.clear()     // Catch:{ all -> 0x012b }
            java.util.Map<java.lang.String, java.lang.Integer> r11 = f20160d     // Catch:{ all -> 0x012b }
            r11.clear()     // Catch:{ all -> 0x012b }
            monitor-exit(r1)     // Catch:{ all -> 0x012b }
            return r2
        L_0x0124:
            r11 = move-exception
        L_0x0125:
            if (r3 == 0) goto L_0x012f
            r3.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x012f
        L_0x012b:
            r11 = move-exception
            goto L_0x0151
        L_0x012d:
            r0 = move-exception
            goto L_0x013f
        L_0x012f:
            if (r5 == 0) goto L_0x0134
            r5.close()     // Catch:{ IOException -> 0x012d }
        L_0x0134:
            if (r4 == 0) goto L_0x0139
            r4.close()     // Catch:{ IOException -> 0x012d }
        L_0x0139:
            if (r0 == 0) goto L_0x0146
            r0.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0146
        L_0x013f:
            java.lang.String r2 = f20157a     // Catch:{ all -> 0x012b }
            java.lang.String r3 = "Failed to close buffers"
            android.util.Log.e(r2, r3, r0)     // Catch:{ all -> 0x012b }
        L_0x0146:
            java.util.Set<java.lang.String> r0 = f20159c     // Catch:{ all -> 0x012b }
            r0.clear()     // Catch:{ all -> 0x012b }
            java.util.Map<java.lang.String, java.lang.Integer> r0 = f20160d     // Catch:{ all -> 0x012b }
            r0.clear()     // Catch:{ all -> 0x012b }
            throw r11     // Catch:{ all -> 0x012b }
        L_0x0151:
            monitor-exit(r1)     // Catch:{ all -> 0x012b }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.f.e.c(android.content.Context):boolean");
    }

    public static boolean c(String str) {
        return f20159c.contains(str) || f20160d.containsKey(str);
    }

    private static void d(Context context) {
        b(context, context.getApplicationContext().getSharedPreferences("DEBUG_PREF", 0).getInt("EventCount", 0) + 1);
    }
}
