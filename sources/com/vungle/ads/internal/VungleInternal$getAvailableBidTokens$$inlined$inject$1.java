package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class VungleInternal$getAvailableBidTokens$$inlined$inject$1 extends Lambda implements Function0<ConcurrencyTimeoutProvider> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VungleInternal$getAvailableBidTokens$$inlined$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.vungle.ads.internal.util.ConcurrencyTimeoutProvider, java.lang.Object] */
    public final ConcurrencyTimeoutProvider invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(ConcurrencyTimeoutProvider.class);
    }
}
