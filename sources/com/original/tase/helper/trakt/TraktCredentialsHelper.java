package com.original.tase.helper.trakt;

import android.content.SharedPreferences;
import com.movie.FreeMoviesApp;
import com.original.tase.model.trakt.TraktCredentialsInfo;

public class TraktCredentialsHelper {

    /* renamed from: a  reason: collision with root package name */
    private static TraktCredentialsInfo f34018a;

    public static synchronized void a() {
        synchronized (TraktCredentialsHelper.class) {
            synchronized (TraktCredentialsHelper.class) {
                SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                edit.putString("trakt_user", (String) null);
                edit.putString("trakt_access_token", (String) null);
                edit.putString("trakt_refresh_token", (String) null);
                edit.apply();
                f34018a = null;
            }
        }
    }

    public static TraktCredentialsInfo b() {
        SharedPreferences p2 = FreeMoviesApp.p();
        if (f34018a == null) {
            TraktCredentialsInfo traktCredentialsInfo = new TraktCredentialsInfo();
            f34018a = traktCredentialsInfo;
            traktCredentialsInfo.setUser(p2.getString("trakt_user", (String) null));
            f34018a.setAccessToken(p2.getString("trakt_access_token", (String) null));
            f34018a.setRefreshToken(p2.getString("trakt_refresh_token", (String) null));
        }
        return f34018a;
    }

    public static synchronized void c(TraktCredentialsInfo traktCredentialsInfo) {
        synchronized (TraktCredentialsHelper.class) {
            synchronized (TraktCredentialsHelper.class) {
                f34018a = traktCredentialsInfo;
                SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                edit.putString("trakt_user", traktCredentialsInfo.getUserName());
                edit.putString("trakt_access_token", traktCredentialsInfo.getAccessToken());
                edit.putString("trakt_refresh_token", traktCredentialsInfo.getRefreshToken());
                edit.apply();
            }
        }
    }
}
