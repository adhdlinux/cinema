package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;

public interface DrmSessionManager {

    /* renamed from: a  reason: collision with root package name */
    public static final DrmSessionManager f24090a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final DrmSessionManager f24091b;

    public interface DrmSessionReference {

        /* renamed from: a  reason: collision with root package name */
        public static final DrmSessionReference f24092a = new r();

        void release();
    }

    static {
        AnonymousClass1 r02 = new DrmSessionManager() {
            public int a(Format format) {
                return format.f23074p != null ? 1 : 0;
            }

            public void b(Looper looper, PlayerId playerId) {
            }

            public DrmSession c(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
                if (format.f23074p == null) {
                    return null;
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), AdError.MEDIAVIEW_MISSING_ERROR_CODE));
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
        f24090a = r02;
        f24091b = r02;
    }

    int a(Format format);

    void b(Looper looper, PlayerId playerId);

    DrmSession c(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    DrmSessionReference d(DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    void prepare();

    void release();
}
