package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class VungleInitializer$init$$inlined$inject$1 extends Lambda implements Function0<Executors> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VungleInitializer$init$$inlined$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.vungle.ads.internal.executor.Executors] */
    public final Executors invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(Executors.class);
    }
}
