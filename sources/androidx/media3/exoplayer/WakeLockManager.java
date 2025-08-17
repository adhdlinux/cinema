package androidx.media3.exoplayer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import androidx.media3.common.util.Log;

final class WakeLockManager {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5531a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f5532b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5533c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5534d;

    public WakeLockManager(Context context) {
        this.f5531a = context.getApplicationContext();
    }

    @SuppressLint({"WakelockTimeout"})
    private void c() {
        PowerManager.WakeLock wakeLock = this.f5532b;
        if (wakeLock != null) {
            if (!this.f5533c || !this.f5534d) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }

    public void a(boolean z2) {
        if (z2 && this.f5532b == null) {
            PowerManager powerManager = (PowerManager) this.f5531a.getSystemService("power");
            if (powerManager == null) {
                Log.h("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.f5532b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.f5533c = z2;
        c();
    }

    public void b(boolean z2) {
        this.f5534d = z2;
        c();
    }
}
