package com.original.tase.debrid.realdebrid;

import android.content.SharedPreferences;
import com.movie.FreeMoviesApp;
import com.original.tase.Logger;
import com.original.tase.model.debrid.realdebrid.RealDebridCredentialsInfo;
import com.utils.Utils;

public class RealDebridCredentialsHelper {

    /* renamed from: a  reason: collision with root package name */
    public static RealDebridCredentialsInfo f33798a = null;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f33799b = false;

    public static void a() {
        f33799b = !Utils.l(Utils.RDTYPE.REAL_DEBRID);
    }

    public static synchronized void b() {
        synchronized (RealDebridCredentialsHelper.class) {
            synchronized (RealDebridCredentialsHelper.class) {
                try {
                    f33798a = null;
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putString("real_debrid_access_token", (String) null);
                    edit.putString("real_debrid_refresh_token", (String) null);
                    edit.putString("real_debrid_client_secret", (String) null);
                    edit.putString("real_debrid_last_clientID", (String) null);
                    edit.apply();
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }

    public static boolean c() {
        return f33799b;
    }

    public static synchronized RealDebridCredentialsInfo d() {
        RealDebridCredentialsInfo realDebridCredentialsInfo;
        synchronized (RealDebridCredentialsHelper.class) {
            if (f33798a == null) {
                f33798a = new RealDebridCredentialsInfo();
                try {
                    SharedPreferences p2 = FreeMoviesApp.p();
                    f33798a.setAccessToken(p2.getString("real_debrid_access_token", (String) null));
                    f33798a.setRefreshToken(p2.getString("real_debrid_refresh_token", (String) null));
                    f33798a.setClientId(p2.getString("real_debrid_last_clientID", (String) null));
                    f33798a.setClientSecret(p2.getString("real_debrid_client_secret", (String) null));
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
            realDebridCredentialsInfo = f33798a;
        }
        return realDebridCredentialsInfo;
    }

    public static synchronized void e(RealDebridCredentialsInfo realDebridCredentialsInfo) {
        synchronized (RealDebridCredentialsHelper.class) {
            synchronized (RealDebridCredentialsHelper.class) {
                f(realDebridCredentialsInfo.getAccessToken(), realDebridCredentialsInfo.getRefreshToken(), realDebridCredentialsInfo.getClientId(), realDebridCredentialsInfo.getClientSecret());
            }
        }
    }

    public static synchronized void f(String str, String str2, String str3, String str4) {
        synchronized (RealDebridCredentialsHelper.class) {
            synchronized (RealDebridCredentialsHelper.class) {
                try {
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putString("real_debrid_access_token", str);
                    edit.putString("real_debrid_refresh_token", str2);
                    edit.putString("real_debrid_last_clientID", str3);
                    edit.putString("real_debrid_client_secret", str4);
                    edit.apply();
                    if (f33798a == null) {
                        f33798a = new RealDebridCredentialsInfo();
                    }
                    f33798a.setAccessToken(str);
                    f33798a.setRefreshToken(str2);
                    f33798a.setClientId(str3);
                    f33798a.setClientSecret(str4);
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }
}
