package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import com.google.gson.internal.TroubleshootingGuide;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final RecordHelper f31124a;

    private static abstract class RecordHelper {
        private RecordHelper() {
        }

        public abstract Method a(Class<?> cls, Field field);

        /* access modifiers changed from: package-private */
        public abstract <T> Constructor<T> b(Class<T> cls);

        /* access modifiers changed from: package-private */
        public abstract String[] c(Class<?> cls);

        /* access modifiers changed from: package-private */
        public abstract boolean d(Class<?> cls);
    }

    private static class RecordNotSupportedHelper extends RecordHelper {
        private RecordNotSupportedHelper() {
            super();
        }

        public Method a(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public <T> Constructor<T> b(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class<?> cls) {
            return false;
        }
    }

    private static class RecordSupportedHelper extends RecordHelper {

        /* renamed from: a  reason: collision with root package name */
        private final Method f31125a;

        /* renamed from: b  reason: collision with root package name */
        private final Method f31126b;

        /* renamed from: c  reason: collision with root package name */
        private final Method f31127c;

        /* renamed from: d  reason: collision with root package name */
        private final Method f31128d;

        public Method a(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.d(e2);
            }
        }

        public <T> Constructor<T> b(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.f31126b.invoke(cls, new Object[0]);
                Class[] clsArr = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    clsArr[i2] = (Class) this.f31128d.invoke(objArr[i2], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.d(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public String[] c(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.f31126b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    strArr[i2] = (String) this.f31127c.invoke(objArr[i2], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.d(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean d(Class<?> cls) {
            try {
                return ((Boolean) this.f31125a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e2) {
                throw ReflectionHelper.d(e2);
            }
        }

        private RecordSupportedHelper() throws NoSuchMethodException, ClassNotFoundException {
            super();
            Class<Class> cls = Class.class;
            this.f31125a = cls.getMethod("isRecord", new Class[0]);
            this.f31126b = cls.getMethod("getRecordComponents", new Class[0]);
            Class<?> cls2 = Class.forName("java.lang.reflect.RecordComponent");
            this.f31127c = cls2.getMethod("getName", new Class[0]);
            this.f31128d = cls2.getMethod("getType", new Class[0]);
        }
    }

    static {
        RecordHelper recordHelper;
        try {
            recordHelper = new RecordSupportedHelper();
        } catch (ReflectiveOperationException unused) {
            recordHelper = new RecordNotSupportedHelper();
        }
        f31124a = recordHelper;
    }

    private ReflectionHelper() {
    }

    private static void b(AccessibleObject accessibleObject, StringBuilder sb) {
        Class[] clsArr;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            clsArr = ((Method) accessibleObject).getParameterTypes();
        } else {
            clsArr = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(clsArr[i2].getSimpleName());
        }
        sb.append(')');
    }

    public static String c(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        b(constructor, sb);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static RuntimeException d(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.11.0). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    public static RuntimeException e(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.11.0). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }

    public static String f(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    public static String g(AccessibleObject accessibleObject, boolean z2) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + f((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            b(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + c((Constructor) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z2 || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static Method h(Class<?> cls, Field field) {
        return f31124a.a(cls, field);
    }

    public static <T> Constructor<T> i(Class<T> cls) {
        return f31124a.b(cls);
    }

    private static String j(Exception exc) {
        String str;
        if (!exc.getClass().getName().equals("java.lang.reflect.InaccessibleObjectException")) {
            return "";
        }
        String message = exc.getMessage();
        if (message == null || !message.contains("to module com.google.gson")) {
            str = "reflection-inaccessible";
        } else {
            str = "reflection-inaccessible-to-module-gson";
        }
        return "\nSee " + TroubleshootingGuide.a(str);
    }

    public static String[] k(Class<?> cls) {
        return f31124a.c(cls);
    }

    public static boolean l(Class<?> cls) {
        return !n(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    public static boolean m(Class<?> cls) {
        return f31124a.d(cls);
    }

    public static boolean n(Class<?> cls) {
        return Modifier.isStatic(cls.getModifiers());
    }

    public static void o(AccessibleObject accessibleObject) throws JsonIOException {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e2) {
            String g2 = g(accessibleObject, false);
            throw new JsonIOException("Failed making " + g2 + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type." + j(e2), e2);
        }
    }

    public static String p(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return "Failed making constructor '" + c(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage() + j(e2);
        }
    }
}
