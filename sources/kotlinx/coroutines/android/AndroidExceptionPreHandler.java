package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;

public final class AndroidExceptionPreHandler extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
    private volatile Object _preHandler = this;

    public AndroidExceptionPreHandler() {
        super(CoroutineExceptionHandler.D0);
    }

    private final Method o0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        boolean z2 = false;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                z2 = true;
            }
            if (z2) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        boolean z2;
        Object obj;
        int i2 = Build.VERSION.SDK_INT;
        if (26 > i2 || i2 >= 28) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            Method o02 = o0();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            if (o02 != null) {
                obj = o02.invoke((Object) null, new Object[0]);
            } else {
                obj = null;
            }
            if (obj instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) obj;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
