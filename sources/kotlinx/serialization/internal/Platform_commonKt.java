package kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;

public final class Platform_commonKt {

    /* renamed from: a  reason: collision with root package name */
    private static final SerialDescriptor[] f41044a = new SerialDescriptor[0];

    public static final Set<String> a(SerialDescriptor serialDescriptor) {
        Intrinsics.f(serialDescriptor, "<this>");
        if (serialDescriptor instanceof CachedNames) {
            return ((CachedNames) serialDescriptor).a();
        }
        HashSet hashSet = new HashSet(serialDescriptor.e());
        int e2 = serialDescriptor.e();
        for (int i2 = 0; i2 < e2; i2++) {
            hashSet.add(serialDescriptor.f(i2));
        }
        return hashSet;
    }

    public static final SerialDescriptor[] b(List<? extends SerialDescriptor> list) {
        boolean z2;
        Collection collection = list;
        if (collection == null || collection.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            list = null;
        }
        if (list != null) {
            Object[] array = list.toArray(new SerialDescriptor[0]);
            Intrinsics.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            SerialDescriptor[] serialDescriptorArr = (SerialDescriptor[]) array;
            if (serialDescriptorArr != null) {
                return serialDescriptorArr;
            }
        }
        return f41044a;
    }

    public static final KClass<Object> c(KType kType) {
        Intrinsics.f(kType, "<this>");
        KClassifier d2 = kType.d();
        if (d2 instanceof KClass) {
            return (KClass) d2;
        }
        throw new IllegalStateException(("Only KClass supported as classifier, got " + d2).toString());
    }

    public static final Void d(KClass<?> kClass) {
        Intrinsics.f(kClass, "<this>");
        throw new SerializationException("Serializer for class '" + kClass.e() + "' is not found.\nMark the class as @Serializable or provide the serializer explicitly.");
    }
}
