package com.facebook.ads.internal.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.internal.q.a.a;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19642a = "c";

    public static b a(Context context, com.facebook.ads.internal.m.c cVar, String str, Uri uri, Map<String, String> map) {
        if (uri == null) {
            return null;
        }
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter("video_url");
        if (!TextUtils.isEmpty(uri.getQueryParameter("data"))) {
            try {
                JSONObject jSONObject = new JSONObject(uri.getQueryParameter("data"));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    map.put(next, jSONObject.getString(next));
                }
            } catch (JSONException e2) {
                Log.w(f19642a, "Unable to parse json data in AdActionFactory.", e2);
            }
        }
        l a2 = l.a(cVar, a.a());
        authority.hashCode();
        char c2 = 65535;
        switch (authority.hashCode()) {
            case -1458789996:
                if (authority.equals("passthrough")) {
                    c2 = 0;
                    break;
                }
                break;
            case 109770977:
                if (authority.equals("store")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1546100943:
                if (authority.equals("open_link")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new j(context, cVar, str, uri, map);
            case 1:
                if (queryParameter != null) {
                    return null;
                }
                return new f(context, cVar, str, uri, map, a2);
            case 2:
                return new i(context, cVar, str, uri, map, a2);
            default:
                return new k(context, cVar, str, uri);
        }
    }

    public static boolean a(String str) {
        return "store".equalsIgnoreCase(str) || "open_link".equalsIgnoreCase(str);
    }
}
