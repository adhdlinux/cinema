package com.startapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class r8 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f35764a;

    /* renamed from: b  reason: collision with root package name */
    public final ConnectivityManager.NetworkCallback f35765b;

    /* renamed from: c  reason: collision with root package name */
    public final ConnectivityManager.OnNetworkActiveListener f35766c;

    /* renamed from: d  reason: collision with root package name */
    public final List<ua<Void>> f35767d = new LinkedList();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f35768e = new AtomicBoolean(false);

    public class a extends ConnectivityManager.NetworkCallback {
        public a() {
        }

        public void onAvailable(Network network) {
            r8 r8Var = r8.this;
            synchronized (r8Var) {
                for (ua<Void> call : r8Var.f35767d) {
                    call.call();
                }
            }
        }
    }

    public class b implements ConnectivityManager.OnNetworkActiveListener {
        public b() {
        }

        public void onNetworkActive() {
            r8 r8Var = r8.this;
            synchronized (r8Var) {
                for (ua<Void> call : r8Var.f35767d) {
                    call.call();
                }
            }
        }
    }

    public r8(Context context) {
        this.f35764a = context;
        if (Build.VERSION.SDK_INT >= 24) {
            this.f35765b = new a();
            this.f35766c = null;
            return;
        }
        this.f35765b = null;
        this.f35766c = new b();
    }

    public boolean a() {
        if (hc.a(this.f35764a, "android.permission.ACCESS_NETWORK_STATE")) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) this.f35764a.getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        return false;
                    }
                    return true;
                }
            } catch (Throwable th) {
                y8.a(this.f35764a, th);
            }
        }
        return true;
    }
}
