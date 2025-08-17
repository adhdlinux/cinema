package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import androidx.media3.exoplayer.drm.j;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MaskingMediaPeriod;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class MediaSourceList {

    /* renamed from: a  reason: collision with root package name */
    private final PlayerId f5441a;

    /* renamed from: b  reason: collision with root package name */
    private final List<MediaSourceHolder> f5442b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> f5443c = new IdentityHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, MediaSourceHolder> f5444d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final MediaSourceListInfoRefreshListener f5445e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> f5446f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<MediaSourceHolder> f5447g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AnalyticsCollector f5448h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final HandlerWrapper f5449i;

    /* renamed from: j  reason: collision with root package name */
    private ShuffleOrder f5450j = new ShuffleOrder.DefaultShuffleOrder(0);

    /* renamed from: k  reason: collision with root package name */
    private boolean f5451k;

    /* renamed from: l  reason: collision with root package name */
    private TransferListener f5452l;

    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: b  reason: collision with root package name */
        private final MediaSourceHolder f5453b;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.f5453b = mediaSourceHolder;
        }

        private Pair<Integer, MediaSource.MediaPeriodId> V(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId c2 = MediaSourceList.n(this.f5453b, mediaPeriodId);
                if (c2 == null) {
                    return null;
                }
                mediaPeriodId2 = c2;
            }
            return Pair.create(Integer.valueOf(MediaSourceList.s(this.f5453b, i2)), mediaPeriodId2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void W(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f5448h.S(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void X(Pair pair) {
            MediaSourceList.this.f5448h.y(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a0(Pair pair) {
            MediaSourceList.this.f5448h.M(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b0(Pair pair) {
            MediaSourceList.this.f5448h.T(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c0(Pair pair, int i2) {
            MediaSourceList.this.f5448h.z(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d0(Pair pair, Exception exc) {
            MediaSourceList.this.f5448h.N(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e0(Pair pair) {
            MediaSourceList.this.f5448h.Y(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f5448h.O(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f5448h.R(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            MediaSourceList.this.f5448h.J(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f5448h.v(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void j0(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f5448h.u(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) Assertions.f((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
        }

        public void J(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new v0(this, V, loadEventInfo, mediaLoadData, iOException, z2));
            }
        }

        public /* synthetic */ void K(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            j.a(this, i2, mediaPeriodId);
        }

        public void M(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new w0(this, V));
            }
        }

        public void N(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new l0(this, V, exc));
            }
        }

        public void O(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new q0(this, V, loadEventInfo, mediaLoadData));
            }
        }

        public void R(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new p0(this, V, loadEventInfo, mediaLoadData));
            }
        }

        public void S(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new r0(this, V, mediaLoadData));
            }
        }

        public void T(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new m0(this, V));
            }
        }

        public void Y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new u0(this, V));
            }
        }

        public void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new o0(this, V, mediaLoadData));
            }
        }

        public void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new t0(this, V, loadEventInfo, mediaLoadData));
            }
        }

        public void y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new n0(this, V));
            }
        }

        public void z(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f5449i.g(new s0(this, V, i3));
            }
        }
    }

    private static final class MediaSourceAndListener {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource f5455a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f5456b;

        /* renamed from: c  reason: collision with root package name */
        public final ForwardingEventListener f5457c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.f5455a = mediaSource;
            this.f5456b = mediaSourceCaller;
            this.f5457c = forwardingEventListener;
        }
    }

    static final class MediaSourceHolder implements MediaSourceInfoHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MaskingMediaSource f5458a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f5459b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final List<MediaSource.MediaPeriodId> f5460c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f5461d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f5462e;

        public MediaSourceHolder(MediaSource mediaSource, boolean z2) {
            this.f5458a = new MaskingMediaSource(mediaSource, z2);
        }

        public Object a() {
            return this.f5459b;
        }

        public Timeline b() {
            return this.f5458a.Z();
        }

        public void c(int i2) {
            this.f5461d = i2;
            this.f5462e = false;
            this.f5460c.clear();
        }
    }

    public interface MediaSourceListInfoRefreshListener {
        void c();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId) {
        this.f5441a = playerId;
        this.f5445e = mediaSourceListInfoRefreshListener;
        this.f5448h = analyticsCollector;
        this.f5449i = handlerWrapper;
        this.f5446f = new HashMap<>();
        this.f5447g = new HashSet();
    }

    private void C(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            MediaSourceHolder remove = this.f5442b.remove(i4);
            this.f5444d.remove(remove.f5459b);
            g(i4, -remove.f5458a.Z().p());
            remove.f5462e = true;
            if (this.f5451k) {
                v(remove);
            }
        }
    }

    private void g(int i2, int i3) {
        while (i2 < this.f5442b.size()) {
            this.f5442b.get(i2).f5461d += i3;
            i2++;
        }
    }

    private void j(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = this.f5446f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f5455a.q(mediaSourceAndListener.f5456b);
        }
    }

    private void k() {
        Iterator<MediaSourceHolder> it2 = this.f5447g.iterator();
        while (it2.hasNext()) {
            MediaSourceHolder next = it2.next();
            if (next.f5460c.isEmpty()) {
                j(next);
                it2.remove();
            }
        }
    }

    private void l(MediaSourceHolder mediaSourceHolder) {
        this.f5447g.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.f5446f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f5455a.n(mediaSourceAndListener.f5456b);
        }
    }

    private static Object m(Object obj) {
        return AbstractConcatenatedTimeline.v(obj);
    }

    /* access modifiers changed from: private */
    public static MediaSource.MediaPeriodId n(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i2 = 0; i2 < mediaSourceHolder.f5460c.size(); i2++) {
            if (mediaSourceHolder.f5460c.get(i2).f6974d == mediaPeriodId.f6974d) {
                return mediaPeriodId.a(p(mediaSourceHolder, mediaPeriodId.f6971a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return AbstractConcatenatedTimeline.w(obj);
    }

    private static Object p(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.y(mediaSourceHolder.f5459b, obj);
    }

    /* access modifiers changed from: private */
    public static int s(MediaSourceHolder mediaSourceHolder, int i2) {
        return i2 + mediaSourceHolder.f5461d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(MediaSource mediaSource, Timeline timeline) {
        this.f5445e.c();
    }

    private void v(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f5462e && mediaSourceHolder.f5460c.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.f(this.f5446f.remove(mediaSourceHolder));
            mediaSourceAndListener.f5455a.p(mediaSourceAndListener.f5456b);
            mediaSourceAndListener.f5455a.g(mediaSourceAndListener.f5457c);
            mediaSourceAndListener.f5455a.k(mediaSourceAndListener.f5457c);
            this.f5447g.remove(mediaSourceHolder);
        }
    }

    private void y(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.f5458a;
        k0 k0Var = new k0(this);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.f5446f.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, k0Var, forwardingEventListener));
        maskingMediaSource.f(Util.C(), forwardingEventListener);
        maskingMediaSource.j(Util.C(), forwardingEventListener);
        maskingMediaSource.m(k0Var, this.f5452l, this.f5441a);
    }

    public void A(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.f(this.f5443c.remove(mediaPeriod));
        mediaSourceHolder.f5458a.l(mediaPeriod);
        mediaSourceHolder.f5460c.remove(((MaskingMediaPeriod) mediaPeriod).f6943b);
        if (!this.f5443c.isEmpty()) {
            k();
        }
        v(mediaSourceHolder);
    }

    public Timeline B(int i2, int i3, ShuffleOrder shuffleOrder) {
        boolean z2;
        if (i2 < 0 || i2 > i3 || i3 > r()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        this.f5450j = shuffleOrder;
        C(i2, i3);
        return i();
    }

    public Timeline D(List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        C(0, this.f5442b.size());
        return f(this.f5442b.size(), list, shuffleOrder);
    }

    public Timeline E(ShuffleOrder shuffleOrder) {
        int r2 = r();
        if (shuffleOrder.getLength() != r2) {
            shuffleOrder = shuffleOrder.e().g(0, r2);
        }
        this.f5450j = shuffleOrder;
        return i();
    }

    public Timeline F(int i2, int i3, List<MediaItem> list) {
        boolean z2;
        boolean z3 = false;
        if (i2 < 0 || i2 > i3 || i3 > r()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        if (list.size() == i3 - i2) {
            z3 = true;
        }
        Assertions.a(z3);
        for (int i4 = i2; i4 < i3; i4++) {
            this.f5442b.get(i4).f5458a.o(list.get(i4 - i2));
        }
        return i();
    }

    public Timeline f(int i2, List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.f5450j = shuffleOrder;
            for (int i3 = i2; i3 < list.size() + i2; i3++) {
                MediaSourceHolder mediaSourceHolder = list.get(i3 - i2);
                if (i3 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.f5442b.get(i3 - 1);
                    mediaSourceHolder.c(mediaSourceHolder2.f5461d + mediaSourceHolder2.f5458a.Z().p());
                } else {
                    mediaSourceHolder.c(0);
                }
                g(i3, mediaSourceHolder.f5458a.Z().p());
                this.f5442b.add(i3, mediaSourceHolder);
                this.f5444d.put(mediaSourceHolder.f5459b, mediaSourceHolder);
                if (this.f5451k) {
                    y(mediaSourceHolder);
                    if (this.f5443c.isEmpty()) {
                        this.f5447g.add(mediaSourceHolder);
                    } else {
                        j(mediaSourceHolder);
                    }
                }
            }
        }
        return i();
    }

    public MediaPeriod h(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Object o2 = o(mediaPeriodId.f6971a);
        MediaSource.MediaPeriodId a2 = mediaPeriodId.a(m(mediaPeriodId.f6971a));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.f(this.f5444d.get(o2));
        l(mediaSourceHolder);
        mediaSourceHolder.f5460c.add(a2);
        MaskingMediaPeriod W = mediaSourceHolder.f5458a.i(a2, allocator, j2);
        this.f5443c.put(W, mediaSourceHolder);
        k();
        return W;
    }

    public Timeline i() {
        if (this.f5442b.isEmpty()) {
            return Timeline.f4346a;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f5442b.size(); i3++) {
            MediaSourceHolder mediaSourceHolder = this.f5442b.get(i3);
            mediaSourceHolder.f5461d = i2;
            i2 += mediaSourceHolder.f5458a.Z().p();
        }
        return new PlaylistTimeline(this.f5442b, this.f5450j);
    }

    public ShuffleOrder q() {
        return this.f5450j;
    }

    public int r() {
        return this.f5442b.size();
    }

    public boolean t() {
        return this.f5451k;
    }

    public Timeline w(int i2, int i3, int i4, ShuffleOrder shuffleOrder) {
        boolean z2;
        if (i2 < 0 || i2 > i3 || i3 > r() || i4 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        this.f5450j = shuffleOrder;
        if (i2 == i3 || i2 == i4) {
            return i();
        }
        int min = Math.min(i2, i4);
        int max = Math.max(((i3 - i2) + i4) - 1, i3 - 1);
        int i5 = this.f5442b.get(min).f5461d;
        Util.O0(this.f5442b, i2, i3, i4);
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.f5442b.get(min);
            mediaSourceHolder.f5461d = i5;
            i5 += mediaSourceHolder.f5458a.Z().p();
            min++;
        }
        return i();
    }

    public void x(TransferListener transferListener) {
        Assertions.h(!this.f5451k);
        this.f5452l = transferListener;
        for (int i2 = 0; i2 < this.f5442b.size(); i2++) {
            MediaSourceHolder mediaSourceHolder = this.f5442b.get(i2);
            y(mediaSourceHolder);
            this.f5447g.add(mediaSourceHolder);
        }
        this.f5451k = true;
    }

    public void z() {
        for (MediaSourceAndListener next : this.f5446f.values()) {
            try {
                next.f5455a.p(next.f5456b);
            } catch (RuntimeException e2) {
                Log.d("MediaSourceList", "Failed to release child source.", e2);
            }
            next.f5455a.g(next.f5457c);
            next.f5455a.k(next.f5457c);
        }
        this.f5446f.clear();
        this.f5447g.clear();
        this.f5451k = false;
    }
}
