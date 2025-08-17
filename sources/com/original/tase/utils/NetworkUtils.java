package com.original.tase.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import com.utils.Utils;

public class NetworkUtils {
    public static boolean a() {
        Context v2 = Utils.v();
        if (v2 == null) {
            return false;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) v2.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null && (networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3))) {
                    return true;
                }
            } else {
                try {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                        Log.i("update_statut", "Network is available : true");
                        return true;
                    }
                } catch (Exception e2) {
                    Log.i("update_statut", "" + e2.getMessage());
                }
            }
        }
        Log.i("update_statut", "Network is available : FALSE ");
        return false;
    }
}
