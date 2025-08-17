package kotlin.random;

import java.util.Random;

public abstract class AbstractPlatformRandom extends Random {
    public int b(int i2) {
        return RandomKt.d(g().nextInt(), i2);
    }

    public int c() {
        return g().nextInt();
    }

    public int d(int i2) {
        return g().nextInt(i2);
    }

    public long f() {
        return g().nextLong();
    }

    public abstract Random g();
}
