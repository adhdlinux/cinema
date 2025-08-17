package androidx.media3.exoplayer.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.AbstractConcatenatedTimeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Deprecated
public final class ConcatenatingMediaSource extends CompositeMediaSource<MediaSourceHolder> {
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static final MediaItem f6860w = new MediaItem.Builder().g(Uri.EMPTY).a();

    /* renamed from: k  reason: collision with root package name */
    private final List<MediaSourceHolder> f6861k;

    /* renamed from: l  reason: collision with root package name */
    private final Set<HandlerAndRunnable> f6862l;

    /* renamed from: m  reason: collision with root package name */
    private Handler f6863m;

    /* renamed from: n  reason: collision with root package name */
    private final List<MediaSourceHolder> f6864n;

    /* renamed from: o  reason: collision with root package name */
    private final IdentityHashMap<MediaPeriod, MediaSourceHolder> f6865o;

    /* renamed from: p  reason: collision with root package name */
    private final Map<Object, MediaSourceHolder> f6866p;

    /* renamed from: q  reason: collision with root package name */
    private final Set<MediaSourceHolder> f6867q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f6868r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f6869s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f6870t;

    /* renamed from: u  reason: collision with root package name */
    private Set<HandlerAndRunnable> f6871u;

    /* renamed from: v  reason: collision with root package name */
    private ShuffleOrder f6872v;

    private static final class ConcatenatedTimeline extends AbstractConcatenatedTimeline {

        /* renamed from: h  reason: collision with root package name */
        private final int f6873h;

        /* renamed from: i  reason: collision with root package name */
        private final int f6874i;

        /* renamed from: j  reason: collision with root package name */
        private final int[] f6875j;

        /* renamed from: k  reason: collision with root package name */
        private final int[] f6876k;

        /* renamed from: l  reason: collision with root package name */
        private final Timeline[] f6877l;

        /* renamed from: m  reason: collision with root package name */
        private final Object[] f6878m;

        /* renamed from: n  reason: collision with root package name */
        private final HashMap<Object, Integer> f6879n = new HashMap<>();

        public ConcatenatedTimeline(Collection<MediaSourceHolder> collection, ShuffleOrder shuffleOrder, boolean z2) {
            super(z2, shuffleOrder);
            int size = collection.size();
            this.f6875j = new int[size];
            this.f6876k = new int[size];
            this.f6877l = new Timeline[size];
            this.f6878m = new Object[size];
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (MediaSourceHolder next : collection) {
                this.f6877l[i4] = next.f6882a.Z();
                this.f6876k[i4] = i2;
                this.f6875j[i4] = i3;
                i2 += this.f6877l[i4].p();
                i3 += this.f6877l[i4].i();
                Object[] objArr = this.f6878m;
                Object obj = next.f6883b;
                objArr[i4] = obj;
                this.f6879n.put(obj, Integer.valueOf(i4));
                i4++;
            }
            this.f6873h = i2;
            this.f6874i = i3;
        }

        /* access modifiers changed from: protected */
        public int A(int i2) {
            return this.f6876k[i2];
        }

        /* access modifiers changed from: protected */
        public Timeline D(int i2) {
            return this.f6877l[i2];
        }

        public int i() {
            return this.f6874i;
        }

        public int p() {
            return this.f6873h;
        }

        /* access modifiers changed from: protected */
        public int s(Object obj) {
            Integer num = this.f6879n.get(obj);
            if (num == null) {
                return -1;
            }
            return num.intValue();
        }

        /* access modifiers changed from: protected */
        public int t(int i2) {
            return Util.g(this.f6875j, i2 + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public int u(int i2) {
            return Util.g(this.f6876k, i2 + 1, false, false);
        }

        /* access modifiers changed from: protected */
        public Object x(int i2) {
            return this.f6878m[i2];
        }

        /* access modifiers changed from: protected */
        public int z(int i2) {
            return this.f6875j[i2];
        }
    }

    private static final class FakeMediaSource extends BaseMediaSource {
        private FakeMediaSource() {
        }

        /* access modifiers changed from: protected */
        public void B() {
        }

        public MediaItem a() {
            return ConcatenatingMediaSource.f6860w;
        }

        public void c() {
        }

        public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
            throw new UnsupportedOperationException();
        }

        public void l(MediaPeriod mediaPeriod) {
        }

        /* access modifiers changed from: protected */
        public void z(TransferListener transferListener) {
        }
    }

    private static final class HandlerAndRunnable {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f6880a;

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f6881b;

        public HandlerAndRunnable(Handler handler, Runnable runnable) {
            this.f6880a = handler;
            this.f6881b = runnable;
        }

        public void a() {
            this.f6880a.post(this.f6881b);
        }
    }

    static final class MediaSourceHolder {

        /* renamed from: a  reason: collision with root package name */
        public final MaskingMediaSource f6882a;

        /* renamed from: b  reason: collision with root package name */
        public final Object f6883b = new Object();

        /* renamed from: c  reason: collision with root package name */
        public final List<MediaSource.MediaPeriodId> f6884c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        public int f6885d;

        /* renamed from: e  reason: collision with root package name */
        public int f6886e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f6887f;

        public MediaSourceHolder(MediaSource mediaSource, boolean z2) {
            this.f6882a = new MaskingMediaSource(mediaSource, z2);
        }

        public void a(int i2, int i3) {
            this.f6885d = i2;
            this.f6886e = i3;
            this.f6887f = false;
            this.f6884c.clear();
        }
    }

    private static final class MessageData<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f6888a;

        /* renamed from: b  reason: collision with root package name */
        public final T f6889b;

        /* renamed from: c  reason: collision with root package name */
        public final HandlerAndRunnable f6890c;

        public MessageData(int i2, T t2, HandlerAndRunnable handlerAndRunnable) {
            this.f6888a = i2;
            this.f6889b = t2;
            this.f6890c = handlerAndRunnable;
        }
    }

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void Q(int i2, MediaSourceHolder mediaSourceHolder) {
        if (i2 > 0) {
            MediaSourceHolder mediaSourceHolder2 = this.f6864n.get(i2 - 1);
            mediaSourceHolder.a(i2, mediaSourceHolder2.f6886e + mediaSourceHolder2.f6882a.Z().p());
        } else {
            mediaSourceHolder.a(i2, 0);
        }
        U(i2, 1, mediaSourceHolder.f6882a.Z().p());
        this.f6864n.add(i2, mediaSourceHolder);
        this.f6866p.put(mediaSourceHolder.f6883b, mediaSourceHolder);
        K(mediaSourceHolder, mediaSourceHolder.f6882a);
        if (!y() || !this.f6865o.isEmpty()) {
            D(mediaSourceHolder);
        } else {
            this.f6867q.add(mediaSourceHolder);
        }
    }

    private void S(int i2, Collection<MediaSourceHolder> collection) {
        for (MediaSourceHolder Q : collection) {
            Q(i2, Q);
            i2++;
        }
    }

    private void T(int i2, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (handler == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (runnable == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z2 == z3) {
            z4 = true;
        }
        Assertions.a(z4);
        Handler handler2 = this.f6863m;
        for (MediaSource f2 : collection) {
            Assertions.f(f2);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (MediaSource mediaSourceHolder : collection) {
            arrayList.add(new MediaSourceHolder(mediaSourceHolder, this.f6869s));
        }
        this.f6861k.addAll(i2, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(1, new MessageData(i2, arrayList, V(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    private void U(int i2, int i3, int i4) {
        while (i2 < this.f6864n.size()) {
            MediaSourceHolder mediaSourceHolder = this.f6864n.get(i2);
            mediaSourceHolder.f6885d += i3;
            mediaSourceHolder.f6886e += i4;
            i2++;
        }
    }

    private HandlerAndRunnable V(Handler handler, Runnable runnable) {
        if (handler == null || runnable == null) {
            return null;
        }
        HandlerAndRunnable handlerAndRunnable = new HandlerAndRunnable(handler, runnable);
        this.f6862l.add(handlerAndRunnable);
        return handlerAndRunnable;
    }

    private void W() {
        Iterator<MediaSourceHolder> it2 = this.f6867q.iterator();
        while (it2.hasNext()) {
            MediaSourceHolder next = it2.next();
            if (next.f6884c.isEmpty()) {
                D(next);
                it2.remove();
            }
        }
    }

    private synchronized void X(Set<HandlerAndRunnable> set) {
        for (HandlerAndRunnable a2 : set) {
            a2.a();
        }
        this.f6862l.removeAll(set);
    }

    private void Y(MediaSourceHolder mediaSourceHolder) {
        this.f6867q.add(mediaSourceHolder);
        E(mediaSourceHolder);
    }

    private static Object Z(Object obj) {
        return AbstractConcatenatedTimeline.v(obj);
    }

    private static Object b0(Object obj) {
        return AbstractConcatenatedTimeline.w(obj);
    }

    private static Object c0(MediaSourceHolder mediaSourceHolder, Object obj) {
        return AbstractConcatenatedTimeline.y(mediaSourceHolder.f6883b, obj);
    }

    private Handler d0() {
        return (Handler) Assertions.f(this.f6863m);
    }

    /* access modifiers changed from: private */
    public boolean f0(Message message) {
        switch (message.what) {
            case 1:
                MessageData messageData = (MessageData) Util.i(message.obj);
                this.f6872v = this.f6872v.g(messageData.f6888a, ((Collection) messageData.f6889b).size());
                S(messageData.f6888a, (Collection) messageData.f6889b);
                l0(messageData.f6890c);
                break;
            case 2:
                MessageData messageData2 = (MessageData) Util.i(message.obj);
                int i2 = messageData2.f6888a;
                int intValue = ((Integer) messageData2.f6889b).intValue();
                if (i2 == 0 && intValue == this.f6872v.getLength()) {
                    this.f6872v = this.f6872v.e();
                } else {
                    this.f6872v = this.f6872v.a(i2, intValue);
                }
                for (int i3 = intValue - 1; i3 >= i2; i3--) {
                    j0(i3);
                }
                l0(messageData2.f6890c);
                break;
            case 3:
                MessageData messageData3 = (MessageData) Util.i(message.obj);
                ShuffleOrder shuffleOrder = this.f6872v;
                int i4 = messageData3.f6888a;
                ShuffleOrder a2 = shuffleOrder.a(i4, i4 + 1);
                this.f6872v = a2;
                this.f6872v = a2.g(((Integer) messageData3.f6889b).intValue(), 1);
                h0(messageData3.f6888a, ((Integer) messageData3.f6889b).intValue());
                l0(messageData3.f6890c);
                break;
            case 4:
                MessageData messageData4 = (MessageData) Util.i(message.obj);
                this.f6872v = (ShuffleOrder) messageData4.f6889b;
                l0(messageData4.f6890c);
                break;
            case 5:
                n0();
                break;
            case 6:
                X((Set) Util.i(message.obj));
                break;
            default:
                throw new IllegalStateException();
        }
        return true;
    }

    private void g0(MediaSourceHolder mediaSourceHolder) {
        if (mediaSourceHolder.f6887f && mediaSourceHolder.f6884c.isEmpty()) {
            this.f6867q.remove(mediaSourceHolder);
            L(mediaSourceHolder);
        }
    }

    private void h0(int i2, int i3) {
        int min = Math.min(i2, i3);
        int max = Math.max(i2, i3);
        int i4 = this.f6864n.get(min).f6886e;
        List<MediaSourceHolder> list = this.f6864n;
        list.add(i3, list.remove(i2));
        while (min <= max) {
            MediaSourceHolder mediaSourceHolder = this.f6864n.get(min);
            mediaSourceHolder.f6885d = min;
            mediaSourceHolder.f6886e = i4;
            i4 += mediaSourceHolder.f6882a.Z().p();
            min++;
        }
    }

    private void j0(int i2) {
        MediaSourceHolder remove = this.f6864n.remove(i2);
        this.f6866p.remove(remove.f6883b);
        U(i2, -1, -remove.f6882a.Z().p());
        remove.f6887f = true;
        g0(remove);
    }

    private void k0() {
        l0((HandlerAndRunnable) null);
    }

    private void l0(HandlerAndRunnable handlerAndRunnable) {
        if (!this.f6870t) {
            d0().obtainMessage(5).sendToTarget();
            this.f6870t = true;
        }
        if (handlerAndRunnable != null) {
            this.f6871u.add(handlerAndRunnable);
        }
    }

    private void m0(MediaSourceHolder mediaSourceHolder, Timeline timeline) {
        int p2;
        if (mediaSourceHolder.f6885d + 1 < this.f6864n.size() && (p2 = timeline.p() - (this.f6864n.get(mediaSourceHolder.f6885d + 1).f6886e - mediaSourceHolder.f6886e)) != 0) {
            U(mediaSourceHolder.f6885d + 1, 0, p2);
        }
        k0();
    }

    private void n0() {
        this.f6870t = false;
        Set<HandlerAndRunnable> set = this.f6871u;
        this.f6871u = new HashSet();
        A(new ConcatenatedTimeline(this.f6864n, this.f6872v, this.f6868r));
        d0().obtainMessage(6, set).sendToTarget();
    }

    /* access modifiers changed from: protected */
    public synchronized void B() {
        super.B();
        this.f6864n.clear();
        this.f6867q.clear();
        this.f6866p.clear();
        this.f6872v = this.f6872v.e();
        Handler handler = this.f6863m;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f6863m = null;
        }
        this.f6870t = false;
        this.f6871u.clear();
        X(this.f6862l);
    }

    public synchronized void O(int i2, MediaSource mediaSource) {
        T(i2, Collections.singletonList(mediaSource), (Handler) null, (Runnable) null);
    }

    public synchronized void P(MediaSource mediaSource) {
        O(this.f6861k.size(), mediaSource);
    }

    public synchronized void R(Collection<MediaSource> collection) {
        T(this.f6861k.size(), collection, (Handler) null, (Runnable) null);
    }

    public MediaItem a() {
        return f6860w;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a0 */
    public MediaSource.MediaPeriodId F(MediaSourceHolder mediaSourceHolder, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i2 = 0; i2 < mediaSourceHolder.f6884c.size(); i2++) {
            if (mediaSourceHolder.f6884c.get(i2).f6974d == mediaPeriodId.f6974d) {
                return mediaPeriodId.a(c0(mediaSourceHolder, mediaPeriodId.f6971a));
            }
        }
        return null;
    }

    public boolean d() {
        return false;
    }

    public synchronized Timeline e() {
        ShuffleOrder shuffleOrder;
        if (this.f6872v.getLength() != this.f6861k.size()) {
            shuffleOrder = this.f6872v.e().g(0, this.f6861k.size());
        } else {
            shuffleOrder = this.f6872v;
        }
        return new ConcatenatedTimeline(this.f6861k, shuffleOrder, this.f6868r);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e0 */
    public int H(MediaSourceHolder mediaSourceHolder, int i2) {
        return i2 + mediaSourceHolder.f6886e;
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        Object b02 = b0(mediaPeriodId.f6971a);
        MediaSource.MediaPeriodId a2 = mediaPeriodId.a(Z(mediaPeriodId.f6971a));
        MediaSourceHolder mediaSourceHolder = this.f6866p.get(b02);
        if (mediaSourceHolder == null) {
            mediaSourceHolder = new MediaSourceHolder(new FakeMediaSource(), this.f6869s);
            mediaSourceHolder.f6887f = true;
            K(mediaSourceHolder, mediaSourceHolder.f6882a);
        }
        Y(mediaSourceHolder);
        mediaSourceHolder.f6884c.add(a2);
        MaskingMediaPeriod W = mediaSourceHolder.f6882a.i(a2, allocator, j2);
        this.f6865o.put(W, mediaSourceHolder);
        W();
        return W;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i0 */
    public void J(MediaSourceHolder mediaSourceHolder, MediaSource mediaSource, Timeline timeline) {
        m0(mediaSourceHolder, timeline);
    }

    public void l(MediaPeriod mediaPeriod) {
        MediaSourceHolder mediaSourceHolder = (MediaSourceHolder) Assertions.f(this.f6865o.remove(mediaPeriod));
        mediaSourceHolder.f6882a.l(mediaPeriod);
        mediaSourceHolder.f6884c.remove(((MaskingMediaPeriod) mediaPeriod).f6943b);
        if (!this.f6865o.isEmpty()) {
            W();
        }
        g0(mediaSourceHolder);
    }

    /* access modifiers changed from: protected */
    public void v() {
        super.v();
        this.f6867q.clear();
    }

    /* access modifiers changed from: protected */
    public void w() {
    }

    /* access modifiers changed from: protected */
    public synchronized void z(TransferListener transferListener) {
        super.z(transferListener);
        this.f6863m = new Handler(new c(this));
        if (this.f6861k.isEmpty()) {
            n0();
        } else {
            this.f6872v = this.f6872v.g(0, this.f6861k.size());
            S(0, this.f6861k);
            k0();
        }
    }

    public ConcatenatingMediaSource(boolean z2, MediaSource... mediaSourceArr) {
        this(z2, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z2, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        this(z2, false, shuffleOrder, mediaSourceArr);
    }

    public ConcatenatingMediaSource(boolean z2, boolean z3, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource f2 : mediaSourceArr) {
            Assertions.f(f2);
        }
        this.f6872v = shuffleOrder.getLength() > 0 ? shuffleOrder.e() : shuffleOrder;
        this.f6865o = new IdentityHashMap<>();
        this.f6866p = new HashMap();
        this.f6861k = new ArrayList();
        this.f6864n = new ArrayList();
        this.f6871u = new HashSet();
        this.f6862l = new HashSet();
        this.f6867q = new HashSet();
        this.f6868r = z2;
        this.f6869s = z3;
        R(Arrays.asList(mediaSourceArr));
    }
}
