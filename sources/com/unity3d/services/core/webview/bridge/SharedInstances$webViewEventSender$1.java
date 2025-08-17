package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.WebViewApp;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class SharedInstances$webViewEventSender$1 implements IEventSender {
    SharedInstances$webViewEventSender$1() {
    }

    public boolean canSend() {
        return WebViewApp.getCurrentApp() != null;
    }

    public boolean sendEvent(Enum<?> enumR, Enum<?> enumR2, Object... objArr) {
        Intrinsics.f(enumR, "eventCategory");
        Intrinsics.f(enumR2, "eventId");
        Intrinsics.f(objArr, "params");
        WebViewApp currentApp = WebViewApp.getCurrentApp();
        if (currentApp != null) {
            return currentApp.sendEvent(enumR, enumR2, Arrays.copyOf(objArr, objArr.length));
        }
        return false;
    }
}
