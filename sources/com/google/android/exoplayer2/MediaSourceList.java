package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.j;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
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
    private final PlayerId f23341a;

    /* renamed from: b  reason: collision with root package name */
    private final List<MediaSourceHolder> f23342b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> f23343c = new IdentityHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Object, MediaSourceHolder> f23344d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final MediaSourceListInfoRefreshListener f23345e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<MediaSourceHolder, MediaSourceAndListener> f23346f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<MediaSourceHolder> f23347g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final AnalyticsCollector f23348h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final HandlerWrapper f23349i;

    /* renamed from: j  reason: collision with root package name */
    private ShuffleOrder f23350j = new ShuffleOrder.DefaultShuffleOrder(0);

    /* renamed from: k  reason: collision with root package name */
    private boolean f23351k;

    /* renamed from: l  reason: collision with root package name */
    private TransferListener f23352l;

    private final class ForwardingEventListener implements MediaSourceEventListener, DrmSessionEventListener {

        /* renamed from: b  reason: collision with root package name */
        private final MediaSourceHolder f23353b;

        public ForwardingEventListener(MediaSourceHolder mediaSourceHolder) {
            this.f23353b = mediaSourceHolder;
        }

        private Pair<Integer, MediaSource.MediaPeriodId> V(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            MediaSource.MediaPeriodId mediaPeriodId2 = null;
            if (mediaPeriodId != null) {
                MediaSource.MediaPeriodId c2 = MediaSourceList.n(this.f23353b, mediaPeriodId);
                if (c2 == null) {
                    return null;
                }
                mediaPeriodId2 = c2;
            }
            return Pair.create(Integer.valueOf(MediaSourceList.r(this.f23353b, i2)), mediaPeriodId2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void W(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f23348h.r(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void X(Pair pair) {
            MediaSourceList.this.f23348h.E(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Y(Pair pair) {
            MediaSourceList.this.f23348h.y(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void Z(Pair pair) {
            MediaSourceList.this.f23348h.J(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a0(Pair pair, int i2) {
            MediaSourceList.this.f23348h.G(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b0(Pair pair, Exception exc) {
            MediaSourceList.this.f23348h.C(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c0(Pair pair) {
            MediaSourceList.this.f23348h.H(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f23348h.u(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f23348h.F(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            MediaSourceList.this.f23348h.I(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData, iOException, z2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void g0(Pair pair, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f23348h.v(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) pair.second, loadEventInfo, mediaLoadData);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void h0(Pair pair, MediaLoadData mediaLoadData) {
            MediaSourceList.this.f23348h.B(((Integer) pair.first).intValue(), (MediaSource.MediaPeriodId) Assertions.e((MediaSource.MediaPeriodId) pair.second), mediaLoadData);
        }

        public void B(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new o1(this, V, mediaLoadData));
            }
        }

        public void C(int i2, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new q1(this, V, exc));
            }
        }

        public void E(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new i1(this, V));
            }
        }

        public void F(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new r1(this, V, loadEventInfo, mediaLoadData));
            }
        }

        public void G(int i2, MediaSource.MediaPeriodId mediaPeriodId, int i3) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new n1(this, V, i3));
            }
        }

        public void H(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new p1(this, V));
            }
        }

        public void I(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new k1(this, V, loadEventInfo, mediaLoadData, iOException, z2));
            }
        }

        public void J(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new j1(this, V));
            }
        }

        public void r(int i2, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new l1(this, V, mediaLoadData));
            }
        }

        public void u(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new m1(this, V, loadEventInfo, mediaLoadData));
            }
        }

        public void v(int i2, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new h1(this, V, loadEventInfo, mediaLoadData));
            }
        }

        public void y(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            Pair<Integer, MediaSource.MediaPeriodId> V = V(i2, mediaPeriodId);
            if (V != null) {
                MediaSourceList.this.f23349i.g(new s1(this, V));
            }
        }

        public /* synthetic */ void z(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
            j.a(this, i2, mediaPeriodId);
        }
    }

    private static final class MediaSourceAndListener {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource f23355a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource.MediaSourceCaller f23356b;

        /* renamed from: c  reason: collision with root package name */
        public final ForwardingEventListener f23357c;

        public MediaSourceAndListener(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, ForwardingEventListener forwardingEventListener) {
            this.f23355a = mediaSource;
            this.f23356b = mediaSourceCaller;
            this.f23357c = forwardingEventListener;
        }
    }

    static final class MediaSourceHolder implements MediaSourceInfoHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MaskingMediaSource f23358a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f23359b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final List<MediaSource.MediaPeriodId> f23360c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f23361d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f23362e;

        public MediaSourceHolder(MediaSource mediaSource, boolean z2) {
            this.f23358a = new MaskingMediaSource(mediaSource, z2);
        }

        public Object a() {
            return this.f23359b;
        }

        public Timeline b() {
            return this.f23358a.Z();
        }

        public void c(int i2) {
            this.f23361d = i2;
            this.f23362e = false;
            this.f23360c.clear();
        }
    }

    public interface MediaSourceListInfoRefreshListener {
        void c();
    }

    public MediaSourceList(MediaSourceListInfoRefreshListener mediaSourceListInfoRefreshListener, AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, PlayerId playerId) {
        this.f23341a = playerId;
        this.f23345e = mediaSourceListInfoRefreshListener;
        this.f23348h = analyticsCollector;
        this.f23349i = handlerWrapper;
        this.f23346f = new HashMap<>();
        this.f23347g = new HashSet();
    }

    private void B(int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            MediaSourceHolder remove = this.f23342b.remove(i4);
            this.f23344d.remove(remove.f23359b);
            g(i4, -remove.f23358a.Z().t());
            remove.f23362e = true;
            if (this.f23351k) {
                u(remove);
            }
        }
    }

    private void g(int i2, int i3) {
        while (i2 < this.f23342b.size()) {
            this.f23342b.get(i2).f23361d += i3;
            i2++;
        }
    }

    private void j(MediaSourceHolder mediaSourceHolder) {
        MediaSourceAndListener mediaSourceAndListener = this.f23346f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f23355a.n(mediaSourceAndListener.f23356b);
        }
    }

    private void k() {
        Iterator<MediaSourceHolder> it2 = this.f23347g.iterator();
        while (it2.hasNext()) {
            MediaSourceHolder next = it2.next();
            if (next.f23360c.isEmpty()) {
                j(next);
                it2.remove();
            }
        }
    }

    private void l(MediaSourceHolder mediaSourceHolder) {
        this.f23347g.add(mediaSourceHolder);
        MediaSourceAndListener mediaSourceAndListener = this.f23346f.get(mediaSourceHolder);
        if (mediaSourceAndListener != null) {
            mediaSourceAndListener.f23355a.m(mediaSourceAndListener.f23356b);
        }
    }

    private static Object m(Object obj) {
        return AbstractConcatenatedTimeline.z(obj);
    }

    /* access modifiers changed from: private */
    public static MediaSource.MediaPeriodId n(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i2 = 0; i2 < mediaSourceHolder.f23360c.size(); i2++) {
            if (mediaSourceHolder.f23360c.get(i2).f25796d == mediaPeriodId.f25796d) {
                return mediaPeriodId.c(p(mediaSourceHolder, mediaPeriodId.f25793a));
            }
        }
        return null;
    }

    private static Object o(Object obj) {
        return AbstractConcatenatedTimeline.A(obj);
    }

    private static Object p(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.C(mediaSourceHolder.f23359b, obj);
    }

    /* access modifiers changed from: private */
    public static int r(MediaSourceHolder mediaSourceHolder, int i2) {
        return i2 + mediaSourceHolder.f23361d;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(MediaSource mediaSource, Timeline timeline) {
        this.f23345e.c();
    }

    private void u(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f23362e && mediaSourceHolder.f23360c.isEmpty()) {
            MediaSourceAndListener mediaSourceAndListener = (MediaSourceAndListener) Assertions.e(this.f23346f.remove(mediaSourceHolder));
            mediaSourceAndListener.f23355a.g(mediaSourceAndListener.f23356b);
            mediaSourceAndListener.f23355a.j(mediaSourceAndListener.f23357c);
            mediaSourceAndListener.f23355a.r(mediaSourceAndListener.f23357c);
            this.f23347g.remove(mediaSourceHolder);
        }
    }

    private void x(MediaSourceHolder mediaSourceHolder) {
        MaskingMediaSource maskingMediaSource = mediaSourceHolder.f23358a;
        g1 g1Var = new g1(this);
        ForwardingEventListener forwardingEventListener = new ForwardingEventListener(mediaSourceHolder);
        this.f23346f.put(mediaSourceHolder, new MediaSourceAndListener(maskingMediaSource, g1Var, forwardingEventListener));
        maskingMediaSource.i(Util.y(), forwardingEventListener);
        maskingMediaSource.o(Util.y(), forwardingEventListener);
        maskingMediaSource.k(g1Var, this.f23352l, this.f23341a);
    }

    public Timeline A(int i2, int i3, ShuffleOrder shuffleOrder) {
        boolean z2;
        if (i2 < 0 || i2 > i3 || i3 > q()) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        this.f23350j = shuffleOrder;
        B(i2, i3);
        return i();
    }

    public Timeline C(List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        B(0, this.f23342b.size());
        return f(this.f23342b.size(), list, shuffleOrder);
    }

    public Timeline D(ShuffleOrder shuffleOrder) {
        int q2 = q();
        if (shuffleOrder.getLength() != q2) {
            shuffleOrder = shuffleOrder.e().g(0, q2);
        }
        this.f23350j = shuffleOrder;
        return i();
    }

    public Timeline f(int i2, List<MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        if (!list.isEmpty()) {
            this.f23350j = shuffleOrder;
            for (int i3 = i2; i3 < list.size() + i2; i3++) {
                MediaSourceHolder mediaSourceHolder = list.get(i3 - i2);
                if (i3 > 0) {
                    MediaSourceHolder mediaSourceHolder2 = this.f23342b.get(i3 - 1);
                    mediaSourceHolder.c(mediaSourceHolder2.f23361d + mediaSourceHolder2.f23358a.Z().t());
                } else {
                    mediaSourceHolder.c(0);
                }
                g(i3, mediaSourceHolder.f23358a.Z().t());
                this.f23342b.add(i3, mediaSourceHolder);
                this.f23344d.put(mediaSourceHolder.f23359b, mediaSourceHolder);
                if (this.f23351k) {
                    x(mediaSourceHolder);
                    if (this.f23343c.isEmpty()) {
                        this.f23347g.add(mediaSourceHolder);
                    } else {
                        j(mediaSourceHolder);
                    }
                }
            }
        }
        return i();
    }

    public MediaPeriod h(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Object o2 = o(mediaPeriodId.f25793a);
        MediaSource.MediaPeriodId c2 = mediaPeriodId.c(m(mediaPeriodId.f25793a));
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.e(this.f23344d.get(o2));
        l(mediaSourceHolder);
        mediaSourceHolder.f23360c.add(c2);
        MaskingMediaPeriod W = mediaSourceHolder.f23358a.f(c2, allocator, j2);
        this.f23343c.put(W, mediaSourceHolder);
        k();
        return W;
    }

    public Timeline i() {
        if (this.f23342b.isEmpty()) {
            return Timeline.f23481b;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f23342b.size(); i3++) {
            MediaSourceHolder mediaSourceHolder = this.f23342b.get(i3);
            mediaSourceHolder.f23361d = i2;
            i2 += mediaSourceHolder.f23358a.Z().t();
        }
        return new PlaylistTimeline(this.f23342b, this.f23350j);
    }

    public int q() {
        return this.f23342b.size();
    }

    public boolean s() {
        return this.f23351k;
    }

    public Timeline v(int i2, int i3, int i4, ShuffleOrder shuffleOrder) {
        boolean z2;
        if (i2 < 0 || i2 > i3 || i3 > q() || i4 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        Assertions.a(z2);
        this.f23350j = shuffleOrder;
        if (i2 == i3 || i2 == i4) {
            return i();
        }
        int min = Math.min(i2, i4);
        int max = Math.max(((i3 - i2) + i4) - 1, i3 - 1);
        int i5 = this.f23342b.get(min).f23361d;
        Util.E0(this.f23342b, i2, i3, i4);
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.f23342b.get(min);
            mediaSourceHolder.f23361d = i5;
            i5 += mediaSourceHolder.f23358a.Z().t();
            min++;
        }
        return i();
    }

    public void w(TransferListener transferListener) {
        Assertions.g(!this.f23351k);
        this.f23352l = transferListener;
        for (int i2 = 0; i2 < this.f23342b.size(); i2++) {
            MediaSourceHolder mediaSourceHolder = this.f23342b.get(i2);
            x(mediaSourceHolder);
            this.f23347g.add(mediaSourceHolder);
        }
        this.f23351k = true;
    }

    public void y() {
        for (MediaSourceAndListener next : this.f23346f.values()) {
            try {
                next.f23355a.g(next.f23356b);
            } catch (RuntimeException e2) {
                Log.d("MediaSourceList", "Failed to release child source.", e2);
            }
            next.f23355a.j(next.f23357c);
            next.f23355a.r(next.f23357c);
        }
        this.f23346f.clear();
        this.f23347g.clear();
        this.f23351k = false;
    }

    public void z(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.e(this.f23343c.remove(mediaPeriod));
        mediaSourceHolder.f23358a.l(mediaPeriod);
        mediaSourceHolder.f23360c.remove(((MaskingMediaPeriod) mediaPeriod).f25765b);
        if (!this.f23343c.isEmpty()) {
            k();
        }
        u(mediaSourceHolder);
    }
}
