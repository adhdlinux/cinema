package com.vungle.ads.internal.task;

import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import kotlin.jvm.internal.Intrinsics;

public abstract class PriorityRunnable implements VungleThreadPoolExecutor.ComparableRunnable {
    public int compareTo(Object obj) {
        Intrinsics.f(obj, "other");
        if (!(obj instanceof PriorityRunnable)) {
            return -1;
        }
        return Intrinsics.h(((PriorityRunnable) obj).getPriority(), getPriority());
    }

    public abstract int getPriority();
}
