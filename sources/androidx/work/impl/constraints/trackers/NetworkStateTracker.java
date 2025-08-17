package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.core.net.ConnectivityManagerCompat;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

public class NetworkStateTracker extends ConstraintTracker<NetworkState> {

    /* renamed from: j  reason: collision with root package name */
    static final String f12441j = Logger.f("NetworkStateTracker");

    /* renamed from: g  reason: collision with root package name */
    private final ConnectivityManager f12442g = ((ConnectivityManager) this.f12435b.getSystemService("connectivity"));

    /* renamed from: h  reason: collision with root package name */
    private NetworkStateCallback f12443h;

    /* renamed from: i  reason: collision with root package name */
    private NetworkStateBroadcastReceiver f12444i;

    private class NetworkStateBroadcastReceiver extends BroadcastReceiver {
        NetworkStateBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                Logger.c().a(NetworkStateTracker.f12441j, "Network broadcast received", new Throwable[0]);
                NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
                networkStateTracker.d(networkStateTracker.g());
            }
        }
    }

    private class NetworkStateCallback extends ConnectivityManager.NetworkCallback {
        NetworkStateCallback() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            Logger.c().a(NetworkStateTracker.f12441j, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.d(networkStateTracker.g());
        }

        public void onLost(Network network) {
            Logger.c().a(NetworkStateTracker.f12441j, "Network connection lost", new Throwable[0]);
            NetworkStateTracker networkStateTracker = NetworkStateTracker.this;
            networkStateTracker.d(networkStateTracker.g());
        }
    }

    public NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        if (j()) {
            this.f12443h = new NetworkStateCallback();
        } else {
            this.f12444i = new NetworkStateBroadcastReceiver();
        }
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public void e() {
        if (j()) {
            try {
                Logger.c().a(f12441j, "Registering network callback", new Throwable[0]);
                this.f12442g.registerDefaultNetworkCallback(this.f12443h);
            } catch (IllegalArgumentException | SecurityException e2) {
                Logger.c().b(f12441j, "Received exception while registering network callback", e2);
            }
        } else {
            Logger.c().a(f12441j, "Registering broadcast receiver", new Throwable[0]);
            this.f12435b.registerReceiver(this.f12444i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void f() {
        if (j()) {
            try {
                Logger.c().a(f12441j, "Unregistering network callback", new Throwable[0]);
                this.f12442g.unregisterNetworkCallback(this.f12443h);
            } catch (IllegalArgumentException | SecurityException e2) {
                Logger.c().b(f12441j, "Received exception while unregistering network callback", e2);
            }
        } else {
            Logger.c().a(f12441j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f12435b.unregisterReceiver(this.f12444i);
        }
    }

    /* access modifiers changed from: package-private */
    public NetworkState g() {
        boolean z2;
        NetworkInfo activeNetworkInfo = this.f12442g.getActiveNetworkInfo();
        boolean z3 = true;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            z2 = false;
        } else {
            z2 = true;
        }
        boolean i2 = i();
        boolean a2 = ConnectivityManagerCompat.a(this.f12442g);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z3 = false;
        }
        return new NetworkState(z2, i2, a2, z3);
    }

    /* renamed from: h */
    public NetworkState b() {
        return g();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.f12442g.getNetworkCapabilities(this.f12442g.getActiveNetwork());
            if (networkCapabilities == null || !networkCapabilities.hasCapability(16)) {
                return false;
            }
            return true;
        } catch (SecurityException e2) {
            Logger.c().b(f12441j, "Unable to validate active network", e2);
            return false;
        }
    }
}
