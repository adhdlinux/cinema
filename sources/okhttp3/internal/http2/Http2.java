package okhttp3.internal.http2;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.ByteString;

public final class Http2 {
    private static final String[] BINARY;
    public static final ByteString CONNECTION_PREFACE = ByteString.f41331e.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    private static final String[] FLAGS = new String[64];
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = new Http2();
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    static {
        String[] strArr = new String[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        for (int i2 = 0; i2 < 256; i2++) {
            String binaryString = Integer.toBinaryString(i2);
            Intrinsics.e(binaryString, "toBinaryString(it)");
            strArr[i2] = StringsKt__StringsJVMKt.B(Util.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        String[] strArr2 = FLAGS;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = strArr2[1] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = iArr2[i3];
            int i5 = iArr[0];
            String[] strArr3 = FLAGS;
            int i6 = i5 | i4;
            strArr3[i6] = strArr3[i5] + '|' + strArr3[i4];
            strArr3[i6 | 8] = strArr3[i5] + '|' + strArr3[i4] + "|PADDED";
        }
        int length = FLAGS.length;
        for (int i7 = 0; i7 < length; i7++) {
            String[] strArr4 = FLAGS;
            if (strArr4[i7] == null) {
                strArr4[i7] = BINARY[i7];
            }
        }
    }

    private Http2() {
    }

    public final String formatFlags(int i2, int i3) {
        String str;
        if (i3 == 0) {
            return "";
        }
        if (!(i2 == 2 || i2 == 3)) {
            if (i2 == 4 || i2 == 6) {
                if (i3 == 1) {
                    return "ACK";
                }
                return BINARY[i3];
            } else if (!(i2 == 7 || i2 == 8)) {
                String[] strArr = FLAGS;
                if (i3 < strArr.length) {
                    str = strArr[i3];
                    Intrinsics.c(str);
                } else {
                    str = BINARY[i3];
                }
                String str2 = str;
                if (i2 == 5 && (i3 & 4) != 0) {
                    return StringsKt__StringsJVMKt.C(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
                if (i2 != 0 || (i3 & 32) == 0) {
                    return str2;
                }
                return StringsKt__StringsJVMKt.C(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            }
        }
        return BINARY[i3];
    }

    public final String formattedType$okhttp(int i2) {
        String[] strArr = FRAME_NAMES;
        if (i2 < strArr.length) {
            return strArr[i2];
        }
        return Util.format("0x%02x", Integer.valueOf(i2));
    }

    public final String frameLog(boolean z2, int i2, int i3, int i4, int i5) {
        String str;
        String formattedType$okhttp = formattedType$okhttp(i4);
        String formatFlags = formatFlags(i4, i5);
        if (z2) {
            str = "<<";
        } else {
            str = ">>";
        }
        return Util.format("%s 0x%08x %5d %-13s %s", str, Integer.valueOf(i2), Integer.valueOf(i3), formattedType$okhttp, formatFlags);
    }
}
