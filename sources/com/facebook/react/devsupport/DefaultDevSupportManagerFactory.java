package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.packagerconnection.RequestHandler;
import java.util.Map;

public class DefaultDevSupportManagerFactory implements DevSupportManagerFactory {
    private static final String DEVSUPPORT_IMPL_CLASS = "BridgeDevSupportManager";
    private static final String DEVSUPPORT_IMPL_PACKAGE = "com.facebook.react.devsupport";

    public DevSupportManager create(Context context, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z2, int i2) {
        return create(context, reactInstanceDevHelper, str, z2, (RedBoxHandler) null, (DevBundleDownloadListener) null, i2, (Map<String, RequestHandler>) null, (SurfaceDelegateFactory) null);
    }

    public DevSupportManager create(Context context, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z2, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i2, Map<String, RequestHandler> map, SurfaceDelegateFactory surfaceDelegateFactory) {
        if (!z2) {
            return new DisabledDevSupportManager();
        }
        try {
            return (DevSupportManager) Class.forName(DEVSUPPORT_IMPL_PACKAGE + "." + DEVSUPPORT_IMPL_CLASS).getConstructor(new Class[]{Context.class, ReactInstanceDevHelper.class, String.class, Boolean.TYPE, RedBoxHandler.class, DevBundleDownloadListener.class, Integer.TYPE, Map.class, SurfaceDelegateFactory.class}).newInstance(new Object[]{context, reactInstanceDevHelper, str, Boolean.TRUE, redBoxHandler, devBundleDownloadListener, Integer.valueOf(i2), map, surfaceDelegateFactory});
        } catch (Exception e2) {
            throw new RuntimeException("Requested enabled DevSupportManager, but BridgeDevSupportManager class was not found or could not be created", e2);
        }
    }
}
