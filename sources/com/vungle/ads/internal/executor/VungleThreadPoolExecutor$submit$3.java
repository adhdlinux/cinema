package com.vungle.ads.internal.executor;

import com.vungle.ads.OutOfMemory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

final class VungleThreadPoolExecutor$submit$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VungleThreadPoolExecutor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VungleThreadPoolExecutor$submit$3(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        super(0);
        this.this$0 = vungleThreadPoolExecutor;
    }

    public final void invoke() {
        new OutOfMemory("submit callable error in " + this.this$0.executorName()).logErrorNoReturnValue$vungle_ads_release();
    }
}
