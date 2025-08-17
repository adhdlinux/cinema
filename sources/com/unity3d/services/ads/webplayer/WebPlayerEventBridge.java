package com.unity3d.services.ads.webplayer;

import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;

public class WebPlayerEventBridge {
    public static void error(String str, String str2, String str3) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.ERROR, str2, str3, str);
        }
    }

    public static void sendFrameUpdate(String str, int i2, int i3, int i4, int i5, float f2) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.FRAME_UPDATE, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2));
        }
    }

    public static void sendGetFrameResponse(String str, String str2, int i2, int i3, int i4, int i5, float f2) {
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            currentApp.sendEvent(WebViewEventCategory.WEBPLAYER, WebPlayerEvent.GET_FRAME_RESPONSE, str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Float.valueOf(f2));
        }
    }
}
