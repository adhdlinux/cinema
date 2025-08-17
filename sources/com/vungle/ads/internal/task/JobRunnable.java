package com.vungle.ads.internal.task;

import android.os.Bundle;
import android.os.Process;
import com.vungle.ads.internal.util.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class JobRunnable extends PriorityRunnable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = JobRunnable.class.getSimpleName();
    private final JobCreator creator;
    private final JobRunner jobRunner;
    private final JobInfo jobinfo;
    private final ThreadPriorityHelper threadPriorityHelper;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public JobRunnable(JobInfo jobInfo, JobCreator jobCreator, JobRunner jobRunner2, ThreadPriorityHelper threadPriorityHelper2) {
        Intrinsics.f(jobInfo, "jobinfo");
        Intrinsics.f(jobCreator, "creator");
        Intrinsics.f(jobRunner2, "jobRunner");
        this.jobinfo = jobInfo;
        this.creator = jobCreator;
        this.jobRunner = jobRunner2;
        this.threadPriorityHelper = threadPriorityHelper2;
    }

    public static /* synthetic */ void getPriority$annotations() {
    }

    public int getPriority() {
        return this.jobinfo.getPriority();
    }

    public void run() {
        ThreadPriorityHelper threadPriorityHelper2 = this.threadPriorityHelper;
        if (threadPriorityHelper2 != null) {
            try {
                int makeAndroidThreadPriority = threadPriorityHelper2.makeAndroidThreadPriority(this.jobinfo);
                Process.setThreadPriority(makeAndroidThreadPriority);
                Logger.Companion companion = Logger.Companion;
                String str = TAG;
                Intrinsics.e(str, "TAG");
                companion.d(str, "Setting process thread prio = " + makeAndroidThreadPriority + " for " + this.jobinfo.getJobTag());
            } catch (Throwable unused) {
                Logger.Companion companion2 = Logger.Companion;
                String str2 = TAG;
                Intrinsics.e(str2, "TAG");
                companion2.e(str2, "Error on setting process thread priority");
            }
        }
        try {
            String jobTag = this.jobinfo.getJobTag();
            Bundle extras = this.jobinfo.getExtras();
            Logger.Companion companion3 = Logger.Companion;
            String str3 = TAG;
            Intrinsics.e(str3, "TAG");
            companion3.d(str3, "Start job " + jobTag + "Thread " + Thread.currentThread().getName());
            int onRunJob = this.creator.create(jobTag).onRunJob(extras, this.jobRunner);
            Intrinsics.e(str3, "TAG");
            companion3.d(str3, "On job finished " + jobTag + " with result " + onRunJob);
            if (onRunJob == 2) {
                long makeNextRescedule = this.jobinfo.makeNextRescedule();
                if (makeNextRescedule > 0) {
                    this.jobinfo.setDelay(makeNextRescedule);
                    this.jobRunner.execute(this.jobinfo);
                    Intrinsics.e(str3, "TAG");
                    companion3.d(str3, "Rescheduling " + jobTag + " in " + makeNextRescedule);
                }
            }
        } catch (Exception e2) {
            Logger.Companion companion4 = Logger.Companion;
            String str4 = TAG;
            Intrinsics.e(str4, "TAG");
            companion4.e(str4, "Cannot create job" + e2.getLocalizedMessage());
        }
    }
}
