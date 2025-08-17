package com.original.tase.debrid.alldebrid;

import android.content.SharedPreferences;
import com.movie.FreeMoviesApp;
import com.original.tase.Logger;
import com.original.tase.model.debrid.alldebrid.AllDebridCredentialsInfo;
import com.utils.Utils;

public class AllDebridCredentialsHelper {

    /* renamed from: a  reason: collision with root package name */
    private static AllDebridCredentialsInfo f33790a;

    public static synchronized void a() {
        synchronized (AllDebridCredentialsHelper.class) {
            synchronized (AllDebridCredentialsHelper.class) {
                try {
                    f33790a = null;
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putString("all_debrid_access_token", (String) null);
                    edit.putLong("all_debrid_expired_in", 0);
                    edit.apply();
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }

    public static synchronized AllDebridCredentialsInfo b() {
        AllDebridCredentialsInfo allDebridCredentialsInfo;
        synchronized (AllDebridCredentialsHelper.class) {
            if (f33790a == null) {
                f33790a = new AllDebridCredentialsInfo();
                try {
                    SharedPreferences p2 = FreeMoviesApp.p();
                    f33790a.setApiKey(p2.getString("all_debrid_access_token", (String) null), p2.getLong("all_debrid_expired_in", 0));
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
            allDebridCredentialsInfo = f33790a;
        }
        return allDebridCredentialsInfo;
    }

    public static boolean c() {
        return !Utils.l(Utils.RDTYPE.ALL_DEBRID);
    }

    public static synchronized void d(AllDebridCredentialsInfo allDebridCredentialsInfo) {
        synchronized (AllDebridCredentialsHelper.class) {
            synchronized (AllDebridCredentialsHelper.class) {
                e(allDebridCredentialsInfo.getApikey(), allDebridCredentialsInfo.getExpires_in());
            }
        }
    }

    public static synchronized void e(String str, long j2) {
        synchronized (AllDebridCredentialsHelper.class) {
            synchronized (AllDebridCredentialsHelper.class) {
                try {
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putString("all_debrid_access_token", str);
                    edit.putLong("all_debrid_expired_in", j2);
                    edit.apply();
                    if (f33790a == null) {
                        f33790a = new AllDebridCredentialsInfo();
                    }
                    f33790a.setApiKey(str, j2);
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }
}
