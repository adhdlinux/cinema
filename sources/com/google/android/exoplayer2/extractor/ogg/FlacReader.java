package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class FlacReader extends StreamReader {

    /* renamed from: n  reason: collision with root package name */
    private FlacStreamMetadata f24715n;

    /* renamed from: o  reason: collision with root package name */
    private FlacOggSeeker f24716o;

    private static final class FlacOggSeeker implements OggSeeker {

        /* renamed from: a  reason: collision with root package name */
        private FlacStreamMetadata f24717a;

        /* renamed from: b  reason: collision with root package name */
        private FlacStreamMetadata.SeekTable f24718b;

        /* renamed from: c  reason: collision with root package name */
        private long f24719c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f24720d = -1;

        public FlacOggSeeker(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.SeekTable seekTable) {
            this.f24717a = flacStreamMetadata;
            this.f24718b = seekTable;
        }

        public long a(ExtractorInput extractorInput) {
            long j2 = this.f24720d;
            if (j2 < 0) {
                return -1;
            }
            long j3 = -(j2 + 2);
            this.f24720d = -1;
            return j3;
        }

        public SeekMap b() {
            boolean z2;
            if (this.f24719c != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.g(z2);
            return new FlacSeekTableSeekMap(this.f24717a, this.f24719c);
        }

        public void c(long j2) {
            long[] jArr = this.f24718b.f24220a;
            this.f24720d = jArr[Util.i(jArr, j2, true, true)];
        }

        public void d(long j2) {
            this.f24719c = j2;
        }
    }

    FlacReader() {
    }

    private int n(ParsableByteArray parsableByteArray) {
        int i2 = (parsableByteArray.e()[2] & 255) >> 4;
        if (i2 == 6 || i2 == 7) {
            parsableByteArray.V(4);
            parsableByteArray.O();
        }
        int j2 = FlacFrameReader.j(parsableByteArray, i2);
        parsableByteArray.U(0);
        return j2;
    }

    private static boolean o(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean p(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() >= 5 && parsableByteArray.H() == 127 && parsableByteArray.J() == 1179402563) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public long f(ParsableByteArray parsableByteArray) {
        if (!o(parsableByteArray.e())) {
            return -1;
        }
        return (long) n(parsableByteArray);
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean i(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) {
        byte[] e2 = parsableByteArray.e();
        FlacStreamMetadata flacStreamMetadata = this.f24715n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(e2, 17);
            this.f24715n = flacStreamMetadata2;
            setupData.f24757a = flacStreamMetadata2.g(Arrays.copyOfRange(e2, 9, parsableByteArray.g()), (Metadata) null);
            return true;
        } else if ((e2[0] & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.SeekTable g2 = FlacMetadataReader.g(parsableByteArray);
            FlacStreamMetadata b2 = flacStreamMetadata.b(g2);
            this.f24715n = b2;
            this.f24716o = new FlacOggSeeker(b2, g2);
            return true;
        } else if (!o(e2)) {
            return true;
        } else {
            FlacOggSeeker flacOggSeeker = this.f24716o;
            if (flacOggSeeker != null) {
                flacOggSeeker.d(j2);
                setupData.f24758b = this.f24716o;
            }
            Assertions.e(setupData.f24757a);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f24715n = null;
            this.f24716o = null;
        }
    }
}
