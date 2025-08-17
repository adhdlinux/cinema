package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Log;

final class WakeLockManager {

    /* renamed from: a  reason: collision with root package name */
    private final PowerManager f23542a;

    /* renamed from: b  reason: collision with root package name */
    private PowerManager.WakeLock f23543b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23544c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23545d;

    public WakeLockManager(Context context) {
        this.f23542a = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @SuppressLint({"WakelockTimeout"})
    private void c() {
        PowerManager.WakeLock wakeLock = this.f23543b;
        if (wakeLock != null) {
            if (!this.f23544c || !this.f23545d) {
                wakeLock.release();
            } else {
                wakeLock.acquire();
            }
        }
    }

    public void a(boolean z2) {
        if (z2 && this.f23543b == null) {
            PowerManager powerManager = this.f23542a;
            if (powerManager == null) {
                Log.i("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.f23543b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
        }
        this.f23544c = z2;
        c();
    }

    public void b(boolean z2) {
        this.f23545d = z2;
        c();
    }
}
