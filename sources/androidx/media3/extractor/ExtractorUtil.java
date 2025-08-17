package androidx.media3.extractor;

import androidx.media3.common.ParserException;
import java.io.EOFException;
import java.io.IOException;
import org.checkerframework.dataflow.qual.Pure;

public final class ExtractorUtil {
    private ExtractorUtil() {
    }

    @Pure
    public static void a(boolean z2, String str) throws ParserException {
        if (!z2) {
            throw ParserException.a(str, (Throwable) null);
        }
    }

    public static boolean b(ExtractorInput extractorInput, byte[] bArr, int i2, int i3, boolean z2) throws IOException {
        try {
            return extractorInput.c(bArr, i2, i3, z2);
        } catch (EOFException e2) {
            if (z2) {
                return false;
            }
            throw e2;
        }
    }

    public static int c(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i3) {
            int j2 = extractorInput.j(bArr, i2 + i4, i3 - i4);
            if (j2 == -1) {
                break;
            }
            i4 += j2;
        }
        return i4;
    }

    public static boolean d(ExtractorInput extractorInput, byte[] bArr, int i2, int i3) throws IOException {
        try {
            extractorInput.readFully(bArr, i2, i3);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(ExtractorInput extractorInput, int i2) throws IOException {
        try {
            extractorInput.k(i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
