package kotlinx.serialization.internal;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

public final class ClassValueCache$initClassValue$1 extends ClassValue<CacheEntry<T>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ClassValueCache<T> f40963a;

    ClassValueCache$initClassValue$1(ClassValueCache<T> classValueCache) {
        this.f40963a = classValueCache;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public CacheEntry<T> computeValue(Class<?> cls) {
        Intrinsics.f(cls, "type");
        return new CacheEntry<>((KSerializer) this.f40963a.f40961a.invoke(JvmClassMappingKt.c(cls)));
    }
}
