package androidx.media3.exoplayer.drm;

import android.os.Looper;
import androidx.media3.common.Format;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import com.facebook.ads.AdError;

public interface DrmSessionManager {

    /* renamed from: a  reason: collision with root package name */
    public static final DrmSessionManager f6227a = new DrmSessionManager() {
        public void a(Looper looper, PlayerId playerId) {
        }

        public DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            if (format.f4019r == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
        }

        public int c(Format format) {
            return format.f4019r != null ? 1 : 0;
        }

        public /* synthetic */ DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            return q.a(this, eventDispatcher, format);
        }

        public /* synthetic */ void prepare() {
            q.b(this);
        }

        public /* synthetic */ void release() {
            q.c(this);
        }
    };

    public interface DrmSessionReference {

        /* renamed from: a  reason: collision with root package name */
        public static final DrmSessionReference f6228a = new r();

        void release();
    }

    void a(Looper looper, PlayerId playerId);

    DrmSession b(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    int c(Format format);

    DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    void prepare();

    void release();
}
