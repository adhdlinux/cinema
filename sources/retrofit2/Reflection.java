package retrofit2;

import android.annotation.TargetApi;
import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

class Reflection {

    @TargetApi(24)
    @IgnoreJRERequirement
    static final class Android24 extends Reflection {
        Android24() {
        }

        /* access modifiers changed from: package-private */
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return DefaultMethodSupport.invoke(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        /* access modifiers changed from: package-private */
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    @IgnoreJRERequirement
    static class Java8 extends Reflection {
        Java8() {
        }

        /* access modifiers changed from: package-private */
        public String describeMethodParameter(Method method, int i2) {
            Parameter parameter = method.getParameters()[i2];
            if (!parameter.isNamePresent()) {
                return Reflection.super.describeMethodParameter(method, i2);
            }
            return "parameter '" + parameter.getName() + '\'';
        }

        /* access modifiers changed from: package-private */
        public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
            return DefaultMethodSupport.invoke(method, cls, obj, objArr);
        }

        /* access modifiers changed from: package-private */
        public boolean isDefaultMethod(Method method) {
            return method.isDefault();
        }
    }

    Reflection() {
    }

    /* access modifiers changed from: package-private */
    public String describeMethodParameter(Method method, int i2) {
        return "parameter #" + (i2 + 1);
    }

    /* access modifiers changed from: package-private */
    public Object invokeDefaultMethod(Method method, Class<?> cls, Object obj, Object[] objArr) throws Throwable {
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public boolean isDefaultMethod(Method method) {
        return false;
    }
}
