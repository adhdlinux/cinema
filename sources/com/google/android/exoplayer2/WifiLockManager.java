package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager;
import com.google.android.exoplayer2.util.Log;

final class WifiLockManager {

    /* renamed from: a  reason: collision with root package name */
    private final WifiManager f23546a;

    /* renamed from: b  reason: collision with root package name */
    private WifiManager.WifiLock f23547b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23548c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23549d;

    public WifiLockManager(Context context) {
        this.f23546a = (WifiManager) context.getApplicationContext().getSystemService("wifi");
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f23547b;
        if (wifiLock != null) {
            if (!this.f23548c || !this.f23549d) {
                wifiLock.release();
            } else {
                wifiLock.acquire();
            }
        }
    }

    public void a(boolean z2) {
        if (z2 && this.f23547b == null) {
            WifiManager wifiManager = this.f23546a;
            if (wifiManager == null) {
                Log.i("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.f23547b = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.f23548c = z2;
        c();
    }

    public void b(boolean z2) {
        this.f23549d = z2;
        c();
    }
}
