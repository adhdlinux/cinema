package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {

    /* renamed from: a  reason: collision with root package name */
    private static Map<Class<?>, Integer> f3683a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private static Map<Class<?>, List<Constructor<? extends GeneratedAdapter>>> f3684b = new HashMap();

    /* renamed from: androidx.lifecycle.Lifecycling$1  reason: invalid class name */
    class AnonymousClass1 implements LifecycleEventObserver {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LifecycleEventObserver f3685b;

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            this.f3685b.onStateChanged(lifecycleOwner, event);
        }
    }

    private Lifecycling() {
    }

    private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException(e3);
        } catch (InvocationTargetException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static Constructor<? extends GeneratedAdapter> b(Class<?> cls) {
        String str;
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            if (packageR != null) {
                str = packageR.getName();
            } else {
                str = "";
            }
            if (!str.isEmpty()) {
                canonicalName = canonicalName.substring(str.length() + 1);
            }
            String c2 = c(canonicalName);
            if (!str.isEmpty()) {
                c2 = str + "." + c2;
            }
            Constructor<?> declaredConstructor = Class.forName(c2).getDeclaredConstructor(new Class[]{cls});
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String c(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    private static int d(Class<?> cls) {
        Integer num = f3683a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g2 = g(cls);
        f3683a.put(cls, Integer.valueOf(g2));
        return g2;
    }

    private static boolean e(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    static LifecycleEventObserver f(Object obj) {
        boolean z2 = obj instanceof LifecycleEventObserver;
        boolean z3 = obj instanceof FullLifecycleObserver;
        if (z2 && z3) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) obj);
        }
        if (z3) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj, (LifecycleEventObserver) null);
        }
        if (z2) {
            return (LifecycleEventObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (d(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = f3684b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        for (int i2 = 0; i2 < list.size(); i2++) {
            generatedAdapterArr[i2] = a((Constructor) list.get(i2), obj);
        }
        return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
    }

    private static int g(Class<?> cls) {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends GeneratedAdapter> b2 = b(cls);
        if (b2 != null) {
            f3684b.put(cls, Collections.singletonList(b2));
            return 2;
        } else if (ClassesInfoCache.f3649c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            if (!e(superclass)) {
                arrayList = null;
            } else if (d(superclass) == 1) {
                return 1;
            } else {
                arrayList = new ArrayList(f3684b.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (e(cls2)) {
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f3684b.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f3684b.put(cls, arrayList);
            return 2;
        }
    }
}
