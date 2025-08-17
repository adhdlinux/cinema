package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.signals.SignalManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class BaseAd$special$$inlined$inject$1 extends Lambda implements Function0<SignalManager> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseAd$special$$inlined$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.SignalManager, java.lang.Object] */
    public final SignalManager invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(SignalManager.class);
    }
}
