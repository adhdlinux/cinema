package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.Format;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdaptiveTrackSelection extends BaseTrackSelection {

    /* renamed from: h  reason: collision with root package name */
    private final BandwidthMeter f7336h;

    /* renamed from: i  reason: collision with root package name */
    private final long f7337i;

    /* renamed from: j  reason: collision with root package name */
    private final long f7338j;

    /* renamed from: k  reason: collision with root package name */
    private final long f7339k;

    /* renamed from: l  reason: collision with root package name */
    private final int f7340l;

    /* renamed from: m  reason: collision with root package name */
    private final int f7341m;

    /* renamed from: n  reason: collision with root package name */
    private final float f7342n;

    /* renamed from: o  reason: collision with root package name */
    private final float f7343o;

    /* renamed from: p  reason: collision with root package name */
    private final ImmutableList<AdaptationCheckpoint> f7344p;

    /* renamed from: q  reason: collision with root package name */
    private final Clock f7345q;

    /* renamed from: r  reason: collision with root package name */
    private float f7346r;

    /* renamed from: s  reason: collision with root package name */
    private int f7347s;

    /* renamed from: t  reason: collision with root package name */
    private int f7348t;

    /* renamed from: u  reason: collision with root package name */
    private long f7349u;

    /* renamed from: v  reason: collision with root package name */
    private MediaChunk f7350v;

    /* renamed from: w  reason: collision with root package name */
    private long f7351w;

    public static final class AdaptationCheckpoint {

        /* renamed from: a  reason: collision with root package name */
        public final long f7352a;

        /* renamed from: b  reason: collision with root package name */
        public final long f7353b;

        public AdaptationCheckpoint(long j2, long j3) {
            this.f7352a = j2;
            this.f7353b = j3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdaptationCheckpoint)) {
                return false;
            }
            AdaptationCheckpoint adaptationCheckpoint = (AdaptationCheckpoint) obj;
            if (this.f7352a == adaptationCheckpoint.f7352a && this.f7353b == adaptationCheckpoint.f7353b) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((int) this.f7352a) * 31) + ((int) this.f7353b);
        }
    }

    public static class Factory implements ExoTrackSelection.Factory {

        /* renamed from: a  reason: collision with root package name */
        private final int f7354a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7355b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7356c;

        /* renamed from: d  reason: collision with root package name */
        private final int f7357d;

        /* renamed from: e  reason: collision with root package name */
        private final int f7358e;

        /* renamed from: f  reason: collision with root package name */
        private final float f7359f;

        /* renamed from: g  reason: collision with root package name */
        private final float f7360g;

        /* renamed from: h  reason: collision with root package name */
        private final Clock f7361h;

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
                    int[] iArr = definition.f7458b;
                    if (iArr.length != 0) {
                        if (iArr.length == 1) {
                            exoTrackSelection = new FixedTrackSelection(definition.f7457a, iArr[0], definition.f7459c);
                        } else {
                            exoTrackSelection = b(definition.f7457a, iArr, definition.f7459c, bandwidthMeter, (ImmutableList) v2.get(i2));
                        }
                        exoTrackSelectionArr[i2] = exoTrackSelection;
                    }
                }
            }
            return exoTrackSelectionArr;
        }

        /* access modifiers changed from: protected */
        public AdaptiveTrackSelection b(TrackGroup trackGroup, int[] iArr, int i2, BandwidthMeter bandwidthMeter, ImmutableList<AdaptationCheckpoint> immutableList) {
            return new AdaptiveTrackSelection(trackGroup, iArr, i2, bandwidthMeter, (long) this.f7354a, (long) this.f7355b, (long) this.f7356c, this.f7357d, this.f7358e, this.f7359f, this.f7360g, immutableList, this.f7361h);
        }

        public Factory(int i2, int i3, int i4, float f2) {
            this(i2, i3, i4, 1279, 719, f2, 0.75f, Clock.f4616a);
        }

        public Factory(int i2, int i3, int i4, int i5, int i6, float f2, float f3, Clock clock) {
            this.f7354a = i2;
            this.f7355b = i3;
            this.f7356c = i4;
            this.f7357d = i5;
            this.f7358e = i6;
            this.f7359f = f2;
            this.f7360g = f3;
            this.f7361h = clock;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i2, BandwidthMeter bandwidthMeter, long j2, long j3, long j4, int i3, int i4, float f2, float f3, List<AdaptationCheckpoint> list, Clock clock) {
        super(trackGroup, iArr, i2);
        BandwidthMeter bandwidthMeter2;
        long j5;
        if (j4 < j2) {
            Log.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            bandwidthMeter2 = bandwidthMeter;
            j5 = j2;
        } else {
            bandwidthMeter2 = bandwidthMeter;
            j5 = j4;
        }
        this.f7336h = bandwidthMeter2;
        this.f7337i = j2 * 1000;
        this.f7338j = j3 * 1000;
        this.f7339k = j5 * 1000;
        this.f7340l = i3;
        this.f7341m = i4;
        this.f7342n = f2;
        this.f7343o = f3;
        this.f7344p = ImmutableList.n(list);
        this.f7345q = clock;
        this.f7346r = 1.0f;
        this.f7348t = 0;
        this.f7349u = -9223372036854775807L;
        this.f7351w = -2147483647L;
    }

    private long A(long j2) {
        long G = G(j2);
        if (this.f7344p.isEmpty()) {
            return G;
        }
        int i2 = 1;
        while (i2 < this.f7344p.size() - 1 && this.f7344p.get(i2).f7352a < G) {
            i2++;
        }
        AdaptationCheckpoint adaptationCheckpoint = this.f7344p.get(i2 - 1);
        AdaptationCheckpoint adaptationCheckpoint2 = this.f7344p.get(i2);
        long j3 = adaptationCheckpoint.f7352a;
        long j4 = adaptationCheckpoint.f7353b;
        return j4 + ((long) ((((float) (G - j3)) / ((float) (adaptationCheckpoint2.f7352a - j3))) * ((float) (adaptationCheckpoint2.f7353b - j4))));
    }

    private long B(List<? extends MediaChunk> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        MediaChunk mediaChunk = (MediaChunk) Iterables.d(list);
        long j2 = mediaChunk.f7223g;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = mediaChunk.f7224h;
        if (j3 != -9223372036854775807L) {
            return j3 - j2;
        }
        return -9223372036854775807L;
    }

    private long D(MediaChunkIterator[] mediaChunkIteratorArr, List<? extends MediaChunk> list) {
        int i2 = this.f7347s;
        if (i2 >= mediaChunkIteratorArr.length || !mediaChunkIteratorArr[i2].next()) {
            for (MediaChunkIterator mediaChunkIterator : mediaChunkIteratorArr) {
                if (mediaChunkIterator.next()) {
                    return mediaChunkIterator.b() - mediaChunkIterator.a();
                }
            }
            return B(list);
        }
        MediaChunkIterator mediaChunkIterator2 = mediaChunkIteratorArr[this.f7347s];
        return mediaChunkIterator2.b() - mediaChunkIterator2.a();
    }

    private static long[][] E(ExoTrackSelection.Definition[] definitionArr) {
        long[][] jArr = new long[definitionArr.length][];
        for (int i2 = 0; i2 < definitionArr.length; i2++) {
            ExoTrackSelection.Definition definition = definitionArr[i2];
            if (definition == null) {
                jArr[i2] = new long[0];
            } else {
                jArr[i2] = new long[definition.f7458b.length];
                int i3 = 0;
                while (true) {
                    int[] iArr = definition.f7458b;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    long j2 = (long) definition.f7457a.a(iArr[i3]).f4010i;
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
        long c2 = this.f7336h.c();
        this.f7351w = c2;
        long j3 = (long) (((float) c2) * this.f7342n);
        long a2 = this.f7336h.a();
        if (a2 == -9223372036854775807L || j2 == -9223372036854775807L) {
            return (long) (((float) j3) / this.f7346r);
        }
        float f2 = (float) j2;
        return (long) ((((float) j3) * Math.max((f2 / this.f7346r) - ((float) a2), 0.0f)) / f2);
    }

    private long H(long j2, long j3) {
        if (j2 == -9223372036854775807L) {
            return this.f7337i;
        }
        if (j3 != -9223372036854775807L) {
            j2 -= j3;
        }
        return Math.min((long) (((float) j2) * this.f7343o), this.f7337i);
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
        for (int i3 = 0; i3 < this.f7363b; i3++) {
            if (j2 == Long.MIN_VALUE || !o(i3, j2)) {
                Format b2 = b(i3);
                if (x(b2, b2.f4010i, A)) {
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
            if (definition == null || definition.f7458b.length <= 1) {
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
        return this.f7339k;
    }

    /* access modifiers changed from: protected */
    public boolean I(long j2, List<? extends MediaChunk> list) {
        long j3 = this.f7349u;
        if (j3 == -9223372036854775807L || j2 - j3 >= 1000 || (!list.isEmpty() && !((MediaChunk) Iterables.d(list)).equals(this.f7350v))) {
            return true;
        }
        return false;
    }

    public int a() {
        return this.f7347s;
    }

    public void d(float f2) {
        this.f7346r = f2;
    }

    public void disable() {
        this.f7350v = null;
    }

    public Object e() {
        return null;
    }

    public void enable() {
        this.f7349u = -9223372036854775807L;
        this.f7350v = null;
    }

    public int j(long j2, List<? extends MediaChunk> list) {
        MediaChunk mediaChunk;
        int i2;
        int i3;
        long elapsedRealtime = this.f7345q.elapsedRealtime();
        if (!I(elapsedRealtime, list)) {
            return list.size();
        }
        this.f7349u = elapsedRealtime;
        if (list.isEmpty()) {
            mediaChunk = null;
        } else {
            mediaChunk = (MediaChunk) Iterables.d(list);
        }
        this.f7350v = mediaChunk;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long j02 = Util.j0(((MediaChunk) list.get(size - 1)).f7223g - j2, this.f7346r);
        long C = C();
        if (j02 < C) {
            return size;
        }
        Format b2 = b(y(elapsedRealtime, B(list)));
        for (int i4 = 0; i4 < size; i4++) {
            MediaChunk mediaChunk2 = (MediaChunk) list.get(i4);
            Format format = mediaChunk2.f7220d;
            if (Util.j0(mediaChunk2.f7223g - j2, this.f7346r) >= C && format.f4010i < b2.f4010i && (i2 = format.f4022u) != -1 && i2 <= this.f7341m && (i3 = format.f4021t) != -1 && i3 <= this.f7340l && i2 < b2.f4022u) {
                return i4;
            }
        }
        return size;
    }

    public int m() {
        return this.f7348t;
    }

    public void q(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
        int i2;
        long elapsedRealtime = this.f7345q.elapsedRealtime();
        long D = D(mediaChunkIteratorArr, list);
        int i3 = this.f7348t;
        if (i3 == 0) {
            this.f7348t = 1;
            this.f7347s = y(elapsedRealtime, D);
            return;
        }
        int i4 = this.f7347s;
        if (list.isEmpty()) {
            i2 = -1;
        } else {
            i2 = p(((MediaChunk) Iterables.d(list)).f7220d);
        }
        if (i2 != -1) {
            i3 = ((MediaChunk) Iterables.d(list)).f7221e;
            i4 = i2;
        }
        int y2 = y(elapsedRealtime, D);
        if (y2 != i4 && !o(i4, elapsedRealtime)) {
            Format b2 = b(i4);
            Format b3 = b(y2);
            long H = H(j4, D);
            int i5 = b3.f4010i;
            int i6 = b2.f4010i;
            if ((i5 > i6 && j3 < H) || (i5 < i6 && j3 >= this.f7338j)) {
                y2 = i4;
            }
        }
        if (y2 != i4) {
            i3 = 3;
        }
        this.f7348t = i3;
        this.f7347s = y2;
    }

    /* access modifiers changed from: protected */
    public boolean x(Format format, int i2, long j2) {
        return ((long) i2) <= j2;
    }
}
