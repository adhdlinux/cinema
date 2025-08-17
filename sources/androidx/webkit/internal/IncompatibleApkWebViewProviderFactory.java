package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

public class IncompatibleApkWebViewProviderFactory implements WebViewProviderFactory {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f12069a = new String[0];

    public String[] a() {
        return f12069a;
    }

    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        throw new UnsupportedOperationException("This should never happen, if this method was called it means we're trying to reach into WebView APK code on an incompatible device. This most likely means the current method is being called too early, or is being called on start-up rather than lazily");
    }
}
