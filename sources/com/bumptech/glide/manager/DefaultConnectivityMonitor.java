package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.util.Preconditions;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {

    /* renamed from: b  reason: collision with root package name */
    private final Context f16972b;

    /* renamed from: c  reason: collision with root package name */
    final ConnectivityMonitor.ConnectivityListener f16973c;

    /* renamed from: d  reason: collision with root package name */
    boolean f16974d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16975e;

    /* renamed from: f  reason: collision with root package name */
    private final BroadcastReceiver f16976f = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            DefaultConnectivityMonitor defaultConnectivityMonitor = DefaultConnectivityMonitor.this;
            boolean z2 = defaultConnectivityMonitor.f16974d;
            defaultConnectivityMonitor.f16974d = defaultConnectivityMonitor.a(context);
            if (z2 != DefaultConnectivityMonitor.this.f16974d) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + DefaultConnectivityMonitor.this.f16974d);
                }
                DefaultConnectivityMonitor defaultConnectivityMonitor2 = DefaultConnectivityMonitor.this;
                defaultConnectivityMonitor2.f16973c.a(defaultConnectivityMonitor2.f16974d);
            }
        }
    };

    DefaultConnectivityMonitor(Context context, ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.f16972b = context.getApplicationContext();
        this.f16973c = connectivityListener;
    }

    private void b() {
        if (!this.f16975e) {
            this.f16974d = a(this.f16972b);
            try {
                this.f16972b.registerReceiver(this.f16976f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                this.f16975e = true;
            } catch (SecurityException e2) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register", e2);
                }
            }
        }
    }

    private void c() {
        if (this.f16975e) {
            this.f16972b.unregisterReceiver(this.f16976f);
            this.f16975e = false;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) Preconditions.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        b();
    }

    public void onStop() {
        c();
    }
}
