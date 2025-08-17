package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.facebook.imageutils.JfifUtil;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.io.IOException;

public final class FlacFrameReader {

    public static final class SampleNumberHolder {

        /* renamed from: a  reason: collision with root package name */
        public long f8015a;
    }

    private FlacFrameReader() {
    }

    private static boolean a(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i2) {
        int j2 = j(parsableByteArray, i2);
        if (j2 == -1 || j2 > flacStreamMetadata.f8020b) {
            return false;
        }
        return true;
    }

    private static boolean b(ParsableByteArray parsableByteArray, int i2) {
        if (parsableByteArray.H() == Util.y(parsableByteArray.e(), i2, parsableByteArray.f() - 1, 0)) {
            return true;
        }
        return false;
    }

    private static boolean c(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, boolean z2, SampleNumberHolder sampleNumberHolder) {
        try {
            long O = parsableByteArray.O();
            if (!z2) {
                O *= (long) flacStreamMetadata.f8020b;
            }
            sampleNumberHolder.f8015a = O;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i2, SampleNumberHolder sampleNumberHolder) {
        boolean z2;
        boolean z3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        FlacStreamMetadata flacStreamMetadata2 = flacStreamMetadata;
        int f2 = parsableByteArray.f();
        long J = parsableByteArray.J();
        long j2 = J >>> 16;
        if (j2 != ((long) i2)) {
            return false;
        }
        if ((j2 & 1) == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = (int) ((J >> 12) & 15);
        int i4 = (int) ((J >> 8) & 15);
        int i5 = (int) (15 & (J >> 4));
        int i6 = (int) ((J >> 1) & 7);
        if ((J & 1) == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!g(i5, flacStreamMetadata2) || !f(i6, flacStreamMetadata2) || z3 || !c(parsableByteArray2, flacStreamMetadata2, z2, sampleNumberHolder) || !a(parsableByteArray2, flacStreamMetadata2, i3) || !e(parsableByteArray2, flacStreamMetadata2, i4) || !b(parsableByteArray2, f2)) {
            return false;
        }
        return true;
    }

    private static boolean e(ParsableByteArray parsableByteArray, FlacStreamMetadata flacStreamMetadata, int i2) {
        int i3 = flacStreamMetadata.f8023e;
        if (i2 == 0) {
            return true;
        }
        if (i2 <= 11) {
            if (i2 == flacStreamMetadata.f8024f) {
                return true;
            }
            return false;
        } else if (i2 == 12) {
            if (parsableByteArray.H() * 1000 == i3) {
                return true;
            }
            return false;
        } else if (i2 > 14) {
            return false;
        } else {
            int N = parsableByteArray.N();
            if (i2 == 14) {
                N *= 10;
            }
            if (N == i3) {
                return true;
            }
            return false;
        }
    }

    private static boolean f(int i2, FlacStreamMetadata flacStreamMetadata) {
        return i2 == 0 || i2 == flacStreamMetadata.f8027i;
    }

    private static boolean g(int i2, FlacStreamMetadata flacStreamMetadata) {
        if (i2 <= 7) {
            if (i2 == flacStreamMetadata.f8025g - 1) {
                return true;
            }
            return false;
        } else if (i2 > 10 || flacStreamMetadata.f8025g != 2) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean h(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata, int i2, SampleNumberHolder sampleNumberHolder) throws IOException {
        long g2 = extractorInput.g();
        byte[] bArr = new byte[2];
        extractorInput.m(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i2) {
            extractorInput.e();
            extractorInput.h((int) (g2 - extractorInput.getPosition()));
            return false;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        System.arraycopy(bArr, 0, parsableByteArray.e(), 0, 2);
        parsableByteArray.T(ExtractorUtil.c(extractorInput, parsableByteArray.e(), 2, 14));
        extractorInput.e();
        extractorInput.h((int) (g2 - extractorInput.getPosition()));
        return d(parsableByteArray, flacStreamMetadata, i2, sampleNumberHolder);
    }

    public static long i(ExtractorInput extractorInput, FlacStreamMetadata flacStreamMetadata) throws IOException {
        int i2;
        extractorInput.e();
        boolean z2 = true;
        extractorInput.h(1);
        byte[] bArr = new byte[1];
        extractorInput.m(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z2 = false;
        }
        extractorInput.h(2);
        if (z2) {
            i2 = 7;
        } else {
            i2 = 6;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(i2);
        parsableByteArray.T(ExtractorUtil.c(extractorInput, parsableByteArray.e(), 0, i2));
        extractorInput.e();
        SampleNumberHolder sampleNumberHolder = new SampleNumberHolder();
        if (c(parsableByteArray, flacStreamMetadata, z2, sampleNumberHolder)) {
            return sampleNumberHolder.f8015a;
        }
        throw ParserException.a((String) null, (Throwable) null);
    }

    public static int j(ParsableByteArray parsableByteArray, int i2) {
        switch (i2) {
            case 1:
                return JfifUtil.MARKER_SOFn;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i2 - 2);
            case 6:
                return parsableByteArray.H() + 1;
            case 7:
                return parsableByteArray.N() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return UserVerificationMethods.USER_VERIFY_HANDPRINT << (i2 - 8);
            default:
                return -1;
        }
    }
}
