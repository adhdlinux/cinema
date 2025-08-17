package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import java.io.IOException;

public interface MediaSource {

    public interface Factory {
        MediaSource a(MediaItem mediaItem);

        Factory b(DrmSessionManagerProvider drmSessionManagerProvider);

        Factory c(LoadErrorHandlingPolicy loadErrorHandlingPolicy);
    }

    public static final class MediaPeriodId extends MediaPeriodId {
        public MediaPeriodId(Object obj) {
            super(obj);
        }

        public MediaPeriodId c(Object obj) {
            return new MediaPeriodId(super.a(obj));
        }

        public MediaPeriodId(Object obj, long j2) {
            super(obj, j2);
        }

        public MediaPeriodId(Object obj, long j2, int i2) {
            super(obj, j2, i2);
        }

        public MediaPeriodId(Object obj, int i2, int i3, long j2) {
            super(obj, i2, i3, j2);
        }

        public MediaPeriodId(MediaPeriodId mediaPeriodId) {
            super(mediaPeriodId);
        }
    }

    public interface MediaSourceCaller {
        void a(MediaSource mediaSource, Timeline timeline);
    }

    MediaItem a();

    void c() throws IOException;

    boolean d();

    Timeline e();

    MediaPeriod f(MediaPeriodId mediaPeriodId, Allocator allocator, long j2);

    void g(MediaSourceCaller mediaSourceCaller);

    void i(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    void j(MediaSourceEventListener mediaSourceEventListener);

    void k(MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId);

    void l(MediaPeriod mediaPeriod);

    void m(MediaSourceCaller mediaSourceCaller);

    void n(MediaSourceCaller mediaSourceCaller);

    void o(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void r(DrmSessionEventListener drmSessionEventListener);
}
