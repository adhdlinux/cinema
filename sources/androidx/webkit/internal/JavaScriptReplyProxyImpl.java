package androidx.webkit.internal;

import androidx.webkit.JavaScriptReplyProxy;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class JavaScriptReplyProxyImpl extends JavaScriptReplyProxy {

    /* renamed from: a  reason: collision with root package name */
    private JsReplyProxyBoundaryInterface f12070a;

    public JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f12070a = jsReplyProxyBoundaryInterface;
    }

    public static JavaScriptReplyProxyImpl a(InvocationHandler invocationHandler) {
        final JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface.getOrCreatePeer(new Callable<Object>() {
            public Object call() {
                return new JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface.this);
            }
        });
    }
}
