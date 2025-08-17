package com.unity3d.services.core.webview.bridge;

public interface IEventSender {
    boolean canSend();

    boolean sendEvent(Enum<?> enumR, Enum<?> enumR2, Object... objArr);
}
