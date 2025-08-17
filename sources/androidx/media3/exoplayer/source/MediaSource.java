package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import androidx.media3.extractor.text.SubtitleParser;
import java.io.IOException;

public interface MediaSource {

    public interface Factory {
        Factory a(SubtitleParser.Factory factory);

        @Deprecated
        Factory b(boolean z2);

        MediaSource c(MediaItem mediaItem);

        Factory d(DrmSessionManagerProvider drmSessionManagerProvider);

        Factory e(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

        Factory f(CmcdConfiguration.Factory factory);
    }

    public static final class MediaPeriodId {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6971a;

        /* renamed from: b  reason: collision with root package name */
        public final int f6972b;

        /* renamed from: c  reason: collision with root package name */
        public final int f6973c;

        /* renamed from: d  reason: collision with root package name */
        public final long f6974d;

        /* renamed from: e  reason: collision with root package name */
        public final int f6975e;

        public MediaPeriodId(Object obj) {
            this(obj, -1);
        }

        public MediaPeriodId a(Object obj) {
            if (this.f6971a.equals(obj)) {
                return this;
            }
            return new MediaPeriodId(obj, this.f6972b, this.f6973c, this.f6974d, this.f6975e);
        }

        public boolean b() {
            return this.f6972b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaPeriodId)) {
                return false;
            }
            MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
            if (this.f6971a.equals(mediaPeriodId.f6971a) && this.f6972b == mediaPeriodId.f6972b && this.f6973c == mediaPeriodId.f6973c && this.f6974d == mediaPeriodId.f6974d && this.f6975e == mediaPeriodId.f6975e) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((527 + this.f6971a.hashCode()) * 31) + this.f6972b) * 31) + this.f6973c) * 31) + ((int) this.f6974d)) * 31) + this.f6975e;
        }

        public MediaPeriodId(Object obj, long j2) {
            this(obj, -1, -1, j2, -1);
        }

        public MediaPeriodId(Object obj, long j2, int i2) {
            this(obj, -1, -1, j2, i2);
        }

        public MediaPeriodId(Object obj, int i2, int i3, long j2) {
            this(obj, i2, i3, j2, -1);
        }

        private MediaPeriodId(Object obj, int i2, int i3, long j2, int i4) {
            this.f6971a = obj;
            this.f6972b = i2;
            this.f6973c = i3;
            this.f6974d = j2;
            this.f6975e = i4;
        }
    }

    public interface MediaSourceCaller {
        void a(MediaSource mediaSource, Timeline timeline);
    }

    MediaItem a();

    void c() throws IOException;

    boolean d();

    Timeline e();

    void f(Handler handler, MediaSourceEventListener mediaSourceEventListener);

    void g(MediaSourceEventListener mediaSourceEventListener);

    MediaPeriod i(MediaPeriodId mediaPeriodId, Allocator allocator, long j2);

    void j(Handler handler, DrmSessionEventListener drmSessionEventListener);

    void k(DrmSessionEventListener drmSessionEventListener);

    void l(MediaPeriod mediaPeriod);

    void m(MediaSourceCaller mediaSourceCaller, TransferListener transferListener, PlayerId playerId);

    void n(MediaSourceCaller mediaSourceCaller);

    void o(MediaItem mediaItem);

    void p(MediaSourceCaller mediaSourceCaller);

    void q(MediaSourceCaller mediaSourceCaller);
}
