package com.unity3d.services.core.cache;

import com.unity3d.services.core.webview.WebViewEventCategory;
import com.unity3d.services.core.webview.bridge.IEventSender;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

public final class CacheEventSender implements Serializable {
    private final IEventSender eventSender;

    public CacheEventSender(IEventSender iEventSender) {
        Intrinsics.f(iEventSender, "eventSender");
        this.eventSender = iEventSender;
    }

    public final boolean sendEvent(CacheEvent cacheEvent, Object... objArr) {
        Intrinsics.f(cacheEvent, "eventId");
        Intrinsics.f(objArr, "params");
        return this.eventSender.sendEvent(WebViewEventCategory.CACHE, cacheEvent, Arrays.copyOf(objArr, objArr.length));
    }
}
