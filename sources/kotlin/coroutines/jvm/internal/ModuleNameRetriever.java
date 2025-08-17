package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

final class ModuleNameRetriever {

    /* renamed from: a  reason: collision with root package name */
    public static final ModuleNameRetriever f40371a = new ModuleNameRetriever();

    /* renamed from: b  reason: collision with root package name */
    private static final Cache f40372b = new Cache((Method) null, (Method) null, (Method) null);

    /* renamed from: c  reason: collision with root package name */
    private static Cache f40373c;

    private static final class Cache {

        /* renamed from: a  reason: collision with root package name */
        public final Method f40374a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f40375b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f40376c;

        public Cache(Method method, Method method2, Method method3) {
            this.f40374a = method;
            this.f40375b = method2;
            this.f40376c = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final Cache a(BaseContinuationImpl baseContinuationImpl) {
        try {
            Cache cache = new Cache(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f40373c = cache;
            return cache;
        } catch (Exception unused) {
            Cache cache2 = f40372b;
            f40373c = cache2;
            return cache2;
        }
    }

    public final String b(BaseContinuationImpl baseContinuationImpl) {
        Object obj;
        Object obj2;
        Object obj3;
        Intrinsics.f(baseContinuationImpl, "continuation");
        Cache cache = f40373c;
        if (cache == null) {
            cache = a(baseContinuationImpl);
        }
        if (cache == f40372b) {
            return null;
        }
        Method method = cache.f40374a;
        if (method != null) {
            obj = method.invoke(baseContinuationImpl.getClass(), new Object[0]);
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        Method method2 = cache.f40375b;
        if (method2 != null) {
            obj2 = method2.invoke(obj, new Object[0]);
        } else {
            obj2 = null;
        }
        if (obj2 == null) {
            return null;
        }
        Method method3 = cache.f40376c;
        if (method3 != null) {
            obj3 = method3.invoke(obj2, new Object[0]);
        } else {
            obj3 = null;
        }
        if (obj3 instanceof String) {
            return (String) obj3;
        }
        return null;
    }
}
