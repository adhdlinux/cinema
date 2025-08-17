package com.vungle.ads.internal.load;

import com.vungle.ads.internal.network.VungleApiClient;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class RTADebugger {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String RTA_DEBUG_ENDPOINT = "https://events.ads.vungle.com/rtadebugging";
    private final VungleApiClient apiClient;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RTADebugger(VungleApiClient vungleApiClient) {
        Intrinsics.f(vungleApiClient, "apiClient");
        this.apiClient = vungleApiClient;
    }

    public final void reportAdMarkup(String str) {
        Intrinsics.f(str, "adm");
        this.apiClient.sendAdMarkup(str, RTA_DEBUG_ENDPOINT);
    }
}
