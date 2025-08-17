package com.vungle.ads.internal.task;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.network.VungleApiClient;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

public final class ResendTpatJob$onRunJob$$inlined$inject$1 extends Lambda implements Function0<VungleApiClient> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResendTpatJob$onRunJob$$inlined$inject$1(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.vungle.ads.internal.network.VungleApiClient, java.lang.Object] */
    public final VungleApiClient invoke() {
        return ServiceLocator.Companion.getInstance(this.$context).getService(VungleApiClient.class);
    }
}
