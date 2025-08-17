package com.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.movie.FreeMoviesApp;
import com.original.tase.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PrefUtils {
    public static byte[] a(Map<String, ?> map) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(map);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static Map<String, ?> b(byte[] bArr) {
        try {
            Map<String, ?> map = (Map) new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
            System.out.println(map.toString());
            return map;
        } catch (IOException | ClassNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.reflect.Type, java.lang.Class<T[]>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T[] c(java.lang.String r2, java.lang.Class<T[]> r3) {
        /*
            android.content.SharedPreferences r0 = com.movie.FreeMoviesApp.p()
            java.lang.String r1 = ""
            java.lang.String r2 = r0.getString(r2, r1)
            boolean r0 = r2.isEmpty()
            if (r0 == 0) goto L_0x0012
            r2 = 0
            return r2
        L_0x0012:
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.Object r2 = r0.m(r2, r3)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.utils.PrefUtils.c(java.lang.String, java.lang.Class):java.lang.Object[]");
    }

    public static String d(Context context) {
        return context.getSharedPreferences("hdmovies", 0).getString("pref_is_movie_selected_v3", NavIds.NAV_TV_SHOW.name());
    }

    public static int e(Context context) {
        return context.getSharedPreferences("hdmovies", 0).getInt("pref_last_open_count_v3", 0);
    }

    public static String f(Context context) {
        return context.getSharedPreferences("hdmovies", 0).getString("pref_server_url_cache_v3", "");
    }

    public static SharedPreferences g(Context context) {
        return context.getSharedPreferences("hdmovies", 0);
    }

    public static void h(Context context) {
        context.getSharedPreferences("hdmovies", 0).edit().putInt("pref_last_open_count_v3", e(context) + 1).apply();
    }

    public static boolean i(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hdmovies", 0);
        return sharedPreferences.getBoolean("pref_autoupdate_checkbox_v3" + Utils.c0(), false);
    }

    public static String j(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hdmovies", 0);
        return sharedPreferences.getString("pref_last_app_config_v3" + Utils.b0(), "");
    }

    public static HashMap<String, Integer> k(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("hdmovies", 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString("pref_provider_point", (String) null);
        if (string == null) {
            return new HashMap<>();
        }
        return (HashMap) gson.m(string, new TypeToken<HashMap<String, Integer>>() {
        }.d());
    }

    public static void l(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("hdmovies", 0).edit();
        edit.putString("pref_last_app_config_v3" + Utils.b0(), str).apply();
    }

    public static void m(Context context, Map<String, ?> map) {
        SharedPreferences.Editor edit = context.getSharedPreferences("hdmovies", 0).edit();
        edit.clear();
        for (Map.Entry next : map.entrySet()) {
            Object value = next.getValue();
            String str = (String) next.getKey();
            if (value instanceof Boolean) {
                edit.putBoolean(str, ((Boolean) value).booleanValue());
            } else if (value instanceof Float) {
                edit.putFloat(str, ((Float) value).floatValue());
            } else if (value instanceof Integer) {
                edit.putInt(str, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                edit.putLong(str, ((Long) value).longValue());
            } else if (value instanceof String) {
                edit.putString(str, (String) value);
            }
        }
        edit.commit();
    }

    public static void n(Context context, HashMap<String, Integer> hashMap) {
        SharedPreferences.Editor edit = context.getSharedPreferences("hdmovies", 0).edit();
        edit.putString("pref_provider_point", new Gson().u(hashMap));
        edit.apply();
    }

    public static void o(String str, String str2) {
        FreeMoviesApp.p().edit().putString(str, str2).apply();
    }

    public static <T> void p(String str, List<T> list) {
        try {
            o(str, new Gson().u(list));
        } catch (Throwable unused) {
            Logger.b("recaptchar", "some time null");
        }
    }

    public static void q(Context context, int i2) {
        context.getSharedPreferences("hdmovies", 0).edit().putString("pref_is_movie_selected_v3", NavIds.f37572c.b(i2)).apply();
    }

    public static void r(Context context, String str) {
        context.getSharedPreferences("hdmovies", 0).edit().putString("pref_search_query", str).apply();
    }

    public static void s(Context context, boolean z2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("hdmovies", 0).edit();
        edit.putBoolean("pref_autoupdate_checkbox_v3" + Utils.c0(), z2).apply();
    }
}
