package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.VungleAdSize;
import kotlin.jvm.internal.Intrinsics;

public abstract class FullscreenAdInternal extends AdInternal {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FullscreenAdInternal(Context context) {
        super(context);
        Intrinsics.f(context, "context");
    }

    public VungleAdSize getAdSizeForAdRequest() {
        return null;
    }

    public boolean isValidAdSize(VungleAdSize vungleAdSize) {
        return true;
    }
}
