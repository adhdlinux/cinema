package androidx.media3.extractor.ogg;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.FlacFrameReader;
import androidx.media3.extractor.FlacMetadataReader;
import androidx.media3.extractor.FlacSeekTableSeekMap;
import androidx.media3.extractor.FlacStreamMetadata;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.ogg.StreamReader;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class FlacReader extends StreamReader {

    /* renamed from: n  reason: collision with root package name */
    private FlacStreamMetadata f8718n;

    /* renamed from: o  reason: collision with root package name */
    private FlacOggSeeker f8719o;

    private static final class FlacOggSeeker implements OggSeeker {

        /* renamed from: a  reason: collision with root package name */
        private FlacStreamMetadata f8720a;

        /* renamed from: b  reason: collision with root package name */
        private FlacStreamMetadata.SeekTable f8721b;

        /* renamed from: c  reason: collision with root package name */
        private long f8722c = -1;

        /* renamed from: d  reason: collision with root package name */
        private long f8723d = -1;

        public FlacOggSeeker(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.SeekTable seekTable) {
            this.f8720a = flacStreamMetadata;
            this.f8721b = seekTable;
        }

        public long a(ExtractorInput extractorInput) {
            long j2 = this.f8723d;
            if (j2 < 0) {
                return -1;
            }
            long j3 = -(j2 + 2);
            this.f8723d = -1;
            return j3;
        }

        public SeekMap b() {
            boolean z2;
            if (this.f8722c != -1) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assertions.h(z2);
            return new FlacSeekTableSeekMap(this.f8720a, this.f8722c);
        }

        public void c(long j2) {
            long[] jArr = this.f8721b.f8031a;
            this.f8723d = jArr[Util.h(jArr, j2, true, true)];
        }

        public void d(long j2) {
            this.f8722c = j2;
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
    public boolean h(ParsableByteArray parsableByteArray, long j2, StreamReader.SetupData setupData) {
        byte[] e2 = parsableByteArray.e();
        FlacStreamMetadata flacStreamMetadata = this.f8718n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(e2, 17);
            this.f8718n = flacStreamMetadata2;
            setupData.f8760a = flacStreamMetadata2.g(Arrays.copyOfRange(e2, 9, parsableByteArray.g()), (Metadata) null);
            return true;
        } else if ((e2[0] & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.SeekTable f2 = FlacMetadataReader.f(parsableByteArray);
            FlacStreamMetadata b2 = flacStreamMetadata.b(f2);
            this.f8718n = b2;
            this.f8719o = new FlacOggSeeker(b2, f2);
            return true;
        } else if (!o(e2)) {
            return true;
        } else {
            FlacOggSeeker flacOggSeeker = this.f8719o;
            if (flacOggSeeker != null) {
                flacOggSeeker.d(j2);
                setupData.f8761b = this.f8719o;
            }
            Assertions.f(setupData.f8760a);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void l(boolean z2) {
        super.l(z2);
        if (z2) {
            this.f8718n = null;
            this.f8719o = null;
        }
    }
}
