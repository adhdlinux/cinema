package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

public class SystemClock implements Clock {
    protected SystemClock() {
    }

    public long a() {
        return android.os.SystemClock.uptimeMillis();
    }

    public HandlerWrapper b(Looper looper, Handler.Callback callback) {
        return new SystemHandlerWrapper(new Handler(looper, callback));
    }

    public void c() {
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return android.os.SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
