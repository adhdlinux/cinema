package androidx.media3.exoplayer.source;

import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.upstream.Allocator;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class MergingMediaSource extends CompositeMediaSource<Integer> {

    /* renamed from: v  reason: collision with root package name */
    private static final MediaItem f6992v = new MediaItem.Builder().c("MergingMediaSource").a();

    /* renamed from: k  reason: collision with root package name */
    private final boolean f6993k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f6994l;

    /* renamed from: m  reason: collision with root package name */
    private final MediaSource[] f6995m;

    /* renamed from: n  reason: collision with root package name */
    private final Timeline[] f6996n;

    /* renamed from: o  reason: collision with root package name */
    private final ArrayList<MediaSource> f6997o;

    /* renamed from: p  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f6998p;

    /* renamed from: q  reason: collision with root package name */
    private final Map<Object, Long> f6999q;

    /* renamed from: r  reason: collision with root package name */
    private final Multimap<Object, ClippingMediaPeriod> f7000r;

    /* renamed from: s  reason: collision with root package name */
    private int f7001s;

    /* renamed from: t  reason: collision with root package name */
    private long[][] f7002t;

    /* renamed from: u  reason: collision with root package name */
    private IllegalMergeException f7003u;

    private static final class ClippedTimeline extends ForwardingTimeline {

        /* renamed from: f  reason: collision with root package name */
        private final long[] f7004f;

        /* renamed from: g  reason: collision with root package name */
        private final long[] f7005g;

        public ClippedTimeline(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int p2 = timeline.p();
            this.f7005g = new long[timeline.p()];
            Timeline.Window window = new Timeline.Window();
            for (int i2 = 0; i2 < p2; i2++) {
                this.f7005g[i2] = timeline.n(i2, window).f4384m;
            }
            int i3 = timeline.i();
            this.f7004f = new long[i3];
            Timeline.Period period = new Timeline.Period();
            for (int i4 = 0; i4 < i3; i4++) {
                timeline.g(i4, period, true);
                long longValue = ((Long) Assertions.f(map.get(period.f4356b))).longValue();
                long[] jArr = this.f7004f;
                longValue = longValue == Long.MIN_VALUE ? period.f4358d : longValue;
                jArr[i4] = longValue;
                long j2 = period.f4358d;
                if (j2 != -9223372036854775807L) {
                    long[] jArr2 = this.f7005g;
                    int i5 = period.f4357c;
                    jArr2[i5] = jArr2[i5] - (j2 - longValue);
                }
            }
        }

        public Timeline.Period g(int i2, Timeline.Period period, boolean z2) {
            super.g(i2, period, z2);
            period.f4358d = this.f7004f[i2];
            return period;
        }

        public Timeline.Window o(int i2, Timeline.Window window, long j2) {
            long j3;
            super.o(i2, window, j2);
            long j4 = this.f7005g[i2];
            window.f4384m = j4;
            if (j4 != -9223372036854775807L) {
                long j5 = window.f4383l;
                if (j5 != -9223372036854775807L) {
                    j3 = Math.min(j5, j4);
                    window.f4383l = j3;
                    return window;
                }
            }
            j3 = window.f4383l;
            window.f4383l = j3;
            return window;
        }
    }

    public static final class IllegalMergeException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f7006b;

        public IllegalMergeException(int i2) {
            this.f7006b = i2;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void M() {
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < this.f7001s; i2++) {
            long j2 = -this.f6996n[0].f(i2, period).n();
            int i3 = 1;
            while (true) {
                Timeline[] timelineArr = this.f6996n;
                if (i3 >= timelineArr.length) {
                    break;
                }
                this.f7002t[i2][i3] = j2 - (-timelineArr[i3].f(i2, period).n());
                i3++;
            }
        }
    }

    private void P() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < this.f7001s; i2++) {
            long j2 = Long.MIN_VALUE;
            int i3 = 0;
            while (true) {
                timelineArr = this.f6996n;
                if (i3 >= timelineArr.length) {
                    break;
                }
                long j3 = timelineArr[i3].f(i2, period).j();
                if (j3 != -9223372036854775807L) {
                    long j4 = j3 + this.f7002t[i2][i3];
                    if (j2 == Long.MIN_VALUE || j4 < j2) {
                        j2 = j4;
                    }
                }
                i3++;
            }
            Object m2 = timelineArr[0].m(i2);
            this.f6999q.put(m2, Long.valueOf(j2));
            for (ClippingMediaPeriod w2 : this.f7000r.get(m2)) {
                w2.w(0, j2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void B() {
        super.B();
        Arrays.fill(this.f6996n, (Object) null);
        this.f7001s = -1;
        this.f7003u = null;
        this.f6997o.clear();
        Collections.addAll(this.f6997o, this.f6995m);
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public MediaSource.MediaPeriodId F(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: O */
    public void J(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.f7003u == null) {
            if (this.f7001s == -1) {
                this.f7001s = timeline.i();
            } else if (timeline.i() != this.f7001s) {
                this.f7003u = new IllegalMergeException(0);
                return;
            }
            if (this.f7002t.length == 0) {
                int i2 = this.f7001s;
                int[] iArr = new int[2];
                iArr[1] = this.f6996n.length;
                iArr[0] = i2;
                this.f7002t = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.f6997o.remove(mediaSource);
            this.f6996n[num.intValue()] = timeline;
            if (this.f6997o.isEmpty()) {
                if (this.f6993k) {
                    M();
                }
                ClippedTimeline clippedTimeline = this.f6996n[0];
                if (this.f6994l) {
                    P();
                    clippedTimeline = new ClippedTimeline(clippedTimeline, this.f6999q);
                }
                A(clippedTimeline);
            }
        }
    }

    public MediaItem a() {
        MediaSource[] mediaSourceArr = this.f6995m;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].a() : f6992v;
    }

    public void c() throws IOException {
        IllegalMergeException illegalMergeException = this.f7003u;
        if (illegalMergeException == null) {
            super.c();
            return;
        }
        throw illegalMergeException;
    }

    public MediaPeriod i(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int length = this.f6995m.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int b2 = this.f6996n[0].b(mediaPeriodId.f6971a);
        for (int i2 = 0; i2 < length; i2++) {
            mediaPeriodArr[i2] = this.f6995m[i2].i(mediaPeriodId.a(this.f6996n[i2].m(b2)), allocator, j2 - this.f7002t[b2][i2]);
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.f6998p, this.f7002t[b2], mediaPeriodArr);
        if (!this.f6994l) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, true, 0, ((Long) Assertions.f(this.f6999q.get(mediaPeriodId.f6971a))).longValue());
        this.f7000r.put(mediaPeriodId.f6971a, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public void l(MediaPeriod mediaPeriod) {
        if (this.f6994l) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator<Map.Entry<Object, ClippingMediaPeriod>> it2 = this.f7000r.a().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((ClippingMediaPeriod) next.getValue()).equals(clippingMediaPeriod)) {
                    this.f7000r.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.f6820b;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i2 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f6995m;
            if (i2 < mediaSourceArr.length) {
                mediaSourceArr[i2].l(mergingMediaPeriod.r(i2));
                i2++;
            } else {
                return;
            }
        }
    }

    public void o(MediaItem mediaItem) {
        this.f6995m[0].o(mediaItem);
    }

    /* access modifiers changed from: protected */
    public void z(TransferListener transferListener) {
        super.z(transferListener);
        for (int i2 = 0; i2 < this.f6995m.length; i2++) {
            K(Integer.valueOf(i2), this.f6995m[i2]);
        }
    }

    public MergingMediaSource(boolean z2, MediaSource... mediaSourceArr) {
        this(z2, false, mediaSourceArr);
    }

    public MergingMediaSource(boolean z2, boolean z3, MediaSource... mediaSourceArr) {
        this(z2, z3, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z2, boolean z3, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.f6993k = z2;
        this.f6994l = z3;
        this.f6995m = mediaSourceArr;
        this.f6998p = compositeSequenceableLoaderFactory;
        this.f6997o = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.f7001s = -1;
        this.f6996n = new Timeline[mediaSourceArr.length];
        this.f7002t = new long[0][];
        this.f6999q = new HashMap();
        this.f7000r = MultimapBuilder.a().a().e();
    }
}
