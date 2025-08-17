package com.vungle.ads.internal.task;

import kotlin.jvm.internal.Intrinsics;

public final class JobRunnerThreadPriorityHelper implements ThreadPriorityHelper {
    public int makeAndroidThreadPriority(JobInfo jobInfo) {
        Intrinsics.f(jobInfo, "jobInfo");
        return Math.min(19, Math.abs(Math.min(0, jobInfo.getPriority() - 2)) + 10);
    }
}
