package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.bumptech.glide.manager.ConnectivityMonitor;

public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    public ConnectivityMonitor a(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        boolean z2;
        String str;
        if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            if (z2) {
                str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
            } else {
                str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
            }
            Log.d("ConnectivityMonitor", str);
        }
        if (z2) {
            return new DefaultConnectivityMonitor(context, connectivityListener);
        }
        return new NullConnectivityMonitor();
    }
}
