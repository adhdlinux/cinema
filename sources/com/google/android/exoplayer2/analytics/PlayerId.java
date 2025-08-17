package com.google.android.exoplayer2.analytics;

import android.media.metrics.LogSessionId;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class PlayerId {

    /* renamed from: b  reason: collision with root package name */
    public static final PlayerId f23627b = (Util.f28808a < 31 ? new PlayerId() : new PlayerId(LogSessionIdApi31.f23629b));

    /* renamed from: a  reason: collision with root package name */
    private final LogSessionIdApi31 f23628a;

    private static final class LogSessionIdApi31 {

        /* renamed from: b  reason: collision with root package name */
        public static final LogSessionIdApi31 f23629b = new LogSessionIdApi31(LogSessionId.LOG_SESSION_ID_NONE);

        /* renamed from: a  reason: collision with root package name */
        public final LogSessionId f23630a;

        public LogSessionIdApi31(LogSessionId logSessionId) {
            this.f23630a = logSessionId;
        }
    }

    public PlayerId() {
        this((LogSessionIdApi31) null);
        Assertions.g(Util.f28808a < 31);
    }

    public LogSessionId a() {
        return ((LogSessionIdApi31) Assertions.e(this.f23628a)).f23630a;
    }

    public PlayerId(LogSessionId logSessionId) {
        this(new LogSessionIdApi31(logSessionId));
    }

    private PlayerId(LogSessionIdApi31 logSessionIdApi31) {
        this.f23628a = logSessionIdApi31;
    }
}
