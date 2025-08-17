package androidx.work.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.core.os.HandlerCompat;
import androidx.work.RunnableScheduler;

public class DefaultRunnableScheduler implements RunnableScheduler {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f12242a = HandlerCompat.a(Looper.getMainLooper());

    public void a(Runnable runnable) {
        this.f12242a.removeCallbacks(runnable);
    }

    public void b(long j2, Runnable runnable) {
        this.f12242a.postDelayed(runnable, j2);
    }
}
