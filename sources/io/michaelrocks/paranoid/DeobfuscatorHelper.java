package io.michaelrocks.paranoid;

import okhttp3.internal.ws.WebSocketProtocol;

public class DeobfuscatorHelper {
    private DeobfuscatorHelper() {
    }

    private static long a(int i2, String[] strArr, long j2) {
        return (((long) strArr[i2 / 8191].charAt(i2 % 8191)) << 32) ^ RandomHelper.a(j2);
    }

    public static String b(long j2, String[] strArr) {
        long a2 = RandomHelper.a(RandomHelper.c(4294967295L & j2));
        long j3 = (a2 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
        long a3 = RandomHelper.a(a2);
        int i2 = (int) (((j2 >>> 32) ^ j3) ^ ((a3 >>> 16) & -65536));
        long a4 = a(i2, strArr, a3);
        int i3 = (int) ((a4 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
        char[] cArr = new char[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            a4 = a(i2 + i4 + 1, strArr, a4);
            cArr[i4] = (char) ((int) ((a4 >>> 32) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        }
        return new String(cArr);
    }
}
