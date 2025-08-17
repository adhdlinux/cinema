package com.google.android.exoplayer2.scheduler;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class RequirementsWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final Context f25673a;

    /* renamed from: b  reason: collision with root package name */
    private final Listener f25674b;

    /* renamed from: c  reason: collision with root package name */
    private final Requirements f25675c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Handler f25676d = Util.y();

    /* renamed from: e  reason: collision with root package name */
    private DeviceStatusChangeReceiver f25677e;

    /* renamed from: f  reason: collision with root package name */
    private int f25678f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public NetworkCallback f25679g;

    private class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                RequirementsWatcher.this.e();
            }
        }
    }

    public interface Listener {
        void a(RequirementsWatcher requirementsWatcher, int i2);
    }

    private final class NetworkCallback extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        private boolean f25681a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f25682b;

        private NetworkCallback() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (RequirementsWatcher.this.f25679g != null) {
                RequirementsWatcher.this.e();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (RequirementsWatcher.this.f25679g != null) {
                RequirementsWatcher.this.g();
            }
        }

        private void e() {
            RequirementsWatcher.this.f25676d.post(new c(this));
        }

        private void f() {
            RequirementsWatcher.this.f25676d.post(new b(this));
        }

        public void onAvailable(Network network) {
            e();
        }

        public void onBlockedStatusChanged(Network network, boolean z2) {
            if (!z2) {
                f();
            }
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean hasCapability = networkCapabilities.hasCapability(16);
            if (!this.f25681a || this.f25682b != hasCapability) {
                this.f25681a = true;
                this.f25682b = hasCapability;
                e();
            } else if (hasCapability) {
                f();
            }
        }

        public void onLost(Network network) {
            e();
        }
    }

    public RequirementsWatcher(Context context, Listener listener, Requirements requirements) {
        this.f25673a = context.getApplicationContext();
        this.f25674b = listener;
        this.f25675c = requirements;
    }

    /* access modifiers changed from: private */
    public void e() {
        int d2 = this.f25675c.d(this.f25673a);
        if (this.f25678f != d2) {
            this.f25678f = d2;
            this.f25674b.a(this, d2);
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        if ((this.f25678f & 3) != 0) {
            e();
        }
    }

    private void h() {
        NetworkCallback networkCallback = new NetworkCallback();
        this.f25679g = networkCallback;
        ((ConnectivityManager) Assertions.e((ConnectivityManager) this.f25673a.getSystemService("connectivity"))).registerDefaultNetworkCallback(networkCallback);
    }

    private void k() {
        ((ConnectivityManager) Assertions.e((ConnectivityManager) this.f25673a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) Assertions.e(this.f25679g));
        this.f25679g = null;
    }

    public Requirements f() {
        return this.f25675c;
    }

    public int i() {
        this.f25678f = this.f25675c.d(this.f25673a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f25675c.k()) {
            if (Util.f28808a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f25675c.f()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f25675c.i()) {
            if (Util.f28808a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f25675c.m()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        DeviceStatusChangeReceiver deviceStatusChangeReceiver = new DeviceStatusChangeReceiver();
        this.f25677e = deviceStatusChangeReceiver;
        this.f25673a.registerReceiver(deviceStatusChangeReceiver, intentFilter, (String) null, this.f25676d);
        return this.f25678f;
    }

    public void j() {
        this.f25673a.unregisterReceiver((BroadcastReceiver) Assertions.e(this.f25677e));
        this.f25677e = null;
        if (Util.f28808a >= 24 && this.f25679g != null) {
            k();
        }
    }
}
