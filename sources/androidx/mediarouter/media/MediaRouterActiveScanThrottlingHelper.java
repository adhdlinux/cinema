package androidx.mediarouter.media;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.framework.media.NotificationOptions;

class MediaRouterActiveScanThrottlingHelper {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f10642a = new Handler(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    private final Runnable f10643b;

    /* renamed from: c  reason: collision with root package name */
    private long f10644c;

    /* renamed from: d  reason: collision with root package name */
    private long f10645d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10646e;

    MediaRouterActiveScanThrottlingHelper(Runnable runnable) {
        this.f10643b = runnable;
    }

    public boolean a() {
        if (this.f10646e) {
            long j2 = this.f10644c;
            if (j2 > 0) {
                this.f10642a.postDelayed(this.f10643b, j2);
            }
        }
        return this.f10646e;
    }

    public void b(boolean z2, long j2) {
        if (z2) {
            long j3 = this.f10645d;
            if (j3 - j2 < NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
                this.f10644c = Math.max(this.f10644c, (j2 + NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) - j3);
                this.f10646e = true;
            }
        }
    }

    public void c() {
        this.f10644c = 0;
        this.f10646e = false;
        this.f10645d = SystemClock.elapsedRealtime();
        this.f10642a.removeCallbacks(this.f10643b);
    }
}
