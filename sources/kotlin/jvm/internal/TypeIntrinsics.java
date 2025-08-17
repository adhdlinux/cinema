package kotlin.jvm.internal;

import java.util.List;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

public class TypeIntrinsics {
    public static List a(Object obj) {
        if ((obj instanceof KMappedMarker) && !(obj instanceof KMutableList)) {
            h(obj, "kotlin.collections.MutableList");
        }
        return c(obj);
    }

    public static Object b(Object obj, int i2) {
        if (obj != null && !e(obj, i2)) {
            h(obj, "kotlin.jvm.functions.Function" + i2);
        }
        return obj;
    }

    public static List c(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e2) {
            throw g(e2);
        }
    }

    public static int d(Object obj) {
        if (obj instanceof FunctionBase) {
            return ((FunctionBase) obj).getArity();
        }
        if (obj instanceof Function0) {
            return 0;
        }
        if (obj instanceof Function1) {
            return 1;
        }
        if (obj instanceof Function2) {
            return 2;
        }
        if (obj instanceof Function3) {
            return 3;
        }
        if (obj instanceof Function4) {
            return 4;
        }
        if (obj instanceof Function5) {
            return 5;
        }
        if (obj instanceof Function6) {
            return 6;
        }
        if (obj instanceof Function7) {
            return 7;
        }
        if (obj instanceof Function8) {
            return 8;
        }
        if (obj instanceof Function9) {
            return 9;
        }
        if (obj instanceof Function10) {
            return 10;
        }
        if (obj instanceof Function11) {
            return 11;
        }
        if (obj instanceof Function12) {
            return 12;
        }
        if (obj instanceof Function13) {
            return 13;
        }
        if (obj instanceof Function14) {
            return 14;
        }
        if (obj instanceof Function15) {
            return 15;
        }
        if (obj instanceof Function16) {
            return 16;
        }
        if (obj instanceof Function17) {
            return 17;
        }
        if (obj instanceof Function18) {
            return 18;
        }
        if (obj instanceof Function19) {
            return 19;
        }
        if (obj instanceof Function20) {
            return 20;
        }
        if (obj instanceof Function21) {
            return 21;
        }
        if (obj instanceof Function22) {
            return 22;
        }
        return -1;
    }

    public static boolean e(Object obj, int i2) {
        return (obj instanceof Function) && d(obj) == i2;
    }

    private static <T extends Throwable> T f(T t2) {
        return Intrinsics.n(t2, TypeIntrinsics.class.getName());
    }

    public static ClassCastException g(ClassCastException classCastException) {
        throw ((ClassCastException) f(classCastException));
    }

    public static void h(Object obj, String str) {
        String str2;
        if (obj == null) {
            str2 = "null";
        } else {
            str2 = obj.getClass().getName();
        }
        i(str2 + " cannot be cast to " + str);
    }

    public static void i(String str) {
        throw g(new ClassCastException(str));
    }
}
