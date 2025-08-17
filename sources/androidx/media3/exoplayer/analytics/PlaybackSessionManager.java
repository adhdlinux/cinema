package androidx.media3.exoplayer.analytics;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaSource;

public interface PlaybackSessionManager {

    public interface Listener {
        void c(AnalyticsListener.EventTime eventTime, String str, String str2);

        void g0(AnalyticsListener.EventTime eventTime, String str, boolean z2);

        void p0(AnalyticsListener.EventTime eventTime, String str);

        void s0(AnalyticsListener.EventTime eventTime, String str);
    }

    String a();

    void b(AnalyticsListener.EventTime eventTime);

    String c(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId);

    void d(AnalyticsListener.EventTime eventTime);

    void e(AnalyticsListener.EventTime eventTime);

    void f(Listener listener);

    void g(AnalyticsListener.EventTime eventTime, int i2);
}
