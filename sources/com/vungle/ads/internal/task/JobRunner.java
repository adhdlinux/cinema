package com.vungle.ads.internal.task;

public interface JobRunner {
    void cancelPendingJob(String str);

    void execute(JobInfo jobInfo);
}
