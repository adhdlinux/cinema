package com.startapp;

import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fg {

    /* renamed from: a  reason: collision with root package name */
    public static WindowManager f34542a;

    /* renamed from: b  reason: collision with root package name */
    public static String[] f34543b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    public static float f34544c = Resources.getSystem().getDisplayMetrics().density;

    public static float a(int i2) {
        return ((float) i2) / f34544c;
    }

    public static JSONObject a(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) a(i2));
            jSONObject.put("y", (double) a(i3));
            jSONObject.put("width", (double) a(i4));
            jSONObject.put("height", (double) a(i5));
        } catch (JSONException e2) {
            p.a("Error with creating viewStateObject", (Exception) e2);
        }
        return jSONObject;
    }

    public static void a(JSONObject jSONObject) {
        float f2;
        float f3;
        if (f34542a != null) {
            Point point = new Point(0, 0);
            f34542a.getDefaultDisplay().getRealSize(point);
            f2 = a(point.x);
            f3 = a(point.y);
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        try {
            jSONObject.put("width", (double) f2);
            jSONObject.put("height", (double) f3);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            p.a("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static boolean b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            if (!c(optJSONArray.optJSONObject(i2), optJSONArray2.optJSONObject(i2))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x008d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean c(org.json.JSONObject r10, org.json.JSONObject r11) {
        /*
            r0 = 1
            if (r10 != 0) goto L_0x0006
            if (r11 != 0) goto L_0x0006
            return r0
        L_0x0006:
            r1 = 0
            if (r10 == 0) goto L_0x008f
            if (r11 != 0) goto L_0x000d
            goto L_0x008f
        L_0x000d:
            java.lang.String[] r2 = f34543b
            int r3 = r2.length
            r4 = 0
        L_0x0011:
            if (r4 >= r3) goto L_0x0026
            r5 = r2[r4]
            double r6 = r10.optDouble(r5)
            double r8 = r11.optDouble(r5)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0023
            r2 = 0
            goto L_0x0027
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x0011
        L_0x0026:
            r2 = 1
        L_0x0027:
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = "adSessionId"
            java.lang.String r3 = ""
            java.lang.String r4 = r10.optString(r2, r3)
            java.lang.String r2 = r11.optString(r2, r3)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = "hasWindowFocus"
            boolean r4 = r10.optBoolean(r2)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            boolean r2 = r11.optBoolean(r2)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x008d
            java.lang.String r2 = "isFriendlyObstructionFor"
            org.json.JSONArray r4 = r10.optJSONArray(r2)
            org.json.JSONArray r2 = r11.optJSONArray(r2)
            if (r4 != 0) goto L_0x0062
            if (r2 != 0) goto L_0x0062
            goto L_0x0083
        L_0x0062:
            boolean r5 = a((org.json.JSONArray) r4, (org.json.JSONArray) r2)
            if (r5 != 0) goto L_0x0069
            goto L_0x007e
        L_0x0069:
            r5 = 0
        L_0x006a:
            int r6 = r4.length()
            if (r5 >= r6) goto L_0x0083
            java.lang.String r6 = r4.optString(r5, r3)
            java.lang.String r7 = r2.optString(r5, r3)
            boolean r6 = r6.equals(r7)
            if (r6 != 0) goto L_0x0080
        L_0x007e:
            r2 = 0
            goto L_0x0084
        L_0x0080:
            int r5 = r5 + 1
            goto L_0x006a
        L_0x0083:
            r2 = 1
        L_0x0084:
            if (r2 == 0) goto L_0x008d
            boolean r10 = b(r10, r11)
            if (r10 == 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r0 = 0
        L_0x008e:
            return r0
        L_0x008f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.fg.c(org.json.JSONObject, org.json.JSONObject):boolean");
    }
}
