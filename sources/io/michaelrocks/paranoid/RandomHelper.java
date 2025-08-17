package io.michaelrocks.paranoid;

import okhttp3.internal.ws.WebSocketProtocol;

public class RandomHelper {
    private RandomHelper() {
    }

    public static long a(long j2) {
        short s2 = (short) ((int) (j2 & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        short s3 = (short) ((int) ((j2 >>> 16) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
        short s4 = (short) (s3 ^ s2);
        return ((((long) b(s4, 10)) | (((long) ((short) (b((short) (s2 + s3), 9) + s2))) << 16)) << 16) | ((long) ((short) (((short) (b(s2, 13) ^ s4)) ^ (s4 << 5))));
    }

    private static short b(short s2, int i2) {
        return (short) ((s2 >>> (32 - i2)) | (s2 << i2));
    }

    public static long c(long j2) {
        long j3 = (j2 ^ (j2 >>> 33)) * 7109453100751455733L;
        return ((j3 ^ (j3 >>> 28)) * -3808689974395783757L) >>> 32;
    }
}
