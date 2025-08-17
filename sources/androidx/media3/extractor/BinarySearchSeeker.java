package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.SeekMap;
import java.io.IOException;

public abstract class BinarySearchSeeker {

    /* renamed from: a  reason: collision with root package name */
    protected final BinarySearchSeekMap f7929a;

    /* renamed from: b  reason: collision with root package name */
    protected final TimestampSeeker f7930b;

    /* renamed from: c  reason: collision with root package name */
    protected SeekOperationParams f7931c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7932d;

    public static class BinarySearchSeekMap implements SeekMap {

        /* renamed from: a  reason: collision with root package name */
        private final SeekTimestampConverter f7933a;

        /* renamed from: b  reason: collision with root package name */
        private final long f7934b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f7935c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f7936d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final long f7937e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final long f7938f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public final long f7939g;

        public BinarySearchSeekMap(SeekTimestampConverter seekTimestampConverter, long j2, long j3, long j4, long j5, long j6, long j7) {
            this.f7933a = seekTimestampConverter;
            this.f7934b = j2;
            this.f7935c = j3;
            this.f7936d = j4;
            this.f7937e = j5;
            this.f7938f = j6;
            this.f7939g = j7;
        }

        public SeekMap.SeekPoints d(long j2) {
            return new SeekMap.SeekPoints(new SeekPoint(j2, SeekOperationParams.h(this.f7933a.a(j2), this.f7935c, this.f7936d, this.f7937e, this.f7938f, this.f7939g)));
        }

        public boolean f() {
            return true;
        }

        public long h() {
            return this.f7934b;
        }

        public long k(long j2) {
            return this.f7933a.a(j2);
        }
    }

    public static final class DefaultSeekTimestampConverter implements SeekTimestampConverter {
        public long a(long j2) {
            return j2;
        }
    }

    protected static class SeekOperationParams {

        /* renamed from: a  reason: collision with root package name */
        private final long f7940a;

        /* renamed from: b  reason: collision with root package name */
        private final long f7941b;

        /* renamed from: c  reason: collision with root package name */
        private final long f7942c;

        /* renamed from: d  reason: collision with root package name */
        private long f7943d;

        /* renamed from: e  reason: collision with root package name */
        private long f7944e;

        /* renamed from: f  reason: collision with root package name */
        private long f7945f;

        /* renamed from: g  reason: collision with root package name */
        private long f7946g;

        /* renamed from: h  reason: collision with root package name */
        private long f7947h;

        protected SeekOperationParams(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
            this.f7940a = j2;
            this.f7941b = j3;
            this.f7943d = j4;
            this.f7944e = j5;
            this.f7945f = j6;
            this.f7946g = j7;
            this.f7942c = j8;
            this.f7947h = h(j3, j4, j5, j6, j7, j8);
        }

        protected static long h(long j2, long j3, long j4, long j5, long j6, long j7) {
            if (j5 + 1 >= j6 || j3 + 1 >= j4) {
                return j5;
            }
            long j8 = (long) (((float) (j2 - j3)) * (((float) (j6 - j5)) / ((float) (j4 - j3))));
            return Util.q(((j8 + j5) - j7) - (j8 / 20), j5, j6 - 1);
        }

        /* access modifiers changed from: private */
        public long i() {
            return this.f7946g;
        }

        /* access modifiers changed from: private */
        public long j() {
            return this.f7945f;
        }

        /* access modifiers changed from: private */
        public long k() {
            return this.f7947h;
        }

        /* access modifiers changed from: private */
        public long l() {
            return this.f7940a;
        }

        /* access modifiers changed from: private */
        public long m() {
            return this.f7941b;
        }

        private void n() {
            this.f7947h = h(this.f7941b, this.f7943d, this.f7944e, this.f7945f, this.f7946g, this.f7942c);
        }

        /* access modifiers changed from: private */
        public void o(long j2, long j3) {
            this.f7944e = j2;
            this.f7946g = j3;
            n();
        }

        /* access modifiers changed from: private */
        public void p(long j2, long j3) {
            this.f7943d = j2;
            this.f7945f = j3;
            n();
        }
    }

    protected interface SeekTimestampConverter {
        long a(long j2);
    }

    public static final class TimestampSearchResult {

        /* renamed from: d  reason: collision with root package name */
        public static final TimestampSearchResult f7948d = new TimestampSearchResult(-3, -9223372036854775807L, -1);
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final int f7949a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final long f7950b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final long f7951c;

        private TimestampSearchResult(int i2, long j2, long j3) {
            this.f7949a = i2;
            this.f7950b = j2;
            this.f7951c = j3;
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
        this.f7930b = timestampSeeker;
        this.f7932d = i2;
        this.f7929a = new BinarySearchSeekMap(seekTimestampConverter, j2, j3, j4, j5, j6, j7);
    }

    /* access modifiers changed from: protected */
    public SeekOperationParams a(long j2) {
        long j3 = j2;
        return new SeekOperationParams(j3, this.f7929a.k(j3), this.f7929a.f7935c, this.f7929a.f7936d, this.f7929a.f7937e, this.f7929a.f7938f, this.f7929a.f7939g);
    }

    public final SeekMap b() {
        return this.f7929a;
    }

    public int c(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            SeekOperationParams seekOperationParams = (SeekOperationParams) Assertions.j(this.f7931c);
            long b2 = seekOperationParams.j();
            long c2 = seekOperationParams.i();
            long d2 = seekOperationParams.k();
            if (c2 - b2 <= ((long) this.f7932d)) {
                e(false, b2);
                return g(extractorInput, b2, positionHolder);
            } else if (!i(extractorInput, d2)) {
                return g(extractorInput, d2, positionHolder);
            } else {
                extractorInput.e();
                TimestampSearchResult b3 = this.f7930b.b(extractorInput, seekOperationParams.m());
                int a2 = b3.f7949a;
                if (a2 == -3) {
                    e(false, d2);
                    return g(extractorInput, d2, positionHolder);
                } else if (a2 == -2) {
                    seekOperationParams.p(b3.f7950b, b3.f7951c);
                } else if (a2 == -1) {
                    seekOperationParams.o(b3.f7950b, b3.f7951c);
                } else if (a2 == 0) {
                    i(extractorInput, b3.f7951c);
                    e(true, b3.f7951c);
                    return g(extractorInput, b3.f7951c, positionHolder);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    public final boolean d() {
        return this.f7931c != null;
    }

    /* access modifiers changed from: protected */
    public final void e(boolean z2, long j2) {
        this.f7931c = null;
        this.f7930b.a();
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
        positionHolder.f8069a = j2;
        return 1;
    }

    public final void h(long j2) {
        SeekOperationParams seekOperationParams = this.f7931c;
        if (seekOperationParams == null || seekOperationParams.l() != j2) {
            this.f7931c = a(j2);
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
