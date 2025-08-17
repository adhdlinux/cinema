package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.chunk.Chunk;
import androidx.media3.exoplayer.source.chunk.MediaChunk;
import androidx.media3.exoplayer.source.chunk.MediaChunkIterator;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final MediaPeriod[] f6981b;

    /* renamed from: c  reason: collision with root package name */
    private final IdentityHashMap<SampleStream, Integer> f6982c;

    /* renamed from: d  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f6983d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<MediaPeriod> f6984e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<TrackGroup, TrackGroup> f6985f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private MediaPeriod.Callback f6986g;

    /* renamed from: h  reason: collision with root package name */
    private TrackGroupArray f6987h;

    /* renamed from: i  reason: collision with root package name */
    private MediaPeriod[] f6988i;

    /* renamed from: j  reason: collision with root package name */
    private SequenceableLoader f6989j;

    private static final class ForwardingTrackSelection implements ExoTrackSelection {

        /* renamed from: a  reason: collision with root package name */
        private final ExoTrackSelection f6990a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackGroup f6991b;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
            this.f6990a = exoTrackSelection;
            this.f6991b = trackGroup;
        }

        public int a() {
            return this.f6990a.a();
        }

        public Format b(int i2) {
            return this.f6991b.a(this.f6990a.c(i2));
        }

        public int c(int i2) {
            return this.f6990a.c(i2);
        }

        public void d(float f2) {
            this.f6990a.d(f2);
        }

        public void disable() {
            this.f6990a.disable();
        }

        public Object e() {
            return this.f6990a.e();
        }

        public void enable() {
            this.f6990a.enable();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            if (!this.f6990a.equals(forwardingTrackSelection.f6990a) || !this.f6991b.equals(forwardingTrackSelection.f6991b)) {
                return false;
            }
            return true;
        }

        public void f() {
            this.f6990a.f();
        }

        public int g(int i2) {
            return this.f6990a.g(i2);
        }

        public TrackGroup h() {
            return this.f6991b;
        }

        public int hashCode() {
            return ((527 + this.f6991b.hashCode()) * 31) + this.f6990a.hashCode();
        }

        public void i(boolean z2) {
            this.f6990a.i(z2);
        }

        public int j(long j2, List<? extends MediaChunk> list) {
            return this.f6990a.j(j2, list);
        }

        public int k() {
            return this.f6990a.k();
        }

        public Format l() {
            return this.f6991b.a(this.f6990a.k());
        }

        public int length() {
            return this.f6990a.length();
        }

        public int m() {
            return this.f6990a.m();
        }

        public void n() {
            this.f6990a.n();
        }

        public boolean o(int i2, long j2) {
            return this.f6990a.o(i2, j2);
        }

        public int p(Format format) {
            return this.f6990a.g(this.f6991b.b(format));
        }

        public void q(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.f6990a.q(j2, j3, j4, list, mediaChunkIteratorArr);
        }

        public boolean r(int i2, long j2) {
            return this.f6990a.r(i2, j2);
        }

        public boolean s(long j2, Chunk chunk, List<? extends MediaChunk> list) {
            return this.f6990a.s(j2, chunk, list);
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.f6983d = compositeSequenceableLoaderFactory;
        this.f6981b = mediaPeriodArr;
        this.f6989j = compositeSequenceableLoaderFactory.empty();
        this.f6982c = new IdentityHashMap<>();
        this.f6988i = new MediaPeriod[0];
        for (int i2 = 0; i2 < mediaPeriodArr.length; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                this.f6981b[i2] = new TimeOffsetMediaPeriod(mediaPeriodArr[i2], j2);
            }
        }
    }

    public long b() {
        return this.f6989j.b();
    }

    public boolean c() {
        return this.f6989j.c();
    }

    public long e() {
        return this.f6989j.e();
    }

    public void f(long j2) {
        this.f6989j.f(j2);
    }

    public boolean g(LoadingInfo loadingInfo) {
        if (this.f6984e.isEmpty()) {
            return this.f6989j.g(loadingInfo);
        }
        int size = this.f6984e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f6984e.get(i2).g(loadingInfo);
        }
        return false;
    }

    public long h(long j2, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod;
        MediaPeriod[] mediaPeriodArr = this.f6988i;
        if (mediaPeriodArr.length > 0) {
            mediaPeriod = mediaPeriodArr[0];
        } else {
            mediaPeriod = this.f6981b[0];
        }
        return mediaPeriod.h(j2, seekParameters);
    }

    public long i(long j2) {
        long i2 = this.f6988i[0].i(j2);
        int i3 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f6988i;
            if (i3 >= mediaPeriodArr.length) {
                return i2;
            }
            if (mediaPeriodArr[i3].i(i2) == i2) {
                i3++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public long j() {
        long j2 = -9223372036854775807L;
        for (MediaPeriod mediaPeriod : this.f6988i) {
            long j3 = mediaPeriod.j();
            if (j3 != -9223372036854775807L) {
                if (j2 == -9223372036854775807L) {
                    MediaPeriod[] mediaPeriodArr = this.f6988i;
                    int length = mediaPeriodArr.length;
                    int i2 = 0;
                    while (i2 < length) {
                        MediaPeriod mediaPeriod2 = mediaPeriodArr[i2];
                        if (mediaPeriod2 == mediaPeriod) {
                            break;
                        } else if (mediaPeriod2.i(j3) == j3) {
                            i2++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j2 = j3;
                } else if (j3 != j2) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j2 == -9223372036854775807L || mediaPeriod.i(j2) == j2)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j2;
    }

    public void l() throws IOException {
        for (MediaPeriod l2 : this.f6981b) {
            l2.l();
        }
    }

    public void m(MediaPeriod mediaPeriod) {
        this.f6984e.remove(mediaPeriod);
        if (this.f6984e.isEmpty()) {
            int i2 = 0;
            for (MediaPeriod n2 : this.f6981b) {
                i2 += n2.n().f7178a;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                MediaPeriod[] mediaPeriodArr = this.f6981b;
                if (i3 < mediaPeriodArr.length) {
                    TrackGroupArray n3 = mediaPeriodArr[i3].n();
                    int i5 = n3.f7178a;
                    int i6 = 0;
                    while (i6 < i5) {
                        TrackGroup b2 = n3.b(i6);
                        Format[] formatArr = new Format[b2.f4390a];
                        for (int i7 = 0; i7 < b2.f4390a; i7++) {
                            Format a2 = b2.a(i7);
                            Format.Builder a3 = a2.a();
                            StringBuilder sb = new StringBuilder();
                            sb.append(i3);
                            sb.append(":");
                            String str = a2.f4002a;
                            if (str == null) {
                                str = "";
                            }
                            sb.append(str);
                            formatArr[i7] = a3.a0(sb.toString()).K();
                        }
                        TrackGroup trackGroup = new TrackGroup(i3 + ":" + b2.f4391b, formatArr);
                        this.f6985f.put(trackGroup, b2);
                        trackGroupArr[i4] = trackGroup;
                        i6++;
                        i4++;
                    }
                    i3++;
                } else {
                    this.f6987h = new TrackGroupArray(trackGroupArr);
                    ((MediaPeriod.Callback) Assertions.f(this.f6986g)).m(this);
                    return;
                }
            }
        }
    }

    public TrackGroupArray n() {
        return (TrackGroupArray) Assertions.f(this.f6987h);
    }

    public void o(long j2, boolean z2) {
        for (MediaPeriod o2 : this.f6988i) {
            o2.o(j2, z2);
        }
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
        Integer num;
        Integer num2;
        int i2;
        ExoTrackSelection[] exoTrackSelectionArr2 = exoTrackSelectionArr;
        SampleStream[] sampleStreamArr2 = sampleStreamArr;
        int[] iArr = new int[exoTrackSelectionArr2.length];
        int[] iArr2 = new int[exoTrackSelectionArr2.length];
        int i3 = 0;
        while (true) {
            num = 0;
            if (i3 >= exoTrackSelectionArr2.length) {
                break;
            }
            SampleStream sampleStream = sampleStreamArr2[i3];
            if (sampleStream != null) {
                num = this.f6982c.get(sampleStream);
            }
            if (num == null) {
                i2 = -1;
            } else {
                i2 = num.intValue();
            }
            iArr[i3] = i2;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i3];
            if (exoTrackSelection != null) {
                String str = exoTrackSelection.h().f4391b;
                iArr2[i3] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i3] = -1;
            }
            i3++;
        }
        this.f6982c.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.f6981b.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < this.f6981b.length) {
            for (int i5 = 0; i5 < exoTrackSelectionArr2.length; i5++) {
                if (iArr[i5] == i4) {
                    num2 = sampleStreamArr2[i5];
                } else {
                    num2 = num;
                }
                sampleStreamArr4[i5] = num2;
                if (iArr2[i5] == i4) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.f(exoTrackSelectionArr2[i5]);
                    exoTrackSelectionArr3[i5] = new ForwardingTrackSelection(exoTrackSelection2, (TrackGroup) Assertions.f(this.f6985f.get(exoTrackSelection2.h())));
                } else {
                    exoTrackSelectionArr3[i5] = num;
                }
            }
            int i6 = i4;
            ArrayList arrayList2 = arrayList;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            long q2 = this.f6981b[i4].q(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j3);
            if (i6 == 0) {
                j3 = q2;
            } else if (q2 != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i7 = 0; i7 < exoTrackSelectionArr2.length; i7++) {
                boolean z3 = true;
                if (iArr2[i7] == i6) {
                    sampleStreamArr3[i7] = sampleStreamArr4[i7];
                    this.f6982c.put((SampleStream) Assertions.f(sampleStreamArr4[i7]), Integer.valueOf(i6));
                    z2 = true;
                } else if (iArr[i7] == i6) {
                    if (sampleStreamArr4[i7] != null) {
                        z3 = false;
                    }
                    Assertions.h(z3);
                }
            }
            if (z2) {
                arrayList2.add(this.f6981b[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
            num = null;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        this.f6988i = (MediaPeriod[]) arrayList3.toArray(new MediaPeriod[0]);
        this.f6989j = this.f6983d.a(arrayList3, Lists.l(arrayList3, new r()));
        return j3;
    }

    public MediaPeriod r(int i2) {
        MediaPeriod mediaPeriod = this.f6981b[i2];
        if (mediaPeriod instanceof TimeOffsetMediaPeriod) {
            return ((TimeOffsetMediaPeriod) mediaPeriod).d();
        }
        return mediaPeriod;
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f6986g = callback;
        Collections.addAll(this.f6984e, this.f6981b);
        for (MediaPeriod s2 : this.f6981b) {
            s2.s(this, j2);
        }
    }

    /* renamed from: u */
    public void p(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.f(this.f6986g)).p(this);
    }
}
