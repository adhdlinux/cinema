package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    public int e(int i2, int i3) {
        return ThreadLocalRandom.current().nextInt(i2, i3);
    }

    public Random g() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Intrinsics.e(current, "current()");
        return current;
    }
}
