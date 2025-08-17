package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

public class Intrinsics {
    private Intrinsics() {
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) m(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void c(Object obj) {
        if (obj == null) {
            p();
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            q(str);
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            throw ((NullPointerException) m(new NullPointerException(str + " must not be null")));
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            s(str);
        }
    }

    public static int h(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 == i3 ? 0 : 1;
    }

    public static int i(long j2, long j3) {
        int i2 = (j2 > j3 ? 1 : (j2 == j3 ? 0 : -1));
        if (i2 < 0) {
            return -1;
        }
        return i2 == 0 ? 0 : 1;
    }

    private static String j(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = Intrinsics.class.getName();
        int i2 = 0;
        while (!stackTrace[i2].getClassName().equals(name)) {
            i2++;
        }
        while (stackTrace[i2].getClassName().equals(name)) {
            i2++;
        }
        StackTraceElement stackTraceElement = stackTrace[i2];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void k() {
        u();
    }

    public static void l(int i2, String str) {
        u();
    }

    private static <T extends Throwable> T m(T t2) {
        return n(t2, Intrinsics.class.getName());
    }

    static <T extends Throwable> T n(T t2, String str) {
        StackTraceElement[] stackTrace = t2.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.equals(stackTrace[i3].getClassName())) {
                i2 = i3;
            }
        }
        t2.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i2 + 1, length));
        return t2;
    }

    public static String o(String str, Object obj) {
        return str + obj;
    }

    public static void p() {
        throw ((NullPointerException) m(new NullPointerException()));
    }

    public static void q(String str) {
        throw ((NullPointerException) m(new NullPointerException(str)));
    }

    public static void r() {
        throw ((KotlinNullPointerException) m(new KotlinNullPointerException()));
    }

    private static void s(String str) {
        throw ((IllegalArgumentException) m(new IllegalArgumentException(j(str))));
    }

    private static void t(String str) {
        throw ((NullPointerException) m(new NullPointerException(j(str))));
    }

    public static void u() {
        v("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void v(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void w(String str) {
        throw ((UninitializedPropertyAccessException) m(new UninitializedPropertyAccessException(str)));
    }

    public static void x(String str) {
        w("lateinit property " + str + " has not been initialized");
    }
}
