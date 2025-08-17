package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;

public class WebMessageListenerAdapter implements WebMessageListenerBoundaryInterface {

    /* renamed from: a  reason: collision with root package name */
    private WebViewCompat.WebMessageListener f12076a;

    public WebMessageListenerAdapter(WebViewCompat.WebMessageListener webMessageListener) {
        this.f12076a = webMessageListener;
    }

    public String[] getSupportedFeatures() {
        return new String[]{Features.WEB_MESSAGE_LISTENER};
    }

    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z2, InvocationHandler invocationHandler2) {
        WebMessageCompat b2 = WebMessageAdapter.b((WebMessageBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageBoundaryInterface.class, invocationHandler));
        if (b2 != null) {
            this.f12076a.a(webView, b2, uri, z2, JavaScriptReplyProxyImpl.a(invocationHandler2));
        }
    }
}
