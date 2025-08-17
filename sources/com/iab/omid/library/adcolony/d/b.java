package com.iab.omid.library.adcolony.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.iab.omid.library.adcolony.b.c;
import com.iab.omid.library.adcolony.walking.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f31403a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f31404b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    static float f31405c = Resources.getSystem().getDisplayMetrics().density;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final float f31406a;

        /* renamed from: b  reason: collision with root package name */
        final float f31407b;

        a(float f2, float f3) {
            this.f31406a = f2;
            this.f31407b = f3;
        }
    }

    static float a(int i2) {
        return ((float) i2) / f31405c;
    }

    public static JSONObject b(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) a(i2));
            jSONObject.put("y", (double) a(i3));
            jSONObject.put("width", (double) a(i4));
            jSONObject.put("height", (double) a(i5));
        } catch (JSONException e2) {
            c.b("Error with creating viewStateObject", e2);
        }
        return jSONObject;
    }

    public static void c(Context context) {
        if (context != null) {
            f31405c = context.getResources().getDisplayMetrics().density;
            f31403a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void d(JSONObject jSONObject) {
        a k2 = k(jSONObject);
        try {
            jSONObject.put("width", (double) k2.f31406a);
            jSONObject.put("height", (double) k2.f31407b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void e(JSONObject jSONObject, a.C0043a aVar) {
        c a2 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.c()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a2.b());
            jSONObject.put("friendlyObstructionPurpose", a2.c());
            jSONObject.put("friendlyObstructionReason", a2.d());
        } catch (JSONException e2) {
            c.b("Error with setting friendly obstruction", e2);
        }
    }

    public static void f(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e2) {
            c.b("Error with setting not visible reason", e2);
        }
    }

    public static void g(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            c.b("Error with setting ad session id", e2);
        }
    }

    public static void h(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            c.b("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void i(JSONObject jSONObject, JSONObject jSONObject2) {
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

    private static boolean j(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    private static a k(JSONObject jSONObject) {
        float f2;
        float f3;
        if (f31403a != null) {
            Point point = new Point(0, 0);
            f31403a.getDefaultDisplay().getRealSize(point);
            f3 = a(point.x);
            f2 = a(point.y);
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        return new a(f3, f2);
    }

    public static void l(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e2) {
            c.b("Error with setting not visible reason", e2);
        }
    }

    public static boolean m(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && n(jSONObject, jSONObject2) && p(jSONObject, jSONObject2) && o(jSONObject, jSONObject2) && q(jSONObject, jSONObject2) && r(jSONObject, jSONObject2);
    }

    private static boolean n(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f31404b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean o(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    private static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!j(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            if (!optJSONArray.optString(i2, "").equals(optJSONArray2.optString(i2, ""))) {
                return false;
            }
        }
        return true;
    }

    private static boolean r(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!j(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            if (!m(optJSONArray.optJSONObject(i2), optJSONArray2.optJSONObject(i2))) {
                return false;
            }
        }
        return true;
    }
}
