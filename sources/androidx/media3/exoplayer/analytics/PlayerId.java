package androidx.media3.exoplayer.analytics;

import android.media.metrics.LogSessionId;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import java.util.Objects;

public final class PlayerId {

    /* renamed from: d  reason: collision with root package name */
    public static final PlayerId f5617d;

    /* renamed from: a  reason: collision with root package name */
    public final String f5618a;

    /* renamed from: b  reason: collision with root package name */
    private final LogSessionIdApi31 f5619b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5620c;

    private static final class LogSessionIdApi31 {

        /* renamed from: b  reason: collision with root package name */
        public static final LogSessionIdApi31 f5621b = new LogSessionIdApi31(LogSessionId.LOG_SESSION_ID_NONE);

        /* renamed from: a  reason: collision with root package name */
        public final LogSessionId f5622a;

        public LogSessionIdApi31(LogSessionId logSessionId) {
            this.f5622a = logSessionId;
        }
    }

    static {
        PlayerId playerId;
        if (Util.f4714a < 31) {
            playerId = new PlayerId("");
        } else {
            playerId = new PlayerId(LogSessionIdApi31.f5621b, "");
        }
        f5617d = playerId;
    }

    public PlayerId(String str) {
        Assertions.h(Util.f4714a < 31);
        this.f5618a = str;
        this.f5619b = null;
        this.f5620c = new Object();
    }

    public LogSessionId a() {
        return ((LogSessionIdApi31) Assertions.f(this.f5619b)).f5622a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayerId)) {
            return false;
        }
        PlayerId playerId = (PlayerId) obj;
        if (!Objects.equals(this.f5618a, playerId.f5618a) || !Objects.equals(this.f5619b, playerId.f5619b) || !Objects.equals(this.f5620c, playerId.f5620c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f5618a, this.f5619b, this.f5620c});
    }

    public PlayerId(LogSessionId logSessionId, String str) {
        this(new LogSessionIdApi31(logSessionId), str);
    }

    private PlayerId(LogSessionIdApi31 logSessionIdApi31, String str) {
        this.f5619b = logSessionIdApi31;
        this.f5618a = str;
        this.f5620c = new Object();
    }
}
