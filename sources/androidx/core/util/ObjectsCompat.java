package androidx.core.util;

import java.util.Objects;

public class ObjectsCompat {

    static class Api19Impl {
        private Api19Impl() {
        }

        static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    private ObjectsCompat() {
    }

    public static boolean a(Object obj, Object obj2) {
        return Api19Impl.a(obj, obj2);
    }

    public static int b(Object... objArr) {
        return Api19Impl.b(objArr);
    }

    public static <T> T c(T t2) {
        t2.getClass();
        return t2;
    }

    public static <T> T d(T t2, String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    public static String e(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
