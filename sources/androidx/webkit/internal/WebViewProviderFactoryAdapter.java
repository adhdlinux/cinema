package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewProviderFactoryAdapter implements WebViewProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    final WebViewProviderFactoryBoundaryInterface f12108a;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f12108a = webViewProviderFactoryBoundaryInterface;
    }

    public String[] a() {
        return this.f12108a.getSupportedFeatures();
    }

    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, this.f12108a.createWebView(webView));
    }
}
