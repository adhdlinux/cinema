package androidx.media3.common.util;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

public final class CodecSpecificDataUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f4617a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f4618b = {"", "A", "B", "C"};

    private CodecSpecificDataUtil() {
    }

    public static String a(int i2, int i3, int i4) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
    }

    public static List<byte[]> b(boolean z2) {
        return Collections.singletonList(z2 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(int i2, boolean z2, int i3, int i4, int[] iArr, int i5) {
        char c2;
        Object[] objArr = new Object[5];
        objArr[0] = f4618b[i2];
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = Integer.valueOf(i4);
        if (z2) {
            c2 = 'H';
        } else {
            c2 = 'L';
        }
        objArr[3] = Character.valueOf(c2);
        objArr[4] = Integer.valueOf(i5);
        StringBuilder sb = new StringBuilder(Util.G("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i6 = 0; i6 < length; i6++) {
            sb.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i6])}));
        }
        return sb.toString();
    }

    public static byte[] d(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = f4617a;
        byte[] bArr3 = new byte[(bArr2.length + i3)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length, i3);
        return bArr3;
    }

    public static Pair<Integer, Integer> e(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        parsableByteArray.U(9);
        int H = parsableByteArray.H();
        parsableByteArray.U(20);
        return Pair.create(Integer.valueOf(parsableByteArray.L()), Integer.valueOf(H));
    }

    public static boolean f(List<byte[]> list) {
        if (list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1) {
            return true;
        }
        return false;
    }
}
