package androidx.media3.extractor.ts;

import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.TimestampAdjuster;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.BinarySearchSeeker;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class TsBinarySearchSeeker extends BinarySearchSeeker {

    private static final class TsPcrSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a  reason: collision with root package name */
        private final TimestampAdjuster f9498a;

        /* renamed from: b  reason: collision with root package name */
        private final ParsableByteArray f9499b = new ParsableByteArray();

        /* renamed from: c  reason: collision with root package name */
        private final int f9500c;

        /* renamed from: d  reason: collision with root package name */
        private final int f9501d;

        public TsPcrSeeker(int i2, TimestampAdjuster timestampAdjuster, int i3) {
            this.f9500c = i2;
            this.f9498a = timestampAdjuster;
            this.f9501d = i3;
        }

        private BinarySearchSeeker.TimestampSearchResult c(ParsableByteArray parsableByteArray, long j2, long j3) {
            int a2;
            int i2;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            long j4 = j3;
            int g2 = parsableByteArray.g();
            long j5 = -1;
            long j6 = -1;
            long j7 = -9223372036854775807L;
            while (parsableByteArray.a() >= 188 && (i2 = a2 + 188) <= g2) {
                long c2 = TsUtil.c(parsableByteArray2, (a2 = TsUtil.a(parsableByteArray.e(), parsableByteArray.f(), g2)), this.f9500c);
                if (c2 != -9223372036854775807L) {
                    long b2 = this.f9498a.b(c2);
                    if (b2 > j2) {
                        if (j7 == -9223372036854775807L) {
                            return BinarySearchSeeker.TimestampSearchResult.d(b2, j4);
                        }
                        return BinarySearchSeeker.TimestampSearchResult.e(j4 + j6);
                    } else if (100000 + b2 > j2) {
                        return BinarySearchSeeker.TimestampSearchResult.e(j4 + ((long) a2));
                    } else {
                        j6 = (long) a2;
                        j7 = b2;
                    }
                }
                parsableByteArray2.U(i2);
                j5 = (long) i2;
            }
            if (j7 != -9223372036854775807L) {
                return BinarySearchSeeker.TimestampSearchResult.f(j7, j4 + j5);
            }
            return BinarySearchSeeker.TimestampSearchResult.f7948d;
        }

        public void a() {
            this.f9499b.R(Util.f4719f);
        }

        public BinarySearchSeeker.TimestampSearchResult b(ExtractorInput extractorInput, long j2) throws IOException {
            long position = extractorInput.getPosition();
            int min = (int) Math.min((long) this.f9501d, extractorInput.getLength() - position);
            this.f9499b.Q(min);
            extractorInput.m(this.f9499b.e(), 0, min);
            return c(this.f9499b, j2, position);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TsBinarySearchSeeker(androidx.media3.common.util.TimestampAdjuster r17, long r18, long r20, int r22, int r23) {
        /*
            r16 = this;
            androidx.media3.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter r1 = new androidx.media3.extractor.BinarySearchSeeker$DefaultSeekTimestampConverter
            r1.<init>()
            androidx.media3.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker r2 = new androidx.media3.extractor.ts.TsBinarySearchSeeker$TsPcrSeeker
            r0 = r17
            r3 = r22
            r4 = r23
            r2.<init>(r3, r0, r4)
            r5 = 0
            r3 = 1
            long r7 = r18 + r3
            r9 = 0
            r13 = 188(0xbc, double:9.3E-322)
            r15 = 940(0x3ac, float:1.317E-42)
            r0 = r16
            r3 = r18
            r11 = r20
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.TsBinarySearchSeeker.<init>(androidx.media3.common.util.TimestampAdjuster, long, long, int, int):void");
    }
}
