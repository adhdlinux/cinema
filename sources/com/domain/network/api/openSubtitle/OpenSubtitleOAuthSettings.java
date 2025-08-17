package com.domain.network.api.openSubtitle;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.movie.FreeMoviesApp;
import com.utils.subtitle.services.openSubtitle.models.User;
import kotlin.jvm.internal.Intrinsics;

public final class OpenSubtitleOAuthSettings {

    /* renamed from: a  reason: collision with root package name */
    public static final OpenSubtitleOAuthSettings f19367a = new OpenSubtitleOAuthSettings();

    private OpenSubtitleOAuthSettings() {
    }

    public final void a() {
        SharedPreferences p2 = FreeMoviesApp.p();
        p2.edit().putString("pref_open_subtitle_access_token", "").apply();
        p2.edit().putString("pref_open_subtitle_user", "").apply();
    }

    public final String b() {
        String string = FreeMoviesApp.p().getString("pref_open_subtitle_access_token", "");
        if (string == null) {
            return "";
        }
        return string;
    }

    public final User c() {
        boolean z2;
        String string = FreeMoviesApp.p().getString("pref_open_subtitle_user", "");
        if (string == null || string.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return null;
        }
        return (User) new Gson().l(string, User.class);
    }

    public final String d() {
        boolean z2;
        String str;
        String string = FreeMoviesApp.p().getString("pref_open_subtitle_user", "");
        if (string == null || string.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            return null;
        }
        User user = (User) new Gson().l(string, User.class);
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(user.getUser_id());
        sb.append(" \nLevel: ");
        sb.append(user.getLevel());
        sb.append(" \nUser Type: ");
        if (user.getVip()) {
            str = "Vip";
        } else {
            str = "Normal";
        }
        sb.append(str);
        sb.append("\nAllowed Download: ");
        sb.append(user.getAllowed_downloads());
        sb.append("\nDownload count: ");
        sb.append(user.getDownloads_count());
        sb.append(" \nRemaining downloads: ");
        sb.append(user.getRemaining_downloads());
        return sb.toString();
    }

    public final void e(String str) {
        Intrinsics.f(str, "accessToken");
        FreeMoviesApp.p().edit().putString("pref_open_subtitle_access_token", str).apply();
    }

    public final void f(User user) {
        Intrinsics.f(user, "user");
        FreeMoviesApp.p().edit().putString("pref_open_subtitle_user", new Gson().u(user)).apply();
    }
}
