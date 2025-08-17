package androidx.media3.extractor.wav;

import android.util.Pair;
import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.ExtractorInput;
import java.io.IOException;

final class WavHeaderReader {

    private static final class ChunkHeader {

        /* renamed from: a  reason: collision with root package name */
        public final int f9592a;

        /* renamed from: b  reason: collision with root package name */
        public final long f9593b;

        private ChunkHeader(int i2, long j2) {
            this.f9592a = i2;
            this.f9593b = j2;
        }

        public static ChunkHeader a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
            extractorInput.m(parsableByteArray.e(), 0, 8);
            parsableByteArray.U(0);
            return new ChunkHeader(parsableByteArray.q(), parsableByteArray.x());
        }
    }

    private WavHeaderReader() {
    }

    public static boolean a(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        int i2 = ChunkHeader.a(extractorInput, parsableByteArray).f9592a;
        if (i2 != 1380533830 && i2 != 1380333108) {
            return false;
        }
        extractorInput.m(parsableByteArray.e(), 0, 4);
        parsableByteArray.U(0);
        int q2 = parsableByteArray.q();
        if (q2 == 1463899717) {
            return true;
        }
        Log.c("WavHeaderReader", "Unsupported form type: " + q2);
        return false;
    }

    public static WavFormat b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        byte[] bArr;
        ExtractorInput extractorInput2 = extractorInput;
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        ChunkHeader d2 = d(1718449184, extractorInput2, parsableByteArray);
        if (d2.f9593b >= 16) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assertions.h(z2);
        extractorInput2.m(parsableByteArray.e(), 0, 16);
        parsableByteArray.U(0);
        int z3 = parsableByteArray.z();
        int z4 = parsableByteArray.z();
        int y2 = parsableByteArray.y();
        int y3 = parsableByteArray.y();
        int z5 = parsableByteArray.z();
        int z6 = parsableByteArray.z();
        int i2 = ((int) d2.f9593b) - 16;
        if (i2 > 0) {
            byte[] bArr2 = new byte[i2];
            extractorInput2.m(bArr2, 0, i2);
            bArr = bArr2;
        } else {
            bArr = Util.f4719f;
        }
        extractorInput2.k((int) (extractorInput.g() - extractorInput.getPosition()));
        return new WavFormat(z3, z4, y2, y3, z5, z6, bArr);
    }

    public static long c(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader a2 = ChunkHeader.a(extractorInput, parsableByteArray);
        if (a2.f9592a != 1685272116) {
            extractorInput.e();
            return -1;
        }
        extractorInput.h(8);
        parsableByteArray.U(0);
        extractorInput.m(parsableByteArray.e(), 0, 8);
        long v2 = parsableByteArray.v();
        extractorInput.k(((int) a2.f9593b) + 8);
        return v2;
    }

    private static ChunkHeader d(int i2, ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
        ChunkHeader a2 = ChunkHeader.a(extractorInput, parsableByteArray);
        while (a2.f9592a != i2) {
            Log.h("WavHeaderReader", "Ignoring unknown WAV chunk: " + a2.f9592a);
            long j2 = a2.f9593b;
            long j3 = 8 + j2;
            if (j2 % 2 != 0) {
                j3++;
            }
            if (j3 <= 2147483647L) {
                extractorInput.k((int) j3);
                a2 = ChunkHeader.a(extractorInput, parsableByteArray);
            } else {
                throw ParserException.d("Chunk is too large (~2GB+) to skip; id: " + a2.f9592a);
            }
        }
        return a2;
    }

    public static Pair<Long, Long> e(ExtractorInput extractorInput) throws IOException {
        extractorInput.e();
        ChunkHeader d2 = d(1684108385, extractorInput, new ParsableByteArray(8));
        extractorInput.k(8);
        return Pair.create(Long.valueOf(extractorInput.getPosition()), Long.valueOf(d2.f9593b));
    }
}
