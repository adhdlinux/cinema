package androidx.webkit;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.webkit.WebView;
import androidx.webkit.internal.ApiHelperForO;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import androidx.webkit.internal.WebViewProviderFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

public class WebViewCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f12063a = Uri.parse("*");

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f12064b = Uri.parse("");

    public interface WebMessageListener {
        void a(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy);
    }

    private WebViewCompat() {
    }

    public static void a(WebView webView, String str, Set<String> set, WebMessageListener webMessageListener) {
        if (WebViewFeatureInternal.U.c()) {
            f(webView).a(str, (String[]) set.toArray(new String[0]), webMessageListener);
            return;
        }
        throw WebViewFeatureInternal.a();
    }

    private static WebViewProviderBoundaryInterface b(WebView webView) {
        return d().createWebView(webView);
    }

    public static PackageInfo c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return ApiHelperForO.a();
        }
        try {
            return e();
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    private static WebViewProviderFactory d() {
        return WebViewGlueCommunicator.c();
    }

    @SuppressLint({"PrivateApi"})
    private static PackageInfo e() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return (PackageInfo) Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", new Class[0]).invoke((Object) null, new Object[0]);
    }

    private static WebViewProviderAdapter f(WebView webView) {
        return new WebViewProviderAdapter(b(webView));
    }
}
