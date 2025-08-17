package com.vungle.ads.internal.util;

import com.facebook.common.time.Clock;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class ConcurrencyTimeoutProvider {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long OPERATION_TIMEOUT = TimeUnit.SECONDS.toMillis(4);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final long getTimeout() {
        return ThreadUtil.INSTANCE.isMainThread() ? OPERATION_TIMEOUT : Clock.MAX_TIME;
    }
}
