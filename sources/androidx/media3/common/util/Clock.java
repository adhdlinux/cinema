package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;

public interface Clock {

    /* renamed from: a  reason: collision with root package name */
    public static final Clock f4616a = new SystemClock();

    long a();

    HandlerWrapper b(Looper looper, Handler.Callback callback);

    void c();

    long currentTimeMillis();

    long elapsedRealtime();

    long nanoTime();
}
