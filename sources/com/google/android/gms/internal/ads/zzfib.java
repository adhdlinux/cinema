package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.WindowManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzfib {
    static float zza = Resources.getSystem().getDisplayMetrics().density;
    private static WindowManager zzb;
    private static final String[] zzc = {"x", "y", "width", "height"};

    public static JSONObject zza(int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", (double) (((float) i2) / zza));
            jSONObject.put("y", (double) (((float) i3) / zza));
            jSONObject.put("width", (double) (((float) i4) / zza));
            jSONObject.put("height", (double) (((float) i5) / zza));
        } catch (JSONException e2) {
            zzfic.zza("Error with creating viewStateObject", e2);
        }
        return jSONObject;
    }

    public static void zzb(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e2) {
            zzfic.zza("Error with setting ad session id", e2);
        }
    }

    public static void zzc(JSONObject jSONObject, JSONObject jSONObject2) {
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

    public static void zzd(Context context) {
        if (context != null) {
            zza = context.getResources().getDisplayMetrics().density;
            zzb = (WindowManager) context.getSystemService("window");
        }
    }

    public static void zze(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (NullPointerException | JSONException e2) {
            zzfic.zza("JSONException during JSONObject.put for name [" + str + "]", e2);
        }
    }

    public static void zzf(JSONObject jSONObject) {
        float f2;
        float f3;
        if (zzb != null) {
            Point point = new Point(0, 0);
            zzb.getDefaultDisplay().getRealSize(point);
            float f4 = zza;
            f2 = ((float) point.x) / f4;
            f3 = ((float) point.y) / f4;
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

    public static boolean zzg(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null && jSONObject2 != null) {
            String[] strArr = zzc;
            int i2 = 0;
            while (true) {
                if (i2 < 4) {
                    String str = strArr[i2];
                    if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                        break;
                    }
                    i2++;
                } else if (jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", "")) && Boolean.valueOf(jSONObject.optBoolean("hasWindowFocus")).equals(Boolean.valueOf(jSONObject2.optBoolean("hasWindowFocus")))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
                    if (optJSONArray != null || optJSONArray2 != null) {
                        if (zzh(optJSONArray, optJSONArray2)) {
                            int i3 = 0;
                            while (true) {
                                if (i3 < optJSONArray.length()) {
                                    if (!optJSONArray.optString(i3, "").equals(optJSONArray2.optString(i3, ""))) {
                                        break;
                                    }
                                    i3++;
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("childViews");
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray("childViews");
                    if (!(optJSONArray3 == null && optJSONArray4 == null)) {
                        if (zzh(optJSONArray3, optJSONArray4)) {
                            int i4 = 0;
                            while (i4 < optJSONArray3.length()) {
                                if (zzg(optJSONArray3.optJSONObject(i4), optJSONArray4.optJSONObject(i4))) {
                                    i4++;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean zzh(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
