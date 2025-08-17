package com.facebook.ads.internal.l;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f20244a;

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f20245b;

    private a(Context context) {
        this.f20245b = context.getApplicationContext().getSharedPreferences("com.facebook.ads.FEATURE_CONFIG", 0);
    }

    private static int a(Context context, String str, int i2) {
        int a2 = w(context).a(str, i2);
        return (a2 < 0 || a2 >= 101) ? i2 : a2;
    }

    public static boolean a(Context context) {
        return b("com.google.android.exoplayer2", "ExoPlayer") && w(context).a("adnw_enable_exoplayer", false);
    }

    public static boolean b(Context context) {
        return w(context).a("adnw_enable_debug_overlay", false);
    }

    private static boolean b(String str, String str2) {
        try {
            Class.forName(str + "." + str2);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        return w(context).a("adnw_block_lockscreen", false);
    }

    public static boolean d(Context context) {
        return w(context).a("adnw_android_memory_opt", false);
    }

    public static boolean e(Context context) {
        return w(context).a("adnw_android_disable_blur", false);
    }

    public static boolean f(Context context) {
        return w(context).a("adnw_android_disable_playable_precache", false);
    }

    public static boolean g(Context context) {
        return w(context).a("adnw_enable_iab", false);
    }

    public static boolean h(Context context) {
        return w(context).a("adnw_debug_logging", false);
    }

    public static Set<String> i(Context context) {
        String a2 = w(context).a("additional_debug_logging_black_list", "");
        HashSet hashSet = new HashSet();
        try {
            JSONArray jSONArray = new JSONArray(a2);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                hashSet.add(jSONArray.getString(i2));
            }
        } catch (JSONException unused) {
        }
        return hashSet;
    }

    public static int j(Context context) {
        return a(context, "additional_debug_logging_black_list_percentage", 0);
    }

    public static int k(Context context) {
        return a(context, "additional_debug_logging_sampling_percentage", 100);
    }

    public static long l(Context context) {
        return w(context).a("unified_logging_immediate_delay_ms", 500);
    }

    public static long m(Context context) {
        return ((long) w(context).a("unified_logging_dispatch_interval_seconds", 300)) * 1000;
    }

    public static int n(Context context) {
        return w(context).a("unified_logging_event_limit", -1);
    }

    public static boolean o(Context context) {
        return w(context).a("video_and_endcard_autorotate", "autorotate_disabled").equals("autorotate_enabled");
    }

    public static int p(Context context) {
        return w(context).a("minimum_elapsed_time_after_impression", -1);
    }

    public static int q(Context context) {
        return w(context).a("stack_trace_sample_rate", 0);
    }

    public static boolean r(Context context) {
        return w(context).a("adnw_top_activity_viewability", false);
    }

    public static boolean s(Context context) {
        return w(context).a("adnw_enhanced_viewability_area_check", false);
    }

    public static boolean t(Context context) {
        return w(context).a("adnw_viewability_check_area_based", false);
    }

    public static String u(Context context) {
        return w(context).a("adnw_logging_endpoint_prefix", "www");
    }

    public static boolean v(Context context) {
        return w(context).a("adnw_mapp_markup_impression_after_image_load", false);
    }

    public static a w(Context context) {
        if (f20244a == null) {
            synchronized (a.class) {
                if (f20244a == null) {
                    f20244a = new a(context);
                }
            }
        }
        return f20244a;
    }

    public int a(String str, int i2) {
        String string = this.f20245b.getString(str, String.valueOf(i2));
        try {
            return string.equals("null") ? i2 : Integer.valueOf(string).intValue();
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public long a(String str, long j2) {
        String string = this.f20245b.getString(str, String.valueOf(j2));
        try {
            return string.equals("null") ? j2 : Long.valueOf(string).longValue();
        } catch (NumberFormatException unused) {
            return j2;
        }
    }

    public String a(String str, String str2) {
        String string = this.f20245b.getString(str, str2);
        return (string == null || string.equals("null")) ? str2 : string;
    }

    public void a(String str) {
        if (str != null && !str.isEmpty() && !str.equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            SharedPreferences.Editor edit = this.f20245b.edit();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                edit.putString(next, jSONObject.getString(next));
            }
            edit.apply();
        }
    }

    public boolean a(String str, boolean z2) {
        String string = this.f20245b.getString(str, String.valueOf(z2));
        return string.equals("null") ? z2 : Boolean.valueOf(string).booleanValue();
    }
}
