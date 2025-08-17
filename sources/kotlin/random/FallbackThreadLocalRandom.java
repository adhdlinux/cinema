package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.Intrinsics;

public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {

    /* renamed from: d  reason: collision with root package name */
    private final FallbackThreadLocalRandom$implStorage$1 f40442d = new FallbackThreadLocalRandom$implStorage$1();

    public Random g() {
        Object obj = this.f40442d.get();
        Intrinsics.e(obj, "implStorage.get()");
        return (Random) obj;
    }
}
