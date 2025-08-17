package com.unity3d.services.core.webview.bridge;

import com.unity3d.services.core.webview.WebViewApp;
import kotlin.jvm.internal.Intrinsics;

public final class SharedInstances$webViewAppNativeCallbackSubject$1 implements INativeCallbackSubject {
    SharedInstances$webViewAppNativeCallbackSubject$1() {
    }

    public NativeCallback getCallback(String str) {
        Intrinsics.f(str, "callbackId");
        NativeCallback callback = WebViewApp.getCurrentApp().getCallback(str);
        Intrinsics.e(callback, "getCurrentApp().getCallback(callbackId)");
        return callback;
    }

    public void remove(NativeCallback nativeCallback) {
        Intrinsics.f(nativeCallback, "callback");
        WebViewApp.getCurrentApp().removeCallback(nativeCallback);
    }
}
