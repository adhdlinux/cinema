package androidx.webkit.internal;

import android.os.Build;
import android.webkit.WebView;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewGlueCommunicator {

    private static class LAZY_FACTORY_HOLDER {

        /* renamed from: a  reason: collision with root package name */
        static final WebViewProviderFactory f12106a = WebViewGlueCommunicator.a();

        private LAZY_FACTORY_HOLDER() {
        }
    }

    private WebViewGlueCommunicator() {
    }

    static WebViewProviderFactory a() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (IllegalAccessException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException(e4);
        }
    }

    private static InvocationHandler b() throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, d()).getDeclaredMethod("createWebViewProviderFactory", new Class[0]).invoke((Object) null, new Object[0]);
    }

    public static WebViewProviderFactory c() {
        return LAZY_FACTORY_HOLDER.f12106a;
    }

    public static ClassLoader d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ApiHelperForP.b();
        }
        return e().getClass().getClassLoader();
    }

    private static Object e() {
        try {
            Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", new Class[0]);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke((Object) null, new Object[0]);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException(e4);
        }
    }
}
