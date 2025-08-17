package com.google.android.exoplayer2.extractor.flac;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.a;
import java.io.IOException;

final class FlacBinarySearchSeeker extends BinarySearchSeeker {

    private static final class FlacTimestampSeeker implements BinarySearchSeeker.TimestampSeeker {

        /* renamed from: a  reason: collision with root package name */
        private final FlacStreamMetadata f24342a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24343b;

        /* renamed from: c  reason: collision with root package name */
        private final FlacFrameReader.SampleNumberHolder f24344c;

        private long c(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.g() < extractorInput.getLength() - 6 && !FlacFrameReader.h(extractorInput, this.f24342a, this.f24343b, this.f24344c)) {
                extractorInput.h(1);
            }
            if (extractorInput.g() < extractorInput.getLength() - 6) {
                return this.f24344c.f24204a;
            }
            extractorInput.h((int) (extractorInput.getLength() - extractorInput.g()));
            return this.f24342a.f24217j;
        }

        public /* synthetic */ void a() {
            a.a(this);
        }

        public BinarySearchSeeker.TimestampSearchResult b(ExtractorInput extractorInput, long j2) throws IOException {
            long position = extractorInput.getPosition();
            long c2 = c(extractorInput);
            long g2 = extractorInput.g();
            extractorInput.h(Math.max(6, this.f24342a.f24210c));
            long c3 = c(extractorInput);
            long g3 = extractorInput.g();
            if (c2 <= j2 && c3 > j2) {
                return BinarySearchSeeker.TimestampSearchResult.e(g2);
            }
            if (c3 <= j2) {
                return BinarySearchSeeker.TimestampSearchResult.f(c3, g3);
            }
            return BinarySearchSeeker.TimestampSearchResult.d(c2, position);
        }

        private FlacTimestampSeeker(FlacStreamMetadata flacStreamMetadata, int i2) {
            this.f24342a = flacStreamMetadata;
            this.f24343b = i2;
            this.f24344c = new FlacFrameReader.SampleNumberHolder();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FlacBinarySearchSeeker(com.google.android.exoplayer2.extractor.FlacStreamMetadata r17, int r18, long r19, long r21) {
        /*
            r16 = this;
            r0 = r17
            java.util.Objects.requireNonNull(r17)
            j0.a r1 = new j0.a
            r1.<init>(r0)
            com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker r2 = new com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker$FlacTimestampSeeker
            r3 = 0
            r4 = r18
            r2.<init>(r0, r4)
            long r3 = r17.f()
            r5 = 0
            long r7 = r0.f24217j
            long r13 = r17.d()
            r9 = 6
            int r0 = r0.f24210c
            int r15 = java.lang.Math.max(r9, r0)
            r0 = r16
            r9 = r19
            r11 = r21
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.flac.FlacBinarySearchSeeker.<init>(com.google.android.exoplayer2.extractor.FlacStreamMetadata, int, long, long):void");
    }
}
