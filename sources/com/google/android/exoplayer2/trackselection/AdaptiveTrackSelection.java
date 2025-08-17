package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {

    /* renamed from: h  reason: collision with root package name */
    private final BandwidthMeter f27624h;

    /* renamed from: i  reason: collision with root package name */
    private final long f27625i;

    /* renamed from: j  reason: collision with root package name */
    private final long f27626j;

    /* renamed from: k  reason: collision with root package name */
    private final long f27627k;

    /* renamed from: l  reason: collision with root package name */
    private final int f27628l;

    /* renamed from: m  reason: collision with root package name */
    private final int f27629m;

    /* renamed from: n  reason: collision with root package name */
    private final float f27630n;

    /* renamed from: o  reason: collision with root package name */
    private final float f27631o;

    /* renamed from: p  reason: collision with root package name */
    private final ImmutableList<AdaptationCheckpoint> f27632p;

    /* renamed from: q  reason: collision with root package name */
    private final Clock f27633q;

    /* renamed from: r  reason: collision with root package name */
    private float f27634r;

    /* renamed from: s  reason: collision with root package name */
    private int f27635s;

    /* renamed from: t  reason: collision with root package name */
    private int f27636t;

    /* renamed from: u  reason: collision with root package name */
    private long f27637u;

    /* renamed from: v  reason: collision with root package name */
    private MediaChunk f27638v;

    public static final class AdaptationCheckpoint {

        /* renamed from: a  reason: collision with root package name */
        public final long f27639a;

        /* renamed from: b  reason: collision with root package name */
        public final long f27640b;

        public AdaptationCheckpoint(long j2, long j3) {
            this.f27639a = j2;
            this.f27640b = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            if (this.f27639a == adaptationCheckpoint.f27639a && this.f27640b == adaptationCheckpoint.f27640b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.f27639a) * 31) + ((int) this.f27640b);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final int f27641a;

        /* renamed from: b  reason: collision with root package name */
        private final int f27642b;

        /* renamed from: c  reason: collision with root package name */
        private final int f27643c;

        /* renamed from: d  reason: collision with root package name */
        private final int f27644d;

        /* renamed from: e  reason: collision with root package name */
        private final int f27645e;

        /* renamed from: f  reason: collision with root package name */
        private final float f27646f;

        /* renamed from: g  reason: collision with root package name */
        private final float f27647g;

        /* renamed from: h  reason: collision with root package name */
        private final Clock f27648h;

        public Factory() {
            this(10000, 25000, 25000, 0.7f);
        }

        public final ExoTrackSelection[] a(ExoTrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            ExoTrackSelection exoTrackSelection;
            ImmutableList v2 = AdaptiveTrackSelection.z(definitionArr);
            ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
            for (int i2 = 0; i2 < definitionArr.length; i2++) {
                ExoTrackSelection.Definition definition = definitionArr[i2];
                if (definition != null) {
                    int[] iArr = definition.f27746b;
                    if (iArr.length != 0) {
                        if (iArr.length == 1) {
                            exoTrackSelection = new FixedTrackSelection(definition.f27745a, iArr[0], definition.f27747c);
                        } else {
                            exoTrackSelection = b(definition.f27745a, iArr, definition.f27747c, bandwidthMeter, (ImmutableList) v2.get(i2));
                        }
                        exoTrackSelectionArr[i2] = exoTrackSelection;
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        /* access modifiers changed from: protected */
        public AdaptiveTrackSelection b(TrackGroup trackGroup, int[] iArr, int i2, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i2, bandwidthMeter, (long) this.f27641a, (long) this.f27642b, (long) this.f27643c, this.f27644d, this.f27645e, this.f27646f, this.f27647g, immutableList, this.f27648h);
        }

        public Factory(int i2, int i3, int i4, float f2) {
            this(i2, i3, i4, 1279, 719, f2, 0.75f, Clock.f28651a);
        }

        public Factory(int i2, int i3, int i4, int i5, int i6, float f2, float f3, Clock clock) {
            this.f27641a = i2;
            this.f27642b = i3;
            this.f27643c = i4;
            this.f27644d = i5;
            this.f27645e = i6;
            this.f27646f = f2;
            this.f27647g = f3;
            this.f27648h = clock;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i2, BandwidthMeter bandwidthMeter, long j2, long j3, long j4, int i3, int i4, float f2, float f3, List<AdaptationCheckpoint> list, Clock clock) {
        super(trackGroup, iArr, i2);
        BandwidthMeter bandwidthMeter2;
        long j5;
        if (j4 < j2) {
            Log.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter2 = bandwidthMeter;
            j5 = j2;
        } else {
            bandwidthMeter2 = bandwidthMeter;
            j5 = j4;
        }
        this.f27624h = bandwidthMeter2;
        this.f27625i = j2 * 1000;
        this.f27626j = j3 * 1000;
        this.f27627k = j5 * 1000;
        this.f27628l = i3;
        this.f27629m = i4;
        this.f27630n = f2;
        this.f27631o = f3;
        this.f27632p = ImmutableList.n(list);
        this.f27633q = clock;
        this.f27634r = 1.0f;
        this.f27636t = 0;
        this.f27637u = -9223372036854775807L;
    }

    private long A(long j2) {
        long G = G(j2);
        if (this.f27632p.isEmpty()) {
            return G;
        }
        int i2 = 1;
        while (i2 < this.f27632p.size() - 1 && this.f27632p.get(i2).f27639a < G) {
            i2++;
        }
        AdaptationCheckpoint adaptationCheckpoint = this.f27632p.get(i2 - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = this.f27632p.get(i2);
        long j3 = adaptationCheckpoint.f27639a;
        long j4 = adaptationCheckpoint.f27640b;
        return j4 + ((long) ((((float) (G - j3)) / ((float) (adaptationCheckpoint2.f27639a - j3))) * ((float) (adaptationCheckpoint2.f27640b - j4))));
    }

    private long B(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.d(list);
        long j2 = mediaChunk.f26084g;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = mediaChunk.f26085h;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    private long D(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i2 = this.f27635s;
        if (i2 >= mediaChunkIteratorArr.length || !mediaChunkIteratorArr[i2].next()) {
            for (MediaChunkIterator mediaChunkIterator : mediaChunkIteratorArr) {
                if (mediaChunkIterator.next()) {
                    return mediaChunkIterator.b() - mediaChunkIterator.a();
                }
            }
            return B(list);
        }
        MediaChunkIterator mediaChunkIterator2 = mediaChunkIteratorArr[this.f27635s];
        return mediaChunkIterator2.b() - mediaChunkIterator2.a();
    }

    private static long[][] E(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i2 = 0; i2 < definitionArr.length; i2++) {
            ExoTrackSelection.Definition definition = definitionArr[i2];
            if (definition == null) {
                jArr[i2] = new long[0];
            } else {
                jArr[i2] = new long[definition.f27746b.length];
                int i3 = 0;
                while (true) {
                    int[] iArr = definition.f27746b;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    long j2 = (long) definition.f27745a.c(iArr[i3]).f23067i;
                    long[] jArr2 = jArr[i2];
                    if (j2 == -1) {
                        j2 = 0;
                    }
                    jArr2[i3] = j2;
                    i3++;
                }
                Arrays.sort(jArr[i2]);
            }
        }
        return jArr;
    }

    private static ImmutableList<Integer> F(long[][] jArr) {
        double d2;
        ListMultimap<K, V> e2 = MultimapBuilder.c().a().e();
        for (int i2 = 0; i2 < jArr.length; i2++) {
            long[] jArr2 = jArr[i2];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i3 = 0;
                while (true) {
                    long[] jArr3 = jArr[i2];
                    double d3 = 0.0d;
                    if (i3 >= jArr3.length) {
                        break;
                    }
                    long j2 = jArr3[i3];
                    if (j2 != -1) {
                        d3 = Math.log((double) j2);
                    }
                    dArr[i3] = d3;
                    i3++;
                }
                int i4 = length - 1;
                double d4 = dArr[i4] - dArr[0];
                int i5 = 0;
                while (i5 < i4) {
                    double d5 = dArr[i5];
                    i5++;
                    double d6 = (d5 + dArr[i5]) * 0.5d;
                    if (d4 == 0.0d) {
                        d2 = 1.0d;
                    } else {
                        d2 = (d6 - dArr[0]) / d4;
                    }
                    e2.put(Double.valueOf(d2), Integer.valueOf(i2));
                }
            }
        }
        return ImmutableList.n(e2.values());
    }

    private long G(long j2) {
        long c2 = (long) (((float) this.f27624h.c()) * this.f27630n);
        long a2 = this.f27624h.a();
        if (a2 == -9223372036854775807L || j2 == -9223372036854775807L) {
            return (long) (((float) c2) / this.f27634r);
        }
        float f2 = (float) j2;
        return (long) ((((float) c2) * Math.max((f2 / this.f27634r) - ((float) a2), 0.0f)) / f2);
    }

    private long H(long j2, long j3) {
        if (j2 == -9223372036854775807L) {
            return this.f27625i;
        }
        if (j3 != -9223372036854775807L) {
            j2 -= j3;
        }
        return Math.min((long) (((float) j2) * this.f27631o), this.f27625i);
    }

    private static void w(List<ImmutableList.Builder<AdaptationCheckpoint>> list, long[] jArr) {
        long j2 = 0;
        for (long j3 : jArr) {
            j2 += j3;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ImmutableList.Builder builder = list.get(i2);
            if (builder != null) {
                builder.d(new AdaptationCheckpoint(j2, jArr[i2]));
            }
        }
    }

    private int y(long j2, long j3) {
        long A = A(j3);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f27650b; i3++) {
            if (j2 == Long.MIN_VALUE || !p(i3, j2)) {
                Format b2 = b(i3);
                if (x(b2, b2.f23067i, A)) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public static ImmutableList<ImmutableList<AdaptationCheckpoint>> z(ExoTrackSelection.Definition[] definitionArr) {
        ImmutableList immutableList;
        long j2;
        ArrayList arrayList = new ArrayList();
        for (ExoTrackSelection.Definition definition : definitionArr) {
            if (definition == null || definition.f27746b.length <= 1) {
                arrayList.add((Object) null);
            } else {
                ImmutableList.Builder k2 = ImmutableList.k();
                k2.d(new AdaptationCheckpoint(0, 0));
                arrayList.add(k2);
            }
        }
        long[][] E = E(definitionArr);
        int[] iArr = new int[E.length];
        long[] jArr = new long[E.length];
        for (int i2 = 0; i2 < E.length; i2++) {
            long[] jArr2 = E[i2];
            if (jArr2.length == 0) {
                j2 = 0;
            } else {
                j2 = jArr2[0];
            }
            jArr[i2] = j2;
        }
        w(arrayList, jArr);
        ImmutableList<Integer> F = F(E);
        for (int i3 = 0; i3 < F.size(); i3++) {
            int intValue = F.get(i3).intValue();
            int i4 = iArr[intValue] + 1;
            iArr[intValue] = i4;
            jArr[intValue] = E[intValue][i4];
            w(arrayList, jArr);
        }
        for (int i5 = 0; i5 < definitionArr.length; i5++) {
            if (arrayList.get(i5) != null) {
                jArr[i5] = jArr[i5] * 2;
            }
        }
        w(arrayList, jArr);
        ImmutableList.Builder k3 = ImmutableList.k();
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            ImmutableList.Builder builder = (ImmutableList.Builder) arrayList.get(i6);
            if (builder == null) {
                immutableList = ImmutableList.r();
            } else {
                immutableList = builder.k();
            }
            k3.d(immutableList);
        }
        return k3.k();
    }

    /* access modifiers changed from: protected */
    public long C() {
        return this.f27627k;
    }

    /* access modifiers changed from: protected */
    public boolean I(long j2, List<? extends MediaChunk> list) {
        long j3 = this.f27637u;
        if (j3 == -9223372036854775807L || j2 - j3 >= 1000 || (!list.isEmpty() && !((MediaChunk) Iterables.d(list)).equals(this.f27638v))) {
            return true;
        }
        return false;
    }

    public int a() {
        return this.f27635s;
    }

    public void d(float f2) {
        this.f27634r = f2;
    }

    public void disable() {
        this.f27638v = null;
    }

    public Object e() {
        return null;
    }

    public void enable() {
        this.f27637u = -9223372036854775807L;
        this.f27638v = null;
    }

    public int j(long j2, List<? extends MediaChunk> list) {
        MediaChunk mediaChunk;
        int i2;
        int i3;
        long elapsedRealtime = this.f27633q.elapsedRealtime();
        if (!I(elapsedRealtime, list)) {
            return list.size();
        }
        this.f27637u = elapsedRealtime;
        if (list.isEmpty()) {
            mediaChunk = null;
        } else {
            mediaChunk = (MediaChunk) Iterables.d(list);
        }
        this.f27638v = mediaChunk;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long g02 = Util.g0(((MediaChunk) list.get(size - 1)).f26084g - j2, this.f27634r);
        long C = C();
        if (g02 < C) {
            return size;
        }
        Format b2 = b(y(elapsedRealtime, B(list)));
        for (int i4 = 0; i4 < size; i4++) {
            MediaChunk mediaChunk2 = (MediaChunk) list.get(i4);
            Format format = mediaChunk2.f26081d;
            if (Util.g0(mediaChunk2.f26084g - j2, this.f27634r) >= C && format.f23067i < b2.f23067i && (i2 = format.f23077s) != -1 && i2 <= this.f27629m && (i3 = format.f23076r) != -1 && i3 <= this.f27628l && i2 < b2.f23077s) {
                return i4;
            }
        }
        return size;
    }

    public int m() {
        return this.f27636t;
    }

    public void s(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        int i2;
        long elapsedRealtime = this.f27633q.elapsedRealtime();
        long D = D(mediaChunkIteratorArr, list);
        int i3 = this.f27636t;
        if (i3 == 0) {
            this.f27636t = 1;
            this.f27635s = y(elapsedRealtime, D);
            return;
        }
        int i4 = this.f27635s;
        if (list.isEmpty()) {
            i2 = -1;
        } else {
            i2 = r(((MediaChunk) Iterables.d(list)).f26081d);
        }
        if (i2 != -1) {
            i3 = ((MediaChunk) Iterables.d(list)).f26082e;
            i4 = i2;
        }
        int y2 = y(elapsedRealtime, D);
        if (!p(i4, elapsedRealtime)) {
            Format b2 = b(i4);
            Format b3 = b(y2);
            long H = H(j4, D);
            int i5 = b3.f23067i;
            int i6 = b2.f23067i;
            if ((i5 > i6 && j3 < H) || (i5 < i6 && j3 >= this.f27626j)) {
                y2 = i4;
            }
        }
        if (y2 != i4) {
            i3 = 3;
        }
        this.f27636t = i3;
        this.f27635s = y2;
    }

    /* access modifiers changed from: protected */
    public boolean x(Format format, int i2, long j2) {
        return ((long) i2) <= j2;
    }
}
