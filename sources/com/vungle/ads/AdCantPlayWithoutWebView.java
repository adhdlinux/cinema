package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.DefaultConstructorMarker;

public final class AdCantPlayWithoutWebView extends VungleError {
    public AdCantPlayWithoutWebView() {
        super(Sdk$SDKError.Reason.WEBVIEW_ERROR, "No WebView when playing ads.", (DefaultConstructorMarker) null);
    }
}
