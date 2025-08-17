package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.omsdk.OMInjector;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class ConfigManager$initWithConfig$$inlined$inject$2 extends Lambda implements Function0<OMInjector> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConfigManager$initWithConfig$$inlined$inject$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.omsdk.OMInjector] */
    public final OMInjector invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(OMInjector.class);
    }
}
