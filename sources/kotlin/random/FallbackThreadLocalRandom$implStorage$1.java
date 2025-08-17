package kotlin.random;

import java.util.Random;

public final class FallbackThreadLocalRandom$implStorage$1 extends ThreadLocal<Random> {
    FallbackThreadLocalRandom$implStorage$1() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Random initialValue() {
        return new Random();
    }
}
