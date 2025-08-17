package com.facebook.imageutils;

import com.facebook.infer.annotation.Nullsafe;
import java.io.IOException;
import java.io.InputStream;

@Nullsafe(Nullsafe.Mode.STRICT)
class StreamProcessor {
    StreamProcessor() {
    }

    public static int readPackedInt(InputStream inputStream, int i2, boolean z2) throws IOException {
        int i3;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int read = inputStream.read();
            if (read != -1) {
                if (z2) {
                    i3 = (read & JfifUtil.MARKER_FIRST_BYTE) << (i4 * 8);
                } else {
                    i5 <<= 8;
                    i3 = read & JfifUtil.MARKER_FIRST_BYTE;
                }
                i5 |= i3;
                i4++;
            } else {
                throw new IOException("no more bytes");
            }
        }
        return i5;
    }
}
