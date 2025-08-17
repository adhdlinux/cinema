package kotlinx.serialization.descriptors;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.internal.PrimitivesKt;

public final class SerialDescriptorsKt {
    public static final SerialDescriptor a(String str, PrimitiveKind primitiveKind) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(primitiveKind, "kind");
        if (!StringsKt__StringsJVMKt.v(str)) {
            return PrimitivesKt.a(str, primitiveKind);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor b(String str, SerialDescriptor[] serialDescriptorArr, Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(serialDescriptorArr, "typeParameters");
        Intrinsics.f(function1, "builderAction");
        if (!StringsKt__StringsJVMKt.v(str)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            function1.invoke(classSerialDescriptorBuilder);
            return new SerialDescriptorImpl(str, StructureKind.CLASS.f40939a, classSerialDescriptorBuilder.f().size(), ArraysKt___ArraysKt.Q(serialDescriptorArr), classSerialDescriptorBuilder);
        }
        throw new IllegalArgumentException("Blank serial names are prohibited".toString());
    }

    public static final SerialDescriptor c(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.f(str, "serialName");
        Intrinsics.f(serialKind, "kind");
        Intrinsics.f(serialDescriptorArr, "typeParameters");
        Intrinsics.f(function1, "builder");
        if (!(!StringsKt__StringsJVMKt.v(str))) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        } else if (!Intrinsics.a(serialKind, StructureKind.CLASS.f40939a)) {
            ClassSerialDescriptorBuilder classSerialDescriptorBuilder = new ClassSerialDescriptorBuilder(str);
            function1.invoke(classSerialDescriptorBuilder);
            return new SerialDescriptorImpl(str, serialKind, classSerialDescriptorBuilder.f().size(), ArraysKt___ArraysKt.Q(serialDescriptorArr), classSerialDescriptorBuilder);
        } else {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
    }

    public static /* synthetic */ SerialDescriptor d(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function1 = SerialDescriptorsKt$buildSerialDescriptor$1.f40936f;
        }
        return c(str, serialKind, serialDescriptorArr, function1);
    }
}
