package com.unity3d.services.ads.adunit;

import com.unity3d.services.ads.configuration.IAdsModuleConfiguration;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IModuleConfiguration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import java.util.Map;

public class AdUnitViewHandlerFactory implements IAdUnitViewHandlerFactory {
    public IAdUnitViewHandler createViewHandler(String str) {
        Map<String, Class> adUnitViewHandlers;
        if (WebViewApp.getCurrentApp() != null) {
            Configuration configuration = WebViewApp.getCurrentApp().getConfiguration();
            Class[] moduleConfigurationList = configuration.getModuleConfigurationList();
            int length = moduleConfigurationList.length;
            int i2 = 0;
            while (i2 < length) {
                IModuleConfiguration moduleConfiguration = configuration.getModuleConfiguration(moduleConfigurationList[i2]);
                if (!(moduleConfiguration instanceof IAdsModuleConfiguration) || (adUnitViewHandlers = ((IAdsModuleConfiguration) moduleConfiguration).getAdUnitViewHandlers()) == null || !adUnitViewHandlers.containsKey(str)) {
                    i2++;
                } else {
                    try {
                        return (IAdUnitViewHandler) adUnitViewHandlers.get(str).newInstance();
                    } catch (Exception unused) {
                        DeviceLog.error("Error creating view: " + str);
                        return null;
                    }
                }
            }
        }
        return null;
    }
}
