package io.reactivex.internal.util;

import com.facebook.common.time.Clock;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicLong;

public final class BackpressureHelper {
    private BackpressureHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static long a(AtomicLong atomicLong, long j2) {
        long j3;
        do {
            j3 = atomicLong.get();
            if (j3 == Clock.MAX_TIME) {
                return Clock.MAX_TIME;
            }
        } while (!atomicLong.compareAndSet(j3, b(j3, j2)));
        return j3;
    }

    public static long b(long j2, long j3) {
        long j4 = j2 + j3;
        return j4 < 0 ? Clock.MAX_TIME : j4;
    }

    public static long c(AtomicLong atomicLong, long j2) {
        long j3;
        long j4;
        do {
            j3 = atomicLong.get();
            if (j3 == Clock.MAX_TIME) {
                return Clock.MAX_TIME;
            }
            j4 = j3 - j2;
            if (j4 < 0) {
                RxJavaPlugins.s(new IllegalStateException("More produced than requested: " + j4));
                j4 = 0;
            }
        } while (!atomicLong.compareAndSet(j3, j4));
        return j4;
    }
}
