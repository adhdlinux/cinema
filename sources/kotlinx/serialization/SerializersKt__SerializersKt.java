package kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;

final /* synthetic */ class SerializersKt__SerializersKt {
    private static final KSerializer<? extends Object> a(KClass<Object> kClass, List<? extends KType> list, List<? extends KSerializer<Object>> list2) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        Class<List> cls = List.class;
        if (Intrinsics.a(kClass, Reflection.b(Collection.class))) {
            z2 = true;
        } else {
            z2 = Intrinsics.a(kClass, Reflection.b(cls));
        }
        if (z2) {
            z3 = true;
        } else {
            z3 = Intrinsics.a(kClass, Reflection.b(cls));
        }
        if (z3) {
            z4 = true;
        } else {
            z4 = Intrinsics.a(kClass, Reflection.b(ArrayList.class));
        }
        if (z4) {
            return new ArrayListSerializer((KSerializer) list2.get(0));
        }
        if (Intrinsics.a(kClass, Reflection.b(HashSet.class))) {
            return new HashSetSerializer((KSerializer) list2.get(0));
        }
        Class<Set> cls2 = Set.class;
        if (Intrinsics.a(kClass, Reflection.b(cls2))) {
            z5 = true;
        } else {
            z5 = Intrinsics.a(kClass, Reflection.b(cls2));
        }
        if (z5) {
            z6 = true;
        } else {
            z6 = Intrinsics.a(kClass, Reflection.b(LinkedHashSet.class));
        }
        if (z6) {
            return new LinkedHashSetSerializer((KSerializer) list2.get(0));
        }
        if (Intrinsics.a(kClass, Reflection.b(HashMap.class))) {
            return new HashMapSerializer((KSerializer) list2.get(0), (KSerializer) list2.get(1));
        }
        Class<Map> cls3 = Map.class;
        if (Intrinsics.a(kClass, Reflection.b(cls3))) {
            z7 = true;
        } else {
            z7 = Intrinsics.a(kClass, Reflection.b(cls3));
        }
        if (z7) {
            z8 = true;
        } else {
            z8 = Intrinsics.a(kClass, Reflection.b(LinkedHashMap.class));
        }
        if (z8) {
            return new LinkedHashMapSerializer((KSerializer) list2.get(0), (KSerializer) list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Map.Entry.class))) {
            return BuiltinSerializersKt.j((KSerializer) list2.get(0), (KSerializer) list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Pair.class))) {
            return BuiltinSerializersKt.l((KSerializer) list2.get(0), (KSerializer) list2.get(1));
        }
        if (Intrinsics.a(kClass, Reflection.b(Triple.class))) {
            return BuiltinSerializersKt.n((KSerializer) list2.get(0), (KSerializer) list2.get(1), (KSerializer) list2.get(2));
        }
        if (!PlatformKt.l(kClass)) {
            return null;
        }
        KClassifier d2 = ((KType) list.get(0)).d();
        Intrinsics.d(d2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        return BuiltinSerializersKt.a((KClass) d2, (KSerializer) list2.get(0));
    }

    private static final KSerializer<? extends Object> b(KClass<Object> kClass, List<? extends KSerializer<Object>> list) {
        Object[] array = list.toArray(new KSerializer[0]);
        Intrinsics.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        KSerializer[] kSerializerArr = (KSerializer[]) array;
        return PlatformKt.d(kClass, (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> c(KSerializer<T> kSerializer, boolean z2) {
        if (z2) {
            return BuiltinSerializersKt.s(kSerializer);
        }
        Intrinsics.d(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<? extends Object> d(KClass<Object> kClass, List<? extends KType> list, List<? extends KSerializer<Object>> list2) {
        Intrinsics.f(kClass, "<this>");
        Intrinsics.f(list, "types");
        Intrinsics.f(list2, "serializers");
        KSerializer<? extends Object> a2 = a(kClass, list, list2);
        if (a2 == null) {
            return b(kClass, list2);
        }
        return a2;
    }

    public static final KSerializer<Object> e(SerializersModule serializersModule, KType kType) {
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(kType, "type");
        KSerializer<Object> f2 = f(serializersModule, kType, true);
        if (f2 != null) {
            return f2;
        }
        PlatformKt.m(Platform_commonKt.c(kType));
        throw new KotlinNothingValueException();
    }

    private static final KSerializer<Object> f(SerializersModule serializersModule, KType kType, boolean z2) {
        KSerializer<Object> kSerializer;
        KSerializer<? extends Object> kSerializer2;
        KClass<Object> c2 = Platform_commonKt.c(kType);
        boolean b2 = kType.b();
        Iterable<KTypeProjection> f2 = kType.f();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.p(f2, 10));
        for (KTypeProjection a2 : f2) {
            KType a3 = a2.a();
            if (a3 != null) {
                arrayList.add(a3);
            } else {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + kType).toString());
            }
        }
        if (arrayList.isEmpty()) {
            kSerializer = SerializersCacheKt.a(c2, b2);
        } else {
            Object b3 = SerializersCacheKt.b(c2, arrayList, b2);
            if (z2) {
                if (Result.g(b3)) {
                    b3 = null;
                }
                kSerializer = (KSerializer) b3;
            } else if (Result.e(b3) != null) {
                return null;
            } else {
                kSerializer = (KSerializer) b3;
            }
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        if (arrayList.isEmpty()) {
            kSerializer2 = SerializersModule.c(serializersModule, c2, (List) null, 2, (Object) null);
        } else {
            List e2 = SerializersKt.e(serializersModule, arrayList, z2);
            if (e2 == null) {
                return null;
            }
            KSerializer<? extends Object> a4 = SerializersKt.a(c2, arrayList, e2);
            if (a4 == null) {
                kSerializer2 = serializersModule.b(c2, e2);
            } else {
                kSerializer2 = a4;
            }
        }
        if (kSerializer2 != null) {
            return c(kSerializer2, b2);
        }
        return null;
    }

    public static final <T> KSerializer<T> g(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        KSerializer<T> b2 = PlatformKt.b(kClass);
        if (b2 == null) {
            return PrimitivesKt.b(kClass);
        }
        return b2;
    }

    public static final KSerializer<Object> h(SerializersModule serializersModule, KType kType) {
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(kType, "type");
        return f(serializersModule, kType, false);
    }

    public static final List<KSerializer<Object>> i(SerializersModule serializersModule, List<? extends KType> list, boolean z2) {
        ArrayList arrayList;
        Intrinsics.f(serializersModule, "<this>");
        Intrinsics.f(list, "typeArguments");
        if (z2) {
            Iterable<KType> iterable = list;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable, 10));
            for (KType b2 : iterable) {
                arrayList.add(SerializersKt.b(serializersModule, b2));
            }
        } else {
            Iterable<KType> iterable2 = list;
            arrayList = new ArrayList(CollectionsKt__IterablesKt.p(iterable2, 10));
            for (KType d2 : iterable2) {
                KSerializer<Object> d3 = SerializersKt.d(serializersModule, d2);
                if (d3 == null) {
                    return null;
                }
                arrayList.add(d3);
            }
        }
        return arrayList;
    }
}
