package androidx.media3.exoplayer;

import android.content.Context;
import android.net.wifi.WifiManager;
import androidx.media3.common.util.Log;

final class WifiLockManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5535a;

    /* renamed from: b  reason: collision with root package name */
    private WifiManager.WifiLock f5536b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5537c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5538d;

    public WifiLockManager(Context context) {
        this.f5535a = context.getApplicationContext();
    }

    private void c() {
        WifiManager.WifiLock wifiLock = this.f5536b;
        if (wifiLock != null) {
            if (!this.f5537c || !this.f5538d) {
                wifiLock.release();
            } else {
                wifiLock.acquire();
            }
        }
    }

    public void a(boolean z2) {
        if (z2 && this.f5536b == null) {
            WifiManager wifiManager = (WifiManager) this.f5535a.getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                Log.h("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock createWifiLock = wifiManager.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.f5536b = createWifiLock;
            createWifiLock.setReferenceCounted(false);
        }
        this.f5537c = z2;
        c();
    }

    public void b(boolean z2) {
        this.f5538d = z2;
        c();
    }
}
