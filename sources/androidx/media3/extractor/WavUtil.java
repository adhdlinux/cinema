package androidx.media3.extractor;

import androidx.media3.common.util.Util;

public final class WavUtil {
    private WavUtil() {
    }

    public static int a(int i2, int i3) {
        if (i2 != 1) {
            if (i2 == 3) {
                return i3 == 32 ? 4 : 0;
            }
            if (i2 != 65534) {
                return 0;
            }
        }
        return Util.g0(i3);
    }
}
