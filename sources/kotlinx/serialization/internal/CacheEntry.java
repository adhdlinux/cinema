package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

final class CacheEntry<T> {

    /* renamed from: a  reason: collision with root package name */
    public final KSerializer<T> f40954a;

    public CacheEntry(KSerializer<T> kSerializer) {
        this.f40954a = kSerializer;
    }
}
