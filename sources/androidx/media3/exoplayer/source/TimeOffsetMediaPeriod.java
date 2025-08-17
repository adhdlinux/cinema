package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import java.io.IOException;

final class TimeOffsetMediaPeriod implements MediaPeriod, MediaPeriod.Callback {

    /* renamed from: b  reason: collision with root package name */
    private final MediaPeriod f7170b;

    /* renamed from: c  reason: collision with root package name */
    private final long f7171c;

    /* renamed from: d  reason: collision with root package name */
    private MediaPeriod.Callback f7172d;

    private static final class TimeOffsetSampleStream implements SampleStream {

        /* renamed from: b  reason: collision with root package name */
        private final SampleStream f7173b;

        /* renamed from: c  reason: collision with root package name */
        private final long f7174c;

        public TimeOffsetSampleStream(SampleStream sampleStream, long j2) {
            this.f7173b = sampleStream;
            this.f7174c = j2;
        }

        public void a() throws IOException {
            this.f7173b.a();
        }

        public SampleStream b() {
            return this.f7173b;
        }

        public int d(long j2) {
            return this.f7173b.d(j2 - this.f7174c);
        }

        public boolean isReady() {
            return this.f7173b.isReady();
        }

        public int m(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i2) {
            int m2 = this.f7173b.m(formatHolder, decoderInputBuffer, i2);
            if (m2 == -4) {
                decoderInputBuffer.f5069f += this.f7174c;
            }
            return m2;
        }
    }

    public TimeOffsetMediaPeriod(MediaPeriod mediaPeriod, long j2) {
        this.f7170b = mediaPeriod;
        this.f7171c = j2;
    }

    public long b() {
        long b2 = this.f7170b.b();
        if (b2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f7171c + b2;
    }

    public boolean c() {
        return this.f7170b.c();
    }

    public MediaPeriod d() {
        return this.f7170b;
    }

    public long e() {
        long e2 = this.f7170b.e();
        if (e2 == Long.MIN_VALUE) {
            return Long.MIN_VALUE;
        }
        return this.f7171c + e2;
    }

    public void f(long j2) {
        this.f7170b.f(j2 - this.f7171c);
    }

    public boolean g(LoadingInfo loadingInfo) {
        return this.f7170b.g(loadingInfo.a().f(loadingInfo.f5395a - this.f7171c).d());
    }

    public long h(long j2, SeekParameters seekParameters) {
        return this.f7170b.h(j2 - this.f7171c, seekParameters) + this.f7171c;
    }

    public long i(long j2) {
        return this.f7170b.i(j2 - this.f7171c) + this.f7171c;
    }

    public long j() {
        long j2 = this.f7170b.j();
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f7171c + j2;
    }

    public void l() throws IOException {
        this.f7170b.l();
    }

    public void m(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.f(this.f7172d)).m(this);
    }

    public TrackGroupArray n() {
        return this.f7170b.n();
    }

    public void o(long j2, boolean z2) {
        this.f7170b.o(j2 - this.f7171c, z2);
    }

    public long q(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j2) {
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
        long q2 = this.f7170b.q(exoTrackSelectionArr, zArr, sampleStreamArr3, zArr2, j2 - this.f7171c);
        for (int i3 = 0; i3 < sampleStreamArr2.length; i3++) {
            SampleStream sampleStream2 = sampleStreamArr3[i3];
            if (sampleStream2 == null) {
                sampleStreamArr2[i3] = null;
            } else {
                SampleStream sampleStream3 = sampleStreamArr2[i3];
                if (sampleStream3 == null || ((TimeOffsetSampleStream) sampleStream3).b() != sampleStream2) {
                    sampleStreamArr2[i3] = new TimeOffsetSampleStream(sampleStream2, this.f7171c);
                }
            }
        }
        return q2 + this.f7171c;
    }

    /* renamed from: r */
    public void p(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Assertions.f(this.f7172d)).p(this);
    }

    public void s(MediaPeriod.Callback callback, long j2) {
        this.f7172d = callback;
        this.f7170b.s(this, j2 - this.f7171c);
    }
}
