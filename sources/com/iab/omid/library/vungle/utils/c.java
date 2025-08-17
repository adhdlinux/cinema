package com.iab.omid.library.vungle.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import com.iab.omid.library.vungle.adsession.OutputDeviceStatus;
import com.iab.omid.library.vungle.internal.e;
import com.iab.omid.library.vungle.walking.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static WindowManager f31752a;

    /* renamed from: b  reason: collision with root package name */
    private static String[] f31753b = {"x", "y", "width", "height"};

    /* renamed from: c  reason: collision with root package name */
    static float f31754c = Resources.getSystem().getDisplayMetrics().density;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31755a;

        static {
            int[] iArr = new int[OutputDeviceStatus.values().length];
            f31755a = iArr;
            try {
                iArr[OutputDeviceStatus.NOT_DETECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final float f31756a;

        /* renamed from: b  reason: collision with root package name */
        final float f31757b;

        b(float f2, float f3) {
            this.f31756a = f2;
            this.f31757b = f3;
        }
    }

    static float a(int i2) {
        return ((float) i2) / f31754c;
    }

    private static b b(JSONObject jSONObject) {
        float f2;
        float f3;
        if (f31752a != null) {
            Point point = new Point(0, 0);
            f31752a.getDefaultDisplay().getRealSize(point);
            f3 = a(point.x);
            f2 = a(point.y);
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        return new b(f3, f2);
    }

    public static JSONObject c(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) a(i2));
            jSONObject.put("y", (double) a(i3));
            jSONObject.put("width", (double) a(i4));
            jSONObject.put("height", (double) a(i5));
        } catch (JSONException e2) {
            d.b("Error with creating viewStateObject", e2);
        }
        return jSONObject;
    }

    public static void d(Context context) {
        if (context != null) {
            f31754c = context.getResources().getDisplayMetrics().density;
            f31752a = (WindowManager) context.getSystemService("window");
        }
    }

    public static void e(JSONObject jSONObject, OutputDeviceStatus outputDeviceStatus) {
        try {
            jSONObject.put("noOutputDevice", k(outputDeviceStatus));
        } catch (JSONException e2) {
            d.b("Error with setting output device status", e2);
        }
    }

    public static void f(JSONObject jSONObject, a.C0050a aVar) {
        e a2 = aVar.a();
        JSONArray jSONArray = new JSONArray();
        for (String put : aVar.c()) {
            jSONArray.put(put);
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", a2.d());
            jSONObject.put("friendlyObstructionPurpose", a2.b());
            jSONObject.put("friendlyObstructionReason", a2.a());
        } catch (JSONException e2) {
            d.b("Error with setting friendly obstruction", e2);
        }
    }

    public static void g(JSONObject jSONObject, Boolean bool) {
        try {
            jSONObject.put("hasWindowFocus", bool);
        } catch (JSONException e2) {
            d.b("Error with setting has window focus", e2);
        }
    }

    public static void h(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            d.b("Error with setting ad session id", e2);
        }
    }

    public static void i(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            d.b("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void j(JSONObject jSONObject, JSONObject jSONObject2) {
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

    private static boolean k(OutputDeviceStatus outputDeviceStatus) {
        return a.f31755a[outputDeviceStatus.ordinal()] == 1;
    }

    private static boolean l(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }

    public static void m(JSONObject jSONObject) {
        b b2 = b(jSONObject);
        try {
            jSONObject.put("width", (double) b2.f31756a);
            jSONObject.put("height", (double) b2.f31757b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static void n(JSONObject jSONObject, Boolean bool) {
        if (bool.booleanValue()) {
            try {
                jSONObject.put("isPipActive", bool);
            } catch (JSONException e2) {
                d.b("Error with setting is picture-in-picture active", e2);
            }
        }
    }

    public static void o(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e2) {
            d.b("Error with setting not visible reason", e2);
        }
    }

    private static boolean p(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("childViews");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!l(optJSONArray, optJSONArray2)) {
            return false;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            if (!v(optJSONArray.optJSONObject(i2), optJSONArray2.optJSONObject(i2))) {
                return false;
            }
        }
        return true;
    }

    private static boolean q(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
        JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
        if (optJSONArray == null && optJSONArray2 == null) {
            return true;
        }
        if (!l(optJSONArray, optJSONArray2)) {
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
        return Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")));
    }

    private static boolean s(JSONObject jSONObject, JSONObject jSONObject2) {
        return Boolean.valueOf(jSONObject.optBoolean("noOutputDevice")).equals(Boolean.valueOf(jSONObject2.optBoolean("noOutputDevice")));
    }

    private static boolean t(JSONObject jSONObject, JSONObject jSONObject2) {
        for (String str : f31753b) {
            if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean u(JSONObject jSONObject, JSONObject jSONObject2) {
        return jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""));
    }

    public static boolean v(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        return jSONObject != null && jSONObject2 != null && t(jSONObject, jSONObject2) && u(jSONObject, jSONObject2) && s(jSONObject, jSONObject2) && r(jSONObject, jSONObject2) && q(jSONObject, jSONObject2) && p(jSONObject, jSONObject2);
    }
}
