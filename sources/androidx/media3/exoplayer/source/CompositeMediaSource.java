package androidx.media3.exoplayer.source;

import android.os.Handler;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.j;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import java.io.IOException;
import java.util.HashMap;

public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* renamed from: h  reason: collision with root package name */
    private final HashMap<T, MediaSourceAndListener<T>> f6846h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private Handler f6847i;

    /* renamed from: j  reason: collision with root package name */
    private TransferListener f6848j;

    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: b  reason: collision with root package name */
        private final T f6849b;

        /* renamed from: c  reason: collision with root package name */
        private MediaSourceEventListener.EventDispatcher f6850c;

        /* renamed from: d  reason: collision with root package name */
        private DrmSessionEventListener.EventDispatcher f6851d;

        public ForwardingEventListener(T t2) {
            this.f6850c = CompositeMediaSource.this.u((MediaSource.MediaPeriodId) null);
            this.f6851d = CompositeMediaSource.this.s((MediaSource.MediaPeriodId) null);
            this.f6849b = t2;
        }

        private boolean n(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = CompositeMediaSource.this.F(this.f6849b, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int H = CompositeMediaSource.this.H(this.f6849b, i2);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.f6850c;
            if (eventDispatcher.f6976a != H || !Util.c(eventDispatcher.f6977b, mediaPeriodId2)) {
                this.f6850c = CompositeMediaSource.this.t(H, mediaPeriodId2);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f6851d;
            if (eventDispatcher2.f6222a == H && Util.c(eventDispatcher2.f6223b, mediaPeriodId2)) {
                return true;
            }
            this.f6851d = CompositeMediaSource.this.r(H, mediaPeriodId2);
            return true;
        }

        private MediaLoadData p(MediaLoadData mediaLoadData, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaLoadData mediaLoadData2 = mediaLoadData;
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            long G = CompositeMediaSource.this.G(this.f6849b, mediaLoadData2.f6969f, mediaPeriodId2);
            long G2 = CompositeMediaSource.this.G(this.f6849b, mediaLoadData2.f6970g, mediaPeriodId2);
            if (G == mediaLoadData2.f6969f && G2 == mediaLoadData2.f6970g) {
                return mediaLoadData2;
            }
            return new MediaLoadData(mediaLoadData2.f6964a, mediaLoadData2.f6965b, mediaLoadData2.f6966c, mediaLoadData2.f6967d, mediaLoadData2.f6968e, G, G2);
        }

        public void J(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            if (n(i2, mediaPeriodId)) {
                this.f6850c.x(loadEventInfo, p(mediaLoadData, mediaPeriodId), iOException, z2);
            }
        }

        public /* synthetic */ void K(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            j.a(this, i2, mediaPeriodId);
        }

        public void M(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (n(i2, mediaPeriodId)) {
                this.f6851d.i();
            }
        }

        public void N(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (n(i2, mediaPeriodId)) {
                this.f6851d.l(exc);
            }
        }

        public void O(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (n(i2, mediaPeriodId)) {
                this.f6850c.r(loadEventInfo, p(mediaLoadData, mediaPeriodId));
            }
        }

        public void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (n(i2, mediaPeriodId)) {
                this.f6850c.u(loadEventInfo, p(mediaLoadData, mediaPeriodId));
            }
        }

        public void S(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (n(i2, mediaPeriodId)) {
                this.f6850c.i(p(mediaLoadData, mediaPeriodId));
            }
        }

        public void T(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (n(i2, mediaPeriodId)) {
                this.f6851d.j();
            }
        }

        public void Y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (n(i2, mediaPeriodId)) {
                this.f6851d.m();
            }
        }

        public void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (n(i2, mediaPeriodId)) {
                this.f6850c.D(p(mediaLoadData, mediaPeriodId));
            }
        }

        public void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (n(i2, mediaPeriodId)) {
                this.f6850c.A(loadEventInfo, p(mediaLoadData, mediaPeriodId));
            }
        }

        public void y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (n(i2, mediaPeriodId)) {
                this.f6851d.h();
            }
        }

        public void z(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            if (n(i2, mediaPeriodId)) {
                this.f6851d.k(i3);
            }
        }
    }

    private static final class MediaSourceAndListener<T> {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource f6853a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f6854b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeMediaSource<T>.ForwardingEventListener f6855c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, CompositeMediaSource<T>.ForwardingEventListener forwardingEventListener) {
            this.f6853a = mediaSource;
            this.f6854b = mediaSourceCaller;
            this.f6855c = forwardingEventListener;
        }
    }

    protected CompositeMediaSource() {
    }

    /* access modifiers changed from: protected */
    public void B() {
        for (MediaSourceAndListener next : this.f6846h.values()) {
            next.f6853a.p(next.f6854b);
            next.f6853a.g(next.f6855c);
            next.f6853a.k(next.f6855c);
        }
        this.f6846h.clear();
    }

    /* access modifiers changed from: protected */
    public final void D(T t2) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.f(this.f6846h.get(t2));
        mediaSourceAndListener.f6853a.q(mediaSourceAndListener.f6854b);
    }

    /* access modifiers changed from: protected */
    public final void E(T t2) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.f(this.f6846h.get(t2));
        mediaSourceAndListener.f6853a.n(mediaSourceAndListener.f6854b);
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId F(T t2, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    public long G(T t2, long j2, MediaSource.MediaPeriodId mediaPeriodId) {
        return j2;
    }

    /* access modifiers changed from: protected */
    public int H(T t2, int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: J */
    public abstract void I(T t2, MediaSource mediaSource, Timeline timeline);

    /* access modifiers changed from: protected */
    public final void K(T t2, MediaSource mediaSource) {
        Assertions.a(!this.f6846h.containsKey(t2));
        b bVar = new b(this, t2);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(t2);
        this.f6846h.put(t2, new MediaSourceAndListener(mediaSource, bVar, forwardingEventListener));
        mediaSource.f((Handler) Assertions.f(this.f6847i), forwardingEventListener);
        mediaSource.j((Handler) Assertions.f(this.f6847i), forwardingEventListener);
        mediaSource.m(bVar, this.f6848j, x());
        if (!y()) {
            mediaSource.q(bVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void L(T t2) {
        MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.f(this.f6846h.remove(t2));
        mediaSourceAndListener.f6853a.p(mediaSourceAndListener.f6854b);
        mediaSourceAndListener.f6853a.g(mediaSourceAndListener.f6855c);
        mediaSourceAndListener.f6853a.k(mediaSourceAndListener.f6855c);
    }

    public void c() throws IOException {
        for (MediaSourceAndListener<T> mediaSourceAndListener : this.f6846h.values()) {
            mediaSourceAndListener.f6853a.c();
        }
    }

    /* access modifiers changed from: protected */
    public void v() {
        for (MediaSourceAndListener next : this.f6846h.values()) {
            next.f6853a.q(next.f6854b);
        }
    }

    /* access modifiers changed from: protected */
    public void w() {
        for (MediaSourceAndListener next : this.f6846h.values()) {
            next.f6853a.n(next.f6854b);
        }
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        this.f6848j = transferListener;
        this.f6847i = Util.A();
    }
}
