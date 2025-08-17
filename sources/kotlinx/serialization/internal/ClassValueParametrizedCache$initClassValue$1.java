package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

public final class ClassValueParametrizedCache$initClassValue$1 extends ClassValue<ParametrizedCacheEntry<T>> {
    ClassValueParametrizedCache$initClassValue$1() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ParametrizedCacheEntry<T> computeValue(Class<?> cls) {
        Intrinsics.f(cls, "type");
        return new ParametrizedCacheEntry<>();
    }
}
