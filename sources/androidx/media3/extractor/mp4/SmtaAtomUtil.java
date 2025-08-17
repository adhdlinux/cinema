package androidx.media3.extractor.mp4;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;

public final class SmtaAtomUtil {
    private SmtaAtomUtil() {
    }

    private static int a(int i2, ParsableByteArray parsableByteArray, int i3) {
        if (i2 == 12) {
            return 240;
        }
        if (i2 == 13) {
            return 120;
        }
        if (i2 == 21 && parsableByteArray.a() >= 8 && parsableByteArray.f() + 8 <= i3) {
            int q2 = parsableByteArray.q();
            int q3 = parsableByteArray.q();
            if (q2 >= 12 && q3 == 1936877170) {
                return parsableByteArray.I();
            }
        }
        return -2147483647;
    }

    public static Metadata b(ParsableByteArray parsableByteArray, int i2) {
        parsableByteArray.V(12);
        while (parsableByteArray.f() < i2) {
            int f2 = parsableByteArray.f();
            int q2 = parsableByteArray.q();
            if (parsableByteArray.q() != 1935766900) {
                parsableByteArray.U(f2 + q2);
            } else if (q2 < 16) {
                return null;
            } else {
                parsableByteArray.V(4);
                int i3 = -1;
                int i4 = 0;
                for (int i5 = 0; i5 < 2; i5++) {
                    int H = parsableByteArray.H();
                    int H2 = parsableByteArray.H();
                    if (H == 0) {
                        i3 = H2;
                    } else if (H == 1) {
                        i4 = H2;
                    }
                }
                int a2 = a(i3, parsableByteArray, i2);
                if (a2 == -2147483647) {
                    return null;
                }
                return new Metadata(new SmtaMetadataEntry((float) a2, i4));
            }
        }
        return null;
    }
}
