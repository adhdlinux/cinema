package com.vungle.ads.internal.executor;

import com.vungle.ads.internal.task.PriorityRunnable;
import kotlin.jvm.internal.Intrinsics;

public final class VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$1 extends PriorityRunnable {
    final /* synthetic */ Runnable $command;
    final /* synthetic */ Runnable $fail;

    VungleThreadPoolExecutor$Companion$getWrappedRunnableWithFail$1(Runnable runnable, Runnable runnable2) {
        this.$command = runnable;
        this.$fail = runnable2;
    }

    public int compareTo(Object obj) {
        Intrinsics.f(obj, "other");
        if (!(obj instanceof PriorityRunnable)) {
            return 0;
        }
        return Intrinsics.h(((PriorityRunnable) obj).getPriority(), getPriority());
    }

    public int getPriority() {
        return ((PriorityRunnable) this.$command).getPriority();
    }

    public void run() {
        VungleThreadPoolExecutor.Companion.wrapRunnableWithFail(this.$command, this.$fail);
    }
}
