package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.task.PriorityRunnable;
import kotlin.jvm.internal.Intrinsics;

public final class VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$2 implements VungleThreadPoolExecutor.ComparableRunnable {
    final /* synthetic */ Runnable $command;
    final /* synthetic */ Runnable $fail;

    VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$2(Runnable runnable, Runnable runnable2) {
        this.$command = runnable;
        this.$fail = runnable2;
    }

    public int compareTo(Object obj) {
        Intrinsics.f(obj, "other");
        Runnable runnable = this.$command;
        if (runnable instanceof PriorityRunnable) {
            return ((PriorityRunnable) runnable).compareTo(obj);
        }
        return 0;
    }

    public void run() {
        VungleThreadPoolExecutor.Companion.wrapRunnableWithFail(this.$command, this.$fail);
    }
}
