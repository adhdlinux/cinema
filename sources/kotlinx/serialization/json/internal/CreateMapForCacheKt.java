package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class CreateMapForCacheKt {
    public static final <K, V> Map<K, V> a(int i2) {
        return new ConcurrentHashMap(i2);
    }
}
