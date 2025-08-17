package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ClearKeyUtil {
    private ClearKeyUtil() {
    }

    public static byte[] a(byte[] bArr) {
        if (Util.f28808a >= 27) {
            return bArr;
        }
        return Util.p0(c(Util.D(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (Util.f28808a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(Util.D(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (i2 != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return Util.p0(sb.toString());
        } catch (JSONException e2) {
            Log.d("ClearKeyUtil", "Failed to adjust response data: " + Util.D(bArr), e2);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
