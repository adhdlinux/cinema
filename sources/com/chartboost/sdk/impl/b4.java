package com.chartboost.sdk.impl;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

public abstract class b4 {
    public static final NetworkInfo a(Context context) {
        ConnectivityManager b2;
        Object obj;
        NetworkInfo networkInfo = null;
        if (context == null || (b2 = b(context)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.f40263c;
            obj = Result.b(b2.getActiveNetworkInfo());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            w7.a("Chartboost", "Cannot retrieve active network info: " + e2);
        }
        if (!Result.g(obj)) {
            networkInfo = obj;
        }
        return networkInfo;
    }

    public static final ConnectivityManager b(Context context) {
        Object obj;
        ConnectivityManager connectivityManager = null;
        if (context == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.f40263c;
            Object systemService = context.getSystemService("connectivity");
            Intrinsics.d(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            obj = Result.b((ConnectivityManager) systemService);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            w7.a("Chartboost", "Cannot retrieve connectivity manager: " + e2);
        }
        if (!Result.g(obj)) {
            connectivityManager = obj;
        }
        return connectivityManager;
    }

    public static final boolean c(Context context) {
        NetworkInfo a2 = a(context);
        if (a2 == null || !a2.isConnected() || a2.getType() != 0) {
            return false;
        }
        return true;
    }

    public static final boolean d(Context context) {
        NetworkCapabilities a2;
        NetworkInfo a3 = a(context);
        if (Build.VERSION.SDK_INT >= 23 && (a2 = a(context, (Network) null, 1, (Object) null)) != null) {
            return a2.hasCapability(16);
        }
        if (a3 == null || !a3.isConnected()) {
            return false;
        }
        return true;
    }

    public static final boolean e(Context context) {
        NetworkInfo a2 = a(context);
        if (a2 == null || !a2.isConnected() || a2.getType() != 1) {
            return false;
        }
        return true;
    }

    public static final int f(Context context) {
        NetworkInfo a2 = a(context);
        if (a2 == null || !a2.isConnected()) {
            return 0;
        }
        return a2.getSubtype();
    }

    public static final h8 g(Context context) {
        h8 h8Var;
        NetworkInfo a2 = a(context);
        if (a2 != null) {
            if (a2.isConnected()) {
                h8Var = a(a2.getType(), a2.getSubtype());
            } else {
                h8Var = h8.UNKNOWN;
            }
            if (h8Var != null) {
                return h8Var;
            }
        }
        return h8.UNKNOWN;
    }

    public static /* synthetic */ NetworkCapabilities a(Context context, Network network, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            network = null;
        }
        return a(context, network);
    }

    public static final NetworkCapabilities a(Context context, Network network) {
        ConnectivityManager b2;
        Object obj;
        NetworkCapabilities networkCapabilities = null;
        if (context == null || (b2 = b(context)) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.f40263c;
            if (network == null) {
                network = b2.getActiveNetwork();
            }
            obj = Result.b(b2.getNetworkCapabilities(network));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        Throwable e2 = Result.e(obj);
        if (e2 != null) {
            w7.a("Chartboost", "Cannot retrieve network capabilities: " + e2);
        }
        if (!Result.g(obj)) {
            networkCapabilities = obj;
        }
        return networkCapabilities;
    }

    public static final h8 a(int i2, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return h8.UNKNOWN;
            }
            return h8.WIFI;
        } else if (i3 == 20) {
            return h8.CELLULAR_5G;
        } else {
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return h8.CELLULAR_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return h8.CELLULAR_3G;
                case 13:
                    return h8.CELLULAR_4G;
                default:
                    return h8.CELLULAR_UNKNOWN;
            }
        }
    }
}
