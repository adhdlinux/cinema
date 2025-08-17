package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;

final class MergingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final MediaPeriod[] f25804b;

    /* renamed from: c  reason: collision with root package name */
    private final IdentityHashMap<SampleStream, Integer> f25805c;

    /* renamed from: d  reason: collision with root package name */
    private final CompositeSequenceableLoaderFactory f25806d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<MediaPeriod> f25807e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<TrackGroup, TrackGroup> f25808f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private MediaPeriod.Callback f25809g;

    /* renamed from: h  reason: collision with root package name */
    private TrackGroupArray f25810h;

    /* renamed from: i  reason: collision with root package name */
    private MediaPeriod[] f25811i;

    /* renamed from: j  reason: collision with root package name */
    private SequenceableLoader f25812j;

    private static final class ForwardingTrackSelection implements ExoTrackSelection {

        /* renamed from: a  reason: collision with root package name */
        private final ExoTrackSelection f25813a;

        /* renamed from: b  reason: collision with root package name */
        private final TrackGroup f25814b;

        public ForwardingTrackSelection(ExoTrackSelection exoTrackSelection, TrackGroup trackGroup) {
            this.f25813a = exoTrackSelection;
            this.f25814b = trackGroup;
        }

        public int a() {
            return this.f25813a.a();
        }

        public Format b(int i2) {
            return this.f25813a.b(i2);
        }

        public int c(int i2) {
            return this.f25813a.c(i2);
        }

        public void d(float f2) {
            this.f25813a.d(f2);
        }

        public void disable() {
            this.f25813a.disable();
        }

        public Object e() {
            return this.f25813a.e();
        }

        public void enable() {
            this.f25813a.enable();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingTrackSelection)) {
                return false;
            }
            ForwardingTrackSelection forwardingTrackSelection = (ForwardingTrackSelection) obj;
            if (!this.f25813a.equals(forwardingTrackSelection.f25813a) || !this.f25814b.equals(forwardingTrackSelection.f25814b)) {
                return false;
            }
            return true;
        }

        public void f() {
            this.f25813a.f();
        }

        public int g(int i2) {
            return this.f25813a.g(i2);
        }

        public TrackGroup h() {
            return this.f25814b;
        }

        public int hashCode() {
            return ((527 + this.f25814b.hashCode()) * 31) + this.f25813a.hashCode();
        }

        public void i(boolean z2) {
            this.f25813a.i(z2);
        }

        public int j(long j2, List<? extends MediaChunk> list) {
            return this.f25813a.j(j2, list);
        }

        public int k() {
            return this.f25813a.k();
        }

        public Format l() {
            return this.f25813a.l();
        }

        public int length() {
            return this.f25813a.length();
        }

        public int m() {
            return this.f25813a.m();
        }

        public void n() {
            this.f25813a.n();
        }

        public boolean o(int i2, long j2) {
            return this.f25813a.o(i2, j2);
        }

        public boolean p(int i2, long j2) {
            return this.f25813a.p(i2, j2);
        }

        public boolean q(long j2, Chunk chunk, List<? extends MediaChunk> list) {
            return this.f25813a.q(j2, chunk, list);
        }

        public int r(Format format) {
            return this.f25813a.r(format);
        }

        public void s(long j2, long j3, long j4, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr) {
            this.f25813a.s(j2, j3, j4, list, mediaChunkIteratorArr);
        }
    }

    private static final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final MediaPeriod f25815b;

        /* renamed from: c  reason: collision with root package name */
        private final long f25816c;

        /* renamed from: d  reason: collision with root package name */
        private MediaPeriod.Callback f25817d;

        public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long j2) {
            this.f25815b = mediaPeriod;
            this.f25816c = j2;
        }

        public long b() {
            long b2 = this.f25815b.b();
            if (b2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f25816c + b2;
        }

        public boolean c() {
            return this.f25815b.c();
        }

        public long e() {
            long e2 = this.f25815b.e();
            if (e2 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            return this.f25816c + e2;
        }

        public void f(long j2) {
            this.f25815b.f(j2 - this.f25816c);
        }

        public long g(long j2, SeekParameters seekParameters) {
            return this.f25815b.g(j2 - this.f25816c, seekParameters) + this.f25816c;
        }

        public boolean h(long j2) {
            return this.f25815b.h(j2 - this.f25816c);
        }

        public long i(long j2) {
            return this.f25815b.i(j2 - this.f25816c) + this.f25816c;
        }

        public long j() {
            long j2 = this.f25815b.j();
            if (j2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f25816c + j2;
        }

        public void l() throws IOException {
            this.f25815b.l();
        }

        public TrackGroupArray n() {
            return this.f25815b.n();
        }

        public void o(long j2, boolean z2) {
            this.f25815b.o(j2 - this.f25816c, z2);
        }

        public void p(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.e(this.f25817d)).p(this);
        }

        /* renamed from: q */
        public void d(MediaPeriod mediaPeriod) {
            ((MediaPeriod.Callback) Assertions.e(this.f25817d)).d(this);
        }

        public void r(MediaPeriod.Callback callback, long j2) {
            this.f25817d = callback;
            this.f25815b.r(this, j2 - this.f25816c);
        }

        public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
            SampleStream[] sampleStreamArr2 = sampleStreamArr;
            SampleStream[] sampleStreamArr3 = new SampleStream[sampleStreamArr2.length];
            int i2 = 0;
            while (true) {
                SampleStream sampleStream = null;
                if (i2 >= sampleStreamArr2.length) {
                    break;
                }
                TimeOffsetSampleStream timeOffsetSampleStream = (TimeOffsetSampleStream) sampleStreamArr2[i2];
                if (timeOffsetSampleStream != null) {
                    sampleStream = timeOffsetSampleStream.b();
                }
                sampleStreamArr3[i2] = sampleStream;
                i2++;
            }
            long s2 = this.f25815b.s(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, j2 - this.f25816c);
            for (int i3 = 0; i3 < sampleStreamArr2.length; i3++) {
                SampleStream sampleStream2 = sampleStreamArr3[i3];
                if (sampleStream2 == null) {
                    sampleStreamArr2[i3] = null;
                } else {
                    SampleStream sampleStream3 = sampleStreamArr2[i3];
                    if (sampleStream3 == null || ((TimeOffsetSampleStream) sampleStream3).b() != sampleStream2) {
                        sampleStreamArr2[i3] = new TimeOffsetSampleStream(sampleStream2, this.f25816c);
                    }
                }
            }
            return s2 + this.f25816c;
        }
    }

    private static final class TimeOffsetSampleStream implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        private final SampleStream f25818b;

        /* renamed from: c  reason: collision with root package name */
        private final long f25819c;

        public TimeOffsetSampleStream(SampleStream sampleStream, long j2) {
            this.f25818b = sampleStream;
            this.f25819c = j2;
        }

        public void a() throws IOException {
            this.f25818b.a();
        }

        public SampleStream b() {
            return this.f25818b;
        }

        public int d(long j2) {
            return this.f25818b.d(j2 - this.f25819c);
        }

        public boolean isReady() {
            return this.f25818b.isReady();
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int m2 = this.f25818b.m(formatHolder, decoderInputBuffer, i2);
            if (m2 == -4) {
                decoderInputBuffer.f23963f = Math.max(0, decoderInputBuffer.f23963f + this.f25819c);
            }
            return m2;
        }
    }

    public MergingMediaPeriod(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, long[] jArr, MediaPeriod... mediaPeriodArr) {
        this.f25806d = compositeSequenceableLoaderFactory;
        this.f25804b = mediaPeriodArr;
        this.f25812j = compositeSequenceableLoaderFactory.a(new SequenceableLoader[0]);
        this.f25805c = new IdentityHashMap<>();
        this.f25811i = new MediaPeriod[0];
        for (int i2 = 0; i2 < mediaPeriodArr.length; i2++) {
            long j2 = jArr[i2];
            if (j2 != 0) {
                this.f25804b[i2] = new TimeOffsetMediaPeriod(mediaPeriodArr[i2], j2);
            }
        }
    }

    public long b() {
        return this.f25812j.b();
    }

    public boolean c() {
        return this.f25812j.c();
    }

    public long e() {
        return this.f25812j.e();
    }

    public void f(long j2) {
        this.f25812j.f(j2);
    }

    public long g(long j2, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod;
        MediaPeriod[] mediaPeriodArr = this.f25811i;
        if (mediaPeriodArr.length > 0) {
            mediaPeriod = mediaPeriodArr[0];
        } else {
            mediaPeriod = this.f25804b[0];
        }
        return mediaPeriod.g(j2, seekParameters);
    }

    public boolean h(long j2) {
        if (this.f25807e.isEmpty()) {
            return this.f25812j.h(j2);
        }
        int size = this.f25807e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f25807e.get(i2).h(j2);
        }
        return false;
    }

    public long i(long j2) {
        long i2 = this.f25811i[0].i(j2);
        int i3 = 1;
        while (true) {
            MediaPeriod[] mediaPeriodArr = this.f25811i;
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
        for (MediaPeriod mediaPeriod : this.f25811i) {
            long j3 = mediaPeriod.j();
            if (j3 != -9223372036854775807L) {
                if (j2 == -9223372036854775807L) {
                    MediaPeriod[] mediaPeriodArr = this.f25811i;
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
        for (MediaPeriod l2 : this.f25804b) {
            l2.l();
        }
    }

    public MediaPeriod m(int i2) {
        MediaPeriod mediaPeriod = this.f25804b[i2];
        if (mediaPeriod instanceof TimeOffsetMediaPeriod) {
            return ((TimeOffsetMediaPeriod) mediaPeriod).f25815b;
        }
        return mediaPeriod;
    }

    public TrackGroupArray n() {
        return (TrackGroupArray) Assertions.e(this.f25810h);
    }

    public void o(long j2, boolean z2) {
        for (MediaPeriod o2 : this.f25811i) {
            o2.o(j2, z2);
        }
    }

    public void p(MediaPeriod mediaPeriod) {
        this.f25807e.remove(mediaPeriod);
        if (this.f25807e.isEmpty()) {
            int i2 = 0;
            for (MediaPeriod n2 : this.f25804b) {
                i2 += n2.n().f26010b;
            }
            TrackGroup[] trackGroupArr = new TrackGroup[i2];
            int i3 = 0;
            int i4 = 0;
            while (true) {
                MediaPeriod[] mediaPeriodArr = this.f25804b;
                if (i3 < mediaPeriodArr.length) {
                    TrackGroupArray n3 = mediaPeriodArr[i3].n();
                    int i5 = n3.f26010b;
                    int i6 = 0;
                    while (i6 < i5) {
                        TrackGroup b2 = n3.b(i6);
                        TrackGroup b3 = b2.b(i3 + ":" + b2.f26003c);
                        this.f25808f.put(b3, b2);
                        trackGroupArr[i4] = b3;
                        i6++;
                        i4++;
                    }
                    i3++;
                } else {
                    this.f25810h = new TrackGroupArray(trackGroupArr);
                    ((MediaPeriod.Callback) Assertions.e(this.f25809g)).p(this);
                    return;
                }
            }
        }
    }

    /* renamed from: q */
    public void d(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.e(this.f25809g)).d(this);
    }

    public void r(MediaPeriod.Callback callback, long j2) {
        this.f25809g = callback;
        Collections.addAll(this.f25807e, this.f25804b);
        for (MediaPeriod r2 : this.f25804b) {
            r2.r(this, j2);
        }
    }

    public long s(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
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
                num = this.f25805c.get(sampleStream);
            }
            if (num == null) {
                i2 = -1;
            } else {
                i2 = num.intValue();
            }
            iArr[i3] = i2;
            ExoTrackSelection exoTrackSelection = exoTrackSelectionArr2[i3];
            if (exoTrackSelection != null) {
                String str = exoTrackSelection.h().f26003c;
                iArr2[i3] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i3] = -1;
            }
            i3++;
        }
        this.f25805c.clear();
        int length = exoTrackSelectionArr2.length;
        SampleStream[] sampleStreamArr3 = new SampleStream[length];
        SampleStream[] sampleStreamArr4 = new SampleStream[exoTrackSelectionArr2.length];
        ExoTrackSelection[] exoTrackSelectionArr3 = new ExoTrackSelection[exoTrackSelectionArr2.length];
        ArrayList arrayList = new ArrayList(this.f25804b.length);
        long j3 = j2;
        int i4 = 0;
        while (i4 < this.f25804b.length) {
            for (int i5 = 0; i5 < exoTrackSelectionArr2.length; i5++) {
                if (iArr[i5] == i4) {
                    num2 = sampleStreamArr2[i5];
                } else {
                    num2 = num;
                }
                sampleStreamArr4[i5] = num2;
                if (iArr2[i5] == i4) {
                    ExoTrackSelection exoTrackSelection2 = (ExoTrackSelection) Assertions.e(exoTrackSelectionArr2[i5]);
                    exoTrackSelectionArr3[i5] = new ForwardingTrackSelection(exoTrackSelection2, (TrackGroup) Assertions.e(this.f25808f.get(exoTrackSelection2.h())));
                } else {
                    exoTrackSelectionArr3[i5] = num;
                }
            }
            int i6 = i4;
            ArrayList arrayList2 = arrayList;
            ExoTrackSelection[] exoTrackSelectionArr4 = exoTrackSelectionArr3;
            long s2 = this.f25804b[i4].s(exoTrackSelectionArr3, zArr, sampleStreamArr4, zArr2, j3);
            if (i6 == 0) {
                j3 = s2;
            } else if (s2 != j3) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z2 = false;
            for (int i7 = 0; i7 < exoTrackSelectionArr2.length; i7++) {
                boolean z3 = true;
                if (iArr2[i7] == i6) {
                    sampleStreamArr3[i7] = sampleStreamArr4[i7];
                    this.f25805c.put((SampleStream) Assertions.e(sampleStreamArr4[i7]), Integer.valueOf(i6));
                    z2 = true;
                } else if (iArr[i7] == i6) {
                    if (sampleStreamArr4[i7] != null) {
                        z3 = false;
                    }
                    Assertions.g(z3);
                }
            }
            if (z2) {
                arrayList2.add(this.f25804b[i6]);
            }
            i4 = i6 + 1;
            arrayList = arrayList2;
            exoTrackSelectionArr3 = exoTrackSelectionArr4;
            num = null;
        }
        System.arraycopy(sampleStreamArr3, 0, sampleStreamArr2, 0, length);
        MediaPeriod[] mediaPeriodArr = (MediaPeriod[]) arrayList.toArray(new MediaPeriod[0]);
        this.f25811i = mediaPeriodArr;
        this.f25812j = this.f25806d.a(mediaPeriodArr);
        return j3;
    }
}
