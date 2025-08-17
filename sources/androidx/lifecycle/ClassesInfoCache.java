package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
final class ClassesInfoCache {

    /* renamed from: c  reason: collision with root package name */
    static ClassesInfoCache f3649c = new ClassesInfoCache();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, CallbackInfo> f3650a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Class<?>, Boolean> f3651b = new HashMap();

    @Deprecated
    static class CallbackInfo {

        /* renamed from: a  reason: collision with root package name */
        final Map<Lifecycle.Event, List<MethodReference>> f3652a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        final Map<MethodReference, Lifecycle.Event> f3653b;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.f3653b = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.f3652a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f3652a.put(event, list);
                }
                list.add((MethodReference) next.getKey());
            }
        }

        private static void b(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lifecycleOwner, event, obj);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            b(this.f3652a.get(event), lifecycleOwner, event, obj);
            b(this.f3652a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    @Deprecated
    static final class MethodReference {

        /* renamed from: a  reason: collision with root package name */
        final int f3654a;

        /* renamed from: b  reason: collision with root package name */
        final Method f3655b;

        MethodReference(int i2, Method method) {
            this.f3654a = i2;
            this.f3655b = method;
            method.setAccessible(true);
        }

        /* access modifiers changed from: package-private */
        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i2 = this.f3654a;
                if (i2 == 0) {
                    this.f3655b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f3655b.invoke(obj, new Object[]{lifecycleOwner});
                } else if (i2 == 2) {
                    this.f3655b.invoke(obj, new Object[]{lifecycleOwner, event});
                }
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MethodReference)) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (this.f3654a != methodReference.f3654a || !this.f3655b.getName().equals(methodReference.f3655b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f3654a * 31) + this.f3655b.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    private CallbackInfo a(Class<?> cls, Method[] methodArr) {
        int i2;
        CallbackInfo c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c2 = c(superclass)) == null)) {
            hashMap.putAll(c2.f3653b);
        }
        for (Class c3 : cls.getInterfaces()) {
            for (Map.Entry next : c(c3).f3653b.entrySet()) {
                e(hashMap, (MethodReference) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z2 = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i2 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new MethodReference(i2, method), value, cls);
                    z2 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.f3650a.put(cls, callbackInfo);
        this.f3651b.put(cls, Boolean.valueOf(z2));
        return callbackInfo;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 != null && event != event2) {
            Method method = methodReference.f3655b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    /* access modifiers changed from: package-private */
    public CallbackInfo c(Class<?> cls) {
        CallbackInfo callbackInfo = this.f3650a.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return a(cls, (Method[]) null);
    }

    /* access modifiers changed from: package-private */
    public boolean d(Class<?> cls) {
        Boolean bool = this.f3651b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method annotation : b2) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f3651b.put(cls, Boolean.FALSE);
        return false;
    }
}
