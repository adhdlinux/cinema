package com.unity3d.services.core.webview.bridge;

public interface INativeCallbackSubject {
    NativeCallback getCallback(String str);

    void remove(NativeCallback nativeCallback);
}
