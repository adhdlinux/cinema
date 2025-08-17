package kotlin.text;

public final /* synthetic */ class c {
    public static /* synthetic */ long a(long j2, long j3) {
        if (j3 < 0) {
            return (j2 ^ Long.MIN_VALUE) < (j3 ^ Long.MIN_VALUE) ? 0 : 1;
        }
        if (j2 >= 0) {
            return j2 / j3;
        }
        int i2 = 1;
        long j4 = ((j2 >>> 1) / j3) << 1;
        if (((j2 - (j4 * j3)) ^ Long.MIN_VALUE) < (j3 ^ Long.MIN_VALUE)) {
            i2 = 0;
        }
        return j4 + ((long) i2);
    }
}
