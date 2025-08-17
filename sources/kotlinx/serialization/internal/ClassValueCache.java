package kotlinx.serialization.internal;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;

final class ClassValueCache<T> implements SerializerCache<T> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Function1<KClass<?>, KSerializer<T>> f40961a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassValueCache$initClassValue$1 f40962b = c();

    public ClassValueCache(Function1<? super KClass<?>, ? extends KSerializer<T>> function1) {
        Intrinsics.f(function1, "compute");
        this.f40961a = function1;
    }

    private final ClassValueCache$initClassValue$1 c() {
        return new ClassValueCache$initClassValue$1(this);
    }

    public KSerializer<T> a(KClass<Object> kClass) {
        Intrinsics.f(kClass, "key");
        return ((CacheEntry) this.f40962b.get(JvmClassMappingKt.a(kClass))).f40954a;
    }
}
