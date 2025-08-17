package okhttp3.internal.platform.android;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class CloseGuard {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Method getMethod;
    private final Method openMethod;
    private final Method warnIfOpenMethod;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CloseGuard get() {
            Method method;
            Method method2;
            Method method3;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                method2 = cls.getMethod("get", new Class[0]);
                method = cls.getMethod(MRAIDPresenter.OPEN, new Class[]{String.class});
                method3 = cls.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception unused) {
                method2 = null;
                method3 = null;
                method = null;
            }
            return new CloseGuard(method2, method, method3);
        }
    }

    public CloseGuard(Method method, Method method2, Method method3) {
        this.getMethod = method;
        this.openMethod = method2;
        this.warnIfOpenMethod = method3;
    }

    public final Object createAndOpen(String str) {
        Intrinsics.f(str, "closer");
        Method method = this.getMethod;
        if (method != null) {
            try {
                Object invoke = method.invoke((Object) null, new Object[0]);
                Method method2 = this.openMethod;
                Intrinsics.c(method2);
                method2.invoke(invoke, new Object[]{str});
                return invoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean warnIfOpen(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            Method method = this.warnIfOpenMethod;
            Intrinsics.c(method);
            method.invoke(obj, new Object[0]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
