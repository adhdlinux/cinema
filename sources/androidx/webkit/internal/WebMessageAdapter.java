package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;

public class WebMessageAdapter implements WebMessageBoundaryInterface {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f12075a = {Features.WEB_MESSAGE_GET_MESSAGE_PAYLOAD};

    private static WebMessagePortCompat[] a(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i2 = 0; i2 < invocationHandlerArr.length; i2++) {
            webMessagePortCompatArr[i2] = new WebMessagePortImpl(invocationHandlerArr[i2]);
        }
        return webMessagePortCompatArr;
    }

    public static WebMessageCompat b(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        WebMessagePortCompat[] a2 = a(webMessageBoundaryInterface.getPorts());
        if (!WebViewFeatureInternal.C.c()) {
            return new WebMessageCompat(webMessageBoundaryInterface.getData(), a2);
        }
        WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
        int type = webMessagePayloadBoundaryInterface.getType();
        if (type == 0) {
            return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsString(), a2);
        }
        if (type != 1) {
            return null;
        }
        return new WebMessageCompat(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), a2);
    }
}
