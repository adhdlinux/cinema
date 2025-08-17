package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.packagerconnection.RequestHandler;
import java.util.Map;

public interface DevSupportManagerFactory {
    DevSupportManager create(Context context, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z2, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i2, Map<String, RequestHandler> map, SurfaceDelegateFactory surfaceDelegateFactory);
}
