package kotlin.random;

import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

public abstract class Random {

    /* renamed from: b  reason: collision with root package name */
    public static final Default f40443b = new Default((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final Random f40444c = PlatformImplementationsKt.f40382a.b();

    public static final class Default extends Random implements Serializable {
        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public int b(int i2) {
            return Random.f40444c.b(i2);
        }

        public int c() {
            return Random.f40444c.c();
        }

        public int d(int i2) {
            return Random.f40444c.d(i2);
        }

        public int e(int i2, int i3) {
            return Random.f40444c.e(i2, i3);
        }

        public long f() {
            return Random.f40444c.f();
        }
    }

    public abstract int b(int i2);

    public int c() {
        return b(32);
    }

    public int d(int i2) {
        return e(0, i2);
    }

    public int e(int i2, int i3) {
        int i4;
        int c2;
        int i5;
        int c3;
        boolean z2;
        RandomKt.b(i2, i3);
        int i6 = i3 - i2;
        if (i6 > 0 || i6 == Integer.MIN_VALUE) {
            if (((-i6) & i6) == i6) {
                i4 = b(RandomKt.c(i6));
            } else {
                do {
                    c2 = c() >>> 1;
                    i5 = c2 % i6;
                } while ((c2 - i5) + (i6 - 1) < 0);
                i4 = i5;
            }
            return i2 + i4;
        }
        do {
            c3 = c();
            z2 = false;
            if (i2 <= c3 && c3 < i3) {
                z2 = true;
                continue;
            }
        } while (!z2);
        return c3;
    }

    public long f() {
        return (((long) c()) << 32) + ((long) c());
    }
}
