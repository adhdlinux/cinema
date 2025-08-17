package okhttp3;

import com.facebook.ads.internal.c.a;
import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator<String> {
    CipherSuite$Companion$ORDER_BY_NAME$1() {
    }

    public int compare(String str, String str2) {
        Intrinsics.f(str, a.f20042a);
        Intrinsics.f(str2, "b");
        int min = Math.min(str.length(), str2.length());
        int i2 = 4;
        while (i2 < min) {
            char charAt = str.charAt(i2);
            char charAt2 = str2.charAt(i2);
            if (charAt == charAt2) {
                i2++;
            } else if (Intrinsics.h(charAt, charAt2) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
        int length = str.length();
        int length2 = str2.length();
        if (length == length2) {
            return 0;
        }
        if (length < length2) {
            return -1;
        }
        return 1;
    }
}
