package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

final class ParametrizedCacheEntry<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap<List<KType>, Result<KSerializer<T>>> f41043a = new ConcurrentHashMap<>();
}
