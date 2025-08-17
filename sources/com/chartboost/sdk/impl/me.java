package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.chartboost.sdk.impl.wd;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class me {

    /* renamed from: a  reason: collision with root package name */
    public static WindowManager f18202a;

    /* renamed from: b  reason: collision with root package name */
    public static String[] f18203b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    public static float f18204c = Resources.getSystem().getDisplayMetrics().density;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18205a;

        static {
            int[] iArr = new int[c9.values().length];
            f18205a = iArr;
            try {
                iArr[c9.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final float f18206a;

        /* renamed from: b  reason: collision with root package name */
        public final float f18207b;

        public b(float f2, float f3) {
            this.f18206a = f2;
            this.f18207b = f3;
        }
    }

    public static float a(int i2) {
        return ((float) i2) / f18204c;
    }

    public static void b(JSONObject jSONObject) {
        b a2 = a(jSONObject);
        try {
            jSONObject.put("width", (double) a2.f18206a);
            jSONObject.put("height", (double) a2.f18207b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean c(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!a(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            if (!optJSONArray.optString(i2, "").equals(optJSONArray2.optString(i2, ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean d(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    public static boolean e(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    public static boolean f(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f18203b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean h(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && f(jSONObject, jSONObject2) && g(jSONObject, jSONObject2) && e(jSONObject, jSONObject2) && d(jSONObject, jSONObject2) && c(jSONObject, jSONObject2) && b(jSONObject, jSONObject2);
    }

    public static b a(JSONObject jSONObject) {
        float f2;
        float f3;
        if (f18202a != null) {
            Point point = new Point(0, 0);
            f18202a.getDefaultDisplay().getRealSize(point);
            f3 = a(point.x);
            f2 = a(point.y);
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        return new b(f3, f2);
    }

    public static void b(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e2) {
            se.a("Error with setting not visible reason", e2);
        }
    }

    public static JSONObject a(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) a(i2));
            jSONObject.put("y", (double) a(i3));
            jSONObject.put("width", (double) a(i4));
            jSONObject.put("height", (double) a(i5));
        } catch (JSONException e2) {
            se.a("Error with creating viewStateObject", e2);
        }
        return jSONObject;
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
            if (!h(optJSONArray.optJSONObject(i2), optJSONArray2.optJSONObject(i2))) {
                return false;
            }
        }
        return true;
    }

    public static void a(Context context) {
        if (context != null) {
            f18204c = context.getResources().getDisplayMetrics().density;
            f18202a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void a(JSONObject jSONObject, c9 c9Var) {
        try {
            jSONObject.put("noOutputDevice", a(c9Var));
        } catch (JSONException e2) {
            se.a("Error with setting output device status", e2);
        }
    }

    public static void a(JSONObject jSONObject, wd.a aVar) {
        we a2 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.b()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a2.d());
            jSONObject.put("friendlyObstructionPurpose", a2.b());
            jSONObject.put("friendlyObstructionReason", a2.a());
        } catch (JSONException e2) {
            se.a("Error with setting friendly obstruction", e2);
        }
    }

    public static void a(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e2) {
            se.a("Error with setting has window focus", e2);
        }
    }

    public static void a(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            se.a("Error with setting ad session id", e2);
        }
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            se.a("JSONException during JSONObject.put for name [" + str + "]", e2);
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

    public static boolean a(c9 c9Var) {
        return a.f18205a[c9Var.ordinal()] == 1;
    }

    public static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
