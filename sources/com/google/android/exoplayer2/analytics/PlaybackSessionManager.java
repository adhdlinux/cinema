package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.MediaSource;

public interface PlaybackSessionManager {

    public interface Listener {
        void e0(AnalyticsListener.EventTime eventTime, String str, boolean z2);

        void f0(AnalyticsListener.EventTime eventTime, String str);

        void r0(AnalyticsListener.EventTime eventTime, String str);

        void z0(AnalyticsListener.EventTime eventTime, String str, String str2);
    }

    String a();

    void b(Listener listener);

    void c(AnalyticsListener.EventTime eventTime);

    void d(AnalyticsListener.EventTime eventTime);

    void e(AnalyticsListener.EventTime eventTime, int i2);

    void f(AnalyticsListener.EventTime eventTime);

    String g(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId);
}
