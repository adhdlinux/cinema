package androidx.webkit.internal;

import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessagePortImpl extends WebMessagePortCompat {

    /* renamed from: a  reason: collision with root package name */
    private WebMessagePortBoundaryInterface f12077a;

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        this.f12077a = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
