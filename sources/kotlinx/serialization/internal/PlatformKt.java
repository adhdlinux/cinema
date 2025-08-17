package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;

public final class PlatformKt {
    private static final Object a(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T> KSerializer<T> b(KClass<T> kClass) {
        Intrinsics.f(kClass, "<this>");
        return d(kClass, new KSerializer[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0063, code lost:
        if (r3 == false) goto L_0x0065;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0083 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.KSerializer<T> c(java.lang.Class<T> r8, kotlinx.serialization.KSerializer<java.lang.Object>... r9) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.f(r8, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.f(r9, r0)
            boolean r0 = r8.isEnum()
            if (r0 == 0) goto L_0x001b
            boolean r0 = j(r8)
            if (r0 == 0) goto L_0x001b
            kotlinx.serialization.KSerializer r8 = e(r8)
            return r8
        L_0x001b:
            boolean r0 = r8.isInterface()
            if (r0 == 0) goto L_0x0028
            kotlinx.serialization.KSerializer r0 = g(r8)
            if (r0 == 0) goto L_0x0028
            return r0
        L_0x0028:
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            kotlinx.serialization.KSerializer[] r9 = (kotlinx.serialization.KSerializer[]) r9
            kotlinx.serialization.KSerializer r9 = h(r8, r9)
            if (r9 == 0) goto L_0x0036
            return r9
        L_0x0036:
            kotlinx.serialization.KSerializer r9 = f(r8)
            if (r9 == 0) goto L_0x003d
            return r9
        L_0x003d:
            r9 = 0
            java.lang.Class[] r0 = r8.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x007f }
            java.lang.String r1 = "declaredClasses"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)     // Catch:{ NoSuchFieldException -> 0x007f }
            int r1 = r0.length     // Catch:{ NoSuchFieldException -> 0x007f }
            r2 = 0
            r4 = r9
            r3 = 0
        L_0x004b:
            if (r2 >= r1) goto L_0x0063
            r5 = r0[r2]     // Catch:{ NoSuchFieldException -> 0x007f }
            java.lang.String r6 = r5.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x007f }
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.Intrinsics.a(r6, r7)     // Catch:{ NoSuchFieldException -> 0x007f }
            if (r6 == 0) goto L_0x0060
            if (r3 == 0) goto L_0x005e
            goto L_0x0065
        L_0x005e:
            r3 = 1
            r4 = r5
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x004b
        L_0x0063:
            if (r3 != 0) goto L_0x0066
        L_0x0065:
            r4 = r9
        L_0x0066:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ NoSuchFieldException -> 0x007f }
            if (r4 == 0) goto L_0x0077
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch:{ NoSuchFieldException -> 0x007f }
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NoSuchFieldException -> 0x007f }
            goto L_0x0078
        L_0x0077:
            r0 = r9
        L_0x0078:
            boolean r1 = r0 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x007f }
            if (r1 == 0) goto L_0x0080
            kotlinx.serialization.KSerializer r0 = (kotlinx.serialization.KSerializer) r0     // Catch:{ NoSuchFieldException -> 0x007f }
            goto L_0x0081
        L_0x007f:
        L_0x0080:
            r0 = r9
        L_0x0081:
            if (r0 == 0) goto L_0x0084
            return r0
        L_0x0084:
            boolean r0 = k(r8)
            if (r0 == 0) goto L_0x0093
            kotlinx.serialization.PolymorphicSerializer r9 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.KClass r8 = kotlin.jvm.JvmClassMappingKt.c(r8)
            r9.<init>(r8)
        L_0x0093:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.c(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    public static final <T> KSerializer<T> d(KClass<T> kClass, KSerializer<Object>... kSerializerArr) {
        Intrinsics.f(kClass, "<this>");
        Intrinsics.f(kSerializerArr, "args");
        return c(JvmClassMappingKt.a(kClass), (KSerializer[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final <T> KSerializer<T> e(Class<T> cls) {
        Object[] enumConstants = cls.getEnumConstants();
        String canonicalName = cls.getCanonicalName();
        Intrinsics.e(canonicalName, "canonicalName");
        Intrinsics.d(enumConstants, "null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
        return new EnumSerializer(canonicalName, (Enum[]) enumConstants);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r5 == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0094, code lost:
        if (r5 == false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0096, code lost:
        r6 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0091 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.serialization.KSerializer<T> f(java.lang.Class<T> r11) {
        /*
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r6 = r2
            r4 = 0
            r5 = 0
        L_0x000f:
            r7 = 1
            if (r4 >= r1) goto L_0x0041
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            if (r9 == 0) goto L_0x0036
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r11)
            if (r9 == 0) goto L_0x0036
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x0036
            r9 = 1
            goto L_0x0037
        L_0x0036:
            r9 = 0
        L_0x0037:
            if (r9 == 0) goto L_0x003e
            if (r5 == 0) goto L_0x003c
            goto L_0x0043
        L_0x003c:
            r6 = r8
            r5 = 1
        L_0x003e:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0041:
            if (r5 != 0) goto L_0x0044
        L_0x0043:
            r6 = r2
        L_0x0044:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L_0x0049
            return r2
        L_0x0049:
            java.lang.Object r0 = r6.get(r2)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            java.lang.String r1 = "methods"
            kotlin.jvm.internal.Intrinsics.e(r11, r1)
            int r1 = r11.length
            r6 = r2
            r4 = 0
            r5 = 0
        L_0x005a:
            if (r4 >= r1) goto L_0x0094
            r8 = r11[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "serializer"
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            if (r9 == 0) goto L_0x0089
            java.lang.Class[] r9 = r8.getParameterTypes()
            java.lang.String r10 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.e(r9, r10)
            int r9 = r9.length
            if (r9 != 0) goto L_0x0078
            r9 = 1
            goto L_0x0079
        L_0x0078:
            r9 = 0
        L_0x0079:
            if (r9 == 0) goto L_0x0089
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r10 = kotlinx.serialization.KSerializer.class
            boolean r9 = kotlin.jvm.internal.Intrinsics.a(r9, r10)
            if (r9 == 0) goto L_0x0089
            r9 = 1
            goto L_0x008a
        L_0x0089:
            r9 = 0
        L_0x008a:
            if (r9 == 0) goto L_0x0091
            if (r5 == 0) goto L_0x008f
            goto L_0x0096
        L_0x008f:
            r6 = r8
            r5 = 1
        L_0x0091:
            int r4 = r4 + 1
            goto L_0x005a
        L_0x0094:
            if (r5 != 0) goto L_0x0097
        L_0x0096:
            r6 = r2
        L_0x0097:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x009c
            return r2
        L_0x009c:
            java.lang.Object[] r11 = new java.lang.Object[r3]
            java.lang.Object r11 = r6.invoke(r0, r11)
            boolean r0 = r11 instanceof kotlinx.serialization.KSerializer
            if (r0 == 0) goto L_0x00a9
            r2 = r11
            kotlinx.serialization.KSerializer r2 = (kotlinx.serialization.KSerializer) r2
        L_0x00a9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.f(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    private static final <T> KSerializer<T> g(Class<T> cls) {
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.a(Reflection.b(serializable.with()), Reflection.b(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(JvmClassMappingKt.c(cls));
        }
        return null;
    }

    private static final <T> KSerializer<T> h(Class<?> cls, KSerializer<Object>... kSerializerArr) {
        boolean z2;
        Class[] clsArr;
        Object a2 = a(cls);
        if (a2 == null) {
            return null;
        }
        try {
            if (kSerializerArr.length == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                clsArr = new Class[0];
            } else {
                int length = kSerializerArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr2[i2] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = a2.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(a2, Arrays.copyOf(kSerializerArr, kSerializerArr.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e2.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e2;
        }
    }

    public static final boolean i(Object obj, KClass<?> kClass) {
        Intrinsics.f(obj, "<this>");
        Intrinsics.f(kClass, "kclass");
        return JvmClassMappingKt.b(kClass).isInstance(obj);
    }

    private static final <T> boolean j(Class<T> cls) {
        if (cls.getAnnotation(Serializable.class) == null && cls.getAnnotation(Polymorphic.class) == null) {
            return true;
        }
        return false;
    }

    private static final <T> boolean k(Class<T> cls) {
        if (cls.getAnnotation(Polymorphic.class) != null) {
            return true;
        }
        Serializable serializable = (Serializable) cls.getAnnotation(Serializable.class);
        if (serializable == null || !Intrinsics.a(Reflection.b(serializable.with()), Reflection.b(PolymorphicSerializer.class))) {
            return false;
        }
        return true;
    }

    public static final boolean l(KClass<Object> kClass) {
        Intrinsics.f(kClass, "rootClass");
        return JvmClassMappingKt.a(kClass).isArray();
    }

    public static final Void m(KClass<?> kClass) {
        Intrinsics.f(kClass, "<this>");
        Platform_commonKt.d(kClass);
        throw new KotlinNothingValueException();
    }

    public static final <T, E extends T> E[] n(ArrayList<E> arrayList, KClass<T> kClass) {
        Intrinsics.f(arrayList, "<this>");
        Intrinsics.f(kClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.a(kClass), arrayList.size());
        Intrinsics.d(newInstance, "null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
        E[] array = arrayList.toArray((Object[]) newInstance);
        Intrinsics.e(array, "toArray(java.lang.reflec….java, size) as Array<E>)");
        return array;
    }
}
