package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public abstract class BinarySearchSeeker {

    /* renamed from: a  reason: collision with root package name */
    protected final BinarySearchSeekMap f24139a;

    /* renamed from: b  reason: collision with root package name */
    protected final TimestampSeeker f24140b;

    /* renamed from: c  reason: collision with root package name */
    protected SeekOperationParams f24141c;

    /* renamed from: d  reason: collision with root package name */
    private final int f24142d;

    public static class BinarySearchSeekMap implements SeekMap {

        /* renamed from: a  reason: collision with root package name */
        private final SeekTimestampConverter f24143a;

        /* renamed from: b  reason: collision with root package name */
        private final long f24144b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f24145c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f24146d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long f24147e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final long f24148f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final long f24149g;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f24143a = seekTimestampConverter;
            this.f24144b = j2;
            this.f24145c = j3;
            this.f24146d = j4;
            this.f24147e = j5;
            this.f24148f = j6;
            this.f24149g = j7;
        }

        public SeekMap.SeekPoints d(long j2) {
            return new SeekMap.SeekPoints(new SeekPoint(j2, SeekOperationParams.h(this.f24143a.a(j2), this.f24145c, this.f24146d, this.f24147e, this.f24148f, this.f24149g)));
        }

        public boolean f() {
            return true;
        }

        public long h() {
            return this.f24144b;
        }

        public long k(long j2) {
            return this.f24143a.a(j2);
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        public long a(long j2) {
            return j2;
        }
    }

    protected static class SeekOperationParams {

        /* renamed from: a  reason: collision with root package name */
        private final long f24150a;

        /* renamed from: b  reason: collision with root package name */
        private final long f24151b;

        /* renamed from: c  reason: collision with root package name */
        private final long f24152c;

        /* renamed from: d  reason: collision with root package name */
        private long f24153d;

        /* renamed from: e  reason: collision with root package name */
        private long f24154e;

        /* renamed from: f  reason: collision with root package name */
        private long f24155f;

        /* renamed from: g  reason: collision with root package name */
        private long f24156g;

        /* renamed from: h  reason: collision with root package name */
        private long f24157h;

        protected SeekOperationParams(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f24150a = j2;
            this.f24151b = j3;
            this.f24153d = j4;
            this.f24154e = j5;
            this.f24155f = j6;
            this.f24156g = j7;
            this.f24152c = j8;
            this.f24157h = h(j3, j4, j5, j6, j7, j8);
        }

        protected static long h(long j2, long j3, long j4, long j5, long j6, long j7) {
            if (j5 + 1 >= j6 || j3 + 1 >= j4) {
                return j5;
            }
            long j8 = (long) (((float) (j2 - j3)) * (((float) (j6 - j5)) / ((float) (j4 - j3))));
            return Util.r(((j8 + j5) - j7) - (j8 / 20), j5, j6 - 1);
        }

        /* access modifiers changed from: private */
        public long i() {
            return this.f24156g;
        }

        /* access modifiers changed from: private */
        public long j() {
            return this.f24155f;
        }

        /* access modifiers changed from: private */
        public long k() {
            return this.f24157h;
        }

        /* access modifiers changed from: private */
        public long l() {
            return this.f24150a;
        }

        /* access modifiers changed from: private */
        public long m() {
            return this.f24151b;
        }

        private void n() {
            this.f24157h = h(this.f24151b, this.f24153d, this.f24154e, this.f24155f, this.f24156g, this.f24152c);
        }

        /* access modifiers changed from: private */
        public void o(long j2, long j3) {
            this.f24154e = j2;
            this.f24156g = j3;
            n();
        }

        /* access modifiers changed from: private */
        public void p(long j2, long j3) {
            this.f24153d = j2;
            this.f24155f = j3;
            n();
        }
    }

    protected interface SeekTimestampConverter {
        long a(long j2);
    }

    public static final class TimestampSearchResult {

        /* renamed from: d  reason: collision with root package name */
        public static final TimestampSearchResult f24158d = new TimestampSearchResult(-3, -9223372036854775807L, -1);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f24159a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f24160b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f24161c;

        private TimestampSearchResult(int i2, long j2, long j3) {
            this.f24159a = i2;
            this.f24160b = j2;
            this.f24161c = j3;
        }

        public static TimestampSearchResult d(long j2, long j3) {
            return new TimestampSearchResult(-1, j2, j3);
        }

        public static TimestampSearchResult e(long j2) {
            return new TimestampSearchResult(0, -9223372036854775807L, j2);
        }

        public static TimestampSearchResult f(long j2, long j3) {
            return new TimestampSearchResult(-2, j2, j3);
        }
    }

    protected interface TimestampSeeker {
        void a();

        TimestampSearchResult b(ExtractorInput extractorInput, long j2) throws IOException;
    }

    protected BinarySearchSeeker(SeekTimestampConverter seekTimestampConverter, TimestampSeeker timestampSeeker, long j2, long j3, long j4, long j5, long j6, long j7, int i2) {
        this.f24140b = timestampSeeker;
        this.f24142d = i2;
        this.f24139a = new BinarySearchSeekMap(seekTimestampConverter, j2, j3, j4, j5, j6, j7);
    }

    /* access modifiers changed from: protected */
    public SeekOperationParams a(long j2) {
        long j3 = j2;
        return new SeekOperationParams(j3, this.f24139a.k(j3), this.f24139a.f24145c, this.f24139a.f24146d, this.f24139a.f24147e, this.f24139a.f24148f, this.f24139a.f24149g);
    }

    public final SeekMap b() {
        return this.f24139a;
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            SeekOperationParams seekOperationParams = (SeekOperationParams) Assertions.i(this.f24141c);
            long b2 = seekOperationParams.j();
            long c2 = seekOperationParams.i();
            long d2 = seekOperationParams.k();
            if (c2 - b2 <= ((long) this.f24142d)) {
                e(false, b2);
                return g(extractorInput, b2, positionHolder);
            } else if (!i(extractorInput, d2)) {
                return g(extractorInput, d2, positionHolder);
            } else {
                extractorInput.e();
                TimestampSearchResult b3 = this.f24140b.b(extractorInput, seekOperationParams.m());
                int a2 = b3.f24159a;
                if (a2 == -3) {
                    e(false, d2);
                    return g(extractorInput, d2, positionHolder);
                } else if (a2 == -2) {
                    seekOperationParams.p(b3.f24160b, b3.f24161c);
                } else if (a2 == -1) {
                    seekOperationParams.o(b3.f24160b, b3.f24161c);
                } else if (a2 == 0) {
                    i(extractorInput, b3.f24161c);
                    e(true, b3.f24161c);
                    return g(extractorInput, b3.f24161c, positionHolder);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean d() {
        return this.f24141c != null;
    }

    /* access modifiers changed from: protected */
    public final void e(boolean z2, long j2) {
        this.f24141c = null;
        this.f24140b.a();
        f(z2, j2);
    }

    /* access modifiers changed from: protected */
    public void f(boolean z2, long j2) {
    }

    /* access modifiers changed from: protected */
    public final int g(ExtractorInput extractorInput, long j2, PositionHolder positionHolder) {
        if (j2 == extractorInput.getPosition()) {
            return 0;
        }
        positionHolder.f24231a = j2;
        return 1;
    }

    public final void h(long j2) {
        SeekOperationParams seekOperationParams = this.f24141c;
        if (seekOperationParams == null || seekOperationParams.l() != j2) {
            this.f24141c = a(j2);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean i(ExtractorInput extractorInput, long j2) throws IOException {
        long position = j2 - extractorInput.getPosition();
        if (position < 0 || position > 262144) {
            return false;
        }
        extractorInput.k((int) position);
        return true;
    }
}
