package kotlin.jvm;

import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

public final class JvmClassMappingKt {
    public static final <T> Class<T> a(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        Class<?> a2 = ((ClassBasedDeclarationContainer) kClass).a();
        Intrinsics.d(a2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return a2;
    }

    public static final <T> Class<T> b(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        Class a2 = ((ClassBasedDeclarationContainer) kClass).a();
        if (!a2.isPrimitive()) {
            Intrinsics.d(a2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return a2;
        }
        String name = a2.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    a2 = Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    a2 = Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    a2 = Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    a2 = Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    a2 = Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    a2 = Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    a2 = Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    a2 = Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    a2 = Short.class;
                    break;
                }
                break;
        }
        Intrinsics.d(a2, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return a2;
    }

    public static final <T> KClass<T> c(Class<T> cls) {
        Intrinsics.f(cls, "<this>");
        return Reflection.b(cls);
    }
}
