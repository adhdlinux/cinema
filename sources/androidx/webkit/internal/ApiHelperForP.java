package androidx.webkit.internal;

import android.os.Looper;
import android.webkit.TracingConfig;
import android.webkit.TracingController;
import android.webkit.WebView;
import androidx.webkit.TracingConfig;
import java.io.OutputStream;
import java.util.concurrent.Executor;

public class ApiHelperForP {
    private ApiHelperForP() {
    }

    public static TracingController a() {
        return TracingController.getInstance();
    }

    public static ClassLoader b() {
        return WebView.getWebViewClassLoader();
    }

    public static Looper c(WebView webView) {
        return webView.getWebViewLooper();
    }

    public static boolean d(TracingController tracingController) {
        return tracingController.isTracing();
    }

    public static void e(String str) {
        WebView.setDataDirectorySuffix(str);
    }

    public static void f(TracingController tracingController, TracingConfig tracingConfig) {
        new TracingConfig.Builder();
        throw null;
    }

    public static boolean g(TracingController tracingController, OutputStream outputStream, Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
