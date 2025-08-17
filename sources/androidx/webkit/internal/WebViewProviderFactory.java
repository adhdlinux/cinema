package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

public interface WebViewProviderFactory {
    String[] a();

    WebViewProviderBoundaryInterface createWebView(WebView webView);
}
