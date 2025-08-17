package androidx.webkit.internal;

import androidx.webkit.WebViewCompat;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewProviderAdapter {

    /* renamed from: a  reason: collision with root package name */
    WebViewProviderBoundaryInterface f12107a;

    public WebViewProviderAdapter(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.f12107a = webViewProviderBoundaryInterface;
    }

    public void a(String str, String[] strArr, WebViewCompat.WebMessageListener webMessageListener) {
        this.f12107a.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageListenerAdapter(webMessageListener)));
    }
}
