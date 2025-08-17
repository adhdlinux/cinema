package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.j;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.HashMap;

public abstract class CompositeMediaSource<T> extends BaseMediaSource {

    /* renamed from: i  reason: collision with root package name */
    private final HashMap<T, MediaSourceAndListener<T>> f25722i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private Handler f25723j;

    /* renamed from: k  reason: collision with root package name */
    private TransferListener f25724k;

    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: b  reason: collision with root package name */
        private final T f25725b;

        /* renamed from: c  reason: collision with root package name */
        private MediaSourceEventListener.EventDispatcher f25726c;

        /* renamed from: d  reason: collision with root package name */
        private DrmSessionEventListener.EventDispatcher f25727d;

        public ForwardingEventListener(T t2) {
            this.f25726c = CompositeMediaSource.this.w((MediaSource.MediaPeriodId) null);
            this.f25727d = CompositeMediaSource.this.u((MediaSource.MediaPeriodId) null);
            this.f25725b = t2;
        }

        private MediaLoadData K(MediaLoadData mediaLoadData) {
            long H = CompositeMediaSource.this.H(this.f25725b, mediaLoadData.f25791f);
            long H2 = CompositeMediaSource.this.H(this.f25725b, mediaLoadData.f25792g);
            if (H == mediaLoadData.f25791f && H2 == mediaLoadData.f25792g) {
                return mediaLoadData;
            }
            return new MediaLoadData(mediaLoadData.f25786a, mediaLoadData.f25787b, mediaLoadData.f25788c, mediaLoadData.f25789d, mediaLoadData.f25790e, H, H2);
        }

        private boolean p(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2;
            if (mediaPeriodId != null) {
                mediaPeriodId2 = CompositeMediaSource.this.G(this.f25725b, mediaPeriodId);
                if (mediaPeriodId2 == null) {
                    return false;
                }
            } else {
                mediaPeriodId2 = null;
            }
            int I = CompositeMediaSource.this.I(this.f25725b, i2);
            MediaSourceEventListener.EventDispatcher eventDispatcher = this.f25726c;
            if (eventDispatcher.f25798a != I || !Util.c(eventDispatcher.f25799b, mediaPeriodId2)) {
                this.f25726c = CompositeMediaSource.this.v(I, mediaPeriodId2, 0);
            }
            DrmSessionEventListener.EventDispatcher eventDispatcher2 = this.f25727d;
            if (eventDispatcher2.f24085a == I && Util.c(eventDispatcher2.f24086b, mediaPeriodId2)) {
                return true;
            }
            this.f25727d = CompositeMediaSource.this.s(I, mediaPeriodId2);
            return true;
        }

        public void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (p(i2, mediaPeriodId)) {
                this.f25726c.E(K(mediaLoadData));
            }
        }

        public void C(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            if (p(i2, mediaPeriodId)) {
                this.f25727d.l(exc);
            }
        }

        public void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (p(i2, mediaPeriodId)) {
                this.f25727d.h();
            }
        }

        public void F(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (p(i2, mediaPeriodId)) {
                this.f25726c.v(loadEventInfo, K(mediaLoadData));
            }
        }

        public void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            if (p(i2, mediaPeriodId)) {
                this.f25727d.k(i3);
            }
        }

        public void H(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (p(i2, mediaPeriodId)) {
                this.f25727d.m();
            }
        }

        public void I(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            if (p(i2, mediaPeriodId)) {
                this.f25726c.y(loadEventInfo, K(mediaLoadData), iOException, z2);
            }
        }

        public void J(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (p(i2, mediaPeriodId)) {
                this.f25727d.j();
            }
        }

        public void r(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            if (p(i2, mediaPeriodId)) {
                this.f25726c.j(K(mediaLoadData));
            }
        }

        public void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (p(i2, mediaPeriodId)) {
                this.f25726c.s(loadEventInfo, K(mediaLoadData));
            }
        }

        public void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            if (p(i2, mediaPeriodId)) {
                this.f25726c.B(loadEventInfo, K(mediaLoadData));
            }
        }

        public void y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            if (p(i2, mediaPeriodId)) {
                this.f25727d.i();
            }
        }

        public /* synthetic */ void z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            j.a(this, i2, mediaPeriodId);
        }
    }

    private static final class MediaSourceAndListener<T> {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource f25729a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f25730b;

        /* renamed from: c  reason: collision with root package name */
        public final CompositeMediaSource<T>.ForwardingEventListener f25731c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, CompositeMediaSource<T>.ForwardingEventListener forwardingEventListener) {
            this.f25729a = mediaSource;
            this.f25730b = mediaSourceCaller;
            this.f25731c = forwardingEventListener;
        }
    }

    protected CompositeMediaSource() {
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        this.f25724k = transferListener;
        this.f25723j = Util.w();
    }

    /* access modifiers changed from: protected */
    public void E() {
        for (MediaSourceAndListener next : this.f25722i.values()) {
            next.f25729a.g(next.f25730b);
            next.f25729a.j(next.f25731c);
            next.f25729a.r(next.f25731c);
        }
        this.f25722i.clear();
    }

    /* access modifiers changed from: protected */
    public MediaSource.MediaPeriodId G(T t2, MediaSource.MediaPeriodId mediaPeriodId) {
        return mediaPeriodId;
    }

    /* access modifiers changed from: protected */
    public long H(T t2, long j2) {
        return j2;
    }

    /* access modifiers changed from: protected */
    public int I(T t2, int i2) {
        return i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public abstract void J(T t2, MediaSource mediaSource, Timeline timeline);

    /* access modifiers changed from: protected */
    public final void L(T t2, MediaSource mediaSource) {
        Assertions.a(!this.f25722i.containsKey(t2));
        a aVar = new a(this, t2);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(t2);
        this.f25722i.put(t2, new MediaSourceAndListener(mediaSource, aVar, forwardingEventListener));
        mediaSource.i((Handler) Assertions.e(this.f25723j), forwardingEventListener);
        mediaSource.o((Handler) Assertions.e(this.f25723j), forwardingEventListener);
        mediaSource.k(aVar, this.f25724k, A());
        if (!B()) {
            mediaSource.n(aVar);
        }
    }

    public void c() throws IOException {
        for (MediaSourceAndListener<T> mediaSourceAndListener : this.f25722i.values()) {
            mediaSourceAndListener.f25729a.c();
        }
    }

    /* access modifiers changed from: protected */
    public void y() {
        for (MediaSourceAndListener next : this.f25722i.values()) {
            next.f25729a.n(next.f25730b);
        }
    }

    /* access modifiers changed from: protected */
    public void z() {
        for (MediaSourceAndListener next : this.f25722i.values()) {
            next.f25729a.m(next.f25730b);
        }
    }
}
