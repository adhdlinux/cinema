package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

public class Reflection {

    /* renamed from: a  reason: collision with root package name */
    private static final ReflectionFactory f40430a;

    /* renamed from: b  reason: collision with root package name */
    private static final KClass[] f40431b = new KClass[0];

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f40430a = reflectionFactory;
    }

    public static KFunction a(FunctionReference functionReference) {
        return f40430a.a(functionReference);
    }

    public static KClass b(Class cls) {
        return f40430a.b(cls);
    }

    public static KDeclarationContainer c(Class cls) {
        return f40430a.c(cls, "");
    }

    public static KType d(KType kType) {
        return f40430a.d(kType);
    }

    public static KProperty0 e(PropertyReference0 propertyReference0) {
        return f40430a.e(propertyReference0);
    }

    public static String f(FunctionBase functionBase) {
        return f40430a.f(functionBase);
    }

    public static String g(Lambda lambda) {
        return f40430a.g(lambda);
    }

    public static KType h(Class cls) {
        return f40430a.h(b(cls), Collections.emptyList(), false);
    }

    public static KType i(Class cls, KTypeProjection kTypeProjection) {
        return f40430a.h(b(cls), Collections.singletonList(kTypeProjection), false);
    }

    public static KType j(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f40430a.h(b(cls), Arrays.asList(new KTypeProjection[]{kTypeProjection, kTypeProjection2}), false);
    }
}
