package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.serialization.KSerializer;

public final class CachingKt {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f40955a;

    static {
        Object obj;
        try {
            Result.Companion companion = Result.f40263c;
            obj = Result.b(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.f40263c;
            obj = Result.b(ResultKt.a(th));
        }
        if (Result.h(obj)) {
            Class cls = (Class) obj;
            obj = Boolean.TRUE;
        }
        Object b2 = Result.b(obj);
        Boolean bool = Boolean.FALSE;
        if (Result.g(b2)) {
            b2 = bool;
        }
        f40955a = ((Boolean) b2).booleanValue();
    }

    public static final <T> SerializerCache<T> a(Function1<? super KClass<?>, ? extends KSerializer<T>> function1) {
        Intrinsics.f(function1, "factory");
        if (f40955a) {
            return new ClassValueCache(function1);
        }
        return new ConcurrentHashMapCache(function1);
    }

    public static final <T> ParametrizedSerializerCache<T> b(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> function2) {
        Intrinsics.f(function2, "factory");
        if (f40955a) {
            return new ClassValueParametrizedCache(function2);
        }
        return new ConcurrentHashMapParametrizedCache(function2);
    }
}
