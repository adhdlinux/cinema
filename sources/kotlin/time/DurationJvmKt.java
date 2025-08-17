package kotlin.time;

import java.text.DecimalFormat;

public final class DurationJvmKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f40572a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f40573b;

    static {
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        f40573b = threadLocalArr;
    }

    public static final boolean a() {
        return f40572a;
    }
}
