package com.original.tase.debrid.premiumize;

import android.content.SharedPreferences;
import com.movie.FreeMoviesApp;
import com.original.tase.Logger;
import com.original.tase.model.debrid.premiumize.PremiumizeCredentialsInfo;

public class PremiumizeCredentialsHelper {

    /* renamed from: a  reason: collision with root package name */
    private static PremiumizeCredentialsInfo f33793a;

    public static synchronized void a() {
        synchronized (PremiumizeCredentialsHelper.class) {
            synchronized (PremiumizeCredentialsInfo.class) {
                try {
                    f33793a = null;
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putString("premiumize_apikey", (String) null);
                    edit.putString("premiumize_premium_until2", (String) null);
                    edit.apply();
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }

    public static synchronized PremiumizeCredentialsInfo b() {
        PremiumizeCredentialsInfo premiumizeCredentialsInfo;
        synchronized (PremiumizeCredentialsHelper.class) {
            if (f33793a == null) {
                f33793a = new PremiumizeCredentialsInfo();
                try {
                    SharedPreferences p2 = FreeMoviesApp.p();
                    f33793a.setAccessToken(p2.getString("premiumize_apikey", (String) null));
                    f33793a.setPremium_until(p2.getLong("premiumize_premium_until2", 0));
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
            premiumizeCredentialsInfo = f33793a;
        }
        return premiumizeCredentialsInfo;
    }

    public static synchronized void c(PremiumizeCredentialsInfo premiumizeCredentialsInfo) {
        synchronized (PremiumizeCredentialsHelper.class) {
            synchronized (PremiumizeCredentialsInfo.class) {
                d(premiumizeCredentialsInfo.getAccessToken(), premiumizeCredentialsInfo.getPremium_until());
            }
        }
    }

    public static synchronized void d(String str, long j2) {
        synchronized (PremiumizeCredentialsHelper.class) {
            synchronized (PremiumizeCredentialsInfo.class) {
                try {
                    SharedPreferences.Editor edit = FreeMoviesApp.p().edit();
                    edit.putString("premiumize_apikey", str);
                    edit.putLong("premiumize_premium_until2", j2);
                    edit.apply();
                    if (f33793a == null) {
                        f33793a = new PremiumizeCredentialsInfo();
                    }
                    f33793a.setAccessToken(str);
                    f33793a.setPremium_until(j2);
                } catch (Throwable th) {
                    Logger.d(th, new boolean[0]);
                }
            }
        }
    }
}
