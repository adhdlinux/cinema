package kotlinx.serialization.internal;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> f40964a;

    /* renamed from: b  reason: collision with root package name */
    private final ClassValueParametrizedCache$initClassValue$1 f40965b = b();

    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> function2) {
        Intrinsics.f(function2, "compute");
        this.f40964a = function2;
    }

    private final ClassValueParametrizedCache$initClassValue$1 b() {
        return new ClassValueParametrizedCache$initClassValue$1();
    }

    public Object a(KClass<Object> kClass, List<? extends KType> list) {
        Object obj;
        Intrinsics.f(kClass, "key");
        Intrinsics.f(list, "types");
        ConcurrentHashMap a2 = ((ParametrizedCacheEntry) this.f40965b.get(JvmClassMappingKt.a(kClass))).f41043a;
        Object obj2 = a2.get(list);
        if (obj2 == null) {
            try {
                Result.Companion companion = Result.f40263c;
                obj = Result.b(this.f40964a.invoke(kClass, list));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.f40263c;
                obj = Result.b(ResultKt.a(th));
            }
            Result a3 = Result.a(obj);
            Object putIfAbsent = a2.putIfAbsent(list, a3);
            if (putIfAbsent == null) {
                obj2 = a3;
            } else {
                obj2 = putIfAbsent;
            }
        }
        Intrinsics.e(obj2, "serializers.getOrPut(typ… { producer() }\n        }");
        return ((Result) obj2).j();
    }
}
