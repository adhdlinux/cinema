package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
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

    /* renamed from: w  reason: collision with root package name */
    private static final MediaItem f25820w = new MediaItem.Builder().d("MergingMediaSource").a();

    /* renamed from: l  reason: collision with root package name */
    private final boolean f25821l;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f25822m;

    /* renamed from: n  reason: collision with root package name */
    private final MediaSource[] f25823n;

    /* renamed from: o  reason: collision with root package name */
    private final Timeline[] f25824o;

    /* renamed from: p  reason: collision with root package name */
    private final ArrayList<MediaSource> f25825p;

    /* renamed from: q  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f25826q;

    /* renamed from: r  reason: collision with root package name */
    private final Map<Object, Long> f25827r;

    /* renamed from: s  reason: collision with root package name */
    private final Multimap<Object, ClippingMediaPeriod> f25828s;

    /* renamed from: t  reason: collision with root package name */
    private int f25829t;

    /* renamed from: u  reason: collision with root package name */
    private long[][] f25830u;

    /* renamed from: v  reason: collision with root package name */
    private IllegalMergeException f25831v;

    private static final class ClippedTimeline extends ForwardingTimeline {

        /* renamed from: h  reason: collision with root package name */
        private final long[] f25832h;

        /* renamed from: i  reason: collision with root package name */
        private final long[] f25833i;

        public ClippedTimeline(Timeline timeline, Map<Object, Long> map) {
            super(timeline);
            int t2 = timeline.t();
            this.f25833i = new long[timeline.t()];
            Timeline.Window window = new Timeline.Window();
            for (int i2 = 0; i2 < t2; i2++) {
                this.f25833i[i2] = timeline.r(i2, window).f23524o;
            }
            int m2 = timeline.m();
            this.f25832h = new long[m2];
            Timeline.Period period = new Timeline.Period();
            for (int i3 = 0; i3 < m2; i3++) {
                timeline.k(i3, period, true);
                long longValue = ((Long) Assertions.e(map.get(period.f23493c))).longValue();
                long[] jArr = this.f25832h;
                longValue = longValue == Long.MIN_VALUE ? period.f23495e : longValue;
                jArr[i3] = longValue;
                long j2 = period.f23495e;
                if (j2 != -9223372036854775807L) {
                    long[] jArr2 = this.f25833i;
                    int i4 = period.f23494d;
                    jArr2[i4] = jArr2[i4] - (j2 - longValue);
                }
            }
        }

        public Timeline.Period k(int i2, Timeline.Period period, boolean z2) {
            super.k(i2, period, z2);
            period.f23495e = this.f25832h[i2];
            return period;
        }

        public Timeline.Window s(int i2, Timeline.Window window, long j2) {
            long j3;
            super.s(i2, window, j2);
            long j4 = this.f25833i[i2];
            window.f23524o = j4;
            if (j4 != -9223372036854775807L) {
                long j5 = window.f23523n;
                if (j5 != -9223372036854775807L) {
                    j3 = Math.min(j5, j4);
                    window.f23523n = j3;
                    return window;
                }
            }
            j3 = window.f23523n;
            window.f23523n = j3;
            return window;
        }
    }

    public static final class IllegalMergeException extends IOException {

        /* renamed from: b  reason: collision with root package name */
        public final int f25834b;

        public IllegalMergeException(int i2) {
            this.f25834b = i2;
        }
    }

    public MergingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    private void M() {
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < this.f25829t; i2++) {
            long j2 = -this.f25824o[0].j(i2, period).q();
            int i3 = 1;
            while (true) {
                Timeline[] timelineArr = this.f25824o;
                if (i3 >= timelineArr.length) {
                    break;
                }
                this.f25830u[i2][i3] = j2 - (-timelineArr[i3].j(i2, period).q());
                i3++;
            }
        }
    }

    private void P() {
        Timeline[] timelineArr;
        Timeline.Period period = new Timeline.Period();
        for (int i2 = 0; i2 < this.f25829t; i2++) {
            long j2 = Long.MIN_VALUE;
            int i3 = 0;
            while (true) {
                timelineArr = this.f25824o;
                if (i3 >= timelineArr.length) {
                    break;
                }
                long m2 = timelineArr[i3].j(i2, period).m();
                if (m2 != -9223372036854775807L) {
                    long j3 = m2 + this.f25830u[i2][i3];
                    if (j2 == Long.MIN_VALUE || j3 < j2) {
                        j2 = j3;
                    }
                }
                i3++;
            }
            Object q2 = timelineArr[0].q(i2);
            this.f25827r.put(q2, Long.valueOf(j2));
            for (ClippingMediaPeriod w2 : this.f25828s.get(q2)) {
                w2.w(0, j2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void C(TransferListener transferListener) {
        super.C(transferListener);
        for (int i2 = 0; i2 < this.f25823n.length; i2++) {
            L(Integer.valueOf(i2), this.f25823n[i2]);
        }
    }

    /* access modifiers changed from: protected */
    public void E() {
        super.E();
        Arrays.fill(this.f25824o, (Object) null);
        this.f25829t = -1;
        this.f25831v = null;
        this.f25825p.clear();
        Collections.addAll(this.f25825p, this.f25823n);
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public MediaSource.MediaPeriodId G(Integer num, MediaSource.MediaPeriodId mediaPeriodId) {
        if (num.intValue() == 0) {
            return mediaPeriodId;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: O */
    public void K(Integer num, MediaSource mediaSource, Timeline timeline) {
        if (this.f25831v == null) {
            if (this.f25829t == -1) {
                this.f25829t = timeline.m();
            } else if (timeline.m() != this.f25829t) {
                this.f25831v = new IllegalMergeException(0);
                return;
            }
            if (this.f25830u.length == 0) {
                int i2 = this.f25829t;
                int[] iArr = new int[2];
                iArr[1] = this.f25824o.length;
                iArr[0] = i2;
                this.f25830u = (long[][]) Array.newInstance(Long.TYPE, iArr);
            }
            this.f25825p.remove(mediaSource);
            this.f25824o[num.intValue()] = timeline;
            if (this.f25825p.isEmpty()) {
                if (this.f25821l) {
                    M();
                }
                ClippedTimeline clippedTimeline = this.f25824o[0];
                if (this.f25822m) {
                    P();
                    clippedTimeline = new ClippedTimeline(clippedTimeline, this.f25827r);
                }
                D(clippedTimeline);
            }
        }
    }

    public MediaItem a() {
        MediaSource[] mediaSourceArr = this.f25823n;
        return mediaSourceArr.length > 0 ? mediaSourceArr[0].a() : f25820w;
    }

    public void c() throws IOException {
        IllegalMergeException illegalMergeException = this.f25831v;
        if (illegalMergeException == null) {
            super.c();
            return;
        }
        throw illegalMergeException;
    }

    public MediaPeriod f(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j2) {
        int length = this.f25823n.length;
        MediaPeriod[] mediaPeriodArr = new MediaPeriod[length];
        int f2 = this.f25824o[0].f(mediaPeriodId.f25793a);
        for (int i2 = 0; i2 < length; i2++) {
            mediaPeriodArr[i2] = this.f25823n[i2].f(mediaPeriodId.c(this.f25824o[i2].q(f2)), allocator, j2 - this.f25830u[f2][i2]);
        }
        MergingMediaPeriod mergingMediaPeriod = new MergingMediaPeriod(this.f25826q, this.f25830u[f2], mediaPeriodArr);
        if (!this.f25822m) {
            return mergingMediaPeriod;
        }
        ClippingMediaPeriod clippingMediaPeriod = new ClippingMediaPeriod(mergingMediaPeriod, true, 0, ((Long) Assertions.e(this.f25827r.get(mediaPeriodId.f25793a))).longValue());
        this.f25828s.put(mediaPeriodId.f25793a, clippingMediaPeriod);
        return clippingMediaPeriod;
    }

    public void l(MediaPeriod mediaPeriod) {
        if (this.f25822m) {
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            Iterator<Map.Entry<Object, ClippingMediaPeriod>> it2 = this.f25828s.a().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry next = it2.next();
                if (((ClippingMediaPeriod) next.getValue()).equals(clippingMediaPeriod)) {
                    this.f25828s.remove(next.getKey(), next.getValue());
                    break;
                }
            }
            mediaPeriod = clippingMediaPeriod.f25696b;
        }
        MergingMediaPeriod mergingMediaPeriod = (MergingMediaPeriod) mediaPeriod;
        int i2 = 0;
        while (true) {
            MediaSource[] mediaSourceArr = this.f25823n;
            if (i2 < mediaSourceArr.length) {
                mediaSourceArr[i2].l(mergingMediaPeriod.m(i2));
                i2++;
            } else {
                return;
            }
        }
    }

    public MergingMediaSource(boolean z2, MediaSource... mediaSourceArr) {
        this(z2, false, mediaSourceArr);
    }

    public MergingMediaSource(boolean z2, boolean z3, MediaSource... mediaSourceArr) {
        this(z2, z3, new DefaultCompositeSequenceableLoaderFactory(), mediaSourceArr);
    }

    public MergingMediaSource(boolean z2, boolean z3, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, MediaSource... mediaSourceArr) {
        this.f25821l = z2;
        this.f25822m = z3;
        this.f25823n = mediaSourceArr;
        this.f25826q = compositeSequenceableLoaderFactory;
        this.f25825p = new ArrayList<>(Arrays.asList(mediaSourceArr));
        this.f25829t = -1;
        this.f25824o = new Timeline[mediaSourceArr.length];
        this.f25830u = new long[0][];
        this.f25827r = new HashMap();
        this.f25828s = MultimapBuilder.a().a().e();
    }
}
